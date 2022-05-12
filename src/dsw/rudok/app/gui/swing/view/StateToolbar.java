package dsw.rudok.app.gui.swing.view;

import javax.swing.*;

public class StateToolbar extends JToolBar {
    private JLabel label;
    public StateToolbar() {
        super(VERTICAL);
        setFloatable(false);
        label=new JLabel("State: ");
        add("State",label);
        add(GlavniFrame.getInstance().getActionManager().getNewSelectionAction());
        add(GlavniFrame.getInstance().getActionManager().getNewMove());
        add(GlavniFrame.getInstance().getActionManager().getNewResizeAction());
        add(GlavniFrame.getInstance().getActionManager().getNewTriangleAction());
        add(GlavniFrame.getInstance().getActionManager().getNewCircleAction());
        add(GlavniFrame.getInstance().getActionManager().getNewRectangleAction());
        add(GlavniFrame.getInstance().getActionManager().getNewRotateAction2());
        add(GlavniFrame.getInstance().getActionManager().getNewRotateAction());
        add(GlavniFrame.getInstance().getActionManager().getNewDeleteAction2());
    }
}
