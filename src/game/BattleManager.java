/*
 * Decompiled with CFR 0.152.
 */
package game;

import game.BattleScreen;
import game.BoardScreen;
import game.CharacterSelectScreen;
import game.ConnectionWatchdog;
import game.PlayerAccountInfo;
import game.PlayerEntity;
import game.PopupDialog;
import game.TerrainMidlet;

public final class BattleManager {
    public static int var_int_a;
    public static int var_int_b;
    public static PlayerEntity[] var_game_PlayerEntity_arr_a;
    public static int[] var_int_arr_a;
    public static byte var_byte_a;
    public static short[] var_short_arr_a;
    public static short[] var_short_arr_b;
    public static int c;
    public static int d;
    private int lIl1lI1l1I;
    private int lIlIl11lll1;

    public final void a(short[] sArray, short[] sArray2, int[] nArray) {
        int n;
        this.lIl1lI1l1I = 0;
        this.lIlIl11lll1 = 0;
        int n2 = 8;
        if (BoardScreen.var_byte_b == 7) {
            n2 = var_int_b;
        }
        for (n = 0; n < n2; ++n) {
            BattleManager.var_game_PlayerEntity_arr_a[n] = null;
            if (sArray[n] != -1) {
                boolean bl;
                PlayerAccountInfo playerAccountInfo = (PlayerAccountInfo)BoardScreen.var_game_BoardScreen_a.var_java_util_Vector_a.elementAt(n);
                System.out.println("[cp] IDDB= " + playerAccountInfo.var_int_a + " my IDDB= " + TerrainMidlet.myInfo.var_int_a + " i=" + n);
                boolean bl2 = bl = TerrainMidlet.myInfo.var_int_a != playerAccountInfo.var_int_a;
                if (!playerAccountInfo.var_boolean_a) {
                    BattleManager.var_game_PlayerEntity_arr_a[n] = new PlayerEntity(playerAccountInfo.var_int_a, (byte)n, sArray[n], sArray2[n], bl, n % 2 != 0 ? 0 : 2, playerAccountInfo.var_byte_a, playerAccountInfo.var_game_EquipSlotSet_a, nArray[n]);
                    BattleManager.var_game_PlayerEntity_arr_a[n].var_javax_microedition_lcdui_Image_b = playerAccountInfo.var_javax_microedition_lcdui_Image_a;
                } else {
                    BattleManager.var_game_PlayerEntity_arr_a[n] = new PopupDialog(playerAccountInfo.var_int_a, (byte)n, sArray[n], sArray2[n], bl, n % 2 != 0 ? 0 : 2, playerAccountInfo.var_byte_a, nArray[n]);
                }
                BattleManager.var_game_PlayerEntity_arr_a[n].var_java_lang_String_a = playerAccountInfo.var_java_lang_String_a;
                BattleManager.var_game_PlayerEntity_arr_a[n].var_int_vipUserId = playerAccountInfo.var_int_a;
                BattleManager.var_game_PlayerEntity_arr_a[n].M = playerAccountInfo.g;
                if (!bl) {
                    BattleManager.var_game_PlayerEntity_arr_a[n].var_int_arr_a = BoardScreen.var_game_BoardScreen_a.int_arr_b();
                    BattleScreen.var_byte_b = (byte)n;
                }
            }
            ++this.lIl1lI1l1I;
        }
        System.out.println("[cp] PLAYER COUNT= " + this.lIl1lI1l1I);
        this.lIlIl11lll1 = this.lIl1lI1l1I;
        n = 0;
        while (n < n2) {
            BattleManager.var_int_arr_a[n] = n++;
        }
    }

    public static String java_lang_String_a(int n) {
        for (int i = 0; i < var_game_PlayerEntity_arr_a.length; ++i) {
            if (BattleManager.var_game_PlayerEntity_arr_a[i].var_int_o != n) continue;
            return BattleManager.var_game_PlayerEntity_arr_a[i].var_java_lang_String_a;
        }
        return "";
    }

    public final void a(short[] sArray, short[] sArray2) {
        int n;
        System.out.println("[cp] BOSS NUMBER SEND= " + sArray.length);
        System.out.println("[cp] ALL COUNT = " + this.lIlIl11lll1);
        for (n = 0; n < sArray.length; ++n) {
            BattleManager.var_game_PlayerEntity_arr_a[n + this.lIlIl11lll1] = null;
            if (sArray[n] == -1) continue;
            PlayerAccountInfo playerAccountInfo = (PlayerAccountInfo)BoardScreen.var_game_BoardScreen_a.var_java_util_Vector_b.elementAt(n);
            boolean bl = TerrainMidlet.myInfo.var_int_a != playerAccountInfo.var_int_a;
            PopupDialog popupDialog = new PopupDialog(playerAccountInfo.var_int_a, (byte)1, sArray[n], sArray2[n], bl, 2, playerAccountInfo.var_byte_a, playerAccountInfo.h);
            popupDialog.var_java_lang_String_a = playerAccountInfo.var_java_lang_String_a;
            popupDialog.var_int_w = playerAccountInfo.h;
            popupDialog.var_int_x = playerAccountInfo.h;
            popupDialog.var_byte_b = playerAccountInfo.var_byte_b;
            popupDialog.var_boolean_a = playerAccountInfo.var_boolean_c;
            popupDialog.var_byte_a = playerAccountInfo.var_byte_c;
            popupDialog.c = playerAccountInfo.j;
            BattleManager.var_game_PlayerEntity_arr_a[n + this.lIlIl11lll1] = popupDialog;
            System.out.println("[ca] Name:" + playerAccountInfo.var_java_lang_String_a + " HP=" + playerAccountInfo.h + " X= " + sArray[n] + " Y= " + sArray2[n] + " size: " + var_game_PlayerEntity_arr_a.length);
        }
        this.lIlIl11lll1 += BoardScreen.var_game_BoardScreen_a.var_java_util_Vector_b.size();
        BoardScreen.var_game_BoardScreen_a.var_java_util_Vector_b.removeAllElements();
        for (n = 0; n < var_game_PlayerEntity_arr_a.length; ++n) {
            if (var_game_PlayerEntity_arr_a[n] == null) continue;
            System.out.println("[cp] i player= " + n);
        }
    }

    public static void void_a() {
        for (int i = 0; i < var_game_PlayerEntity_arr_a.length; ++i) {
            if (var_game_PlayerEntity_arr_a[i] != null) {
                BattleManager.var_short_arr_a[i] = (short)BattleManager.var_game_PlayerEntity_arr_a[i].var_int_g;
                BattleManager.var_short_arr_b[i] = (short)BattleManager.var_game_PlayerEntity_arr_a[i].var_int_h;
                continue;
            }
            BattleManager.var_short_arr_a[i] = -1;
            BattleManager.var_short_arr_b[i] = -1;
        }
    }

    public static PlayerEntity game_PlayerEntity_a() {
        if (var_game_PlayerEntity_arr_a[var_byte_a] != null) {
            return var_game_PlayerEntity_arr_a[var_byte_a];
        }
        return null;
    }

    public static PlayerEntity game_PlayerEntity_a(int n) {
        for (int i = 0; i < var_game_PlayerEntity_arr_a.length; ++i) {
            if (var_game_PlayerEntity_arr_a[i] == null || BattleManager.var_game_PlayerEntity_arr_a[i].var_int_o != n) continue;
            return var_game_PlayerEntity_arr_a[i];
        }
        return null;
    }

    public static PlayerEntity b(int n) {
        for (int i = 0; i < var_game_PlayerEntity_arr_a.length; ++i) {
            if (var_game_PlayerEntity_arr_a[i] == null || BattleManager.var_game_PlayerEntity_arr_a[i].var_byte_b != n) continue;
            return var_game_PlayerEntity_arr_a[i];
        }
        return null;
    }

    public static boolean boolean_a() {
        return var_byte_a == BattleScreen.var_byte_b;
    }

    /** Luot bi hoan lai cho pet danh xong (-1 = khong co). */
    public static byte deferredNextPlayer = -1;
    private static long deferredAt = 0L;

    /** Goi moi frame sau BattlePet.update(): ap dung luot da hoan khi pet da xong. */
    public static void applyDeferredNextPlayer() {
        if (deferredNextPlayer < 0) {
            return;
        }
        if (BattlePet.isBusy()) {
            // con pet dang bay/danh/ve thi chua chuyen luot
            if (System.currentTimeMillis() - deferredAt < 15000L) {
                return;
            }
            BattlePet.reset();
        }
        byte by = deferredNextPlayer;
        deferredNextPlayer = -1;
        System.out.println("[pet] pet danh xong het -> chuyen luot " + by);
        a(by);
    }

    public static void a(byte by) {
        System.out.println("[cp] SET NEXT PLAYER " + by);
        if (BattlePet.isBusy()) {
            // pet chua danh xong: hoan luot, khong chan thread (chan thread se lam treo game)
            deferredNextPlayer = by;
            deferredAt = System.currentTimeMillis();
            System.out.println("[pet] hoan luot " + by + " cho pet danh xong het");
            return;
        }
        if (BattleScreen.var_java_lang_String_a.equals("")) {
            if (by >= 0 && by < var_game_PlayerEntity_arr_a.length && var_game_PlayerEntity_arr_a[by] != null) {
                BattleManager.var_game_PlayerEntity_arr_a[by].var_boolean_v = true;
                if (BattleManager.var_game_PlayerEntity_arr_a[by].var_byte_f != 8) {
                    BattleManager.var_game_PlayerEntity_arr_a[by].var_byte_f = 0;
                    // Mỗi lượt mới: lực 1 bắt đầu rỗng, chưa mở lực 2
                    BattleManager.var_game_PlayerEntity_arr_a[by].var_byte_d = 0;
                    BattleManager.var_game_PlayerEntity_arr_a[by].var_byte_e = 0;
                    BattleManager.var_game_PlayerEntity_arr_a[by].l111ll1l = false;
                    PlayerEntity.isPullingForce = false;
                    PlayerEntity.waitingSecondPressRelease = false;
                    PlayerEntity.keyHoldFrames = 0;
                    PlayerEntity.fireCooldown = 0;
                    var_game_PlayerEntity_arr_a[by].f();
                }
                BattleManager.var_game_PlayerEntity_arr_a[by].var_int_n = 0;
                BattleManager.var_game_PlayerEntity_arr_a[by].var_int_k = -1;
                if (BattleManager.var_game_PlayerEntity_arr_a[by].var_boolean_o) {
                    BattleManager.var_game_PlayerEntity_arr_a[by].var_boolean_o = false;
                }
                if (BattleManager.var_game_PlayerEntity_arr_a[by].var_byte_c != 15) {
                    BattleManager.var_game_PlayerEntity_arr_a[by].var_boolean_n = true;
                }
            }
            for (int i = 0; i < var_game_PlayerEntity_arr_a.length; ++i) {
                if (var_game_PlayerEntity_arr_a[i] == null) continue;
                BattleManager.var_game_PlayerEntity_arr_a[i].var_boolean_d = false;
                if (BattleManager.var_game_PlayerEntity_arr_a[i].var_byte_f != 5) {
                    BattleManager.var_game_PlayerEntity_arr_a[i].var_boolean_q = false;
                }
                CharacterSelectScreen.var_int_c = 0;
                if (i != BattleScreen.var_byte_b) continue;
                PlayerEntity playerEntity = var_game_PlayerEntity_arr_a[i];
                if (playerEntity.var_int_g != playerEntity.var_int_i) {
                    playerEntity.var_int_g = playerEntity.var_int_i;
                }
                if (playerEntity.var_int_h != playerEntity.var_int_j) {
                    playerEntity.var_int_h = playerEntity.var_int_j;
                }
                if (BattleManager.var_game_PlayerEntity_arr_a[i].var_boolean_t) continue;
                ConnectionWatchdog.game_ConnectionWatchdog_a().b((short)BattleManager.var_game_PlayerEntity_arr_a[i].var_int_g, (short)BattleManager.var_game_PlayerEntity_arr_a[i].var_int_h);
                BattleManager.var_game_PlayerEntity_arr_a[i].var_boolean_t = true;
            }
            if (BattleScreen.var_game_TurnTimer_a != null) {
                BattleScreen.var_game_TurnTimer_a.a();
            }
            var_byte_a = by;
            if (BattleScreen.var_game_GameHelper16_a != null) {
                BattleScreen.var_game_GameHelper16_a.a(by);
            }
        }
    }

    public static void a(int n, short s, short s2) {
        if (n >= 0 && n < var_game_PlayerEntity_arr_a.length && var_game_PlayerEntity_arr_a[n] != null) {
            System.out.println("[cp] LAST X= " + BattleManager.var_game_PlayerEntity_arr_a[n].var_int_g + "nexx=  " + s + " Last y= " + BattleManager.var_game_PlayerEntity_arr_a[n].var_int_h + "next y= " + s2);
            BattleManager.var_game_PlayerEntity_arr_a[n].var_int_y = s;
            BattleManager.var_game_PlayerEntity_arr_a[n].var_int_z = s2;
            BattleManager.var_game_PlayerEntity_arr_a[n].var_boolean_C = true;
            BattleManager.var_game_PlayerEntity_arr_a[n].var_int_E = 0;
            if (n == BattleScreen.var_byte_b) {
                var_game_PlayerEntity_arr_a[n].c(s, s2);
            }
        }
    }

    public static void b(int n, short s, short s2) {
        if (n >= 0 && n < var_game_PlayerEntity_arr_a.length && var_game_PlayerEntity_arr_a[n] != null) {
            var_game_PlayerEntity_arr_a[n].a((int)s, s2);
        }
    }

    public static void c(int n, short s, short s2) {
        if (n < 0 || n >= var_game_PlayerEntity_arr_a.length || var_game_PlayerEntity_arr_a[n] == null) {
            return;
        }
        // server luon nhan vi tri client gui nen echo ve phai bang vi tri hien tai; van ap dung
        BattleManager.var_game_PlayerEntity_arr_a[n].var_int_g = s;
        BattleManager.var_game_PlayerEntity_arr_a[n].var_int_h = s2;
        BattleManager.var_game_PlayerEntity_arr_a[n].var_short_a = s;
        BattleManager.var_game_PlayerEntity_arr_a[n].var_int_y = s;
        BattleManager.var_game_PlayerEntity_arr_a[n].var_int_z = s2;
        if (n == BattleScreen.var_byte_b) {
            var_game_PlayerEntity_arr_a[n].c(s, s2);
        }
    }
}

