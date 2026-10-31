package game;

import game.IActionListener;
import game.PetScreen;

final class ActionListener309
implements IActionListener {
    private final PetScreen a;

    ActionListener309(PetScreen petScreen) {
        this.a = petScreen;
    }

    public final void a() {
        this.a.unequipSelected();
    }
}
