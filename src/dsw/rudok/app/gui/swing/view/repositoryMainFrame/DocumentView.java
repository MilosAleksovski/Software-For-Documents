package dsw.rudok.app.gui.swing.view.repositoryMainFrame;

import dsw.rudok.app.gui.swing.observerMainPanel.Publisher;
import dsw.rudok.app.gui.swing.observerMainPanel.Subscriber;
import dsw.rudok.app.repository.updateEvent.UpdateEvent;
import dsw.rudok.app.repository.workspace.Document;
import dsw.rudok.app.repository.workspace.Page;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DocumentView extends JPanel implements Subscriber, Serializable {
    private Document document;
    private List<PageView> listaStranica;
    private String imeDokumenta;
    private static long serialVersionUID = 4L;

    public DocumentView(Document document) {
        this.document=document;
        this.document.addSubscriber(this);
        listaStranica = new ArrayList<>();
        this.imeDokumenta = document.getName();
        this.setLayout(new GridLayout(1, 2));

    }


    public void dodajStranicu(Page page){
        PageView pageView = new PageView(page);
        this.add(pageView);
        listaStranica.add(pageView);
        updateUI();
    }

    public void obrisiStranicu(Page page){
        for(PageView pageView:listaStranica){
            if(page.equals(pageView.getPage())){
                this.remove(pageView);
                listaStranica.remove(pageView);
                updateUI();
                return;
            }
        }
    }



    public Document getDocument() {
        return document;
    }

    @Override
    public void updateDodavanje(Publisher publisher) {
              Page page = (Page)publisher;
              dodajStranicu(page);
    }

    @Override
    public void updateBrisanje(Publisher publisher) {
        Page page = (Page)publisher;
        obrisiStranicu(page);
    }

    @Override
    public void updateIme(Publisher publisher) {
            Document doc = (Document)publisher;
            imeDokumenta = doc.getName();
    }

    @Override
    public void updateDoubleCLick(Publisher publisher) {

    }

    @Override
    public void updatePerformed(UpdateEvent e) {

    }


    public String getImeDokumenta() {
        return imeDokumenta;
    }
}
