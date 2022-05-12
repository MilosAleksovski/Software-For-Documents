package dsw.rudok.app.gui.swing.stablo.view;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.ErrorHandler.ErrorTypes;
import dsw.rudok.app.gui.swing.stablo.StatusLineObserver.StatusLineSubscriber;
import dsw.rudok.app.gui.swing.stablo.observerT.SubscriberT;
import dsw.rudok.app.gui.swing.stablo.RuStablo;
import dsw.rudok.app.gui.swing.stablo.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.gui.swing.view.repositoryMainFrame.ProjectView;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.*;
import dsw.rudok.app.repository.workspace.slot.Slot;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;

public class RuTreeImplementation implements RuStablo {
    private String imeDokumenta;
    private  int i = 0;
    private RuTreeView treeView;
    private DefaultTreeModel treeModel;
    List<SubscriberT> subscribers;
    List<StatusLineSubscriber> statusLineSubscribers;

    @Override
    public JTree generateTree(Workspace workspace) {
        RuTreeItem root = new RuTreeItem(workspace);
        treeModel = new DefaultTreeModel(root);
        treeView = new RuTreeView(treeModel);
        return treeView;
    }

    @Override
    public void updateTree(JTree jtree) {
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    //Metoda dodaj RuTreee pravi novi Rutree Item koji ima isti node kao i originalni dokument,
    //ukoliko dokument ima decu automatski se prave i novi RuTree item-i koj imaju iste node-ove kao i originalna deca
    //Nazivi originalnog i deljenog dokumenta se konkatuju sa (  **  )

    @Override
    public  void dodajRuTreee(Document document, Project project){
        RuTreeItem ruTreeItem = (RuTreeItem) treeModel.getRoot();
        RuTreeItem projekat = ruTreeItem.findByName(project.getName());
        RuTreeItem dokument = projekat.findByName(document.getName());


        if(!document.getName().contains("**")){
            i = 0;
        }

        if(i == 0){
            dokument.setName(document.getName()+"**");
            document.setName(document.getName()+"**");

            i++;
        }


        RuTreeItem noviDokument = new RuTreeItem(document);
        ((RuTreeItem)treeView.getLastSelectedPathComponent()).add(noviDokument);

        for(int i = 0;i < dokument.getChildCount(); i++){
            RuTreeItem novi = (RuTreeItem) dokument.getChildAt(i);
            RuTreeItem rez = new RuTreeItem(novi.getNode());
            noviDokument.add(rez);
            for(int j = 0; j < novi.getChildCount(); j++){
                RuTreeItem slot = (RuTreeItem) novi.getChildAt(j);
                rez.add(new RuTreeItem(slot.getNode()));
            }

        }


        treeView.expandPath(selectedPath());
        notifySubscribersT("Obavesti");


    }

    @Override
    public void addProject() {

        Project project = new Project("Projekat " + Project.getProjectCounter(), selectedItem());
        ProjectView projectView = new ProjectView(project);

        ((Workspace)selectedItem()).addChild(project);
        RuTreeItem root = (RuTreeItem) treeModel.getRoot();
        RuTreeItem projekat = new RuTreeItem(project);
        root.add(projekat);

        notifySubscribersT("Obavesti");
    }
    @Override
    public void addProject2(Project project) {

        RuTreeItem root = (RuTreeItem) treeModel.getRoot();
        RuTreeItem projekat = new RuTreeItem(project);
        root.add(projekat);

        notifySubscribersT("Obavesti");
    }

    @Override
    public void addDocument() {

        RuNode selectednode = selectedItem();

        Document document = new Document("Dokument " + Document.getDocumentCounter(), selectedItem());
        ((Project) selectednode).addChild(document);
        ((RuTreeItem)treeView.getLastSelectedPathComponent()).add(new RuTreeItem(document));
        treeView.expandPath(selectedPath());
        notifySubscribersT("Obavesti");
    }

    public Object vratiRoot(){
        notifySubscribersT("Obavesti");
        return treeModel.getRoot();
    }

    @Override
    public void addDocument2(Document document) {
        RuTreeItem rez = null;


        RuTreeItem root = (RuTreeItem) treeModel.getRoot();

        for(int i = 0; i < root.getChildCount(); i++){
            RuTreeItem projekat = (RuTreeItem) root.getChildAt(i);

            if(projekat.getNode().equals( document.getParent())){
                rez = projekat;
            }

        }

        rez.add(new RuTreeItem(document));
        treeView.expandPath(selectedPath());
        notifySubscribersT("Obavesti");
    }
    //Priliko pravlenja RuTree item-a za page, pravi se vise istih ukoliko page pripada podeljenom dokumentu



    @Override
    public void addPage() {


        Page p = new Page("Stranica " + Page.getPageCounter(),selectedItem());
        RuNode selectednode = selectedItem();
        ((Document) selectednode).addChild(p);
        treeView.expandPath(selectedPath());

        RuTreeItem root = (RuTreeItem) treeModel.getRoot();
        RuTreeItem doc = (RuTreeItem) treeView.getSelectionPath().getLastPathComponent();


        for(int i = 0; i < root.getChildCount(); i++){

            RuTreeItem projekat = (RuTreeItem) root.getChildAt(i);
            for(int j = 0; j < projekat.getChildCount(); j++){

                RuTreeItem document = (RuTreeItem) projekat.getChildAt(j);

                if(doc.getNode().equals(document.getNode())){
                    document.add(new RuTreeItem(p));
                }


            }

        }
        notifySubscribersT("Obavesti");


    }

    @Override
    public void addPage2(Page page) {


        RuTreeItem rez = null;


        RuTreeItem root = (RuTreeItem) treeModel.getRoot();

        for(int i = 0; i < root.getChildCount(); i++){

            RuTreeItem projekat = (RuTreeItem) root.getChildAt(i);
            for(int j = 0; j < projekat.getChildCount(); j++){

                RuTreeItem document = (RuTreeItem) projekat.getChildAt(j);
                 if(document.getNode().equals(page.getParent())){
                     rez = document;
                     break;
                 }


            }

        }
        rez.add(new RuTreeItem(page));
        treeView.expandPath(selectedPath());
        notifySubscribersT("Obavesti");
    }



    //Priliko pravlenja RuTree item-a za slot, pravi se vise istih ukoliko slot pripada podeljenom dokumentu

    @Override
    public void addSlot(Slot slot) {

        RuNode selectednode = selectedItem();
        ((Page)selectednode).addChild(slot);
        treeView.expandPath(selectedPath());

        RuTreeItem root = (RuTreeItem) treeModel.getRoot();

        for(int i = 0; i < root.getChildCount(); i++){

            RuTreeItem projekat = (RuTreeItem) root.getChildAt(i);
            for(int j = 0; j < projekat.getChildCount(); j++){

                RuTreeItem document = (RuTreeItem) root.getChildAt(i).getChildAt(j);

                for(int k = 0; k < document.getChildCount();k++){
                    RuTreeItem page = (RuTreeItem) document.getChildAt(k);

                        if(selectednode.equals(page.getNode())){
                            page.add(new RuTreeItem(slot));
                        }


                }


            }

        }

        notifySubscribersT("Obavesti");
    }


    public void Delete2(Slot slot){
        RuTreeItem root = (RuTreeItem) treeModel.getRoot();

        for(int i = 0; i < root.getChildCount(); i++){

            RuTreeItem projekat = (RuTreeItem) root.getChildAt(i);
            for(int j = 0; j < projekat.getChildCount(); j++){

                RuTreeItem document = (RuTreeItem) projekat.getChildAt(j);

                for(int k = 0; k < document.getChildCount();k++){
                    RuTreeItem page = (RuTreeItem) document.getChildAt(k);

                    for(int m = 0; m < page.getChildCount();m++){

                        RuTreeItem slot2 = (RuTreeItem) page.getChildAt(m);

                        if(slot.equals(slot2.getNode())){
                            page.remove(slot2);
                        }

                    }

                }


            }

        }

        ((Page) (slot.getParent())).removeChild(slot);
        notifySubscribersT("Obavesti");
    }


    //Prilikom brisanja jednog RuuTree item-a brisu se svi RuTree item-i koji imaju isti Node.
    //RuTree item-i imaju isti node jedino ako pripadaju podeljenom dokumentu

    @Override
    public void Delete() {

        System.out.println("USAO U DELETE");
        RuNode selectednode = selectedItem();

        if(selectedPath()==null || selectednode instanceof Slot){
            AppCore.getInstance().getErrHandler().generateError(ErrorTypes.SELECTIONERROR);
        }
        else {
            if(selectednode instanceof Workspace){
                AppCore.getInstance().getErrHandler().generateError(ErrorTypes.WORKSPACEERROR);

            }
            else {

                if((selectednode.getParent()) instanceof Workspace){
                    int brojac = 0;
                   RuTreeItem root = (RuTreeItem) treeModel.getRoot();
                   RuTreeItem selektovaniProjekat = (RuTreeItem) treeView.getLastSelectedPathComponent();
                   RuTreeItem selektovaniPParent = (RuTreeItem) selektovaniProjekat.getParent();
                    System.out.println(selektovaniProjekat.getName()+ "AAA");
                    System.out.println(selektovaniPParent.getName()+ "BBB");

                    for(int i = 0; i < selektovaniProjekat.getChildCount(); i++){
                        RuTreeItem dokument = (RuTreeItem) selektovaniProjekat.getChildAt(i);

                        for(int j = 0; j < root.getChildCount(); j++){
                            RuTreeItem projekat = (RuTreeItem) root.getChildAt(j);

                            if(selektovaniProjekat != projekat) {

                                for (int k = 0; k < projekat.getChildCount(); k++) {
                                    RuTreeItem dokument2 = (RuTreeItem) projekat.getChildAt(k);

                                    if(dokument.getNode().equals(dokument2.getNode())){
                                        if(brojac++  == 0) {
                                            System.out.println("Deca projekta!");
                                            ((Project) dokument2.getNode().getParent()).removeChild(dokument2.getNode());


                                        }
                                        projekat.remove(dokument2);
                                        break;
                                    }

                                }
                            }
                        }

                    }
                    selektovaniPParent.remove(selektovaniProjekat);
                    ((Workspace) (selectednode.getParent())).removeChild(selectednode);
                    notifySubscribersT("Obavesti");
                    return;
                }

                else if((selectednode.getParent()) instanceof Project){

                    RuTreeItem root = (RuTreeItem) treeModel.getRoot();

                    for(int i = 0; i < root.getChildCount(); i++){


                        RuTreeItem projekat = (RuTreeItem) root.getChildAt(i);
                        for(int j = 0; j < projekat.getChildCount(); j++){
                            RuTreeItem dokument = (RuTreeItem) projekat.getChildAt(j);

                            if(dokument.getNode().equals(selectednode)){
                                projekat.remove(dokument);
                                break;
                            }


                        }

                    }

                    ((Project) (selectednode.getParent())).removeChild(selectednode);
                    notifySubscribersT("Obavesti");
                    return;
                }
                else if((selectednode.getParent()) instanceof Document){

                    RuTreeItem root = (RuTreeItem) treeModel.getRoot();

                    for(int i = 0; i < root.getChildCount(); i++){

                        RuTreeItem projekat = (RuTreeItem) root.getChildAt(i);

                        for(int j = 0; j < projekat.getChildCount(); j++){

                            RuTreeItem document = (RuTreeItem) projekat.getChildAt(j);

                              for(int k = 0; k < document.getChildCount(); k++){

                                  RuTreeItem page = (RuTreeItem) document.getChildAt(k);

                                  if(selectednode.equals(page.getNode())){
                                      document.remove(page);
                                  }

                              }

                        }

                    }
                    ((Document) (selectednode.getParent())).removeChild(selectednode);
                    notifySubscribersT("Obavesti");
                    return;


                }
                else if((selectednode.getParent()) instanceof Page){
                    RuTreeItem root = (RuTreeItem) treeModel.getRoot();

                    for(int i = 0; i < root.getChildCount(); i++){

                        RuTreeItem projekat = (RuTreeItem) root.getChildAt(i);
                        for(int j = 0; j < projekat.getChildCount(); j++){

                            RuTreeItem document = (RuTreeItem) projekat.getChildAt(j);

                            for(int k = 0; k < document.getChildCount();k++){
                                RuTreeItem page = (RuTreeItem) document.getChildAt(k);

                                for(int m = 0; m < page.getChildCount();m++){

                                    RuTreeItem slot = (RuTreeItem) page.getChildAt(m);

                                    if(selectednode.equals(slot.getNode())){
                                        page.remove(slot);
                                    }

                                }

                            }


                        }

                    }

                    ((Page) (selectednode.getParent())).removeChild(selectednode);
                    notifySubscribersT("Obavesti");
                    return;

                }
            }
        }
    }

    @Override
    public RuNode selectedItem() {
        return ((RuTreeItem)treeView.getLastSelectedPathComponent()).getNode();
    }

    @Override
    public TreePath selectedPath() {
        return treeView.getSelectionPath();
    }

    @Override
    public boolean isWorkspaceSelected() {
        if (selectedPath() == null)
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean isSelected(TreePath path) {
        if(path!=null) {
            notifyStatusLineSubscribers(path);
            return true;
        }
        return false;
    }
    @Override
    public void addSubscriberT(SubscriberT sub) {
        if(sub == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriberT(SubscriberT sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscribersT(Object notification) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;
        for(SubscriberT listener : subscribers){
            listener.updateT(notification);
        }
    }

    @Override
    public void addStatusLineSubscriber(StatusLineSubscriber statsub) {
        if(statsub == null)
            return;
        if(this.statusLineSubscribers ==null)
            this.statusLineSubscribers = new ArrayList<>();
        if(this.statusLineSubscribers.contains(statsub))
            return;
        this.statusLineSubscribers.add(statsub);
    }

    @Override
    public void removeStatusLineSubscriber(StatusLineSubscriber statsub) {
        if(statsub == null || this.statusLineSubscribers == null || !this.statusLineSubscribers.contains(statsub))
            return;
        this.statusLineSubscribers.remove(statsub);
    }

    @Override
    public void notifyStatusLineSubscribers(TreePath treePath) {
        if(treePath == null || this.statusLineSubscribers == null || this.statusLineSubscribers.isEmpty())
            return;
        for(StatusLineSubscriber listener : statusLineSubscribers){
            listener.updateStatusLineSubscribers(treePath);
        }
    }


    @Override
    public GlavniFrame vratiGlavniFrame() {
        return null;
    }
}
