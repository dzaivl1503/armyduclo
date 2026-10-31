/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
package game;

import game.ActionListener008;
import game.ActionListener024;
import game.ActionListener050;
import game.ActionListener052;
import game.ActionListener088;
import game.ActionListener096;
import game.ActionListener110;
import game.ActionListener133;
import game.ActionListener140;
import game.ActionListener171;
import game.ActionListener180;
import game.ActionListener205;
import game.ActionListener214;
import game.ActionListener215;
import game.BaseScreen;
import game.BattleScreen;
import game.CharacterUpgradeScreen;
import game.ChatPopup;
import game.ClanScreen;
import game.ConnectionWatchdog;
import game.DataUtils;
import game.ExplosionEffect;
import game.FontRenderer;
import game.GameCanvas;
import game.GameCommand;
import game.GameHelper05;
import game.GameHelper11;
import game.GameHelper18;
import game.GameHelper28;
import game.GameHelper31;
import game.GameHelper34;
import game.GameHelper44;
import game.MapEntity;
import game.PlayerAccountInfo;
import game.PlayerEntity;
import game.ShopScreen;
import game.StringUtils;
import game.TerrainMidlet;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class BoardScreen
extends BaseScreen {
    public static BoardScreen var_game_BoardScreen_a;
    public static final String[] var_java_lang_String_arr_a;
    public static byte var_byte_a;
    public static byte var_byte_b;
    public Vector var_java_util_Vector_a = new Vector();
    public Vector var_java_util_Vector_b = new Vector();
    public static Image[] var_javax_microedition_lcdui_Image_arr_a;
    private static Image var_javax_microedition_lcdui_Image_llll11I11Il;
    private static Image var_javax_microedition_lcdui_Image_I1llIIII;
    public static Image var_javax_microedition_lcdui_Image_a;
    public static Image var_javax_microedition_lcdui_Image_b;
    private static Image var_javax_microedition_lcdui_Image_l11IIIll1;
    public static Image var_javax_microedition_lcdui_Image_c;
    public static byte[] var_byte_arr_a;
    public static byte[] var_byte_arr_b;
    public int[] var_int_arr_lIII1III11I = new int[8];
    public int[] var_int_arr_llI1lI1Il = new int[8];
    public int var_int_lIII1III11I;
    public int var_int_llI1lI1Il;
    private int var_int_Il111I11 = -1;
    public static byte var_byte_c;
    public int[] var_int_arr_a = new int[8];
    public static GameHelper11 var_game_GameHelper11_a;
    private boolean var_boolean_l111Il11 = false;
    private boolean var_boolean_lIII1III11I = false;
    private int var_int_I1II111II1;
    private int var_int_llll11I11Il = 0;
    private int var_int_I1llIIII = 0;
    private int var_int_l11IIIll1 = 0;
    private int var_int_lIlll1II11l = 0;
    public static MapEntity var_game_MapEntity_a;
    private GameCommand var_game_GameCommand_l111Il11;
    private GameCommand var_game_GameCommand_lIII1III11I;
    private GameCommand var_game_GameCommand_llI1lI1Il;
    private GameCommand var_game_GameCommand_Il111I11;
    private GameCommand var_game_GameCommand_I1II111II1;
    private GameCommand var_game_GameCommand_lIlll1II11l;
    private GameCommand var_game_GameCommand_II1lIIl1;
    private GameCommand l1II1lIl1l;
    private GameCommand I11lIl1ll;
    private GameCommand I1lIIllI;
    private GameCommand IIIllI1Il;
    private GameCommand IlI1I11IIII;
    private GameCommand IIlII1llll;
    private GameCommand IlIl1IIl1Il;
    public static Image[] var_javax_microedition_lcdui_Image_arr_b;
    public static Image d;
    public static Image e;
    private static Image var_javax_microedition_lcdui_Image_lIlll1II11l;
    public static Image[] var_javax_microedition_lcdui_Image_arr_c;
    private int var_int_II1lIIl1 = 0;
    public int var_int_a;
    private boolean var_boolean_llI1lI1Il;

    public static void a(byte[] bytes) {
        GameHelper44.var_game_GameHelper44_a = new GameHelper44();
        var_javax_microedition_lcdui_Image_arr_a = new Image[GameHelper34.var_byte_a];
        new StringBuffer("[jg] MM.NUMBMAP= ").append(GameHelper34.var_byte_a);
        GameHelper28 helper = new GameHelper28(bytes);
        for (int i = 0; i < GameHelper34.var_byte_a; ++i) {
            new StringBuffer("[jg] i= ").append(GameHelper34.var_java_lang_String_arr_b[i]);
            BoardScreen.var_javax_microedition_lcdui_Image_arr_a[i] = helper.a(GameHelper34.var_java_lang_String_arr_b[i] + ".png");
        }
        var_javax_microedition_lcdui_Image_b = helper.a("khungmap.png");
    }

    private void I111l11IIll() {
        for (int i = 0; i < this.var_int_arr_a.length; ++i) {
            this.var_int_arr_a[i] = -2;
        }
        this.var_int_arr_a[0] = 0;
        this.var_int_arr_a[1] = 0;
        this.var_int_arr_a[2] = 1;
        this.var_int_arr_a[3] = 1;
    }

    public static int[] int_arr_a() {
        int[] nArray = new int[8];
        int[] nArray2 = nArray;
        nArray[0] = 0;
        nArray2[1] = 0;
        nArray2[2] = 0;
        nArray2[3] = 0;
        nArray2[4] = 0;
        nArray2[5] = 0;
        nArray2[6] = 0;
        nArray2[7] = 0;
        return nArray2;
    }

    public final int[] int_arr_b() {
        int[] nArray = new int[this.var_int_arr_a.length];
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = this.var_int_arr_a[i];
        }
        return nArray;
    }

    public final void a(int n, PlayerAccountInfo playerAccountInfo) {
        this.var_java_util_Vector_a.setElementAt(playerAccountInfo, n);
    }

    public BoardScreen() {
        this.var_int_arr_lIII1III11I[0] = 24;
        this.var_int_arr_llI1lI1Il[0] = GameCanvas.var_int_c - 128;
        this.var_int_arr_lIII1III11I[1] = GameCanvas.var_int_b - 24;
        this.var_int_arr_llI1lI1Il[1] = GameCanvas.var_int_c - 128;
        this.var_int_arr_lIII1III11I[2] = 62;
        this.var_int_arr_llI1lI1Il[2] = GameCanvas.var_int_c - 80;
        this.var_int_arr_lIII1III11I[3] = GameCanvas.var_int_b - 62;
        this.var_int_arr_llI1lI1Il[3] = GameCanvas.var_int_c - 80;
        this.var_int_arr_lIII1III11I[4] = 62;
        this.var_int_arr_llI1lI1Il[4] = GameCanvas.var_int_c - 128;
        this.var_int_arr_lIII1III11I[5] = GameCanvas.var_int_b - 62;
        this.var_int_arr_llI1lI1Il[5] = GameCanvas.var_int_c - 128;
        this.var_int_arr_lIII1III11I[6] = 24;
        this.var_int_arr_llI1lI1Il[6] = GameCanvas.var_int_c - 80;
        this.var_int_arr_lIII1III11I[7] = GameCanvas.var_int_b - 24;
        this.var_int_arr_llI1lI1Il[7] = GameCanvas.var_int_c - 80;
        this.I111l11IIll();
        this.var_int_llll11I11Il = GameCanvas.var_int_b - (GameHelper31.var_int_c * 18 + 5);
        this.var_int_I1llIIII = GameCanvas.var_int_c - (BaseScreen.var_int_r + 42) + 5;
        this.var_int_lIlll1II11l = GameCanvas.var_int_b / 2 - 80 + 12;
        this.var_int_l11IIIll1 = GameCanvas.var_int_c / 2 - 40;
        var_game_MapEntity_a = new MapEntity();
        BoardScreen.var_game_MapEntity_a.var_int_a = 2;
        BoardScreen.var_game_MapEntity_a.var_int_b = GameCanvas.var_int_c - BaseScreen.var_int_o - 25;
        if (GameCanvas.var_boolean_d) {
            BoardScreen.var_game_MapEntity_a.var_int_b = GameCanvas.var_int_c - BaseScreen.var_int_o - 45;
        }
        BoardScreen.var_game_MapEntity_a.var_int_c = GameCanvas.var_int_b - 4;
        BoardScreen.var_game_MapEntity_a.d = BaseScreen.var_int_o + 2;
        BoardScreen.var_game_MapEntity_a.var_boolean_a = true;
        this.var_game_GameCommand_I1II111II1 = new GameCommand("Menu", new ActionListener180(this));
        this.var_game_GameCommand_l111Il11 = new GameCommand("Chat", new ActionListener215(this));
        this.var_game_GameCommand_lIlll1II11l = new GameCommand(StringUtils.dR(), new ActionListener205());
        this.var_game_GameCommand_II1lIIl1 = new GameCommand(StringUtils.cU(), new ActionListener024(this));
        this.IIlII1llll = new GameCommand(StringUtils.dP(), new ActionListener133());
        this.IlIl1IIl1Il = new GameCommand(StringUtils.dQ(), new ActionListener088());
        this.var_game_GameCommand_Il111I11 = new GameCommand(StringUtils.bD(), new ActionListener140(this));
        this.var_game_GameCommand_llI1lI1Il = new GameCommand(StringUtils.aS(), new ActionListener096(this));
        this.var_game_GameCommand_lIII1III11I = new GameCommand(StringUtils.dU(), new ActionListener052(this));
        this.I1lIIllI = new GameCommand(StringUtils.dH(), new ActionListener008(this));
        this.IIIllI1Il = new GameCommand(StringUtils.dS(), new ActionListener171());
        this.IlI1I11IIII = new GameCommand(StringUtils.dT(), new ActionListener050(this));
        this.l1II1lIl1l = new GameCommand(StringUtils.dF(), new ActionListener214(this));
        this.I11lIl1ll = new GameCommand(StringUtils.dH(), new ActionListener110(this));
        this.f = this.var_game_GameCommand_I1II111II1;
        this.h = this.var_game_GameCommand_lIII1III11I;
    }

    public final void a(int n, byte by) {
        int n2 = this.IIIIII1llI(n);
        if (n2 >= 0 && n2 < this.var_java_util_Vector_a.size() && by >= 0 && by < this.var_java_util_Vector_a.size()) {
            this.var_java_util_Vector_a.setElementAt(this.var_java_util_Vector_a.elementAt(n2), by);
            this.var_java_util_Vector_a.setElementAt(new PlayerAccountInfo(), n2);
        }
        if (n == TerrainMidlet.myInfo.var_int_a) {
            this.var_int_Il111I11 = by;
        }
        new StringBuffer("[jg] indexOfme= ").append(this.var_int_Il111I11);
    }

    private int IIIIII1llI(int n) {
        for (int i = 0; i < this.var_java_util_Vector_a.size(); ++i) {
            if (((PlayerAccountInfo)this.var_java_util_Vector_a.elementAt((int)i)).var_int_a != n) continue;
            return i;
        }
        return -1;
    }

    public void void_b() {
        if (GameCanvas.var_boolean_c) {
            if (GameCanvas.a(this.var_int_llll11I11Il - 10, this.var_int_I1llIIII - 10, 300, 50)) {
                this.var_boolean_llI1lI1Il = true;
            }
            if (this.var_boolean_llI1lI1Il && !this.var_boolean_l111Il11 && GameCanvas.a(this.var_int_lIlll1II11l - 30, this.var_int_l11IIIll1 - 30, 220, 140)) {
                int n = ((GameCanvas.g - (this.var_int_l11IIIll1 - 10)) / 40 << 2) + (GameCanvas.f - (this.var_int_lIlll1II11l - 10)) / 40;
                if (this.var_int_I1II111II1 != n) {
                    this.var_int_I1II111II1 = n;
                } else {
                    this.g.var_game_IActionListener_a.a();
                }
            }
        }
        if (this.var_boolean_l111Il11) {
            var_game_GameHelper11_a.a();
        }
        if (GameCanvas.var_boolean_arr_a[2]) {
            if (!this.var_boolean_l111Il11) {
                this.var_int_I1II111II1 -= 4;
                if (this.var_int_I1II111II1 < 0) {
                    this.var_int_I1II111II1 = 0;
                }
            }
        } else if (GameCanvas.var_boolean_arr_a[8]) {
            if (!this.var_boolean_l111Il11) {
                this.var_int_I1II111II1 += 4;
                if (this.var_int_I1II111II1 > 7) {
                    this.var_int_I1II111II1 = 7;
                }
            }
        } else if (GameCanvas.var_boolean_arr_a[4]) {
            if (!this.var_boolean_l111Il11) {
                --this.var_int_I1II111II1;
                if (this.var_int_I1II111II1 < 0) {
                    this.var_int_I1II111II1 = 7;
                }
            }
        } else if (GameCanvas.var_boolean_arr_a[6] && !this.var_boolean_l111Il11) {
            ++this.var_int_I1II111II1;
            if (this.var_int_I1II111II1 % 4 == 0) {
                this.var_int_I1II111II1 = 0;
            }
        }
        if (GameCanvas.var_boolean_c && (GameCanvas.a(30, 0, 50, 50) || (var_game_MapEntity_a != null && GameCanvas.a(var_game_MapEntity_a.var_int_a, var_game_MapEntity_a.var_int_b, var_game_MapEntity_a.var_int_c, var_game_MapEntity_a.d)))) {
            var_game_MapEntity_a.void_a();
        }
        super.void_b();
        BaseScreen.m();
    }

    public void c() {
        PlayerAccountInfo playerAccountInfo;
        int n;
        if (this.var_int_a > 0) {
            --this.var_int_a;
        }
        if (this.var_int_II1lIIl1 > 0) {
            --this.var_int_II1lIIl1;
        }
        for (n = 0; n < this.var_java_util_Vector_a.size(); ++n) {
            playerAccountInfo = (PlayerAccountInfo)this.var_java_util_Vector_a.elementAt(n);
            if (playerAccountInfo == null) continue;
            playerAccountInfo.var_game_FloatingTextManager_a.b();
        }
        if (var_game_MapEntity_a.java_lang_String_a().equals("")) {
            this.f = this.var_game_GameCommand_I1II111II1;
            this.h = this.var_game_GameCommand_lIII1III11I;
            if (this.var_int_llI1lI1Il == TerrainMidlet.myInfo.var_int_a) {
                this.h = this.var_game_GameCommand_llI1lI1Il;
                this.var_game_GameCommand_llI1lI1Il.var_java_lang_String_a = StringUtils.aS();
            } else {
                this.h = var_byte_b != 7 ? this.var_game_GameCommand_Il111I11 : this.var_game_GameCommand_llI1lI1Il;
                this.var_game_GameCommand_Il111I11.var_java_lang_String_a = StringUtils.bD();
                boolean isMeReady = false;
                for (n = 0; n < this.var_java_util_Vector_a.size(); ++n) {
                    playerAccountInfo = (PlayerAccountInfo)this.var_java_util_Vector_a.elementAt(n);
                    if (playerAccountInfo == null) continue;
                    if (playerAccountInfo.var_int_a == TerrainMidlet.myInfo.var_int_a) {
                        this.var_int_Il111I11 = n;
                        if (playerAccountInfo.var_boolean_b) {
                            isMeReady = true;
                            this.var_game_GameCommand_Il111I11.var_java_lang_String_a = StringUtils.aK();
                            this.g = this.var_int_a == 0 ? this.var_game_GameCommand_Il111I11 : null;
                        }
                    }
                }
                if (!isMeReady && this.var_int_Il111I11 >= 0 && this.var_int_Il111I11 < this.var_java_util_Vector_a.size()) {
                    PlayerAccountInfo myAcc = (PlayerAccountInfo)this.var_java_util_Vector_a.elementAt(this.var_int_Il111I11);
                    if (myAcc != null && myAcc.var_boolean_b) {
                        isMeReady = true;
                    }
                }
                this.g = this.var_int_llI1lI1Il != TerrainMidlet.myInfo.var_int_a && isMeReady ? null : this.l1II1lIl1l;
            }
            if (this.var_boolean_l111Il11) {
                this.h = null;
                this.f = null;
            }
            if (this.var_boolean_l111Il11) {
                this.h = this.I11lIl1ll;
            }
            if (this.var_boolean_llI1lI1Il) {
                this.g = this.l1II1lIl1l;
                this.h = this.I1lIIllI;
                this.f = null;
            }
        } else {
            this.g = this.var_game_GameCommand_l111Il11;
            this.h = BoardScreen.var_game_MapEntity_a.var_game_GameCommand_a;
        }
        var_game_MapEntity_a.c();
        var_game_GameHelper11_a.b();
        GameHelper18.a();
    }

    public void a(Graphics graphics) {
        Object object;
        int n;
        ClanScreen.c(graphics);
        for (n = 0; n < GameCanvas.var_int_b; n += 32) {
            graphics.drawImage(var_javax_microedition_lcdui_Image_a, n, GameCanvas.var_int_c - 96 - 15, 0);
        }
        GameHelper18.a(graphics);
        if (GameCanvas.var_boolean_d) {
            graphics.translate(0, -15);
            graphics.translate(0, -5);
        }
        graphics.setColor(12965614);
        graphics.fillRect(0, GameCanvas.var_int_c - 96, GameCanvas.var_int_b, 45);
        for (n = 0; n < GameCanvas.var_int_b / var_javax_microedition_lcdui_Image_l11IIIll1.getWidth(); ++n) {
            DataUtils.a(graphics, var_javax_microedition_lcdui_Image_l11IIIll1, 0, 16, 33, 8, 0, (n + 1) * 33, GameCanvas.var_int_c - 96, 0);
        }
        graphics.fillRect(0, GameCanvas.var_int_c - 68, GameCanvas.var_int_b, 68);
        graphics.fillRect(0, GameCanvas.var_int_c - 96 - 12, 75, 45);
        graphics.fillRect(GameCanvas.var_int_b - 75, GameCanvas.var_int_c - 96 - 12, 75, 45);
        graphics.setColor(6985149);
        graphics.drawRect(-1, GameCanvas.var_int_c - 96 - 12, 76, 45);
        graphics.drawRect(GameCanvas.var_int_b - 76, GameCanvas.var_int_c - 96 - 12, 76, 45);
        graphics.setColor(9289);
        graphics.drawLine(76, GameCanvas.var_int_c - 96 - 12, 76, GameCanvas.var_int_c - 96 + 33);
        graphics.drawLine(GameCanvas.var_int_b - 77, GameCanvas.var_int_c - 96 - 12, GameCanvas.var_int_b - 77, GameCanvas.var_int_c - 96 + 33);
        for (n = 0; n < GameCanvas.var_int_b; ++n) {
            DataUtils.a(graphics, var_javax_microedition_lcdui_Image_l11IIIll1, 0, 16, 33, 8, 0, n * 33, GameCanvas.var_int_c - 68, 0);
        }
        graphics.setColor(6985149);
        graphics.drawLine(0, GameCanvas.var_int_c - 60, GameCanvas.var_int_b, GameCanvas.var_int_c - 60);
        for (n = 0; n < 2; ++n) {
            DataUtils.a(graphics, var_javax_microedition_lcdui_Image_l11IIIll1, 0, 16, 33, 8, 0, n * 33, GameCanvas.var_int_c - 96 - 20, 0);
            DataUtils.a(graphics, var_javax_microedition_lcdui_Image_l11IIIll1, 0, 16, 33, 8, 0, GameCanvas.var_int_b - n * 33, GameCanvas.var_int_c - 96 - 20, 24);
        }
        DataUtils.a(graphics, var_javax_microedition_lcdui_Image_l11IIIll1, 0, 0, 33, 8, 0, 66, GameCanvas.var_int_c - 96 - 20, 0);
        DataUtils.a(graphics, var_javax_microedition_lcdui_Image_l11IIIll1, 0, 8, 33, 8, 0, GameCanvas.var_int_b - 66, GameCanvas.var_int_c - 96 - 20, 24);
        graphics.translate(0, -graphics.getTranslateY());
        if (GameCanvas.var_boolean_d) {
            graphics.translate(0, -15);
        }
        if (var_byte_b != 7) {
            for (n = 0; n < 8 && n < this.var_java_util_Vector_a.size(); ++n) {
                object = (PlayerAccountInfo)this.var_java_util_Vector_a.elementAt(n);
                if (((PlayerAccountInfo)object).var_int_a == -1) continue;
                boolean bl = n % 2 != 0;
                PlayerEntity.a(graphics, ((PlayerAccountInfo)object).var_byte_a, 5, this.var_int_arr_lIII1III11I[n] + (bl ? -2 : 2), this.var_int_arr_llI1lI1Il[n] + (GameCanvas.var_boolean_d ? 8 : 13), bl ? 0 : 2, ((PlayerAccountInfo)object).var_game_EquipSlotSet_a);
                ((PlayerAccountInfo)object).a(graphics, this.var_int_arr_lIII1III11I[n] + (bl ? -2 : 2), this.var_int_arr_llI1lI1Il[n] + (GameCanvas.var_boolean_d ? 8 : 13), bl ? 0 : 2);
                if (((PlayerAccountInfo)object).var_javax_microedition_lcdui_Image_a != null) {
                    graphics.drawImage(((PlayerAccountInfo)object).var_javax_microedition_lcdui_Image_a, this.var_int_arr_lIII1III11I[n] - 18, this.var_int_arr_llI1lI1Il[n] - (BaseScreen.var_int_r - 4), 0);
                }
                BoardScreen.a(graphics, ((PlayerAccountInfo)object).g, this.var_int_arr_lIII1III11I[n], this.var_int_arr_llI1lI1Il[n] - 15, 3);
                (var_byte_b != 5 && n % 2 == 0 ? FontRenderer.g : FontRenderer.h).a(graphics, ((PlayerAccountInfo)object).var_java_lang_String_a, this.var_int_arr_lIII1III11I[n], this.var_int_arr_llI1lI1Il[n] + 15, 2);
                VipManager.drawAfterName(graphics, (var_byte_b != 5 && n % 2 == 0 ? FontRenderer.g : FontRenderer.h), ((PlayerAccountInfo)object).var_java_lang_String_a, ((PlayerAccountInfo)object).var_int_a, this.var_int_arr_lIII1III11I[n], this.var_int_arr_llI1lI1Il[n] + 15);
                if (((PlayerAccountInfo)object).var_boolean_b && ((PlayerAccountInfo)object).var_int_a != this.var_int_llI1lI1Il) {
                    FontRenderer.e.a(graphics, "ok", this.var_int_arr_lIII1III11I[n], this.var_int_arr_llI1lI1Il[n] - 32, 2);
                }
                if (((PlayerAccountInfo)object).var_int_a != this.var_int_llI1lI1Il) continue;
                FontRenderer.e.a(graphics, StringUtils.cB(), this.var_int_arr_lIII1III11I[n], this.var_int_arr_llI1lI1Il[n] - 32, 2);
            }
        } else {
            for (n = 0; n < this.var_java_util_Vector_a.size(); ++n) {
                object = (PlayerAccountInfo)this.var_java_util_Vector_a.elementAt(n);
                if (((PlayerAccountInfo)object).var_int_a == -1) continue;
                boolean bl = n % 2 != 0;
                PlayerEntity.a(graphics, ((PlayerAccountInfo)object).var_byte_a, 5, this.var_int_arr_lIII1III11I[0] + (bl ? -2 : 2), this.var_int_arr_llI1lI1Il[0] + (GameCanvas.var_boolean_d ? 8 : 13), bl ? 0 : 2, ((PlayerAccountInfo)object).var_game_EquipSlotSet_a);
                ((PlayerAccountInfo)object).a(graphics, this.var_int_arr_lIII1III11I[0] + (bl ? -2 : 2), this.var_int_arr_llI1lI1Il[0] + (GameCanvas.var_boolean_d ? 8 : 13), bl ? 0 : 2);
                if (((PlayerAccountInfo)object).var_javax_microedition_lcdui_Image_a != null) {
                    graphics.drawImage(((PlayerAccountInfo)object).var_javax_microedition_lcdui_Image_a, this.var_int_arr_lIII1III11I[0] - 18, this.var_int_arr_llI1lI1Il[0] - (BaseScreen.var_int_r - 4), 0);
                }
                BoardScreen.a(graphics, ((PlayerAccountInfo)object).g, this.var_int_arr_lIII1III11I[0], this.var_int_arr_llI1lI1Il[0] - 15, 3);
                (n % 2 != 0 ? FontRenderer.h : FontRenderer.g).a(graphics, ((PlayerAccountInfo)object).var_java_lang_String_a, this.var_int_arr_lIII1III11I[0], this.var_int_arr_llI1lI1Il[0] + 15, 2);
                VipManager.drawAfterName(graphics, (n % 2 != 0 ? FontRenderer.h : FontRenderer.g), ((PlayerAccountInfo)object).var_java_lang_String_a, ((PlayerAccountInfo)object).var_int_a, this.var_int_arr_lIII1III11I[0], this.var_int_arr_llI1lI1Il[0] + 15);
                if (((PlayerAccountInfo)object).var_boolean_b && ((PlayerAccountInfo)object).var_int_a != this.var_int_llI1lI1Il) {
                    FontRenderer.e.a(graphics, "ok", this.var_int_arr_lIII1III11I[0], this.var_int_arr_llI1lI1Il[0] - 32, 2);
                }
                if (((PlayerAccountInfo)object).var_int_a != this.var_int_llI1lI1Il) continue;
                FontRenderer.e.a(graphics, StringUtils.cB(), this.var_int_arr_lIII1III11I[0], this.var_int_arr_llI1lI1Il[0] - 32, 2);
            }
        }
        if (GameCanvas.var_int_c > 220) {
            try {
                if (var_byte_b == 5) {
                    n = var_byte_arr_a.length - (GameHelper34.var_byte_a - var_byte_c);
                    PlayerEntity.a(graphics, var_byte_arr_b[n], GameCanvas.var_int_a % 10 <= 5 ? 1 : 0, GameCanvas.var_int_b / 2, GameCanvas.var_int_c - 95 - (GameCanvas.var_boolean_d ? 4 : 0), 2, null);
                }
            }
            catch (Exception exception) {}
        }
        graphics.translate(0, -graphics.getTranslateY());
        if (GameCanvas.var_int_c < 300) {
            if (GameCanvas.var_int_b <= 300) {
                FontRenderer.e.a(graphics, StringUtils.dL() + ": " + var_byte_a, GameCanvas.var_int_d, 10, 2);
                FontRenderer.e.a(graphics, GameHelper05.var_java_lang_String_a, GameCanvas.var_int_d, 25, 2);
                FontRenderer.e.a(graphics, var_byte_c + 1 + ". " + GameHelper34.var_java_lang_String_arr_a[var_byte_c], GameCanvas.var_int_d, 40, 2);
            } else {
                graphics.setColor(0xFFFFFF);
                graphics.fillRect(GameCanvas.var_int_d - 88, 13, 76, 46);
                try {
                    FontRenderer.e.a(graphics, StringUtils.dL() + ": " + var_byte_a, GameCanvas.var_int_d, 12, 0);
                    FontRenderer.e.a(graphics, GameHelper05.var_java_lang_String_a, GameCanvas.var_int_d, 27, 0);
                    FontRenderer.e.a(graphics, var_byte_c + 1 + ". " + GameHelper34.var_java_lang_String_arr_a[var_byte_c], GameCanvas.var_int_d, 42, 0);
                    if (var_javax_microedition_lcdui_Image_arr_a[var_byte_c] != null) {
                        graphics.drawImage(var_javax_microedition_lcdui_Image_arr_a[var_byte_c], GameCanvas.var_int_d - 50, 36, 3);
                    }
                }
                catch (Exception exception) {
                    graphics.drawImage(var_javax_microedition_lcdui_Image_lIlll1II11l, GameCanvas.var_int_d - 50, 36, 3);
                }
                graphics.drawImage(var_javax_microedition_lcdui_Image_b, GameCanvas.var_int_d - 50, 36, 3);
                if (this.var_int_lIII1III11I != 0) {
                    FontRenderer.e.a(graphics, this.var_int_lIII1III11I + StringUtils.aq(), GameCanvas.var_int_b / 2, 65, 3);
                }
            }
            if (GameCanvas.var_int_b < 200 && this.var_int_lIII1III11I != 0) {
                FontRenderer.e.a(graphics, this.var_int_lIII1III11I + StringUtils.aq(), GameCanvas.var_int_b / 2, 60, 3);
            }
        } else {
            FontRenderer.e.a(graphics, StringUtils.dL() + ": " + var_byte_a, GameCanvas.var_int_d, 85, 2);
            FontRenderer.e.a(graphics, GameHelper05.var_java_lang_String_a, GameCanvas.var_int_d, 100, 2);
            if (this.var_int_lIII1III11I != 0) {
                FontRenderer.e.a(graphics, this.var_int_lIII1III11I + StringUtils.aq(), GameCanvas.var_int_b / 2, 120, 3);
            }
        }
        PlayerAccountInfo playerAccountInfo = TerrainMidlet.myInfo;
        object = DataUtils.a(playerAccountInfo.var_long_c) + StringUtils.aq() + " - " + DataUtils.a(playerAccountInfo.e) + StringUtils.ar();
        FontRenderer.a.a(graphics, "Lvl " + playerAccountInfo.var_int_b + "  " + (String)object, 6, GameCanvas.var_int_c - BaseScreen.var_int_r - 35, 0);
        CharacterUpgradeScreen.a(graphics, 5, GameCanvas.var_int_c - BaseScreen.var_int_r - 20);
        if (GameCanvas.var_int_b > 200) {
            int n2 = 105 + (this.var_int_llll11I11Il - 105) / 2;
            graphics.drawImage(BaseScreen.s, n2, GameCanvas.var_int_c - BaseScreen.var_int_r - 26, 3);
            FontRenderer.e.a(graphics, String.valueOf(playerAccountInfo.var_int_d), n2, GameCanvas.var_int_c - BaseScreen.var_int_r - 17, 3);
        }
        this.I1l11I1I(graphics, this.var_int_llll11I11Il, this.var_int_I1llIIII);
        if (GameCanvas.var_int_c > 300) {
            graphics.setColor(0xFFFFFF);
            graphics.fillRect(GameCanvas.var_int_d - 38, 13, 76, 46);
            try {
                if (var_javax_microedition_lcdui_Image_arr_a[var_byte_c] != null) {
                    graphics.drawImage(var_javax_microedition_lcdui_Image_arr_a[var_byte_c], GameCanvas.var_int_d, 36, 3);
                    FontRenderer.e.a(graphics, var_byte_c + 1 + ". " + GameHelper34.var_java_lang_String_arr_a[var_byte_c], GameCanvas.var_int_d, 70, 2);
                }
            }
            catch (Exception exception) {
                graphics.drawImage(var_javax_microedition_lcdui_Image_lIlll1II11l, GameCanvas.var_int_d, 36, 3);
                FontRenderer.e.a(graphics, "Unknow", GameCanvas.var_int_d, 70, 2);
            }
            graphics.drawImage(var_javax_microedition_lcdui_Image_b, GameCanvas.var_int_d, 36, 3);
        }
        if (this.var_boolean_llI1lI1Il) {
            this.IIIIII1llI(graphics, this.var_int_lIlll1II11l, this.var_int_l11IIIll1);
        }
        if (this.var_boolean_l111Il11) {
            int n3 = GameCanvas.var_int_b - BoardScreen.var_game_GameHelper11_a.b >> 1;
            int n4 = (GameCanvas.var_int_c - BaseScreen.var_int_r) / 2 - 80;
            BaseScreen.a(graphics, n4, GameCanvas.var_boolean_d ? 4 : 3, GameCanvas.var_boolean_d ? 138 : 118, StringUtils.m());
            var_game_GameHelper11_a.a(n3, n4 + 25, graphics, ExplosionEffect.int_arr_a());
            n3 = GameCanvas.var_int_b / 2;
            FontRenderer.a.a(graphics, ExplosionEffect.a((int)BoardScreen.var_game_GameHelper11_a.a).var_java_lang_String_a, n3, n4 += GameCanvas.var_boolean_d ? 115 : 95, 3);
        }
        graphics.translate(-graphics.getTranslateX(), -graphics.getTranslateY());
        graphics.setClip(0, 0, GameCanvas.var_int_b, GameCanvas.var_int_c);
        if (!var_game_MapEntity_a.java_lang_String_a().equals("")) {
            var_game_MapEntity_a.a(graphics);
        }
        if (GameCanvas.var_boolean_d) {
            graphics.drawImage(var_javax_microedition_lcdui_Image_c, 30, 10, 0);
        }
        super.a(graphics);
    }

    public static void a(Graphics graphics, int n, int n2, int n3, int n4) {
        try {
            DataUtils.a(graphics, var_javax_microedition_lcdui_Image_I1llIIII, 0, n * 12, 12, 12, 0, n2, n3, n4);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public void e() {
        for (int i = 0; i < this.var_java_util_Vector_a.size(); ++i) {
            PlayerAccountInfo playerAccountInfo = (PlayerAccountInfo)this.var_java_util_Vector_a.elementAt(i);
            ConnectionWatchdog.game_ConnectionWatchdog_a().a(playerAccountInfo.var_short_b);
        }
    }

    public void b_() {
        super.b_();
        this.var_int_arr_a = ExplosionEffect.int_arr_a(this.var_int_arr_a);
        PlayerEntity.var_boolean_c = false;
        if (BattleScreen.var_game_BattleScreen_a != null) {
            BattleScreen.e();
        }
    }

    private void IIIIII1llI(Graphics graphics, int n, int n2) {
        BaseScreen.a(graphics, this.var_int_l11IIIll1 - 40, 4, 120, StringUtils.m());
        int n3 = this.var_boolean_l111Il11 ? -1 : this.var_int_I1II111II1;
        GameHelper31.a(graphics, this.var_int_arr_a, n3, n, n2, true, null);
        for (n3 = 0; n3 < this.var_int_arr_a.length; ++n3) {
            if (n3 == this.var_int_arr_a.length - 1) {
                BoardScreen.IIIIII1llI(graphics, ExplosionEffect.a((int)15).g, n + 120 + 9, n2 + 52);
            }
            if (n3 == this.var_int_arr_a.length - 2) {
                BoardScreen.IIIIII1llI(graphics, ExplosionEffect.a((int)14).g, n + 80 + 9, n2 + 52);
            }
            if (n3 == this.var_int_arr_a.length - 3) {
                BoardScreen.IIIIII1llI(graphics, ExplosionEffect.a((int)13).g, n + 40 + 9, n2 + 52);
            }
            if (n3 != this.var_int_arr_a.length - 4) continue;
            BoardScreen.IIIIII1llI(graphics, ExplosionEffect.a((int)12).g, n + 9, n2 + 52);
        }
    }

    private void I1l11I1I(Graphics graphics, int n, int n2) {
        int n3 = this.var_boolean_l111Il11 ? -1 : this.var_int_I1II111II1;
        GameHelper31.a(graphics, this.var_int_arr_a, n3, n, n2, false, null);
        for (n3 = 0; n3 < this.var_int_arr_a.length; ++n3) {
            if (n3 == this.var_int_arr_a.length - 1) {
                BoardScreen.IIIIII1llI(graphics, ExplosionEffect.a((int)15).g, n + 54 + 9, n2 + 28);
            }
            if (n3 == this.var_int_arr_a.length - 2) {
                BoardScreen.IIIIII1llI(graphics, ExplosionEffect.a((int)14).g, n + 36 + 9, n2 + 28);
            }
            if (n3 == this.var_int_arr_a.length - 3) {
                BoardScreen.IIIIII1llI(graphics, ExplosionEffect.a((int)13).g, n + 18 + 9, n2 + 28);
            }
            if (n3 != this.var_int_arr_a.length - 4) continue;
            BoardScreen.IIIIII1llI(graphics, ExplosionEffect.a((int)12).g, n + 9, n2 + 28);
        }
    }

    private static void IIIIII1llI(Graphics graphics, int n, int n2, int n3) {
        FontRenderer.h.a(graphics, String.valueOf(n), n2, n3, 0);
    }

    public final String java_lang_String_a(int n) {
        for (int i = 0; i < this.var_java_util_Vector_a.size(); ++i) {
            PlayerAccountInfo playerAccountInfo = (PlayerAccountInfo)this.var_java_util_Vector_a.elementAt(i);
            if (playerAccountInfo.var_int_a != n) continue;
            return playerAccountInfo.var_java_lang_String_a;
        }
        return "";
    }

    public final PlayerAccountInfo game_PlayerAccountInfo_a(int n) {
        for (int i = 0; i < this.var_java_util_Vector_a.size(); ++i) {
            PlayerAccountInfo playerAccountInfo = (PlayerAccountInfo)this.var_java_util_Vector_a.elementAt(i);
            if (playerAccountInfo.var_int_a != n) continue;
            return playerAccountInfo;
        }
        return null;
    }

    public void a(int n, int n2, Vector vector) {
        this.var_int_lIII1III11I = n2;
        this.var_java_util_Vector_a = vector;
        this.void_a(n);
        for (n = 0; n < vector.size(); ++n) {
            if (((PlayerAccountInfo)vector.elementAt((int)n)).var_int_a != TerrainMidlet.myInfo.var_int_a) continue;
            this.var_int_Il111I11 = n;
            return;
        }
    }

    public int getMasterId() {
        return this.var_int_llI1lI1Il;
    }

    public void setMasterId(int n) {
        this.var_int_llI1lI1Il = n;
    }

    public void void_a(int n) {
        this.var_int_llI1lI1Il = n;
        for (n = 0; n < this.var_java_util_Vector_a.size(); ++n) {
            PlayerAccountInfo playerAccountInfo = (PlayerAccountInfo)this.var_java_util_Vector_a.elementAt(n);
            if (playerAccountInfo.var_int_a != this.var_int_llI1lI1Il) continue;
            playerAccountInfo.var_boolean_b = true;
        }
    }

    public void a(int n, String string) {
        n = this.IIIIII1llI(n);
        if (n >= 0 && n < this.var_int_arr_lIII1III11I.length) {
            new ChatPopup().a(90, this.var_int_arr_lIII1III11I[n], this.var_int_arr_llI1lI1Il[n] - 10, string);
        }
    }

    public void c(int n) {
        for (int i = 0; i < this.var_java_util_Vector_a.size(); ++i) {
            PlayerAccountInfo playerAccountInfo = (PlayerAccountInfo)this.var_java_util_Vector_a.elementAt(i);
            if (playerAccountInfo.var_int_a != n) continue;
            playerAccountInfo.var_int_a = -1;
            playerAccountInfo.var_boolean_b = false;
        }
    }

    public void f() {
        VipManager.request();
        for (int i = 0; i < this.var_java_util_Vector_a.size(); ++i) {
            PlayerAccountInfo playerAccountInfo = (PlayerAccountInfo)this.var_java_util_Vector_a.elementAt(i);
            playerAccountInfo.var_boolean_b = playerAccountInfo.var_int_a == this.var_int_llI1lI1Il;
        }
    }

    public void d(int n) {
        this.var_int_lIII1III11I = n;
        for (n = 0; n < this.var_java_util_Vector_a.size(); ++n) {
            ((PlayerAccountInfo)this.var_java_util_Vector_a.elementAt((int)n)).var_boolean_b = false;
        }
    }

    public final void b(int n) {
        if (GameCanvas.var_game_GameHelper21_a == null) {
            var_game_MapEntity_a.boolean_a(n);
        }
    }

    static int int_a(BoardScreen boardScreen) {
        return boardScreen.var_int_llI1lI1Il;
    }

    static GameCommand game_GameCommand_a(BoardScreen boardScreen) {
        return boardScreen.IIlII1llll;
    }

    static GameCommand game_GameCommand_b(BoardScreen boardScreen) {
        return boardScreen.IlIl1IIl1Il;
    }

    public final PlayerAccountInfo getMyAccountInfo() {
        if (this.var_int_Il111I11 >= 0 && this.var_int_Il111I11 < this.var_java_util_Vector_a.size()) {
            return (PlayerAccountInfo)this.var_java_util_Vector_a.elementAt(this.var_int_Il111I11);
        }
        for (int i = 0; i < this.var_java_util_Vector_a.size(); ++i) {
            PlayerAccountInfo p = (PlayerAccountInfo)this.var_java_util_Vector_a.elementAt(i);
            if (p != null && p.var_int_a == TerrainMidlet.myInfo.var_int_a) {
                this.var_int_Il111I11 = i;
                return p;
            }
        }
        return null;
    }

    static int int_b(BoardScreen boardScreen) {
        if (boardScreen.var_int_Il111I11 >= 0 && boardScreen.var_int_Il111I11 < boardScreen.var_java_util_Vector_a.size()) {
            return boardScreen.var_int_Il111I11;
        }
        for (int i = 0; i < boardScreen.var_java_util_Vector_a.size(); ++i) {
            PlayerAccountInfo p = (PlayerAccountInfo)boardScreen.var_java_util_Vector_a.elementAt(i);
            if (p != null && p.var_int_a == TerrainMidlet.myInfo.var_int_a) {
                boardScreen.var_int_Il111I11 = i;
                return i;
            }
        }
        return -1;
    }

    static GameCommand game_GameCommand_c(BoardScreen boardScreen) {
        return boardScreen.var_game_GameCommand_lIlll1II11l;
    }

    static GameCommand game_GameCommand_d(BoardScreen boardScreen) {
        return boardScreen.var_game_GameCommand_II1lIIl1;
    }

    static GameCommand game_GameCommand_e(BoardScreen boardScreen) {
        return boardScreen.IIIllI1Il;
    }

    static GameCommand f(BoardScreen boardScreen) {
        return boardScreen.IlI1I11IIII;
    }

    static GameCommand g(BoardScreen boardScreen) {
        return boardScreen.var_game_GameCommand_lIII1III11I;
    }

    static int int_c(BoardScreen boardScreen) {
        return boardScreen.var_int_II1lIIl1;
    }

    static void void_a(BoardScreen boardScreen) {
        boardScreen.var_int_II1lIIl1 = 30;
    }

    static int int_d(BoardScreen boardScreen) {
        return boardScreen.var_int_lIII1III11I;
    }

    static void void_b(BoardScreen boardScreen) {
        boardScreen.var_boolean_llI1lI1Il = false;
    }

    static int int_e(BoardScreen boardScreen) {
        return boardScreen.var_int_I1II111II1;
    }

    static boolean boolean_a(BoardScreen boardScreen) {
        return boardScreen.var_boolean_l111Il11;
    }

    static void a(BoardScreen boardScreen, boolean bl) {
        boardScreen.var_boolean_l111Il11 = bl;
    }

    static boolean boolean_b(BoardScreen boardScreen) {
        return false;
    }

    static void void_c(BoardScreen boardScreen) {
        boardScreen.var_boolean_lIII1III11I = false;
    }

    static {
        var_java_lang_String_arr_a = new String[]{"GUNNER", "MISS 6", "ELECTICIAN", "KING KONG", "ROCKETER", "GRANOS", "CHICKY", "TARZAN", "APACHE", "MAGENTA", "LASER GIRL", "COW GIRL"};
        var_byte_c = 0;
        Image[] imageArray = new Image[5];
        var_javax_microedition_lcdui_Image_arr_c = imageArray;
        imageArray[0] = BattleScreen.var_javax_microedition_lcdui_Image_arr_a[0];
        BoardScreen.var_javax_microedition_lcdui_Image_arr_c[1] = BattleScreen.var_javax_microedition_lcdui_Image_arr_a[1];
        BoardScreen.var_javax_microedition_lcdui_Image_arr_c[2] = BattleScreen.var_javax_microedition_lcdui_Image_arr_a[2];
        BoardScreen.var_javax_microedition_lcdui_Image_arr_c[3] = BattleScreen.var_javax_microedition_lcdui_Image_arr_a[3];
        BoardScreen.var_javax_microedition_lcdui_Image_arr_c[4] = BattleScreen.var_javax_microedition_lcdui_Image_arr_a[4];
        var_javax_microedition_lcdui_Image_I1llIIII = BattleScreen.var_javax_microedition_lcdui_Image_i;
        var_javax_microedition_lcdui_Image_a = BattleScreen.var_javax_microedition_lcdui_Image_j;
        var_javax_microedition_lcdui_Image_llll11I11Il = ShopScreen.var_javax_microedition_lcdui_Image_b;
        try {
            var_javax_microedition_lcdui_Image_lIlll1II11l = Image.createImage((String)"/randomMap.png");
            var_javax_microedition_lcdui_Image_l11IIIll1 = Image.createImage((String)"/map/line.png");
            var_javax_microedition_lcdui_Image_c = Image.createImage((String)"/iconChat.png");
        } catch (Exception e) {}
    }
}

