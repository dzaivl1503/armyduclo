/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
package game;

import game.BaseScreen;
import game.BattleManager;
import game.BattleScreen;
import game.BoardScreen;
import game.CharacterSelectScreen;
import game.ChatScreen;
import game.ClanScreen;
import game.ConnectionWatchdog;
import game.DataUtils;
import game.EquipSlotSet;
import game.ExplosionEffect;
import game.FloatingTextManager;
import game.FontRenderer;
import game.GameCanvas;
import game.GameHelper01;
import game.GameHelper16;
import game.GameHelper28;
import game.GameHelper29;
import game.GameHelper34;
import game.GameHelper40;
import game.PopupDialog;
import game.RankingScreen;
import game.ShopScreen;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class PlayerEntity {
    public boolean var_boolean_b;
    private boolean var_boolean_II1ll11I;
    public static boolean var_boolean_c;
    public boolean var_boolean_d;
    public static boolean var_boolean_e;
    public boolean var_boolean_f;
    public boolean var_boolean_g = true;
    public boolean var_boolean_h = false;
    public boolean var_boolean_i = false;
    public boolean var_boolean_j;
    public boolean var_boolean_k;
    public int var_int_d;
    private int var_int_II1ll11I;
    public boolean var_boolean_l;
    public boolean var_boolean_m;
    public int var_int_e = 0;
    public int var_int_f = 0;
    public int var_int_g;
    public int var_int_h;
    public int var_int_i;
    public int var_int_j;
    public boolean var_boolean_n;
    public int[] var_int_arr_a;
    public int var_int_k = -1;
    public boolean var_boolean_o;
    public boolean var_boolean_p;
    public int var_int_l = 0;
    public int var_int_m = 0;
    public int var_int_n = 0;
    public int var_int_o;
    public byte var_byte_b;
    public byte var_byte_c;
    public boolean var_boolean_q;
    public boolean var_boolean_r;
    public boolean var_boolean_s;
    public boolean var_boolean_t;
    public boolean l111ll1l = false;
    public boolean var_boolean_u = false;

    public boolean has2Force() {
        this.var_byte_g = ShopScreen.a(this.var_byte_c);
        this.var_boolean_u = ShopScreen.b(this.var_byte_g) && !this.var_boolean_o ? true : (this.var_boolean_p ? ShopScreen.b(this.var_byte_g) : false);
        return this.var_boolean_u;
    }
    public byte var_byte_d = 0;
    public byte var_byte_e = 0;
    public static int var_int_p;
    public static int var_int_q;
    public static boolean isPullingForce = false;
    public static int fireCooldown = 0;
    public static boolean waitingSecondPressRelease = false;
    public static int keyHoldFrames = 0;
    public int var_int_r;
    private int var_int_IIllIll1I = 0;
    private static int var_int_III1l1II1lI;
    private int var_int_lIl11lIll1;
    private int var_int_I11IlllI1;
    public int var_int_s = 5;
    /** user_id trong DB: dung de tra cuu huy hieu VIP. */
    public int var_int_vipUserId = -1;
    private int var_int_IlI1IIllllI;
    public int var_int_t;
    private int var_int_llIIIIllll1 = this.var_int_t = 2;
    public byte var_byte_f = 0;
    public int var_int_u;
    public int var_int_v = 1;
    public boolean var_boolean_v = false;
    private boolean var_boolean_lIl11lIll1 = false;
    public int var_int_w;
    public int var_int_x;
    private String var_java_lang_String_IIllIll1I;
    private String var_java_lang_String_III1l1II1lI;
    private String lII11I1l;
    public byte var_byte_g = 0;
    private byte var_byte_II1ll11I;
    public byte var_byte_h;
    public byte var_byte_i;
    public boolean var_boolean_w;
    public boolean var_boolean_x;
    public boolean var_boolean_y;
    public boolean var_boolean_z;
    public boolean var_boolean_A;
    private int var_int_l1IllIll1;
    public boolean var_boolean_B;
    public short var_short_a;
    public String var_java_lang_String_a = "";
    private int var_int_IllI1l11llI = 0;
    private int IIl1I1l1IIll = 1;
    public int var_int_y;
    public int var_int_z;
    public boolean var_boolean_C = false;
    public static short[] var_short_arr_a;
    private EquipSlotSet var_game_EquipSlotSet_II1ll11I;
    private int IIllIl1ll = 100;
    public boolean var_boolean_D = false;
    private byte llI1IIl1 = (byte)-1;
    private boolean var_boolean_I11IlllI1;
    private boolean var_boolean_IlI1IIllllI;
    public int var_int_A;
    public int var_int_B;
    public int var_int_C;
    private int Il1lIl1IIl;
    private int I11l11lIll;
    private int IllII1IllIll;
    private int l1111I11;
    public boolean var_boolean_E = false;
    private int lllIIIl1IIl;
    private int I111lI1l;
    boolean var_boolean_F;
    public int var_int_D;
    public int var_int_E;
    public int var_int_F;
    public int var_int_G;
    public int var_int_H;
    public int var_int_I;
    private short[][] var_short_arr_arr_II1ll11I;
    private short[][] var_short_arr_arr_IIllIll1I;
    public static int var_int_J;
    public static int var_int_K;
    public static boolean var_boolean_G;
    private int lI11I1I1lllI;
    public static boolean var_boolean_H;
    private static int lIlI11ll1I;
    private int lIllIIl1I;
    private int l1III1llIl1l;
    public int var_int_L = 25;
    private boolean var_boolean_llIIIIllll1 = false;
    private boolean var_boolean_l1IllIll1 = false;
    private boolean var_boolean_IllI1l11llI = false;
    private int I1II1lII;
    private int II1I11llI11l;
    private int ll1l1I1II;
    public int M;
    public byte var_byte_j = 1;
    private static int Illl1ll1I1I;
    private static int IllllIllIl1I;
    private static int lIIl1lI1;
    private static int IIlI1I1lII;
    private static int llIlIIIIlIIl;
    public GameHelper29 var_game_GameHelper29_a;
    public Image var_javax_microedition_lcdui_Image_b;
    private static Image var_javax_microedition_lcdui_Image_II1ll11I;
    private static Image ll1Il1lIll1;
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
    public static Image var_javax_microedition_lcdui_Image_o;
    public static Image var_javax_microedition_lcdui_Image_p;
    public static Image var_javax_microedition_lcdui_Image_q;
    public static Image var_javax_microedition_lcdui_Image_r;
    public static Image var_javax_microedition_lcdui_Image_s;
    public static Image var_javax_microedition_lcdui_Image_t;
    public static Image var_javax_microedition_lcdui_Image_u;
    private static Image l1lIIII11llI;
    private static Image llllll11lIII;
    public static Image var_javax_microedition_lcdui_Image_v;
    public static Image var_javax_microedition_lcdui_Image_w;
    public static Image[] var_javax_microedition_lcdui_Image_arr_a;
    public static boolean var_boolean_I;
    public static boolean var_boolean_J;
    public static boolean var_boolean_K;
    public static boolean var_boolean_L;
    public static short var_short_b;
    public static short var_short_c;
    public FloatingTextManager var_game_FloatingTextManager_a;

    public static void b() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeBoolean(var_boolean_I);
            dataOutputStream.writeBoolean(var_boolean_J);
            dataOutputStream.writeBoolean(var_boolean_K);
            dataOutputStream.writeShort(var_short_b);
            dataOutputStream.writeShort(var_short_c);
            dataOutputStream.writeBoolean(var_boolean_L);
            dataOutputStream.flush();
            DataUtils.a(byteArrayOutputStream.toByteArray(), "V9Data");
            dataOutputStream.close();
            byteArrayOutputStream.close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public static void a(byte[] bytes) {
        GameHelper28 helper = new GameHelper28(bytes);
        var_javax_microedition_lcdui_Image_II1ll11I = BattleScreen.var_javax_microedition_lcdui_Image_e;
        PlayerEntity.var_javax_microedition_lcdui_Image_arr_a[0] = helper.a("yellowP.png");
        PlayerEntity.var_javax_microedition_lcdui_Image_arr_a[1] = helper.a("cuteGirl.png");
        PlayerEntity.var_javax_microedition_lcdui_Image_arr_a[2] = helper.a("greenP.png");
        PlayerEntity.var_javax_microedition_lcdui_Image_arr_a[3] = helper.a("conKhiP.png");
        PlayerEntity.var_javax_microedition_lcdui_Image_arr_a[4] = helper.a("rocketer.png");
        PlayerEntity.var_javax_microedition_lcdui_Image_arr_a[5] = helper.a("robot.png");
        PlayerEntity.var_javax_microedition_lcdui_Image_arr_a[6] = helper.a("ga.png");
        PlayerEntity.var_javax_microedition_lcdui_Image_arr_a[7] = helper.a("tazz.png");
        PlayerEntity.var_javax_microedition_lcdui_Image_arr_a[8] = helper.a("apache.png");
        PlayerEntity.var_javax_microedition_lcdui_Image_arr_a[9] = helper.a("cowg.png");
        PlayerEntity.var_javax_microedition_lcdui_Image_arr_a[10] = helper.a("magenta.png");
        PlayerEntity.var_javax_microedition_lcdui_Image_arr_a[11] = helper.a("bosssmall.png");
        PlayerEntity.var_javax_microedition_lcdui_Image_arr_a[12] = helper.a("bossbig.png");
        llllll11lIII = helper.a("bug_gun.png");
        var_javax_microedition_lcdui_Image_v = helper.a("bug_body.png");
        var_javax_microedition_lcdui_Image_w = helper.a("bug_leg.png");
        var_javax_microedition_lcdui_Image_q = helper.a("fire.png");
        ll1Il1lIll1 = helper.a("arm.png");
        var_javax_microedition_lcdui_Image_c = helper.a("leg.png");
        var_javax_microedition_lcdui_Image_d = helper.a("body.png");
        var_javax_microedition_lcdui_Image_e = helper.a("body_injured.png");
        PlayerEntity.var_javax_microedition_lcdui_Image_arr_a[14] = helper.a("bossrobot.png");
        var_javax_microedition_lcdui_Image_r = helper.a("UFO.png");
        var_javax_microedition_lcdui_Image_s = helper.a("UFOFire.png");
        var_javax_microedition_lcdui_Image_f = helper.a("khicau.png");
        var_javax_microedition_lcdui_Image_g = helper.a("gun.png");
        var_javax_microedition_lcdui_Image_h = helper.a("bomb.png");
        var_javax_microedition_lcdui_Image_i = helper.a("fan1.png");
        var_javax_microedition_lcdui_Image_j = helper.a("fan2.png");
        var_javax_microedition_lcdui_Image_k = helper.a("gunbig.png");
        var_javax_microedition_lcdui_Image_o = helper.a("ma.png");
        var_javax_microedition_lcdui_Image_p = helper.a("ma2.png");
        var_javax_microedition_lcdui_Image_l = helper.a("back_fan.png");
        var_javax_microedition_lcdui_Image_m = helper.a("front_fan.png");
        var_javax_microedition_lcdui_Image_n = helper.a("injured.png");
        var_javax_microedition_lcdui_Image_t = helper.a("spider.png");
        PlayerEntity.var_javax_microedition_lcdui_Image_arr_a[18] = helper.a("mainGun.png");
        PlayerEntity.var_javax_microedition_lcdui_Image_arr_a[21] = helper.a("eye.png");
        PlayerEntity.var_javax_microedition_lcdui_Image_arr_a[13] = llllll11lIII;
        PlayerEntity.var_javax_microedition_lcdui_Image_arr_a[15] = ll1Il1lIll1;
    }

    public PlayerEntity(int n, byte by, int n2, int n3, boolean bl, int n4, byte by2, EquipSlotSet equipSlotSet, int n5) {
        this.var_int_o = n;
        this.var_byte_b = by;
        this.var_boolean_B = bl;
        this.var_int_t = n4;
        this.var_byte_c = by2;
        this.var_game_EquipSlotSet_II1ll11I = equipSlotSet;
        this.var_int_r = by2 < 11 ? (n4 != 2 ? 180 - var_short_arr_a[this.var_byte_c] : (var_short_arr_a[this.var_byte_c] >= 0 ? var_short_arr_a[this.var_byte_c] : 0)) : 0;
        boolean bl2 = this.var_boolean_b = BoardScreen.var_byte_b != 5 && by % 2 == 0;
        if (equipSlotSet != null) {
            this.var_int_II1ll11I = equipSlotSet.var_game_ItemTemplate_arr_a[0].var_byte_g;
        }
        System.out.println("[co] ID BULLET = " + this.var_int_II1ll11I);
        if (this.var_byte_c == 3) {
            this.var_game_GameHelper29_a = new GameHelper29(var_javax_microedition_lcdui_Image_arr_a[this.var_byte_c], 30, 32);
        } else if (this.var_byte_c == 6) {
            this.var_game_GameHelper29_a = new GameHelper29(var_javax_microedition_lcdui_Image_arr_a[this.var_byte_c], 29, 24);
        } else if (this.var_byte_c == 7) {
            this.var_game_GameHelper29_a = new GameHelper29(var_javax_microedition_lcdui_Image_arr_a[this.var_byte_c], 32, 32);
        } else if (this.var_byte_c == 11) {
            this.var_game_GameHelper29_a = new GameHelper29(var_javax_microedition_lcdui_Image_arr_a[this.var_byte_c], 18, 19);
        } else if (this.var_byte_c == 12) {
            this.var_game_GameHelper29_a = new GameHelper29(var_javax_microedition_lcdui_Image_arr_a[this.var_byte_c], 30, 28);
        } else if (this.var_byte_c == 14) {
            this.var_game_GameHelper29_a = new GameHelper29(var_javax_microedition_lcdui_Image_arr_a[this.var_byte_c], 24, 30);
        } else if (this.var_byte_c == 13) {
            this.var_game_GameHelper29_a = new GameHelper29(var_javax_microedition_lcdui_Image_arr_a[this.var_byte_c], 15, 15);
        } else if (this.var_byte_c == 15) {
            this.var_game_GameHelper29_a = new GameHelper29(var_javax_microedition_lcdui_Image_arr_a[this.var_byte_c], 35, 40);
        } else if (this.var_byte_c == 9) {
            this.var_game_GameHelper29_a = new GameHelper29(var_javax_microedition_lcdui_Image_arr_a[this.var_byte_c], 24, 24);
        } else if (this.var_byte_c == 10) {
            this.var_game_GameHelper29_a = new GameHelper29(var_javax_microedition_lcdui_Image_arr_a[this.var_byte_c], 32, 32);
        } else if (this.var_byte_c != 16) {
            if (this.var_byte_c == 18) {
                this.var_game_GameHelper29_a = new GameHelper29(var_javax_microedition_lcdui_Image_arr_a[this.var_byte_c], 21, 20);
            } else if (this.var_byte_c != 17 && this.var_byte_c != 19) {
                if (this.var_byte_c == 21) {
                    this.var_game_GameHelper29_a = new GameHelper29(var_javax_microedition_lcdui_Image_arr_a[this.var_byte_c], 12, 12);
                } else if (this.var_byte_c != 20 && this.var_byte_c != 22 && this.var_byte_c != 23 && this.var_byte_c != 24 && this.var_byte_c != 25 && this.var_byte_c != 26) {
                    this.var_game_GameHelper29_a = new GameHelper29(var_javax_microedition_lcdui_Image_arr_a[this.var_byte_c], 24, 24);
                }
            }
        }
        this.var_boolean_n = true;
        this.var_boolean_s = false;
        this.var_boolean_t = true;
        this.var_int_g = n2;
        this.var_int_h = n3;
        this.var_int_A = n2;
        this.var_int_B = n3;
        this.var_int_y = n2;
        this.var_int_z = n3;
        this.var_int_i = n2;
        this.var_int_j = n3;
        this.var_short_a = (short)n2;
        this.var_int_k = -1;
        this.var_int_arr_a = new int[8];
        this.var_int_w = this.var_int_x = n5;
        this.var_boolean_z = false;
        this.var_game_FloatingTextManager_a = new FloatingTextManager();
    }

    public final void a(byte by) {
        this.var_boolean_D = true;
        this.llI1IIl1 = by;
        this.var_boolean_IlI1IIllllI = true;
        this.var_int_A = this.var_int_g;
        this.var_int_B = this.var_int_h;
    }

    public final void a(int n) {
        this.var_boolean_l = true;
        this.var_int_C = n;
    }

    public final void c() {
        if (this.var_boolean_D) {
            this.var_boolean_n = false;
            this.var_int_v = 3;
            if (this.var_boolean_IlI1IIllllI) {
                this.var_int_h += 6;
                if (this.var_int_h >= BattleManager.var_game_PlayerEntity_arr_a[this.llI1IIl1].var_int_h - 24) {
                    this.var_int_h = BattleManager.var_game_PlayerEntity_arr_a[this.llI1IIl1].var_int_h - 24;
                    this.var_boolean_IlI1IIllllI = false;
                    this.var_boolean_I11IlllI1 = true;
                }
            }
            if (this.var_boolean_I11IlllI1) {
                this.var_int_h -= 6;
                BattleManager.var_game_PlayerEntity_arr_a[this.llI1IIl1].var_int_h = this.var_int_h + 24;
                BattleManager.var_game_PlayerEntity_arr_a[this.llI1IIl1].var_int_z = this.var_int_h + 24;
                if (this.var_int_h <= this.var_int_B) {
                    this.var_int_h = this.var_int_B;
                    this.var_int_z = this.var_int_B;
                    this.var_boolean_I11IlllI1 = false;
                    this.var_boolean_D = false;
                    GameCanvas.var_boolean_e = true;
                }
            }
        }
    }

    public final void a(int n, int n2) {
        this.var_boolean_E = true;
        this.Il1lIl1IIl = n;
        this.I11l11lIll = n2;
        this.IllII1IllIll = this.var_int_g;
        this.l1111I11 = this.var_int_h;
        if (this.Il1lIl1IIl > this.IllII1IllIll) {
            this.var_int_v = 1;
            this.var_int_t = 2;
            return;
        }
        this.var_int_v = 0;
        this.var_int_t = 0;
    }

    public final void b(int n) {
        if (this.var_int_g >= GameHelper34.var_int_a) {
            this.var_int_g = -100;
            this.Il1lIl1IIl = this.IllII1IllIll;
            this.I11l11lIll = this.l1111I11;
            PopupDialog.b = 0;
        }
        int n2 = DataUtils.a(this.Il1lIl1IIl - this.var_int_g, this.var_int_h - this.I11l11lIll);
        int n3 = n * DataUtils.b(n2) >> 10;
        n2 = -(n * DataUtils.int_a(n2) >> 10);
        GameHelper40 gameHelper40 = new GameHelper40(n3, n2);
        this.lllIIIl1IIl = gameHelper40.a;
        this.I111lI1l = gameHelper40.b;
        this.var_int_g += this.lllIIIl1IIl;
        this.var_int_h += this.I111lI1l;
        if (this.var_int_g < this.Il1lIl1IIl + n / 2 && this.var_int_g >= this.Il1lIl1IIl - n / 2 && this.var_int_h < this.I11l11lIll + n / 2 && this.var_int_h >= this.I11l11lIll - n / 2) {
            this.var_int_g = this.Il1lIl1IIl;
            this.var_int_h = this.I11l11lIll;
            this.var_int_D = this.I11l11lIll;
            while (this.var_int_D < GameHelper34.var_int_b && !GameHelper34.a(this.var_int_g, this.var_int_D)) {
                ++this.var_int_D;
            }
            this.var_byte_g = (byte)-1;
            this.var_boolean_F = true;
            this.var_boolean_E = false;
            GameCanvas.var_boolean_e = true;
        }
    }

    /*
     * Unable to fully structure code
     */
    public void a() {
        block31: {
            if (BattleManager.var_byte_a == BattleScreen.var_byte_b) {
                if (this.var_byte_i < this.var_byte_h) {
                    this.var_byte_i = (byte)(this.var_byte_i + 2);
                }
                if (this.var_byte_i > this.var_byte_h) {
                    this.var_byte_i = this.var_byte_h;
                }
            }
                        switch (this.var_byte_f) {
                case 5: {
                    if (this.var_byte_c != 23 && this.var_byte_c != 24 && this.var_byte_c != 25 && this.var_byte_c != 26) {
                        if (this.IIllIl1ll > 0) {
                            --this.IIllIl1ll;
                        } else {
                            BattleScreen.var_game_BattleGraphicHelper_a.a(this.var_int_g, this.var_int_h - 8, (byte)5);
                            this.IIllIl1ll = 100;
                        }
                    }
                    break block31;
                }
                case 7: {
                    ++this.var_int_IlI1IIllllI;
                    if (this.var_int_IlI1IIllllI > 4) {
                        ++this.var_int_s;
                        if (this.var_int_s != 10) break;
                        this.var_int_s = 8;
                        break;
                    }
                    break block31;
                }
                                case 8: {
                    ++this.var_int_IlI1IIllllI;
                    if (this.var_int_IlI1IIllllI > 25) {
                        if (this.var_int_w > 0) {
                            this.var_byte_f = 0;
                            this.f();
                        } else {
                            this.I1IIlIII();
                        }
                    }
                    break block31;
                }
            }
            this.var_int_IlI1IIllllI = 0;
        }
        this.var_int_lIl11lIll1 = PlayerEntity.var_int_p * DataUtils.b(this.var_int_r) >> 10;
        this.var_int_I11IlllI1 = PlayerEntity.var_int_p * DataUtils.int_a(this.var_int_r) >> 10;
        if (this.var_boolean_B && !this.var_boolean_j && !this.var_boolean_m && !this.var_boolean_n) {
            if (this.var_int_y < this.var_int_g) {
                System.out.println("[co] x= " + this.var_int_g + " nextx= " + this.var_int_y);
                this.a(false);
            } else if (this.var_int_y > this.var_int_g) {
                System.out.println("[co] x= " + this.var_int_g + " nextx= " + this.var_int_y);
                this.a(true);
            }
            if (this.var_int_y == this.var_int_g && this.var_int_z != this.var_int_h && this.var_byte_f == 0) {
                this.var_int_h = this.var_int_z;
            }
        }
        if (this.var_boolean_s && !CharacterSelectScreen.var_boolean_a) {
            this.var_boolean_n = true;
            this.var_boolean_s = false;
            this.var_boolean_r = true;
        }
        if (this.var_boolean_n) {
            this.lIlll1I1lIII();
        }
        if (!this.var_boolean_o && this.var_byte_c <= 9 && this.var_byte_c != 15 && this.var_byte_c != 17) {
            if (this.var_int_t == 0 && this.var_int_r > 180 - PlayerEntity.var_short_arr_a[this.var_byte_c]) {
                this.var_int_r = 180 - PlayerEntity.var_short_arr_a[this.var_byte_c];
            }
            if (this.var_int_t == 2 && this.var_int_r < PlayerEntity.var_short_arr_a[this.var_byte_c]) {
                this.var_int_r = PlayerEntity.var_short_arr_a[this.var_byte_c];
            }
        }
        if (this.var_boolean_A) {
            ++this.var_int_l1IllIll1;
            if (this.var_int_l1IllIll1 == 20) {
                this.var_int_l1IllIll1 = 0;
                this.var_boolean_A = false;
                GameCanvas.var_boolean_e = true;
            }
            if (GameCanvas.var_int_a % 2 == 0) {
                new ChatScreen(DataUtils.b(this.var_int_g - 10, this.var_int_g + 10), DataUtils.b(this.var_int_h - 20, this.var_int_h + 2), 10);
            }
        }
        if (this.var_byte_f == 1 && this.var_int_g == this.var_int_F && this.var_int_h == this.var_int_G && this.var_boolean_C) {
            this.var_boolean_C = false;
            System.out.println("[co] DA TOI NOI DA TOI NOI DA TOI NOI x= " + this.var_int_g + "y = " + this.var_int_h);
            synchronized (GameHelper01.b) {
                GameHelper01.b.notify();
            }
        }
        if (this.var_boolean_C) {
            ++this.var_int_E;
            if (this.var_int_E == 200) {
                this.var_int_E = 0;
                this.var_int_g = this.var_int_F;
                this.var_int_h = this.var_int_G;
                this.var_int_E = 0;
                this.var_boolean_C = false;
                synchronized (GameHelper01.b) {
                    GameHelper01.b.notify();
                    return;
                }
            }
        }
    }

    private void lI11I1l1() {
        if (this.var_int_t == 0) {
            if (this.var_int_r > 180 - var_short_arr_a[this.var_byte_c]) {
                this.var_int_r = 180 - var_short_arr_a[this.var_byte_c];
            }
            if (this.var_int_r < 91) {
                this.var_int_r = 91;
            }
        }
        if (this.var_int_t == 2) {
            if (this.var_int_r < var_short_arr_a[this.var_byte_c]) {
                this.var_int_r = var_short_arr_a[this.var_byte_c];
            }
            if (this.var_int_r > 89) {
                this.var_int_r = 89;
            }
        }
    }

    private void I1I1Il1ll1() {
        if (this.var_boolean_o) {
            if (this.var_int_t == 0) {
                if (this.var_int_k == 20) {
                    if (this.var_int_r > 225) {
                        this.var_int_r = 225;
                    }
                    if (this.var_int_r < 180) {
                        this.var_int_r = 180;
                    }
                } else if (this.var_int_k == 22) {
                    if (this.var_int_r != 91) {
                        this.var_int_r = 91;
                        this.var_int_s = 3;
                    }
                } else if (this.var_int_k == 23) {
                    this.var_int_r = -269;
                } else {
                    this.lI11I1l1();
                }
            }
            if (this.var_int_t != 2) {
                return;
            }
            if (this.var_int_k == 20) {
                if (this.var_int_r > 0) {
                    this.var_int_r = 0;
                }
                if (this.var_int_r < -45) {
                    this.var_int_r = -45;
                }
                return;
            }
            if (this.var_int_k == 22) {
                if (this.var_int_r != 89) {
                    this.var_int_r = 89;
                    this.var_int_s = 3;
                }
                return;
            }
            if (this.var_int_k == 23) {
                this.var_int_r = -89;
                return;
            }
        }
        this.lI11I1l1();
    }

    private void lIlll1I1lIII() {
        if (this.var_boolean_j || this.var_boolean_D) {
            if (this.var_byte_c == 25 || this.var_byte_c == 26) {
                this.var_boolean_n = false;
                this.var_boolean_r = false;
                if (this.var_byte_f == 5) {
                    new ChatScreen(this.var_int_g, this.var_int_h, 1);
                    this.var_boolean_g = false;
                }
                return;
            }
            if (this.var_byte_f != 5) {
                this.var_boolean_n = false;
                this.var_boolean_r = false;
                return;
            }
        }
        if (this.var_int_h > GameHelper34.var_int_b + 200) {
            var_boolean_c = false;
            if (this.var_boolean_r) {
                this.var_boolean_q = true;
                this.var_boolean_r = false;
                if (this.var_byte_f != 5 && BattleScreen.var_byte_b == this.var_byte_b && !this.var_boolean_lIl11lIll1) {
                    ConnectionWatchdog.game_ConnectionWatchdog_a().b((short)this.var_int_g, (short)this.var_int_h);
                    this.var_boolean_lIl11lIll1 = true;
                }
                this.var_boolean_n = false;
                if (BattleScreen.var_boolean_f) {
                    ConnectionWatchdog.game_ConnectionWatchdog_a().d((byte)1);
                    BattleScreen.var_boolean_f = false;
                }
            }
            this.var_int_z = this.var_int_h;
            if (this.var_byte_f != 1) {
                this.c(this.var_int_g, this.var_int_h);
            }
        } else {
            this.var_int_IllI1l11llI += this.IIl1I1l1IIll;
            int n = Math.abs(this.var_int_IllI1l11llI);
            for (int i = 0; i <= n; ++i) {
                if (GameHelper34.a(this.var_int_g, this.var_int_h)) {
                    this.var_int_IllI1l11llI = 0;
                    this.var_boolean_n = false;
                    if (this.var_boolean_r) {
                        this.var_boolean_q = true;
                        this.var_boolean_r = false;
                        if (BattleManager.game_PlayerEntity_a().var_byte_c == 15) {
                            this.var_boolean_k = true;
                        }
                    }
                    this.var_int_z = this.var_int_h;
                    if (this.var_byte_f != 1) {
                        this.c(this.var_int_g, this.var_int_h);
                    }
                    if (this.var_byte_b == BattleScreen.var_byte_b && this.var_byte_f != 1 && !CharacterSelectScreen.var_boolean_a && this.var_boolean_t && this.var_int_k == 23) {
                        BattleManager.c(this.var_byte_b, (short)this.var_int_g, (short)this.var_int_h);
                    }
                    return;
                }
                ++this.var_int_h;
            }
        }
        if (GameHelper34.var_boolean_a && !this.var_boolean_II1ll11I && GameHelper34.boolean_a(this.var_int_g, this.var_int_h, (byte)2)) {
            this.var_boolean_II1ll11I = true;
        }
    }

    public final void d() {
        if (!var_boolean_G && GameCanvas.var_game_GameHelper21_a == null && (!this.var_boolean_B && this.var_boolean_v || BattleScreen.var_boolean_f) && this.var_byte_f != 5) {
            if (!BaseScreen.k) {
                if (GameCanvas.var_boolean_arr_b[2] && !this.var_boolean_n) {
                    if (this.var_int_t == 2) {
                        this.lI1ll1ll11();
                    } else {
                        this.l11lIIlllII();
                    }
                } else if (!GameCanvas.var_boolean_arr_b[8]) {
                    this.var_int_IIllIll1I = 1;
                }
            } else if (!GameCanvas.var_boolean_arr_b[8]) {
                this.var_int_IIllIll1I = 1;
            }
            if (!BaseScreen.k) {
                if (GameCanvas.var_boolean_arr_b[8] && !this.var_boolean_n) {
                    if (this.var_int_t == 0) {
                        this.lI1ll1ll11();
                    } else {
                        this.l11lIIlllII();
                    }
                } else if (!GameCanvas.var_boolean_arr_b[2]) {
                    this.var_int_IIllIll1I = 1;
                }
            } else if (!GameCanvas.var_boolean_arr_b[2]) {
                this.var_int_IIllIll1I = 1;
            }
            if (!BaseScreen.k) {
                if (GameCanvas.var_boolean_arr_b[4] && !this.var_boolean_n && !GameCanvas.var_boolean_arr_b[6] && !GameCanvas.var_boolean_arr_b[5]) {
                    this.a(false);
                }
            } else if (GameCanvas.var_boolean_arr_b[4] && !this.var_boolean_n) {
                BaseScreen.n = false;
                this.a(false);
            }
            if (!BaseScreen.k) {
                if (GameCanvas.var_boolean_arr_b[6] && !this.var_boolean_n && !GameCanvas.var_boolean_arr_b[4] && !GameCanvas.var_boolean_arr_b[5]) {
                    this.a(true);
                }
            } else if (GameCanvas.var_boolean_arr_b[6] && !this.var_boolean_n) {
                BaseScreen.var_boolean_o = false;
                this.a(true);
            }
            if (fireCooldown > 0) {
                fireCooldown--;
            } else if (GameCanvas.var_boolean_arr_b[5] && !this.var_boolean_n && !GameCanvas.var_boolean_arr_b[4] && !GameCanvas.var_boolean_arr_b[6]) {
                if (waitingSecondPressRelease) {
                    // Đang giữ phím từ lực 1 -> chưa nhả ra thì chưa kéo lực 2
                } else {
                    GameCanvas.var_boolean_arr_a[5] = false;
                    GameCanvas.var_boolean_arr_a[12] = false;
                    GameCanvas.var_boolean_arr_a[13] = false;
                    if (this.var_byte_f != 3) {
                        // Bắt đầu kéo lực mới: lực 1 rỗng, chưa mở lực 2
                        this.var_byte_d = 0;
                        this.var_byte_e = 0;
                        this.l111ll1l = false;
                        this.var_byte_f = (byte)3;
                        this.var_byte_g = ShopScreen.a(this.var_byte_c);
                        this.var_boolean_u = ShopScreen.b(this.var_byte_g) && !this.var_boolean_o ? true : (this.var_boolean_p ? ShopScreen.b(this.var_byte_g) : false);
                        BattleScreen.var_game_TurnTimer_a.d();
                    } else if (!this.var_boolean_u) {
                        this.var_byte_d = (byte)(this.var_byte_d + 1);
                        if (this.var_byte_d >= var_int_p) {
                            this.var_byte_f = (byte)2;
                            this.lll1IlI1lIII();
                            if (ShopScreen.b(this.var_byte_g)) {
                                this.var_boolean_u = true;
                            }
                            BaseScreen.m();
                            var_boolean_G = true;
                            fireCooldown = 25;
                        }
                    } else if (!this.l111ll1l) {
                        this.var_byte_d = (byte)(this.var_byte_d + 1);
                        if (this.var_byte_d >= var_int_p) {
                            this.l111ll1l = true;
                            waitingSecondPressRelease = true;
                        }
                    } else {
                        this.var_byte_e = (byte)(this.var_byte_e + 1);
                        if (this.var_byte_e >= var_int_q) {
                            this.var_byte_f = (byte)2;
                            this.lll1IlI1lIII();
                            this.l111ll1l = false;
                            BaseScreen.m();
                            var_boolean_G = true;
                            fireCooldown = 25;
                        }
                    }
                }
            } else {
                waitingSecondPressRelease = false;
                GameCanvas.var_boolean_arr_a[5] = false;
                if (!this.var_boolean_u) {
                    if (this.var_byte_d > 1 && this.var_byte_f == 3) {
                        this.var_byte_f = (byte)2;
                        this.lll1IlI1lIII();
                        BaseScreen.m();
                        var_boolean_G = true;
                        fireCooldown = 25;
                    } else {
                        this.var_byte_d = 0;
                    }
                } else if (this.var_byte_f == 3) {
                    if (!this.l111ll1l) {
                        if (this.var_byte_d > 1) {
                            this.l111ll1l = true;
                        }
                    } else if (this.var_byte_e > 1) {
                        this.var_byte_f = (byte)2;
                        this.lll1IlI1lIII();
                        this.l111ll1l = false;
                        BaseScreen.m();
                        var_boolean_G = true;
                        fireCooldown = 25;
                    }
                } else {
                    this.var_byte_d = 0;
                    this.var_byte_e = 0;
                }
            }
            if (this.var_byte_f == 1 && (!GameCanvas.var_boolean_arr_b[4] && this.var_int_t == 0 || !GameCanvas.var_boolean_arr_b[6] && this.var_int_t == 2)) {
                this.var_byte_f = 0;
                this.f();
                if (this.var_short_a != this.var_int_g) {
                    System.out.println("[co] INPUT x= " + (short)this.var_int_g + " y= " + (short)this.var_int_h);
                    ConnectionWatchdog.game_ConnectionWatchdog_a().a((short)this.var_int_g, (short)this.var_int_h);
                }
                this.var_short_a = (short)this.var_int_g;
            }
        }
    }

    private void lll1IlI1lIII() {
        this.var_boolean_v = false;
        var_boolean_c = true;
        this.var_boolean_d = true;
        this.var_byte_II1ll11I = 1;
        var_boolean_e = true;
        System.out.println("[co] GUN= " + this.var_byte_c);
        this.var_byte_g = ShopScreen.a(this.var_byte_c);
        switch (this.var_int_k) {
            case 1: {
                this.ll1Il1lIlI1((byte)5, (byte)1);
                return;
            }
            case 2: {
                this.var_byte_II1ll11I = (byte)(this.var_byte_II1ll11I << 1);
            }
            default: {
                this.ll1Il1lIlI1(this.var_byte_g, this.var_byte_II1ll11I);
                return;
            }
            case 6: {
                this.ll1Il1lIlI1((byte)6, (byte)1);
                return;
            }
            case 7: {
                this.ll1Il1lIlI1((byte)7, (byte)1);
                return;
            }
            case 8: {
                this.ll1Il1lIlI1((byte)4, (byte)1);
                return;
            }
            case 9: {
                this.ll1Il1lIlI1((byte)8, (byte)1);
                return;
            }
            case 11: {
                this.ll1Il1lIlI1((byte)16, (byte)1);
                return;
            }
            case 16: {
                this.ll1Il1lIlI1((byte)14, (byte)1);
                return;
            }
            case 17: {
                this.ll1Il1lIlI1((byte)13, (byte)1);
                return;
            }
            case 18: {
                this.ll1Il1lIlI1((byte)22, (byte)1);
                return;
            }
            case 19: {
                this.ll1Il1lIlI1((byte)26, (byte)1);
                return;
            }
            case 20: {
                this.ll1Il1lIlI1((byte)25, (byte)1);
                return;
            }
            case 21: {
                this.ll1Il1lIlI1((byte)23, (byte)1);
                return;
            }
            case 22: {
                this.ll1Il1lIlI1((byte)28, (byte)1);
                return;
            }
            case 23: {
                this.ll1Il1lIlI1((byte)30, (byte)1);
                return;
            }
            case 24: {
                this.ll1Il1lIlI1((byte)50, (byte)1);
                return;
            }
            case 25: {
                this.ll1Il1lIlI1((byte)51, (byte)1);
                return;
            }
            case 26: {
                this.ll1Il1lIlI1((byte)52, (byte)1);
                return;
            }
            case 27: {
                this.ll1Il1lIlI1((byte)53, (byte)1);
                return;
            }
            case 28: {
                this.ll1Il1lIlI1((byte)54, (byte)1);
                return;
            }
            case 29: {
                this.ll1Il1lIlI1((byte)55, (byte)1);
                return;
            }
            case 30: {
                this.ll1Il1lIlI1((byte)56, (byte)1);
                return;
            }
            case 31: 
        }
        this.ll1Il1lIlI1((byte)57, (byte)1);
    }

    public final void a(byte by, byte by2, short s, short s2, byte by3, short[][] sArray, short[][] sArray2, byte by4, byte by5, short s3, short[][] sArray3, short[][] sArray4, int n, int n2) {
        this.var_boolean_d = true;
        var_boolean_c = true;
        this.var_boolean_F = false;
        if (BattleManager.boolean_a() && this.var_byte_b == BattleScreen.var_byte_b) {
            this.var_boolean_v = false;
        }
        this.var_short_a = s;
        this.var_int_y = this.var_short_a;
        this.var_int_g = this.var_short_a;
        short s4 = s2;
        this.var_int_z = s4;
        this.var_int_h = s4;
        var_int_J = n;
        var_int_K = n2;
        System.out.println("name char shoot| " + this.var_java_lang_String_a + "/" + this.var_int_r + "/curFame " + this.var_int_s);
        this.c(s, s2);
        if (by3 != 36) {
            this.var_int_t = sArray[0][0] > s ? 2 : 0;
        }
        this.var_byte_g = by3;
        this.var_int_r = s3;
        this.f();
        BattleScreen.var_game_CharacterSelectScreen_a.a(by, by2, by3, sArray, sArray2, by4, by5, sArray3, sArray4, this.var_int_II1ll11I);
        this.var_byte_f = (byte)4;
        if (by3 == 35) {
            this.var_boolean_i = true;
        }
        if (by3 == 43) {
            this.var_short_arr_arr_II1ll11I = sArray;
            this.var_short_arr_arr_IIllIll1I = sArray2;
            BattleManager.b(by2, (short)(GameHelper34.var_int_a + 100), sArray2[0][0]);
        }
        if (by3 == 44) {
            PopupDialog.var_int_a = sArray[0][sArray[0].length - 1];
        }
        if (by3 == 47) {
            try {
                switch (RankingScreen.a(this.var_int_g, this.var_int_h, this.var_short_arr_arr_II1ll11I[2][3], this.var_short_arr_arr_IIllIll1I[2][3])) {
                    case 0: {
                        this.var_int_v = 0;
                        return;
                    }
                    case 1: {
                        this.var_int_v = 1;
                    }
                    default: {
                        return;
                    }
                    case 2: {
                        this.var_int_v = 2;
                        return;
                    }
                    case 3: 
                }
                this.var_int_v = 3;
                return;
            }
            catch (Exception exception) {
                Exception exception2 = exception;
                exception.printStackTrace();
            }
        }
    }

    public final void e() {
        BattleScreen.var_game_BattleGraphicHelper_a.a(this.var_int_g, this.var_int_h - 12, DataUtils.d(4), DataUtils.b(-8, -5), (byte)20);
        BattleScreen.var_game_BattleGraphicHelper_a.a(this.var_int_g, this.var_int_h - 12, DataUtils.d(3), DataUtils.b(-8, -4), (byte)20);
        BattleScreen.var_game_BattleGraphicHelper_a.a(this.var_int_g, this.var_int_h - 12, -DataUtils.d(4), DataUtils.b(-8, -5), (byte)20);
        BattleScreen.var_game_BattleGraphicHelper_a.a(this.var_int_g, this.var_int_h - 12, -DataUtils.d(3), DataUtils.b(-8, -4), (byte)20);
        GameCanvas.j = 0;
        GameCanvas.var_boolean_e = true;
    }

    private void ll1Il1lIlI1(byte by, byte by2) {
        if (BattleScreen.var_boolean_f) {
            ConnectionWatchdog.game_ConnectionWatchdog_a().a(by, (short)this.var_int_g, (short)this.var_int_h, (short)this.var_int_r, this.var_byte_d, this.var_byte_e, by2);
        } else {
            ConnectionWatchdog.game_ConnectionWatchdog_a().b(by, (short)this.var_int_g, (short)this.var_int_h, (short)this.var_int_r, this.var_byte_d, this.var_byte_e, by2);
        }
        this.var_int_l = this.var_byte_d;
        this.var_int_m = this.var_byte_e;
    }

    public final void a(int n, boolean bl, int n2) {
        if (!bl) {
            if (!this.var_boolean_o) {
                ConnectionWatchdog.game_ConnectionWatchdog_a().f((byte)n);
                if (BoardScreen.var_byte_b != 7) {
                    this.var_int_arr_a[n2] = -1;
                }
                this.var_boolean_o = true;
                return;
            }
        } else {
            switch (n) {
                case 0: 
                case 2: 
                case 32: 
                case 33: {
                    this.var_boolean_p = true;
                    new ChatScreen(this.var_int_g, this.var_int_h - 12, 5, this.var_byte_b, (byte)n);
                    break;
                }
                case 1: 
                case 6: 
                case 7: 
                case 8: 
                case 9: 
                case 11: 
                case 16: 
                case 17: 
                case 18: 
                case 19: 
                case 21: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: {
                    this.var_boolean_p = false;
                    new ChatScreen(this.var_int_g, this.var_int_h - 12, 5, this.var_byte_b, (byte)n);
                    break;
                }
                case 3: {
                    this.var_boolean_p = true;
                    this.var_boolean_y = true;
                    new ChatScreen(this.var_int_g, this.var_int_h - 12, 5, this.var_byte_b, (byte)n);
                    if (this.var_boolean_x) break;
                    new ChatScreen(this.var_int_g, this.var_int_h, 4, this.var_byte_b, (byte)n);
                    break;
                }
                case 4: 
                case 34: {
                    this.var_boolean_p = true;
                    this.var_boolean_x = true;
                    new ChatScreen(this.var_int_g, this.var_int_h - 12, 5, this.var_byte_b, (byte)n);
                    new ChatScreen(this.var_int_g, this.var_int_h, 4, this.var_byte_b, (byte)n);
                    break;
                }
                case 5: {
                    this.var_boolean_p = true;
                    new ChatScreen(this.var_int_g, this.var_int_h - 12, 5, this.var_byte_b, (byte)n);
                    break;
                }
                case 10: {
                    this.var_boolean_p = true;
                    new ChatScreen(this.var_int_g, this.var_int_h - 12, 5, this.var_byte_b, (byte)n);
                    break;
                }
                case 20: {
                    if (this.var_int_t == 2) {
                        this.var_int_r = 0;
                    }
                    if (this.var_int_t == 0) {
                        this.var_int_r = 180;
                    }
                    this.var_boolean_p = false;
                    new ChatScreen(this.var_int_g, this.var_int_h - 12, 5, this.var_byte_b, (byte)n);
                    break;
                }
                case 22: {
                    this.var_int_r = 89;
                    this.var_boolean_p = false;
                    new ChatScreen(this.var_int_g, this.var_int_h - 12, 5, this.var_byte_b, (byte)n);
                    break;
                }
                case 23: {
                    this.var_int_r = -89;
                    this.var_boolean_p = false;
                    new ChatScreen(this.var_int_g, this.var_int_h - 12, 5, this.var_byte_b, (byte)n);
                    break;
                }
                case 35: {
                    this.var_boolean_p = true;
                    new ChatScreen(this.var_int_g, this.var_int_h - 12, 5, this.var_byte_b, (byte)n);
                    new ChatScreen(this.var_int_g, this.var_int_h, 4, this.var_byte_b, (byte)n);
                    break;
                }
                case 100: {
                    new ChatScreen(this.var_int_g, this.var_int_h - 12, 5, this.var_byte_b, 38);
                }
            }
            this.var_int_k = n;
            System.out.println("[co] ITEM USE= " + this.var_int_k);
            this.var_byte_f = 0;
            if (!this.var_boolean_x) {
                new ChatScreen(this.var_int_g, this.var_int_h - 12, 3, this.var_byte_b, (byte)n);
            }
            if (this.var_byte_b == BattleScreen.var_byte_b && n != 100) {
                ExplosionEffect.a((int)n).g = (byte)(ExplosionEffect.a((int)n).g - 1);
            }
            this.var_byte_d = 0;
            this.var_byte_e = 0;
            if (this.var_int_k != 100 && this.l111ll1l) {
                this.l111ll1l = false;
            }
            isPullingForce = false;
            waitingSecondPressRelease = false;
            keyHoldFrames = 0;
        }
    }

    public void a(Graphics graphics) {
        if (this.var_boolean_g) {
            if (!(this.var_byte_b != BattleScreen.var_byte_b && BattleScreen.var_boolean_i || this.var_int_g <= GameHelper16.b - 75 || this.var_int_g - 75 >= GameHelper16.b + GameCanvas.var_int_b)) {
                if (BoardScreen.var_byte_b != 7 || this.var_byte_f != 5 && this.var_int_w != 0) {
                    if (!BattleScreen.var_java_lang_String_a.equals("") || !this.var_boolean_x || this.var_byte_b == BattleScreen.var_byte_b || this.var_boolean_b == BattleManager.var_game_PlayerEntity_arr_a[BattleScreen.var_byte_b].var_boolean_b) {
                        if (this.var_byte_f != 5 && this.var_byte_c < 11 && this.var_boolean_w) {
                            ++this.lIllIIl1I;
                            if (this.lIllIIl1I == 2) {
                                this.lIllIIl1I = 0;
                                ++this.l1III1llIl1l;
                                if (this.l1III1llIl1l > 3) {
                                    this.l1III1llIl1l = 0;
                                }
                            }
                            DataUtils.a(graphics, l1lIIII11llI, 0, this.l1III1llIl1l * 47, 41, 47, 0, this.var_int_g, this.var_int_h, 33);
                        }
                        int n = this.var_int_t;
                        if (this.var_byte_f == 8) {
                            n = this.var_int_llIIIIllll1;
                        }
                        if (this.var_byte_c != 15 && this.var_byte_c != 16 && this.var_byte_c != 17 && this.var_byte_c != 19 && this.var_byte_c != 21 && this.var_byte_c != 22 && this.var_byte_c != 23 && this.var_byte_c != 24) {
                            if (BoardScreen.var_byte_b != 7 || BoardScreen.var_byte_b == 7 && this.var_byte_f != 5 && this.var_int_w != 0) {
                                if (this.var_game_EquipSlotSet_II1ll11I != null) {
                                    this.var_game_EquipSlotSet_II1ll11I.a(graphics, n, this.var_int_s, this.var_int_g, this.var_int_h);
                                } else {
                                    this.var_game_GameHelper29_a.a(this.var_int_s, this.var_int_g, this.var_int_h, n, 33, graphics);
                                }
                                if (this.var_javax_microedition_lcdui_Image_b != null && BattleScreen.var_boolean_h) {
                                    graphics.drawImage(this.var_javax_microedition_lcdui_Image_b, this.var_int_g - ((this.var_boolean_b ? FontRenderer.g : FontRenderer.h).a(this.var_java_lang_String_a) >> 1) - 5, this.var_int_h - 37, 33);
                                }
                            }
                            if (var_boolean_H && ++lIlI11ll1I == 10) {
                                lIlI11ll1I = 0;
                                var_boolean_H = false;
                            }
                            if (this.var_boolean_z && GameCanvas.var_int_a % 5 == 0) {
                                new ChatScreen(DataUtils.b(this.var_int_g - 10, this.var_int_g + 10), DataUtils.b(this.var_int_h - 20, this.var_int_h + 2), 10);
                            }
                            if (BattleScreen.var_game_CharacterSelectScreen_a.var_byte_b == 0 && this.var_byte_b == BattleScreen.var_byte_b && GameCanvas.var_int_a % 2 == 0) {
                                ++this.lI11I1I1lllI;
                                if (this.lI11I1I1lllI == 2) {
                                    this.lI11I1I1lllI = 0;
                                }
                            }
                        }
                        int n2 = n;
                        int n3 = this.var_int_h;
                        int n4 = this.var_int_g;
                        Graphics graphics2 = graphics;
                        PlayerEntity playerEntity = this;
                        if (var_boolean_L) {
                            playerEntity.var_game_FloatingTextManager_a.a(graphics2, n4, n3, n2);
                        }
                        if (BattleScreen.var_java_lang_String_a.equals("") && this.var_byte_c != 15 && this.var_byte_f != 5 && this.var_int_w > 0) {
                            byte by = (byte)(this.var_byte_c == 10 ? 46 : 40);
                            graphics.setColor(0xFFFFFF);
                            graphics.fillRect(this.var_int_g - 15, this.var_int_h + 5 - by, 25, 4);
                            if (this.var_int_L > 16) {
                                graphics.setColor(65280);
                            } else if (this.var_int_L > 8) {
                                graphics.setColor(0xFF8000);
                            } else {
                                graphics.setColor(0xFF0000);
                            }
                            if (this.var_int_L > 25) {
                                this.var_int_L = 25;
                            }
                            graphics.fillRect(this.var_int_g - 15, this.var_int_h + 5 - by, this.var_int_L, 4);
                            graphics.setColor(0);
                            graphics.drawRect(this.var_int_g - 15, this.var_int_h + 5 - by, 25, 4);
                            if (var_boolean_I) {
                                FontRenderer.d.a(graphics, "HP: " + this.var_int_w + "/" + this.var_int_x, this.var_int_g, this.var_int_h + 5 - by - 23, 2);
                            }
                        }
                        if (BattleScreen.var_java_lang_String_a.equals("") && !(this instanceof PopupDialog)) {
                            if (BattleManager.var_byte_a == this.var_byte_b) {
                                if (GameCanvas.var_int_a % 10 > 5) {
                                    (this.var_boolean_b ? FontRenderer.g : FontRenderer.h).a(graphics, this.var_java_lang_String_a, this.var_int_g, this.var_int_h - 44, 2);
                                }
                            } else {
                                (this.var_boolean_b ? FontRenderer.g : FontRenderer.h).a(graphics, this.var_java_lang_String_a, this.var_int_g, this.var_int_h - 44, 2);
                            }
                            // huy hieu vip: ve ngoai dieu kien nhay de khong nhay theo ten
                            VipManager.drawAfterName(graphics, this.var_boolean_b ? FontRenderer.g : FontRenderer.h, this.var_java_lang_String_a, this.var_int_vipUserId, this.var_int_g, this.var_int_h - 44);
                            byte by = (byte)(this.var_byte_c == 10 ? 35 : 27);
                            BoardScreen.a(graphics, this.M, this.var_int_g, this.var_int_h - by, 3);
                        }
                    }
                    this.b(graphics);
                    if (this.var_boolean_l1IllIll1) {
                        graphics.setColor(0xFF0000);
                        FontRenderer.e.a(graphics, this.var_java_lang_String_III1l1II1lI, this.var_int_g, this.var_int_h - this.II1I11llI11l, 3);
                        ++this.II1I11llI11l;
                        if (this.II1I11llI11l > 200) {
                            this.var_boolean_l1IllIll1 = false;
                            this.var_java_lang_String_III1l1II1lI = "";
                        }
                    }
                    if (this.var_boolean_IllI1l11llI) {
                        FontRenderer.e.a(graphics, this.lII11I1l, this.var_int_g, this.var_int_h - this.ll1l1I1II, 3);
                        graphics.drawImage(BaseScreen.s, this.var_int_g + 20, this.var_int_h - this.ll1l1I1II + 10, 3);
                        ++this.ll1l1I1II;
                        if (this.ll1l1I1II > 200) {
                            this.var_boolean_IllI1l11llI = this.var_boolean_n;
                            this.lII11I1l = "";
                        }
                    }
                    if (BattleManager.boolean_a() && BattleScreen.var_byte_b == this.var_byte_b && this.var_byte_f != 8 && !(this instanceof PopupDialog)) {
                        graphics.drawImage(var_javax_microedition_lcdui_Image_II1ll11I, this.var_int_g + this.var_int_lIl11lIll1, this.var_int_h - this.var_int_I11IlllI1 - 11, 3);
                    }
                    graphics.setColor(0);
                }
            } else if (this.var_byte_b != BattleManager.var_byte_a && BattleManager.game_PlayerEntity_a().var_boolean_b != this.var_boolean_b) {
                int n = this.var_int_g;
                int n5 = this.var_int_h - 12;
                if (n <= GameHelper16.b + 5 || n >= GameHelper16.b + GameCanvas.var_int_b - 10 || n5 <= GameHelper16.c + 20 || n5 >= GameHelper16.c + GameCanvas.var_int_c - 30) {
                    if (n < GameHelper16.b + 5) {
                        n = GameHelper16.b + 5;
                    } else if (n > GameHelper16.b + GameCanvas.var_int_b - 10) {
                        n = GameHelper16.b + GameCanvas.var_int_b - 10;
                    }
                    if (n5 < GameHelper16.c + 20) {
                        n5 = GameHelper16.c + 20;
                    } else if (n5 > GameHelper16.c + GameCanvas.var_int_c - 30) {
                        n5 = GameHelper16.c + GameCanvas.var_int_c - 30;
                    }
                    graphics.setColor(0xFF0000);
                    graphics.fillRect(n, n5, 2, 2);
                    if (GameCanvas.var_int_a % 10 > 5) {
                        graphics.drawRect(n - 2, n5 - 2, 5, 5);
                    }
                }
            }
            if (this.var_boolean_f) {
                graphics.drawImage(ChatScreen.a, this.var_int_g, this.var_int_h - 12, 3);
            }
            if (BattleManager.boolean_a() && BattleManager.var_byte_a == this.var_byte_b) {
                this.l1ll1IIll1(graphics);
            }
        }
    }

    private void l1ll1IIll1(Graphics graphics) {
        if (this.var_byte_c <= 9 && var_boolean_J) {
            int n = this.var_int_g + (20 * DataUtils.b(this.var_int_r) >> 10);
            int n2 = this.var_int_h - 12 - (20 * DataUtils.int_a(this.var_int_r) >> 10);
            int n3 = var_int_p * DataUtils.b(this.var_int_r) >> 10;
            int n4 = -(var_int_p * DataUtils.int_a(this.var_int_r) >> 10);
            if (this.var_boolean_o) {
                switch (this.var_int_k) {
                    case 1: {
                        this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4, 0, 0, 80, 65280);
                        return;
                    }
                    default: {
                        break;
                    }
                    case 6: {
                        int n5 = BattleScreen.var_int_k * 70 / 100;
                        int n6 = BattleScreen.var_int_l * 70 / 100;
                        this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4, n5, n6, 90, 0xFF0000);
                        return;
                    }
                    case 7: {
                        int n7 = BattleScreen.var_int_k * 70 / 100;
                        int n8 = BattleScreen.var_int_l * 70 / 100;
                        this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4, n7, n8, 80, 0xFF0000);
                        return;
                    }
                    case 8: {
                        this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4, 0, 0, 80, 0xFF0000);
                        return;
                    }
                    case 9: {
                        int n9 = BattleScreen.var_int_k * 70 / 100;
                        int n10 = BattleScreen.var_int_l * 70 / 100;
                        this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4, n9, n10, 70, 0xFFFF00);
                        return;
                    }
                    case 11: {
                        this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4, 0, 0, 100, 0xFF0000);
                        return;
                    }
                    case 16: {
                        int n11 = BattleScreen.var_int_k * 10 / 100;
                        int n12 = BattleScreen.var_int_l * 10 / 100;
                        this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4, n11, n12, 50, 0xFF0000);
                        return;
                    }
                    case 17: {
                        int n13 = BattleScreen.var_int_k * 50 / 100;
                        int n14 = BattleScreen.var_int_l * 50 / 100;
                        this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4, n13, n14, 120, 0xFFFF00);
                        return;
                    }
                    case 18: {
                        return;
                    }
                    case 19: {
                        int n15 = BattleScreen.var_int_k * 30 / 100;
                        int n16 = BattleScreen.var_int_l * 30 / 100;
                        this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4, n15, n16, 60, 0xFFFF00);
                        return;
                    }
                    case 20: {
                        this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4, 0, 0, -50, 0xFF0000);
                        return;
                    }
                    case 21: {
                        int n17 = BattleScreen.var_int_k * 20 / 100;
                        int n18 = BattleScreen.var_int_l * 20 / 100;
                        this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4, n17, n18, 100, 0xFFFF00);
                        return;
                    }
                    case 22: {
                        this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4 /= 2, 0, 0, 20, 0xFFFF00);
                        return;
                    }
                    case 23: {
                        return;
                    }
                    case 25: {
                        int n19 = BattleScreen.var_int_k * 5 / 100;
                        int n20 = BattleScreen.var_int_l * 5 / 100;
                        this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4, n19, n20, 60, 0xFFFF00);
                        return;
                    }
                    case 26: {
                        int n21 = BattleScreen.var_int_k * 10 / 100;
                        int n22 = BattleScreen.var_int_l * 10 / 100;
                        this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4, n21, n22, 100, 0xFF0000);
                        return;
                    }
                    case 28: {
                        this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4, 0, 0, 80, 0xFFFF00);
                        return;
                    }
                    case 29: {
                        int n23 = BattleScreen.var_int_k * 6 / 100;
                        int n24 = BattleScreen.var_int_l * 6 / 100;
                        this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4, n23, n24, 60, 0xFFFF00);
                        return;
                    }
                    case 30: {
                        int n25 = BattleScreen.var_int_k * 70 / 100;
                        int n26 = BattleScreen.var_int_l * 70 / 100;
                        int n27 = this.var_int_r - 5;
                        int n28 = 0;
                        while (n28 < 3) {
                            n = this.var_int_g + (20 * DataUtils.b(n27) >> 10);
                            n2 = this.var_int_h - 12 - (20 * DataUtils.int_a(n27) >> 10);
                            n3 = var_int_p * DataUtils.b(n27) >> 10;
                            n4 = -(var_int_p * DataUtils.int_a(n27) >> 10);
                            this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4, n25, n26, 70, 0xFFFF00);
                            ++n28;
                            n27 += 5;
                        }
                        return;
                    }
                    case 31: {
                        this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4, 0, 0, 120, 0xFFFF00);
                        return;
                    }
                }
            }
            switch (this.var_byte_c) {
                case 0: {
                    int n29 = BattleScreen.var_int_k * 80 / 100;
                    int n30 = BattleScreen.var_int_l * 80 / 100;
                    this.ll1Il1lIlI1(graphics, 0, n, n2, n3, n4, n29, n30, 100, 255);
                    return;
                }
                case 1: {
                    int n31 = BattleScreen.var_int_k * 50 / 100;
                    int n32 = BattleScreen.var_int_l * 50 / 100;
                    this.ll1Il1lIlI1(graphics, 1, n, n2, n3, n4, n31, n32, 50, 255);
                    return;
                }
                case 2: {
                    int n33 = BattleScreen.var_int_k * 80 / 100;
                    int n34 = BattleScreen.var_int_l * 80 / 100;
                    int n35 = this.var_int_r - 5;
                    int n36 = 0;
                    while (n36 < 3) {
                        n = this.var_int_g + (20 * DataUtils.b(n35) >> 10);
                        n2 = this.var_int_h - 12 - (20 * DataUtils.int_a(n35) >> 10);
                        n3 = var_int_p * DataUtils.b(n35) >> 10;
                        n4 = -(var_int_p * DataUtils.int_a(n35) >> 10);
                        this.ll1Il1lIlI1(graphics, 2, n, n2, n3, n4, n33, n34, 60, 255);
                        ++n36;
                        n35 += 5;
                    }
                    return;
                }
                case 3: {
                    int n37 = BattleScreen.var_int_k * 40 / 100;
                    int n38 = BattleScreen.var_int_l * 40 / 100;
                    int n39 = this.var_int_r - 6;
                    int n40 = 0;
                    while (n40 < 4) {
                        n = this.var_int_g + (20 * DataUtils.b(n39) >> 10);
                        n2 = this.var_int_h - 12 - (20 * DataUtils.int_a(n39) >> 10);
                        n3 = var_int_p * DataUtils.b(n39) >> 10;
                        n4 = -(var_int_p * DataUtils.int_a(n39) >> 10);
                        this.ll1Il1lIlI1(graphics, 3, n, n2, n3, n4, n37, n38, 90, 255);
                        ++n40;
                        n39 += 4;
                    }
                    return;
                }
                case 4: {
                    int n41 = BattleScreen.var_int_k * 50 / 100;
                    int n42 = BattleScreen.var_int_l * 50 / 100;
                    this.ll1Il1lIlI1(graphics, 4, n, n2, n3, n4, n41, n42, 80, 255);
                    return;
                }
                case 5: {
                    int n43 = BattleScreen.var_int_k * 30 / 100;
                    int n44 = BattleScreen.var_int_l * 30 / 100;
                    this.ll1Il1lIlI1(graphics, 5, n, n2, n3, n4, n43, n44, 90, 255);
                    return;
                }
                case 6: {
                    int n45 = BattleScreen.var_int_k * 20 / 100;
                    int n46 = BattleScreen.var_int_l * 20 / 100;
                    this.ll1Il1lIlI1(graphics, 6, n, n2, n3, n4, n45, n46, 50, 255);
                    return;
                }
                case 7: {
                    int n47 = BattleScreen.var_int_k * 10 / 100;
                    int n48 = BattleScreen.var_int_l * 10 / 100;
                    this.ll1Il1lIlI1(graphics, 7, n, n2, n3, n4, n47, n48, 50, 255);
                    return;
                }
                case 8: {
                    int n49 = BattleScreen.var_int_k * 30 / 100;
                    int n50 = BattleScreen.var_int_l * 30 / 100;
                    this.ll1Il1lIlI1(graphics, 8, n, n2, n3, n4, n49, n50, 100, 255);
                    return;
                }
                case 9: {
                    int n51 = BattleScreen.var_int_k * 40 / 100;
                    int n52 = BattleScreen.var_int_l * 40 / 100;
                    if (!BattleScreen.var_boolean_f) {
                        n3 = (var_int_p + 5) * DataUtils.b(this.var_int_r) >> 10;
                        n4 = -((var_int_p + 5) * DataUtils.int_a(this.var_int_r) >> 10);
                    }
                    this.ll1Il1lIlI1(graphics, 9, n, n2, n3, n4, n51, n52, 70, 255);
                }
            }
        }
    }

    private void ll1Il1lIlI1(Graphics graphics, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        int n10 = n2;
        int n11 = n3;
        graphics.setColor(n9);
        boolean bl = n4 <= 0;
        int n12 = -1;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        for (int i = 1; var_short_b < 0 || i < var_short_b; ++i) {
            int n16 = n10 + n4;
            int n17 = n11 + n5;
            graphics.drawLine(n10, n11, n16, n17);
            if ((n == 6 || n == 8) && i > 1 && i <= 31 && i % var_short_c == 0) {
                if (i - 1 == var_int_q) {
                    graphics.setColor(0x555555);
                } else {
                    graphics.setColor(0xFF0000);
                }
                FontRenderer.d.a(graphics, String.valueOf(i - 1), n10, n11 + 5, 65);
                graphics.setColor(n9);
            }
            n14 += n7;
            n15 += n8;
            if (Math.abs(n13 += n6) >= 100) {
                n4 += n13 / 100;
                n13 %= 100;
            }
            if (Math.abs(n14) >= 100) {
                n5 += n14 / 100;
                n14 %= 100;
            }
            if (Math.abs(n15) >= 100) {
                n5 += n15 / 100;
                n15 %= 100;
            }
            if (n5 > 0 && n17 > GameHelper16.c + GameCanvas.var_int_c || n16 < -100 || n16 > GameHelper34.var_int_a + 100) break;
            if (n == 6) {
                if (i == var_int_q) {
                    this.ll1Il1lIlI1(graphics, 0, n16, n17 + 8, 0, 0, n6 / 2, n7 / 2, 30, 65280);
                }
                graphics.setColor(n9);
            } else if (n == 7) {
                if (n12 == 0) {
                    n4 = bl ? ++n4 : --n4;
                    n12 = (byte)(n12 + 1);
                } else if (n12 > 0) {
                    n4 = bl ? (n4 += 2) : (n4 -= 2);
                } else if (n5 > 0) {
                    n12 = (byte)(n12 + 1);
                }
            } else if (n == 8) {
                if (i == var_int_q) {
                    n12 = this.var_int_r + DataUtils.c(DataUtils.a(this.var_int_g - n10, this.var_int_h - n11));
                    if (this.var_int_r < 90) {
                        n12 = 180 - n12;
                    }
                    n12 -= 15;
                    n = 0;
                    while (n < 3) {
                        n2 = n10 + (20 * DataUtils.b(n12) >> 10);
                        n3 = n11 - 12 - (20 * DataUtils.int_a(n12) >> 10);
                        n4 = var_int_p * DataUtils.b(n12) >> 11;
                        n5 = -(var_int_p * DataUtils.int_a(n12) >> 11);
                        this.ll1Il1lIlI1(graphics, 0, n2, n3, n4, n5, n6, n7, n8, 65280);
                        ++n;
                        n12 += 15;
                    }
                    return;
                }
            } else if (n == 9 && n12 < 0 && n5 >= 0) {
                n12 = DataUtils.a(n16 - n2, n3 - n17);
                n4 = var_int_p * DataUtils.b(n12) >> 10;
                n5 = var_int_p * DataUtils.int_a(n12) >> 10;
                if (n4 != 0) {
                    while (Math.abs(n4) < 15) {
                        n4 += n4;
                        n5 += n5;
                    }
                }
                n6 = 0;
                n7 = 0;
                n8 = 0;
                n13 = 0;
                n14 = 0;
                n15 = 0;
                graphics.setColor(0xFF0000);
                n12 = 0;
            }
            n10 = n16;
            n11 = n17;
        }
    }

    public final void b(byte by) {
        this.var_byte_h = by;
        if (this.var_byte_h == 100) {
            this.var_boolean_w = true;
        }
        if (this.var_byte_h != 100) {
            this.var_boolean_w = false;
        }
    }

    public final void a(int n, byte by) {
        System.out.println("[co] UPDATE HP nexHP= " + n);
        if (n < this.var_int_w && this.var_byte_b != BattleScreen.var_byte_b) {
            // danh trung dich -> pet moi lao len danh
            BattlePet.onHitLanded(this.var_byte_b);
        }
        boolean bl = true;
        this.var_boolean_llIIIIllll1 = true;
        this.var_int_L = by;
        if (n < this.var_int_w) {
            this.var_java_lang_String_IIllIll1I = "- " + (this.var_int_w - n);
            BattleScreen.var_game_GameHelper16_a.a(this.var_int_g, this.var_int_h);
        } else {
            this.var_java_lang_String_IIllIll1I = "+ " + (n - this.var_int_w);
            bl = false;
        }
        this.I1II1lII = 25;
        this.var_int_w = n;
        if (n <= 0) {
            this.I1IIlIII();
        }
        if (bl) {
            BattleScreen.g();
        }
    }

    public final void c(int n) {
        this.var_boolean_l1IllIll1 = true;
        this.II1I11llI11l = 30;
        this.var_java_lang_String_III1l1II1lI = n >= 0 ? "exp: +" + n : "exp: " + n;
        BattleScreen.var_game_GameHelper16_a.a(this.var_int_g, this.var_int_h);
        BattleScreen.g();
    }

    public final void d(int n) {
        this.var_boolean_IllI1l11llI = true;
        this.ll1l1I1II = 35;
        this.lII11I1l = n >= 0 ? " +" + n : " " + n;
        BattleScreen.var_game_GameHelper16_a.a(this.var_int_g, this.var_int_h);
        BattleScreen.g();
    }

    private void I1IIlIII() {
        this.var_byte_f = (byte)5;
        this.var_int_w = 0;
        this.var_int_s = 7;
        if (this.var_boolean_x) {
            this.var_boolean_x = false;
        }
        if (this.var_boolean_y) {
            this.var_boolean_y = false;
        }
        if (this.var_boolean_j) {
            if (this.var_byte_c == 21) {
                return;
            }
            if (this.var_byte_c == 17) {
                return;
            }
            this.var_boolean_n = true;
        }
        Object object = GameHelper01.b;
        synchronized (object) {
            GameHelper01.b.notify();
            return;
        }
    }

    protected final void b(Graphics graphics) {
        if (this.var_boolean_llIIIIllll1) {
            graphics.setColor(0xFF0000);
            FontRenderer.f.a(graphics, this.var_java_lang_String_IIllIll1I, this.var_int_g, this.var_int_h - this.I1II1lII, 3);
            ++this.I1II1lII;
            if (this.I1II1lII > 50) {
                this.var_boolean_llIIIIllll1 = false;
                this.var_java_lang_String_IIllIll1I = "";
            }
        }
    }

    public final void a(boolean bl) {
        if (this.var_byte_f == 0 || this.var_byte_f == 2 || this.var_byte_f == 8) {
            this.var_byte_f = 1;
            this.var_int_s = 4;
        }
        if (this.var_byte_f != 3) {
            if (bl) {
                if (this.var_int_t != 2) {
                    this.var_int_r = 180 - this.var_int_r;
                }
                this.var_int_t = 2;
            } else {
                if (this.var_int_t != 0) {
                    this.var_int_r = 180 - this.var_int_r;
                }
                this.var_int_t = 0;
            }
        }
        if (!this.var_boolean_f && this.var_byte_f == 1) {
            if (!this.var_boolean_r) {
                this.var_boolean_r = true;
            }
            if (GameHelper34.var_boolean_a && BattleScreen.var_java_util_Vector_b.isEmpty()) {
                GameHelper34.boolean_a(this.var_int_g, this.var_int_h, (byte)0);
            }
            int n2 = this.var_byte_j;
            if (this.var_boolean_y) {
                n2 = 2;
            }
            if (!this.var_boolean_B) {
                if (this.var_int_n > 60) {
                    return;
                }
                ++this.var_int_n;
            }
            ++this.var_int_IlI1IIllllI;
            if (this.var_int_IlI1IIllllI > 2) {
                ++this.var_int_s;
                if (this.var_int_s == 6) {
                    this.var_int_s = 4;
                }
                this.var_int_IlI1IIllllI = 0;
            }
            this.var_int_g = bl ? (this.var_int_g + n2) : (this.var_int_g - n2);
            this.var_boolean_n = true;
            if (GameHelper34.a(this.var_int_g, this.var_int_h - 5)) {
                if (!this.var_boolean_B) {
                    --this.var_int_n;
                }
                this.var_int_g = bl ? (this.var_int_g - n2) : (this.var_int_g + n2);
                this.var_boolean_n = false;
                if (this.var_boolean_B && this.var_int_g == this.var_int_y && this.var_int_h != this.var_int_z) {
                    this.var_int_h = this.var_int_z;
                    return;
                }
            } else {
                for (int k = 4; k >= 0; --k) {
                    if (!GameHelper34.a(this.var_int_g, this.var_int_h - k)) continue;
                    this.var_int_h -= k;
                    this.var_int_z = this.var_int_h;
                    this.var_boolean_n = false;
                    if (this.var_boolean_B && this.var_int_g == this.var_int_y && this.var_int_h != this.var_int_z) {
                        this.var_int_h = this.var_int_z;
                    }
                    return;
                }
            }
        }
    }

    private void lI1ll1ll11() {
        if (this.var_byte_f != 1) {
            this.var_int_r += this.var_int_IIllIll1I;
            if (this.var_int_IIllIll1I < 15) {
                this.var_int_IIllIll1I += 2;
            }
            this.I1I1Il1ll1();
            this.f();
        }
    }

    private void l11lIIlllII() {
        if (this.var_byte_f != 1) {
            this.var_int_r -= this.var_int_IIllIll1I;
            if (this.var_int_IIllIll1I < 15) {
                this.var_int_IIllIll1I += 2;
            }
            this.I1I1Il1ll1();
            this.f();
        }
    }

    public final void f() {
        if (this.var_int_r < 255 && this.var_int_r > 90) {
            this.var_int_t = 0;
            if (this.var_int_r <= 195) {
                if (this.var_int_r > 165) {
                    this.var_int_s = 1;
                    return;
                }
                if (this.var_int_r > 115) {
                    this.var_int_s = 2;
                    return;
                }
                this.var_int_s = 3;
                return;
            }
        } else {
            this.var_int_t = 2;
            if (this.var_int_r > 65) {
                this.var_int_s = 3;
                return;
            }
            if (this.var_int_r > 15) {
                this.var_int_s = 2;
                return;
            }
            if (this.var_int_r > -15) {
                this.var_int_s = 1;
                return;
            }
        }
        this.var_int_s = 0;
    }

    public final void e(int n) {
        if (this.var_byte_f != 8 && this.var_byte_f != 5) {
            this.var_byte_f = (byte)8;
            this.var_int_IlI1IIllllI = 0;
            this.var_int_s = 6;
            this.var_int_llIIIIllll1 = n;
        }
    }

    public final void b(int n, int n2) {
        if (n > n2) {
            this.var_int_t = 2;
            return;
        }
        this.var_int_t = 0;
    }

    public final void g() {
        this.var_int_s = 8;
        this.var_byte_f = (byte)7;
    }

    public static void a(Graphics graphics, int n, int n2, int n3, int n4, int n5, EquipSlotSet equipSlotSet) {
        int n6 = n != 3 ? 24 : 32;
        if (n == 7) {
            n6 = 32;
        }
        if (n == 12) {
            n6 = 28;
        }
        if (n == 14) {
            n6 = 30;
            n2 = 0;
        }
        if (n == 10) {
            n6 = 22;
        }
        if (n == 13) {
            if (++IllllIllIl1I == 10) {
                IllllIllIl1I = 0;
            }
            if (IllllIllIl1I == 5) {
                Illl1ll1I1I = 1;
            }
            if (IllllIllIl1I == 0) {
                Illl1ll1I1I = 0;
            }
            DataUtils.a(graphics, var_javax_microedition_lcdui_Image_v, 0, 0, 42, 30, 2, n3 + 4, n4 - 10 + Illl1ll1I1I, 33);
            DataUtils.a(graphics, var_javax_microedition_lcdui_Image_w, 0, 0, 44, 25, 2, n3, n4, 33);
            DataUtils.a(graphics, llllll11lIII, 0, 15, 15, 15, 0, n3, n4 - 15 + Illl1ll1I1I, 33);
            return;
        }
        if (n == 15) {
            if (++IllllIllIl1I == 10) {
                IllllIllIl1I = 0;
            }
            if (IllllIllIl1I == 5) {
                Illl1ll1I1I = 1;
            }
            if (IllllIllIl1I == 0) {
                Illl1ll1I1I = 0;
            }
            graphics.drawImage(var_javax_microedition_lcdui_Image_c, n3, n4, 33);
            lIIl1lI1 = -20;
            DataUtils.a(graphics, ll1Il1lIll1, 0, 0, 35, 40, 0, n3 + lIIl1lI1, n4 - 22 + Illl1ll1I1I, 3);
            graphics.drawImage(var_javax_microedition_lcdui_Image_d, n3 - 1, n4 - 10 + Illl1ll1I1I, 33);
            DataUtils.a(graphics, ll1Il1lIll1, 0, 0, 35, 40, 0, n3, n4 - 20 + Illl1ll1I1I, 3);
            return;
        }
        if (n == 16) {
            DataUtils.a(graphics, var_javax_microedition_lcdui_Image_r, 0, 0, 51, 46, 0, n3, n4, 33);
            if (GameCanvas.var_int_a % 3 == 0) {
                DataUtils.a(graphics, var_javax_microedition_lcdui_Image_s, 0, 0, 16, 11, 0, n3, n4 + -5, 17);
                return;
            }
            DataUtils.a(graphics, var_javax_microedition_lcdui_Image_s, 0, 11, 16, 11, 0, n3, n4 - 5, 17);
            return;
        }
        if (n == 17) {
            if (++IIlI1I1lII == 20) {
                IIlI1I1lII = 0;
            }
            llIlIIIIlIIl = IIlI1I1lII <= 10 ? -1 : 0;
            graphics.drawImage(ClanScreen.var_javax_microedition_lcdui_Image_d, n3, n4 + llIlIIIIlIIl, 33);
            return;
        }
        if (n == 22) {
            graphics.setColor(0x7A7A7A);
            DataUtils.a(graphics, var_javax_microedition_lcdui_Image_t, 0, 0, 41, 22, 1, n3 + 1, n4, 33);
            DataUtils.a(graphics, var_javax_microedition_lcdui_Image_t, 0, 0, 41, 22, 0, n3, n4 - 22, 33);
            return;
        }
        if (n == 25) {
            DataUtils.a(graphics, var_javax_microedition_lcdui_Image_o, 0, 0, 35, 32, 0, n3, n4, 33);
            return;
        }
        if (n == 26) {
            DataUtils.a(graphics, var_javax_microedition_lcdui_Image_p, 0, 0, 35, 32, 0, n3, n4, 33);
            return;
        }
        if (equipSlotSet != null) {
            equipSlotSet.a(graphics, n5, n2, n3, n4);
            return;
        }
        DataUtils.a(graphics, var_javax_microedition_lcdui_Image_arr_a[n], 0, n2 * n6, var_javax_microedition_lcdui_Image_arr_a[n].getWidth(), n6, n5, n3, n4, 33);
    }

    public final void c(int n, int n2) {
        if (this.var_byte_b == BattleScreen.var_byte_b) {
            this.var_int_i = n;
            this.var_int_j = n2;
        }
    }

    public final void h() {
        PlayerEntity playerEntity = this;
        if (var_boolean_L) {
            playerEntity.var_game_FloatingTextManager_a.b();
        }
    }

    static {
        var_boolean_e = false;
        var_int_III1l1II1lI = 0;
        var_short_arr_a = null;
        var_javax_microedition_lcdui_Image_arr_a = new Image[25];
        var_boolean_I = true;
        var_boolean_J = true;
        var_boolean_K = true;
        var_boolean_L = true;
        var_short_b = (short)-1;
        var_short_c = 1;
        l1lIIII11llI = RankingScreen.b;
        var_int_p = 30;
        var_int_q = 30;
        try {
            Object object = DataUtils.byte_arr_a("V9Data");
            if (object != null) {
                object = new ByteArrayInputStream((byte[])object);
                DataInputStream dataInputStream = new DataInputStream((InputStream)object);
                var_boolean_I = dataInputStream.readBoolean();
                var_boolean_J = dataInputStream.readBoolean();
                var_boolean_K = dataInputStream.readBoolean();
                var_short_b = dataInputStream.readShort();
                var_short_c = dataInputStream.readShort();
                if (dataInputStream.available() > 0) {
                    var_boolean_L = dataInputStream.readBoolean();
                }
                dataInputStream.close();
                ((ByteArrayInputStream)object).close();
            }
        }
        catch (Exception exception) {}
    }
}

