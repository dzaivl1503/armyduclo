package game;

import game.BaseScreen;
import game.EquipScreen;
import game.IActionListener;
import game.MenuScreen;
import game.PetScreen;

/** Mo man hinh Pet tu menu cua EquipScreen. */
final class ActionListener310
implements IActionListener {
    private final EquipScreen a;

    ActionListener310(EquipScreen equipScreen) {
        this.a = equipScreen;
    }

    public final void a() {
        if (PetScreen.var_game_PetScreen_a == null) {
            PetScreen.var_game_PetScreen_a = new PetScreen();
        }
        BaseScreen baseScreen = this.a != null ? this.a : MenuScreen.var_game_MenuScreen_a;
        PetScreen.var_game_PetScreen_a.a(baseScreen);
    }
}
