/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Image
 */
package game;

import game.AchievementScreen;
import game.ActionListener011;
import game.ActionListener045;
import game.ActionListener165;
import game.ActionListener173;
import game.ActionListener193;
import game.ActionListener207;
import game.ActionListener264;
import game.AvatarIcon;
import game.BattleManager;
import game.BattleScreen;
import game.BoardScreen;
import game.ChallengeScreen;
import game.CharacterSelectScreen;
import game.CharacterUpgradeScreen;
import game.ChatEntity;
import game.ChestBox;
import game.ClanGroupEntry;
import game.ClanMemberEntry;
import game.ConnectionWatchdog;
import game.DailyGiftScreen;
import game.DataUtils;
import game.EffectCache;
import game.EquipItemEntry;
import game.EquipScreen;
import game.EquipSlotSet;
import game.EquipTemplate;
import game.EquipUpgradeEntry;
import game.ExplosionEffect;
import game.FloatingTextManager;
import game.FontRenderer;
import game.GameCanvas;
import game.GameHelper05;
import game.GameHelper07;
import game.GameHelper14;
import game.GameHelper17;
import game.GameHelper23;
import game.GameHelper25;
import game.GameHelper27;
import game.GameHelper31;
import game.GameHelper34;
import game.GameHelper37;
import game.GameHelper41;
import game.GameHelper43;
import game.GameHelper48;
import game.GameHelper53;
import game.GameSetting;
import game.INetworkCallback;
import game.IPacketListener;
import game.InventoryScreen;
import game.ItemEffect;
import game.ItemManager;
import game.ItemTemplate;
import game.LuckyDrawScreen;
import game.MenuScreen;
import game.Message;
import game.MissionScreen;
import game.OptionScreen;
import game.PlayerAccountInfo;
import game.PlayerEntity;
import game.PlayerSlot;
import game.ProfileScreen;
import game.QuestReward;
import game.ServerInfo;
import game.ServerManager;
import game.ShopItemEntry;
import game.ShopScreen;
import game.StringUtils;
import game.TerrainMidlet;
import game.TurnTimer;
import game.UpdateScreen;
import game.UpgradeScreen;
import java.io.DataInputStream;
import java.util.Vector;
import javax.microedition.lcdui.Image;

public final class GameHelper01
implements INetworkCallback {
    private IPacketListener c;
    private static GameHelper01 d;
    public static boolean a;
    public static Object b;

    public static GameHelper01 d() {
        if (d == null) {
            d = new GameHelper01();
        }
        return d;
    }

    public final void c() {
        this.c.b();
    }

    public final void a() {
        this.c.void_a();
    }

    public final void b() {
        this.c.c();
    }

    /*
     * WARNING - void declaration
     */
    public final void a(Message object) {
        block342: {
            if (object != null) {
                try {
                    switch (((Message)object).a) {
                        case -110: {
                            PetManager.handlePetInfo((Message)object);
                            return;
                        }
                        case -111: {
                            PetManager.handlePetSlots((Message)object);
                            return;
                        }
                        case -109: {
                            VipManager.handleVipInfo((Message)object);
                            return;
                        }
                        case -98: {
                            BauCuaHandler.handleMessage((Message)object);
                            return;
                        }
                        case -100: {
                            String string = ((Message)object).java_io_DataInputStream_a().readUTF();
                            String string2 = ((Message)object).java_io_DataInputStream_a().readUTF();
                            String string3 = ((Message)object).java_io_DataInputStream_a().readUTF();
                            MenuScreen.a(1);
                            MenuScreen.var_java_lang_String_arr_a[MenuScreen.var_byte_a] = string.toUpperCase();
                            if (UpdateScreen.var_game_UpdateScreen_a == null) {
                                UpdateScreen.var_game_UpdateScreen_a = new UpdateScreen();
                            }
                            UpdateScreen.var_java_lang_String_a = string2;
                            UpdateScreen.b = string3;
                            UpdateScreen.var_game_UpdateScreen_a.d();
                            return;
                        }
                        default: {
                            return;
                        }
                        case 55: {
                            GameHelper01.b((Message)object);
                            return;
                        }
                        case -26: {
                            String string = ((Message)object).java_io_DataInputStream_a().readUTF();
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] agent= " + string + " provider= " + by);
                            TerrainMidlet.providerId = by;
                            DataUtils.a("provider", (int)by);
                            DataUtils.a("agent", string);
                            return;
                        }
                        case -25: {
                            int n = ((Message)object).java_io_DataInputStream_a().readInt();
                            GameCanvas.b(((Message)object).java_io_DataInputStream_a().readUTF(), new ActionListener193(n));
                            return;
                        }
                        case -24: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            int n = ((Message)object).java_io_DataInputStream_a().readInt();
                            System.out.println("[ca] curr CUP= " + n);
                            TerrainMidlet.myInfo.var_int_d = n;
                            if (GameCanvas.var_game_BaseScreen_a != BattleScreen.var_game_BattleScreen_a || BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b] == null) break;
                            BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b].d(by);
                            return;
                        }
                        case -23: {
                            GameCanvas.d();
                            Vector<GameHelper23> vector = new Vector<GameHelper23>();
                            while (((Message)object).java_io_DataInputStream_a().available() > 0) {
                                GameHelper23 gameHelper23 = new GameHelper23();
                                gameHelper23.var_int_a = ((Message)object).java_io_DataInputStream_a().readByte();
                                gameHelper23.d = ((Message)object).java_io_DataInputStream_a().readByte();
                                gameHelper23.var_java_lang_String_a = ((Message)object).java_io_DataInputStream_a().readUTF();
                                gameHelper23.var_java_lang_String_b = ((Message)object).java_io_DataInputStream_a().readUTF();
                                gameHelper23.var_int_b = ((Message)object).java_io_DataInputStream_a().readInt();
                                gameHelper23.c = ((Message)object).java_io_DataInputStream_a().readInt();
                                gameHelper23.var_boolean_a = ((Message)object).java_io_DataInputStream_a().readBoolean();
                                System.out.println("[ca] id = " + gameHelper23.var_int_a + " level= " + gameHelper23.d + " name= " + gameHelper23.var_java_lang_String_a + " require=" + gameHelper23.var_int_b + " have= " + gameHelper23.c + " reward= " + gameHelper23.var_java_lang_String_b);
                                vector.addElement(gameHelper23);
                            }
                            MissionScreen.a.a(vector);
                            MissionScreen.a.b_();
                            return;
                        }
                        case -22: {
                            ProfileScreen.var_game_ProfileScreen_b.var_game_EquipItemEntry_a.var_long_a = ((Message)object).java_io_DataInputStream_a().readLong();
                            ProfileScreen.var_game_ProfileScreen_b.var_game_EquipItemEntry_a.var_int_c = ((Message)object).java_io_DataInputStream_a().readInt();
                            return;
                        }
                        case -19: {
                            int n = ((Message)object).java_io_DataInputStream_a().readByte();
                            for (int i = 0; i < n; ++i) {
                                byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                                String string = ((Message)object).java_io_DataInputStream_a().readUTF();
                                byte by2 = ((Message)object).java_io_DataInputStream_a().readByte();
                                ChallengeScreen.var_game_ChallengeScreen_a.a(by + by2 + 1, string);
                            }
                            return;
                        }
                        case -18: {
                            byte by19 = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] FOMULA= " + by19);
                            if (by19 == 0) {
                                String string = ((Message)object).java_io_DataInputStream_a().readUTF();
                                System.out.println("[ca] fInfo= " + string);
                                GameCanvas.a(string, new ActionListener173());
                            }
                            if (by19 != 1) break;
                            DailyGiftScreen.var_game_DailyGiftScreen_a.var_java_util_Vector_a.removeAllElements();
                            GameCanvas.d();
                            short s = ((Message)object).java_io_DataInputStream_a().readShort();
                            int n = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] feId: " + s + " nFomular= " + n);
                            for (int i = 0; i < n; ++i) {
                                boolean bl;
                                int string;
                                GameHelper07 gameHelper07 = new GameHelper07();
                                int n3 = ((Message)object).java_io_DataInputStream_a().readShort();
                                String by4 = ((Message)object).java_io_DataInputStream_a().readUTF();
                                int by = ((Message)object).java_io_DataInputStream_a().readByte();
                                by19 = ((Message)object).java_io_DataInputStream_a().readByte();
                                byte by3 = ((Message)object).java_io_DataInputStream_a().readByte();
                                System.out.println("[ca] id item create= " + n3 + " type Fomula= " + by3 + " gun= " + by19 + " lvRequire: " + by);
                                gameHelper07.var_game_ItemTemplate_b = EquipSlotSet.b(by19, by3, (short)n3);
                                gameHelper07.var_game_ItemTemplate_b.var_java_lang_String_a = by4;
                                System.out.println("[ca] Name equip= " + by4);
                                gameHelper07.var_int_a = by;
                                gameHelper07.var_int_b = s;
                                n3 = ((Message)object).java_io_DataInputStream_a().readShort();
                                gameHelper07.var_javax_microedition_lcdui_Image_arr_a = new Image[n3];
                                gameHelper07.var_java_lang_String_arr_a = new String[n3];
                                gameHelper07.var_java_lang_String_arr_b = new String[n3];
                                gameHelper07.var_int_arr_a = new int[n3];
                                for (string = 0; string < n3; ++string) {
                                    String string3;
                                    short s2 = ((Message)object).java_io_DataInputStream_a().readShort();
                                    gameHelper07.var_java_lang_String_arr_b[string] = string3 = ((Message)object).java_io_DataInputStream_a().readUTF();
                                    if (GameHelper37.boolean_a(s2)) {
                                        gameHelper07.var_javax_microedition_lcdui_Image_arr_a[string] = GameHelper37.javax_microedition_lcdui_Image_a(s2);
                                    } else {
                                        ConnectionWatchdog.game_ConnectionWatchdog_a().a((byte)4, s2, (byte)i);
                                    }
                                    gameHelper07.var_int_arr_a[string] = s2;
                                    int needCount = ((Message)object).java_io_DataInputStream_a().readUnsignedShort();
                                    int haveCount = ((Message)object).java_io_DataInputStream_a().readUnsignedShort();
                                    gameHelper07.var_java_lang_String_arr_a[string] = haveCount + "/" + needCount;
                                    System.out.println("[ca]  Image id= " + s2 + " name= " + string3 + " numMaterial= " + gameHelper07.var_java_lang_String_arr_a[string]);
                                }
                                string = ((Message)object).java_io_DataInputStream_a().readShort();
                                String string4 = ((Message)object).java_io_DataInputStream_a().readUTF();
                                n3 = ((Message)object).java_io_DataInputStream_a().readByte();
                                string4 = string4 + (n3 == 0 ? "" : " " + n3);
                                boolean bl2 = ((Message)object).java_io_DataInputStream_a().readBoolean();
                                bl = ((Message)object).java_io_DataInputStream_a().readBoolean();
                                n3 = ((Message)object).java_io_DataInputStream_a().readByte();
                                gameHelper07.var_java_lang_String_arr_c = new String[n3];
                                for (by = 0; by < n3; ++by) {
                                    gameHelper07.var_java_lang_String_arr_c[by] = ((Message)object).java_io_DataInputStream_a().readUTF();
                                    System.out.println("[ca] detail=" + gameHelper07.var_java_lang_String_arr_c[by]);
                                }
                                gameHelper07.var_int_c = n3 * 18;
                                gameHelper07.var_boolean_a = bl2;
                                gameHelper07.var_game_ItemTemplate_a = EquipSlotSet.b(by19, by3, (short)string);
                                gameHelper07.var_game_ItemTemplate_a.var_java_lang_String_a = string4;
                                gameHelper07.var_boolean_b = bl;
                                System.out.println("[ca] idEquipNeed=" + string + " equipNeedName=" + string4);
                                System.out.println("[ca] is Have= " + bl2);
                                System.out.println("[ca] is Finish= " + bl);
                                DailyGiftScreen.var_game_DailyGiftScreen_a.a(gameHelper07);
                            }
                            if (GameCanvas.var_game_BaseScreen_a == InventoryScreen.var_game_InventoryScreen_a) {
                                DailyGiftScreen.var_game_DailyGiftScreen_a.var_game_BaseScreen_a = InventoryScreen.var_game_InventoryScreen_a;
                            } else if (GameCanvas.var_game_BaseScreen_a == GameHelper48.var_game_GameHelper48_a) {
                                DailyGiftScreen.var_game_DailyGiftScreen_a.var_game_BaseScreen_a = GameHelper48.var_game_GameHelper48_a;
                            } else if (GameCanvas.var_game_BaseScreen_a != null) {
                                DailyGiftScreen.var_game_DailyGiftScreen_a.var_game_BaseScreen_a = GameCanvas.var_game_BaseScreen_a;
                            }
                            if (DailyGiftScreen.var_game_DailyGiftScreen_a.var_java_util_Vector_a.isEmpty()) {
                                return;
                            }
                            if (GameCanvas.var_game_BaseScreen_a == InventoryScreen.var_game_InventoryScreen_a) {
                                DailyGiftScreen.var_game_DailyGiftScreen_a.a(InventoryScreen.var_game_InventoryScreen_a);
                            }
                            if (GameCanvas.var_game_BaseScreen_a == GameHelper48.var_game_GameHelper48_a) {
                                DailyGiftScreen.var_game_DailyGiftScreen_a.a(GameHelper48.var_game_GameHelper48_a);
                                return;
                            }
                            break block342;
                        }
                        case -17: {
                            String string18;
                            byte n5;
                            ChestBox chestBox;
                            byte by5;
                            byte by6 = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] Lucky Gift id= " + by6);
                            if (by6 == -1) {
                                byte by7 = ((Message)object).java_io_DataInputStream_a().readByte();
                                String string5 = ((Message)object).java_io_DataInputStream_a().readUTF();
                                if (GameCanvas.var_int_b < 200) {
                                    GameCanvas.void_a(string5);
                                }
                                UpgradeScreen.var_java_lang_String_arr_a = FontRenderer.a.a(string5, GameCanvas.var_int_b - 80);
                                UpgradeScreen.var_game_TurnTimer_a = new TurnTimer();
                                UpgradeScreen.var_game_TurnTimer_a.a(by7);
                                UpgradeScreen.var_game_TurnTimer_a.a();
                                UpgradeScreen.var_game_UpgradeScreen_a.b_();
                                return;
                            }
                            if (by6 == 0) {
                                by5 = ((Message)object).java_io_DataInputStream_a().readByte();
                                chestBox = new ChestBox();
                                byte string = ((Message)object).java_io_DataInputStream_a().readByte();
                                n5 = ((Message)object).java_io_DataInputStream_a().readByte();
                                string18 = ((Message)object).java_io_DataInputStream_a().readUTF();
                                chestBox.var_int_a = by5;
                                chestBox.var_int_b = string;
                                chestBox.var_java_lang_String_a = string18;
                                chestBox.c = n5;
                                chestBox.var_boolean_a = true;
                                chestBox.var_boolean_b = true;
                                UpgradeScreen.var_game_UpgradeScreen_a.var_game_ChestBox_arr_a[by5] = chestBox;
                                System.out.println("[ca] index= " + by5 + "idIcon= " + chestBox.c);
                                if (chestBox.var_int_b == 2) {
                                    ConnectionWatchdog.game_ConnectionWatchdog_a().a((byte)3, (short)(chestBox.c & 0xFF), by5);
                                }
                            }
                            if (by6 != -2) break;
                            for (int idx = 0; idx < 12; ++idx) {
                                ChestBox chestBox2 = new ChestBox();
                                int chestType = ((Message)object).java_io_DataInputStream_a().readByte();
                                System.out.println("[ca] type= " + chestType);
                                if (chestType == -1) continue;
                                int iconId = ((Message)object).java_io_DataInputStream_a().readByte();
                                String chestName = ((Message)object).java_io_DataInputStream_a().readUTF();
                                chestBox2.var_int_a = idx;
                                chestBox2.var_int_b = chestType;
                                chestBox2.var_java_lang_String_a = chestName;
                                chestBox2.c = iconId;
                                chestBox2.var_boolean_b = true;
                                chestBox2.var_boolean_a = true;
                                UpgradeScreen.var_game_UpgradeScreen_a.var_game_ChestBox_arr_a[idx] = chestBox2;
                                UpgradeScreen.var_game_UpgradeScreen_a.var_int_arr_a[idx] = -1;
                                if (chestBox2.var_int_b != 2) continue;
                                ConnectionWatchdog.game_ConnectionWatchdog_a().a((byte)3, (short)(chestBox2.c & 0xFF), (byte)idx);
                            }
                            UpgradeScreen.var_game_UpgradeScreen_a.var_boolean_a = true;
                            UpgradeScreen.var_game_UpgradeScreen_a.e();
                            return;
                        }
                        case -14: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] TypE= " + by);
                            if (by != -1) {
                                byte by8 = ((Message)object).java_io_DataInputStream_a().readByte();
                                String i = ((Message)object).java_io_DataInputStream_a().readUTF();
                                Vector<PlayerAccountInfo> vector = new Vector<PlayerAccountInfo>();
                                System.out.println("[ca] page= " + by8 + " s34= " + i);
                                while (((Message)object).java_io_DataInputStream_a().available() > 0) {
                                    PlayerAccountInfo playerAccountInfo = new PlayerAccountInfo();
                                    playerAccountInfo.var_int_a = ((Message)object).java_io_DataInputStream_a().readInt();
                                    playerAccountInfo.var_java_lang_String_a = ((Message)object).java_io_DataInputStream_a().readUTF();
                                    playerAccountInfo.var_byte_a = ((Message)object).java_io_DataInputStream_a().readByte();
                                    playerAccountInfo.var_short_b = ((Message)object).java_io_DataInputStream_a().readShort();
                                    playerAccountInfo.var_int_b = ((Message)object).java_io_DataInputStream_a().readShort();
                                    playerAccountInfo.var_int_c = ((Message)object).java_io_DataInputStream_a().readByte();
                                    playerAccountInfo.f();
                                    playerAccountInfo.f = ((Message)object).java_io_DataInputStream_a().readUnsignedByte();
                                    for (int i2 = 0; i2 < 5; ++i2) {
                                        playerAccountInfo.var_short_arr_arr_a[playerAccountInfo.var_byte_a][i2] = ((Message)object).java_io_DataInputStream_a().readShort();
                                    }
                                    playerAccountInfo.var_java_lang_String_b = ((Message)object).java_io_DataInputStream_a().readUTF();
                                    System.out.println("[ca] aa= " + playerAccountInfo.var_java_lang_String_b);
                                    playerAccountInfo.var_boolean_b = true;
                                    playerAccountInfo.b();
                                    vector.addElement(playerAccountInfo);
                                }
                                this.c.a((byte)(-by), by8, vector, i);
                                return;
                            }
                            int n = ((Message)object).java_io_DataInputStream_a().readByte();
                            MenuScreen.var_java_lang_String_arr_arr_a[7] = new String[n];
                            for (int by2 = 0; by2 < n; ++by2) {
                                MenuScreen.var_java_lang_String_arr_arr_a[7][by2] = ((Message)object).java_io_DataInputStream_a().readUTF();
                            }
                            return;
                        }
                        case -12: {
                            if (OptionScreen.a == null) {
                                OptionScreen.a = new OptionScreen();
                            }
                            Vector<PlayerSlot> vector = new Vector<PlayerSlot>();
                            int n = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] nCL+ " + n);
                            for (int i = 0; i < n; ++i) {
                                PlayerSlot playerSlot = new PlayerSlot();
                                playerSlot.var_byte_a = ((Message)object).java_io_DataInputStream_a().readByte();
                                playerSlot.var_java_lang_String_a = ((Message)object).java_io_DataInputStream_a().readUTF();
                                System.out.println("[ca] name= " + playerSlot.var_java_lang_String_a);
                                playerSlot.var_int_a = ((Message)object).java_io_DataInputStream_a().readInt();
                                playerSlot.var_int_b = ((Message)object).java_io_DataInputStream_a().readInt();
                                playerSlot.var_byte_b = ((Message)object).java_io_DataInputStream_a().readByte();
                                playerSlot.c = ((Message)object).java_io_DataInputStream_a().readByte();
                                vector.addElement(playerSlot);
                            }
                            OptionScreen.a.a(vector);
                            OptionScreen.a.b_();
                            return;
                        }
                        case -10: {
                            for (int i = 0; i < 8; ++i) {
                                BattleScreen.var_byte_arr_a[i] = ((Message)object).java_io_DataInputStream_a().readByte();
                                System.out.println("[ca] item num= " + BattleScreen.var_byte_arr_a[i]);
                            }
                            return;
                        }
                        case -7: {
                            int s = 0;
                            PlayerAccountInfo playerAccountInfo = TerrainMidlet.myInfo;
                            boolean i = false;
                            while (s < 5) {
                                int string19 = ((Message)object).java_io_DataInputStream_a().readInt();
                                if (playerAccountInfo.var_game_EquipSlotSet_a.var_game_ItemTemplate_arr_a[s] != null) {
                                    playerAccountInfo.var_game_EquipSlotSet_a.var_game_ItemTemplate_arr_a[s].var_int_a = string19;
                                }
                                System.out.println("[ca] dbkey = " + string19);
                                ++s;
                            }
                            return;
                        }
                        case -6: {
                            byte i = ((Message)object).java_io_DataInputStream_a().readByte();
                            GameCanvas.c(StringUtils.ds());
                            GameHelper34.var_java_util_Vector_a.removeAllElements();
                            if (GameCanvas.var_game_BaseScreen_a == BattleScreen.var_game_BattleScreen_a) {
                                GameCanvas.var_game_BaseScreen_a = BoardScreen.var_game_BoardScreen_a;
                            }
                            BattleScreen.var_game_GameHelper34_a.void_a(i);
                            System.gc();
                            return;
                        }
                        case -3: {
                            Vector<ItemTemplate> vector = new Vector<ItemTemplate>();
                            while (((Message)object).java_io_DataInputStream_a().available() > 0) {
                                short playerAccountInfo = ((Message)object).java_io_DataInputStream_a().readShort();
                                String s = ((Message)object).java_io_DataInputStream_a().readUTF();
                                String vector2 = ((Message)object).java_io_DataInputStream_a().readUTF();
                                int n = ((Message)object).java_io_DataInputStream_a().readInt();
                                int i = ((Message)object).java_io_DataInputStream_a().readInt();
                                byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                                byte by9 = ((Message)object).java_io_DataInputStream_a().readByte();
                                ItemTemplate clanGroupEntry = new ItemTemplate();
                                clanGroupEntry.var_short_a = playerAccountInfo;
                                clanGroupEntry.var_java_lang_String_a = s;
                                clanGroupEntry.var_java_lang_String_b = vector2;
                                clanGroupEntry.var_int_e = n;
                                clanGroupEntry.var_int_f = i;
                                clanGroupEntry.var_byte_e = by;
                                clanGroupEntry.var_boolean_d = true;
                                if (GameHelper37.boolean_a(playerAccountInfo)) {
                                    clanGroupEntry.var_javax_microedition_lcdui_Image_a = GameHelper37.javax_microedition_lcdui_Image_a(playerAccountInfo);
                                } else {
                                    ConnectionWatchdog.game_ConnectionWatchdog_a().a((byte)1, playerAccountInfo, (byte)-1);
                                }
                                if (by9 == 0) {
                                    clanGroupEntry.var_boolean_b = true;
                                }
                                vector.addElement(clanGroupEntry);
                            }
                            GameCanvas.d();
                            if (GameHelper48.var_game_GameHelper48_a == null) {
                                GameHelper48.var_game_GameHelper48_a = new GameHelper48();
                            }
                            GameHelper48.var_game_GameHelper48_a.a(vector);
                            GameHelper48.var_game_GameHelper48_a.a(MenuScreen.var_game_MenuScreen_a);
                            return;
                        }
                        case -2: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            PlayerAccountInfo playerAccountInfo = TerrainMidlet.myInfo;
                            if (by == 0) {
                                TerrainMidlet.isVip[playerAccountInfo.var_byte_a] = false;
                            } else {
                                for (int n = 0; n < 5; ++n) {
                                    short playerAccountInfo2 = ((Message)object).java_io_DataInputStream_a().readShort();
                                    System.out.println("[ca]  vip ID= " + playerAccountInfo2);
                                    playerAccountInfo.var_short_arr_arr_b[playerAccountInfo.var_byte_a][n] = playerAccountInfo2;
                                }
                                playerAccountInfo.c();
                                TerrainMidlet.isVip[playerAccountInfo.var_byte_a] = true;
                            }
                            EquipScreen.var_game_EquipScreen_a.k();
                            return;
                        }
                        case 3: {
                            int n;
                            ConnectionWatchdog.game_ConnectionWatchdog_a().n();
                            ConnectionWatchdog.game_ConnectionWatchdog_a().b((byte)-1, -1);
                            System.currentTimeMillis();
                            ConnectionWatchdog.game_ConnectionWatchdog_a().d();
                            PlayerAccountInfo playerAccountInfo = TerrainMidlet.myInfo = new PlayerAccountInfo();
                            TerrainMidlet.myInfo.var_int_a = ((Message)object).java_io_DataInputStream_a().readInt();
                            System.out.println("[ca] IDDB= " + playerAccountInfo.var_int_a);
                            playerAccountInfo.var_long_c = ((Message)object).java_io_DataInputStream_a().readLong();
                            playerAccountInfo.e = ((Message)object).java_io_DataInputStream_a().readLong();
                            playerAccountInfo.var_byte_a = ((Message)object).java_io_DataInputStream_a().readByte();
                            playerAccountInfo.var_short_b = ((Message)object).java_io_DataInputStream_a().readShort();
                            System.out.println("[ca] CLAN ID= " + playerAccountInfo.var_short_b);
                            ((Message)object).java_io_DataInputStream_a().readByte();
                            for (int i = 0; i < 10; ++i) {
                                TerrainMidlet.isVip[i] = ((Message)object).java_io_DataInputStream_a().readBoolean();
                                if (!TerrainMidlet.isVip[i]) {
                                    for (n = 0; n < 5; ++n) {
                                        playerAccountInfo.var_short_arr_arr_a[i][n] = ((Message)object).java_io_DataInputStream_a().readShort();
                                    }
                                    continue;
                                }
                                for (n = 0; n < 5; ++n) {
                                    playerAccountInfo.var_short_arr_arr_b[i][n] = ((Message)object).java_io_DataInputStream_a().readShort();
                                }
                                for (n = 0; n < 5; ++n) {
                                    playerAccountInfo.var_short_arr_arr_a[i][n] = ((Message)object).java_io_DataInputStream_a().readShort();
                                }
                            }
                            Vector<GameHelper31> vector = new Vector<GameHelper31>();
                            for (n = 0; n < 36; ++n) {
                                int n6 = ((Message)object).java_io_DataInputStream_a().readInt();
                                int n7 = ((Message)object).java_io_DataInputStream_a().readInt();
                                int n8 = ((Message)object).java_io_DataInputStream_a().readInt();
                                System.out.println("[ca] numI= " + n6 + "size= 36 xu= " + n7 + "luong = " + n8);
                                vector.addElement(new GameHelper31((byte)n, n6, n7, n8));
                            }
                            ExplosionEffect.a(vector);
                            for (n = 0; n < 10; ++n) {
                                if (n < 3) {
                                    ChatEntity.var_byte_arr_a[n] = 1;
                                    ChatEntity.var_int_arr_a[n] = 0;
                                    ChatEntity.var_int_arr_b[n] = 0;
                                    continue;
                                }
                                ChatEntity.var_byte_arr_a[n] = ((Message)object).java_io_DataInputStream_a().readByte();
                                ChatEntity.var_int_arr_a[n] = ((Message)object).java_io_DataInputStream_a().readShort() * 1000;
                                ChatEntity.var_int_arr_b[n] = ((Message)object).java_io_DataInputStream_a().readShort();
                                System.out.println(new StringBuffer("[ca] LUONG= ").append(ChatEntity.var_int_arr_b[n]));
                            }
                            MenuScreen.var_java_lang_String_a = ((Message)object).java_io_DataInputStream_a().readUTF();
                            MenuScreen.var_java_lang_String_b = ((Message)object).java_io_DataInputStream_a().readUTF();
                            MenuScreen.var_java_lang_String_c = ((Message)object).java_io_DataInputStream_a().readUTF();
                            MenuScreen.a(0);
                            if (!GameSetting.var_boolean_d) {
                                GameCanvas.c();
                                return;
                            }
                            ConnectionWatchdog.game_ConnectionWatchdog_a().b((byte)5, (byte)0);
                            return;
                        }
                        case 4: {
                            this.c.a(((Message)object).java_io_DataInputStream_a().readUTF());
                            return;
                        }
                        case 5: {
                            ClanGroupEntry clanGroupEntry = new ClanGroupEntry();
                            clanGroupEntry.var_int_a = ((Message)object).java_io_DataInputStream_a().readInt();
                            clanGroupEntry.var_java_lang_String_a = ((Message)object).java_io_DataInputStream_a().readUTF();
                            clanGroupEntry.b = ((Message)object).java_io_DataInputStream_a().readUTF();
                            this.c.a(clanGroupEntry);
                            return;
                        }
                        case 6: {
                            Vector<ClanMemberEntry> vector = new Vector<ClanMemberEntry>();
                            while (((Message)object).java_io_DataInputStream_a().available() > 0) {
                                byte by;
                                ClanMemberEntry vector3 = new ClanMemberEntry();
                                vector3.var_byte_a = ((Message)object).java_io_DataInputStream_a().readByte();
                                vector3.b = by = ((Message)object).java_io_DataInputStream_a().readByte();
                                ((Message)object).java_io_DataInputStream_a().readByte();
                                vector3.c = ((Message)object).java_io_DataInputStream_a().readByte();
                                vector.addElement(vector3);
                            }
                            GameCanvas.d();
                            if (ChallengeScreen.var_game_ChallengeScreen_a == null) {
                                ChallengeScreen.var_game_ChallengeScreen_a = new ChallengeScreen();
                            }
                            ChallengeScreen.var_game_ChallengeScreen_a.a(vector);
                            ChallengeScreen.var_game_ChallengeScreen_a.b_();
                            if (BattleScreen.var_game_BattleScreen_a != null) {
                                BattleScreen.f();
                            }
                            ConnectionWatchdog.game_ConnectionWatchdog_a().p();
                            return;
                        }
                        case 7: {
                            if (GameCanvas.var_game_BaseScreen_a == BoardScreen.var_game_BoardScreen_a) {
                                return;
                            }
                            Vector<EquipTemplate> vector = new Vector<EquipTemplate>();
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            while (((Message)object).java_io_DataInputStream_a().available() > 0) {
                                EquipTemplate playerAccountInfo = new EquipTemplate();
                                playerAccountInfo.var_byte_a = ((Message)object).java_io_DataInputStream_a().readByte();
                                playerAccountInfo.b = ((Message)object).java_io_DataInputStream_a().readByte();
                                playerAccountInfo.c = ((Message)object).java_io_DataInputStream_a().readByte();
                                playerAccountInfo.var_boolean_a = ((Message)object).java_io_DataInputStream_a().readBoolean();
                                playerAccountInfo.var_int_a = ((Message)object).java_io_DataInputStream_a().readInt();
                                ((Message)object).java_io_DataInputStream_a().readBoolean();
                                playerAccountInfo.var_java_lang_String_a = ((Message)object).java_io_DataInputStream_a().readUTF();
                                playerAccountInfo.d = ((Message)object).java_io_DataInputStream_a().readByte();
                                vector.addElement(playerAccountInfo);
                            }
                            GameCanvas.d();
                            if (GameHelper05.var_game_GameHelper05_a == null) {
                                GameHelper05.var_game_GameHelper05_a = new GameHelper05();
                            }
                            GameHelper05.var_game_GameHelper05_a.var_byte_a = by;
                            GameHelper05.a(vector);
                            GameHelper05.var_game_GameHelper05_a.b_();
                            if (BattleScreen.var_game_BattleScreen_a != null) {
                                BattleScreen.f();
                            }
                            System.out.println("[ca] NhanM_BOARDLIST size: " + vector.size());
                            return;
                        }
                        case 8: {
                            PlayerAccountInfo string20;
                            boolean isBauCua = false;
                            Vector<PlayerAccountInfo> vector = new Vector<PlayerAccountInfo>();
                            int n = ((Message)object).java_io_DataInputStream_a().readInt();
                            int n9 = ((Message)object).java_io_DataInputStream_a().readInt();
                            ((Message)object).java_io_DataInputStream_a().readByte();
                            ((Message)object).java_io_DataInputStream_a().readByte();
                            while (((Message)object).java_io_DataInputStream_a().available() > 0) {
                                string20 = new PlayerAccountInfo();
                                string20.var_int_a = ((Message)object).java_io_DataInputStream_a().readInt();
                                if (string20.var_int_a == -1) {
                                    string20.var_java_lang_String_a = "";
                                } else {
                                    string20.var_short_b = ((Message)object).java_io_DataInputStream_a().readShort();
                                    System.out.println("[ca] clanID= " + string20.var_short_b);
                                    string20.var_java_lang_String_a = ((Message)object).java_io_DataInputStream_a().readUTF();
                                    string20.var_long_c = ((Message)object).java_io_DataInputStream_a().readLong();
                                    System.out.println("[ca] IDDB join = " + string20.var_int_a + " name join= " + string20.var_java_lang_String_a);
                                    string20.var_int_b = (int)((Message)object).java_io_DataInputStream_a().readLong();
                                    string20.f();
                                    string20.var_byte_a = ((Message)object).java_io_DataInputStream_a().readByte();
                                    for (int i = 0; i < 5; ++i) {
                                        string20.var_short_arr_arr_a[string20.var_byte_a][i] = ((Message)object).java_io_DataInputStream_a().readShort();
                                        System.out.println("[ca] equip= " + string20.var_short_arr_arr_a[string20.var_byte_a][i]);
                                        string20.b();
                                    }
                                    string20.var_boolean_b = ((Message)object).java_io_DataInputStream_a().readBoolean();
                                    isBauCua = ((Message)object).java_io_DataInputStream_a().readBoolean();
                                }
                                vector.addElement(string20);
                                System.out.println("[ca] PLAYER SIZE===========" + vector.size());
                            }
                            GameCanvas.d();
                            BattleScreen.var_boolean_f = false;
                            if (isBauCua) {
                                ZoneScreen zoneScreen = new ZoneScreen();
                                BoardScreen.var_game_BoardScreen_a = zoneScreen;
                                ZoneScreen.instance = zoneScreen;
                                GameCanvas.var_game_ZoneScreen_a = zoneScreen;
                                zoneScreen.a(n, n9, vector);
                                zoneScreen.updateCommands();
                            } else {
                                if (BoardScreen.var_game_BoardScreen_a == null || (BoardScreen.var_game_BoardScreen_a instanceof ZoneScreen)) {
                                    BoardScreen.var_game_BoardScreen_a = new BoardScreen();
                                }
                                BoardScreen.var_game_BoardScreen_a.a(n, n9, vector);
                            }
                            for (int i = 0; i < vector.size(); ++i) {
                                string20 = (PlayerAccountInfo)vector.elementAt(i);
                                if (string20.var_int_a != n) continue;
                                string20.var_boolean_b = true;
                            }
                            BoardScreen.var_game_BoardScreen_a.b_();
                            BoardScreen.var_game_BoardScreen_a.e();
                            return;
                        }
                        case 9: {
                            int n = ((Message)object).java_io_DataInputStream_a().readInt();
                            String string = ((Message)object).java_io_DataInputStream_a().readUTF();
                            this.c.a(string, n);
                            return;
                        }
                        case 10: {
                            this.c.d(((Message)object).java_io_DataInputStream_a().readUTF());
                            return;
                        }
                        case 11: {
                            ((Message)object).java_io_DataInputStream_a().readShort();
                            int n = ((Message)object).java_io_DataInputStream_a().readInt();
                            String kickReason = ((Message)object).java_io_DataInputStream_a().readUTF();
                            this.c.a(n, kickReason);
                            System.out.println("[ca] NHAN M KICK id: " + n);
                            return;
                        }
                        case 12: {
                            PlayerAccountInfo playerAccountInfo = new PlayerAccountInfo();
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            playerAccountInfo.var_int_a = ((Message)object).java_io_DataInputStream_a().readInt();
                            playerAccountInfo.var_short_b = ((Message)object).java_io_DataInputStream_a().readShort();
                            playerAccountInfo.var_java_lang_String_a = ((Message)object).java_io_DataInputStream_a().readUTF();
                            playerAccountInfo.var_int_b = ((Message)object).java_io_DataInputStream_a().readShort();
                            playerAccountInfo.f();
                            playerAccountInfo.var_byte_a = ((Message)object).java_io_DataInputStream_a().readByte();
                            for (int i = 0; i < 5; ++i) {
                                playerAccountInfo.var_short_arr_arr_a[playerAccountInfo.var_byte_a][i] = ((Message)object).java_io_DataInputStream_a().readShort();
                                playerAccountInfo.b();
                                System.out.println("[ca] ID EQUIP= " + playerAccountInfo.var_short_arr_arr_a[playerAccountInfo.var_byte_a][i]);
                            }
                            playerAccountInfo.var_boolean_b = false;
                            BoardScreen.var_game_BoardScreen_a.a((int)by, playerAccountInfo);
                            System.out.println("[ca] " + playerAccountInfo.var_java_lang_String_a + " v\u1eeba v\u00e0o b\u00e0n.");
                            ConnectionWatchdog.game_ConnectionWatchdog_a().a(playerAccountInfo.var_short_b);
                            System.out.println("[ca] << joinBoard ID " + playerAccountInfo.var_int_a);
                            return;
                        }
                        case 14: {
                            int n = ((Message)object).java_io_DataInputStream_a().readInt();
                            int n10 = ((Message)object).java_io_DataInputStream_a().readInt();
                            System.out.println("[ca] ID leave" + n + " bop: " + n10);
                            BoardScreen.var_game_BoardScreen_a.c(n);
                            BoardScreen.var_game_BoardScreen_a.void_a(n10);
                            if (GameCanvas.var_game_BaseScreen_a == BattleScreen.var_game_BattleScreen_a) {
                                for (int i = 0; i < BattleManager.var_game_PlayerEntity_arr_a.length; ++i) {
                                    if (BattleManager.var_game_PlayerEntity_arr_a[i] == null || n != BattleManager.var_game_PlayerEntity_arr_a[i].var_int_o) continue;
                                    if (BoardScreen.var_byte_b != 7) {
                                        BattleManager.var_game_PlayerEntity_arr_a[i].var_byte_f = (byte)5;
                                        break;
                                    }
                                    BattleManager.var_game_PlayerEntity_arr_a[i] = null;
                                    break;
                                }
                            }
                            if (BoardScreen.var_byte_b != 7 && BattleScreen.var_game_GameHelper16_a != null) {
                                BattleScreen.var_game_GameHelper16_a.a(BattleManager.var_byte_a);
                            }
                            Object bl = b;
                            synchronized (bl) {
                                b.notifyAll();
                            }
                            System.out.println("[ca] << LeaveBoard ID : " + n);
                            return;
                        }
                        case 16: {
                            int n = ((Message)object).java_io_DataInputStream_a().readInt();
                            boolean bl = ((Message)object).java_io_DataInputStream_a().readBoolean();
                            this.c.a(n, bl);
                            return;
                        }
                        case 17: {
                            if (((Message)object).java_io_DataInputStream_a().readByte() != 0) break;
                            InventoryScreen.var_game_InventoryScreen_a.a(((Message)object).java_io_DataInputStream_a().readUTF());
                            return;
                        }
                        case 19: {
                            ((Message)object).java_io_DataInputStream_a().readShort();
                            int n = ((Message)object).java_io_DataInputStream_a().readInt();
                            BoardScreen.var_game_BoardScreen_a.d(n);
                            System.out.println("[ca] NHAN M - DAT TIEN CUOC: " + n);
                            return;
                        }
                        case 20: {
                            byte by;
                            BoardScreen.var_game_BoardScreen_a.var_java_util_Vector_b.removeAllElements();
                            short[] sArray = new short[5];
                            if (BattleScreen.var_boolean_f) {
                                for (by = 0; by < 5; ++by) {
                                    sArray[by] = ((Message)object).java_io_DataInputStream_a().readShort();
                                }
                            }
                            ((Message)object).java_io_DataInputStream_a().readByte();
                            by = ((Message)object).java_io_DataInputStream_a().readByte();
                            int n = ((Message)object).java_io_DataInputStream_a().readUnsignedShort();
                            int n11 = BoardScreen.var_byte_b == 7 ? (int)((Message)object).java_io_DataInputStream_a().readByte() : 8;
                            System.out.println("[ca] TEAM POINT= " + n);
                            short[] sArray2 = new short[n11];
                            short[] sArray3 = new short[n11];
                            int[] nArray = new int[n11];
                            for (int s = 0; s < n11; ++s) {
                                sArray2[s] = ((Message)object).java_io_DataInputStream_a().readShort();
                                if (sArray2[s] != -1) {
                                    sArray3[s] = ((Message)object).java_io_DataInputStream_a().readShort();
                                    nArray[s] = ((Message)object).java_io_DataInputStream_a().readInt();
                                } else {
                                    sArray3[s] = -1;
                                }
                                System.out.println("[ca] HP=" + nArray[s] + " X= " + sArray2[s] + " Y= " + sArray3[s]);
                            }
                            if (BattleScreen.var_game_BattleScreen_a == null) {
                                BattleScreen.var_game_BattleScreen_a = new BattleScreen();
                            }
                            if (!BattleScreen.var_boolean_f) {
                                BattleScreen.var_game_BattleScreen_a.a(by, sArray2, sArray3, nArray, n);
                                BattleScreen.var_game_BattleScreen_a.a(BoardScreen.var_game_BoardScreen_a);
                            } else {
                                MenuScreen.a(by, sArray2, sArray3, nArray, sArray);
                            }
                            if (BoardScreen.var_game_BoardScreen_a.var_int_arr_a[4] >= 0) {
                                ExplosionEffect.a((int)12).g = (byte)(ExplosionEffect.a((int)12).g - 1);
                            }
                            if (BoardScreen.var_game_BoardScreen_a.var_int_arr_a[5] >= 0) {
                                ExplosionEffect.a((int)13).g = (byte)(ExplosionEffect.a((int)13).g - 1);
                            }
                            if (BoardScreen.var_game_BoardScreen_a.var_int_arr_a[6] >= 0) {
                                ExplosionEffect.a((int)14).g = (byte)(ExplosionEffect.a((int)14).g - 1);
                            }
                            if (BoardScreen.var_game_BoardScreen_a.var_int_arr_a[7] >= 0) {
                                ExplosionEffect.a((int)15).g = (byte)(ExplosionEffect.a((int)15).g - 1);
                            }
                            GameCanvas.d();
                            GameCanvas.var_game_GameHelper10_a.var_boolean_a = false;
                            CharacterSelectScreen.b();
                            GameCanvas.void_a(StringUtils.ds());
                            a = true;
                            return;
                        }
                        case 21: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            short s = ((Message)object).java_io_DataInputStream_a().readShort();
                            short s2 = ((Message)object).java_io_DataInputStream_a().readShort();
                            if (by >= 0 && by < BattleManager.var_game_PlayerEntity_arr_a.length && BattleManager.var_game_PlayerEntity_arr_a[by] != null) {
                                BattleManager.var_game_PlayerEntity_arr_a[by].var_int_F = s;
                                BattleManager.var_game_PlayerEntity_arr_a[by].var_int_G = s2;
                                if (BattleManager.var_game_PlayerEntity_arr_a[by].var_int_g == s && BattleManager.var_game_PlayerEntity_arr_a[by].var_int_h == s2) {
                                    return;
                                }
                                BattleManager.a(by, s, s2);
                                if (by == BattleScreen.var_byte_b || BattleManager.var_game_PlayerEntity_arr_a[by].var_boolean_y) break;
                            }
                            Object s3 = b;
                            synchronized (s3) {
                                b.wait();
                                return;
                            }
                        }
                        case 22: 
                        case 84: {
                            int n;
                            int n2;
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            byte by10 = ((Message)object).java_io_DataInputStream_a().readByte();
                            byte by11 = ((Message)object).java_io_DataInputStream_a().readByte();
                            byte by12 = ((Message)object).java_io_DataInputStream_a().readByte();
                            short s = ((Message)object).java_io_DataInputStream_a().readShort();
                            short s4 = ((Message)object).java_io_DataInputStream_a().readShort();
                            short s5 = ((Message)object).java_io_DataInputStream_a().readShort();
                            System.out.println("[ca] TYPE SHOOT= " + by);
                            System.out.println("[ca] FIRE ARMY critical= " + by10);
                            System.out.println("[ca] X: " + s + " Y: " + s4 + " ARG:" + s5);
                            byte by3 = 0;
                            if (by12 == 17 || by12 == 19) {
                                by3 = ((Message)object).java_io_DataInputStream_a().readByte();
                                System.out.println("[ca] FORCE2= " + by3);
                            }
                            if (by12 == 14 || by12 == 40) {
                                CharacterSelectScreen.var_int_a = ((Message)object).java_io_DataInputStream_a().readByte();
                                ((Message)object).java_io_DataInputStream_a().readByte();
                                System.out.println("[ca] ANGLE1= " + CharacterSelectScreen.var_int_a);
                            }
                            if (by12 == 44 || by12 == 45 || by12 == 47) {
                                CharacterSelectScreen.var_int_a = ((Message)object).java_io_DataInputStream_a().readByte();
                                System.out.println("[ca] ANGLE2= " + CharacterSelectScreen.var_int_a);
                            }
                            byte by4 = ((Message)object).java_io_DataInputStream_a().readByte();
                            int n3 = ((Message)object).java_io_DataInputStream_a().readByte();
                            CharacterSelectScreen.f = n3;
                            System.out.println("[ca] NBULL= " + n3);
                            short[][] sArrayArray = new short[n3][];
                            short[][] sArrayArray2 = new short[n3][];
                            short[][] sArrayArray3 = new short[n3][];
                            short[][] sArrayArray4 = new short[n3][];
                            for (n2 = 0; n2 < n3; ++n2) {
                                Object n4;
                                int by16;
                                n = ((Message)object).java_io_DataInputStream_a().readShort();
                                System.out.println("[ca] LENT= " + n);
                                if (n < 0) {
                                    n = 0;
                                }
                                short[] n16 = new short[n];
                                short[] dyArr = new short[n];
                                short[] by20 = new short[n];
                                short[] by15 = new short[n];
                                if (by == 0) {
                                    for (by16 = 0; by16 < n; ++by16) {
                                        if (by16 == 0) {
                                            n16[by16] = ((Message)object).java_io_DataInputStream_a().readShort();
                                            dyArr[by16] = ((Message)object).java_io_DataInputStream_a().readShort();
                                            by20[by16] = n16[by16];
                                            by15[by16] = dyArr[by16];
                                        } else {
                                            if (by16 == n - 1 && by12 == 49) {
                                                try {
                                                    by20[by16] = ((Message)object).java_io_DataInputStream_a().readShort();
                                                    by15[by16] = ((Message)object).java_io_DataInputStream_a().readShort();
                                                    ShopScreen.var_int_a = ((Message)object).java_io_DataInputStream_a().readByte();
                                                    ShopScreen.var_int_b = ((Message)object).java_io_DataInputStream_a().readByte();
                                                    System.out.println("MGT addX: " + ShopScreen.var_int_a + " addY: " + ShopScreen.var_int_b);
                                                    System.out.println("MGT addX2: " + ShopScreen.var_int_a + " addY2: " + ShopScreen.var_int_b);
                                                }
                                                catch (Exception exception) {
                                                    exception.printStackTrace();
                                                }
                                                break;
                                            }
                                            n16[by16] = (short)((Message)object).java_io_DataInputStream_a().readByte();
                                            dyArr[by16] = (short)((Message)object).java_io_DataInputStream_a().readByte();
                                            by20[by16] = (short)(by20[by16 - 1] + n16[by16]);
                                            by15[by16] = (short)(by15[by16 - 1] + dyArr[by16]);
                                        }
                                        if (by12 != 17) continue;
                                        System.out.println("[ca] xPaint= " + by20[by16] + "yPaint= " + by15[by16]);
                                    }
                                }
                                if (by == 1) {
                                    for (by16 = 0; by16 < n; ++by16) {
                                        by20[by16] = ((Message)object).java_io_DataInputStream_a().readShort();
                                        by15[by16] = ((Message)object).java_io_DataInputStream_a().readShort();
                                    }
                                }
                                sArrayArray[n2] = by20;
                                sArrayArray2[n2] = by15;
                                if (by12 != 48) continue;
                                int n15 = ((Message)object).java_io_DataInputStream_a().readByte();
                                short[] xHit = new short[n15];
                                short[] by46 = new short[n15];
                                for (int i = 0; i < n15; ++i) {
                                    xHit[i] = ((Message)object).java_io_DataInputStream_a().readShort();
                                    by46[i] = ((Message)object).java_io_DataInputStream_a().readShort();
                                    System.out.println("[ca] xHit= " + (int)xHit[i] + " yHit=" + by46[i]);
                                }
                                sArrayArray3[n2] = xHit;
                                sArrayArray4[n2] = by46;
                            }
                            n2 = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] type sieu cao= " + n2);
                            n = -1;
                            int n5 = -1;
                            if (n2 == 1 || n2 == 2) {
                                n = ((Message)object).java_io_DataInputStream_a().readShort();
                                n5 = ((Message)object).java_io_DataInputStream_a().readShort();
                                System.out.println("[ca] xsuper= " + n + " ysuper= " + n5);
                            }
                            if (by11 >= 0 && by11 < BattleManager.var_game_PlayerEntity_arr_a.length && BattleManager.var_game_PlayerEntity_arr_a[by11] != null) {
                                BattleManager.var_game_PlayerEntity_arr_a[by11].a(by10, by11, s, s4, by12, sArrayArray, sArrayArray2, by4, by3, s5, sArrayArray3, sArrayArray4, n, n5);
                            }
                            if (GameCanvas.var_game_BaseScreen_a == BattleScreen.var_game_BattleScreen_a) {
                                synchronized (b) {
                                    b.wait();
                                    return;
                                }
                            }
                            return;
                        }
                        case 24: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            PlayerEntity.var_boolean_c = false;
                            BattleManager.a(by);
                            if (BattleScreen.var_game_CharacterSelectScreen_a != null) {
                                BattleScreen.var_game_CharacterSelectScreen_a.var_int_b = 0;
                            }
                            if (!a) break;
                            a = false;
                            GameCanvas.d();
                            return;
                        }
                        case 25: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            byte by6 = ((Message)object).java_io_DataInputStream_a().readByte();
                            BattleScreen.b((int)by, (int)by6);
                            System.out.println("[ca] Nhan Message: CHANGE WIND: " + by + " : " + by6);
                            return;
                        }
                        case 26: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            byte by7 = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] USED ITEM = " + by7);
                            BattleManager.var_game_PlayerEntity_arr_a[by].a(by7, true, 0);
                            return;
                        }
                        case 27: {
                            int n = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] inventory Update lent= " + n);
                            for (int i = 0; i < n; ++i) {
                                short sArray;
                                int n17;
                                int n18;
                                byte vector = ((Message)object).java_io_DataInputStream_a().readByte();
                                System.out.println("[ca] action= " + vector);
                                if (vector == 0) {
                                    n18 = ((Message)object).java_io_DataInputStream_a().readInt();
                                    n17 = ((Message)object).java_io_DataInputStream_a().readByte();
                                    System.out.println("[ca] nRemove= " + n17);
                                    EquipScreen.var_game_EquipScreen_a.a(n18, n17);
                                    InventoryScreen.var_game_InventoryScreen_a.a(n18, n17);
                                    continue;
                                }
                                if (vector != 2) {
                                    if (vector == 1) {
                                        sArray = ((Message)object).java_io_DataInputStream_a().readShort();
                                        String string = ((Message)object).java_io_DataInputStream_a().readUTF();
                                        String descStr = ((Message)object).java_io_DataInputStream_a().readUTF();
                                        ItemTemplate itemTemplate = new ItemTemplate();
                                        itemTemplate.var_short_a = sArray;
                                        itemTemplate.var_java_lang_String_a = string;
                                        itemTemplate.var_java_lang_String_b = descStr;
                                        itemTemplate.var_boolean_d = true;
                                        EquipScreen.a(itemTemplate, false);
                                        continue;
                                    }
                                    if (vector != 3) continue;
                                    sArray = ((Message)object).java_io_DataInputStream_a().readShort();
                                    n17 = ((Message)object).java_io_DataInputStream_a().readByte();
                                    String nameStr = ((Message)object).java_io_DataInputStream_a().readUTF();
                                    String descStr2 = ((Message)object).java_io_DataInputStream_a().readUTF();
                                    ItemTemplate bl = new ItemTemplate();
                                    bl.var_short_a = sArray;
                                    bl.var_int_b = n17;
                                    bl.var_java_lang_String_a = nameStr;
                                    bl.var_java_lang_String_b = descStr2;
                                    bl.var_boolean_d = true;
                                    EquipScreen.a(bl, true);
                                    continue;
                                }
                                n18 = ((Message)object).java_io_DataInputStream_a().readInt();
                                System.out.println("[ca] IDDB= " + n18);
                                n17 = ((Message)object).java_io_DataInputStream_a().readByte();
                                int[] abilityArr = new int[n17];
                                for (int j2 = 0; j2 < n17; ++j2) {
                                    abilityArr[j2] = ((Message)object).java_io_DataInputStream_a().readInt();
                                    System.out.println("[ca] ability= " + abilityArr[j2]);
                                }
                                sArray = ((Message)object).java_io_DataInputStream_a().readByte();
                                n17 = ((Message)object).java_io_DataInputStream_a().readByte();
                                byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                                boolean s = ((Message)object).java_io_DataInputStream_a().readBoolean();
                                String l2 = ((Message)object).java_io_DataInputStream_a().readUTF();
                                int s6 = ((Message)object).java_io_DataInputStream_a().readByte();
                                int[] l3 = new int[s6];
                                for (int string8 = 0; string8 < s6; ++string8) {
                                    l3[string8] = ((Message)object).java_io_DataInputStream_a().readInt();
                                }
                                ItemTemplate j = null;
                                if (InventoryScreen.var_game_InventoryScreen_a != null) {
                                    j = InventoryScreen.var_game_InventoryScreen_a.a(n18);
                                }
                                if (j == null && EquipScreen.var_java_util_Vector_a != null) {
                                    for (int idx = 0; idx < EquipScreen.var_java_util_Vector_a.size(); ++idx) {
                                        ItemTemplate it = (ItemTemplate)EquipScreen.var_java_util_Vector_a.elementAt(idx);
                                        if (it != null && it.var_int_a == n18) {
                                            j = it;
                                            break;
                                        }
                                    }
                                }
                                if (j == null && EquipScreen.var_game_EquipScreen_a != null) {
                                    j = EquipScreen.var_game_EquipScreen_a.a(n18);
                                }
                                if (j == null && TerrainMidlet.myInfo != null && TerrainMidlet.myInfo.var_game_EquipSlotSet_a != null && TerrainMidlet.myInfo.var_game_EquipSlotSet_a.var_game_ItemTemplate_arr_a != null) {
                                    for (int idx = 0; idx < TerrainMidlet.myInfo.var_game_EquipSlotSet_a.var_game_ItemTemplate_arr_a.length; ++idx) {
                                        ItemTemplate equipped = TerrainMidlet.myInfo.var_game_EquipSlotSet_a.var_game_ItemTemplate_arr_a[idx];
                                        if (equipped != null && equipped.var_int_a == n18) {
                                            j = equipped;
                                            break;
                                        }
                                    }
                                }
                                if (j != null) {
                                    j.a(abilityArr);
                                    j.b(abilityArr);
                                    j.var_byte_c = (byte)sArray;
                                    j.var_byte_e = (byte)n17;
                                    j.h = by;
                                    j.var_boolean_e = s;
                                    j.var_java_lang_String_c = l2;
                                    j.var_int_arr_c = l3;
                                }
                                if (GameCanvas.var_game_BaseScreen_a == InventoryScreen.var_game_InventoryScreen_a && InventoryScreen.var_game_InventoryScreen_a != null) {
                                    InventoryScreen.var_game_InventoryScreen_a.f();
                                }
                                if (GameCanvas.var_game_BaseScreen_a == EquipScreen.var_game_EquipScreen_a && EquipScreen.var_game_EquipScreen_a != null) {
                                    EquipScreen.var_game_EquipScreen_a.l();
                                }
                                PlayerAccountInfo string7 = TerrainMidlet.myInfo;
                                if (j != null && string7 != null && string7.var_game_EquipSlotSet_a != null && string7.var_game_EquipSlotSet_a.var_game_ItemTemplate_arr_a != null) {
                                    if (j.var_byte_a >= 0 && j.var_byte_a < string7.var_game_EquipSlotSet_a.var_game_ItemTemplate_arr_a.length) {
                                        if (string7.var_game_EquipSlotSet_a.var_game_ItemTemplate_arr_a[j.var_byte_a] != null && string7.var_game_EquipSlotSet_a.var_game_ItemTemplate_arr_a[j.var_byte_a].var_int_a == j.var_int_a) {
                                            string7.var_game_EquipSlotSet_a.var_game_ItemTemplate_arr_a[j.var_byte_a].b(j);
                                            string7.d();
                                        }
                                    }
                                }
                                if (EquipScreen.var_game_EquipScreen_a != null) {
                                    EquipScreen.var_game_EquipScreen_a.k();
                                }
                            }
                            if (InventoryScreen.var_game_InventoryScreen_a != null) {
                                InventoryScreen.var_game_InventoryScreen_a.e();
                            }
                            return;
                        }
                        case 29: {
                            Vector<PlayerAccountInfo> vector = new Vector<PlayerAccountInfo>();
                            while (((Message)object).java_io_DataInputStream_a().available() > 0) {
                                PlayerAccountInfo string = new PlayerAccountInfo();
                                string.var_int_a = ((Message)object).java_io_DataInputStream_a().readInt();
                                string.var_java_lang_String_a = ((Message)object).java_io_DataInputStream_a().readUTF();
                                System.out.println("[ca] name= " + string.var_java_lang_String_a);
                                string.var_long_c = ((Message)object).java_io_DataInputStream_a().readLong();
                                string.var_byte_a = ((Message)object).java_io_DataInputStream_a().readByte();
                                string.var_short_b = ((Message)object).java_io_DataInputStream_a().readShort();
                                string.var_boolean_b = ((Message)object).java_io_DataInputStream_a().readByte() != 0;
                                string.var_int_b = ((Message)object).java_io_DataInputStream_a().readShort();
                                string.var_int_c = ((Message)object).java_io_DataInputStream_a().readByte();
                                string.f();
                                short[] l = new short[5];
                                for (int i = 0; i < 5; ++i) {
                                    l[i] = ((Message)object).java_io_DataInputStream_a().readShort();
                                    string.var_short_arr_arr_a[string.var_byte_a][i] = l[i];
                                    System.out.println("[ca] id EQuip " + i + "= " + l[i]);
                                    string.b();
                                }
                                vector.addElement(string);
                            }
                            this.c.a(vector);
                            return;
                        }
                        case 32: {
                            this.c.a(((Message)object).java_io_DataInputStream_a().readByte());
                            return;
                        }
                        case 33: {
                            this.c.a(((Message)object).java_io_DataInputStream_a().readByte());
                            return;
                        }
                        case 34: {
                            if (((Message)object).java_io_DataInputStream_a().readInt() != -1) {
                                String vector = ((Message)object).java_io_DataInputStream_a().readUTF();
                                long playerAccountInfo = ((Message)object).java_io_DataInputStream_a().readLong();
                                short by = ((Message)object).java_io_DataInputStream_a().readShort();
                                byte by47 = ((Message)object).java_io_DataInputStream_a().readByte();
                                long n = ((Message)object).java_io_DataInputStream_a().readLong();
                                long s = ((Message)object).java_io_DataInputStream_a().readLong();
                                long string = ((Message)object).java_io_DataInputStream_a().readLong();
                                int n20 = ((Message)object).java_io_DataInputStream_a().readInt();
                                AchievementScreen.var_game_AchievementScreen_a.var_int_a = by;
                                AchievementScreen.var_game_AchievementScreen_a.var_int_b = by47;
                                AchievementScreen.var_game_AchievementScreen_a.var_long_a = playerAccountInfo;
                                AchievementScreen.var_game_AchievementScreen_a.var_int_c = n;
                                AchievementScreen.var_game_AchievementScreen_a.var_long_b = s;
                                AchievementScreen.var_game_AchievementScreen_a.var_long_c = string;
                                AchievementScreen.var_game_AchievementScreen_a.d = n20;
                                AchievementScreen.var_game_AchievementScreen_a.var_java_lang_String_a = ((Message)object).java_io_DataInputStream_a().readUTF();
                                if (GameCanvas.var_game_GameHelper08_a.boolean_a(TerrainMidlet.myInfo.var_short_b)) {
                                    AchievementScreen.var_game_AchievementScreen_a.var_javax_microedition_lcdui_Image_a = GameCanvas.var_game_GameHelper08_a.javax_microedition_lcdui_Image_a(TerrainMidlet.myInfo.var_short_b);
                                } else {
                                    ConnectionWatchdog.game_ConnectionWatchdog_a().a(TerrainMidlet.myInfo.var_short_b);
                                }
                                String string9 = StringUtils.dD() + ": " + vector + ". " + StringUtils.dE() + ": " + DataUtils.a(playerAccountInfo) + StringUtils.aq() + "-" + DataUtils.a((long)n) + " " + StringUtils.ar() + ". Level:" + by + "+" + by47 + "%";
                                if (GameCanvas.var_game_BaseScreen_a == BoardScreen.var_game_BoardScreen_a) {
                                    GameCanvas.void_a(string9);
                                    return;
                                }
                                GameCanvas.d();
                                AchievementScreen.var_game_AchievementScreen_a.b_();
                                return;
                            }
                            GameCanvas.void_a(StringUtils.aL());
                            return;
                        }
                        case 36: {
                            Vector<PlayerAccountInfo> vector = new Vector<PlayerAccountInfo>();
                            while (((Message)object).java_io_DataInputStream_a().available() > 0) {
                                PlayerAccountInfo object8 = new PlayerAccountInfo();
                                object8.var_int_a = ((Message)object).java_io_DataInputStream_a().readInt();
                                object8.var_java_lang_String_a = ((Message)object).java_io_DataInputStream_a().readUTF();
                                vector.addElement(object8);
                            }
                            this.c.c(vector);
                            return;
                        }
                        case 45: {
                            this.c.c(((Message)object).java_io_DataInputStream_a().readUTF());
                            return;
                        }
                        case 46: {
                            if (PlayerEntity.var_boolean_K) {
                                this.c.b(((Message)object).java_io_DataInputStream_a().readUTF());
                            }
                            return;
                        }
                        case 47: {
                            ((Message)object).java_io_DataInputStream_a().readUTF();
                            return;
                        }
                        case 48: {
                            this.c.b(((Message)object).java_io_DataInputStream_a().readUTF(), ((Message)object).java_io_DataInputStream_a().readUTF());
                            return;
                        }
                        case 50: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            ((Message)object).java_io_DataInputStream_a().readByte();
                            int n = ((Message)object).java_io_DataInputStream_a().readInt();
                            BattleScreen.var_game_BattleScreen_a.a(by, n);
                            BoardScreen.var_game_BoardScreen_a.f();
                            BoardScreen.var_game_BoardScreen_a.var_int_a = 5;
                            System.out.println("[ca] [ca] << team Win " + by + " moneyBonus " + n);
                            Object l = b;
                            synchronized (l) {
                                b.notifyAll();
                                return;
                            }
                        }
                        case 51: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] who update HP= " + by);
                            int n = ((Message)object).java_io_DataInputStream_a().readInt();
                            byte by18 = ((Message)object).java_io_DataInputStream_a().readByte();
                            if (BoardScreen.var_byte_b != 7) {
                                if (BattleManager.var_game_PlayerEntity_arr_a[by] == null) break;
                                BattleManager.var_game_PlayerEntity_arr_a[by].a(n, by18);
                                System.out.println("[ca] Nhan Message: UPDATE HP: " + by + " nextHP: " + n + " pixel= " + by18);
                                return;
                            }
                            if (BattleManager.b(by) == null) break;
                            BattleManager.b(by).a(n, by18);
                            System.out.println("[ca] Nhan Message: UPDATE HP: " + by + " nextHP: " + n + " pixel= " + by18);
                            return;
                        }
                        case 52: {
                            int n = ((Message)object).java_io_DataInputStream_a().readInt();
                            System.out.println("[ca] " + n + " whoBonus");
                            int n21 = ((Message)object).java_io_DataInputStream_a().readInt();
                            long l = ((Message)object).java_io_DataInputStream_a().readLong();
                            if (n == TerrainMidlet.myInfo.var_int_a) {
                                TerrainMidlet.myInfo.var_long_c = l;
                            }
                            if (GameCanvas.var_game_BaseScreen_a == BattleScreen.var_game_BattleScreen_a) {
                                BattleScreen.var_game_BattleScreen_a.void_a(n21, n);
                            }
                            System.out.println("[ca] << BonusMoney ID " + n + " Money " + n21);
                            return;
                        }
                        case 53: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            short s = ((Message)object).java_io_DataInputStream_a().readShort();
                            short s6 = ((Message)object).java_io_DataInputStream_a().readShort();
                            BattleManager.c(by, s, s6);
                            BattleManager.var_game_PlayerEntity_arr_a[by].var_byte_g = (byte)-1;
                            return;
                        }
                        case 59: {
                            BattleScreen.b(((Message)object).java_io_DataInputStream_a().readByte());
                            return;
                        }
                        case 63: {
                            String string = ((Message)object).java_io_DataInputStream_a().readUTF();
                            String string2 = ((Message)object).java_io_DataInputStream_a().readUTF();
                            String string3 = ((Message)object).java_io_DataInputStream_a().readUTF();
                            GameCanvas.b(string, new ActionListener165(string2, string3));
                            System.out.println("[ca] text: " + string + "    data: " + string2 + "    to: " + string3);
                            return;
                        }
                        case 64: {
                            int n;
                            int n6;
                            int n7;
                            int n8;
                            int n9;
                            int n10 = ((Message)object).java_io_DataInputStream_a().readByte();
                            byte[] byArray = new byte[n10];
                            for (n9 = 0; n9 < n10; ++n9) {
                                byArray[n9] = ((Message)object).java_io_DataInputStream_a().readByte();
                            }
                            n9 = ((Message)object).java_io_DataInputStream_a().readByte();
                            short[] sArray = new short[n9];
                            for (n8 = 0; n8 < n9; ++n8) {
                                sArray[n8] = ((Message)object).java_io_DataInputStream_a().readShort();
                            }
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            n8 = by;
                            byte[] byArray2 = new byte[by];
                            for (n7 = 0; n7 < n8; ++n7) {
                                byArray2[n7] = ((Message)object).java_io_DataInputStream_a().readByte();
                            }
                            byte by8 = ((Message)object).java_io_DataInputStream_a().readByte();
                            n7 = by8;
                            byte[] byArray3 = new byte[by8];
                            for (n6 = 0; n6 < n7; ++n6) {
                                byArray3[n6] = ((Message)object).java_io_DataInputStream_a().readByte();
                            }
                            BattleManager.var_int_a = ((Message)object).java_io_DataInputStream_a().readByte();
                            byte by9 = ((Message)object).java_io_DataInputStream_a().readByte();
                            n6 = by9;
                            BoardScreen.var_byte_arr_a = new byte[by9];
                            for (n = 0; n < n6; ++n) {
                                BoardScreen.var_byte_arr_a[n] = ((Message)object).java_io_DataInputStream_a().readByte();
                            }
                            BoardScreen.var_byte_arr_b = new byte[n6];
                            for (n = 0; n < n6; ++n) {
                                BoardScreen.var_byte_arr_b[n] = ((Message)object).java_io_DataInputStream_a().readByte();
                            }
                            BattleManager.var_int_b = ((Message)object).java_io_DataInputStream_a().readByte();
                            ShopScreen.var_byte_arr_a = byArray;
                            PlayerEntity.var_short_arr_a = sArray;
                            ChatEntity.var_byte_arr_b = byArray2;
                            ChatEntity.c = byArray3;
                            ChatEntity.var_game_ChatEntity_a = new ChatEntity();
                            ChallengeScreen.var_game_ChallengeScreen_a = new ChallengeScreen();
                            return;
                        }
                        case 69: {
                            int n = ((Message)object).java_io_DataInputStream_a().readInt();
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            GameCanvas.d();
                            if (n == TerrainMidlet.myInfo.var_int_a) {
                                TerrainMidlet.myInfo.var_byte_a = by;
                            }
                            ChatEntity.var_game_ChatEntity_a.f();
                            System.out.println("[ca] << change player " + by);
                            return;
                        }
                        case 71: {
                            this.c.a(((Message)object).java_io_DataInputStream_a().readInt(), ((Message)object).java_io_DataInputStream_a().readByte());
                            return;
                        }
                        case 72: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] nITEM BUY= " + by);
                            byte[] byArray = new byte[by];
                            int[] nArray = new int[by];
                            for (int i = 0; i < by; ++i) {
                                byArray[i] = ((Message)object).java_io_DataInputStream_a().readByte();
                                nArray[i] = ((Message)object).java_io_DataInputStream_a().readInt();
                            }
                            long l = ((Message)object).java_io_DataInputStream_a().readLong();
                            long n = ((Message)object).java_io_DataInputStream_a().readLong();
                            ExplosionEffect.a(by, byArray, nArray, l, n);
                            return;
                        }
                        case 74: {
                            ChatEntity.var_byte_arr_a[((Message)object).java_io_DataInputStream_a().readByte() + ChatEntity.var_int_b] = 1;
                            ChatEntity.var_game_ChatEntity_a.e();
                            GameCanvas.d();
                            return;
                        }
                        case 75: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] Map ID = " + by);
                            GameCanvas.var_game_BaseScreen_a = BoardScreen.var_game_BoardScreen_a;
                            BoardScreen.var_game_BoardScreen_a.f();
                            BoardScreen.var_byte_c = by;
                            if (by != 27 && by != 100) {
                                GameCanvas.c(StringUtils.ds());
                                GameHelper34.var_java_util_Vector_a.removeAllElements();
                                BattleScreen.var_game_GameHelper34_a.void_a(by);
                            }
                            if (BattleScreen.var_java_lang_String_a.equals("")) break;
                            ConnectionWatchdog.game_ConnectionWatchdog_a().k((byte)-3);
                            return;
                        }
                        case 76: {
                            BoardScreen.var_byte_a = ((Message)object).java_io_DataInputStream_a().readByte();
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            String string = ((Message)object).java_io_DataInputStream_a().readUTF();
                            BoardScreen.var_byte_b = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] roomId=" + BoardScreen.var_byte_a + " boardID= " + by + " boardName= " + string + " type=" + BoardScreen.var_byte_b);
                            GameHelper05.a(by, string);
                            return;
                        }
                        case 78: {
                            if (!((Message)object).java_io_DataInputStream_a().readBoolean()) {
                                if (DataUtils.int_a("blockInvite") == 1) {
                                    return;
                                }
                                String string = ((Message)object).java_io_DataInputStream_a().readUTF();
                                byte n = ((Message)object).java_io_DataInputStream_a().readByte();
                                byte by21 = ((Message)object).java_io_DataInputStream_a().readByte();
                                String msgStr = ((Message)object).java_io_DataInputStream_a().readUTF();
                                GameCanvas.a(string, new ActionListener207(n, by21, msgStr), new ActionListener011());
                                return;
                            }
                            int n = ((Message)object).java_io_DataInputStream_a().readByte();
                            Vector<PlayerAccountInfo> vector = new Vector<PlayerAccountInfo>();
                            for (int object9 = 0; object9 < n; ++object9) {
                                PlayerAccountInfo n11 = new PlayerAccountInfo();
                                n11.var_java_lang_String_a = ((Message)object).java_io_DataInputStream_a().readUTF();
                                n11.var_int_a = ((Message)object).java_io_DataInputStream_a().readInt();
                                n11.var_byte_a = ((Message)object).java_io_DataInputStream_a().readByte();
                                n11.var_long_c = ((Message)object).java_io_DataInputStream_a().readLong();
                                n11.var_int_b = (int)((Message)object).java_io_DataInputStream_a().readLong();
                                n11.var_int_c = ((Message)object).java_io_DataInputStream_a().readUnsignedByte();
                                for (int i = 0; i < 5; ++i) {
                                    n11.var_short_arr_arr_a[n11.var_byte_a][i] = ((Message)object).java_io_DataInputStream_a().readShort();
                                }
                                n11.f();
                                n11.b();
                                n11.var_boolean_b = true;
                                vector.addElement(n11);
                            }
                            GameCanvas.d();
                            ServerManager.b(vector);
                            return;
                        }
                        case 80: {
                            BattleScreen.void_a(((Message)object).java_io_DataInputStream_a().readByte());
                            return;
                        }
                        case 83: {
                            MenuScreen.var_game_MenuScreen_a.b_();
                            BattleScreen.f();
                            Object string10 = b;
                            synchronized (string10) {
                                b.notify();
                                return;
                            }
                        }
                        case 86: {
                            String string = ((Message)object).java_io_DataInputStream_a().readUTF();
                            String string4 = ((Message)object).java_io_DataInputStream_a().readUTF();
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            this.c.a(string, string4, by);
                            System.out.println("[ca] B= " + string4);
                            return;
                        }
                        case 87: {
                            String myName = ((Message)object).java_io_DataInputStream_a().readUTF();
                            System.out.println("[ca] myName= " + myName);
                            TerrainMidlet.myInfo.var_java_lang_String_a = myName;
                            return;
                        }
                        case 88: {
                            int n = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] len= " + n);
                            ChallengeScreen.var_java_lang_String_arr_a = new String[n];
                            for (int n12 = 0; n12 < n; ++n12) {
                                String sArray = ((Message)object).java_io_DataInputStream_a().readUTF();
                                ((Message)object).java_io_DataInputStream_a().readUTF();
                                ChallengeScreen.var_java_lang_String_arr_a[n12] = sArray;
                            }
                            return;
                        }
                        case 89: {
                            int n = ((Message)object).java_io_DataInputStream_a().readByte();
                            short[] sArray = new short[n];
                            short[] sArray4 = new short[n];
                            int n13 = -1;
                            for (int object10 = 0; object10 < n; ++object10) {
                                PlayerAccountInfo by = new PlayerAccountInfo();
                                by.var_int_a = ((Message)object).java_io_DataInputStream_a().readInt();
                                by.var_java_lang_String_a = ((Message)object).java_io_DataInputStream_a().readUTF();
                                by.h = ((Message)object).java_io_DataInputStream_a().readInt();
                                by.var_byte_a = ((Message)object).java_io_DataInputStream_a().readByte();
                                n13 = by.var_byte_a;
                                by.var_boolean_a = true;
                                sArray[object10] = ((Message)object).java_io_DataInputStream_a().readShort();
                                sArray4[object10] = ((Message)object).java_io_DataInputStream_a().readShort();
                                by.var_byte_b = (byte)object10;
                                System.out.println("[ca] send Boss index= " + by.var_byte_b + " nvUser: " + by.var_byte_a);
                                if (BoardScreen.var_game_BoardScreen_a != null && BoardScreen.var_game_BoardScreen_a.var_java_util_Vector_b != null) {
                                    BoardScreen.var_game_BoardScreen_a.var_java_util_Vector_b.addElement(by);
                                }
                            }
                            if (BattleScreen.var_game_BattleManager_a != null) {
                                BattleScreen.var_game_BattleManager_a.a(sArray, sArray4);
                            }
                            if (n13 != 23 && n13 != 24) break;
                            Object byArray = b;
                            synchronized (byArray) {
                                b.wait();
                                return;
                            }
                        }
                        case 90: {
                            switch (((Message)object).java_io_DataInputStream_a().readByte()) {
                                case 1: {
                                    byte n = ((Message)object).java_io_DataInputStream_a().readByte();
                                    if (n != GameCanvas.var_byte_a) {
                                        int n14 = ((Message)object).java_io_DataInputStream_a().readUnsignedShort();
                                        byte[] byArray = new byte[n14];
                                        System.out.println(new StringBuffer("[ca] minimap lent= ").append(n14));
                                        ((Message)object).java_io_DataInputStream_a().read(byArray, 0, n14);
                                        BoardScreen.a(byArray);
                                        GameCanvas.a("iconversion2", n);
                                        GameCanvas.a("icondata2", byArray);
                                    }
                                    GameSetting.var_int_b = 45;
                                    GameSetting.var_int_c = 60;
                                    ConnectionWatchdog.game_ConnectionWatchdog_a().b((byte)3, GameCanvas.var_byte_c);
                                    return;
                                }
                                case 2: {
                                    GameSetting.var_boolean_a = true;
                                    byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                                    if (by != GameCanvas.var_byte_b) {
                                        GameCanvas.c(StringUtils.aC());
                                        byte[] byArray = new byte[((Message)object).java_io_DataInputStream_a().readUnsignedShort()];
                                        ((Message)object).java_io_DataInputStream_a().read(byArray, 0, byArray.length);
                                        GameCanvas.a(byArray, (byte)0);
                                        GameCanvas.a("valuesdata2", byArray);
                                        GameCanvas.a("valuesversion2", by);
                                    } else {
                                        GameCanvas.c(StringUtils.ds());
                                        GameSetting.var_boolean_a = false;
                                    }
                                    GameSetting.var_int_b = 15;
                                    GameSetting.var_int_c = 30;
                                    ConnectionWatchdog.game_ConnectionWatchdog_a().b((byte)1, (byte)0);
                                    return;
                                }
                                case 3: {
                                    byte s = ((Message)object).java_io_DataInputStream_a().readByte();
                                    if (s != GameCanvas.var_byte_c) {
                                        int by = ((Message)object).java_io_DataInputStream_a().readUnsignedShort();
                                        byte[] n = new byte[by];
                                        ((Message)object).java_io_DataInputStream_a().read(n, 0, by);
                                        PlayerEntity.a(n);
                                        GameCanvas.a("playerVersion2", s);
                                        GameCanvas.a("playerdata2", n);
                                    }
                                    GameSetting.var_int_b = 60;
                                    GameSetting.var_int_c = 75;
                                    ConnectionWatchdog.game_ConnectionWatchdog_a().b((byte)4, GameCanvas.var_byte_d);
                                    return;
                                }
                                case 4: {
                                    byte s7 = ((Message)object).java_io_DataInputStream_a().readByte();
                                    ((Message)object).java_io_DataInputStream_a().readInt();
                                    if (s7 != GameCanvas.var_byte_d) {
                                        int i = ((Message)object).java_io_DataInputStream_a().readInt();
                                        byte[] byArray = new byte[i];
                                        ((Message)object).java_io_DataInputStream_a().read(byArray, 0, i);
                                        GameCanvas.a(byArray, (byte)1);
                                        GameCanvas.a("equipVersion2", s7);
                                        GameCanvas.a("equipdata2", byArray);
                                        System.out.println(new StringBuffer("[ca] file lent= ").append(i));
                                    }
                                    GameSetting.var_int_b = 75;
                                    GameSetting.var_int_c = 90;
                                    ConnectionWatchdog.game_ConnectionWatchdog_a().b((byte)5, GameCanvas.var_byte_e);
                                    return;
                                }
                                case 5: {
                                    byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                                    if (by == GameCanvas.var_byte_e) {
                                        for (int n = 0; n < GameCanvas.i; ++n) {
                                            byte[] byArray = GameCanvas.byte_arr_a("bigImage" + n);
                                            EquipSlotSet.var_javax_microedition_lcdui_Image_arr_a[n] = Image.createImage((byte[])byArray, (int)0, (int)byArray.length);
                                        }
                                        ConnectionWatchdog.game_ConnectionWatchdog_a().b((byte)6, (byte)0);
                                        GameCanvas.d();
                                        this.c.d();
                                        return;
                                    }
                                    int object11 = ((Message)object).java_io_DataInputStream_a().readUnsignedShort();
                                    byte[] object12 = new byte[object11];
                                    ((Message)object).java_io_DataInputStream_a().read(object12, 0, object11);
                                    GameCanvas.a(object12, (byte)2);
                                    GameCanvas.a("levelCVersion2", by);
                                    GameCanvas.a("levelCData2", object12);
                                    for (int by23 = 0; by23 < GameCanvas.i; ++by23) {
                                        ConnectionWatchdog.game_ConnectionWatchdog_a().j((byte)by23);
                                    }
                                    return;
                                }
                            }
                            return;
                        }
                        case 92: {
                            int n = ((Message)object).java_io_DataInputStream_a().readShort();
                            GameHelper34.var_short_arr_a = new short[n];
                            for (int i = 0; i < n; ++i) {
                                GameHelper34.var_short_arr_a[i] = ((Message)object).java_io_DataInputStream_a().readShort();
                            }
                            return;
                        }
                        case 93: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            short s = ((Message)object).java_io_DataInputStream_a().readShort();
                            short s7 = ((Message)object).java_io_DataInputStream_a().readShort();
                            System.out.println("[ca] FLY  x= " + s + " y= " + s7);
                            BattleManager.b(by, s, s7);
                            if (BattleScreen.var_game_GameHelper16_a != null) {
                                BattleScreen.var_game_GameHelper16_a.a(by);
                            }
                            if (GameCanvas.var_game_BaseScreen_a != BattleScreen.var_game_BattleScreen_a) break;
                            Object by22 = b;
                            synchronized (by22) {
                                b.wait();
                                return;
                            }
                        }
                        case 94: {
                            ConnectionWatchdog.game_ConnectionWatchdog_a().a(BoardScreen.var_game_BoardScreen_a.var_int_arr_a);
                            return;
                        }
                        case 95: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            byte by10 = ((Message)object).java_io_DataInputStream_a().readByte();
                            BattleManager.var_game_PlayerEntity_arr_a[by].a(by10);
                            if (GameCanvas.var_game_BaseScreen_a != BattleScreen.var_game_BattleScreen_a) break;
                            Object by48 = b;
                            synchronized (by48) {
                                b.wait();
                                return;
                            }
                        }
                        case 96: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            byte by11 = ((Message)object).java_io_DataInputStream_a().readByte();
                            BattleManager.var_game_PlayerEntity_arr_a[by11].var_boolean_z = true;
                            BattleManager.var_game_PlayerEntity_arr_a[by11].var_boolean_A = true;
                            BattleManager.var_game_PlayerEntity_arr_a[by].var_int_v = 3;
                            if (GameCanvas.var_game_BaseScreen_a != BattleScreen.var_game_BattleScreen_a) break;
                            Object n = b;
                            synchronized (n) {
                                b.wait();
                                return;
                            }
                        }
                        case 97: {
                            short object14;
                            int n = ((Message)object).java_io_DataInputStream_a().readInt();
                            TerrainMidlet.myInfo.var_long_a = ((Message)object).java_io_DataInputStream_a().readLong();
                            TerrainMidlet.myInfo.var_long_b = ((Message)object).java_io_DataInputStream_a().readLong();
                            System.out.println(new StringBuffer("[ca] expAdd= ").append(n));
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            if (by == 0) {
                                TerrainMidlet.myInfo.var_int_c = ((Message)object).java_io_DataInputStream_a().readByte();
                                System.out.println(new StringBuffer("[ca] percen 0 = ").append(TerrainMidlet.myInfo.var_int_c));
                            }
                            if (GameCanvas.var_game_BaseScreen_a == BattleScreen.var_game_BattleScreen_a && BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b] != null) {
                                BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b].c(n);
                            }
                            if (by != 1) break;
                            short s8 = ((Message)object).java_io_DataInputStream_a().readShort();
                            by = ((Message)object).java_io_DataInputStream_a().readByte();
                            TerrainMidlet.myInfo.var_short_a = object14 = ((Message)object).java_io_DataInputStream_a().readShort();
                            System.out.println(new StringBuffer("[ca] currLevel= ").append(s8).append(" currPoint= ").append(object14));
                            TerrainMidlet.myInfo.var_int_b = s8;
                            TerrainMidlet.myInfo.var_int_c = by;
                            System.out.println(new StringBuffer("[ca] percen 1 = ").append(TerrainMidlet.myInfo.var_int_c));
                            return;
                        }
                        case 99: {
                            TerrainMidlet.myInfo.var_int_b = ((Message)object).java_io_DataInputStream_a().readShort();
                            TerrainMidlet.myInfo.var_int_c = ((Message)object).java_io_DataInputStream_a().readByte();
                            TerrainMidlet.myInfo.f();
                            System.out.println(new StringBuffer("[ca] level=").append(TerrainMidlet.myInfo.var_int_b));
                            TerrainMidlet.myInfo.var_short_a = ((Message)object).java_io_DataInputStream_a().readShort();
                            for (int i = 0; i < 5; ++i) {
                                TerrainMidlet.myInfo.var_short_arr_a[i] = ((Message)object).java_io_DataInputStream_a().readShort();
                                System.out.println(new StringBuffer("[ca] my ability= ").append(TerrainMidlet.myInfo.var_short_arr_a[i]));
                            }
                            TerrainMidlet.myInfo.var_long_a = ((Message)object).java_io_DataInputStream_a().readLong();
                            TerrainMidlet.myInfo.var_long_b = ((Message)object).java_io_DataInputStream_a().readLong();
                            TerrainMidlet.myInfo.var_int_d = ((Message)object).java_io_DataInputStream_a().readInt();
                            TerrainMidlet.myInfo.a();
                            if (!MenuScreen.var_boolean_a) break;
                            MenuScreen.var_boolean_a = false;
                            GameCanvas.d();
                            if (CharacterUpgradeScreen.var_game_CharacterUpgradeScreen_a == null) {
                                CharacterUpgradeScreen.var_game_CharacterUpgradeScreen_a = new CharacterUpgradeScreen();
                            }
                            CharacterUpgradeScreen.var_game_CharacterUpgradeScreen_a.a(MenuScreen.var_game_MenuScreen_a);
                            return;
                        }
                        case 100: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] Lucky " + by);
                            BattleManager.var_game_PlayerEntity_arr_a[by].e();
                            Object vector = b;
                            synchronized (vector) {
                                b.wait();
                                return;
                            }
                        }
                        case 101: {
                            int by;
                            int j;
                            InventoryScreen.var_game_InventoryScreen_a = new InventoryScreen();
                            Vector<ItemTemplate> by49 = new Vector<ItemTemplate>();
                            PlayerAccountInfo playerAccountInfo = TerrainMidlet.myInfo;
                            int i = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] lent byte= " + i);
                            for (j = 0; j < i; ++j) {
                                int n34;
                                by = ((Message)object).java_io_DataInputStream_a().readInt();
                                byte by29 = ((Message)object).java_io_DataInputStream_a().readByte();
                                byte s = ((Message)object).java_io_DataInputStream_a().readByte();
                                short string = ((Message)object).java_io_DataInputStream_a().readShort();
                                String string21 = ((Message)object).java_io_DataInputStream_a().readUTF();
                                int n31 = ((Message)object).java_io_DataInputStream_a().readByte();
                                int[] n33 = new int[n31];
                                for (n34 = 0; n34 < n31; ++n34) {
                                    n33[n34] = ((Message)object).java_io_DataInputStream_a().readInt();
                                }
                                n31 = ((Message)object).java_io_DataInputStream_a().readByte();
                                byte by26 = ((Message)object).java_io_DataInputStream_a().readByte();
                                byte by27 = ((Message)object).java_io_DataInputStream_a().readByte();
                                n34 = ((Message)object).java_io_DataInputStream_a().readUnsignedByte();
                                byte by30 = ((Message)object).java_io_DataInputStream_a().readByte();
                                boolean itemTemplate = ((Message)object).java_io_DataInputStream_a().readBoolean();
                                String nArray3 = ((Message)object).java_io_DataInputStream_a().readUTF();
                                int numHoles = ((Message)object).java_io_DataInputStream_a().readByte();
                                int[] itemTemplate3 = new int[numHoles];
                                for (int playerAccountInfo3 = 0; playerAccountInfo3 < numHoles; ++playerAccountInfo3) {
                                    itemTemplate3[playerAccountInfo3] = ((Message)object).java_io_DataInputStream_a().readInt();
                                }
                                System.out.println("[ca] vip I= " + by27 + " level= " + n34);
                                ItemTemplate i3 = EquipSlotSet.b(by29, s, string);
                                EquipSlotSet.b(by29, s, string).var_int_g = n34;
                                ItemTemplate newTemplate = new ItemTemplate();
                                i3.var_byte_e = (byte)n31;
                                i3.var_java_lang_String_a = string21;
                                newTemplate.var_short_a = i3.var_short_a;
                                newTemplate.var_short_arr_a = i3.var_short_arr_a;
                                newTemplate.var_short_arr_b = i3.var_short_arr_b;
                                newTemplate.var_byte_arr_a = i3.var_byte_arr_a;
                                newTemplate.var_byte_arr_b = i3.var_byte_arr_b;
                                newTemplate.var_byte_arr_c = i3.var_byte_arr_c;
                                newTemplate.var_byte_arr_d = i3.var_byte_arr_d;
                                newTemplate.var_short_b = i3.var_short_b;
                                newTemplate.var_byte_a = i3.var_byte_a;
                                newTemplate.var_byte_b = by29;
                                newTemplate.var_byte_e = i3.var_byte_e;
                                newTemplate.var_java_lang_String_a = i3.var_java_lang_String_a + (i3.var_int_g == 0 ? "" : " " + i3.var_int_g);
                                newTemplate.var_int_a = by;
                                newTemplate.var_byte_f = i3.var_byte_f;
                                newTemplate.h = by30;
                                newTemplate.var_boolean_e = itemTemplate;
                                newTemplate.var_java_lang_String_c = nArray3;
                                newTemplate.var_int_arr_c = itemTemplate3;
                                System.out.println("[ca] tam level= " + newTemplate.var_byte_f);
                                newTemplate.var_byte_c = by26;
                                newTemplate.var_byte_d = by27;
                                playerAccountInfo.b();
                                newTemplate.void_b();
                                newTemplate.a(n33);
                                by49.addElement(newTemplate);
                            }
                            for (j = 0; j < 5; ++j) {
                                by = ((Message)object).java_io_DataInputStream_a().readInt();
                                System.out.println("[ca] MY DB KEY= " + by);
                                if (playerAccountInfo.var_game_EquipSlotSet_a.var_game_ItemTemplate_arr_a[j] == null) continue;
                                playerAccountInfo.var_game_EquipSlotSet_a.var_game_ItemTemplate_arr_a[j].var_int_a = by;
                                playerAccountInfo.var_int_arr_c[j] = by;
                            }
                            if (EquipScreen.var_game_EquipScreen_a == null) {
                                EquipScreen.var_game_EquipScreen_a = new EquipScreen();
                            }
                            EquipScreen.a(by49);
                            return;
                        }
                        case 102: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("action= " + by);
                            if (by == 0) {
                                GameCanvas.d();
                                EquipScreen.var_game_EquipScreen_a.h();
                                MenuScreen.var_game_MenuScreen_a.b_();
                            }
                            if (by == 1) {
                                EquipScreen.var_game_EquipScreen_a.i();
                                MenuScreen.var_game_MenuScreen_a.b_();
                                GameCanvas.d();
                            }
                            if (by != 2) break;
                            PlayerAccountInfo vector = TerrainMidlet.myInfo;
                            for (int n = 0; n < 10; ++n) {
                                for (int i = 0; i < 5; ++i) {
                                    vector.var_short_arr_arr_a[n][i] = ((Message)object).java_io_DataInputStream_a().readShort();
                                    if (n != 0) continue;
                                    System.out.println("[ca] my equip= " + vector.var_short_arr_arr_a[n][i]);
                                }
                            }
                            if (GameCanvas.var_game_BaseScreen_a != InventoryScreen.var_game_InventoryScreen_a) {
                                EquipScreen.var_game_EquipScreen_a.j();
                                EquipScreen.var_game_EquipScreen_a.a(MenuScreen.var_game_MenuScreen_a);
                                return;
                            }
                            break block342;
                        }
                        case 103: {
                            Vector<ItemTemplate> by32 = new Vector<ItemTemplate>();
                            int n35 = ((Message)object).java_io_DataInputStream_a().readShort();
                            for (int by33 = 0; by33 < n35; ++by33) {
                                byte s = ((Message)object).java_io_DataInputStream_a().readByte();
                                byte string22 = ((Message)object).java_io_DataInputStream_a().readByte();
                                short nArray = ((Message)object).java_io_DataInputStream_a().readShort();
                                String n37 = ((Message)object).java_io_DataInputStream_a().readUTF();
                                int by34 = ((Message)object).java_io_DataInputStream_a().readInt();
                                int bl = ((Message)object).java_io_DataInputStream_a().readInt();
                                byte string12 = ((Message)object).java_io_DataInputStream_a().readByte();
                                byte by31 = ((Message)object).java_io_DataInputStream_a().readByte();
                                ItemTemplate n38 = EquipSlotSet.a(s, string22, nArray);
                                if (n38 == null) continue;
                                n38.var_java_lang_String_a = n37;
                                n38.var_byte_e = string12;
                                n38.var_int_e = by34;
                                n38.var_int_f = bl;
                                n38.var_byte_f = by31;
                                n38.var_byte_b = s;
                                n38.var_boolean_c = false;
                                n38.var_int_d = by33;
                                by32.addElement(n38);
                            }
                            if (ItemEffect.var_game_ItemEffect_a == null) {
                                ItemEffect.var_game_ItemEffect_a = new ItemEffect();
                            }
                            ItemEffect.var_game_ItemEffect_a.a(by32);
                            MenuScreen.var_game_MenuScreen_a.g();
                            GameCanvas.d();
                            return;
                        }
                        case 104: {
                            int n43;
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] action= " + by);
                            if (by == 0) {
                                int playerAccountInfo = ((Message)object).java_io_DataInputStream_a().readInt();
                                byte by12 = ((Message)object).java_io_DataInputStream_a().readByte();
                                byte by13 = ((Message)object).java_io_DataInputStream_a().readByte();
                                short vector = ((Message)object).java_io_DataInputStream_a().readShort();
                                String n = ((Message)object).java_io_DataInputStream_a().readUTF();
                                int n36 = ((Message)object).java_io_DataInputStream_a().readByte();
                                int[] questReward = new int[n36];
                                for (int i = 0; i < n36; ++i) {
                                    questReward[i] = ((Message)object).java_io_DataInputStream_a().readInt();
                                    System.out.println("[ca] ability = " + questReward[i]);
                                }
                                n43 = ((Message)object).java_io_DataInputStream_a().readByte();
                                n36 = ((Message)object).java_io_DataInputStream_a().readByte();
                                int byArray = ((Message)object).java_io_DataInputStream_a().readUnsignedByte();
                                byte image = ((Message)object).java_io_DataInputStream_a().readByte();
                                boolean equipItemEntry = ((Message)object).java_io_DataInputStream_a().readBoolean();
                                String by50 = ((Message)object).java_io_DataInputStream_a().readUTF();
                                int vector2 = ((Message)object).java_io_DataInputStream_a().readByte();
                                int[] n44 = new int[vector2];
                                for (int itemTemplate = 0; itemTemplate < vector2; ++itemTemplate) {
                                    n44[itemTemplate] = ((Message)object).java_io_DataInputStream_a().readInt();
                                }
                                System.out.println("[ca] 2 level 2= " + byArray);
                                ItemTemplate i = EquipSlotSet.a(by12, by13, vector);
                                i.a(questReward);
                                ItemTemplate vector3 = new ItemTemplate();
                                PlayerAccountInfo playerAccountInfo2 = TerrainMidlet.myInfo;
                                vector3.var_short_a = i.var_short_a;
                                vector3.var_byte_a = i.var_byte_a;
                                vector3.var_short_b = i.var_short_b;
                                vector3.var_byte_b = i.var_byte_b;
                                vector3.var_short_arr_a = i.var_short_arr_a;
                                vector3.var_short_arr_b = i.var_short_arr_b;
                                vector3.var_byte_arr_a = i.var_byte_arr_a;
                                vector3.var_byte_arr_b = i.var_byte_arr_b;
                                vector3.var_byte_arr_c = i.var_byte_arr_c;
                                vector3.var_byte_arr_d = i.var_byte_arr_d;
                                vector3.var_byte_e = (byte)n43;
                                vector3.var_java_lang_String_a = n + (byArray == 0 ? "" : " " + byArray);
                                vector3.var_int_a = playerAccountInfo;
                                vector3.var_byte_f = i.var_byte_f;
                                vector3.var_byte_d = (byte)n36;
                                vector3.var_byte_c = (byte)3;
                                vector3.h = image;
                                vector3.var_boolean_e = equipItemEntry;
                                vector3.var_java_lang_String_c = by50;
                                vector3.var_int_arr_c = n44;
                                for (int sArray = 0; sArray < 5; ++sArray) {
                                    vector3.var_short_arr_c[sArray] = i.var_short_arr_c[sArray];
                                    vector3.var_int_arr_a[sArray] = i.var_int_arr_a[sArray];
                                    vector3.var_int_arr_b[sArray] = i.var_int_arr_b[sArray];
                                }
                                if (playerAccountInfo2.var_game_EquipSlotSet_a.var_game_ItemTemplate_arr_a[vector3.var_byte_a] != null && playerAccountInfo2.var_game_EquipSlotSet_a.var_game_ItemTemplate_arr_a[vector3.var_byte_a].var_short_a == vector3.var_short_a) {
                                    playerAccountInfo2.var_game_EquipSlotSet_a.var_game_ItemTemplate_arr_a[vector3.var_byte_a].var_int_a = playerAccountInfo;
                                }
                                EquipScreen.var_game_EquipScreen_a.b(vector3);
                            }
                            if (by == 1) {
                                String string = ((Message)object).java_io_DataInputStream_a().readUTF();
                                InventoryScreen.var_game_InventoryScreen_a.b(string);
                            }
                            if (by != 2) break;
                            PlayerAccountInfo l = TerrainMidlet.myInfo;
                            for (int by12 = 0; by12 < 10; ++by12) {
                                for (int col = 0; col < 5; ++col) {
                                    l.var_short_arr_arr_a[by12][col] = ((Message)object).java_io_DataInputStream_a().readShort();
                                }
                            }
                            return;
                        }
                        case 105: {
                            long l = ((Message)object).java_io_DataInputStream_a().readLong();
                            long n = ((Message)object).java_io_DataInputStream_a().readLong();
                            TerrainMidlet.myInfo.var_long_c = l;
                            TerrainMidlet.myInfo.e = n;
                            return;
                        }
                        case 106: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            BattleScreen.a(((Message)object).java_io_DataInputStream_a().readByte(), by);
                            return;
                        }
                        case 107: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            BattleScreen.b(((Message)object).java_io_DataInputStream_a().readByte(), by);
                            return;
                        }
                        case 108: {
                            BattleScreen.c(((Message)object).java_io_DataInputStream_a().readByte());
                            return;
                        }
                        case 109: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            byte by35 = ((Message)object).java_io_DataInputStream_a().readByte();
                            if (by == 0) {
                                int n = ((Message)object).java_io_DataInputStream_a().readInt();
                                int n39 = ((Message)object).java_io_DataInputStream_a().readInt();
                                BattleScreen.a(new ServerInfo(by35, n, n39));
                            }
                            if (by != 1) break;
                            BattleScreen.a((int)by35);
                            return;
                        }
                        case 110: {
                            Vector<QuestReward> vector = new Vector<QuestReward>();
                            for (int i = 0; i < 10; ++i) {
                                byte by36 = ((Message)object).java_io_DataInputStream_a().readByte();
                                byte byRewardType = ((Message)object).java_io_DataInputStream_a().readByte();
                                int object15 = ((Message)object).java_io_DataInputStream_a().readInt();
                                QuestReward s9 = new QuestReward(by36, byRewardType, object15);
                                vector.addElement(s9);
                            }
                            byte luckyNum = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] LUCKY NUMB= " + luckyNum);
                            GameCanvas.d();
                            LuckyDrawScreen.var_game_LuckyDrawScreen_a.a(vector, luckyNum);
                            synchronized (b) {
                                b.wait();
                                return;
                            }
                        }
                        case 112: {
                            ExplosionEffect.a((int)12).g = ((Message)object).java_io_DataInputStream_a().readInt();
                            ExplosionEffect.a((int)13).g = ((Message)object).java_io_DataInputStream_a().readInt();
                            ExplosionEffect.a((int)14).g = ((Message)object).java_io_DataInputStream_a().readInt();
                            ExplosionEffect.a((int)15).g = ((Message)object).java_io_DataInputStream_a().readInt();
                            return;
                        }
                        case 113: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            byte by37 = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] index= " + by + " angry= " + by37);
                            BattleManager.var_game_PlayerEntity_arr_a[by].b(by37);
                            return;
                        }
                        case 115: {
                            short s = ((Message)object).java_io_DataInputStream_a().readShort();
                            short s8 = ((Message)object).java_io_DataInputStream_a().readShort();
                            byte[] byArray = new byte[s8];
                            ((Message)object).java_io_DataInputStream_a().read(byArray, 0, s8);
                            Image image = Image.createImage((byte[])byArray, (int)0, (int)s8);
                            EquipItemEntry equipItemEntry = new EquipItemEntry();
                            equipItemEntry.var_short_a = s;
                            equipItemEntry.var_javax_microedition_lcdui_Image_a = image;
                            if (!GameCanvas.var_game_GameHelper08_a.boolean_a(equipItemEntry.var_short_a)) {
                                GameCanvas.var_game_GameHelper08_a.a(equipItemEntry);
                            }
                            ServerManager.a(s, image);
                            return;
                        }
                        case 116: {
                            GameCanvas.d();
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            Vector<EquipItemEntry> vector = new Vector<EquipItemEntry>();
                            while (((Message)object).java_io_DataInputStream_a().available() > 0) {
                                EquipItemEntry equipItemEntry = new EquipItemEntry();
                                equipItemEntry.var_short_a = ((Message)object).java_io_DataInputStream_a().readShort();
                                equipItemEntry.var_java_lang_String_a = ((Message)object).java_io_DataInputStream_a().readUTF();
                                equipItemEntry.var_int_a = (byte)((Message)object).java_io_DataInputStream_a().readUnsignedByte();
                                equipItemEntry.var_int_b = (byte)((Message)object).java_io_DataInputStream_a().readUnsignedByte();
                                equipItemEntry.var_java_lang_String_b = ((Message)object).java_io_DataInputStream_a().readUTF();
                                equipItemEntry.var_long_a = ((Message)object).java_io_DataInputStream_a().readLong();
                                equipItemEntry.var_int_c = ((Message)object).java_io_DataInputStream_a().readInt();
                                equipItemEntry.var_int_d = ((Message)object).java_io_DataInputStream_a().readInt();
                                System.out.println("[ca] money2= " + equipItemEntry.var_int_c + " cup= " + equipItemEntry.var_int_d);
                                equipItemEntry.var_byte_a = ((Message)object).java_io_DataInputStream_a().readByte();
                                equipItemEntry.var_byte_b = ((Message)object).java_io_DataInputStream_a().readByte();
                                equipItemEntry.var_java_lang_String_c = ((Message)object).java_io_DataInputStream_a().readUTF();
                                vector.addElement(equipItemEntry);
                            }
                            ProfileScreen.var_game_ProfileScreen_a.a(GameCanvas.var_game_BaseScreen_a);
                            ProfileScreen.var_game_ProfileScreen_a.a(by, vector);
                            return;
                        }
                        case 117: {
                            GameCanvas.d();
                            EquipItemEntry equipItemEntry = new EquipItemEntry();
                            equipItemEntry.var_short_a = ((Message)object).java_io_DataInputStream_a().readShort();
                            equipItemEntry.var_java_lang_String_a = ((Message)object).java_io_DataInputStream_a().readUTF();
                            equipItemEntry.var_int_a = (byte)((Message)object).java_io_DataInputStream_a().readUnsignedByte();
                            equipItemEntry.var_int_b = (byte)((Message)object).java_io_DataInputStream_a().readUnsignedByte();
                            equipItemEntry.var_java_lang_String_b = ((Message)object).java_io_DataInputStream_a().readUTF();
                            equipItemEntry.var_long_a = ((Message)object).java_io_DataInputStream_a().readLong();
                            equipItemEntry.var_int_c = ((Message)object).java_io_DataInputStream_a().readInt();
                            equipItemEntry.var_int_d = ((Message)object).java_io_DataInputStream_a().readInt();
                            equipItemEntry.e = ((Message)object).java_io_DataInputStream_a().readInt();
                            equipItemEntry.f = ((Message)object).java_io_DataInputStream_a().readInt();
                            equipItemEntry.var_byte_a = ((Message)object).java_io_DataInputStream_a().readByte();
                            equipItemEntry.var_byte_b = ((Message)object).java_io_DataInputStream_a().readByte();
                            equipItemEntry.var_java_lang_String_c = ((Message)object).java_io_DataInputStream_a().readUTF();
                            equipItemEntry.var_java_lang_String_d = ((Message)object).java_io_DataInputStream_a().readUTF();
                            int n = ((Message)object).java_io_DataInputStream_a().readByte();
                            equipItemEntry.var_java_lang_String_arr_a = new String[n];
                            equipItemEntry.var_int_arr_a = new int[n];
                            for (int by51 = 0; by51 < n; ++by51) {
                                equipItemEntry.var_java_lang_String_arr_a[by51] = ((Message)object).java_io_DataInputStream_a().readUTF();
                                equipItemEntry.var_int_arr_a[by51] = ((Message)object).java_io_DataInputStream_a().readInt();
                            }
                            ProfileScreen.var_game_ProfileScreen_b.var_game_EquipItemEntry_a = equipItemEntry;
                            ProfileScreen.var_game_ProfileScreen_b.a(GameCanvas.var_game_BaseScreen_a);
                            return;
                        }
                        case 118: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            Vector<PlayerAccountInfo> vector = new Vector<PlayerAccountInfo>();
                            ((Message)object).java_io_DataInputStream_a().readUTF();
                            while (((Message)object).java_io_DataInputStream_a().available() > 0) {
                                PlayerAccountInfo by39 = new PlayerAccountInfo();
                                by39.var_int_a = ((Message)object).java_io_DataInputStream_a().readInt();
                                by39.var_java_lang_String_a = ((Message)object).java_io_DataInputStream_a().readUTF();
                                System.out.println("[ca] name= " + by39.var_java_lang_String_a);
                                by39.var_long_c = ((Message)object).java_io_DataInputStream_a().readLong();
                                by39.var_byte_a = ((Message)object).java_io_DataInputStream_a().readByte();
                                by39.var_boolean_b = ((Message)object).java_io_DataInputStream_a().readByte() != 0;
                                by39.var_int_b = ((Message)object).java_io_DataInputStream_a().readShort();
                                by39.var_int_c = ((Message)object).java_io_DataInputStream_a().readByte();
                                by39.f = ((Message)object).java_io_DataInputStream_a().readUnsignedByte();
                                by39.var_int_d = ((Message)object).java_io_DataInputStream_a().readInt();
                                by39.f();
                                short[] by40 = new short[5];
                                for (int string14 = 0; string14 < 5; ++string14) {
                                    by40[string14] = ((Message)object).java_io_DataInputStream_a().readShort();
                                    by39.var_short_arr_arr_a[by39.var_byte_a][string14] = by40[string14];
                                    by39.b();
                                }
                                by39.var_java_lang_String_c = ((Message)object).java_io_DataInputStream_a().readUTF();
                                by39.var_java_lang_String_d = ((Message)object).java_io_DataInputStream_a().readUTF();
                                vector.addElement(by39);
                            }
                            this.c.a(by, vector);
                            return;
                        }
                        case 119: {
                            String string;
                            String string5;
                            ((Message)object).java_io_DataInputStream_a().readByte();
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            byte by14 = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] Gift= " + by14);
                            String string6 = BattleManager.var_game_PlayerEntity_arr_a[by].var_java_lang_String_a;
                            if (by14 == 0) {
                                int n = ((Message)object).java_io_DataInputStream_a().readUnsignedShort();
                                string5 = string6 + ": +" + n + StringUtils.aq();
                                BattleScreen.var_game_BattleScreen_a.var_java_util_Vector_c.addElement(new GameHelper14(string5, null));
                            }
                            if (by14 == 1) {
                                by = ((Message)object).java_io_DataInputStream_a().readByte();
                                byte by15 = ((Message)object).java_io_DataInputStream_a().readByte();
                                string = string6 + " : +" + by15 + "x " + GameHelper31.var_java_lang_String_arr_a[by];
                                BattleScreen.var_game_BattleScreen_a.var_java_util_Vector_c.addElement(new GameHelper14(string, null));
                            }
                            if (by14 == 2) {
                                by = ((Message)object).java_io_DataInputStream_a().readByte();
                                byte by16 = ((Message)object).java_io_DataInputStream_a().readByte();
                                short s = ((Message)object).java_io_DataInputStream_a().readShort();
                                ItemTemplate itemTemplate = EquipSlotSet.a(by, by16, s);
                                String string15 = string6 + " : +" + ((Message)object).java_io_DataInputStream_a().readUTF();
                                BattleScreen.var_game_BattleScreen_a.var_java_util_Vector_c.addElement(new GameHelper14(string15, itemTemplate));
                            }
                            if (by14 == 3) {
                                byte by41 = ((Message)object).java_io_DataInputStream_a().readByte();
                                string5 = string6 + " : +" + by41 + "xp";
                                BattleScreen.var_game_BattleScreen_a.var_java_util_Vector_c.addElement(new GameHelper14(string5, null));
                            }
                            if (by14 != 4) break;
                            string = ((Message)object).java_io_DataInputStream_a().readUTF();
                            BattleScreen.var_game_BattleScreen_a.var_java_util_Vector_c.addElement(new GameHelper14("+ " + string, null));
                            return;
                        }
                        case 120: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            int n = ((Message)object).java_io_DataInputStream_a().readInt();
                            byte[] byArray = new byte[n];
                            ((Message)object).java_io_DataInputStream_a().read(byArray, 0, n);
                            GameCanvas.a("bigImage" + by, byArray);
                            EquipSlotSet.var_javax_microedition_lcdui_Image_arr_a[by] = Image.createImage((byte[])byArray, (int)0, (int)n);
                            System.out.println("[ca] idIMg= " + by + " nBig= " + GameCanvas.i);
                            GameSetting.var_int_c = by + 90;
                            if (by != 9) break;
                            GameSetting.var_boolean_a = false;
                            ConnectionWatchdog.game_ConnectionWatchdog_a().b((byte)6, (byte)0);
                            GameCanvas.d();
                            this.c.d();
                            return;
                        }
                        case 121: {
                            boolean bl = ((Message)object).java_io_DataInputStream_a().readBoolean();
                            String string = ((Message)object).java_io_DataInputStream_a().readUTF();
                            String string7 = ((Message)object).java_io_DataInputStream_a().readUTF();
                            System.out.println("[ca] conten= " + string + " sms= " + string7);
                            this.c.a(string, bl, string7);
                            return;
                        }
                        case 122: {
                            Object object3;
                            Vector<Object> vector = new Vector<Object>();
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            System.out.println("[ca] action= " + by);
                            if (by == 0) {
                                while (((Message)object).java_io_DataInputStream_a().available() > 0) {
                                    object3 = new GameHelper17();
                                    ((GameHelper17)object3).a = ((Message)object).java_io_DataInputStream_a().readUTF();
                                    ((GameHelper17)object3).b = ((Message)object).java_io_DataInputStream_a().readUTF();
                                    ((GameHelper17)object3).c = ((Message)object).java_io_DataInputStream_a().readUTF();
                                    vector.addElement(object3);
                                    System.out.println("[ca] id= " + ((GameHelper17)object3).a + " content=" + ((GameHelper17)object3).b + " url: " + ((GameHelper17)object3).c);
                                }
                                this.c.d(vector);
                            }
                            if (by != 2) break;
                            object3 = ((Message)object).java_io_DataInputStream_a().readUTF();
                            String string = ((Message)object).java_io_DataInputStream_a().readUTF();
                            this.c.a((String)object3, string);
                            return;
                        }
                        case 123: {
                            ClanGroupEntry clanGroupEntry = new ClanGroupEntry();
                            clanGroupEntry.var_java_lang_String_a = ((Message)object).java_io_DataInputStream_a().readUTF() + " " + StringUtils.ag();
                            clanGroupEntry.b = ((Message)object).java_io_DataInputStream_a().readUTF();
                            this.c.a(clanGroupEntry);
                            return;
                        }
                        case 124: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            byte by17 = ((Message)object).java_io_DataInputStream_a().readByte();
                            BattleManager.var_game_PlayerEntity_arr_a[by].a((int)by17);
                            BattleManager.var_game_PlayerEntity_arr_a[by].b(BattleManager.var_game_PlayerEntity_arr_a[by17].var_int_g, BattleManager.var_game_PlayerEntity_arr_a[by].var_int_g);
                            if (GameCanvas.var_game_BaseScreen_a != BattleScreen.var_game_BattleScreen_a) break;
                            Object object4 = b;
                            synchronized (object4) {
                                b.wait();
                                return;
                            }
                        }
                        case 125: {
                            if (((Message)object).java_io_DataInputStream_a().readByte() != 0) break;
                            int n = ((Message)object).java_io_DataInputStream_a().readByte();
                            for (int i = 0; i < n; ++i) {
                                short s = ((Message)object).java_io_DataInputStream_a().readShort();
                                short s10 = ((Message)object).java_io_DataInputStream_a().readShort();
                                String string = ((Message)object).java_io_DataInputStream_a().readUTF();
                                String string8 = ((Message)object).java_io_DataInputStream_a().readUTF();
                                System.out.println("[ca] id= " + s + "numb= " + s10 + "nName= " + string + " mDetail= " + string8);
                                ItemTemplate by = new ItemTemplate();
                                by.var_short_a = s;
                                by.var_java_lang_String_a = string;
                                by.var_java_lang_String_b = string8;
                                by.var_boolean_d = true;
                                by.var_short_b = s;
                                by.var_int_b = s10;
                                if (by.var_javax_microedition_lcdui_Image_a == null && GameHelper37.boolean_a(s)) {
                                    by.var_javax_microedition_lcdui_Image_a = GameHelper37.javax_microedition_lcdui_Image_a(s);
                                }
                                EquipScreen.a(by);
                            }
                            return;
                        }
                        case 126: {
                            byte by;
                            byte by18 = ((Message)object).java_io_DataInputStream_a().readByte();
                            int n = ((Message)object).java_io_DataInputStream_a().readUnsignedByte();
                            short s = ((Message)object).java_io_DataInputStream_a().readShort();
                            System.out.println("[ca] Get material Icon " + n + " lent= " + s);
                            byte[] byArray = new byte[s];
                            ((Message)object).java_io_DataInputStream_a().read(byArray, 0, s);
                            Image image = Image.createImage((byte[])byArray, (int)0, (int)s);
                            if (by18 == 0) {
                                GameHelper37.a(new AvatarIcon(n, image));
                                EquipScreen.var_game_EquipScreen_a.a(n, image);
                            }
                            if (by18 == 1) {
                                GameHelper37.a(new AvatarIcon(n, image));
                                GameHelper48.var_game_GameHelper48_a.a(n, image);
                            }
                            if (by18 == 2) {
                                BattleScreen.var_game_GameHelper34_a.a(n, image);
                            }
                            if (by18 == 3) {
                                by = ((Message)object).java_io_DataInputStream_a().readByte();
                                UpgradeScreen.var_game_UpgradeScreen_a.a((int)by).var_javax_microedition_lcdui_Image_a = image;
                            }
                            if (by18 == 4) {
                                by = ((Message)object).java_io_DataInputStream_a().readByte();
                                GameHelper07 s9 = DailyGiftScreen.var_game_DailyGiftScreen_a.a(by);
                                for (int bl = 0; bl < s9.var_javax_microedition_lcdui_Image_arr_a.length; ++bl) {
                                    if (s9.var_int_arr_a[bl] != n) continue;
                                    s9.var_javax_microedition_lcdui_Image_arr_a[bl] = image;
                                }
                            }
                            return;
                        }
                        case 13: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            if (by == 0) {
                                int objectArray = ((Message)object).java_io_DataInputStream_a().readInt();
                                int image = ((Message)object).java_io_DataInputStream_a().readInt();
                                double gameHelper53 = ((Message)object).java_io_DataInputStream_a().readDouble();
                                byte by19 = ((Message)object).java_io_DataInputStream_a().readByte();
                                int n = ((Message)object).java_io_DataInputStream_a().readByte();
                                GameHelper43[] gameHelper43Array = new GameHelper43[n];
                                for (int i = 0; i < n; ++i) {
                                    gameHelper43Array[i] = new GameHelper43(((Message)object).java_io_DataInputStream_a().readShort(), ((Message)object).java_io_DataInputStream_a().readUTF(), ((Message)object).java_io_DataInputStream_a().readShort());
                                }
                                GameHelper41.a.a(objectArray, image, gameHelper53, by19, gameHelper43Array);
                                break;
                            }
                            if (by == 1) {
                                boolean by20 = ((Message)object).java_io_DataInputStream_a().readBoolean();
                                String floatingTextManager = ((Message)object).java_io_DataInputStream_a().readUTF();
                                GameHelper41 playerEntity = GameHelper41.a;
                                playerEntity.a(by20, floatingTextManager);
                            }
                            break block342;
                        }
                        case 44: {
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            if (by == 1) {
                                boolean bl = ((Message)object).java_io_DataInputStream_a().readBoolean();
                                String n42 = ((Message)object).java_io_DataInputStream_a().readUTF();
                                byte playerAccountInfo3 = ((Message)object).java_io_DataInputStream_a().readByte();
                                ItemManager itemManager = ItemManager.a;
                                itemManager.a(bl, playerAccountInfo3, n42);
                            }
                            break block342;
                        }
                        case 61: {
                            short s = ((Message)object).java_io_DataInputStream_a().readShort();
                            if (EffectCache.boolean_a(s)) break;
                            Object[] objectArray = ActionListener045.a(((Message)object).java_io_DataInputStream_a());
                            Image n = (Image)objectArray[0];
                            GameHelper53 gameHelper53 = (GameHelper53)objectArray[1];
                            EffectCache.a(s, n, gameHelper53);
                            break block342;
                        }
                        case 57: {
                            int n;
                            PlayerAccountInfo playerAccountInfo;
                            byte by = ((Message)object).java_io_DataInputStream_a().readByte();
                            if (by == 0) {
                                FloatingTextManager floatingTextManager = MenuScreen.var_game_MenuScreen_a.var_game_FloatingTextManager_a;
                                GameHelper01.a(floatingTextManager, ((Message)object).java_io_DataInputStream_a());
                                break block342;
                            }
                            if (by == 1) {
                                int n15 = ((Message)object).java_io_DataInputStream_a().readInt();
                                PlayerEntity playerEntity = BattleManager.game_PlayerEntity_a(n15);
                                if (playerEntity != null) {
                                    FloatingTextManager floatingTextManager = playerEntity.var_game_FloatingTextManager_a;
                                    GameHelper01.a(floatingTextManager, ((Message)object).java_io_DataInputStream_a());
                                }
                                break block342;
                            }
                            if (by != 2 || (playerAccountInfo = BoardScreen.var_game_BoardScreen_a.game_PlayerAccountInfo_a(n = ((Message)object).java_io_DataInputStream_a().readInt())) == null) break;
                            FloatingTextManager floatingTextManager = playerAccountInfo.var_game_FloatingTextManager_a;
                            GameHelper01.a(floatingTextManager, ((Message)object).java_io_DataInputStream_a());
                        }
                    }
                    return;
                }
                catch (Exception exception) {
                    Exception exception2 = exception;
                    exception.printStackTrace();
                }
            }
        }
    }

    private static void a(FloatingTextManager floatingTextManager, DataInputStream dataInputStream) throws Exception {
        floatingTextManager.a();
        int n = dataInputStream.readByte();
        for (int i = 0; i < n; ++i) {
            short s = dataInputStream.readShort();
            String string = dataInputStream.readUTF();
            int n2 = dataInputStream.readInt();
            int n3 = dataInputStream.readInt();
            boolean bl = dataInputStream.readBoolean();
            floatingTextManager.a(s, string, n2, n3, bl);
        }
    }

    private static void b(Message message) {
        block16: {
            try {
                int n = message.java_io_DataInputStream_a().readByte();
                if (n == 0) {
                    n = message.java_io_DataInputStream_a().readByte();
                    ShopItemEntry[] shopItemEntryArray = new ShopItemEntry[n];
                    EquipUpgradeEntry[] equipUpgradeEntryArray = new EquipUpgradeEntry[n];
                    for (int i = 0; i < n; ++i) {
                        int n2;
                        int n3;
                        ShopItemEntry shopItemEntry = new ShopItemEntry();
                        EquipUpgradeEntry equipUpgradeEntry = new EquipUpgradeEntry();
                        shopItemEntry.var_int_a = message.java_io_DataInputStream_a().readInt();
                        shopItemEntry.var_java_lang_String_a = message.java_io_DataInputStream_a().readUTF();
                        shopItemEntry.var_byte_a = message.java_io_DataInputStream_a().readByte();
                        shopItemEntry.var_short_arr_a = new short[shopItemEntry.var_byte_a];
                        shopItemEntry.var_boolean_arr_a = new boolean[shopItemEntry.var_byte_a];
                        shopItemEntry.var_byte_arr_a = new byte[shopItemEntry.var_byte_a];
                        equipUpgradeEntry.var_java_lang_String_arr_a = new String[shopItemEntry.var_byte_a];
                        for (n3 = 0; n3 < shopItemEntry.var_byte_a; ++n3) {
                            shopItemEntry.var_short_arr_a[n3] = message.java_io_DataInputStream_a().readShort();
                            equipUpgradeEntry.var_java_lang_String_arr_a[n3] = message.java_io_DataInputStream_a().readUTF();
                            shopItemEntry.var_boolean_arr_a[n3] = message.java_io_DataInputStream_a().readBoolean();
                            shopItemEntry.var_byte_arr_a[n3] = message.java_io_DataInputStream_a().readByte();
                        }
                        equipUpgradeEntry.var_short_arr_a = new short[5];
                        equipUpgradeEntry.var_short_arr_b = new short[5];
                        for (n3 = 0; n3 < 5; ++n3) {
                            equipUpgradeEntry.var_short_arr_a[n3] = message.java_io_DataInputStream_a().readShort();
                        }
                        for (n3 = 0; n3 < 5; ++n3) {
                            equipUpgradeEntry.var_short_arr_b[n3] = message.java_io_DataInputStream_a().readShort();
                        }
                        byte by = message.java_io_DataInputStream_a().readByte();
                        n3 = by;
                        if (by > 0) {
                            equipUpgradeEntry.var_java_lang_String_arr_b = new String[n3];
                            for (n2 = 0; n2 < n3; ++n2) {
                                equipUpgradeEntry.var_java_lang_String_arr_b[n2] = message.java_io_DataInputStream_a().readUTF();
                            }
                        } else {
                            equipUpgradeEntry.var_java_lang_String_arr_b = null;
                        }
                        shopItemEntry.var_int_b = message.java_io_DataInputStream_a().readInt();
                        shopItemEntry.var_boolean_a = message.java_io_DataInputStream_a().readBoolean();
                        shopItemEntry.var_byte_b = message.java_io_DataInputStream_a().readByte();
                        shopItemEntry.c = message.java_io_DataInputStream_a().readByte();
                        n2 = shopItemEntry.var_byte_arr_a[0];
                        for (n3 = 1; n3 < shopItemEntry.var_byte_a; n3 = (int)((byte)(n3 + 1))) {
                            if (shopItemEntry.var_byte_arr_a[n3] >= n2 || !shopItemEntry.var_boolean_arr_a[n3]) continue;
                            n2 = shopItemEntry.var_byte_arr_a[n3];
                        }
                        equipUpgradeEntry.var_game_ShopItemEntry_a = shopItemEntry;
                        shopItemEntryArray[i] = shopItemEntry;
                        equipUpgradeEntryArray[i] = equipUpgradeEntry;
                    }
                    if (GameHelper25.a != null) {
                        GameHelper25.a.a(shopItemEntryArray, equipUpgradeEntryArray);
                    }
                    break block16;
                }
                if (n == 2) {
                    n = message.java_io_DataInputStream_a().readInt();
                    String string = message.java_io_DataInputStream_a().readUTF();
                    String string2 = StringUtils.U() + " " + string + "!";
                    GameCanvas.b(string2, new ActionListener264(n));
                    break block16;
                }
                if (n == 3) {
                    n = message.java_io_DataInputStream_a().readInt();
                    int n4 = message.java_io_DataInputStream_a().readInt();
                    double d = message.java_io_DataInputStream_a().readDouble();
                    int n5 = message.java_io_DataInputStream_a().readByte();
                    GameHelper43[] gameHelper43Array = new GameHelper43[n5];
                    for (int i = 0; i < n5; ++i) {
                        gameHelper43Array[i] = new GameHelper43(message.java_io_DataInputStream_a().readShort(), message.java_io_DataInputStream_a().readUTF(), message.java_io_DataInputStream_a().readShort());
                    }
                    GameHelper27.a.a(n, n4, d, gameHelper43Array);
                    break block16;
                }
                if (n == 1) {
                    n = message.java_io_DataInputStream_a().readBoolean() ? 1 : 0;
                    String string = message.java_io_DataInputStream_a().readUTF();
                    GameHelper27.a.a(n != 0, string);
                }
                return;
            }
            catch (Exception exception) {
                Exception exception2 = exception;
                exception.printStackTrace();
                if (GameHelper25.a == null) break block16;
                GameHelper25.a.a("L\u1ed7i khi nh\u1eadn d\u1eef li\u1ec7u");
            }
        }
    }

    public final void a(IPacketListener iPacketListener) {
        this.c = iPacketListener;
    }

    static {
        a = false;
        b = new Object();
    }
}

