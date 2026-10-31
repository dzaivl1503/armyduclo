/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
package game;

import game.ActionListener015;
import game.ActionListener020;
import game.ActionListener022;
import game.ActionListener033;
import game.ActionListener038;
import game.ActionListener091;
import game.ActionListener093;
import game.ActionListener119;
import game.ActionListener130;
import game.ActionListener139;
import game.ActionListener161;
import game.ActionListener188;
import game.ActionListener211;
import game.ActionListener257;
import game.BaseScreen;
import game.BattleGraphicHelper;
import game.BattleManager;
import game.BoardScreen;
import game.CharacterSelectScreen;
import game.ChatScreen;
import game.ClanScreen;
import game.ConnectionWatchdog;
import game.DataUtils;
import game.FontRenderer;
import game.GameCanvas;
import game.GameCommand;
import game.GameHelper01;
import game.GameHelper02;
import game.GameHelper14;
import game.GameHelper16;
import game.GameHelper28;
import game.GameHelper29;
import game.GameHelper31;
import game.GameHelper34;
import game.PetEntity;
import game.PlayerAccountInfo;
import game.PlayerEntity;
import game.PopupDialog;
import game.ServerInfo;
import game.ShopScreen;
import game.StringUtils;
import game.TerrainMidlet;
import game.TrainingScreen;
import game.TurnTimer;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class BattleScreen
extends BaseScreen {
    public static BattleScreen var_game_BattleScreen_a;
    public static GameHelper29 var_game_GameHelper29_a;
    public static Image var_javax_microedition_lcdui_Image_a;
    public static Image var_javax_microedition_lcdui_Image_b;
    public static Image var_javax_microedition_lcdui_Image_c;
    public static Image var_javax_microedition_lcdui_Image_d;
    public static Image var_javax_microedition_lcdui_Image_e;
    public static Image var_javax_microedition_lcdui_Image_f;
    public static Image var_javax_microedition_lcdui_Image_g;
    public static Image var_javax_microedition_lcdui_Image_h;
    public static Image var_javax_microedition_lcdui_Image_i;
    public static Image var_javax_microedition_lcdui_Image_j;
    public static Image var_javax_microedition_lcdui_Image_k;
    public static Image var_javax_microedition_lcdui_Image_l;
    public static Image var_javax_microedition_lcdui_Image_m;
    public static Image var_javax_microedition_lcdui_Image_n;
    public static Image o;
    public static Image p;
    private Image var_javax_microedition_lcdui_Image_ll1ll1IIl;
    private Image var_javax_microedition_lcdui_Image_lIII111lll1I;
    private Image var_javax_microedition_lcdui_Image_Il1l11I1ll;
    private Image var_javax_microedition_lcdui_Image_III111I11II1;
    private Image var_javax_microedition_lcdui_Image_lll1IIlI1l11;
    private Image var_javax_microedition_lcdui_Image_llIl1lIl1l;
    private Image var_javax_microedition_lcdui_Image_lIllllllIIlI;
    public static Image[] var_javax_microedition_lcdui_Image_arr_a;
    public static Image[] var_javax_microedition_lcdui_Image_arr_b;
    private static Image var_javax_microedition_lcdui_Image_I1IlIlll;
    private static Image var_javax_microedition_lcdui_Image_ll1llIIl1l1l;
    private Image var_javax_microedition_lcdui_Image_I1II1l1II1I1;
    private Image var_javax_microedition_lcdui_Image_I1IllIlII;
    public static byte var_byte_a;
    private int var_int_IlI111ll1I = 0;
    public static boolean var_boolean_a;
    private int var_int_ll1ll1IIl;
    private int var_int_lIII111lll1I;
    public static int var_int_a;
    public static int var_int_b;
    public static boolean var_boolean_b;
    public static int var_int_c;
    public static int var_int_d;
    public static boolean var_boolean_c;
    public static int var_int_e;
    public static int var_int_f;
    public static boolean var_boolean_d;
    public static int var_int_g;
    public static int var_int_h;
    public static boolean var_boolean_e;
    public static int var_int_i;
    public static int var_int_j;
    public static Vector var_java_util_Vector_a;
    public static GameHelper34 var_game_GameHelper34_a;
    public static BattleManager var_game_BattleManager_a;
    public static GameHelper16 var_game_GameHelper16_a;
    public static CharacterSelectScreen var_game_CharacterSelectScreen_a;
    public static Vector var_java_util_Vector_b;
    public static BattleGraphicHelper var_game_BattleGraphicHelper_a;
    public static TurnTimer var_game_TurnTimer_a;
    public static int var_int_k;
    public static int var_int_l;
    public static boolean var_boolean_f;
    public static int var_int_m;
    public static boolean var_boolean_g;
    public Vector var_java_util_Vector_c = new Vector();
    public static String var_java_lang_String_a;
    private int var_int_Il1l11I1ll;
    private int var_int_III111I11II1 = -100;
    private boolean l1II111I1;
    private int var_int_lll1IIlI1l11;
    private boolean ll1IIlllI11I;
    private static int var_int_llIl1lIl1l;
    public static byte var_byte_b;
    private Vector ll11I1IIll = new Vector();
    private int var_int_lIllllllIIlI;
    private int var_int_I1IlIlll = 40;
    private TrainingScreen IIIl1llIllI;
    private int var_int_ll1llIIl1l1l = 0;
    private boolean ll11IIIlII;
    private int var_int_I1II1l1II1I1;
    public static boolean var_boolean_h;
    public static int var_int_n;
    private static int var_int_I1IllIlII;
    private static int I1III111lll;
    private static int l1I11lIl;
    private static int ll1IIllIlI11;
    private static int l1I11I1IIl;
    private static int I1IIIllI;
    private static int l1111ll1IIll;
    private static int lI1ll11I1I;
    private static int III1IIlI1lll;
    private static int IllIl1II11l;
    private static int IIIllIIII11;
    private static int IIl1IIIll11;
    private static int I1I1l11ll1II;
    private static int ll1lll1Il;
    public static boolean var_boolean_i;
    private boolean var_boolean_IlI111ll1I = true;
    private int lll1lI11l;
    private boolean var_boolean_ll1ll1IIl;
    public static byte[] var_byte_arr_a;

    public BattleScreen() {
        Object object = this;
        try {
            ((BattleScreen)object).var_javax_microedition_lcdui_Image_I1II1l1II1I1 = Image.createImage((String)"/iconmenu.png");
            ((BattleScreen)object).var_javax_microedition_lcdui_Image_I1IllIlII = Image.createImage((String)"/iconcam.png");
            ((BattleScreen)object).var_javax_microedition_lcdui_Image_ll1ll1IIl = Image.createImage((String)"/wind.png");
            ((BattleScreen)object).var_javax_microedition_lcdui_Image_lIII111lll1I = Image.createImage((String)"/wind2.png");
            var_javax_microedition_lcdui_Image_ll1llIIl1l1l = Image.createImage((String)"/arrow.png");
            ((BattleScreen)object).var_javax_microedition_lcdui_Image_Il1l11I1ll = Image.createImage((String)"/gui/keypad_btn.png");
            ((BattleScreen)object).var_javax_microedition_lcdui_Image_III111I11II1 = Image.createImage((String)"/gui/keypad_btn2.png");
            ((BattleScreen)object).var_javax_microedition_lcdui_Image_lll1IIlI1l11 = Image.createImage((String)"/gui/fire_btn1.png");
            ((BattleScreen)object).var_javax_microedition_lcdui_Image_llIl1lIl1l = Image.createImage((String)"/gui/fire_btn2.png");
            ((BattleScreen)object).var_javax_microedition_lcdui_Image_lIllllllIIlI = Image.createImage((String)"/gui/arrow_btn1.png");
        } catch (Exception e) {
        }
        l1I11lIl = GameCanvas.var_int_b - 5 - this.var_javax_microedition_lcdui_Image_Il1l11I1ll.getWidth();
        ll1IIllIlI11 = GameCanvas.var_int_c - 5 - this.var_javax_microedition_lcdui_Image_Il1l11I1ll.getHeight();
        int n = 15 + this.var_javax_microedition_lcdui_Image_lIllllllIIlI.getWidth() + this.var_javax_microedition_lcdui_Image_lIllllllIIlI.getHeight() / 2;
        int n2 = GameCanvas.var_int_c - 20 - this.var_javax_microedition_lcdui_Image_Il1l11I1ll.getHeight() - this.var_javax_microedition_lcdui_Image_lIllllllIIlI.getWidth() - this.var_javax_microedition_lcdui_Image_lIllllllIIlI.getHeight() / 2;
        l1I11I1IIl = n - 5 - this.var_javax_microedition_lcdui_Image_lIllllllIIlI.getHeight() / 2 - this.var_javax_microedition_lcdui_Image_lIllllllIIlI.getWidth();
        I1IIIllI = n2 - this.var_javax_microedition_lcdui_Image_lIllllllIIlI.getHeight() / 2;
        l1111ll1IIll = n + 5 + this.var_javax_microedition_lcdui_Image_lIllllllIIlI.getHeight() / 2;
        lI1ll11I1I = I1IIIllI;
        III1IIlI1lll = n - this.var_javax_microedition_lcdui_Image_lIllllllIIlI.getHeight() / 2;
        IllIl1II11l = n2 - 5 - this.var_javax_microedition_lcdui_Image_lIllllllIIlI.getHeight() / 2 - this.var_javax_microedition_lcdui_Image_lIllllllIIlI.getWidth();
        IIIllIIII11 = III1IIlI1lll;
        IIl1IIIll11 = n2 + 5 + this.var_javax_microedition_lcdui_Image_lIllllllIIlI.getHeight() / 2;
        I1I1l11ll1II = GameCanvas.var_int_b - 10 - this.var_javax_microedition_lcdui_Image_lll1IIlI1l11.getWidth();
        ll1lll1Il = n2 - this.var_javax_microedition_lcdui_Image_lll1IIlI1l11.getWidth() / 2;
    }

    public static void e() {
        if (var_game_BattleManager_a != null) {
            var_game_BattleManager_a = null;
        }
        if (var_game_GameHelper16_a != null) {
            var_game_GameHelper16_a = null;
        }
        if (var_game_CharacterSelectScreen_a != null) {
            var_game_CharacterSelectScreen_a = null;
        }
        if (var_java_util_Vector_b != null) {
            var_java_util_Vector_b = null;
        }
        if (var_game_TurnTimer_a != null) {
            var_game_TurnTimer_a = null;
        }
    }

    public static void f() {
        GameHelper34.var_java_util_Vector_a.removeAllElements();
        BattlePet.reset();
        System.gc();
    }

    public final void a(byte by, short[] sArray, short[] sArray2, int[] nArray, int n) {
        var_boolean_g = false;
        BattlePet.reset();
        BattleManager.deferredNextPlayer = -1;
        BattlePet.startWatchdog();
        PetManager.requestSync();
        System.out.println("[pet] vao tran: so pet trang bi=" + PetManager.equippedCount()
                + " myIndex=" + BattleScreen.var_byte_b);
        this.l1II111I1 = false;
        var_java_lang_String_a = "";
        this.var_int_lll1IIlI1l11 = 3;
        var_boolean_h = true;
        if (var_byte_a != 2) {
            var_game_GameHelper34_a.a();
        } else {
            ClanScreen.a();
        }
        var_game_BattleManager_a = new BattleManager();
        BattleManager.var_game_PlayerEntity_arr_a = new PlayerEntity[BattleManager.var_int_a];
        BattleManager.var_int_arr_a = new int[BattleManager.var_int_a];
        BattleManager.var_short_arr_a = new short[BattleManager.var_int_a];
        BattleManager.var_short_arr_b = new short[BattleManager.var_int_a];
        new StringBuffer("Max players: ").append(BattleManager.var_int_a);
        PlayerEntity.var_boolean_G = false;
        var_game_CharacterSelectScreen_a = new CharacterSelectScreen();
        var_java_util_Vector_b = new Vector();
        var_game_BattleGraphicHelper_a = new BattleGraphicHelper();
        var_java_util_Vector_a = new Vector();
        var_game_TurnTimer_a = new TurnTimer();
        if (n != 0) {
            new StringBuffer("[eo] ").append(n).append(StringUtils.J());
        }
        var_game_GameHelper16_a = new GameHelper16();
        var_game_TurnTimer_a.a(by);
        this.IIIl1llIllI = null;
        if (var_byte_a != 2) {
            if (ClanScreen.var_byte_a == 2) {
                this.IIIl1llIllI = new TrainingScreen();
                this.IIIl1llIllI.a(0);
            }
            if (ClanScreen.var_byte_a == 10) {
                this.IIIl1llIllI = new TrainingScreen();
                if (BattleScreen.var_game_GameHelper34_a.c == 34) {
                    this.IIIl1llIllI.a = 35;
                }
                if (BattleScreen.var_game_GameHelper34_a.c == 35) {
                    this.IIIl1llIllI.a = 30;
                }
                if (BattleScreen.var_game_GameHelper34_a.c == 38) {
                    this.IIIl1llIllI.a = 80;
                }
                if (BattleScreen.var_game_GameHelper34_a.c == 39) {
                    this.IIIl1llIllI.a = 0;
                }
                this.IIIl1llIllI.a(1);
            }
        }
        var_game_BattleManager_a.a(sArray, sArray2, nArray);
        var_game_GameHelper16_a.a(var_byte_b);
        var_boolean_i = false;
        ShopScreen.e = 200;
    }

    /*
     * Unable to fully structure code
     */
    public final void void_b() {
        PlayerEntity var2_1 = null;
        int var3_3 = 0;
        int var1_5 = 0;
        int var2_2 = 0;
        int[] var3_4 = null;
        int var1_6 = 0;
        block69: {
            block70: {
                block68: {
                    block65: {
                        block67: {
                            block66: {
                                if (!BattleManager.boolean_a() && !BattleScreen.var_boolean_f) break block65;
                                if (!GameCanvas.var_boolean_c) break block66;
                                GameCanvas.var_boolean_arr_b[2] = false;
                                GameCanvas.var_boolean_arr_b[4] = false;
                                GameCanvas.var_boolean_arr_b[6] = false;
                                GameCanvas.var_boolean_arr_b[8] = false;
                                GameCanvas.var_boolean_arr_b[5] = false;
                                break block65;
                            }
                            if (GameCanvas.var_game_PopupMenu_a.var_boolean_a || !GameCanvas.var_boolean_d || !GameCanvas.var_boolean_b) break block65;
                            if (!GameCanvas.a(BattleScreen.l1I11lIl, BattleScreen.ll1IIllIlI11, 20, 20) || GameCanvas.var_int_a % 3 != 0) break block67;
                            BattleScreen.var_game_BattleScreen_a.var_boolean_IlI111ll1I = BattleScreen.var_game_BattleScreen_a.var_boolean_IlI111ll1I == false;
                            break block65;
                        }
                        if (BattleScreen.var_game_BattleScreen_a.var_boolean_IlI111ll1I)
                        if (GameCanvas.a(BattleScreen.l1I11I1IIl - 5, BattleScreen.I1IIIllI - 5, 30, 30)) {
                            GameCanvas.var_boolean_arr_b[4] = true;
                        } else if (GameCanvas.a(BattleScreen.l1111ll1IIll - 5, BattleScreen.lI1ll11I1I - 5, 30, 30)) {
                            GameCanvas.var_boolean_arr_b[6] = true;
                        } else if (GameCanvas.a(BattleScreen.III1IIlI1lll - 5, BattleScreen.IllIl1II11l - 5, 30, 30)) {
                            GameCanvas.var_boolean_arr_b[2] = true;
                        } else if (GameCanvas.a(BattleScreen.IIIllIIII11 - 5, BattleScreen.IIl1IIIll11 - 5, 30, 30)) {
                            GameCanvas.var_boolean_arr_b[8] = true;
                        } else if (GameCanvas.a(BattleScreen.I1I1l11ll1II, BattleScreen.ll1lll1Il, 50, 50)) {
                            GameCanvas.var_boolean_arr_b[5] = true;
                        } else if (GameCanvas.a(0, 0, GameCanvas.var_int_b, GameCanvas.var_int_c - 2 * BaseScreen.var_int_o) && GameHelper16.var_byte_a == 1 && !GameCanvas.a(0, 0, 100, 50) && !GameCanvas.a(GameCanvas.var_int_b - 50, 0, 50, 50)) {
                            var2_1 = BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b];
                            var2_1.var_int_t = GameCanvas.f <= var2_1.var_int_g - GameHelper16.b ? 0 : 2;
                            var3_3 = var2_1.var_int_g - GameCanvas.f - GameHelper16.b;
                            var1_5 = var2_1.var_int_h - GameCanvas.g - GameHelper16.c;
                            var2_1.var_int_r = DataUtils.a(-var3_3, var1_5);
                            if (var2_1.var_int_t == 2) {
                                if (var2_1.var_int_r > 270) {
                                    var2_1.var_int_r -= 360;
                                }
                                if (var2_1.var_int_r < PlayerEntity.var_short_arr_a[var2_1.var_byte_c]) {
                                    var2_1.var_int_r = PlayerEntity.var_short_arr_a[var2_1.var_byte_c];
                                }
                            }
                            if (var2_1.var_int_t == 0 && var2_1.var_int_r > 180 - PlayerEntity.var_short_arr_a[var2_1.var_byte_c]) {
                                var2_1.var_int_r = 180 - PlayerEntity.var_short_arr_a[var2_1.var_byte_c];
                            }
                            var2_1.f();
                        }
                    }
                    if (GameCanvas.var_boolean_c && this.ll1IIlllI11I && GameCanvas.a(0, 0, 50, 50)) {
                        this.ll1IIlllI11I = false;
                        this.Il11l1I11l();
                    }
                    if (GameHelper16.var_byte_a != 0) break block68;
                    if (!BaseScreen.k) {
                        if (GameCanvas.var_boolean_arr_b[2]) {
                            GameHelper16.g = -20;
                        }
                        if (GameCanvas.var_boolean_arr_b[8]) {
                            GameHelper16.g = 20;
                        }
                        if (GameCanvas.var_boolean_arr_b[4]) {
                            GameHelper16.f = -20;
                        }
                        if (GameCanvas.var_boolean_arr_b[6]) {
                            GameHelper16.f = 20;
                        }
                    }
                    if (GameCanvas.var_boolean_d && GameCanvas.var_boolean_b) {
                        if (GameCanvas.a(0, GameCanvas.var_int_c / 2 - 25, 50, 50)) {
                            GameHelper16.f = -20;
                        }
                        if (GameCanvas.a(GameCanvas.var_int_b - 50, GameCanvas.var_int_c / 2 - 25, 50, 50)) {
                            GameHelper16.f = 20;
                        }
                        if (GameCanvas.a(GameCanvas.var_int_b / 2 - 30, 0, 60, 60)) {
                            GameHelper16.g = -20;
                        }
                        if (GameCanvas.a(GameCanvas.var_int_b / 2 - 30, GameCanvas.var_int_c - 60, 60, 60)) {
                            GameHelper16.g = 20;
                        }
                    }
                    if (GameCanvas.var_boolean_arr_a[5] || GameCanvas.var_boolean_arr_a[12] || GameCanvas.var_boolean_arr_a[13]) {
                        if (CharacterSelectScreen.var_boolean_a && !BattleScreen.var_game_CharacterSelectScreen_a.var_java_util_Vector_a.isEmpty()) {
                            BattleScreen.var_game_GameHelper16_a.a((ShopScreen)BattleScreen.var_game_CharacterSelectScreen_a.var_java_util_Vector_a.elementAt(0));
                        } else {
                            BattleScreen.var_game_GameHelper16_a.a(BattleManager.var_byte_a);
                        }
                        BaseScreen.m();
                    }
                    if (GameCanvas.var_boolean_d && GameCanvas.var_boolean_c && GameCanvas.a(GameCanvas.var_int_b - 50, 0, 50, 50)) {
                        if (GameHelper16.var_byte_a == 0) {
                            if (CharacterSelectScreen.var_boolean_a && !BattleScreen.var_game_CharacterSelectScreen_a.var_java_util_Vector_a.isEmpty()) {
                                BattleScreen.var_game_GameHelper16_a.a((ShopScreen)BattleScreen.var_game_CharacterSelectScreen_a.var_java_util_Vector_a.elementAt(0));
                            } else {
                                BattleScreen.var_game_GameHelper16_a.a(BattleManager.var_byte_a);
                            }
                        }
                        BaseScreen.m();
                        return;
                    }
                    break block69;
                }
                if (BoardScreen.var_game_MapEntity_a.java_lang_String_a().equals("")) break block70;
                if (GameCanvas.var_boolean_arr_a[5] || GameCanvas.var_boolean_arr_a[12] || this.ll11IIIlII) {
                    this.ll11IIIlII = false;
                    if (this.var_int_ll1llIIl1l1l == 0) {
                        String chatMsg = BoardScreen.var_game_MapEntity_a.java_lang_String_a();
                        ConnectionWatchdog.game_ConnectionWatchdog_a().c(chatMsg);
                        BoardScreen.var_game_MapEntity_a.a("");
                        this.a(TerrainMidlet.myInfo.var_int_a, chatMsg);
                        this.var_int_ll1llIIl1l1l = this.var_int_lIllllllIIlI;
                    } else {
                        BoardScreen.var_game_MapEntity_a.a("");
                    }
                    BaseScreen.m();
                }
                if (GameCanvas.var_boolean_arr_a[13]) {
                    BoardScreen.var_game_MapEntity_a.b();
                    BaseScreen.m();
                    return;
                }
                break block69;
            }
            if (GameCanvas.var_boolean_d && !BattleScreen.var_java_lang_String_a.equals("") && GameCanvas.a(0, 0, GameCanvas.var_int_b, GameCanvas.var_int_c - BaseScreen.var_int_r) || !BattleScreen.var_java_lang_String_a.equals("") && (GameCanvas.var_boolean_arr_a[5] || GameCanvas.var_boolean_arr_a[12] || GameCanvas.var_boolean_arr_a[13])) { BattleScreen.I11Il1lI1llI(); BaseScreen.m(); return; }
            if (!this.ll1IIlllI11I) {
                if (GameCanvas.var_boolean_arr_a[12]) {
                    this.Il11l1I11l();
                    BaseScreen.m();
                    return;
                }
                if (GameCanvas.var_boolean_c) {
                    if (GameCanvas.a(0, 0, 50, 50)) {
                        this.Il11l1I11l();
                        return;
                    }
                    if (GameCanvas.a(50, 0, 50, 50)) {
                        this.ll11IIIlII = true;
                        BoardScreen.var_game_MapEntity_a.void_a();
                        return;
                    }
                }
                if (GameCanvas.var_boolean_arr_a[13]) {
                    GameHelper16.var_byte_a = 0;
                    BaseScreen.m();
                }
                if (GameCanvas.var_boolean_d && GameCanvas.var_boolean_c && GameCanvas.a(GameCanvas.var_int_b - 50, 0, 50, 50)) {
                    GameHelper16.var_byte_a = 0;
                    BaseScreen.m();
                }
                if (GameHelper16.var_byte_a == 1) {
                    BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b].d();
                    return;
                }
            } else {
                var2_2 = BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b].var_int_arr_a.length;
                if (GameCanvas.var_boolean_arr_a[2]) {
                    if ((BattleScreen.var_int_llIl1lIl1l -= 4) < 0) {
                        BattleScreen.var_int_llIl1lIl1l = 0;
                    }
                    BaseScreen.m();
                }
                if (GameCanvas.var_boolean_arr_a[8]) {
                    if ((BattleScreen.var_int_llIl1lIl1l += 4) > var2_2 - 1) {
                        BattleScreen.var_int_llIl1lIl1l = var2_2 - 1;
                    }
                    BaseScreen.m();
                }
                if (GameCanvas.var_boolean_arr_a[4]) {
                    if (--BattleScreen.var_int_llIl1lIl1l < 0) {
                        BattleScreen.var_int_llIl1lIl1l = var2_2 - 1;
                    }
                    BaseScreen.m();
                }
                if (GameCanvas.var_boolean_arr_a[6]) {
                    if (++BattleScreen.var_int_llIl1lIl1l > var2_2 - 1) {
                        BattleScreen.var_int_llIl1lIl1l = 0;
                    }
                    BaseScreen.m();
                }
                if (GameCanvas.var_boolean_arr_a[5] || GameCanvas.var_boolean_arr_a[12]) {
                    var3_4 = BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b].var_int_arr_a;
                    for (var1_5 = 0; var1_5 < var3_4.length; ++var1_5) {
                        new StringBuffer("[eo] item list= ").append(var3_4[var1_5]);
                    }
                    if (BattleScreen.var_boolean_f) {
                        BaseScreen.m();
                        BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b].a(var3_4[BattleScreen.var_int_llIl1lIl1l], true, BattleScreen.var_int_llIl1lIl1l);
                        if (var3_4[BattleScreen.var_int_llIl1lIl1l] == 0) {
                            BattleManager.var_game_PlayerEntity_arr_a[0].var_int_w += 30;
                        }
                        this.ll1IIlllI11I = false;
                        return;
                    }
                    if (BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b].var_int_k == -1 && var3_4[BattleScreen.var_int_llIl1lIl1l] >= 0 && var3_4[BattleScreen.var_int_llIl1lIl1l] != BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b].var_int_k && BattleManager.boolean_a() && (BoardScreen.var_byte_b != 7 || BattleScreen.var_byte_arr_a[BattleScreen.var_int_llIl1lIl1l] != 0)) {
                        BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b].a(var3_4[BattleScreen.var_int_llIl1lIl1l], false, BattleScreen.var_int_llIl1lIl1l);
                        this.ll1IIlllI11I = false;
                    }
                    BaseScreen.m();
                }
                if (GameCanvas.var_boolean_c && GameCanvas.a(var2_2 = GameCanvas.var_int_d - 80, var1_5 = GameCanvas.var_int_e - 33, 170, 90)) {
                    if ((var2_2 = ((GameCanvas.g - var1_5) / 40 << 2) + (GameCanvas.f - var2_2) / 40) != BattleScreen.var_int_llIl1lIl1l) {
                        BattleScreen.var_int_llIl1lIl1l = var2_2;
                    } else {
                        GameCanvas.var_boolean_arr_a[5] = true;
                    }
                    if (BattleScreen.var_int_llIl1lIl1l < 0) {
                        BattleScreen.var_int_llIl1lIl1l = 0;
                    }
                    if (BattleScreen.var_int_llIl1lIl1l > 7) {
                        BattleScreen.var_int_llIl1lIl1l = 7;
                    }
                }
                if (GameCanvas.var_boolean_arr_a[13]) {
                    this.ll1IIlllI11I = false;
                    BaseScreen.m();
                }
                return;
            }
        }
    }

    private void Il11l1I11l() {
        Vector<GameCommand> vector = new Vector<GameCommand>();
        vector.addElement(new GameCommand(StringUtils.bb(), new ActionListener093()));
        vector.addElement(new GameCommand("L\u1ef0C MAX", new ActionListener130()));
        vector.addElement(new GameCommand("V9 MENU", new ActionListener161()));
        if (BattleManager.boolean_a()) {
            vector.addElement(new GameCommand(StringUtils.bc(), new ActionListener119(this)));
        }
        if (BattleManager.boolean_a() && BattleManager.game_PlayerEntity_a().var_boolean_w && !BattleManager.game_PlayerEntity_a().var_boolean_o) {
            vector.addElement(new GameCommand(StringUtils.ay(), new ActionListener188()));
        }
        vector.addElement(new GameCommand(StringUtils.I(), new ActionListener091()));
        vector.addElement(new GameCommand(StringUtils.cJ(), new ActionListener020()));
        vector.addElement(new GameCommand(StringUtils.cH(), new ActionListener038(this)));
        if (BattleManager.boolean_a() && !var_boolean_f && !CharacterSelectScreen.var_boolean_a && BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b].var_boolean_v && this.var_int_lll1IIlI1l11 > 0) {
            vector.addElement(new GameCommand(StringUtils.be(), new ActionListener211(this)));
        }
        vector.addElement(new GameCommand(StringUtils.bd(), new ActionListener257()));
        GameCanvas.var_game_PopupMenu_a.a(vector);
    }

    public static void a(ServerInfo serverInfo) {
        var_java_util_Vector_a.addElement(serverInfo);
        BattleScreen.g();
    }

    public static void a(int n) {
        for (int i = 0; i < var_java_util_Vector_a.size(); ++i) {
            ServerInfo serverInfo = (ServerInfo)var_java_util_Vector_a.elementAt(i);
            if (serverInfo.var_int_a != n) continue;
            serverInfo.var_boolean_a = true;
            GameHelper34.void_a(serverInfo.var_int_b, serverInfo.c, (byte)57);
            return;
        }
        BattleScreen.g();
    }

    public static void g() {
        Object object = var_game_TurnTimer_a;
        ((TurnTimer)object).a += 2;
        GameCanvas.j = 0;
        GameCanvas.var_boolean_e = true;
        if (GameCanvas.var_game_BaseScreen_a == var_game_BattleScreen_a) {
            object = GameHelper01.b;
            synchronized (object) {
                try {
                    GameHelper01.b.wait();
                }
                catch (InterruptedException interruptedException) {}
                return;
            }
        }
    }

    private static void I11Il1lI1llI() {
        for (int i = 0; i < BattleManager.var_int_a; ++i) {
            if (BattleManager.var_game_PlayerEntity_arr_a[i] == null) continue;
            BattleManager.var_game_PlayerEntity_arr_a[i] = null;
        }
        BoardScreen.var_game_BoardScreen_a.b_();
        Object object = GameHelper01.b;
        synchronized (object) {
            GameHelper01.b.notify();
            return;
        }
    }

    public final void c() {
        Object object;
        int n;
        int n2;
        if (var_boolean_f) {
            switch (var_int_n) {
                case 0: {
                    if (BattleManager.var_game_PlayerEntity_arr_a[0].var_boolean_n) break;
                    var_int_n = -1;
                    GameCanvas.a(StringUtils.cV(), new ActionListener033());
                    break;
                }
                case 1: {
                    if (BattleManager.var_game_PlayerEntity_arr_a[0].var_int_n <= 20) break;
                    var_int_n = -1;
                    GameCanvas.var_boolean_arr_b[4] = false;
                    GameCanvas.var_boolean_arr_b[6] = false;
                    GameCanvas.a(StringUtils.cX(), new ActionListener139());
                    break;
                }
                case 2: {
                    if (BattleManager.var_game_PlayerEntity_arr_a[1].var_int_h <= 514) break;
                    var_int_n = -1;
                    GameCanvas.a(StringUtils.da(), new ActionListener015());
                    break;
                }
                case 3: {
                    if (BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b].var_int_w != 100 && BattleManager.var_game_PlayerEntity_arr_a[1].var_int_h <= GameHelper34.var_int_b && BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b].var_int_h <= GameHelper34.var_int_b) break;
                    var_int_n = -1;
                    GameCanvas.a(StringUtils.db(), new ActionListener022());
                }
            }
        }
        for (n2 = 0; n2 < BattleManager.var_game_PlayerEntity_arr_a.length; ++n2) {
            PlayerEntity playerEntity = BattleManager.var_game_PlayerEntity_arr_a[n2];
            if (playerEntity == null) continue;
            playerEntity.h();
        }
        if (this.var_int_ll1llIIl1l1l > 0) {
            --this.var_int_ll1llIIl1l1l;
        }
        BoardScreen.var_game_MapEntity_a.c();
        if (this.var_int_lIllllllIIlI > 0) {
            --this.var_int_lIllllllIIlI;
            if (this.var_int_lIllllllIIlI == 0) {
                if (this.ll11I1IIll.size() > 0) {
                    this.ll11I1IIll.removeElementAt(0);
                }
                if (this.ll11I1IIll.size() > 0) {
                    this.var_int_lIllllllIIlI = this.var_int_I1IlIlll;
                }
            }
        }
        var_game_GameHelper16_a.a();
        var_game_CharacterSelectScreen_a.a();
        GameHelper34.c();
        BattlePet.update();
        BattleManager.applyDeferredNextPlayer();
        VipManager.request();
        if ((++BattlePet.heartbeat % 90) == 0) {
            System.out.println("[hb] tick " + BattlePet.debugState());
        }
        n2 = 0;
        boolean bl = false;
        for (n = 0; n < BattleManager.var_game_PlayerEntity_arr_a.length; ++n) {
            object = BattleManager.var_game_PlayerEntity_arr_a[n];
            if (object == null) continue;
            ((PlayerEntity)object).a();
            if (((PlayerEntity)object).var_boolean_q) {
                BattleManager.var_int_arr_a[n2] = n;
                n2 = (byte)(n2 + 1);
            }
            if (!((PlayerEntity)object).var_boolean_n || ((PlayerEntity)object).var_byte_f == 5) continue;
            bl = true;
        }
        if (GameCanvas.var_int_a % 2 == 0) {
            if (++BattleManager.c == 10) {
                BattleManager.d = 0;
                BattleManager.c = 0;
            }
            BattleManager.d = BattleManager.c <= 5 ? ++BattleManager.d : --BattleManager.d;
        }
        if (CharacterSelectScreen.var_boolean_b && !bl) {
            ConnectionWatchdog.game_ConnectionWatchdog_a().g();
            BattleManager.game_PlayerEntity_a().var_boolean_d = false;
            PlayerEntity.var_boolean_c = false;
            CharacterSelectScreen.var_boolean_b = false;
        }
        var_game_BattleGraphicHelper_a.a();
        if (this.IIIl1llIllI != null) {
            this.IIIl1llIllI.a();
        }
        for (n = 0; n < var_java_util_Vector_a.size(); ++n) {
            object = (ServerInfo)var_java_util_Vector_a.elementAt(n);
            if (object == null) continue;
            ((ServerInfo)object).a();
        }
        for (n = 0; n < var_java_util_Vector_b.size(); ++n) {
            ((ChatScreen)var_java_util_Vector_b.elementAt(n)).a();
        }
        var_game_TurnTimer_a.c();
        if (++var_int_m > 10000) {
            var_int_m = 0;
        }
        if (this.l1II111I1) {
            --this.var_int_III111I11II1;
            if (this.var_int_III111I11II1 < 50) {
                this.l1II111I1 = false;
                this.var_int_III111I11II1 = GameCanvas.var_int_c / 2 - 15;
            }
        }
        if (this.var_java_util_Vector_c.size() != 0) {
            ++this.var_int_I1II1l1II1I1;
            if (this.var_int_I1II1l1II1I1 == 10) {
                for (n = 0; n < this.var_java_util_Vector_c.size(); ++n) {
                    object = (GameHelper14)this.var_java_util_Vector_c.elementAt(n);
                    if (((GameHelper14)object).a) continue;
                    ((GameHelper14)object).a = true;
                    break;
                }
                this.var_int_I1II1l1II1I1 = 0;
            }
        }
        for (n = 0; n < this.var_java_util_Vector_c.size(); ++n) {
            ((GameHelper14)this.var_java_util_Vector_c.elementAt(n)).a();
        }
    }

    public final void void_a(int n, int n2) {
        for (int i = 0; i < 8; ++i) {
            if (((PlayerAccountInfo)BoardScreen.var_game_BoardScreen_a.var_java_util_Vector_a.elementAt((int)i)).var_int_a != n2) continue;
            if (BattleManager.var_game_PlayerEntity_arr_a != null) {
                if (n > 0) {
                    this.a(n2, " +" + n + StringUtils.aq());
                    return;
                }
                this.a(n2, " -" + n + StringUtils.aq());
            }
            return;
        }
    }

    public final void a(byte by, int n) {
        block9: {
            block8: {
                this.ll11I1IIll.removeAllElements();
                this.var_int_Il1l11I1ll = n;
                this.var_int_III111I11II1 = GameCanvas.var_int_c / 2;
                this.l1II111I1 = true;
                var_game_TurnTimer_a.d();
                if (by != 0) break block8;
                var_java_lang_String_a = StringUtils.aJ();
                for (n = 0; n < BattleManager.var_game_PlayerEntity_arr_a.length; ++n) {
                    if (BattleManager.var_game_PlayerEntity_arr_a[n] == null) continue;
                    BattleManager.var_game_PlayerEntity_arr_a[n].var_boolean_v = false;
                }
                break block9;
            }
            if (BattleManager.var_game_PlayerEntity_arr_a[var_byte_b] == null) break block9;
            n = 1;
            if (by == 1) {
                var_java_lang_String_a = StringUtils.bf();
                if (!BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b].var_boolean_b) {
                    n = 0;
                }
            } else {
                var_java_lang_String_a = StringUtils.bg();
                if (BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b].var_boolean_b) {
                    n = 0;
                }
            }
            if ((n != 0) == BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b].var_boolean_b) {
                for (n = 0; n < BattleManager.var_game_PlayerEntity_arr_a.length; ++n) {
                    if (BattleManager.var_game_PlayerEntity_arr_a[n] == null) continue;
                    BattleManager.var_game_PlayerEntity_arr_a[n].var_boolean_v = false;
                    if (BattleManager.var_game_PlayerEntity_arr_a[n].var_int_w <= 0) continue;
                    if (BattleManager.var_game_PlayerEntity_arr_a[n].var_boolean_b && by != 0) {
                        BattleManager.var_game_PlayerEntity_arr_a[n].g();
                        continue;
                    }
                    if (BattleManager.var_game_PlayerEntity_arr_a[n].var_boolean_b || by != 0) continue;
                    BattleManager.var_game_PlayerEntity_arr_a[n].g();
                }
            }
        }
    }

    public static int[][] int_arr_arr_a(int n, int n2) {
        return new int[][]{{n, n + 30, n - 30, n, n, n + 10, n - 10}, {n2 - 85, n2 - 70, n2 - 70, n2 - 70, n2 - 35, n2, n2}};
    }

    public static void a(byte by, byte by2) {
        if (by2 == 1) {
            if (by == var_byte_b) {
                var_boolean_i = false;
            }
        } else {
            System.out.println("[eo] " + BattleManager.var_game_PlayerEntity_arr_a[by].var_java_lang_String_a + " CAN NOT SEE");
            if (by == var_byte_b) {
                var_boolean_i = true;
            }
        }
        BattleScreen.g();
    }

    public static void void_a(byte by) {
        BattleManager.var_game_PlayerEntity_arr_a[by].var_boolean_x = false;
        var_game_GameHelper16_a.a(by);
        BattleScreen.g();
    }

    public static void b(byte by) {
        var_game_GameHelper16_a.a(by);
        BattleScreen.g();
    }

    public static void b(byte by, byte by2) {
        BattleManager.var_game_PlayerEntity_arr_a[by].var_boolean_f = by2 != 1;
        BattleScreen.g();
    }

    public static void c(byte by) {
        BattleManager.var_game_PlayerEntity_arr_a[by].var_boolean_z = true;
        BattleScreen.g();
    }

    public final void a(Graphics graphics) {
        String string;
        Object object;
        int n;
        GameHelper16.a(graphics);
        if (var_boolean_i) {
            graphics.setColor(0xFFFFFF);
            graphics.fillRect(GameHelper16.b, GameHelper16.c, GameCanvas.var_int_b, GameCanvas.var_int_c);
        } else {
            if (var_byte_a != 2) {
                if (GameHelper34.var_game_ClanScreen_a != null) {
                    GameHelper34.var_game_ClanScreen_a.a(graphics);
                }
            } else {
                graphics.setColor(6483698);
                graphics.fillRect(GameHelper16.b, GameHelper16.c, GameCanvas.var_int_b, GameCanvas.var_int_c);
            }
            if (this.IIIl1llIllI != null) {
                this.IIIl1llIllI.c(graphics);
            }
            for (n = 0; n < GameHelper34.var_java_util_Vector_a.size(); ++n) {
                object = (PetEntity)GameHelper34.var_java_util_Vector_a.elementAt(n);
                if (object == null) continue;
                ((PetEntity)object).a(graphics);
            }
            for (n = 0; n < this.var_java_util_Vector_c.size(); ++n) {
                ((GameHelper14)this.var_java_util_Vector_c.elementAt(n)).a(graphics);
            }
            if (var_boolean_g) {
                GameHelper02.a(graphics, GameHelper16.b, GameHelper16.c, GameCanvas.var_int_b, GameCanvas.var_int_c);
            }
        }
        for (n = 0; n < var_java_util_Vector_a.size(); ++n) {
            object = (ServerInfo)var_java_util_Vector_a.elementAt(n);
            if (object == null || !DataUtils.a(((ServerInfo)object).var_int_b, ((ServerInfo)object).c, GameHelper16.b - 10, GameHelper16.c - 10, GameCanvas.var_int_b + 20, GameCanvas.var_int_c + 20)) continue;
            DataUtils.a(graphics, ChatScreen.b, 0, (GameCanvas.var_int_a % 3 != 0 ? 1 : 0) * 15, 28, 15, 0, ((ServerInfo)object).var_int_b, ((ServerInfo)object).c, 33);
        }
        for (n = 0; n < BattleManager.var_game_PlayerEntity_arr_a.length; ++n) {
            object = BattleManager.var_game_PlayerEntity_arr_a[n];
            if (object == null) continue;
            ((PlayerEntity)object).a(graphics);
        }
        BattlePet.draw(graphics);
        var_game_BattleGraphicHelper_a.a(graphics);
        var_game_CharacterSelectScreen_a.a(graphics);
        if (!var_boolean_i && GameHelper34.var_boolean_a) {
            ClanScreen.a(GameHelper34.var_byte_b, graphics);
        }
        for (n = 0; n < var_java_util_Vector_b.size(); ++n) {
            ((ChatScreen)var_java_util_Vector_b.elementAt(n)).a(graphics);
        }
        if (this.IIIl1llIllI != null) {
            this.IIIl1llIllI.a(graphics);
        }
        if (var_boolean_a) {
            graphics.setColor(0xFFFFFF);
            graphics.fillArc(GameHelper16.b + GameCanvas.var_int_b / 2 - this.var_int_lIII111lll1I, GameHelper16.c + GameCanvas.var_int_b / 2 - this.var_int_lIII111lll1I, this.var_int_ll1ll1IIl, this.var_int_ll1ll1IIl, 0, 360);
            this.var_int_lIII111lll1I += 30;
            this.var_int_ll1ll1IIl += 60;
            if (this.var_int_lIII111lll1I > GameCanvas.var_int_b + 100) {
                this.var_int_lIII111lll1I = 0;
                this.var_int_ll1ll1IIl = 0;
                int[][] coords = BattleScreen.int_arr_arr_a(var_int_a, var_int_b);
                for (n = 0; n < 7; ++n) {
                    new ChatScreen(coords[0][n], coords[1][n], 7);
                }
                var_boolean_a = false;
            }
        }
        if (var_boolean_b) {
            ++this.var_int_IlI111ll1I;
            if (this.var_int_IlI111ll1I % 2 == 0) {
                new ChatScreen(var_int_c + DataUtils.b(-20, 20), var_int_d + DataUtils.b(-20, 20), 8);
            }
            if (this.var_int_IlI111ll1I == 10) {
                this.var_int_IlI111ll1I = 0;
                var_boolean_b = false;
            }
        }
        if (var_boolean_c) {
            ++this.var_int_IlI111ll1I;
            if (this.var_int_IlI111ll1I % 2 == 0) {
                new ChatScreen(var_int_e + DataUtils.b(-50, 50), var_int_f + DataUtils.b(-50, 50), 14);
            }
            if (this.var_int_IlI111ll1I == 30) {
                this.var_int_IlI111ll1I = 0;
                var_boolean_c = false;
            }
        }
        if (var_boolean_d) {
            ++this.var_int_IlI111ll1I;
            if (this.var_int_IlI111ll1I % 2 == 0) {
                new ChatScreen(var_int_g + DataUtils.b(-50, 50), var_int_h + DataUtils.b(-50, 50), 0);
            }
            if (this.var_int_IlI111ll1I == 60) {
                this.var_int_IlI111ll1I = 0;
                var_boolean_d = false;
            }
        }
        if (var_boolean_e) {
            ++this.var_int_IlI111ll1I;
            if (this.var_int_IlI111ll1I % 2 == 0) {
                new ChatScreen(var_int_i + DataUtils.b(-50, 50), var_int_j + DataUtils.b(-50, 50), 15);
            }
            if (this.var_int_IlI111ll1I == 60) {
                this.var_int_IlI111ll1I = 0;
                var_boolean_e = false;
            }
        }
        graphics.translate(-graphics.getTranslateX(), -graphics.getTranslateY());
        if (GameHelper16.var_int_a == 2 && var_int_m / 2 % 2 == 0) {
            graphics.setColor(0xFF0000);
            graphics.fillRect(0, 0, GameCanvas.var_int_b, 10);
            graphics.fillRect(0, GameCanvas.var_int_c - 10, GameCanvas.var_int_b, 10);
            graphics.fillRect(0, 0, 10, GameCanvas.var_int_c);
            graphics.fillRect(GameCanvas.var_int_b - 10, 0, 10, GameCanvas.var_int_c);
        }
        if (!var_boolean_f) {
            var_game_TurnTimer_a.a(graphics);
        }
        graphics.drawImage(this.var_javax_microedition_lcdui_Image_ll1ll1IIl, GameCanvas.var_int_b / 2, 20, 3);
        if (I1III111lll != 0) {
            graphics.setColor(1403067);
            graphics.fillArc(GameCanvas.var_int_b / 2 - 15 + this.lll1lI11l, 5 + this.lll1lI11l, 30 - 2 * this.lll1lI11l, 30 - 2 * this.lll1lI11l, var_int_I1IllIlII - 20, 40);
        }
        this.lll1lI11l = !this.var_boolean_ll1ll1IIl ? ++this.lll1lI11l : --this.lll1lI11l;
        if (this.lll1lI11l > 5) {
            this.var_boolean_ll1ll1IIl = true;
        }
        if (this.lll1lI11l < 0) {
            this.var_boolean_ll1ll1IIl = false;
        }
        graphics.drawImage(this.var_javax_microedition_lcdui_Image_lIII111lll1I, GameCanvas.var_int_b / 2, 20, 3);
        FontRenderer.e.a(graphics, String.valueOf(I1III111lll), GameCanvas.var_int_b / 2, 12, 3);
        FontRenderer.e.a(graphics, "G\u00f3c: " + var_int_I1IllIlII, GameCanvas.var_int_b / 2, 35, 3);
        if (this.ll1IIlllI11I) {
            if (GameCanvas.var_boolean_d) {
                BaseScreen.a(graphics, GameCanvas.var_int_e - 65, 4, 130, StringUtils.m());
                BattleScreen.lI1II1I11l(graphics, GameCanvas.var_int_d - 67, GameCanvas.var_int_e - 20);
                graphics.drawImage(this.var_javax_microedition_lcdui_Image_I1II1l1II1I1, 25, 5, 0);
            } else {
                BattleScreen.lI1II1I11l(graphics, GameCanvas.var_int_d - 27, GameCanvas.var_int_e);
            }
        }
        if (!GameCanvas.var_game_PopupMenu_a.var_boolean_a && GameCanvas.var_game_GameHelper21_a == null && !this.ll1IIlllI11I) {
            if (!GameCanvas.var_boolean_d) {
                graphics.drawImage(this.var_javax_microedition_lcdui_Image_I1II1l1II1I1, 2, GameCanvas.var_int_c - 10, 0);
                if (GameHelper16.var_byte_a == 0) {
                    if (GameCanvas.var_int_a % 10 > 5) {
                        graphics.drawImage(this.var_javax_microedition_lcdui_Image_I1IllIlII, GameCanvas.var_int_b - 20, GameCanvas.var_int_c - 18, 0);
                    }
                } else {
                    graphics.drawImage(this.var_javax_microedition_lcdui_Image_I1IllIlII, GameCanvas.var_int_b - 20, GameCanvas.var_int_c - 18, 0);
                }
            } else {
                graphics.drawImage(this.var_javax_microedition_lcdui_Image_I1II1l1II1I1, 25, 5, 0);
                graphics.drawImage(BoardScreen.var_javax_microedition_lcdui_Image_c, 65, 5, 0);
                if (GameHelper16.var_byte_a != 0 || GameCanvas.var_int_a % 10 > 5) {
                    graphics.drawImage(this.var_javax_microedition_lcdui_Image_I1IllIlII, GameCanvas.var_int_b - 20, 5, 0);
                }
            }
        }
        // Khung luc ban (thanh luc) luon duoc ve khi nhan vat cua minh con trong tran,
        // khong phu thuoc luot hien tai. Chi phan "fill" moi phu thuoc viec dang keo luc.
        PlayerEntity me = null;
        if (BattleManager.var_game_PlayerEntity_arr_a != null
                && BattleScreen.var_byte_b >= 0
                && BattleScreen.var_byte_b < BattleManager.var_game_PlayerEntity_arr_a.length) {
            me = BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b];
        }
        if (me != null && var_game_GameHelper29_a != null) {
            boolean myTurn = BattleManager.boolean_a();
            int n2 = GameCanvas.var_int_b >> 1;
            n = GameCanvas.var_int_c - 20;
            int n3 = me.var_int_l;
            byte by = (me.var_byte_f == 3 || me.l111ll1l) ? me.var_byte_d : (byte)0;

            // Bo clip cu (co the con sot lai tu lan ve truoc) de khung luc khong bi mat.
            graphics.setClip(0, 0, GameCanvas.var_int_b, GameCanvas.var_int_c);

            // Thanh di chuyen (xanh)
            var_game_GameHelper29_a.a(1, n2 - 63, n + 5, 0, 0, graphics);
            graphics.setClip(n2 - 61, n + 5, barWidth((60 - me.var_int_n) * 49 / 60), 13);
            var_game_GameHelper29_a.a(0, n2 - 63, n + 5, 0, 0, graphics);
            graphics.setClip(0, 0, GameCanvas.var_int_b, GameCanvas.var_int_c);

            // Khung luc 1 (do) - luon ve khung, chi fill khi dang keo
            var_game_GameHelper29_a.a(3, n2 + 10, n + 5, 0, 0, graphics);
            graphics.setClip(n2 + 12, n + 5, barWidth(by * 49 / 30), 13);
            var_game_GameHelper29_a.a(2, n2 + 10, n + 5, 0, 0, graphics);
            graphics.setClip(0, 0, GameCanvas.var_int_b, GameCanvas.var_int_c);

            // Thanh HP (vang)
            var_game_GameHelper29_a.a(5, n2 - 63, n - 7, 0, 0, graphics);
            graphics.setClip(n2 - 61, n - 7, barWidth(me.var_byte_i * 49 / 100), 13);
            var_game_GameHelper29_a.a(4, n2 - 63, n - 7, 0, 0, graphics);
            graphics.setClip(0, 0, GameCanvas.var_int_b, GameCanvas.var_int_c);

            if (myTurn && n3 > 0) {
                graphics.setColor(16482687);
                graphics.drawLine(n2 + 12 + n3 * 49 / 30, n + 7, n2 + 12 + n3 * 49 / 30, n + 14);
            }

            // Khung luc 2 (do) - chi hien sau khi luc 1 da day
            if (me.has2Force() && me.l111ll1l) {
                int y2 = GameCanvas.var_int_c - 35;
                int mark = me.var_int_m;
                byte by2 = (me.var_byte_f == 3) ? me.var_byte_e : (byte)0;
                var_game_GameHelper29_a.a(3, n2 + 10, y2 + 8, 0, 0, graphics);
                graphics.setClip(n2 + 12, y2 + 8, barWidth(by2 * 49 / 30), 13);
                var_game_GameHelper29_a.a(2, n2 + 10, y2 + 8, 0, 0, graphics);
                graphics.setClip(0, 0, GameCanvas.var_int_b, GameCanvas.var_int_c);
                if (myTurn && mark > 0) {
                    graphics.setColor(16482687);
                    graphics.drawLine(n2 + 12 + mark * 49 / 30, y2 + 10, n2 + 12 + mark * 49 / 30, y2 + 17);
                }
            }

            n = GameCanvas.var_int_c - 17;
            n3 = me.var_int_r;
            graphics.drawImage(var_javax_microedition_lcdui_Image_I1IlIlll, n2, n + 2, 17);
            FontRenderer.h.a(graphics, String.valueOf(n3 < 90 ? n3 : 180 - n3), n2, n + 4, 2);
            if (GameCanvas.var_boolean_d && myTurn) {
                graphics.setClip(0, 0, GameCanvas.var_int_b, GameCanvas.var_int_c);
                if (!this.var_boolean_IlI111ll1I) {
                    graphics.drawImage(this.var_javax_microedition_lcdui_Image_Il1l11I1ll, l1I11lIl, ll1IIllIlI11, 0);
                } else {
                    graphics.drawImage(this.var_javax_microedition_lcdui_Image_III111I11II1, l1I11lIl, ll1IIllIlI11, 0);
                }
                if (this.var_boolean_IlI111ll1I) {
                    graphics.drawImage(this.var_javax_microedition_lcdui_Image_lIllllllIIlI, l1111ll1IIll, lI1ll11I1I, 0);
                    DataUtils.a(graphics, this.var_javax_microedition_lcdui_Image_lIllllllIIlI, 0, 0, this.var_javax_microedition_lcdui_Image_lIllllllIIlI.getWidth(), this.var_javax_microedition_lcdui_Image_lIllllllIIlI.getHeight(), 3, l1I11I1IIl, I1IIIllI, 20);
                    DataUtils.a(graphics, this.var_javax_microedition_lcdui_Image_lIllllllIIlI, 0, 0, this.var_javax_microedition_lcdui_Image_lIllllllIIlI.getWidth(), this.var_javax_microedition_lcdui_Image_lIllllllIIlI.getHeight(), 6, III1IIlI1lll, IllIl1II11l, 0);
                    DataUtils.a(graphics, this.var_javax_microedition_lcdui_Image_lIllllllIIlI, 0, 0, this.var_javax_microedition_lcdui_Image_lIllllllIIlI.getWidth(), this.var_javax_microedition_lcdui_Image_lIllllllIIlI.getHeight(), 5, IIIllIIII11, IIl1IIIll11, 0);
                    if (GameCanvas.var_boolean_arr_b[5] || GameCanvas.var_boolean_arr_b[5]) {
                        graphics.drawImage(this.var_javax_microedition_lcdui_Image_llIl1lIl1l, I1I1l11ll1II, ll1lll1Il, 0);
                    }
                    graphics.drawImage(this.var_javax_microedition_lcdui_Image_lll1IIlI1l11, I1I1l11ll1II, ll1lll1Il, 0);
                }
            }
        }
        if (!var_java_lang_String_a.equals("")) {
            FontRenderer.f.a(graphics, var_java_lang_String_a, GameCanvas.var_int_b / 2, 80, 3);
            FontRenderer.e.a(graphics, StringUtils.dE() + ": " + DataUtils.a((long)this.var_int_Il1l11I1ll) + " " + StringUtils.aq(), GameCanvas.var_int_b / 2, this.var_int_III111I11II1, 3);
        }
        if (BattleManager.game_PlayerEntity_a() != null && (string = BattleManager.game_PlayerEntity_a().var_java_lang_String_a) != null && !(BattleManager.game_PlayerEntity_a() instanceof PopupDialog)) {
            (BattleManager.game_PlayerEntity_a().var_boolean_b ? FontRenderer.g : FontRenderer.h).a(graphics, string, GameCanvas.var_int_b - 16, (GameCanvas.var_boolean_d ? 25 : 0) + 22, 2);
            VipManager.drawAfterName(graphics, (BattleManager.game_PlayerEntity_a().var_boolean_b ? FontRenderer.g : FontRenderer.h), string, BattleManager.game_PlayerEntity_a().var_int_vipUserId, GameCanvas.var_int_b - 16, (GameCanvas.var_boolean_d ? 25 : 0) + 22);
        }
        graphics.setClip(0, 0, GameCanvas.var_int_b, GameCanvas.var_int_c);
        if (GameHelper16.var_byte_a == 0) {
            FontRenderer.e.a(graphics, StringUtils.cQ(), GameCanvas.var_int_d, GameCanvas.var_int_e - 15, 2);
            int n4 = GameCanvas.var_int_a % 10 > 4 ? 2 : 0;
            graphics.drawImage(var_javax_microedition_lcdui_Image_ll1llIIl1l1l, n4, GameCanvas.var_int_e, 6);
            DataUtils.a(graphics, var_javax_microedition_lcdui_Image_ll1llIIl1l1l, 0, 0, var_javax_microedition_lcdui_Image_ll1llIIl1l1l.getWidth(), var_javax_microedition_lcdui_Image_ll1llIIl1l1l.getHeight(), 2, GameCanvas.var_int_b - n4, GameCanvas.var_int_d, 10);
            DataUtils.a(graphics, var_javax_microedition_lcdui_Image_ll1llIIl1l1l, 0, 0, var_javax_microedition_lcdui_Image_ll1llIIl1l1l.getWidth(), var_javax_microedition_lcdui_Image_ll1llIIl1l1l.getHeight(), 5, GameCanvas.var_int_d, n4 + 25, 17);
            DataUtils.a(graphics, var_javax_microedition_lcdui_Image_ll1llIIl1l1l, 0, 0, var_javax_microedition_lcdui_Image_ll1llIIl1l1l.getWidth(), var_javax_microedition_lcdui_Image_ll1llIIl1l1l.getHeight(), 6, GameCanvas.var_int_d, GameCanvas.var_int_c - 30 - n4, 33);
        }
        if (!BoardScreen.var_game_MapEntity_a.java_lang_String_a().equals("")) {
            BoardScreen.var_game_MapEntity_a.a(graphics);
        }
        graphics.setClip(0, 0, GameCanvas.var_int_b, GameCanvas.var_int_c);
        if (this.ll11I1IIll.size() != 0) {
            String string2 = (String)this.ll11I1IIll.elementAt(0);
            n = this.var_int_I1IlIlll - this.var_int_lIllllllIIlI;
            if (n > 10) {
                n = 10;
            }
            n = GameCanvas.var_int_b >> n;
            FontRenderer.e.a(graphics, string2, n + 3, GameCanvas.var_int_c - 14, 0);
        }
        if (GameCanvas.var_game_GameHelper21_a != null) {
            BaseScreen.c(graphics);
        }
    }

    public final void b(int n) {
        if (GameCanvas.var_game_GameHelper21_a == null && GameHelper16.var_byte_a != 0 && !GameCanvas.var_boolean_d) {
            BoardScreen.var_game_MapEntity_a.boolean_a(n);
        }
    }

    public static void b(int n, int n2) {
        var_int_k = n;
        var_int_l = n2;
        var_int_I1IllIlII = DataUtils.c(DataUtils.a(n, -n2));
        I1III111lll = DataUtils.e(n * n + n2 * n2);
    }

    public final void a(BaseScreen baseScreen) {
        this.b = baseScreen;
        super.b_();
    }

    private static void lI1II1I11l(Graphics graphics, int n, int n2) {
        if (!GameCanvas.var_boolean_d) {
            graphics.setColor(16768329);
            graphics.fillRect(GameHelper16.b, n2 - 1, GameCanvas.var_int_b, GameCanvas.var_boolean_d ? 43 : 36);
        }
        GameHelper31.a(graphics, BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b].var_int_arr_a, var_int_llIl1lIl1l, n, n2, GameCanvas.var_boolean_d, BoardScreen.var_byte_b != 7 ? null : var_byte_arr_a);
        FontRenderer.e.a(graphics, StringUtils.cM(), GameHelper16.b + 5, GameHelper16.c + GameCanvas.var_int_c - FontRenderer.a.a() - 4, 0);
        FontRenderer.e.a(graphics, StringUtils.dI(), GameHelper16.b + GameCanvas.var_int_b - 5, GameHelper16.c + GameCanvas.var_int_c - FontRenderer.a.a() - 4, 1);
    }

    public final void a(int n, String string) {
        if (BoardScreen.var_byte_b != 7) {
            this.ll11I1IIll.addElement(BoardScreen.var_game_BoardScreen_a.java_lang_String_a(n) + ": " + string);
        } else {
            this.ll11I1IIll.addElement(BattleManager.java_lang_String_a(n) + ": " + string);
        }
        if (this.var_int_lIllllllIIlI == 0) {
            this.var_int_lIllllllIIlI = this.var_int_I1IlIlll;
        }
    }

    static void void_a(BattleScreen battleScreen) {
        battleScreen.ll1IIlllI11I = true;
    }

    static int int_a(BattleScreen battleScreen) {
        return battleScreen.var_int_lll1IIlI1l11;
    }

    static void a(BattleScreen battleScreen, int n) {
        battleScreen.var_int_lll1IIlI1l11 = n;
    }

    static void h() {
        if (var_game_BattleManager_a != null && BattleManager.var_game_PlayerEntity_arr_a != null && BattleManager.var_game_PlayerEntity_arr_a[var_byte_b] != null) {
            ConnectionWatchdog.game_ConnectionWatchdog_a().b();
            GameCanvas.c(StringUtils.dU());
            ConnectionWatchdog.game_ConnectionWatchdog_a().void_a();
        }
    }

    // Gioi han be rong phan fill cua thanh luc trong khoang 0..49 pixel.
    private static int barWidth(int n) {
        if (n < 0) {
            return 0;
        }
        return n > 49 ? 49 : n;
    }

    static {
        var_byte_a = 0;
        var_java_util_Vector_a = new Vector();
        GameHelper28 gameHelper28 = new GameHelper28("/gui/gui");
        Image[] imageArray = new Image[9];
        var_javax_microedition_lcdui_Image_arr_a = imageArray;
        imageArray[0] = gameHelper28.a("on.png");
        BattleScreen.var_javax_microedition_lcdui_Image_arr_a[1] = gameHelper28.a("off.png");
        BattleScreen.var_javax_microedition_lcdui_Image_arr_a[2] = gameHelper28.a("r2.png");
        BattleScreen.var_javax_microedition_lcdui_Image_arr_a[3] = gameHelper28.a("arrowup.png");
        BattleScreen.var_javax_microedition_lcdui_Image_arr_a[4] = gameHelper28.a("tile1.png");
        Image[] imageArray2 = new Image[2];
        var_javax_microedition_lcdui_Image_arr_b = imageArray2;
        imageArray2[0] = gameHelper28.a("msg0.png");
        BattleScreen.var_javax_microedition_lcdui_Image_arr_b[1] = gameHelper28.a("msg1.png");
        var_javax_microedition_lcdui_Image_a = gameHelper28.a("fighter.png");
        var_javax_microedition_lcdui_Image_b = gameHelper28.a("mode.png");
        var_javax_microedition_lcdui_Image_c = gameHelper28.a("lock2.png");
        var_javax_microedition_lcdui_Image_d = gameHelper28.a("lock.png");
        var_javax_microedition_lcdui_Image_e = gameHelper28.a("hongTam.png");
        var_javax_microedition_lcdui_Image_f = gameHelper28.a("item.png");
        var_javax_microedition_lcdui_Image_g = gameHelper28.a("logoGame.png");
        var_javax_microedition_lcdui_Image_i = gameHelper28.a("quanham.png");
        var_javax_microedition_lcdui_Image_j = gameHelper28.a("menubg.png");
        var_javax_microedition_lcdui_Image_k = gameHelper28.a("stat.png");
        var_javax_microedition_lcdui_Image_l = gameHelper28.a("trs.png");
        var_javax_microedition_lcdui_Image_m = gameHelper28.a("icon.png");
        var_javax_microedition_lcdui_Image_I1IlIlll = gameHelper28.a("angle.png");
        var_game_GameHelper29_a = new GameHelper29(gameHelper28.a("bar.png"), 53, 12);
        var_javax_microedition_lcdui_Image_n = gameHelper28.a("chat.png");
        o = gameHelper28.a("transparent.png");
        var_javax_microedition_lcdui_Image_h = gameHelper28.a("logo_2.png");
        p = gameHelper28.a("arrowMenu.png");
        var_int_m = 0;
        var_boolean_g = false;
        var_java_lang_String_a = "";
        var_byte_arr_a = new byte[8];
    }
}

