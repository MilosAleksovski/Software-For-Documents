package dsw.rudok.app.gui.swing.controllers;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.ErrorHandler.ErrorTypes;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.repository.workspace.Document;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.Project;
import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.event.ActionEvent;

public class NewSlotAction extends AbstractRuDokAction{
    public NewSlotAction() {

        putValue(SMALL_ICON, loadIcon("slike/dodajSlot.png"));
        putValue(NAME, "New Slot");
        putValue(SHORT_DESCRIPTION, "New Slot");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(GlavniFrame.getInstance().getTree().selectedPath()==null)
            AppCore.getInstance().getErrHandler().generateError(ErrorTypes.SELECTIONERROR);
        else {
            RuNode selected = GlavniFrame.getInstance().getTree().selectedItem();
            if (selected instanceof Slot || selected instanceof Project || selected instanceof Document)
                AppCore.getInstance().getErrHandler().generateError(ErrorTypes.ACTIONERROR);
            else {
               // GlavniFrame.getInstance().getTree().addSlot();
            }
        }
    }
}

