package dsw.rudok.app.gui.swing.controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ExitAction extends AbstractRuDokAction {
    public ExitAction() {

        putValue(SMALL_ICON, loadIcon("slike/izadji.png"));
        putValue(NAME, "Exit");
        putValue(SHORT_DESCRIPTION, "Exit");

    }

    public void actionPerformed(ActionEvent arg0) {
        System.exit(0);
    }
}
