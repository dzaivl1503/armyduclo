/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Image
 */
package game;

import game.BattleScreen;
import game.GameCanvas;
import game.IServerListener;
import game.Message;
import game.PlayerEntity;
import game.ServerManager;
import game.ShopScreen;
import javax.microedition.lcdui.Image;

public final class ConnectionWatchdog {
    private IServerListener var_game_IServerListener_l11llllI;
    private static ConnectionWatchdog var_game_ConnectionWatchdog_l11llllI;

    public final void a(IServerListener iServerListener) {
        this.var_game_IServerListener_l11llllI = iServerListener;
    }

    public static ConnectionWatchdog game_ConnectionWatchdog_a() {
        if (var_game_ConnectionWatchdog_l11llllI == null) {
            var_game_ConnectionWatchdog_l11llllI = new ConnectionWatchdog();
        }
        return var_game_ConnectionWatchdog_l11llllI;
    }

    public final void a(String string, String string2, String string3) {
        Message message = new Message(1);
        try {
            message.java_io_DataOutputStream_a().writeUTF(string);
            message.java_io_DataOutputStream_a().writeUTF(string2);
            message.java_io_DataOutputStream_a().writeUTF(string3);
            this.var_game_IServerListener_l11llllI.a(message);
            message.void_a();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public final void void_a() {
        Message message = new Message(6);
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    /** Xin server gui danh sach pet + 3 slot trang bi pet. */
    public final void sendPetRequest() {
        Message message = new Message(PetManager.CMD_PET_INFO);
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    /** Xin danh sach vip + anh huy hieu. */
    public final void sendVipRequest() {
        Message message = new Message(VipManager.CMD_VIP_INFO);
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    /** Gan pet vao slot trang bi (-1 = bo pet khoi slot). */
    public final void sendPetSlot(byte by, short s) {
        Message message = new Message(PetManager.CMD_PET_EQUIP);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            message.java_io_DataOutputStream_a().writeShort(s);
        }
        catch (Exception exception) {
            // bo qua
        }
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    /** Dung trang bi pet: itemId, petId (-1 = thao ra). */
    public final void sendPetItemUse(short itemId, short petId) {
        Message message = new Message(PetManager.CMD_PET_ITEM_USE);
        try {
            message.java_io_DataOutputStream_a().writeShort(itemId);
            message.java_io_DataOutputStream_a().writeShort(petId);
        }
        catch (Exception exception) {
            // bo qua
        }
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void a(byte by) {
        Message message = new Message(7);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void a(byte by, byte by2, String string) {
        Message message = new Message(8);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            message.java_io_DataOutputStream_a().writeByte(by2);
            message.java_io_DataOutputStream_a().writeUTF(string);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void a(String string) {
        Message message = new Message(54);
        try {
            message.java_io_DataOutputStream_a().writeUTF(string);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void b() {
        Message message = new Message(15);
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void a(boolean bl) {
        Message message = new Message(16);
        try {
            message.java_io_DataOutputStream_a().writeBoolean(bl);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void a(int n) {
        Message message = new Message(19);
        try {
            message.java_io_DataOutputStream_a().writeInt(n);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void b(String string) {
        Message message = new Message(18);
        try {
            message.java_io_DataOutputStream_a().writeUTF(string);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void c(String string) {
        Message message = new Message(9);
        try {
            message.java_io_DataOutputStream_a().writeUTF(string);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void b(int n) {
        Message message = new Message(11);
        try {
            message.java_io_DataOutputStream_a().writeInt(n);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void b(byte by) {
        Message message = new Message(28);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void c(int n) {
        Message message = new Message(30);
        try {
            message.java_io_DataOutputStream_a().writeByte(n);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void a(String string, String string2) {
        Message message = new Message(121);
        try {
            message.java_io_DataOutputStream_a().writeUTF(string);
            message.java_io_DataOutputStream_a().writeUTF(string2);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void c() {
        Message message = new Message(29);
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void d(String string) {
        Message message = new Message(36);
        try {
            message.java_io_DataOutputStream_a().writeUTF(string);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void d(int n) {
        Message message = new Message(32);
        try {
            message.java_io_DataOutputStream_a().writeInt(n);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void e(int n) {
        Message message = new Message(33);
        try {
            message.java_io_DataOutputStream_a().writeInt(n);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void a(int n, String string) {
        Message message = new Message(5);
        try {
            message.java_io_DataOutputStream_a().writeInt(n);
            message.java_io_DataOutputStream_a().writeUTF(string);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void d() {
        Message message = new Message(42);
        try {
            message.java_io_DataOutputStream_a().writeInt(0);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void c(byte by) {
        Message message = new Message(58);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void a(byte by, String string) {
        Message message = new Message(122);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            if (by == 1) {
                message.java_io_DataOutputStream_a().writeUTF(string);
            }
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void d(byte by) {
        Message message = new Message(83);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void b(String string, String string2, String string3) {
        Message message = new Message(77);
        try {
            message.java_io_DataOutputStream_a().writeUTF(string);
            message.java_io_DataOutputStream_a().writeUTF(string2);
            message.java_io_DataOutputStream_a().writeUTF(string3);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void e() {
        Message message = new Message(20);
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void e(byte by) {
        Message message = new Message(75);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void f() {
        Message message = new Message(-6);
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void a(byte n, int[] nArray, int[] nArray2) {
        Message message = new Message(79);
        try {
            message.java_io_DataOutputStream_a().writeByte(n);
            System.out.println("[bv] Remove bull id=" + n);
            for (int i = 0; i < n; ++i) {
                System.out.println("[bv] x= " + nArray[i] + " y=" + nArray2[i]);
                message.java_io_DataOutputStream_a().writeInt(nArray[i]);
                message.java_io_DataOutputStream_a().writeInt(nArray2[i]);
            }
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void a(short s, short s2) {
        if (!BattleScreen.var_boolean_f) {
            Message message = new Message(21);
            try {
                message.java_io_DataOutputStream_a().writeShort(s);
                message.java_io_DataOutputStream_a().writeShort(s2);
            }
            catch (Exception exception) {}
            this.var_game_IServerListener_l11llllI.a(message);
            message.void_a();
        }
    }

    public final void a(byte by, short s, short s2, short s3, byte by2, byte by3, byte by4) {
        Message message = new Message(84);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            message.java_io_DataOutputStream_a().writeShort(s);
            message.java_io_DataOutputStream_a().writeShort(s2);
            message.java_io_DataOutputStream_a().writeShort(s3);
            message.java_io_DataOutputStream_a().writeByte(by2);
            if (ShopScreen.b(by)) {
                message.java_io_DataOutputStream_a().writeByte(by3);
            }
            message.java_io_DataOutputStream_a().writeByte(by4);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
        new StringBuffer("[bv] SendWait_Fire bull: ").append(by).append(" nShoot: ").append(by4).append(" force2= ").append(by3);
    }

    public final void b(byte by, short s, short s2, short s3, byte by2, byte by3, byte by4) {
        Message message = new Message(22);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            message.java_io_DataOutputStream_a().writeShort(s);
            message.java_io_DataOutputStream_a().writeShort(s2);
            message.java_io_DataOutputStream_a().writeShort(s3);
            message.java_io_DataOutputStream_a().writeByte(by2);
            if (ShopScreen.b(by)) {
                message.java_io_DataOutputStream_a().writeByte(by3);
            }
            message.java_io_DataOutputStream_a().writeByte(by4);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
        new StringBuffer("[bv] SendWait_Fire bull: ").append(by).append(" nShoot: ").append(by4).append(" force2= ").append(by3).append(" X= ").append(s).append(" Y= ").append(s2);
    }

    public final void g() {
        if (!BattleScreen.var_boolean_f) {
            Message message = new Message(23);
            this.var_game_IServerListener_l11llllI.a(message);
            message.void_a();
        }
    }

    public final void b(short s, short s2) {
        if (!BattleScreen.var_boolean_f && !PlayerEntity.var_boolean_c) {
            Message message = new Message(53);
            try {
                message.java_io_DataOutputStream_a().writeShort(s);
                message.java_io_DataOutputStream_a().writeShort(s2);
            }
            catch (Exception exception) {}
            this.var_game_IServerListener_l11llllI.a(message);
            message.void_a();
        }
    }

    public final void a(boolean bl, int n) {
        Message message = new Message(78);
        try {
            message.java_io_DataOutputStream_a().writeBoolean(bl);
            message.java_io_DataOutputStream_a().writeInt(n);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void h() {
        if (!BattleScreen.var_boolean_f) {
            Message message = new Message(49);
            this.var_game_IServerListener_l11llllI.a(message);
            message.void_a();
        }
    }

    public final void f(byte by) {
        if (!BattleScreen.var_boolean_f) {
            Message message = new Message(26);
            try {
                message.java_io_DataOutputStream_a().writeByte(by);
            }
            catch (Exception exception) {}
            this.var_game_IServerListener_l11llllI.a(message);
            message.void_a();
        }
    }

    public final void a(int[] nArray) {
        int n;
        Message message = new Message(68);
        try {
            for (n = 0; n < nArray.length; ++n) {
                message.java_io_DataOutputStream_a().writeByte(nArray[n]);
            }
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
        System.out.print("[bv] SendM changeGun lent=" + nArray.length + " data=");
        for (n = 0; n < nArray.length; ++n) {
            System.out.print(" " + nArray[n] + ",");
        }
        System.out.println();
    }

    public final void g(byte by) {
        Message message = new Message(69);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void i() {
        Message message = new Message(71);
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void j() {
        Message message = new Message(-4);
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void f(int n) {
        Message message = new Message(56);
        try {
            message.java_io_DataOutputStream_a().writeByte(n);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void g(int n) {
        Message message = new Message(34);
        try {
            message.java_io_DataOutputStream_a().writeInt(n);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void b(String string, String string2) {
        Message message = new Message(81);
        try {
            message.java_io_DataOutputStream_a().writeUTF(string);
            message.java_io_DataOutputStream_a().writeUTF(string2);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void a(byte by, byte by2, int n) {
        Message message = new Message(72);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            message.java_io_DataOutputStream_a().writeByte(by2);
            message.java_io_DataOutputStream_a().writeInt(n);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void a(byte by, byte by2) {
        Message message = new Message(74);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            message.java_io_DataOutputStream_a().writeByte(by2);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void e(String string) {
        Message message = new Message(127);
        try {
            message.java_io_DataOutputStream_a().writeUTF(string);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void k() {
        Message message = new Message(-26);
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void b(byte by, byte by2) {
        Message message = new Message(90);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            message.java_io_DataOutputStream_a().writeByte(by2);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void a(short[] sArray) {
        Message message = new Message(98);
        try {
            message.java_io_DataOutputStream_a().writeShort(sArray[0]);
            message.java_io_DataOutputStream_a().writeShort(sArray[1]);
            message.java_io_DataOutputStream_a().writeShort(sArray[2]);
            message.java_io_DataOutputStream_a().writeShort(sArray[3]);
            message.java_io_DataOutputStream_a().writeShort(sArray[4]);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void b(int[] nArray) {
        Message message = new Message(102);
        try {
            for (int i = 0; i < nArray.length; ++i) {
                message.java_io_DataOutputStream_a().writeInt(nArray[i]);
                new StringBuffer("[bv] qweqwdasdsad= ").append(nArray[i]);
            }
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void l() {
        Message message = new Message(103);
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void a(byte by, int[] nArray, short s, byte by2) {
        Message message = new Message(104);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            if (by == 1) {
                message.java_io_DataOutputStream_a().writeByte(nArray.length);
                for (int i = 0; i < nArray.length; ++i) {
                    message.java_io_DataOutputStream_a().writeInt(nArray[i]);
                }
            }
            if (by == 0) {
                message.java_io_DataOutputStream_a().writeShort(s);
                message.java_io_DataOutputStream_a().writeByte(by2);
            }
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void h(byte by) {
        Message message = new Message(110);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void m() {
        Message message = new Message(99);
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void n() {
        Message message = new Message(114);
        System.out.println(System.getProperty("microedition.platform"));
        try {
            message.java_io_DataOutputStream_a().writeUTF(System.getProperty("microedition.platform"));
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void a(byte by, int n) {
        Message message = new Message(-2);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            message.java_io_DataOutputStream_a().writeInt(n);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void i(byte by) {
        Message message = new Message(116);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void a(short s) {
        if (s != 0 && s != -1) {
            if (GameCanvas.var_game_GameHelper08_a.boolean_a(s)) {
                Image image = GameCanvas.var_game_GameHelper08_a.javax_microedition_lcdui_Image_a(s);
                ServerManager.a(s, image);
                return;
            }
            Message message = new Message(115);
            try {
                message.java_io_DataOutputStream_a().writeShort(s);
            }
            catch (Exception exception) {}
            this.var_game_IServerListener_l11llllI.a(message);
        }
    }

    public final void b(short s) {
        Message message = new Message(117);
        try {
            message.java_io_DataOutputStream_a().writeShort(s);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void a(byte by, short s) {
        Message message = new Message(118);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            message.java_io_DataOutputStream_a().writeShort(s);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void j(byte by) {
        Message message = new Message(120);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void a(byte by, short s, byte by2) {
        System.out.println("[bv] get material icon " + s);
        Message message = new Message(126);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            message.java_io_DataOutputStream_a().writeShort(s);
            if (by == 3) {
                message.java_io_DataOutputStream_a().writeByte(by2);
            }
            if (by == 4) {
                message.java_io_DataOutputStream_a().writeByte(by2);
            }
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void b(byte by, byte by2, byte by3) {
        Message message = new Message(-18);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            message.java_io_DataOutputStream_a().writeByte(by2);
            if (by2 == 2) {
                message.java_io_DataOutputStream_a().writeByte(by3);
            }
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void a(byte by, byte by2, int[] nArray, byte[] byArray) {
        Message message = new Message(17);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            if (by == 0) {
                message.java_io_DataOutputStream_a().writeByte(by2);
                for (by = 0; by < by2; by = (byte)(by + 1)) {
                    message.java_io_DataOutputStream_a().writeInt(nArray[by]);
                    message.java_io_DataOutputStream_a().writeByte(byArray[by]);
                    new StringBuffer("[bv] ID= ").append(nArray[by]);
                }
            }
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void a(byte by, byte by2, short s, int qty) {
        Message message = new Message(-3);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            if (by == 1) {
                message.java_io_DataOutputStream_a().writeByte(by2);
                message.java_io_DataOutputStream_a().writeShort(s);
                message.java_io_DataOutputStream_a().writeShort((short) qty);
            }
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void a(byte by, byte by2, short s, byte by3) {
        this.a(by, by2, s, (int)(by3 & 0xFF));
    }

    public final void o() {
        Message message = new Message(-4);
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void p() {
        Message message = new Message(-19);
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void c(byte by, byte by2, byte by3) {
        Message message = new Message(-12);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            if (by == 1) {
                message.java_io_DataOutputStream_a().writeByte(by2);
                message.java_io_DataOutputStream_a().writeByte(by3);
            }
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
    }

    public final void b(byte by, int n) {
        Message message = new Message(-14);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            message.java_io_DataOutputStream_a().writeByte(n);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void k(byte by) {
        Message message = new Message(-17);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void c(byte by, byte by2) {
        Message message = new Message(-23);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            if (by == 1) {
                message.java_io_DataOutputStream_a().writeByte(by2);
            }
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void c(byte by, int n) {
        new StringBuffer("[bv] Gop tien ").append(by).append(" soluong= ").append(n);
        Message message = new Message(-21);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            message.java_io_DataOutputStream_a().writeInt(n);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void d(byte by, int n) {
        Message message = new Message(-25);
        try {
            message.java_io_DataOutputStream_a().writeByte(by);
            message.java_io_DataOutputStream_a().writeInt(n);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void h(int n) {
        Message message = new Message(13);
        try {
            message.java_io_DataOutputStream_a().writeByte(0);
            message.java_io_DataOutputStream_a().writeInt(n);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void i(int n) {
        Message message = new Message(13);
        try {
            message.java_io_DataOutputStream_a().writeByte(1);
            message.java_io_DataOutputStream_a().writeInt(n);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void a(int n, int[] nArray, int[] nArray2, int n2) {
        Message message = new Message(44);
        try {
            message.java_io_DataOutputStream_a().writeByte(1);
            message.java_io_DataOutputStream_a().writeInt(n);
            n = nArray != null ? nArray.length : 0;
            message.java_io_DataOutputStream_a().writeByte(n);
            for (int i = 0; i < n; ++i) {
                message.java_io_DataOutputStream_a().writeInt(nArray[i]);
                message.java_io_DataOutputStream_a().writeInt(nArray2[i]);
            }
            message.java_io_DataOutputStream_a().writeInt(n2);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void c(short s) {
        Message message = new Message(61);
        try {
            message.java_io_DataOutputStream_a().writeShort(s);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void sendBauCuaBet(byte[] byArray) {
        Message message = new Message((byte)-98);
        try {
            message.java_io_DataOutputStream_a().writeByte(1);
            for (int i = 0; i < 6; ++i) {
                message.java_io_DataOutputStream_a().writeByte(byArray[i]);
            }
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void sendBauCuaTransfer(byte by, byte by2, byte by3, byte by4, byte by5) {
        Message message = new Message((byte)-98);
        try {
            message.java_io_DataOutputStream_a().writeByte(6);
            message.java_io_DataOutputStream_a().writeByte(by);
            message.java_io_DataOutputStream_a().writeByte(by2);
            message.java_io_DataOutputStream_a().writeByte(by3);
            message.java_io_DataOutputStream_a().writeByte(by4);
            message.java_io_DataOutputStream_a().writeByte(by5);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }

    public final void sendBauCuaPass(byte by, byte by2) {
        Message message = new Message((byte)-98);
        try {
            message.java_io_DataOutputStream_a().writeByte(3);
            message.java_io_DataOutputStream_a().writeByte(by);
            message.java_io_DataOutputStream_a().writeByte(by2);
        }
        catch (Exception exception) {}
        this.var_game_IServerListener_l11llllI.a(message);
        message.void_a();
    }
}

