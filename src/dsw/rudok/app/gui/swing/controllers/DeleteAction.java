package dsw.rudok.app.gui.swing.controllers;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.ErrorHandler.ErrorTypes;
import dsw.rudok.app.gui.swing.view.GlavniFrame;

import java.awt.event.ActionEvent;

public class DeleteAction extends AbstractRuDokAction {


    public DeleteAction() {

        putValue(SMALL_ICON, loadIcon("slike/brisanje.png"));
        putValue(NAME, "Delete document");
        putValue(SHORT_DESCRIPTION, "Delete document");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(GlavniFrame.getInstance().getTree().selectedPath()!=null)
            GlavniFrame.getInstance().getTree().Delete();
        else
            AppCore.getInstance().getErrHandler().generateError(ErrorTypes.SELECTIONERROR);
    }
}
