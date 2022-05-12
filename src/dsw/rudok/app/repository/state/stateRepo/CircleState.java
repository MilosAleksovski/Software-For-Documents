package dsw.rudok.app.repository.state.stateRepo;

import dsw.rudok.app.repository.SlotFactory.CircleFactory;
import dsw.rudok.app.repository.SlotFactory.RectangleFactory;
import dsw.rudok.app.repository.SlotFactory.SlotFactory;
import dsw.rudok.app.repository.SlotHandler.SlotHandler;
import dsw.rudok.app.repository.SlotHandler.SlotHandlerImpl;
import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.state.State;

import java.awt.event.MouseEvent;

public class CircleState extends State {
    private Page mediator;

    public CircleState(Page page)
    {
        this.mediator=page;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        getSlotHandler().napraviSlot(e.getPoint(),"circle", mediator);
    }
    public String toString()
    {
        return "Circle state";
    }
}
