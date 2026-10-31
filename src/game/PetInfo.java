package game;

import javax.microedition.lcdui.Image;

/**
 * Du lieu mot con pet cua nguoi choi.
 * 5 chi so theo dung thu tu cua game:
 * 0 = Sinh luc (HP), 1 = Suc manh (dame), 2 = Phong thu, 3 = May man, 4 = Dong doi.
 *
 * Anh pet la 1 spritesheet doc: chieu cao / frames = chieu cao 1 frame.
 */
public final class PetInfo {
    public int id;
    public String name = "";
    public int level = 1;
    public int color = 0x808080;
    public int[] stats = new int[5];
    /** So frame trong spritesheet (>= 1). */
    public int frames = 1;
    /** Toan bo spritesheet nhan tu server. */
    public Image sheet = null;
    /** Spritesheet ban lon (danh cho man hinh Pet). */
    public Image bigSheet = null;
    private Image[] frameCache = null;
    private Image[] bigCache = null;

    public PetInfo() {
    }

    public PetInfo(int id, String name, int level, int color) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.color = color;
    }

    public final int stat(int index) {
        if (index < 0 || index >= this.stats.length) {
            return 0;
        }
        return this.stats[index];
    }

    public final int frameCount() {
        return this.frames < 1 ? 1 : this.frames;
    }

    /** Anh cua 1 frame (tu cat spritesheet), null neu khong co anh. */
    public final Image frame(int index) {
        if (this.sheet == null) {
            return null;
        }
        int n = this.frameCount();
        int n2 = index % n;
        if (n2 < 0) {
            n2 = 0;
        }
        if (this.frameCache == null) {
            this.frameCache = new Image[n];
        }
        if (this.frameCache[n2] != null) {
            return this.frameCache[n2];
        }
        Image image;
        try {
            if (n <= 1) {
                image = this.sheet;
            } else {
                int n3 = this.sheet.getWidth();
                int n4 = this.sheet.getHeight() / n;
                if (n4 <= 0) {
                    image = this.sheet;
                } else {
                    image = Image.createImage(this.sheet, 0, n2 * n4, n3, n4, 0);
                }
            }
        } catch (Throwable throwable) {
            image = this.sheet;
        }
        this.frameCache[n2] = image;
        return image;
    }

    /** Frame ban lon (man hinh Pet), fallback ve frame nho. */
    public final Image bigFrame(int index) {
        if (this.bigSheet == null) {
            return this.frame(index);
        }
        int n = this.frameCount();
        int n2 = index % n;
        if (n2 < 0) {
            n2 = 0;
        }
        if (this.bigCache == null) {
            this.bigCache = new Image[n];
        }
        if (this.bigCache[n2] != null) {
            return this.bigCache[n2];
        }
        Image image;
        try {
            if (n <= 1) {
                image = this.bigSheet;
            } else {
                int n3 = this.bigSheet.getWidth();
                int n4 = this.bigSheet.getHeight() / n;
                image = n4 <= 0 ? this.bigSheet : Image.createImage(this.bigSheet, 0, n2 * n4, n3, n4, 0);
            }
        } catch (Throwable throwable) {
            image = this.bigSheet;
        }
        this.bigCache[n2] = image;
        return image;
    }

    /** Frame lon dang chay theo thoi gian. */
    public final Image animatedBigFrame() {
        int n = this.frameCount();
        if (n <= 1) {
            return this.bigFrame(0);
        }
        return this.bigFrame((int) (System.currentTimeMillis() / 160L % (long) n));
    }

    /** Frame dang chay theo thoi gian (animation). */
    public final Image animatedFrame() {
        int n = this.frameCount();
        if (n <= 1) {
            return this.frame(0);
        }
        int n2 = (int) (System.currentTimeMillis() / 160L % (long) n);
        return this.frame(n2);
    }

    public final Image icon() {
        return this.frame(0);
    }
}
