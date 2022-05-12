package dsw.rudok.app.repository.SlotFactory;

import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.slot.LassoSlot;
import dsw.rudok.app.repository.workspace.slot.RectangleSlot;
import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.*;

public class LassoFactory extends SlotFactory {
    @Override
    public Slot createSlot(Point position, String name, RuNode parent) {
        return new LassoSlot(position, name, parent);
    }
}