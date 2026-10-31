package game;

import game.IActionListener;
import game.PetScreen;

final class ActionListener307
implements IActionListener {
    private final PetScreen a;

    ActionListener307(PetScreen petScreen) {
        this.a = petScreen;
    }

    public final void a() {
        this.a.equipSelected();
    }
}
