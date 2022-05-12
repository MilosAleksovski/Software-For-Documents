package dsw.rudok.app.gui.swing.controllers;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.ErrorHandler.ErrorTypes;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.repository.workspace.Document;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.workspace.Workspace;
import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.event.ActionEvent;

public class NewDocumentAction extends AbstractRuDokAction {

    public NewDocumentAction() {

        putValue(SMALL_ICON, loadIcon("slike/dodajDoc.png"));
        putValue(NAME, "New Document");
        putValue(SHORT_DESCRIPTION, "New Document");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(GlavniFrame.getInstance().getTree().selectedPath()==null)
            AppCore.getInstance().getErrHandler().generateError(ErrorTypes.SELECTIONERROR);
        else {
            RuNode selected = GlavniFrame.getInstance().getTree().selectedItem();
            if (selected instanceof Document || selected instanceof Page || selected instanceof Slot|| selected instanceof Workspace)
                AppCore.getInstance().getErrHandler().generateError(ErrorTypes.ACTIONERROR);
            else {
                GlavniFrame.getInstance().getTree().addDocument();
            }
        }
    }
}
