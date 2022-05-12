package dsw.rudok.app.gui.swing.view.repositoryMainFrame;

import dsw.rudok.app.gui.swing.observerMainPanel.Publisher;
import dsw.rudok.app.gui.swing.observerMainPanel.Subscriber;
import dsw.rudok.app.gui.swing.stablo.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.repository.updateEvent.UpdateEvent;
import dsw.rudok.app.repository.workspace.Document;
import dsw.rudok.app.repository.workspace.Project;
import dsw.rudok.app.repository.workspace.Workspace;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProjectView extends JPanel implements Subscriber, Serializable {

    private Project project;
    private List<DocumentView> listaDokumenata;
    private static long serialVersionUID = 4L;

    public ProjectView(Project project) {
        this.project = project;
        project.addSubscriber(this);
        listaDokumenata = new ArrayList<>();

    }

     public void dodajTab(Document document){

         DocumentView documentView = new DocumentView(document);
         listaDokumenata.add(documentView);
         if(GlavniFrame.getInstance().getNaslov().getText().equals(GlavniFrame.getInstance().getTree().selectedItem().getName()))
             GlavniFrame.getInstance().getjTabbedPane().addTab(documentView.getImeDokumenta(), documentView);

    }

    public void izbrisiTab(Document document){

        for (DocumentView documentView : listaDokumenata) {
                if (documentView.getDocument().equals(document)) {
                    if (GlavniFrame.getInstance().getNaslov().getText().equals(project.getName())) {
                        System.out.println("Izbrisi tab IF");
                        GlavniFrame.getInstance().getjTabbedPane().remove(documentView);
                    }

                    listaDokumenata.remove(documentView);
                    return;
                }
            }


    }

    //Dvoklikom na projekat brisu se otvoreni tabovi sa desne strane i dodaju se tabovi iz dvokliknutog projekta

     public void dvoklik(){

         GlavniFrame.getInstance().getNaslov().setText(project.getName());
         GlavniFrame.getInstance().getjTabbedPane().removeAll();
         for(DocumentView documentView: listaDokumenata){

             GlavniFrame.getInstance().getjTabbedPane().addTab(documentView.getDocument().getName(), documentView);

         }

     }

     //Brisanjem projekta brisu se svi otvoreni tabovi sa desne strane

     public void izbrisiProjekat(){
        if(GlavniFrame.getInstance().getNaslov().getText().equals(GlavniFrame.getInstance().getTree().selectedItem().getName())) {
            GlavniFrame.getInstance().getjTabbedPane().removeAll();
            GlavniFrame.getInstance().getNaslov().setText("");
        }
     }

    // Ako je projekat kome se deli dokument otvoren sa desne strane automatski se dodaje novi tab, ukoliko nije tab se dodaje
    // u listu docView-a .

     public void copyPaste(DocumentView documentView){

         listaDokumenata.add(documentView);
         if(GlavniFrame.getInstance().getNaslov().getText().equals(GlavniFrame.getInstance().getTree().selectedItem().getName())){
             GlavniFrame.getInstance().getjTabbedPane().addTab(documentView.getDocument().getName(), documentView);
         }
     }


    @Override
    public void updateDodavanje(Publisher publisher) {

            Document document = (Document) publisher;
            dodajTab(document);

    }

    @Override
    public void updateBrisanje(Publisher publisher) {

            if(publisher instanceof Document){
                Document document = (Document)publisher;
                izbrisiTab(document);
            }
            else{
                izbrisiProjekat();
            }

    }

    //Rename

    @Override
    public void updateIme(Publisher publisher) {
        if(project.getName().equals(GlavniFrame.getInstance().getNaslov().getText())) {

            if (publisher instanceof Document) {
                Document document = (Document) publisher;
                int i = 0;
                for (DocumentView documentView : listaDokumenata) {
                    if (documentView.getDocument().equals(document)) {
                        GlavniFrame.getInstance().getjTabbedPane().setTitleAt(i, document.getName());
                        return;
                    }
                    i++;
                }
            }
        }
        if (publisher instanceof Document) {
            Document document = (Document) publisher;
            if( document.getParent().getName().equals(GlavniFrame.getInstance().getNaslov().getText())){
                int i = 0;
                for (DocumentView documentView : listaDokumenata) {
                    if (documentView.getDocument().equals(document)) {
                        GlavniFrame.getInstance().getjTabbedPane().setTitleAt(i, document.getName());
                        return;
                    }
                    i++;
                }
            }
        }

        if(publisher instanceof Project){
            Project project = (Project) publisher;
            GlavniFrame.getInstance().getNaslov().setText(project.getName());
        }


    }

    @Override
    public void updateDoubleCLick(Publisher publisher) {
        dvoklik();
    }

    @Override
    public void updatePerformed(UpdateEvent e) {

    }


    public Project getProject() {
        return project;
    }

}


