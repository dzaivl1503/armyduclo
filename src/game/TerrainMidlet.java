/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.io.Connector
 *  javax.microedition.io.HttpConnection
 *  javax.microedition.lcdui.Display
 *  javax.microedition.lcdui.Displayable
 *  javax.microedition.media.Manager
 *  javax.microedition.media.Player
 *  javax.microedition.media.control.VolumeControl
 *  javax.microedition.midlet.MIDlet
 */
package game;

import game.ConnectTask;
import game.ConnectionWatchdog;
import game.DataUtils;
import game.GameCanvas;
import game.GameHelper01;
import game.IActionListener;
import game.IServerListener;
import game.MessageHandler;
import game.PlayerAccountInfo;
import game.ServerInfo;
import game.ServerManager;
import game.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;
import javax.microedition.midlet.MIDlet;

public class TerrainMidlet
extends MIDlet {
    public static byte providerId;
    public static GameCanvas canvas;
    public static TerrainMidlet instance;
    public static int serverPort;
    public static String serverHost;
    public static PlayerAccountInfo myInfo;
    public static boolean[] isVip;
    private static String var_java_lang_String_l1IIlIll;
    private static Player var_javax_microedition_media_Player_l1IIlIll;
    private static int var_int_l1IIlIll;
    public static String version;

    public TerrainMidlet() {
        Object object;
        Object object2;
        if (canvas == null) {
            canvas = new GameCanvas();
        }
        try {
            object2 = DataUtils.java_io_InputStream_a("/provider.txt");
            object = new byte[((InputStream)object2).available()];
            ((InputStream)object2).read((byte[])object);
            ((InputStream)object2).close();
            providerId = Byte.parseByte(new String((byte[])object, "UTF-8"));
            System.out.println("[coreLG/TerrainMidlet] PROVIDER= " + providerId);
        }
        catch (Exception exception) {}
        serverHost = "103.178.235.112";
        serverPort = 19129;
        GameHelper01.d().a(ServerManager.game_ServerManager_a());
        object = MessageHandler.game_MessageHandler_a();
        MessageHandler.game_MessageHandler_a().var_game_INetworkCallback_a = GameHelper01.d();
        ConnectionWatchdog.game_ConnectionWatchdog_a().a((IServerListener)object);
    }

    public static void fetchAndSaveServerList() {
        GameCanvas.c(StringUtils.ds());
        ServerInfo.var_java_lang_String_arr_a = new String[]{"TuatDuc"};
        ServerInfo.var_java_lang_String_arr_b = new String[]{"103.178.235.112"};
        ServerInfo.var_short_arr_a = new short[]{(short)19129};
        serverHost = "103.178.235.112";
        serverPort = 19129;
        TerrainMidlet.I11Il1ll();
        GameCanvas.d();
    }

    private static void I11Il1ll() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeByte(ServerInfo.var_java_lang_String_arr_a.length);
            for (int i = 0; i < ServerInfo.var_java_lang_String_arr_a.length; ++i) {
                dataOutputStream.writeUTF(ServerInfo.var_java_lang_String_arr_a[i]);
                dataOutputStream.writeUTF(ServerInfo.var_java_lang_String_arr_b[i]);
                dataOutputStream.writeShort(ServerInfo.var_short_arr_a[i]);
            }
            DataUtils.a(byteArrayOutputStream.toByteArray(), "ipArmy2");
            dataOutputStream.close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public static void loadServerList() {
        ServerInfo.var_java_lang_String_arr_a = new String[]{"TuatDuc"};
        ServerInfo.var_java_lang_String_arr_b = new String[]{"103.178.235.112"};
        ServerInfo.var_short_arr_a = new short[]{(short)19129};
        serverHost = "103.178.235.112";
        serverPort = 19129;
        TerrainMidlet.I11Il1ll();
    }

    private static String[] I11Il1ll(String string, String string2) {
        int n = 0;
        int n2 = string.indexOf(string2, 0);
        int n3 = 0;
        int n4 = string2.length();
        while (n2 != -1) {
            n2 += n4;
            n2 = string.indexOf(string2, n2);
            ++n;
        }
        String[] stringArray = new String[n + 1];
        string.indexOf(string2);
        n = 0;
        while ((n2 = string.indexOf(string2, n3)) != -1) {
            stringArray[n] = string.substring(n3, n2);
            n3 = n2 + n4;
            ++n;
        }
        stringArray[n] = string.substring(n3, string.length());
        return stringArray;
    }

    private static String I11Il1ll(String string) {
        try {
            System.out.println("[coreLG/TerrainMidlet] Connecting to: " + string);
            HttpConnection conn = (HttpConnection)Connector.open(string);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
            conn.setRequestProperty("Content-Type", "text/plain");
            conn.setRequestProperty("Connection", "close");
            String resultStr = "";
            int n = conn.getResponseCode();
            System.out.println("[coreLG/TerrainMidlet] Response code: " + n);
            if (n == 200) {
                int n2;
                InputStream inputStream = conn.openInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] byArray = new byte[1024];
                while ((n2 = inputStream.read(byArray)) != -1) {
                    baos.write(byArray, 0, n2);
                }
                resultStr = new String(baos.toByteArray(), "UTF-8");
                inputStream.close();
                System.out.println("[coreLG/TerrainMidlet] Received content length: " + resultStr.length());
            }
            conn.close();
            return resultStr;
        }
        catch (Exception exception) {
            System.err.println("[coreLG/TerrainMidlet] Connection error: " + exception.getMessage());
            exception.printStackTrace();
            return null;
        }
    }

    public void destroyApp(boolean bl) {
        if (canvas != null) {
            canvas = null;
        }
        this.notifyDestroyed();
    }

    public void pauseApp() {
        this.notifyPaused();
    }

    public void startApp() {
        canvas.setFullScreenMode(true);
        Display.getDisplay((MIDlet)this).setCurrent((Displayable)canvas);
        instance = this;
    }

    public static void exit() {
        instance.destroyApp(false);
    }

    public static void executeAsync(String string, String string2, IActionListener iActionListener, IActionListener iActionListener2) {
        new Thread(new ConnectTask(string2, string, iActionListener, iActionListener2)).start();
    }

    public static void playMusic() {
        try {
            var_javax_microedition_media_Player_l1IIlIll.start();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public static void setMusicVolume(int n) {
        try {
            ((VolumeControl)var_javax_microedition_media_Player_l1IIlIll.getControl("VolumeControl")).setLevel(n);
            var_int_l1IIlIll = n;
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public static void loadMusic() {
        try {
            if (var_javax_microedition_media_Player_l1IIlIll != null) {
                var_javax_microedition_media_Player_l1IIlIll.stop();
                var_javax_microedition_media_Player_l1IIlIll = null;
                System.gc();
            }
            var_javax_microedition_media_Player_l1IIlIll = Manager.createPlayer((InputStream)DataUtils.java_io_InputStream_a("/0.mid"), (String)"audio/midi");
            var_javax_microedition_media_Player_l1IIlIll.realize();
            var_javax_microedition_media_Player_l1IIlIll.prefetch();
            var_javax_microedition_media_Player_l1IIlIll.setLoopCount(1);
            ((VolumeControl)var_javax_microedition_media_Player_l1IIlIll.getControl("VolumeControl")).setLevel(var_int_l1IIlIll);
            return;
        }
        catch (Exception exception) {
            System.gc();
            return;
        }
    }

    static {
        serverPort = 19129;
        serverHost = "103.178.235.112";
        isVip = new boolean[10];
        var_int_l1IIlIll = 100;
        version = "2.4.2";
        var_java_lang_String_l1IIlIll = "http://127.0.0.1/sv.txt";
    }
}

