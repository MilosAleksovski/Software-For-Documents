package dsw.rudok.app.gui.swing.controllers;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.ErrorHandler.ErrorTypes;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.Document;
import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.workspace.Project;
import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.event.ActionEvent;

public class NewProjectAction extends AbstractRuDokAction {


    public NewProjectAction() {

        putValue(SMALL_ICON, loadIcon("slike/dodaj.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "New Project");
    }

    public void actionPerformed(ActionEvent arg0) {
        if(GlavniFrame.getInstance().getTree().isWorkspaceSelected()) {
            RuNode selected=GlavniFrame.getInstance().getTree().selectedItem();
            if (selected instanceof Document || selected instanceof Page || selected instanceof Slot || selected instanceof Project)
                AppCore.getInstance().getErrHandler().generateError(ErrorTypes.ACTIONERROR);
            else {
                GlavniFrame.getInstance().getTree().addProject();
            }
        }
        else {
            AppCore.getInstance().getErrHandler().generateError(ErrorTypes.WORKSPACENOTSELECTED);
        }
    }
}
