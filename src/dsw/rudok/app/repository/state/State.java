package dsw.rudok.app.repository.state;


import dsw.rudok.app.repository.SlotHandler.SlotHandler;
import dsw.rudok.app.repository.SlotHandler.SlotHandlerImpl;

import java.awt.event.MouseEvent;
import java.io.Serializable;

public class State implements Serializable {

    transient private SlotHandler slotHandler ;

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}

    public SlotHandler getSlotHandler() {
        slotHandler = new SlotHandlerImpl();
        return slotHandler;
    }
}
