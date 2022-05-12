package dsw.rudok.app.repository.workspace;

import dsw.rudok.app.commands.CommandMenager;
import dsw.rudok.app.gui.swing.view.painters.*;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.Node.RuNodeComposte;
import dsw.rudok.app.repository.PageModel;
import dsw.rudok.app.repository.SlotHandler.SlotHandler;
import dsw.rudok.app.repository.SlotHandler.SlotHandlerImpl;
import dsw.rudok.app.repository.state.StateManager;
import dsw.rudok.app.repository.workspace.slot.RectangleSlot;
import dsw.rudok.app.repository.workspace.slot.Slot;
import dsw.rudok.app.repository.workspace.slot.TriangleSlot;

import javax.swing.event.EventListenerList;
import java.io.Serializable;

public class Page extends RuNodeComposte implements Serializable {
    private static int pageCounter=1;
    private PageModel pModel=new PageModel();
    private static Slot selektovaniSlot = null;
    private CommandMenager commandManager;
    private StateManager stateManager = new StateManager(this);
    private static final long serialVersionUID = 4L;



    public void startCircleState() { stateManager.setCircleState(); }
    public void startSelectState() { stateManager.setSelectState(); }
    public void startRectangleState(){ stateManager.setRectangleState();}
    public void startRotateState2(){stateManager.setRotate2State();}
    public void startTriangleState(){stateManager.setTriangleState();}
    public void startDeleteState(){
        stateManager.setDeleteState();
    }

    public void startRotateState(){
        stateManager.setRotateState();
        stateManager.getCurrentState().mousePressed(null);
    }
    public void startMoveState(){
        stateManager.setMoveState();
        moveEdit();
    }
    public void startResizeState(){
        stateManager.setResizeState();
        resizeEdit();
    }


    public Page(String name, RuNode parent) {

        super(name, parent);
        commandManager = new CommandMenager();
    }

    public void setSelektovaniSlot(Slot selektovaniSlot) {
        this.selektovaniSlot = selektovaniSlot;
    }

    public Slot getSelektovaniSlot() {
        return selektovaniSlot;
    }

    @Override
    public void addChild(RuNode child) {
        if(child != null  && child instanceof Slot)
        {
            Slot slt=(Slot) child;
            if(!this.getChildren().contains(slt)) {
                this.getChildren().add(slt);
            }
        }
    }

    @Override
    public void removeChild(RuNode Child) {
        if(Child != null && Child instanceof Slot){
            this.getChildren().remove(Child);
        }
    }

    public void moveEdit(){
        if (pModel.getSlotovi() == null) {
            return;
        }
        for(Slot slot : pModel.getSlotovi()) {

            if (slot == null) return;

            if (slot.getElementPainter() instanceof SelectRectanglePainter) {
                slot.napraviNoviRPainter();
                pModel.fireUpdatePerformed();
            }
            if (slot.getElementPainter() instanceof SelectTrianlgePainter) {
                slot.napraviNoviTPainter();
                pModel.fireUpdatePerformed();
            }
            if (slot.getElementPainter() instanceof SelectRotatePainter) {
                if (slot instanceof RectangleSlot || slot instanceof TriangleSlot) {
                    slot.napraviNoviRotatePainter2(slot);
                    pModel.fireUpdatePerformed();
                }

            }
        }
    }
    public void resizeEdit() {
        if (pModel.getSlotovi() == null) {
            return;
        } else {
            for (Slot s : pModel.getSlotovi()) {

                selektovaniSlot = s;
                pModel.obrisiElementIzListe(selektovaniSlot);
                if (selektovaniSlot.getElementPainter() instanceof RectanglePainter) {
                    selektovaniSlot.selektovaniRPainter();
                } else if (selektovaniSlot.getElementPainter() instanceof TrianglePainter) {
                    selektovaniSlot.selektovaniTPainter();
                } else if (selektovaniSlot.getElementPainter() instanceof RotatePainter) {
                    selektovaniSlot.selektovaniRotatePainter(selektovaniSlot);
                }

                pModel.dodajElementUListu(selektovaniSlot);

            }
        }
    }

    public static int getPageCounter() {
        return pageCounter++;
    }
    public StateManager getStateManager() {
        return stateManager;
    }

    public PageModel getpModel() {
        return pModel;
    }

    public CommandMenager getCommandManager() {
        return commandManager;
    }
}
