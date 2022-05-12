package dsw.rudok.app.repository.workspace;

import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.Node.RuNodeComposte;
import dsw.rudok.app.repository.workspace.Project;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Workspace extends RuNodeComposte implements Serializable {


    private File projectFile;
    private transient boolean changed;
    private static final long serialVersionUID = 4L;

    public Workspace(String name) {
        super(name,null);
        projectFile = null;
        changed = false;
    }

    @Override
    public void addChild(RuNode child) {
        if(child != null  && child instanceof Project)
        {
            Project project=(Project) child;
            if(!this.getChildren().contains(project)) {
                this.getChildren().add(project);

            }
        }
    }

    @Override
    public void removeChild(RuNode Child) {
        RuNode selectednode = GlavniFrame.getInstance().getTree().selectedItem();
        if(Child != null && Child instanceof Project){
            System.out.println("USAO U REMOVE CHILD");
            this.getChildren().remove(Child);
            this.notifySubscribersBrisanje(Child);
        }
    }

    public File getProjectFile() {
        return projectFile;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

}