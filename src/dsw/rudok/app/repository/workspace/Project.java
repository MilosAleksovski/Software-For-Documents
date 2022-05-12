package dsw.rudok.app.repository.workspace;

import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.Node.RuNodeComposte;
import dsw.rudok.app.repository.workspace.Document;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Project extends RuNodeComposte implements Serializable {

    public static int projectCounter=1;
    private File projectFile;
    private transient boolean changed;
    private List<Document> listDokumenata = new ArrayList<>();



    public Project(String name, RuNode parent) {

        super(name, parent);
        this.projectFile = null;
        this.changed=false;
    }

    @Override
    public void addChild(RuNode child) {
        if(child != null  && child instanceof Document)
        {
            Document doc=(Document) child;
            if(!this.getChildren().contains(doc)) {
                getChildren().add(doc);
                listDokumenata.add(doc);
                notifySubscribersDodavanje(child);
            }
        }


    }

    @Override
    public void removeChild(RuNode Child) {

        if(Child != null && Child instanceof Document){

            this.getChildren().remove(Child);
            this.notifySubscribersBrisanje(Child);
        }

    }
    public static int getProjectCounter() {
        return projectCounter++;
    }

    public File getProjectFile() {
        return projectFile;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
    }
}