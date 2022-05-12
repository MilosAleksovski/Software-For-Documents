package dsw.rudok.app.gui.swing.stablo.controller;

import dsw.rudok.app.gui.swing.stablo.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.gui.swing.view.RuView;
import dsw.rudok.app.gui.swing.view.VratiGlavniFrame;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class RuTreeSelectionListener implements TreeSelectionListener {

    private RuView ruView;

    public RuTreeSelectionListener(){
        ruView = new VratiGlavniFrame();
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {

        TreePath path = e.getPath();
        RuTreeItem treeItemSelected = (RuTreeItem)path.getLastPathComponent();
        String ime = treeItemSelected.getName();
        ruView.vratiGlavniFrame().getTree().isSelected(path);


//        System.out.println("Naziv cvora:"+ treeItemSelected.getName());
//        System.out.println("putanja: "+e.getPath());




    }

}
