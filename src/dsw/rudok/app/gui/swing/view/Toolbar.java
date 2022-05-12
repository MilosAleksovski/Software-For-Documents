package dsw.rudok.app.gui.swing.view;

import javax.swing.*;

public class Toolbar extends JToolBar {
    public Toolbar(){
        super(HORIZONTAL);
        setFloatable(false);

        add(GlavniFrame.getInstance().getActionManager().getNewProjectAction());
        add(GlavniFrame.getInstance().getActionManager().getDocnew());
        add(GlavniFrame.getInstance().getActionManager().getPagenew());
        add(GlavniFrame.getInstance().getActionManager().getDeleteAction());
        add(GlavniFrame.getInstance().getActionManager().getAboutAction());
        add(GlavniFrame.getInstance().getActionManager().getExitAction());
        add(GlavniFrame.getInstance().getActionManager().getNewCopyAction());
        add(GlavniFrame.getInstance().getActionManager().getNewPasteAction());
        add(GlavniFrame.getInstance().getActionManager().getUndoAction());
        add(GlavniFrame.getInstance().getActionManager().getNewRedoAction());
        add(GlavniFrame.getInstance().getActionManager().getNewOpenAction());
        add(GlavniFrame.getInstance().getActionManager().getNewSaveProjectAction());
        add(GlavniFrame.getInstance().getActionManager().getNewOpenProjectAction());
        add(GlavniFrame.getInstance().getActionManager().getNewSwitch());

    }

}
