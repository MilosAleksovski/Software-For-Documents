package dsw.rudok.app.repository.SlotFactory;

import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.slot.RectangleSlot;
import dsw.rudok.app.repository.workspace.slot.Slot;

import javax.swing.text.Position;
import java.awt.*;

public class RectangleFactory extends SlotFactory {
    @Override
    public Slot createSlot(Point position, String name, RuNode parent) {
        return new RectangleSlot(position,name,parent);
    }
}
