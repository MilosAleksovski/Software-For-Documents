package dsw.rudok.app.repository.SlotHandler;

import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public interface SlotHandler  {
    void moveSlot(Page mediator, MouseEvent e);
    void moveSlot2(Page mediator, MouseEvent e);
    void resizeSlot(Page mediator, MouseEvent e);
    void resizeSlot2(Page mediator, MouseEvent e);
    void rotateSlot(Page mediator);
    void deleteSlot(Page mediator, MouseEvent e);
    void napraviSlot(Point point, String type, Page mediator);
    void rotateSlot2Press(MouseEvent e, Page mediator);
    void rotateSlot2Drag(MouseEvent e, Page mediator);
     void setStartcord(MouseEvent e,Page mediator);
     void setEndCord(Page mediator,MouseEvent e);
     void setEndCord2(Page mediator,MouseEvent e);

}
