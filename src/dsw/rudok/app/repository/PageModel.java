package dsw.rudok.app.repository;

import dsw.rudok.app.gui.swing.observerMainPanel.Subscriber;
import dsw.rudok.app.gui.swing.view.painters.*;
import dsw.rudok.app.repository.updateEvent.UpdateEvent;
import dsw.rudok.app.repository.workspace.slot.Slot;

import javax.swing.event.EventListenerList;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class PageModel implements Serializable {
    private String name;
    protected ArrayList<Slot> pageElements =new ArrayList <>();
    private ArrayList<Slot> slotovi=new ArrayList<>();
     EventListenerList listenerList = new EventListenerList();
     UpdateEvent updateEvent = null;



    public void fireUpdatePerformed() {

        Object[] listeners = listenerList.getListenerList();
        for (int i = listeners.length-2; i>=0; i-=2) {
            if (listeners[i]== Subscriber.class) {
                if (updateEvent == null)

                    updateEvent= new UpdateEvent(this);
                ((Subscriber)listeners[i+1]).updatePerformed(updateEvent);
            }
        }
    }

    public void addUpdateListener(Subscriber l) {
        listenerList.add(Subscriber.class,l);
    }

    public int getElementAtPosition(Point point){
        int i = 0;
        for(Slot slot : pageElements){
            Slot p = slot;
            if(p.getElementPainter().elementAt(p, point)){
                return i;
            }
            i++;
        }
        return -1;

    }

    public String getElementAtPosition2(Point point){


        int i = 0;
        for(Slot slot : pageElements){
            Slot p = slot;
            if(p.getElementPainter().elementAt(p, point)){

                break;
            }
            i++;
        }

        int b = 0;
        for(Slot slot : pageElements){
            if (b++ == i) {
                Slot p = slot;

                if (p.getElementPainter() instanceof SelectRectanglePainter) {
                    return p.getElementPainter().elementAt2(p, point);
                } else if (p.getElementPainter() instanceof SelectTrianlgePainter) {
                    return p.getElementPainter().elementAt2(p, point);
                } else if (p.getElementPainter() instanceof SelectRotatePainter) {
                    return p.getElementPainter().elementAt2(p, point);
                }
            }
        }
        return null;

    }

    public  void dodajElementUListu(Slot pageDevice){

        pageElements.add(pageDevice);
        fireUpdatePerformed();
    }
    public void obrisiElementIzListe(Slot pageDevice){
        pageElements.remove(pageDevice);
        fireUpdatePerformed();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }

    public ArrayList<Slot> getPageElements() {
        return pageElements;
    }

    public Iterator<Slot> getDeviceIterator(){
        return pageElements.iterator();
    }

    public ArrayList<Slot> getSlotovi() {
        return slotovi;
    }
}
