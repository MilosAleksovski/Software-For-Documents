package dsw.rudok.app.repository.state.stateRepo;

import dsw.rudok.app.gui.swing.view.painters.CirclePainter;
import dsw.rudok.app.gui.swing.view.painters.ElementPainter;
import dsw.rudok.app.gui.swing.view.painters.RectanglePainter;
import dsw.rudok.app.gui.swing.view.painters.TrianglePainter;
import dsw.rudok.app.repository.SlotHandler.SlotHandler;
import dsw.rudok.app.repository.SlotHandler.SlotHandlerImpl;
import dsw.rudok.app.repository.state.State;
import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.workspace.slot.CircleSlot;
import dsw.rudok.app.repository.workspace.slot.RectangleSlot;
import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;



public class MoveState extends State {
    private Page mediator;

    public MoveState(Page page) {
        this.mediator=page;
    }
    @Override
    public void mousePressed(MouseEvent e) {
          getSlotHandler().moveSlot(mediator, e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        getSlotHandler().moveSlot2(mediator, e);
    }
}
