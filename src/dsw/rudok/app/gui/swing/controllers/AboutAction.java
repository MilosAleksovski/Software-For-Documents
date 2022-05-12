package dsw.rudok.app.gui.swing.controllers;

import dsw.rudok.app.gui.swing.view.AboutPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AboutAction extends AbstractRuDokAction {
    public AboutAction() {

        putValue(SMALL_ICON, loadIcon("slike/about.png"));
        putValue(NAME, "About us");
        putValue(SHORT_DESCRIPTION, "About us");
    }

    public void actionPerformed(ActionEvent arg0) {
        AboutPanel aboutPanel = new AboutPanel();

        aboutPanel.setVisible(true);

    }
}
