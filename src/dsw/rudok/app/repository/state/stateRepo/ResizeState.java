package dsw.rudok.app.repository.state.stateRepo;

import dsw.rudok.app.gui.swing.view.painters.*;
import dsw.rudok.app.repository.SlotHandler.SlotHandler;
import dsw.rudok.app.repository.SlotHandler.SlotHandlerImpl;
import dsw.rudok.app.repository.state.State;
import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.workspace.slot.CircleSlot;
import dsw.rudok.app.repository.workspace.slot.RectangleSlot;
import dsw.rudok.app.repository.workspace.slot.Slot;
import dsw.rudok.app.repository.workspace.slot.TriangleSlot;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;

public class ResizeState extends State {
    private Page mediator;

    public ResizeState(Page page) {
        this.mediator=page;

    }

    @Override
    public void mousePressed(MouseEvent e) {

        getSlotHandler().resizeSlot(mediator, e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        getSlotHandler().resizeSlot2(mediator, e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
