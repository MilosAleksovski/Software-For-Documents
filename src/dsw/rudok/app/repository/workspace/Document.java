package dsw.rudok.app.repository.workspace;

import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.Node.RuNodeComposte;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Document extends RuNodeComposte implements Serializable {

    private static int documentCounter=1;
    private List<Page> listaStranica = new ArrayList<>();

    public Document(String name, RuNode parent) {
        super(name, parent);
    }
    @Override
    public void addChild(RuNode child) {
        if(child != null  && child instanceof Page)
        {
            Page page=(Page) child;
            if(!this.getChildren().contains(page)) {
                this.getChildren().add(page);
                listaStranica.add(page);
                notifySubscribersDodavanje(child);
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void removeChild(RuNode child) {
        if(child != null && child instanceof Page){
            this.getChildren().remove(child);
            this.notifySubscribersBrisanje(child);

        }
    }

    public static int getDocumentCounter() {
        return documentCounter++;
    }
}