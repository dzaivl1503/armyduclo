package game;

import game.ConnectionWatchdog;
import game.DataUtils;
import game.Message;
import game.PetInfo;
import java.io.DataInputStream;
import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.Image;

/**
 * Quan ly pet phia client. Toan bo du lieu (danh sach pet, chi so, anh, slot
 * dang trang bi) lay tu server - server doc tu bang `pets` + `user_pets` trong SQL,
 * nen moi nguoi choi co bo pet khac nhau.
 */
public final class PetManager {

    public static final int SLOT_COUNT = 3;

    /** Ma lenh dong bo pet voi server. */
    public static final byte CMD_PET_INFO = -110;
    public static final byte CMD_PET_EQUIP = -111;
    /** Dung trang bi pet: short itemId, short petId (-1 = thao). */
    public static final byte CMD_PET_ITEM_USE = -112;

    private static final String STORE_NAME = "pet";

    public static final Vector pets = new Vector();
    /** Trang bi pet dang so huu (hien cung hang duoi voi pet). */
    public static final Vector items = new Vector();
    public static final PetInfo[] slots = new PetInfo[SLOT_COUNT];

    /** Anh pet theo pet id, giu lai de khong phai nap lai moi lan. */
    private static final Hashtable iconCache = new Hashtable();

    private static boolean loaded = false;
    /** true khi da nhan du lieu pet tu server. */
    public static boolean fromServer = false;

    private static long lastRequestAt = 0L;

    private PetManager() {
    }

    public static void init() {
        if (loaded) {
            return;
        }
        loaded = true;
        for (int i = 0; i < SLOT_COUNT; ++i) {
            slots[i] = null;
        }
    }

    public static int petCount() {
        return pets.size();
    }

    public static int itemCount() {
        return items.size();
    }

    public static PetItemInfo itemAt(int index) {
        if (index < 0 || index >= items.size()) {
            return null;
        }
        return (PetItemInfo) items.elementAt(index);
    }

    public static PetItemInfo itemById(int itemId) {
        for (int i = 0; i < items.size(); ++i) {
            PetItemInfo item = (PetItemInfo) items.elementAt(i);
            if (item.id == itemId) {
                return item;
            }
        }
        return null;
    }

    /** Dung trang bi cho pet; petId = -1 de thao ra. Server tra lai PET_INFO moi. */
    public static void useItem(PetItemInfo item, int petId) {
        if (item == null) {
            return;
        }
        item.petId = (short) petId;
        item.slot = (byte) (petId < 0 ? -1 : item.slot);
        try {
            ConnectionWatchdog.game_ConnectionWatchdog_a().sendPetItemUse(item.id, (short) petId);
        } catch (Throwable throwable) {
            // mat ket noi: giu du lieu cu
        }
    }

    /** Trang bi dang gan cho pet nay (de ve o trang bi tren pet). */
    public static PetItemInfo itemInSlotOf(int petId, int slot) {
        for (int i = 0; i < items.size(); ++i) {
            PetItemInfo item = (PetItemInfo) items.elementAt(i);
            if (item.petId == petId && item.slot == slot) {
                return item;
            }
        }
        return null;
    }

    public static PetInfo petAt(int index) {
        if (index < 0 || index >= pets.size()) {
            return null;
        }
        return (PetInfo) pets.elementAt(index);
    }

    public static PetInfo petById(int id) {
        for (int i = 0; i < pets.size(); ++i) {
            PetInfo petInfo = (PetInfo) pets.elementAt(i);
            if (petInfo.id == id) {
                return petInfo;
            }
        }
        return null;
    }

    public static PetInfo slotPet(int slot) {
        if (slot < 0 || slot >= SLOT_COUNT) {
            return null;
        }
        return slots[slot];
    }

    public static int slotIndexOf(PetInfo petInfo) {
        for (int i = 0; i < SLOT_COUNT; ++i) {
            if (slots[i] == petInfo) {
                return i;
            }
        }
        return -1;
    }

    public static void equip(PetInfo petInfo, int slot) {
        init();
        if (petInfo == null || slot < 0 || slot >= SLOT_COUNT) {
            return;
        }
        for (int i = 0; i < SLOT_COUNT; ++i) {
            if (slots[i] != null && slots[i].id == petInfo.id) {
                slots[i] = null;
            }
        }
        slots[slot] = petInfo;
        save();
        sendSlot(slot, petInfo.id);
    }

    public static void unequip(int slot) {
        init();
        if (slot < 0 || slot >= SLOT_COUNT) {
            return;
        }
        int petId = slots[slot] == null ? -1 : slots[slot].id;
        slots[slot] = null;
        save();
        sendSlot(slot, petId);
    }

    public static int equippedCount() {
        int n = 0;
        for (int i = 0; i < SLOT_COUNT; ++i) {
            if (slots[i] != null) {
                ++n;
            }
        }
        return n;
    }

    /** Tong 5 chi so cua cac pet dang trang bi. */
    public static int[] totalStats() {
        int[] nArray = new int[5];
        for (int i = 0; i < SLOT_COUNT; ++i) {
            PetInfo petInfo = slots[i];
            if (petInfo == null) {
                continue;
            }
            for (int j = 0; j < 5; ++j) {
                nArray[j] = nArray[j] + petInfo.stats[j];
            }
        }
        return nArray;
    }

    /** Xin du lieu pet tu server (co gioi han tan suat). */
    public static void requestSync() {
        long now = System.currentTimeMillis();
        if (now - lastRequestAt < 2000L) {
            return;
        }
        lastRequestAt = now;
        try {
            ConnectionWatchdog.game_ConnectionWatchdog_a().sendPetRequest();
        } catch (Throwable throwable) {
            // offline: khong lam gi
        }
    }

    private static void sendSlot(int slot, int petId) {
        try {
            ConnectionWatchdog.game_ConnectionWatchdog_a().sendPetSlot((byte) slot, (short) petId);
        } catch (Throwable throwable) {
            // offline: giu du lieu local
        }
    }

    private static Image iconOf(int petId) {
        Integer key = new Integer(petId);
        Image image = (Image) iconCache.get(key);
        if (image != null) {
            return image;
        }
        try {
            image = Image.createImage("/pet/" + petId + ".png");
        } catch (Throwable throwable) {
            image = null;
        }
        if (image != null) {
            iconCache.put(key, image);
        }
        return image;
    }

    /** Nhan goi tin PET_INFO tu server (danh sach pet cua nguoi choi + anh). */
    public static void handlePetInfo(Message message) {
        init();
        System.out.println("[pet] nhan PET_INFO");
        try {
            DataInputStream dataInputStream = message.java_io_DataInputStream_a();
            int n = dataInputStream.readByte() & 0xFF;
            pets.removeAllElements();
            for (int i = 0; i < SLOT_COUNT; ++i) {
                slots[i] = null;
            }
            byte[] byArray = new byte[0];
            for (int i = 0; i < n; ++i) {
                PetInfo petInfo = new PetInfo();
                petInfo.id = dataInputStream.readShort();
                petInfo.name = dataInputStream.readUTF();
                petInfo.level = dataInputStream.readShort();
                for (int j = 0; j < 5; ++j) {
                    petInfo.stats[j] = dataInputStream.readShort();
                }
                int n2 = dataInputStream.readByte();
                int n4 = dataInputStream.readByte();
                int n3 = dataInputStream.readShort();
                if (n3 < 0) {
                    n3 = 0;
                }
                if (n3 > 20000) {
                    // goi tin lech (server cu chua gui frames): dung de khong treo client
                    break;
                }
                if (n3 > 0) {
                    try {
                        byArray = new byte[n3];
                        dataInputStream.readFully(byArray);
                        petInfo.sheet = Image.createImage(byArray, 0, n3);
                    } catch (Throwable throwable) {
                        petInfo.sheet = null;
                    }
                } else {
                    petInfo.sheet = iconOf(petInfo.id);
                }
                petInfo.frames = n4 < 1 ? 1 : n4;
                int n5 = dataInputStream.readShort();
                if (n5 > 0 && n5 <= 200000) {
                    try {
                        byte[] byArray2 = new byte[n5];
                        dataInputStream.readFully(byArray2);
                        petInfo.bigSheet = Image.createImage(byArray2, 0, n5);
                    } catch (Throwable throwable) {
                        petInfo.bigSheet = null;
                    }
                }
                if (petInfo.sheet != null) {
                    iconCache.put(new Integer(petInfo.id), petInfo.sheet);
                }
                pets.addElement(petInfo);
                if (n2 >= 0 && n2 < SLOT_COUNT) {
                    slots[n2] = petInfo;
                }
            }
            if (n > 0) {
                fromServer = true;
            }
            int n6 = dataInputStream.readByte() & 0xFF;
            items.removeAllElements();
            for (int i = 0; i < n6; ++i) {
                PetItemInfo item = new PetItemInfo();
                item.id = dataInputStream.readShort();
                item.name = dataInputStream.readUTF();
                for (int j = 0; j < 5; ++j) {
                    item.stats[j] = dataInputStream.readShort();
                }
                item.petId = dataInputStream.readShort();
                item.slot = dataInputStream.readByte();
                int n7 = dataInputStream.readShort();
                if (n7 > 0 && n7 <= 200000) {
                    byte[] bytes = new byte[n7];
                    dataInputStream.readFully(bytes);
                    try {
                        item.image = Image.createImage(bytes, 0, n7);
                    } catch (Throwable throwable) {
                        item.image = null;
                    }
                }
                items.addElement(item);
            }
            System.out.println("[pet] PET_INFO xong: " + pets.size() + " pet, " + items.size()
                    + " trang bi, dang dung=" + equippedCount());
        } catch (Throwable throwable) {
            System.out.println("[pet] PET_INFO loi: " + throwable);
            // goi tin loi: giu du lieu cu
        }
    }

    /** Nhan goi tin PET_EQUIP (danh sach 3 slot) tu server. */
    public static void handlePetSlots(Message message) {
        init();
        try {
            DataInputStream dataInputStream = message.java_io_DataInputStream_a();
            for (int i = 0; i < SLOT_COUNT; ++i) {
                int n = dataInputStream.readByte();
                slots[i] = n < 0 ? null : petById(n);
            }
            save();
        } catch (Throwable throwable) {
            // goi tin loi: giu du lieu cu
        }
    }

    public static void save() {
        byte[] byArray = new byte[SLOT_COUNT];
        for (int i = 0; i < SLOT_COUNT; ++i) {
            byArray[i] = (byte) (slots[i] == null ? -1 : slots[i].id);
        }
        try {
            DataUtils.a(byArray, STORE_NAME);
        } catch (Throwable throwable) {
            // bo qua loi luu tru
        }
    }
}
