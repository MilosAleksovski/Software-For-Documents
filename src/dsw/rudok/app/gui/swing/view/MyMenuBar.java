package dsw.rudok.app.gui.swing.view;

import javax.swing.*;
import java.awt.event.KeyEvent;


public class MyMenuBar extends JMenuBar {

    public MyMenuBar(){
        JMenu jMenu = new JMenu("File");

        jMenu.add(GlavniFrame.getInstance().getActionManager().getNewProjectAction());
        jMenu.add(GlavniFrame.getInstance().getActionManager().getDocnew());
        jMenu.add(GlavniFrame.getInstance().getActionManager().getPagenew());
        jMenu.add(GlavniFrame.getInstance().getActionManager().getSltnew());
        jMenu.add(GlavniFrame.getInstance().getActionManager().getDeleteAction());
        jMenu.add(GlavniFrame.getInstance().getActionManager().getExitAction());

        this.add(jMenu);

        JMenu jMenu2 = new JMenu("Help");
        jMenu2.add(GlavniFrame.getInstance().getActionManager().getAboutAction());
        this.add(jMenu2);


    }

}
