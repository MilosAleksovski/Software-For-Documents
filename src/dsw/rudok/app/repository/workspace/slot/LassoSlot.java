package dsw.rudok.app.repository.workspace.slot;

import dsw.rudok.app.gui.swing.view.painters.RectanglePainter;
import dsw.rudok.app.repository.Node.RuNode;

import java.awt.*;

public class LassoSlot extends Slot {

    public LassoSlot(Point position, String name, RuNode parent) {
        super( position, name, parent);
        size = new Dimension(100, 50);
        elementPainter = new RectanglePainter(this);

    }
}

