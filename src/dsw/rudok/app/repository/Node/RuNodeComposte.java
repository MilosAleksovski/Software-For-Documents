package dsw.rudok.app.repository.Node;

import dsw.rudok.app.gui.swing.observerMainPanel.Publisher;
import dsw.rudok.app.gui.swing.view.GlavniFrame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class RuNodeComposte extends RuNode implements Serializable {
    List<RuNode> children;
    static GlavniFrame subscriber;

    public RuNodeComposte(String name, RuNode parent) {
        super(name, parent);
        this.children=new ArrayList<>();
    }

    public RuNodeComposte(String name, RuNode parent, List<RuNode> children) {
        super(name, parent);
        this.children = children;
    }

    public abstract void addChild(RuNode child);

    public abstract void removeChild(RuNode Child);



    public RuNode getChildByName(String name)
    {
        for(RuNode child: this.getChildren())
            if(name.equals(child.getName()))
                return child;
    return null;
    }


    /*Geteri i seteri*/

    public List<RuNode> getChildren() {

        return children;
    }

    @Override
    public String toString() {
        return "RuNodeComposte{" +
                "children=" + children +
                '}';
    }


}
