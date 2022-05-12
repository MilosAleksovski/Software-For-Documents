package dsw.rudok.app.repository.state.stateRepo;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.ErrorHandler.ErrorTypes;
import dsw.rudok.app.repository.SlotHandler.SlotHandler;
import dsw.rudok.app.repository.SlotHandler.SlotHandlerImpl;
import dsw.rudok.app.repository.state.State;
import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.workspace.slot.CircleSlot;
import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.event.MouseEvent;

public class RotateState extends State {

    private Page mediator;

    public RotateState(Page mediator) {
        this.mediator = mediator;
    }

    public void mousePressed(MouseEvent e) {
        if(mediator.getSelektovaniSlot()!=null)
        {
            if(mediator.getSelektovaniSlot() instanceof CircleSlot)
            {
                AppCore.getInstance().getErrHandler().generateError(ErrorTypes.ROTATECIRCLEERROR);
            }
            else {
                getSlotHandler().rotateSlot(mediator);
            }
        }
    }
}
