package game;

import game.ActionListener307;
import game.ActionListener308;
import game.ActionListener309;
import game.GameCanvas;
import game.GameCommand;
import game.IActionListener;
import game.PetManager;
import game.PetScreen;
import game.StringUtils;
import java.util.Vector;

final class ActionListener306
implements IActionListener {
    private final PetScreen a;

    ActionListener306(PetScreen petScreen) {
        this.a = petScreen;
    }

    public final void a() {
        Vector<GameCommand> vector = new Vector<GameCommand>();
        vector.addElement(new GameCommand("Trang b\u1ecb pet", new ActionListener307(this.a)));
        if (PetManager.slotPet(this.a.selectedSlot()) != null) {
            vector.addElement(new GameCommand("B\u1ecf pet", new ActionListener309(this.a)));
        }
        vector.addElement(new GameCommand(StringUtils.dI(), new ActionListener308(this.a)));
        GameCanvas.var_game_GameHelper10_a.a(vector, 0);
    }
}
