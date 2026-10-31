package game;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureData;
import java.io.DataInputStream;
import java.util.Hashtable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 * VIP phia client: nhan bang huy hieu (anh) + danh sach vip cua nguoi choi,
 * ve huy hieu ngay sau ten.
 *
 * <p>Moc nap (server tinh tu `users.total_supported`):</p>
 * 100 - 200 - 500 - 1000 - 1500 - 2000 - 2500 - 3000 - 3500 - 4000 - 4500 - 5000
 * tuong ung vip 1..12.
 */
public final class VipManager {

    public static final byte CMD_VIP_INFO = -109;
    public static final int MAX_VIP = 12;

    private static final Hashtable levels = new Hashtable();
    private static final Image[] badges = new Image[MAX_VIP + 1];
    private static boolean hasData = false;
    private static long lastRequestAt = 0L;

    private VipManager() {
    }

    /** Xin danh sach vip (throttle 2s, tu xin lai den khi co du lieu). */
    public static void request() {
        if (hasData) {
            return;
        }
        long now = System.currentTimeMillis();
        if (now - lastRequestAt < 2000L) {
            return;
        }
        try {
            ConnectionWatchdog.game_ConnectionWatchdog_a().sendVipRequest();
            lastRequestAt = now;
            System.out.println("[vip] gui VIP_INFO");
        } catch (Throwable throwable) {
            lastRequestAt = now;
        }
    }

    public static void reset() {
        hasData = false;
        lastRequestAt = 0L;
    }

    /** Nhan goi tin VIP_INFO tu server. */
    public static void handleVipInfo(Message message) {
        try {
            DataInputStream dataInputStream = message.java_io_DataInputStream_a();
            int n = dataInputStream.readByte() & 0xFF;
            int n7 = 0;
            for (int i = 0; i < n; ++i) {
                int n2 = dataInputStream.readByte() & 0xFF;
                int n3 = dataInputStream.readShort();
                if (n3 <= 0 || n3 > 50000 || n2 < 1 || n2 > MAX_VIP) {
                    break;
                }
                byte[] byArray = new byte[n3];
                dataInputStream.readFully(byArray);
                try {
                    badges[n2] = trimTransparent(Image.createImage(byArray, 0, n3));
                    if (badges[n2] != null) {
                        n7++;
                    }
                } catch (Throwable throwable) {
                    badges[n2] = null;
                    System.out.println("[vip] hong anh vip " + n2 + ": " + throwable);
                }
            }
            levels.clear();
            int n4 = dataInputStream.readShort();
            for (int i = 0; i < n4; ++i) {
                int n5 = dataInputStream.readInt();
                int n6 = dataInputStream.readByte();
                if (n5 > 0 && n6 > 0) {
                    levels.put(new Integer(n5), new Integer(n6));
                }
            }
            hasData = true;
            System.out.println("[vip] nhan VIP_INFO: " + n4 + " nguoi co vip, " + n7 + " anh huy hieu");
        } catch (Throwable throwable) {
            System.out.println("[vip] loi parse VIP_INFO: " + throwable);
        }
    }

    public static int levelOf(int userId) {
        if (userId <= 0) {
            return 0;
        }
        Object object = levels.get(new Integer(userId));
        return object == null ? 0 : ((Integer) object).intValue();
    }

    public static Image badge(int level) {
        if (level < 1 || level > MAX_VIP) {
            return null;
        }
        return badges[level];
    }

    /**
     * Cat vien trong suot cua anh huy hieu (server gui khung lon hon icon).
     * Cat duoc thi ve sat ten; khong cat duoc (khong doc duoc pixel) thi tra anh goc.
     */
    private static Image trimTransparent(Image image) {
        if (image == null) {
            return null;
        }
        Pixmap pixmap = null;
        boolean ownPixmap = false;
        try {
            if (image.cachedPixmap != null && !image.cachedPixmap.isDisposed()) {
                pixmap = image.cachedPixmap;
            } else if (image.texture != null) {
                TextureData textureData = image.texture.getTextureData();
                if (textureData != null && !textureData.isPrepared()
                        && textureData.getType() == TextureData.TextureDataType.Pixmap) {
                    textureData.prepare();
                }
                if (textureData != null && textureData.getType() == TextureData.TextureDataType.Pixmap) {
                    pixmap = textureData.consumePixmap();
                    ownPixmap = true;
                }
            }
            if (pixmap == null) {
                return image;
            }
            int w = pixmap.getWidth();
            int h = pixmap.getHeight();
            int minX = w;
            int minY = h;
            int maxX = -1;
            int maxY = -1;
            for (int y = 0; y < h; ++y) {
                for (int x = 0; x < w; ++x) {
                    int pixel = pixmap.getPixel(x, y);
                    if ((pixel & 0xFF) <= 16) {
                        continue;
                    }
                    if (x < minX) minX = x;
                    if (x > maxX) maxX = x;
                    if (y < minY) minY = y;
                    if (y > maxY) maxY = y;
                }
            }
            if (ownPixmap) {
                pixmap.dispose();
                ownPixmap = false;
            }
            if (maxX < minX || maxY < minY) {
                return image;
            }
            int cw = maxX - minX + 1;
            int ch = maxY - minY + 1;
            if (minX == 0 && minY == 0 && cw == w && ch == h) {
                return image;
            }
            Image cropped = Image.createImage(image, minX, minY, cw, ch, 0);
            return cropped != null ? cropped : image;
        } catch (Throwable throwable) {
            System.out.println("[vip] khong cat duoc vien anh: " + throwable);
            return image;
        } finally {
            if (ownPixmap && pixmap != null) {
                pixmap.dispose();
            }
        }
    }

    /**
     * Ve huy hieu vip sat ngay sau ten. Ten ve bang FontRenderer.a(g, ten, x, y, 2):
     * x = tam ngang, y = dinh chu, anchor 2 = canh giua.
     */
    public static void drawAfterName(Graphics graphics, FontRenderer fontRenderer, String string,
                                     int userId, int xCenter, int yTop) {
        int n = levelOf(userId);
        if (n <= 0) {
            return;
        }
        Image image = badge(n);
        if (image == null) {
            return;
        }
        String name = string == null ? "" : string;
        int sumW = 0;
        int spacing = 0;
        int n3 = 13;
        try {
            sumW = fontRenderer.a(name);
            int len = name.length();
            if (len > 1) {
                spacing = (fontRenderer.b(name) - sumW) / (len - 1);
            }
            if (fontRenderer.a() > 0) {
                n3 = fontRenderer.a();
            }
        } catch (Throwable throwable) {
            sumW = 0;
            spacing = 0;
        }
        // FontRenderer.a(g, ten, x, y, 2) canh giua theo a(ten) (khong tinh khoang cach ky tu),
        // nen mep phai that = left + sumW + (len - 1) * spacing.
        // Bo qua khoang trang cuoi ten: ten do server gui co the dem space, se lam huy hieu xa ra.
        int len = name.length();
        int visLen = len;
        while (visLen > 0 && name.charAt(visLen - 1) <= ' ') {
            --visLen;
        }
        int sumVis = sumW;
        if (visLen != len) {
            try {
                sumVis = fontRenderer.a(name.substring(0, visLen));
            } catch (Throwable throwable) {
                sumVis = sumW;
            }
        }
        int left = xCenter - (sumW >> 1);
        int right = left + sumVis + (visLen > 1 ? (visLen - 1) * spacing : 0);
        int n4 = right + 1;
        int n5 = yTop + (n3 - image.getHeight()) / 2;
        graphics.drawImage(image, n4, n5, 20);
    }
}
