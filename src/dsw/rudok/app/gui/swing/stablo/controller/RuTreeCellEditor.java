package dsw.rudok.app.gui.swing.stablo.controller;


import dsw.rudok.app.gui.swing.stablo.model.RuTreeItem;

import dsw.rudok.app.gui.swing.view.RuView;
import dsw.rudok.app.gui.swing.view.VratiGlavniFrame;
import dsw.rudok.app.repository.workspace.*;
import dsw.rudok.app.repository.workspace.slot.Slot;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class RuTreeCellEditor extends DefaultTreeCellEditor implements ActionListener{
    private Object klik =null;
    private JTextField edit=null;
    private RuView ruView = new VratiGlavniFrame();

    public RuTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {

        super(tree, renderer);
    }

    public Component getTreeCellEditorComponent(JTree tree, Object obj, boolean a1, boolean a3, boolean a4, int arg5) {

        klik =obj;
        edit=new JTextField(obj.toString());
        edit.addActionListener(this);
        return edit;
    }

    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent)
            if (((MouseEvent)arg0).getClickCount()==3){
                return true;
            }else if(((MouseEvent)arg0).getClickCount()==2){
                if(ruView.vratiGlavniFrame().getTree().selectedItem() instanceof Project){


                }
            }
        return false;
    }

    public void actionPerformed(ActionEvent e){


        if (!(klik instanceof RuTreeItem))
            return;

        RuTreeItem clicked = (RuTreeItem) klik;

        if (clicked.getNode() instanceof Workspace){
            clicked.setName(e.getActionCommand());
            (clicked.getNode()).setName(e.getActionCommand());
        }
        else if(clicked.getNode() instanceof Project){
            clicked.setName(e.getActionCommand());
            ( clicked.getNode()).setName(e.getActionCommand());
        }
        else if(clicked.getNode() instanceof Document){

            clicked.setName(e.getActionCommand());

            ( clicked.getNode()).setName(clicked.getName());
        }
        else if(clicked.getNode() instanceof Page){
            clicked.setName(e.getActionCommand());
            ( clicked.getNode()).setName(e.getActionCommand());
        }
        else if(clicked.getNode() instanceof Slot){

            clicked.setName(e.getActionCommand());
            ( clicked.getNode()).setName(e.getActionCommand());
        }

        clicked.setName(e.getActionCommand());





    }



}
