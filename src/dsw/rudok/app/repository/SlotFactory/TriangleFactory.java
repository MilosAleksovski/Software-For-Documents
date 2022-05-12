package dsw.rudok.app.repository.SlotFactory;

import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.slot.Slot;
import dsw.rudok.app.repository.workspace.slot.TriangleSlot;

import java.awt.*;

public class TriangleFactory extends SlotFactory {
    @Override
    public Slot createSlot( Point position, String name, RuNode parent) {
        return new TriangleSlot(position, name, parent);
    }
}
