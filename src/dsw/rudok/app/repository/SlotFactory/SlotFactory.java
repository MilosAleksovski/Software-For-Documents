package dsw.rudok.app.repository.SlotFactory;

import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.*;

public abstract class SlotFactory {
    public  Slot napraviSlot( Point position, String name, RuNode parent) {
        Slot slot = createSlot(position,name,parent);
        return slot;
    }
    public abstract Slot createSlot( Point position, String name, RuNode parent);
}
