package dsw.rudok.app.gui.swing.controllers;

import dsw.rudok.app.commands.AddDeviceComand;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.gui.swing.view.repositoryMainFrame.PageView;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.Page;

import java.awt.event.ActionEvent;

public class NewUndoAction extends AbstractRuDokAction {
    public NewUndoAction() {
        putValue(SMALL_ICON, loadIcon("slike/undo.png"));
        putValue(NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "Undo");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RuNode selected = GlavniFrame.getInstance().getTree().selectedItem();
        Page page = (Page) selected;
        page.getCommandManager().undoCommand();

    }
}