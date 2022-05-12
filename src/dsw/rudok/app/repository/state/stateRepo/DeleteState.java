package dsw.rudok.app.repository.state.stateRepo;

import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.repository.SlotHandler.SlotHandler;
import dsw.rudok.app.repository.SlotHandler.SlotHandlerImpl;
import dsw.rudok.app.repository.state.State;
import dsw.rudok.app.repository.workspace.Page;

import java.awt.event.MouseEvent;

public class DeleteState extends State {

    private Page mediator;

    public DeleteState(Page page) {
        this.mediator=page;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        getSlotHandler().deleteSlot(mediator, e);
    }
}

