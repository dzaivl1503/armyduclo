package game;

import javax.microedition.lcdui.Image;

/** 1 mon trang bi pet (tu bang `pet_items`), kem pet dang gan va o trang bi. */
public final class PetItemInfo {

    public short id;
    public String name = "";
    public int[] stats = new int[5];
    public short petId = -1;
    public byte slot = -1;
    public Image image;

    public PetItemInfo() {
    }

    public int stat(int i) {
        return i >= 0 && i < 5 ? this.stats[i] : 0;
    }

    public boolean equipped() {
        return this.petId >= 0;
    }
}
