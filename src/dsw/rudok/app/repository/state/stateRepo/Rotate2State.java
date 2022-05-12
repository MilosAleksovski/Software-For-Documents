package dsw.rudok.app.repository.state.stateRepo;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.ErrorHandler.ErrorTypes;
import dsw.rudok.app.gui.swing.view.painters.DevicePainter;
import dsw.rudok.app.repository.SlotHandler.SlotHandler;
import dsw.rudok.app.repository.SlotHandler.SlotHandlerImpl;
import dsw.rudok.app.repository.state.State;
import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.workspace.slot.CircleSlot;
import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;

public class Rotate2State extends State{
    private Page mediator;


    public Rotate2State(Page md) {

        this.mediator = md;
    }


    public void mousePressed(MouseEvent e) {
        getSlotHandler().rotateSlot2Press(e, mediator);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        getSlotHandler().rotateSlot2Drag(e, mediator);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
