package dsw.rudok.app.gui.swing.controllers;

import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.Page;

import java.awt.event.ActionEvent;

public class NewBoldAction extends AbstractRuDokAction {

    public NewBoldAction() {

        putValue(NAME, "Bold text");
        putValue(SHORT_DESCRIPTION, "Bold text");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
