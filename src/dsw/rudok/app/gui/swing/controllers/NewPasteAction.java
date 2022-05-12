package dsw.rudok.app.gui.swing.controllers;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.ErrorHandler.ErrorTypes;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.Document;
import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.workspace.Project;

import java.awt.event.ActionEvent;

public class NewPasteAction extends AbstractRuDokAction {
    public NewPasteAction(){
        putValue(SMALL_ICON, loadIcon("slike/paste.png"));
        putValue(NAME, "Paste");
        putValue(SHORT_DESCRIPTION, "Paste");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(GlavniFrame.getInstance().getTree().selectedPath()==null)
        {
            AppCore.getInstance().getErrHandler().generateError(ErrorTypes.SELECTIONERROR);
        }
        else {
            RuNode selected = GlavniFrame.getInstance().getTree().selectedItem();
            if (selected instanceof Project) {
                GlavniFrame.getInstance().paste();
            } else {
                AppCore.getInstance().getErrHandler().generateError(ErrorTypes.DOCUMENTERROR, selected);
            }
        }
    }
}
