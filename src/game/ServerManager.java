/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Image
 *  javax.microedition.rms.RecordStore
 */
package game;

import game.AchievementScreen;
import game.ActionListener026;
import game.ActionListener054;
import game.ActionListener070;
import game.ActionListener099;
import game.ActionListener107;
import game.ActionListener109;
import game.ActionListener125;
import game.ActionListener126;
import game.ActionListener141;
import game.BattleManager;
import game.BattleScreen;
import game.BoardScreen;
import game.ClanGroupEntry;
import game.ConnectionWatchdog;
import game.DataUtils;
import game.EquipItemEntry;
import game.EquipScreen;
import game.FontRenderer;
import game.GameCanvas;
import game.GameCommand;
import game.GameHelper05;
import game.GameHelper13;
import game.GameHelper33;
import game.GameSetting;
import game.IActionListener;
import game.IPacketListener;
import game.MenuScreen;
import game.PlayerAccountInfo;
import game.ProfileScreen;
import game.StringUtils;
import game.TerrainMidlet;
import game.TopupScreen;
import java.util.Vector;
import javax.microedition.lcdui.Image;
import javax.microedition.rms.RecordStore;

public final class ServerManager
implements IPacketListener {
    private static ServerManager var_game_ServerManager_I1IIIIl11;
    private static boolean var_boolean_I1IIIIl11;

    public static ServerManager game_ServerManager_a() {
        if (var_game_ServerManager_I1IIIIl11 == null) {
            var_game_ServerManager_I1IIIIl11 = new ServerManager();
        }
        return var_game_ServerManager_I1IIIIl11;
    }

    private static byte[] Il1I11l11I(String string) {
        try {
            RecordStore rs = RecordStore.openRecordStore("vt" + string, false);
            byte[] byArray = rs.getRecord(1);
            rs.closeRecordStore();
            return byArray;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String java_lang_String_a() {
        return "103.178.235.112:19129";
    }

    public final void void_a() {
        if (!var_boolean_I1IIIIl11) {
            var_boolean_I1IIIIl11 = true;
            GameCanvas.void_a(StringUtils.br());
        }
    }

    public final void b() {
        GameCanvas.b(StringUtils.ds());
    }

    public final void c() {
        GameCanvas.void_a(StringUtils.bq());
        if (EquipScreen.var_game_EquipScreen_a != null) {
            EquipScreen.var_java_util_Vector_a.removeAllElements();
            EquipScreen.var_game_EquipScreen_a.b.removeAllElements();
        }
        GameSetting.var_game_GameSetting_a.b_();
    }

    public final void a(String string) {
        GameCanvas.void_a(string);
    }

    public final void d() {
        if (GameSetting.e == 1) {
            TerrainMidlet.myInfo.var_java_lang_String_a = GameSetting.var_game_GameSetting_a.var_game_MapEntity_a.java_lang_String_a();
            DataUtils.a("caroun", GameSetting.var_game_GameSetting_a.var_game_MapEntity_a.java_lang_String_a());
            DataUtils.a("caropass", GameSetting.var_game_GameSetting_a.var_game_MapEntity_b.java_lang_String_a());
        } else {
            TerrainMidlet.myInfo.var_java_lang_String_a = GameSetting.var_game_GameSetting_a.var_game_MapEntity_a.java_lang_String_a();
            DataUtils.a("caroun", "");
            DataUtils.a("caropass", "");
        }
        GameCanvas.d();
        MenuScreen.var_game_MenuScreen_a = new MenuScreen();
        MenuScreen.var_game_MenuScreen_a.b_();
        if (!GameHelper13.var_game_GameHelper13_a.var_java_util_Vector_a.isEmpty()) {
            GameHelper13.var_game_GameHelper13_a.a(MenuScreen.var_game_MenuScreen_a);
        }
    }

    public final void a(int n, boolean bl) {
        if (n == TerrainMidlet.myInfo.var_int_a) {
            GameCanvas.d();
        }
        BoardScreen boardScreen = BoardScreen.var_game_BoardScreen_a;
        for (int i = 0; i < boardScreen.var_java_util_Vector_a.size(); ++i) {
            PlayerAccountInfo playerAccountInfo = (PlayerAccountInfo)boardScreen.var_java_util_Vector_a.elementAt(i);
            if (playerAccountInfo.var_int_a != n) continue;
            playerAccountInfo.var_boolean_b = bl;
        }
        if (boardScreen instanceof ZoneScreen) {
            ((ZoneScreen) boardScreen).updateCommands();
        }
    }

    public final void a(String string, int n) {
        if (BoardScreen.var_game_BoardScreen_a.boolean_a()) {
            if (BoardScreen.var_byte_b != 7) {
                BoardScreen.var_game_BoardScreen_a.a(n, string);
                return;
            }
        } else if (BattleScreen.var_game_BattleScreen_a.boolean_a()) {
            BattleScreen.var_game_BattleScreen_a.a(n, string);
        }
    }

    public final void a(int n, String string) {
        BoardScreen.var_game_BoardScreen_a.c(n);
        if (BoardScreen.var_byte_b != 7) {
            if (n == TerrainMidlet.myInfo.var_int_a) {
                GameCanvas.var_game_GameHelper20_a.a(string, null, new GameCommand("OK", new ActionListener125()), null);
                GameCanvas.var_game_GameHelper21_a = GameCanvas.var_game_GameHelper20_a;
                return;
            }
            BattleManager.game_PlayerEntity_a((int)n).var_int_o = -1;
            BattleManager.game_PlayerEntity_a((int)n).var_java_lang_String_a = "";
            return;
        }
        if (n == TerrainMidlet.myInfo.var_int_a) {
            GameHelper05.var_game_GameHelper05_a.b_();
            return;
        }
        BattleManager.game_PlayerEntity_a((int)n).var_int_o = -1;
        BattleManager.game_PlayerEntity_a((int)n).var_java_lang_String_a = "";
    }

    public final void a(byte by, byte by2, Vector vector, String string) {
        if (GameHelper33.var_game_GameHelper33_a == null) {
            GameHelper33.var_game_GameHelper33_a = new GameHelper33();
        }
        GameCanvas.d();
        GameHelper33.var_game_GameHelper33_a.var_java_lang_String_a = string;
        GameHelper33.var_game_GameHelper33_a.var_int_b = by2;
        GameHelper33.var_game_GameHelper33_a.a(by, vector);
        GameHelper33.var_game_GameHelper33_a.a(MenuScreen.var_game_MenuScreen_a);
    }

    public final void a(String string, boolean bl, String string2) {
        if (!bl) {
            GameCanvas.void_a(StringUtils.bp());
            return;
        }
        TerrainMidlet.executeAsync(string, "sms://" + string2, new ActionListener141(), new ActionListener107());
    }

    public final void a(String string, String string2) {
        TerrainMidlet.executeAsync(string, "sms://" + string2, new ActionListener026(), new ActionListener054());
    }

    public final void a(Vector vector) {
        if (GameHelper33.var_game_GameHelper33_a == null) {
            GameHelper33.var_game_GameHelper33_a = new GameHelper33();
        }
        GameCanvas.d();
        GameHelper33.var_game_GameHelper33_a.a(2, vector);
        if (GameCanvas.var_game_BaseScreen_a == BoardScreen.var_game_BoardScreen_a) {
            GameHelper33.var_game_GameHelper33_a.a(BoardScreen.var_game_BoardScreen_a);
            return;
        }
        if (GameCanvas.var_game_BaseScreen_a == BattleScreen.var_game_BattleScreen_a) {
            GameHelper33.var_game_GameHelper33_a.a(BattleScreen.var_game_BattleScreen_a);
            return;
        }
        if (GameCanvas.var_game_BaseScreen_a == MenuScreen.var_game_MenuScreen_a) {
            GameHelper33.var_game_GameHelper33_a.a(MenuScreen.var_game_MenuScreen_a);
        }
    }

    public static void b(Vector vector) {
        if (GameHelper33.var_game_GameHelper33_a == null) {
            GameHelper33.var_game_GameHelper33_a = new GameHelper33();
        }
        GameCanvas.d();
        GameHelper33.var_game_GameHelper33_a.a(vector);
        if (GameCanvas.var_game_BaseScreen_a == BoardScreen.var_game_BoardScreen_a) {
            GameHelper33.var_game_GameHelper33_a.a(BoardScreen.var_game_BoardScreen_a);
            return;
        }
        if (GameCanvas.var_game_BaseScreen_a == MenuScreen.var_game_MenuScreen_a) {
            GameHelper33.var_game_GameHelper33_a.a(MenuScreen.var_game_MenuScreen_a);
        }
    }

    public final void c(Vector vector) {
        if (vector.size() > 0) {
            for (int i = 0; i < vector.size(); ++i) {
                PlayerAccountInfo playerAccountInfo = (PlayerAccountInfo)vector.elementAt(i);
                if (!playerAccountInfo.var_java_lang_String_a.equals(GameCanvas.var_game_InputScreen_a.a.java_lang_String_a())) continue;
                GameCanvas.b(StringUtils.bl() + " " + playerAccountInfo.var_java_lang_String_a + " " + StringUtils.bm());
                ConnectionWatchdog.game_ConnectionWatchdog_a().d(playerAccountInfo.var_int_a);
            }
            return;
        }
        GameCanvas.void_a(StringUtils.bn());
    }

    public final void a(byte by) {
        if (GameHelper33.var_game_GameHelper33_a == null) {
            GameHelper33.var_game_GameHelper33_a = new GameHelper33();
        }
        if (by == 0) {
            GameCanvas.void_a(StringUtils.bu());
            if (GameCanvas.var_game_BaseScreen_a == GameHelper33.var_game_GameHelper33_a && GameHelper33.var_game_GameHelper33_a.var_int_c == 2) {
                ConnectionWatchdog.game_ConnectionWatchdog_a().c();
                return;
            }
        } else {
            if (by == 2) {
                GameCanvas.void_a(StringUtils.bt());
                return;
            }
            GameCanvas.void_a(StringUtils.bs());
        }
    }

    public final void a(ClanGroupEntry clanGroupEntry) {
        if (GameCanvas.var_game_BaseScreen_a != GameHelper13.var_game_GameHelper13_a) {
            ++GameCanvas.var_game_TimerHUD_a.var_int_a;
            GameCanvas.var_game_TimerHUD_a.b();
        }
        GameHelper13.var_game_GameHelper13_a.var_java_util_Vector_a.insertElementAt(clanGroupEntry, 0);
        GameHelper13.var_game_GameHelper13_a.b = GameHelper13.var_game_GameHelper13_a.var_java_util_Vector_a.size() * 40 - (GameCanvas.var_int_c - 100);
    }

    public final void d(Vector vector) {
        GameCanvas.d();
        if (TopupScreen.a == null) {
            TopupScreen.a = new TopupScreen();
        }
        TopupScreen.a.a(vector);
        TopupScreen.a.b_();
    }

    public final void b(String string) {
        GameCanvas.var_game_GameHelper12_a.a(string);
        GameCanvas.var_game_GameHelper12_a.b();
    }

    public final void c(String string) {
        GameCanvas.void_a(string);
    }

    public final void b(String string, String strUrl) {
        ActionListener099 actionListener = new ActionListener099(strUrl);
        GameCanvas.var_game_GameHelper20_a.a(string, new GameCommand("Download", actionListener), new GameCommand("", actionListener), new GameCommand(StringUtils.dI(), new ActionListener070()));
        GameCanvas.var_game_GameHelper21_a = GameCanvas.var_game_GameHelper20_a;
    }

    public final void a(String string, String strUrl, byte by) {
        if (TerrainMidlet.myInfo != null && TerrainMidlet.myInfo.var_java_lang_String_a != null) {
            FontRenderer.a(strUrl, "@username", TerrainMidlet.myInfo.var_java_lang_String_a);
        }
        ActionListener126 actionListener = new ActionListener126(by, strUrl);
        GameCanvas.var_game_GameHelper20_a.a(string, new GameCommand("OK", actionListener), new GameCommand("", actionListener), new GameCommand(StringUtils.cq(), new ActionListener109()));
        GameCanvas.var_game_GameHelper21_a = GameCanvas.var_game_GameHelper20_a;
    }

    public final void d(String string) {
        GameCanvas.void_a(string);
    }

    public final void a(int n, byte by) {
        GameCanvas.d();
        BoardScreen.var_game_BoardScreen_a.a(n, by);
    }

    public final void a(byte by, Vector vector) {
        if (GameHelper33.var_game_GameHelper33_a == null) {
            GameHelper33.var_game_GameHelper33_a = new GameHelper33();
        }
        GameCanvas.d();
        GameHelper33.var_game_GameHelper33_a.var_int_b = by;
        GameHelper33.var_game_GameHelper33_a.a(5, vector);
        GameHelper33.var_game_GameHelper33_a.a(ProfileScreen.var_game_ProfileScreen_b);
    }

    public static void a(short s, Image image) {
        if (GameCanvas.var_game_BaseScreen_a == ProfileScreen.var_game_ProfileScreen_a) {
            for (int n = 0; n < ProfileScreen.var_game_ProfileScreen_a.var_java_util_Vector_a.size(); ++n) {
                EquipItemEntry entry = (EquipItemEntry)ProfileScreen.var_game_ProfileScreen_a.var_java_util_Vector_a.elementAt(n);
                if (entry.var_short_a == s) {
                    entry.var_javax_microedition_lcdui_Image_a = image;
                    break;
                }
            }
        }
        if (GameCanvas.var_game_BaseScreen_a == ProfileScreen.var_game_ProfileScreen_b) {
            ProfileScreen.var_game_ProfileScreen_b.var_game_EquipItemEntry_a.var_javax_microedition_lcdui_Image_a = image;
        }
        if (GameCanvas.var_game_BaseScreen_a == GameHelper33.var_game_GameHelper33_a) {
            for (int n = 0; n < GameHelper33.var_game_GameHelper33_a.var_java_util_Vector_a.size(); ++n) {
                PlayerAccountInfo info = (PlayerAccountInfo)GameHelper33.var_game_GameHelper33_a.var_java_util_Vector_a.elementAt(n);
                if (info.var_short_b == s) {
                    info.var_javax_microedition_lcdui_Image_a = image;
                }
            }
        }
        if (GameCanvas.var_game_BaseScreen_a == BoardScreen.var_game_BoardScreen_a) {
            for (int n = 0; n < BoardScreen.var_game_BoardScreen_a.var_java_util_Vector_a.size(); ++n) {
                PlayerAccountInfo info = (PlayerAccountInfo)BoardScreen.var_game_BoardScreen_a.var_java_util_Vector_a.elementAt(n);
                if (info.var_short_b == s) {
                    info.var_javax_microedition_lcdui_Image_a = image;
                }
            }
        }
        if (GameCanvas.var_game_BaseScreen_a == AchievementScreen.var_game_AchievementScreen_a) {
            AchievementScreen.var_game_AchievementScreen_a.var_javax_microedition_lcdui_Image_a = image;
        }
    }
}

