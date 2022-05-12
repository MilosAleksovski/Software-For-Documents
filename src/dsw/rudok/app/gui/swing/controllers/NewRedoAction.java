package dsw.rudok.app.gui.swing.controllers;

import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.Page;

import java.awt.event.ActionEvent;

public class NewRedoAction extends AbstractRuDokAction {
    public NewRedoAction() {
        putValue(SMALL_ICON, loadIcon("slike/reedo.png"));
        putValue(NAME, "Redo");
        putValue(SHORT_DESCRIPTION, "Redo");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RuNode selected = GlavniFrame.getInstance().getTree().selectedItem();
        Page page = (Page) selected;
        page.getCommandManager().doCommand();
    }
}