/*
 * Decompiled with CFR 0.152.
 */
package game;

import game.ActionListener236;
import game.ActionListener293;
import game.ActionListener294;
import game.EquipScreen;
import game.GameCanvas;
import game.GameCommand;
import game.IActionListener;
import game.StringUtils;
import java.util.Vector;

final class ActionListener232
implements IActionListener {
    final EquipScreen a;

    ActionListener232(EquipScreen equipScreen) {
        this.a = equipScreen;
    }

    public final void a() {
        Vector<GameCommand> vector = new Vector<GameCommand>();
        if (this.a.b.size() != 0) {
            if (this.a.game_ItemTemplate_a().var_byte_e == 0) {
                vector.addElement(new GameCommand("Gia h\u1ea1n", new ActionListener236(this)));
            }
            vector.addElement(new GameCommand(StringUtils.ax(), new ActionListener293(this)));
        }
        vector.addElement(new GameCommand(StringUtils.R(), new ActionListener294(this)));
        vector.addElement(new GameCommand("Pet", new ActionListener310(this.a)));
        GameCanvas.var_game_GameHelper10_a.a(vector, 0);
    }
}

