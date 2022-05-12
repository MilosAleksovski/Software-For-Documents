package dsw.rudok.app.gui.swing.controllers;

import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.Project;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickListener implements MouseListener {

    private static ClickListener instance = null;

    private ClickListener(){

    }

    public static ClickListener getClickListener(){
        if(instance == null){
            instance = new ClickListener();
        }
        return instance;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2 && GlavniFrame.getInstance().getTree().selectedItem() instanceof Project){
            RuNode ruNode = GlavniFrame.getInstance().getTree().selectedItem();
            ruNode.notifySubscribersDoubleKlik(ruNode);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
