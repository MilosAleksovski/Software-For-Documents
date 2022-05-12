package dsw.rudok.app.repository.workspace.slot;

import dsw.rudok.app.gui.swing.view.painters.TrianglePainter;
import dsw.rudok.app.repository.Node.RuNode;

import java.awt.*;

public class TriangleSlot  extends  Slot{

    public TriangleSlot(Point position, String name, RuNode parent) {
        super(position, name, parent);
        size = new Dimension(100, 50);
        elementPainter = new TrianglePainter(this);
    }
}
