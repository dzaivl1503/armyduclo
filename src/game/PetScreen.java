package game;

import java.util.Vector;
import game.ActionListener306;
import game.ActionListener307;
import game.ActionListener308;
import game.BaseScreen;
import game.BattleScreen;
import game.CharacterUpgradeScreen;
import game.DataUtils;
import game.FontRenderer;
import game.GameCanvas;
import game.GameCommand;
import game.IActionListener;
import game.MenuScreen;
import game.PetInfo;
import game.PetItemInfo;
import game.PetManager;
import game.ScrollDialogScreen;
import game.StringUtils;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 * Man hinh Pet, bo cuc theo EquipScreen:
 * - pet dang dung ve to o giua, 3 o trang bi pet quanh pet
 * - cot 5 chi so ben phai (giong EquipScreen)
 * - hang duoi: kho chung gom pet so huu + trang bi pet
 *   + bam pet  = dung pet do
 *   + bam trang bi = dung cho pet dang chon
 * - thoat: hoi luu neu co thay doi
 */
public final class PetScreen
extends ScrollDialogScreen {

    public static PetScreen var_game_PetScreen_a;

    private static final int SLOT_COUNT = 3;
    private static final int COLS = 3;
    private static final int ROWS = 3;
    private static final int CELL = 20;

    private final int[] slotX = new int[SLOT_COUNT];
    private final int[] slotY = new int[SLOT_COUNT];

    private int centerX;
    private int petX;
    private int petY;
    private int gridX;
    private int gridY;

    private int selIndex = 0;
    /** pet se dung sau khi luu (-1 = chua doi) */
    private int pendingPetId = -1;
    /** itemId da dung trong phien, cho pet dang chon */
    private final Vector pendingItems = new Vector();
    private boolean askingSave = false;
    private boolean saved = false;

    private final GameCommand cmdMenu;
    private final GameCommand cmdUse;
    private final GameCommand cmdClose;

    public PetScreen() {
        this.centerX = GameCanvas.var_int_b / 2;
        this.d = this.centerX - 75;
        this.e = (GameCanvas.var_int_c - BaseScreen.var_int_r) / 2 - 85;
        this.var_int_f = 150;
        this.var_int_g = 170;
        this.var_int_h = 4;
        this.a = "PET";
        this.n();
        this.slotX[0] = this.centerX - 52;
        this.slotY[0] = this.e + 36;
        this.slotX[1] = this.centerX - 77;
        this.slotY[1] = this.e + 62;
        this.slotX[2] = this.centerX - 27;
        this.slotY[2] = this.e + 62;
        this.petX = this.centerX - 52;
        this.petY = this.e + 92;
        this.gridX = this.centerX - 86;
        this.gridY = this.e + 100;
        this.cmdMenu = new GameCommand("Menu", new ActionListener306(this));
        this.cmdUse = new GameCommand("D\u00f9ng", new ActionListener307(this));
        this.cmdClose = new GameCommand(StringUtils.dI(), new ActionListener308(this));
        this.f = this.cmdMenu;
        this.g = this.cmdUse;
        this.h = this.cmdClose;
    }

    public void a(BaseScreen baseScreen) {
        if (baseScreen == null) {
            baseScreen = MenuScreen.var_game_MenuScreen_a;
        }
        PetManager.init();
        PetManager.requestSync();
        this.selIndex = 0;
        this.pendingPetId = -1;
        this.pendingItems.removeAllElements();
        this.askingSave = false;
        this.saved = false;
        super.a(baseScreen);
    }

    // ---------------------------------------------------------------- du lieu dang chon

    private PetInfo displayPet() {
        if (this.pendingPetId >= 0) {
            PetInfo petInfo = PetManager.petById(this.pendingPetId);
            if (petInfo != null) {
                return petInfo;
            }
        }
        PetInfo petInfo = PetManager.slotPet(0);
        if (petInfo != null) {
            return petInfo;
        }
        return PetManager.petAt(0);
    }

    private int displayPetId() {
        PetInfo petInfo = this.displayPet();
        return petInfo == null ? -1 : petInfo.id;
    }

    private int cellCount() {
        return PetManager.petCount() + PetManager.itemCount();
    }

    private int scrollTop() {
        return this.selIndex / (COLS * ROWS) * COLS * ROWS;
    }

    private boolean selectedIsPet() {
        return this.selIndex < PetManager.petCount();
    }

    private PetItemInfo selectedItem() {
        return this.selectedIsPet() ? null : PetManager.itemAt(this.selIndex - PetManager.petCount());
    }

    /** Trang bi dang gan cho pet (ke ca vua dung trong phien chua luu). */
    private PetItemInfo itemOnPet(int petId, int slot) {
        for (int i = 0; i < this.pendingItems.size(); ++i) {
            PetItemInfo item = PetManager.itemById(((Integer) this.pendingItems.elementAt(i)).intValue());
            if (item != null && slot < 0) {
                return item;
            }
        }
        return PetManager.itemInSlotOf(petId, slot);
    }

    /** Cong chi so trang bi dang gan cho pet nay. */
    private int itemBonus(int petId, int statIndex) {
        int n = 0;
        if (petId < 0) {
            return 0;
        }
        for (int i = 0; i < PetManager.itemCount(); ++i) {
            PetItemInfo item = PetManager.itemAt(i);
            if (item == null || item.petId != petId) {
                continue;
            }
            n += item.stat(statIndex);
        }
        return n;
    }

    // ---------------------------------------------------------------- thao tac

    /** O dang chon la pet -> dung pet do; la trang bi -> dung cho pet dang hien thi. */
    final void activateSelected() {
        if (this.selectedIsPet()) {
            PetInfo petInfo = PetManager.petAt(this.selIndex);
            if (petInfo != null) {
                this.pendingPetId = petInfo.id;
                this.saved = false;
            }
            return;
        }
        PetItemInfo item = this.selectedItem();
        int n = this.displayPetId();
        if (item == null || n < 0) {
            return;
        }
        if (!this.pendingItems.contains(new Integer(item.id))) {
            this.pendingItems.addElement(new Integer(item.id));
        }
        this.saved = false;
    }

    final void nextSelection(int step) {
        int n = this.cellCount();
        if (n <= 0) {
            this.selIndex = 0;
            return;
        }
        this.selIndex = (this.selIndex + step + n) % n;
    }

    /** Hoi luu neu co thay doi (chi hoi 1 lan). */
    final void close() {
        if (this.saved || this.askingSave) {
            this.c = true;
            return;
        }
        if (!this.hasChanges()) {
            this.c = true;
            return;
        }
        this.askingSave = true;
        GameCanvas.a("L\u01b0u thay \u0111\u1ed5i?", new IActionListener() {
            public void a() {
                PetScreen.closeDialog();
                PetScreen.this.saveAll();
                PetScreen.this.c = true;
            }
        }, new IActionListener() {
            public void a() {
                PetScreen.closeDialog();
                PetScreen.this.pendingItems.removeAllElements();
                PetScreen.this.pendingPetId = -1;
                PetScreen.this.askingSave = false;
                PetScreen.this.c = true;
            }
        });
    }

    /** Dong hop thoai xac nhan (neu khong dong, dialog se dinh lai tren man hinh). */
    private static void closeDialog() {
        GameCanvas.var_game_GameHelper21_a = null;
        if (GameCanvas.var_game_BaseScreen_a != null && GameCanvas.var_game_BaseScreen_a.j) {
            MenuScreen.var_game_MenuScreen_a.e();
        }
    }

    private boolean hasChanges() {
        if (this.pendingItems.size() > 0) {
            return true;
        }
        if (this.pendingPetId < 0) {
            return false;
        }
        PetInfo petInfo = PetManager.slotPet(0);
        return petInfo == null || petInfo.id != this.pendingPetId;
    }

    /** Gui thay doi len server: pet duoc dung + tung trang bi da dung. */
    final void saveAll() {
        PetInfo petInfo = this.displayPet();
        int n = this.displayPetId();
        if (petInfo != null) {
            PetManager.equip(petInfo, 0);
        }
        for (int i = 0; i < this.pendingItems.size(); ++i) {
            PetItemInfo item = PetManager.itemById(((Integer) this.pendingItems.elementAt(i)).intValue());
            if (item != null && n >= 0) {
                PetManager.useItem(item, n);
            }
        }
        this.pendingItems.removeAllElements();
        this.saved = true;
        this.askingSave = false;
    }

    /** Tuong thich listener cu. */
    final void equipSelected() {
        this.activateSelected();
    }

    final void unequipSelected() {
        PetItemInfo item = this.selectedItem();
        if (item != null) {
            PetManager.useItem(item, -1);
        }
    }

    final void openChooser() {
        this.activateSelected();
    }

    final int selectedSlot() {
        return 0;
    }

    public void void_b() {
        super.void_b();
        PetManager.init();
        if (GameCanvas.var_boolean_arr_a[4]) {
            GameCanvas.var_boolean_arr_a[4] = false;
            this.nextSelection(-1);
        }
        if (GameCanvas.var_boolean_arr_a[6]) {
            GameCanvas.var_boolean_arr_a[6] = false;
            this.nextSelection(1);
        }
        if (GameCanvas.var_boolean_arr_a[2]) {
            GameCanvas.var_boolean_arr_a[2] = false;
            this.nextSelection(-COLS);
        }
        if (GameCanvas.var_boolean_arr_a[8]) {
            GameCanvas.var_boolean_arr_a[8] = false;
            this.nextSelection(COLS);
        }
        if (GameCanvas.var_boolean_c && Math.abs(GameCanvas.h - GameCanvas.g) < 10) {
            this.handleClick();
        }
    }

    private void handleClick() {
        int top = this.scrollTop();
        for (int i = 0; i < COLS * ROWS; ++i) {
            int index = top + i;
            if (index >= this.cellCount()) {
                break;
            }
            int n = this.gridX + 4 + i % COLS * CELL;
            int n2 = this.gridY + 4 + i / COLS * CELL;
            if (!GameCanvas.a(n, n2, CELL - 2, CELL - 2)) {
                continue;
            }
            this.selIndex = index;
            this.activateSelected();
            return;
        }
    }

    // ---------------------------------------------------------------- ve

    public void a(Graphics graphics) {
        super.a(graphics);
        this.drawSlots(graphics);
        this.drawPet(graphics);
        this.drawStats(graphics);
        this.drawInfo(graphics);
        this.drawGrid(graphics);
        this.d(graphics);
    }

    /** 3 o trang bi cua pet dang chon. */
    private void drawSlots(Graphics graphics) {
        int n = this.displayPetId();
        for (int i = 0; i < SLOT_COUNT; ++i) {
            int n2 = this.slotX[i];
            int n3 = this.slotY[i];
            graphics.setColor(4156571);
            graphics.fillRoundRect(n2 - 10, n3 - 10, 20, 20, 4, 4);
            graphics.setColor(16774532);
            graphics.fillRect(n2 - 9, n3 - 9, 18, 18);
            PetItemInfo item = n < 0 ? null : PetManager.itemInSlotOf(n, i);
            if (item != null && item.image != null) {
                Image image = item.image;
                DataUtils.a(graphics, image, 0, 0, image.getWidth(), image.getHeight(), 0, n2, n3, 3);
            } else if (BattleScreen.var_javax_microedition_lcdui_Image_f != null) {
                DataUtils.a(graphics, BattleScreen.var_javax_microedition_lcdui_Image_f, 0, 0, 16, 16, 0, n2, n3, 3);
            }
        }
    }

    private void drawPet(Graphics graphics) {
        PetInfo petInfo = this.displayPet();
        int n = this.petX;
        int n2 = this.petY;
        if (petInfo == null) {
            FontRenderer.b.a(graphics, "Ch\u01b0a c\u00f3 pet", n, n2 - 30, 2);
            return;
        }
        Image image = petInfo.animatedBigFrame();
        if (image != null) {
            DataUtils.a(graphics, image, 0, 0, image.getWidth(), image.getHeight(), 0, n, n2, 33);
            return;
        }
        graphics.setColor(petInfo.color);
        graphics.fillRoundRect(n - 10, n2 - 24, 20, 24, 6, 6);
        graphics.setColor(0);
        graphics.drawRoundRect(n - 10, n2 - 24, 20, 24, 6, 6);
        String string = petInfo.name.length() > 0 ? petInfo.name.substring(0, 1) : "?";
        FontRenderer.a.a(graphics, string, n, n2 - 12, 2);
    }

    /** Giong EquipScreen: icon + 3 o so, chu anchor 3. */
    private void drawStats(Graphics graphics) {
        PetInfo petInfo = this.displayPet();
        int n = this.displayPetId();
        for (int i = 0; i < 5; ++i) {
            if (CharacterUpgradeScreen.var_javax_microedition_lcdui_Image_a != null) {
                DataUtils.a(graphics, CharacterUpgradeScreen.var_javax_microedition_lcdui_Image_a, 0, i << 4, 16, 16, 0,
                        this.centerX - 1, this.e + 46 + i * 18, 3);
            }
            graphics.setColor(2378093);
            graphics.fillRect(this.centerX + 9, this.e + 38 + i * 18, 35, 16);
            graphics.fillRect(this.centerX + 46, this.e + 38 + i * 18, 18, 16);
            graphics.fillRect(this.centerX + 66, this.e + 38 + i * 18, 19, 16);
            int n2 = petInfo == null ? 0 : petInfo.stat(i);
            int n3 = this.itemBonus(n, i);
            FontRenderer.b.a(graphics, String.valueOf(n2 - n3), this.centerX + 26, this.e + 39 + i * 18, 3);
            FontRenderer.c.a(graphics, "+" + n3, this.centerX + 56, this.e + 39 + i * 18, 3);
            FontRenderer.b.a(graphics, String.valueOf(n2), this.centerX + 75, this.e + 39 + i * 18, 3);
        }
    }

    private void drawInfo(Graphics graphics) {
        PetInfo petInfo = this.displayPet();
        int n = this.centerX - 9;
        graphics.setColor(1521982);
        graphics.fillRoundRect(n, this.e + 130, 95, 16, 6, 6);
        graphics.fillRoundRect(n, this.e + 148, 95, 16, 6, 6);
        String string = petInfo == null ? "Ch\u01b0a ch\u1ecdn pet" : petInfo.name;
        String string2 = "Lv " + (petInfo == null ? "-" : String.valueOf(petInfo.level)) + "   "
                + PetManager.petCount() + " pet / " + PetManager.itemCount() + " \u0111\u1ed3";
        FontRenderer.b.a(graphics, string, n + 4, this.e + 131, 0);
        FontRenderer.c.a(graphics, string2, n + 4, this.e + 149, 0);
    }

    /** Kho chung: pet truoc, trang bi pet sau. */
    private void drawGrid(Graphics graphics) {
        int n = this.gridX;
        int n2 = this.gridY;
        graphics.setColor(4156571);
        graphics.fillRoundRect(n, n2, COLS * CELL + 8, ROWS * CELL + 8, 6, 6);
        graphics.setColor(1521982);
        graphics.drawRoundRect(n, n2, COLS * CELL + 8, ROWS * CELL + 8, 6, 6);
        int top = this.scrollTop();
        int n3 = PetManager.petCount();
        for (int i = 0; i < COLS * ROWS; ++i) {
            int index = top + i;
            if (index >= this.cellCount()) {
                break;
            }
            int n4 = n + 4 + i % COLS * CELL;
            int n5 = n2 + 4 + i / COLS * CELL;
            graphics.setColor(index == this.selIndex ? 16767817 : 16774532);
            graphics.fillRect(n4, n5, CELL - 2, CELL - 2);
            if (index < n3) {
                PetInfo petInfo = PetManager.petAt(index);
                if (petInfo == null) {
                    continue;
                }
                Image image = petInfo.icon();
                if (image != null) {
                    DataUtils.a(graphics, image, 0, 0, image.getWidth(), image.getHeight(), 0,
                            n4 + CELL / 2 - 1, n5 + CELL / 2 - 1, 3);
                }
                if (petInfo.id == this.displayPetId()) {
                    graphics.setColor(65280);
                    graphics.drawRect(n4, n5, CELL - 3, CELL - 3);
                }
            } else {
                PetItemInfo item = PetManager.itemAt(index - n3);
                if (item == null) {
                    continue;
                }
                if (item.image != null) {
                    Image image = item.image;
                    DataUtils.a(graphics, image, 0, 0, image.getWidth(), image.getHeight(), 0,
                            n4 + CELL / 2 - 1, n5 + CELL / 2 - 1, 3);
                } else {
                    graphics.setColor(8421504);
                    graphics.fillRect(n4 + 5, n5 + 5, 8, 8);
                }
                if (item.petId >= 0 || this.pendingItems.contains(new Integer(item.id))) {
                    graphics.setColor(16776960);
                    graphics.drawRect(n4 + 1, n5 + 1, CELL - 5, CELL - 5);
                }
            }
        }
    }
}
