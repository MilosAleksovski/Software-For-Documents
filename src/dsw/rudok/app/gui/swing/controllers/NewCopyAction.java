package dsw.rudok.app.gui.swing.controllers;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.ErrorHandler.ErrorTypes;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.repository.workspace.Document;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.Project;

import java.awt.event.ActionEvent;

public class NewCopyAction extends AbstractRuDokAction{


    public NewCopyAction(){
        putValue(SMALL_ICON, loadIcon("slike/copy.png"));
        putValue(NAME, "Copy");
        putValue(SHORT_DESCRIPTION, "Copy");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(GlavniFrame.getInstance().getTree().selectedPath()==null)
        {
            AppCore.getInstance().getErrHandler().generateError(ErrorTypes.SELECTIONERROR);
        }else{
            RuNode selected=GlavniFrame.getInstance().getTree().selectedItem();
            if(selected instanceof Document) {
                GlavniFrame.getInstance().kopirajDokument();
            }
            else
            {
                AppCore.getInstance().getErrHandler().generateError(ErrorTypes.DOCUMENTERROR,selected);
            }
        }
    }
}
