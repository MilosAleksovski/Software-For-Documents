package dsw.rudok.app.gui.swing.stablo.model;

import dsw.rudok.app.repository.workspace.Document;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.Node.RuNodeComposte;
import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.workspace.slot.Slot;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Iterator;

public class RuTreeItem extends DefaultMutableTreeNode {

    private String name;
    private RuNode node;

    public RuTreeItem(String name, RuNode node) {
        this.name = name;
        this.node = node;
    }

    public RuTreeItem(RuNode node) {
        this.node = node;
        this.name=node.getName();
    }

    @Override
    public boolean isLeaf() {
        if(node instanceof RuNodeComposte)
            return false;
        return true;
    }

    @Override
    public String toString() {

        return name;
    }
    public RuTreeItem findByName(String name){

        Iterator iterator = children.iterator();
        while(iterator.hasNext()){
            RuTreeItem current = (RuTreeItem) iterator.next();
            if(current.getNode().getName().equals(name)){
                return  current;
            }

        }
        return  null;

    }

    /*Geteri i seteri*/

    public String getName() {
        return name;
    }
    public RuNode getNode() {
        return node;
    }


    //Prilikom promene imena RuTree-itemu menjau se imena svim RuTree itemima koji imaju isti Node
    //RuTree item-i imaju isti node jedino ako pripadaju podeljenom dokumentu
    //Ukoliko korisnik menja ime podeljenom dokumentu, a ne stavi zvezdicu automatski se stavljaju zvezdice

    public void setName(String name) {

        RuTreeItem root = (RuTreeItem) this.getRoot();
        String ime = this.getName();

        if(this.getNode() instanceof Page){
            for(int i = 0; i < root.getChildCount(); i++){
                RuTreeItem projekat = (RuTreeItem) root.getChildAt(i);
                for(int j = 0; j < projekat.getChildCount(); j++){
                    RuTreeItem dokument = (RuTreeItem) projekat.getChildAt(j);
                    for(int k = 0; k < dokument.getChildCount(); k++ ){
                        RuTreeItem page = (RuTreeItem) dokument.getChildAt(k);
                        if(page.getNode().equals(this.getNode())){
                            page.setName2(name);
                        }
                    }
                }
            }
            return;
        }


        if(this.getNode() instanceof Document){
            int brojac = 0;

            for(int i = 0; i < root.getChildCount(); i++){
                RuTreeItem projekat = (RuTreeItem) root.getChildAt(i);
                for(int j = 0; j < projekat.getChildCount(); j++){
                    RuTreeItem dokument = (RuTreeItem) projekat.getChildAt(j);
                    if(this.node.equals(dokument.getNode())){
                        brojac++;
                    }
                }
            }

            for(int i = 0; i < root.getChildCount(); i++){
                RuTreeItem projekat = (RuTreeItem) root.getChildAt(i);
                for(int j = 0; j < projekat.getChildCount(); j++){
                    RuTreeItem dokument = (RuTreeItem) projekat.getChildAt(j);
                    if(this.node.equals(dokument.getNode())){
                        if(brojac > 1){
                            if(!name.contains("**")){
                                name = name + "**";
                            }
                        }
                        dokument.setName2(name);

                    }
                }
            }
            return;
        }

        if(this.getNode() instanceof Slot){
            for(int i = 0; i < root.getChildCount(); i++){
                RuTreeItem projekat = (RuTreeItem) root.getChildAt(i);
                for(int j = 0; j < projekat.getChildCount(); j++){
                    RuTreeItem dokument = (RuTreeItem) projekat.getChildAt(j);
                    for(int k = 0; k < dokument.getChildCount(); k++ ){
                        RuTreeItem page = (RuTreeItem) dokument.getChildAt(k);
                        for(int m = 0; m < page.getChildCount(); m++){
                            RuTreeItem slot = (RuTreeItem) page.getChildAt(m);
                            if(slot.getNode().equals(this.getNode())){
                                slot.setName2(name);
                            }
                        }
                    }
                }
            }
            return;
        }


        this.name = name;

    }
    public void setName2(String name){
        this.name = name;
    }
    public void setNode(RuNode node) {
        this.node = node;
    }
}
