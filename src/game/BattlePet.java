package game;

import game.BattleManager;
import game.BattleScreen;
import game.FontRenderer;
import game.PetInfo;
import game.PetManager;
import game.PlayerEntity;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 * Pet hien thi trong battle:
 * - dung ben trai nhan vat, chech len khoang 30px.
 * - sau khi nguoi choi ban ~0.5s thi lao sang dich va tan cong roi quay ve.
 * Chi la hieu ung phia client (khong lam thay doi HP that trong server).
 */
public final class BattlePet {

    private static final long DELAY_MS = 600L;

    private static final int FLY_TICKS = 26;
    private static final int STAGGER = 3;
    private static final int HIT_TICKS = 26;
    private static final int BACK_TICKS = 20;

    private static final int STATE_IDLE = 0;
    private static final int STATE_FLY = 1;
    private static final int STATE_HIT = 2;
    private static final int STATE_BACK = 3;

    /** vi tri dung yen tuong doi so voi nhan vat */
    private static final int[] IDLE_DX = {-22, -32, -32};
    private static final int[] IDLE_DY = {-30, -22, -38};

    /** vi tri tan cong tuong doi so voi dich */
    private static final int[] HIT_DX = {-12, 12, 0};
    private static final int[] HIT_DY = {-16, -12, -22};

    private static final int[] posX = new int[PetManager.SLOT_COUNT];
    private static final int[] posY = new int[PetManager.SLOT_COUNT];
    /** huong mat tung pet: 0 = phai, 2 = trai (mirror) */
    private static final int[] posFlip = new int[PetManager.SLOT_COUNT];

    private static int state = STATE_IDLE;
    private static long attackAt = 0L;
    private static int tick = 0;
    /** dem tick cua battle de in nhat ky chan doan */
    public static int heartbeat = 0;

    public static String debugState() {
        int n = 0;
        try {
            n = PetManager.equippedCount();
        } catch (Throwable ignored) {
        }
        return "state=" + state + " tick=" + tick + " target=" + targetIndex + " pets=" + n;
    }
    private static int targetIndex = -1;
    /** muc tieu vua bi ban trung, pet se lao vao dich nay */
    private static int pendingTarget = -1;
    private static long lastScheduleAt = 0L;
    private static String hitText = "";

    private BattlePet() {
    }

    public static void reset() {
        state = STATE_IDLE;
        attackAt = 0L;
        tick = 0;
        targetIndex = -1;
        pendingTarget = -1;
        lastScheduleAt = 0L;
        hitText = "";
    }

    /** Pet con dang bay/danh hoac da hen danh hay khong. */
    public static boolean isBusy() {
        return state != STATE_IDLE || attackAt != 0L;
    }

    /**
     * Chan lai cho pet danh xong (dung truoc khi chuyen luot).
     * Chi cho khi dang o man hinh battle, toi da {@code timeoutMs}.
     */
    public static void waitUntilDone(long timeoutMs) {
        // khong dung: chan thread se lam treo game, xem BattleManager.a(byte) + applyDeferred()
    }

    /** Watchdog: neu game loop dung qua lau thi in stack tat ca thread de tim cho treo. */
    public static void startWatchdog() {
        if (watchdogStarted) {
            return;
        }
        watchdogStarted = true;
        Thread thread = new Thread(new Runnable() {
            public void run() {
                int n = -1;
                while (true) {
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException interruptedException) {
                        return;
                    }
                    int n2 = heartbeat;
                    if (n2 == n) {
                        System.out.println("[pet] === GAME LOOP DUNG: heartbeat=" + n2 + " ===");
                        java.util.Map map = Thread.getAllStackTraces();
                        java.util.Iterator iterator = map.entrySet().iterator();
                        while (iterator.hasNext()) {
                            java.util.Map.Entry entry = (java.util.Map.Entry) iterator.next();
                            Thread thread2 = (Thread) entry.getKey();
                            StackTraceElement[] stackTraceElementArray = (StackTraceElement[]) entry.getValue();
                            System.out.println("[pet] thread " + thread2.getName());
                            for (int i = 0; i < stackTraceElementArray.length; ++i) {
                                System.out.println("[pet]    at " + stackTraceElementArray[i]);
                            }
                        }
                    }
                    n = n2;
                }
            }
        }, "pet-watchdog");
        thread.setDaemon(true);
        thread.start();
    }

    private static boolean watchdogStarted = false;

    /** Goi khi don cua nguoi choi (local) danh trung dich. */
    public static void onHitLanded(int n) {
        if (state != STATE_IDLE || attackAt != 0L) {
            return;
        }
        // pet danh cung lam mau dich tut -> bo qua cac lan tut mau trong 4s de khong lap vo han
        if (System.currentTimeMillis() - lastScheduleAt < 4000L) {
            return;
        }
        try {
            if (PetManager.equippedCount() <= 0) {
                return;
            }
        } catch (Throwable throwable) {
            return;
        }
        pendingTarget = n;
        lastScheduleAt = System.currentTimeMillis();
        attackAt = lastScheduleAt + DELAY_MS;
        System.out.println("[pet] trung dich index=" + n + " -> hen tan cong sau " + DELAY_MS + "ms");
    }

    public static void update() {
        if (state == STATE_IDLE) {
            if (attackAt == 0L || System.currentTimeMillis() < attackAt) {
                return;
            }
            attackAt = 0L;
            if (pickTarget()) {
                state = STATE_FLY;
                tick = 0;
                System.out.println("[pet] lao toi dich index=" + targetIndex);
            } else {
                System.out.println("[pet] khong tim thay dich de danh");
            }
            return;
        }
        ++tick;
        if (state == STATE_FLY) {
            if (tick >= FLY_TICKS + (PetManager.equippedCount() - 1) * STAGGER) {
                state = STATE_HIT;
                tick = 0;
                doHit();
                System.out.println("[pet] danh trung dich index=" + targetIndex + " dame=" + hitText);
            }
            return;
        }
        if (state == STATE_HIT) {
            if (tick >= HIT_TICKS) {
                state = STATE_BACK;
                tick = 0;
            }
            return;
        }
        if (state == STATE_BACK && tick >= BACK_TICKS) {
            state = STATE_IDLE;
            tick = 0;
            targetIndex = -1;
            System.out.println("[pet] ve cho");
        }
    }

    private static PlayerEntity me() {
        PlayerEntity[] arr = BattleManager.var_game_PlayerEntity_arr_a;
        if (arr == null) {
            return null;
        }
        int n = BattleScreen.var_byte_b;
        if (n < 0 || n >= arr.length) {
            return null;
        }
        return arr[n];
    }

    private static PlayerEntity entityAt(int n) {
        PlayerEntity[] arr = BattleManager.var_game_PlayerEntity_arr_a;
        if (arr == null || n < 0 || n >= arr.length) {
            return null;
        }
        return arr[n];
    }

    private static boolean pickTarget() {
        PlayerEntity[] arr = BattleManager.var_game_PlayerEntity_arr_a;
        PlayerEntity playerEntity = me();
        if (arr == null || playerEntity == null) {
            return false;
        }
        // uu tien dung muc tieu vua bi ban trung
        int n8 = pendingTarget;
        pendingTarget = -1;
        if (n8 >= 0 && n8 < arr.length && n8 != BattleScreen.var_byte_b) {
            PlayerEntity playerEntity3 = arr[n8];
            if (playerEntity3 != null && playerEntity3.var_byte_f != 5 && playerEntity3.var_int_w > 0) {
                targetIndex = n8;
                return true;
            }
        }
        int n = -1;
        int n2 = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            PlayerEntity playerEntity2 = arr[i];
            if (playerEntity2 == null || i == BattleScreen.var_byte_b) {
                continue;
            }
            if (playerEntity2.var_byte_f == 5 || playerEntity2.var_int_w <= 0) {
                continue;
            }
            if (playerEntity2.var_boolean_b == playerEntity.var_boolean_b) {
                continue;
            }
            int n3 = playerEntity2.var_int_g - playerEntity.var_int_g;
            int n4 = playerEntity2.var_int_h - playerEntity.var_int_h;
            int n5 = n3 * n3 + n4 * n4;
            if (n5 >= n2) {
                continue;
            }
            n2 = n5;
            n = i;
        }
        if (n < 0) {
            // khong co doi thu khac doi (map train, bot cung doi) -> danh bat ky ai con song
            n2 = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; ++i) {
                PlayerEntity playerEntity2 = arr[i];
                if (playerEntity2 == null || i == BattleScreen.var_byte_b) {
                    continue;
                }
                if (playerEntity2.var_byte_f == 5 || playerEntity2.var_int_w <= 0) {
                    continue;
                }
                int n3 = playerEntity2.var_int_g - playerEntity.var_int_g;
                int n4 = playerEntity2.var_int_h - playerEntity.var_int_h;
                int n5 = n3 * n3 + n4 * n4;
                if (n5 >= n2) {
                    continue;
                }
                n2 = n5;
                n = i;
            }
        }
        targetIndex = n;
        return n >= 0;
    }

    private static void doHit() {
        hitText = "-" + damage();
    }

    private static int damage() {
        try {
            int[] nArray = PetManager.totalStats();
            int n = nArray[1];
            return n > 0 ? n : 1;
        } catch (Throwable throwable) {
            return 1;
        }
    }

    private static void computePositions(PlayerEntity playerEntity, PlayerEntity playerEntity2) {
        boolean facingLeft = playerEntity.var_int_t == 0;
        long now = System.currentTimeMillis();
        for (int i = 0; i < PetManager.SLOT_COUNT; ++i) {
            int n = i < IDLE_DX.length ? IDLE_DX[i] : -22;
            int n2 = i < IDLE_DY.length ? IDLE_DY[i] : -30;
            if (facingLeft) {
                // doi huong: pet sang ben kia nhan vat cho doi xung
                n = -n;
            }
            int n3 = playerEntity.var_int_g + n;
            int n4 = playerEntity.var_int_h + n2;
            if (state == STATE_IDLE) {
                // bay luon quanh nguoi choi: nhun len xuong + dao nhe trai phai
                int n8 = (int) (now / 220L % 4L);
                if (n8 > 2) {
                    n8 = 4 - n8;
                }
                n4 -= n8;
                n3 += (int) (Math.sin((double) (now + i * 900L) / 420.0) * (facingLeft ? -5.0 : 5.0));
                n4 -= (int) (Math.cos((double) (now + i * 900L) / 520.0) * 2.0);
            }
            if (playerEntity2 != null && state != STATE_IDLE) {
                int n5 = playerEntity2.var_int_g + (i < HIT_DX.length ? HIT_DX[i] : 0);
                int n6 = playerEntity2.var_int_h + (i < HIT_DY.length ? HIT_DY[i] : -16);
                if (state == STATE_FLY) {
                    int n7 = tick - i * STAGGER;
                    if (n7 < 0) {
                        n7 = 0;
                    }
                    if (n7 > FLY_TICKS) {
                        n7 = FLY_TICKS;
                    }
                    n3 += (n5 - n3) * n7 / FLY_TICKS;
                    n4 += (n6 - n4) * n7 / FLY_TICKS;
                } else if (state == STATE_HIT) {
                    n3 = n5;
                    n4 = n6;
                } else if (state == STATE_BACK) {
                    int n7 = tick > BACK_TICKS ? BACK_TICKS : tick;
                    n3 = n5 + (n3 - n5) * n7 / BACK_TICKS;
                    n4 = n6 + (n4 - n6) * n7 / BACK_TICKS;
                }
            }
            posX[i] = n3;
            posY[i] = n4;
            // huong mat: bay toi thi huong ve phia truoc, bay ve thi huong ve nguoi choi
            int n8;
            if (state == STATE_BACK) {
                n8 = posX[i] >= playerEntity.var_int_g ? 2 : 0;
            } else if (state == STATE_IDLE) {
                n8 = facingLeft ? 2 : 0;
            } else if (state == STATE_HIT) {
                // dang danh: huong ra phia dich (nguoc huong nguoi choi)
                n8 = playerEntity.var_int_g <= (playerEntity2 == null ? playerEntity.var_int_g
                        : playerEntity2.var_int_g) ? 0 : 2;
            } else {
                n8 = posX[i] >= (playerEntity2 == null ? playerEntity.var_int_g : playerEntity2.var_int_g) ? 2 : 0;
            }
            posFlip[i] = n8;
        }
    }

    public static void draw(Graphics graphics) {
        PlayerEntity playerEntity;
        try {
            if (PetManager.equippedCount() <= 0) {
                return;
            }
            playerEntity = me();
        } catch (Throwable throwable) {
            return;
        }
        if (playerEntity == null || playerEntity.var_byte_f == 5) {
            return;
        }
        PlayerEntity playerEntity2 = entityAt(targetIndex);
        if (state != STATE_IDLE && playerEntity2 == null) {
            reset();
            playerEntity2 = null;
        }
        computePositions(playerEntity, playerEntity2);
        for (int i = 0; i < PetManager.SLOT_COUNT; ++i) {
            PetInfo petInfo = PetManager.slotPet(i);
            if (petInfo == null) {
                continue;
            }
            drawPet(graphics, petInfo, posX[i], posY[i], posFlip[i]);
        }
        if (state == STATE_HIT && playerEntity2 != null) {
            drawHit(graphics, playerEntity2);
        }
    }

    private static void drawPet(Graphics graphics, PetInfo petInfo, int n, int n2, int flip) {
        Image image = petInfo.animatedBigFrame();
        if (image != null) {
            // anchor 33 = HCENTER | BOTTOM: chan pet nam tai n2, flip: 0 = phai, 2 = trai
            DataUtils.a(graphics, image, 0, 0, image.getWidth(), image.getHeight(), flip, n, n2, 33);
            return;
        }
        graphics.setColor(petInfo.color);
        graphics.fillRoundRect(n - 8, n2 - 12, 16, 12, 5, 5);
        graphics.fillRoundRect(n - 6, n2 - 22, 12, 12, 5, 5);
        graphics.setColor(0xFFFFFF);
        graphics.fillRect(n - 4, n2 - 19, 3, 3);
        graphics.fillRect(n + 2, n2 - 19, 3, 3);
        graphics.setColor(0x000000);
        graphics.fillRect(n - 3, n2 - 15, 6, 1);
        graphics.fillRect(n - 10, n2 - 10, 3, 3);
    }

    private static void drawHit(Graphics graphics, PlayerEntity playerEntity) {
        int n = playerEntity.var_int_g;
        int n2 = playerEntity.var_int_h - 16;
        int n3 = 7 + tick;
        graphics.setColor(0xFFFFFF);
        graphics.fillRect(n - n3, n2 - 1 + tick / 2, n3 * 2, 2);
        graphics.fillRect(n - n3 / 2, n2 - n3 / 2, 2, n3);
        graphics.setColor(0xFFFF66);
        graphics.fillRect(n - 2, n2 - 2, 4, 4);
        if (tick > 2 && hitText.length() > 0) {
            FontRenderer.e.a(graphics, hitText, n, n2 - 8 - tick, 2);
        }
    }
}
