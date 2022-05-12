package dsw.rudok.app.repository.Node;

import dsw.rudok.app.gui.swing.observerMainPanel.Publisher;
import dsw.rudok.app.gui.swing.observerMainPanel.Subscriber;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.gui.swing.view.repositoryMainFrame.DocumentView;
import dsw.rudok.app.gui.swing.view.repositoryMainFrame.PageView;
import dsw.rudok.app.gui.swing.view.repositoryMainFrame.ProjectView;
import dsw.rudok.app.repository.workspace.Workspace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class RuNode implements Publisher, Serializable {

    private String name;
    private  RuNode parent;
    private  List<Subscriber> subscribers = new ArrayList<>();
    private static long serialVersionUID = 4L;

    public RuNode(String name, RuNode parent) {
        this.name = name;
        this.parent = parent;

    }



    @Override
    public boolean equals(Object o) {
        if(o!=null && o instanceof RuNode)
        {
            RuNode o2=(RuNode)o;
            return this.getName().equals(o2.getName());
        }
        return false;
    }

    /*Geteri i seteri*/
    public RuNode getParent() {

        return parent;
    }
    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.notifySubscribersRename(this);

    }

    @Override
    public void addSubscriber(Subscriber sub) {

        subscribers.add(sub);

    }

    @Override
    public void removeSubscriber(Subscriber sub) {

        for(Subscriber subscriber: subscribers){
            if(subscriber.equals(sub)){
                subscribers.remove(subscriber);
                return;
            }
        }
    }

    @Override
    public void notifySubscribersDodavanje(RuNode ruNode) {
        for(Subscriber subscriber: subscribers){

            if(subscriber instanceof ProjectView){
                ProjectView projectView = (ProjectView) subscriber;
                if(ruNode.getParent().equals(projectView.getProject())){
                       subscriber.updateDodavanje(ruNode);
                       return;
               }
            }

            if(subscriber instanceof DocumentView){
                DocumentView documentView = (DocumentView) subscriber;
                if(ruNode.getParent().equals(documentView.getDocument())){
                    subscriber.updateDodavanje(ruNode);
                    return;
                }
            }
        }


    }
    @Override
    public void notifySubscribersBrisanje(RuNode ruNode){

        for(Subscriber subscriber: subscribers){
            if(subscriber instanceof ProjectView){

                ProjectView projectView = (ProjectView) subscriber;
                if(ruNode.equals(projectView.getProject())){

                    subscriber.updateBrisanje(ruNode);
                    return;
                }
                else {
                    subscriber.updateBrisanje(ruNode);

                }
            }

           else if(subscriber instanceof DocumentView){
                DocumentView documentView = (DocumentView) subscriber;
                if(ruNode.getParent().equals(documentView.getDocument())){
                    subscriber.updateBrisanje(ruNode);
                    return;
                }
            }


        }
    }

    @Override
    public void notifySubscribersDoubleKlik(RuNode ruNode) {


        for(Subscriber subscriber: subscribers){

            if(subscriber instanceof ProjectView){
                ProjectView projectView = (ProjectView)subscriber;
                if(projectView.getProject().equals(ruNode)){
                    subscriber.updateDoubleCLick(ruNode);
                }
            }

        }
    }

    @Override
    public void notifySubscribersRename(RuNode ruNode) {
        if(ruNode instanceof Workspace)
            return;

        for(Subscriber subscriber: subscribers){
            if(subscriber instanceof ProjectView){
                ProjectView projectView = (ProjectView)subscriber;
                 if(this.equals(projectView.getProject())){
                    subscriber.updateIme(this);
                }
                 else {
                     subscriber.updateIme(this);
                 }
            }
            if(subscriber instanceof PageView){
                PageView pageView = (PageView)subscriber;
                if(this.equals(pageView.getPage())){
                    subscriber.updateIme(this);
                }

            }
        }
    }

    @Override
    public void notifySubscribersCopyPaste(RuNode ruNode) {
        DocumentView documentView;
        for(Subscriber subscriber:subscribers){
            if(subscriber instanceof DocumentView){
                documentView = (DocumentView)subscriber;
                if(ruNode.equals(documentView.getDocument())){
                    for(Subscriber subscriber2:subscribers){
                        if(subscriber2 instanceof ProjectView){
                            ProjectView projectView = (ProjectView)subscriber2;
                            if(projectView.getProject().equals(GlavniFrame.getInstance().getTree().selectedItem())){
                                projectView.copyPaste(documentView);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }



}
