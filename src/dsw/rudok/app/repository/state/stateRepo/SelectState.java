package dsw.rudok.app.repository.state.stateRepo;

import dsw.rudok.app.commands.CommandObserver.CommandSubscriber;
import dsw.rudok.app.repository.SlotHandler.SlotHandler;
import dsw.rudok.app.repository.SlotHandler.SlotHandlerImpl;
import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.state.State;

import java.awt.event.MouseEvent;

public class SelectState extends State {
    private Page mediator;

    public SelectState(Page page) {
        this.mediator=page;

    }
    @Override
    public void mousePressed(MouseEvent e) { getSlotHandler().setStartcord(e,mediator); }
    @Override
    public void mouseDragged(MouseEvent e) {
        getSlotHandler().setEndCord(mediator,e);
    }
    public void mouseReleased(MouseEvent e) {
        getSlotHandler().setEndCord2(mediator,e);
    }



    public String toString()
    {
        return "Select state";
    }
}