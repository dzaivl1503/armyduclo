/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
package game;

import game.BattleManager;
import game.BattleScreen;
import game.BoardScreen;
import game.ChatScreen;
import game.ConnectionWatchdog;
import game.DataUtils;
import game.EquipScreen;
import game.FontRenderer;
import game.GameCanvas;
import game.GameHelper01;
import game.GameHelper16;
import game.GameHelper31;
import game.GameHelper34;
import game.GameHelper37;
import game.PlayerEntity;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class PopupDialog
extends PlayerEntity {
    private int[] l11lIIl1l1I = new int[6];
    private int[] l1IIIII1 = new int[6];
    private boolean IIlII1I11 = false;
    private boolean var_boolean_II11lIII = false;
    private boolean var_boolean_Ill1I11I = false;
    private boolean var_boolean_Ill1III11l = true;
    private boolean var_boolean_I1llIlIlI = false;
    private int var_int_II11lIII = 0;
    private int var_int_Ill1I11I = GameHelper34.var_int_b + 30;
    private int var_int_Ill1III11l;
    private int var_int_I1llIlIlI;
    private int var_int_lI1II1lII;
    public static Image var_javax_microedition_lcdui_Image_a;
    private static Image I1I1IlI111I;
    private static Image lIlllI1I;
    private int var_int_I11llIIIII;
    private static int var_int_l1I1I1ll;
    public static int var_int_a;
    private int lIll1111;
    private int lI1IlI1l;
    private int Il1Il111I1;
    private int I11I1Il11I;
    private int lI1l1lllIl1 = 8;
    private boolean var_boolean_lI1II1lII;
    private int lIlIIIIIl;
    private int IIlIlI1III;
    private int l11lIIIII1 = 0;
    private int lIIlllIl = 0;
    private int IIIll11ll1I1 = 0;
    private int l1lIIl1111l;
    private int IIIl1I1I;
    private int I11IlI1I1I1;
    private int lI1I1II1I1;
    private int Il1llI1I1l;
    private int llIlI11Ill;
    private int II1II1lII = 18;
    public static int b;
    private boolean var_boolean_I11llIIIII;
    public boolean var_boolean_a;
    public byte var_byte_a;
    public int c;
    private Image llIlI1l11111;
    private boolean var_boolean_l1I1I1ll;

    public PopupDialog(int n, byte by, int n2, int n3, boolean bl, int n4, byte by2, int n5) {
        super(n, by, n2, n3, bl, n4, by2, null, n5);
        if (this.var_byte_c == 11) {
            new ChatScreen(this.var_int_g, this.var_int_h, 1);
        }
        if (this.var_byte_c == 13 || this.var_byte_c == 14) {
            this.var_boolean_m = true;
        }
        if (this.var_byte_c == 16 || this.var_byte_c == 17 || this.var_byte_c == 19 || this.var_byte_c == 18 || this.var_byte_c == 21 || this.var_byte_c == 20 || this.var_byte_c == 22 || this.var_byte_c == 24 || this.var_byte_c == 25 || this.var_byte_c == 26) {
            this.var_boolean_j = true;
        }
        if (this.var_byte_c == 22) {
            for (n = 0; n < 6; ++n) {
                if (n == 0) {
                    this.l11lIIl1l1I[n] = DataUtils.b(20, GameCanvas.var_int_b / 3);
                    this.l1IIIII1[n] = DataUtils.b(this.var_int_h - 44, this.var_int_h);
                    continue;
                }
                this.l11lIIl1l1I[n] = this.l11lIIl1l1I[n - 1] + 25 + DataUtils.b(0, GameHelper34.var_int_a / 3 - 20);
                this.l1IIIII1[n] = DataUtils.b(this.var_int_h - 44, this.var_int_h);
            }
        }
        if (this.var_byte_c == 23) {
            new ChatScreen(this.var_int_g, this.var_int_II11lIII, 1);
        }
        if (this.var_byte_c == 25 || this.var_byte_c == 26) {
            new ChatScreen(this.var_int_g, this.var_int_h, 1);
        }
    }

    private void lI1Il1ll1l(Graphics graphics, int n) {
        if (this.var_byte_f != 5 && this.var_int_w > 0) {
            graphics.setColor(0xFFFFFF);
            graphics.fillRect(this.var_int_g - 15 + this.lIll1111, this.var_int_h + 5 - n + this.lI1IlI1l, 25, 4);
            if (this.var_int_L > 16) {
                graphics.setColor(65280);
            } else if (this.var_int_L > 8) {
                graphics.setColor(16744512);
            } else {
                graphics.setColor(0xFF0000);
            }
            if (this.var_int_L > 25) {
                this.var_int_L = 25;
            }
            graphics.fillRect(this.var_int_g - 15 + this.lIll1111, this.var_int_h + 5 - n + this.lI1IlI1l, this.var_int_L, 4);
            graphics.setColor(0);
            graphics.drawRect(this.var_int_g - 15 + this.lIll1111, this.var_int_h + 5 - n + this.lI1IlI1l, 25, 4);
            FontRenderer.i.a(graphics, "HP: " + this.var_int_w + "/" + this.var_int_x, this.var_int_g, this.var_int_h + 5 - n - 23, 2);
        }
    }

    private void I1l1III1(Graphics graphics, int n) {
        DataUtils.a(graphics, n != 0 ? PlayerEntity.var_javax_microedition_lcdui_Image_p : PlayerEntity.var_javax_microedition_lcdui_Image_o, 0, this.l1lIIl1111l << 5, 35, 32, this.var_int_t, this.var_int_g, this.var_int_h, 33);
    }

    public final void a(Graphics graphics) {
        if (this.var_boolean_g) {
            if (this.var_byte_c == 13) {
                int n;
                if (this.var_int_t == 2) {
                    n = 0;
                    if (this.var_int_s == 1) {
                        this.l11lIIIII1 = 15;
                        this.lIIlllIl = 0;
                    }
                    if (this.var_int_s == 2) {
                        this.l11lIIIII1 = 15;
                        this.lIIlllIl = -5;
                    }
                    if (this.var_int_s == 3) {
                        this.l11lIIIII1 = 7;
                        this.lIIlllIl = -12;
                    }
                    this.IIIll11ll1I1 = 4;
                } else {
                    n = 2;
                    if (this.var_int_s == 1) {
                        this.l11lIIIII1 = -15;
                        this.lIIlllIl = 0;
                    }
                    if (this.var_int_s == 2) {
                        this.l11lIIIII1 = -15;
                        this.lIIlllIl = -5;
                    }
                    if (this.var_int_s == 3) {
                        this.l11lIIIII1 = -7;
                        this.lIIlllIl = -12;
                    }
                    this.IIIll11ll1I1 = -4;
                }
                if (this.var_int_t == 0) {
                    this.var_int_H = -this.var_int_H;
                }
                int n2 = this.var_int_g - this.IIIll11ll1I1 + (this.var_int_s != 1 && this.var_int_s != 2 ? 0 : this.var_int_H);
                int n3 = this.var_int_h - 10 + this.lIlIIIIIl + (this.var_int_s != 2 && this.var_int_s != 3 ? 0 : this.var_int_I);
                int n4 = this.var_int_g + this.l11lIIIII1 + (this.var_int_s != 1 && this.var_int_s != 2 ? 0 : this.var_int_H);
                int n5 = this.var_int_h - 15 + this.lIlIIIIIl + this.lIIlllIl + (this.var_int_s != 2 && this.var_int_s != 3 ? 0 : this.var_int_I);
                DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_v, 0, 30 * this.var_int_e, 42, 30, n, n2, n3, 33);
                DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_w, 0, 25 * this.var_int_f, 44, 25, n, this.var_int_g, this.var_int_h, 33);
                if (this.var_int_s == 0 || this.var_int_s == 6) {
                    this.var_int_s = 1;
                }
                // kep frame sung vao so frame that cua bug_gun.png
                int n6 = this.var_game_GameHelper29_a.a;
                if (n6 > 0) {
                    this.var_int_s = (this.var_int_s % n6 + n6) % n6;
                }
                this.var_game_GameHelper29_a.a(this.var_int_s, n4, n5, this.var_int_t, 33, graphics);
                this.lI1Il1ll1l(graphics, 50);
                this.b(graphics);
                return;
            }
            if (this.var_byte_c == 15) {
                if (this.var_byte_f == 5) {
                    graphics.drawImage(PlayerEntity.var_javax_microedition_lcdui_Image_e, this.var_int_g, this.var_int_h, 33);
                } else {
                    if (this.var_int_s > 3) {
                        this.var_int_s = 1;
                    }
                    graphics.drawImage(PlayerEntity.var_javax_microedition_lcdui_Image_c, this.var_int_g, this.var_int_h, 33);
                    byte by = (byte)(this.var_int_s == 3 ? 33 : 3);
                    this.l11lIIIII1 = this.var_int_s != 2 && this.var_int_s != 3 ? -20 : -15;
                    this.var_game_GameHelper29_a.a(this.var_int_s, this.var_int_g + this.l11lIIIII1, this.var_int_h - 22 + this.lIlIIIIIl, 0, (int)by, graphics);
                    graphics.drawImage(PlayerEntity.var_javax_microedition_lcdui_Image_d, this.var_int_g - 1, this.var_int_h - 10 + this.lIlIIIIIl, 33);
                    this.var_game_GameHelper29_a.a(this.var_int_s, this.var_int_g, this.var_int_h - 20 + this.lIlIIIIIl, 0, (int)by, graphics);
                    if (this.var_int_I != 0) {
                        ++this.Il1llI1I1l;
                        if (this.Il1llI1I1l == 10) {
                            this.Il1llI1I1l = 0;
                        }
                        this.lI1I1II1I1 = this.Il1llI1I1l <= 5 ? 0 : 1;
                        DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_q, 0, 10 * this.lI1I1II1I1, 5, 10, 0, this.var_int_g - 10, this.var_int_h, 17);
                        DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_q, 0, 10 * this.lI1I1II1I1, 5, 10, 0, this.var_int_g + 10, this.var_int_h, 17);
                        DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_q, 0, 10 * this.lI1I1II1I1, 5, 10, 0, this.var_int_g - 15, this.var_int_h, 17);
                        DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_q, 0, 10 * this.lI1I1II1I1, 5, 10, 0, this.var_int_g + 15, this.var_int_h, 17);
                    }
                }
                this.lI1Il1ll1l(graphics, 60);
                this.b(graphics);
                return;
            }
            if (this.var_byte_c == 16) {
                if (this.var_byte_f == 8) {
                    DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_r, 0, 46, 51, 46, 0, this.var_int_g + this.lIll1111, this.var_int_h + this.lI1IlI1l, 33);
                } else if (this.var_byte_f == 5) {
                    DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_r, 0, 92, 51, 46, 0, this.var_int_g + this.lIll1111, this.var_int_h + this.lI1IlI1l, 33);
                } else {
                    DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_r, 0, 0, 51, 46, 0, this.var_int_g + this.lIll1111, this.var_int_h + this.lI1IlI1l, 33);
                }
                if (this.var_byte_f != 5) {
                    if (GameCanvas.var_int_a % 3 == 0) {
                        DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_s, 0, 0, 16, 11, 0, this.var_int_g + this.lIll1111, this.var_int_h + this.lI1IlI1l - 5, 17);
                    } else {
                        DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_s, 0, 11, 16, 11, 0, this.var_int_g + this.lIll1111, this.var_int_h + this.lI1IlI1l - 5, 17);
                    }
                    if (this.var_byte_f != 0) {
                        graphics.setColor(149905);
                        for (int i = 0; i < this.lI1l1lllIl1; ++i) {
                            if (i < this.lI1l1lllIl1 / 2 + this.lI1l1lllIl1 / 3 && i > this.lI1l1lllIl1 / 2 - this.lI1l1lllIl1 / 3) {
                                graphics.setColor(0xFFFFFF);
                            } else {
                                graphics.setColor(0x59BBBB);
                            }
                            graphics.drawLine(this.var_int_g - this.lI1l1lllIl1 / 2 + i + this.lIll1111, this.var_int_h + this.lI1IlI1l, this.var_int_g - this.lI1l1lllIl1 / 2 + i + this.lIll1111, this.var_int_D);
                        }
                        if (this.lI1l1lllIl1 == 0) {
                            this.var_boolean_lI1II1lII = true;
                        }
                        if (this.lI1l1lllIl1 == 8) {
                            this.var_boolean_lI1II1lII = false;
                        }
                        if (GameCanvas.var_int_a % 2 == 0) {
                            this.lI1l1lllIl1 = !this.var_boolean_lI1II1lII ? --this.lI1l1lllIl1 : ++this.lI1l1lllIl1;
                        }
                    }
                }
                this.lI1Il1ll1l(graphics, 55);
                this.b(graphics);
                return;
            }
            if (this.var_byte_c == 17) {
                graphics.drawImage(PlayerEntity.var_javax_microedition_lcdui_Image_f, this.var_int_g, this.var_int_h + var_int_l1I1I1ll, 33);
                DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_i, 0, this.var_int_I11llIIIII * 23, 4, 23, 0, this.var_int_g - 8, this.var_int_h - 18 + var_int_l1I1I1ll, 33);
                if (this.var_int_I11llIIIII == 0) {
                    this.var_int_I11llIIIII = 1;
                } else if (this.var_int_I11llIIIII == 1) {
                    this.var_int_I11llIIIII = 0;
                }
                if (GameCanvas.var_int_a % 2 == 0) {
                    graphics.drawImage(PlayerEntity.var_javax_microedition_lcdui_Image_j, this.var_int_g + 10, this.var_int_h - 35 + var_int_l1I1I1ll, 33);
                    graphics.drawImage(PlayerEntity.var_javax_microedition_lcdui_Image_j, this.var_int_g + 34, this.var_int_h - 35 + var_int_l1I1I1ll, 33);
                }
                graphics.drawImage(PlayerEntity.var_javax_microedition_lcdui_Image_m, this.var_int_g - 5, this.var_int_h - 43 + var_int_l1I1I1ll, 33);
                DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_i, 0, this.var_int_I11llIIIII * 23, 4, 23, 0, this.var_int_g, this.var_int_h - 46 + var_int_l1I1I1ll, 33);
                int[] nArray = new int[]{this.var_int_g, this.var_int_g - 30, this.var_int_g + 20};
                int[] nArray2 = new int[]{this.var_int_h - 20, this.var_int_h - 35, this.var_int_h - 25};
                if (this.var_byte_f == 5) {
                    for (int i = 0; i < 3; ++i) {
                        DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_n, 0, i * 12, 14, 12, 0, nArray[i], nArray2[i] + var_int_l1I1I1ll, 0);
                    }
                }
                return;
            }
            if (this.var_byte_c == 18) {
                if (var_int_a <= this.var_int_g + 50 && var_int_a >= this.var_int_g - 50) {
                    this.var_int_s = 1;
                } else if (var_int_a > this.var_int_g + 50) {
                    this.var_int_s = 0;
                    this.var_int_t = 0;
                } else if (var_int_a < this.var_int_g - 50) {
                    this.var_int_s = 0;
                    this.var_int_t = 2;
                }
                if (this.var_int_s > 1) {
                    this.var_int_s = 0;
                }
                int n = this.var_byte_f != 5 ? var_int_l1I1I1ll : 0;
                graphics.drawImage(PlayerEntity.var_javax_microedition_lcdui_Image_g, this.var_int_g, this.var_int_h - 7 + n, 33);
                this.var_game_GameHelper29_a.a(this.var_int_s, this.var_int_g + 2, this.var_int_h + n - 7, this.var_int_t, 3, graphics);
                this.lI1Il1ll1l(graphics, -7);
                this.b(graphics);
                return;
            }
            if (this.var_byte_c == 21) {
                if (this.var_byte_f == 5) {
                    this.var_game_GameHelper29_a.a(2, this.var_int_g + 2, this.var_int_h + var_int_l1I1I1ll - 1, 0, 33, graphics);
                } else if (GameCanvas.var_int_a % 2 == 0) {
                    this.var_game_GameHelper29_a.a(0, this.var_int_g + 2, this.var_int_h + var_int_l1I1I1ll - 1, 0, 33, graphics);
                } else {
                    this.var_game_GameHelper29_a.a(1, this.var_int_g + 2, this.var_int_h + var_int_l1I1I1ll - 1, 0, 33, graphics);
                }
                this.lI1Il1ll1l(graphics, 15);
                this.b(graphics);
                return;
            }
            if (this.var_byte_c == 19) {
                int n = this.var_byte_f != 5 ? var_int_l1I1I1ll : 0;
                graphics.drawImage(PlayerEntity.var_javax_microedition_lcdui_Image_k, this.var_int_g, this.var_int_h + n, 33);
                this.lI1Il1ll1l(graphics, -7);
                this.b(graphics);
                return;
            }
            if (this.var_byte_c == 20) {
                int n = this.var_byte_f != 5 ? var_int_l1I1I1ll : 0;
                graphics.drawImage(PlayerEntity.var_javax_microedition_lcdui_Image_l, this.var_int_g, this.var_int_h + n, 33);
                this.lI1Il1ll1l(graphics, 30);
                this.b(graphics);
                return;
            }
            if (this.var_byte_c == 22) {
                int n;
                graphics.setColor(0x7A7A7A);
                for (n = 0; n < 3; ++n) {
                    graphics.drawLine(0, this.var_int_B + n * 22 - 44, GameHelper34.var_int_a, this.var_int_B + n * 22 - 44);
                }
                for (n = 0; n < 3; ++n) {
                    graphics.drawImage(PlayerEntity.var_javax_microedition_lcdui_Image_u, this.l11lIIl1l1I[n], this.l1IIIII1[n], 3);
                }
                if (this.var_int_v == 0) {
                    DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_t, 0, this.var_int_u * 22, 41, 22, 1, this.var_int_g + 1, this.var_int_h, 33);
                    DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_t, 0, this.var_int_u * 22, 41, 22, 0, this.var_int_g, this.var_int_h - 22, 33);
                }
                if (this.var_int_v == 1) {
                    DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_t, 0, this.var_int_u * 22, 41, 22, 3, this.var_int_g, this.var_int_h, 33);
                    DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_t, 0, this.var_int_u * 22, 41, 22, 2, this.var_int_g, this.var_int_h - 22, 33);
                }
                if (this.var_int_v == 2) {
                    DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_t, 0, this.var_int_u * 22, 41, 22, 4, this.var_int_g, this.var_int_h, 40);
                    DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_t, 0, this.var_int_u * 22, 41, 22, 5, this.var_int_g + 22, this.var_int_h, 40);
                }
                if (this.var_int_v == 3) {
                    DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_t, 0, this.var_int_u * 22, 41, 22, 6, this.var_int_g, this.var_int_h, 40);
                    DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_t, 0, this.var_int_u * 22, 41, 22, 7, this.var_int_g + 22, this.var_int_h, 40);
                }
                if (this.var_int_D != 0) {
                    graphics.setColor(0x525252);
                    graphics.fillRect(this.var_int_A, this.var_int_B - 41, 1, this.var_int_h - this.var_int_B);
                }
                this.lI1Il1ll1l(graphics, 48);
                this.b(graphics);
                return;
            }
            if (this.var_byte_c == 14 && (this.var_boolean_h || this.var_boolean_i)) {
                ++this.Il1llI1I1l;
                if (this.Il1llI1I1l == 10) {
                    this.Il1llI1I1l = 0;
                }
                this.lI1I1II1I1 = this.Il1llI1I1l <= 5 ? 0 : 1;
                DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_q, 0, 10 * this.lI1I1II1I1, 5, 10, 0, this.var_int_g - 5, this.var_int_h + 2, 17);
                DataUtils.a(graphics, PlayerEntity.var_javax_microedition_lcdui_Image_q, 0, 10 * this.lI1I1II1I1, 5, 10, 0, this.var_int_g + 5, this.var_int_h + 2, 17);
            }
            if (this.var_byte_c == 25) {
                this.I1l1III1(graphics, 0);
                this.lI1Il1ll1l(graphics, 40);
                this.b(graphics);
                return;
            }
            if (this.var_byte_c == 26) {
                this.I1l1III1(graphics, 1);
                this.lI1Il1ll1l(graphics, 40);
                this.b(graphics);
                return;
            }
            if (this.var_byte_c == 23) {
                if (this.var_byte_f != 5 && this.var_int_w > 0) {
                    if (this.var_boolean_a) {
                        this.lI1Il1ll1l(graphics, this.var_int_g, this.var_int_II11lIII);
                        return;
                    }
                    graphics.drawImage(var_javax_microedition_lcdui_Image_a, this.var_int_g, this.var_int_II11lIII, 33);
                    return;
                }
            } else if (this.var_byte_c == 24) {
                if (this.var_byte_f != 5) {
                    ++this.var_int_lI1II1lII;
                    if (this.var_int_lI1II1lII == 10) {
                        this.var_int_lI1II1lII = 0;
                    }
                    this.var_int_I1llIlIlI = this.var_int_lI1II1lII < 5 ? 0 : 1;
                    if (this.var_boolean_a) {
                        this.lI1Il1ll1l(graphics, this.var_int_g, this.var_int_Ill1I11I - 8);
                    } else {
                        graphics.drawImage(I1I1IlI111I, this.var_int_g, this.var_int_Ill1I11I - 8, 33);
                    }
                    DataUtils.a(graphics, lIlllI1I, 0, this.var_int_I1llIlIlI * 35, 35, 35, 0, this.var_int_g, this.var_int_Ill1I11I, 33);
                    return;
                }
            } else {
                super.a(graphics);
            }
        }
    }

    private void lI1Il1ll1l(Graphics graphics, int n, int n2) {
        if (this.var_boolean_a) {
            if (this.var_byte_a == 0) {
                GameHelper31.a(graphics, this.c, n, n2, 33);
                return;
            }
            if (this.var_byte_a == 1) {
                if (this.llIlI1l11111 == null) {
                    if (GameHelper37.boolean_a(this.c)) {
                        this.llIlI1l11111 = GameHelper37.javax_microedition_lcdui_Image_a(this.c);
                    } else if (!this.var_boolean_l1I1I1ll) {
                        ConnectionWatchdog.game_ConnectionWatchdog_a().a((byte)0, (short)this.c, (byte)-1);
                        this.var_boolean_l1I1I1ll = true;
                    }
                }
                graphics.drawImage(this.llIlI1l11111, n, n2, 33);
                return;
            }
            if (this.var_byte_a == 2) {
                if (EquipScreen.var_javax_microedition_lcdui_Image_arr_a != null && EquipScreen.var_javax_microedition_lcdui_Image_arr_a.length > 0 && EquipScreen.var_javax_microedition_lcdui_Image_arr_a[0] != null) {
                    int n3 = EquipScreen.var_javax_microedition_lcdui_Image_arr_a[0].getWidth();
                    n3 = this.c * n3;
                    int n4 = n3 / 1024;
                    if (n4 < EquipScreen.var_javax_microedition_lcdui_Image_arr_a.length && EquipScreen.var_javax_microedition_lcdui_Image_arr_a[n4] != null) {
                        DataUtils.a(graphics, EquipScreen.var_javax_microedition_lcdui_Image_arr_a[n4], 0, n3 %= 1024, 16, 16, 0, n, n2, 33);
                    }
                }
            }
        }
    }

    private void I1I1Ill1() {
        ++this.llIlI11Ill;
        if (this.llIlI11Ill == 10) {
            this.llIlI11Ill = 0;
        }
        if (this.llIlI11Ill < 5) {
            this.var_int_s = 1;
            return;
        }
        this.var_int_s = 2;
    }

    /*
     * Unable to fully structure code
     */
    public final void a() {
        super.a();
        switch (this.var_byte_c) {
            case 11: 
            case 12: {
                if (this.var_byte_f == 5) {
                    this.var_int_s = 3;
                    return;
                }
                if (this.var_boolean_B && !this.var_boolean_m) {
                    if (this.var_int_y < this.var_int_g && !this.var_boolean_n) {
                        this.a(false);
                        this.I1I1Ill1();
                        return;
                    }
                    if (this.var_int_y > this.var_int_g && !this.var_boolean_n) {
                        this.a(true);
                        this.I1I1Ill1();
                        return;
                    }
                    if (this.var_int_y == this.var_int_g && this.var_int_z != this.var_int_h && this.var_byte_f == 0 && !this.var_boolean_n) {
                        this.var_int_h = this.var_int_z;
                    }
                }
                if (this.var_boolean_d) {
                    if (this.var_byte_c == 12) {
                        this.IIlII1I11 = true;
                    }
                } else {
                    this.IIlII1I11 = false;
                }
                if (this.IIlII1I11) {
                    this.var_int_s = 4;
                    return;
                }
                ++this.llIlI11Ill;
                if (this.llIlI11Ill == 10) {
                    this.llIlI11Ill = 0;
                }
                if (this.llIlI11Ill < 5) {
                    this.var_int_s = 0;
                    return;
                }
                this.var_int_s = 1;
                return;
            }
            case 13: {
                if (this.var_byte_f == 5) {
                    this.var_int_f = 2;
                    this.var_int_e = 1;
                    this.var_int_s = 0;
                    return;
                }
                if (this.var_int_H < 0) {
                    this.var_int_H += 2;
                }
                if (this.var_int_H > 0) {
                    this.var_int_H = 0;
                }
                if (this.var_int_I > 0) {
                    --this.var_int_I;
                }
                if (this.var_int_I < 0) {
                    this.var_int_I = 0;
                }
                if (this.var_byte_f != 4) {
                    ++this.IIlIlI1III;
                    if (this.IIlIlI1III == 10) {
                        this.IIlIlI1III = 0;
                    }
                    if (this.IIlIlI1III == 5) {
                        this.lIlIIIIIl = 1;
                    }
                    if (this.IIlIlI1III == 0) {
                        this.lIlIIIIIl = 0;
                    }
                }
                if (this.var_byte_f == 4) {
                    this.IIlIlI1III = 0;
                    this.lIlIIIIIl = 0;
                }
                if (this.var_int_f == 0) break;
                if (this.var_int_g < this.var_int_d) {
                    this.var_int_t = 2;
                    return;
                }
                this.var_int_t = 0;
                return;
            }
            case 14: {
                if (!this.var_boolean_i) break;
                this.var_int_h -= this.II1II1lII;
                --this.II1II1lII;
                if (this.II1II1lII != 0) break;
                this.var_boolean_i = false;
                this.II1II1lII = 18;
                this.var_boolean_n = true;
                return;
            }
            case 15: {
                if (this.var_byte_f != 4) {
                    ++this.IIlIlI1III;
                    if (this.IIlIlI1III == 10) {
                        this.IIlIlI1III = 0;
                    }
                    if (this.IIlIlI1III == 5) {
                        this.lIlIIIIIl = 1;
                    }
                    if (this.IIlIlI1III == 0) {
                        this.lIlIIIIIl = 0;
                    }
                }
                if (this.var_boolean_i) {
                    this.var_int_h -= this.II1II1lII;
                    --this.II1II1lII;
                    if (this.II1II1lII == 0) {
                        this.var_boolean_n = true;
                    }
                }
                if (this.var_boolean_i) {
                    if (GameHelper34.a(this.var_int_g, this.var_int_h)) {
                        this.var_boolean_k = true;
                        this.II1II1lII = 18;
                        this.var_boolean_i = false;
                    }
                }
                if (!this.var_boolean_k) break;
                this.var_boolean_k = false;
                for (int var1_1 = 0; var1_1 < 4; ++var1_1) {
                    BattleScreen.var_game_BattleGraphicHelper_a.a(this.var_int_g - var1_1 * 20, this.var_int_h, DataUtils.d(4 + this.var_byte_d / 3), DataUtils.b(-8 - this.var_byte_d / 3, -5 - this.var_byte_d / 3), (byte)3);
                    BattleScreen.var_game_BattleGraphicHelper_a.a(this.var_int_g + var1_1 * 20, this.var_int_h, DataUtils.d(4 + this.var_byte_d / 3), DataUtils.b(-8 - this.var_byte_d / 3, -5 - this.var_byte_d / 3), (byte)3);
                }
                GameHelper16.var_int_a = 3;
                return;
            }
            case 16: {
                if (this.var_boolean_E) {
                    this.b(10);
                    return;
                }
                if (this.var_byte_f != 4 && this.var_byte_f != 5) {
                    if (GameCanvas.var_int_a % 2 != 0) break;
                    ++this.Il1Il111I1;
                    if (this.Il1Il111I1 == 20) {
                        this.Il1Il111I1 = 0;
                    }
                    this.lIll1111 = this.Il1Il111I1 < 10 ? ++this.lIll1111 : --this.lIll1111;
                    ++this.I11I1Il11I;
                    if (this.I11I1Il11I == 10) {
                        this.I11I1Il11I = 0;
                    }
                    if (this.I11I1Il11I < 5) {
                        --this.lI1IlI1l;
                        return;
                    }
                    ++this.lI1IlI1l;
                    return;
                }
                this.lIll1111 = 0;
                this.lI1IlI1l = 0;
                return;
            }
            case 17: {
                if (this.var_byte_f == 5) {
                    ++this.var_int_h;
                    this.var_boolean_n = false;
                    if (GameCanvas.var_int_a % 5 == 0) {
                        new ChatScreen(DataUtils.b(this.var_int_g - 50, this.var_int_g + 50), DataUtils.b(this.var_int_h - 40, this.var_int_h), 0);
                    }
                }
                if (this.var_boolean_E) {
                    this.b(10);
                    PopupDialog.var_int_l1I1I1ll = 0;
                    if (this.var_byte_g == 43) {
                        BattleScreen.var_game_GameHelper16_a.a(this.var_int_g, this.var_int_h + (PopupDialog.b = (short)(PopupDialog.b + 2)));
                    }
                } else {
                    PopupDialog.b = (short)0;
                    PopupDialog.var_int_l1I1I1ll = BattleManager.d;
                }
                for (int var1_2 = 0; var1_2 < BattleManager.var_game_PlayerEntity_arr_a.length; ++var1_2) {
                    if (BattleManager.var_game_PlayerEntity_arr_a[var1_2] == null) continue;
                    if (BattleManager.var_game_PlayerEntity_arr_a[var1_2].var_byte_f != 5) {
                        if (BattleManager.var_game_PlayerEntity_arr_a[var1_2].var_byte_c == 18) {
                            BattleManager.var_game_PlayerEntity_arr_a[var1_2].var_int_g = this.var_int_g + 51;
                            BattleManager.var_game_PlayerEntity_arr_a[var1_2].var_int_h = this.var_int_h + 10;
                        }
                        if (BattleManager.var_game_PlayerEntity_arr_a[var1_2].var_byte_c == 19) {
                            BattleManager.var_game_PlayerEntity_arr_a[var1_2].var_int_g = this.var_int_g - 10;
                            BattleManager.var_game_PlayerEntity_arr_a[var1_2].var_int_h = this.var_int_h + 30;
                        }
                        if (BattleManager.var_game_PlayerEntity_arr_a[var1_2].var_byte_c == 20) {
                            BattleManager.var_game_PlayerEntity_arr_a[var1_2].var_int_g = this.var_int_g - 60;
                            BattleManager.var_game_PlayerEntity_arr_a[var1_2].var_int_h = this.var_int_h - 13;
                        }
                    }
                    if (BattleManager.var_game_PlayerEntity_arr_a[var1_2].var_byte_c != 21) continue;
                    BattleManager.var_game_PlayerEntity_arr_a[var1_2].var_int_g = this.var_int_g + 53;
                    BattleManager.var_game_PlayerEntity_arr_a[var1_2].var_int_h = this.var_int_h - 24;
                }
                return;
            }
            default: {
                return;
            }
                        case 22: {
                this.var_byte_j = (byte)5;
                if (this.var_boolean_E) {
                    ++this.llIlI11Ill;
                    if (this.llIlI11Ill == 4) {
                        this.llIlI11Ill = 0;
                    }
                    if (this.llIlI11Ill >= 2) {
                        this.var_int_u = 1;
                    } else {
                        this.var_int_u = 0;
                    }
                } else {
                    if (this.var_byte_f == 5) {
                        this.var_int_u = 3;
                    } else if (this.var_byte_f == 8) {
                        this.var_int_u = 2;
                    } else {
                        this.var_int_u = 0;
                    }
                }
                if (this.var_boolean_E) {
                    this.b(8);
                }
                if (!this.var_boolean_D) break;
                this.c();
                return;
            }
            case 23: {
                if (BoardScreen.var_byte_b == 7 && GameHelper01.a) {
                    this.var_int_II11lIII = this.var_int_h;
                    this.var_boolean_II11lIII = true;
                    Object var1_3 = GameHelper01.b;
                    synchronized (var1_3) {
                        GameHelper01.b.notify();
                    }
                }
                if (!this.var_boolean_II11lIII) {
                    ++this.var_int_Ill1III11l;
                    this.var_int_II11lIII += this.var_int_Ill1III11l;
                    BattleScreen.var_game_GameHelper16_a.a(this.var_int_g, this.var_int_II11lIII);
                    if (this.var_int_II11lIII > this.var_int_h) {
                        this.var_boolean_II11lIII = true;
                        this.var_int_II11lIII = this.var_int_h;
                        TurnTimer var1_3 = BattleScreen.var_game_TurnTimer_a; var1_3.a += 2;
                        GameCanvas.j = 0;
                        GameCanvas.var_boolean_e = true;
                    }
                }
                if (this.var_byte_f != 5 || this.var_boolean_I11llIIIII) break;
                this.var_boolean_I11llIIIII = true;
                new ChatScreen(this.var_int_g, this.var_int_h, 1);
                return;
            }
            case 24: {
                if (BoardScreen.var_byte_b == 7 && GameHelper01.a) {
                    this.var_int_Ill1I11I = this.var_int_h;
                    this.var_boolean_Ill1I11I = true;
                    Object var1_4 = GameHelper01.b;
                    synchronized (var1_4) {
                        GameHelper01.b.notify();
                    }
                }
                if (!this.var_boolean_Ill1I11I) {
                    this.var_int_Ill1I11I -= 9;
                    BattleScreen.var_game_GameHelper16_a.a(this.var_int_g, this.var_int_Ill1I11I);
                    if (this.var_int_Ill1I11I < this.var_int_h) {
                        this.var_boolean_Ill1I11I = true;
                        this.var_int_Ill1I11I = this.var_int_h;
                        TurnTimer var1_4 = BattleScreen.var_game_TurnTimer_a; var1_4.a += 2;
                        GameCanvas.j = 0;
                        GameCanvas.var_boolean_e = true;
                    }
                } else {
                    if (this.var_boolean_Ill1III11l) {
                        --this.var_int_Ill1I11I;
                    }
                    if (this.var_boolean_I1llIlIlI) {
                        ++this.var_int_Ill1I11I;
                    }
                    if (this.var_int_Ill1I11I < this.var_int_h - 3) {
                        this.var_boolean_I1llIlIlI = true;
                        this.var_boolean_Ill1III11l = false;
                    }
                    if (this.var_int_Ill1I11I > this.var_int_h + 3) {
                        this.var_boolean_I1llIlIlI = false;
                        this.var_boolean_Ill1III11l = true;
                    }
                }
                if (this.var_byte_f != 5 || this.var_boolean_I11llIIIII) break;
                this.var_boolean_I11llIIIII = true;
                new ChatScreen(this.var_int_g, this.var_int_h, 1);
                return;
            }
            case 25: 
            case 26: {
                if (!this.var_boolean_l) {
                    ++this.IIIl1I1I;
                    if (this.IIIl1I1I == 10) {
                        this.IIIl1I1I = 0;
                    }
                    this.l1lIIl1111l = this.IIIl1I1I < 5 ? 0 : 1;
                    this.I11IlI1I1I1 = 0;
                } else {
                    ++this.I11IlI1I1I1;
                    if (this.I11IlI1I1I1 == 5) {
                        this.l1lIIl1111l = 2;
                    }
                    if (this.I11IlI1I1I1 == 10) {
                        this.l1lIIl1111l = 3;
                        BattleManager.var_game_PlayerEntity_arr_a[this.var_int_C].e(this.var_int_t != 2 ? 2 : 0);
                        BattleScreen.var_game_BattleGraphicHelper_a.a(BattleManager.var_game_PlayerEntity_arr_a[this.var_int_C].var_int_g, BattleManager.var_game_PlayerEntity_arr_a[this.var_int_C].var_int_h, (byte)22);
                    }
                    if (this.I11IlI1I1I1 == 18) {
                        this.var_boolean_l = false;
                        Object var1_5 = GameHelper01.b;
                        synchronized (var1_5) {
                            GameHelper01.b.notify();
                        }
                    }
                }
                if (!this.var_boolean_E) break;
                this.b(10);
                return;
            }
        }
    }

    static {
        try {
            var_javax_microedition_lcdui_Image_a = Image.createImage((String)"/item/box.png");
            lIlllI1I = Image.createImage((String)"/item/bongbong.png");
            I1I1IlI111I = Image.createImage((String)"/item/box2.png");
        }
        catch (Exception iOException) {
            Exception iOException2 = iOException;
            iOException.printStackTrace();
        }
    }
}

