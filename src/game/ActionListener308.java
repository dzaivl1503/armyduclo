package game;

import game.IActionListener;
import game.PetScreen;

final class ActionListener308
implements IActionListener {
    private final PetScreen a;

    ActionListener308(PetScreen petScreen) {
        this.a = petScreen;
    }

    public final void a() {
        this.a.close();
    }
}
