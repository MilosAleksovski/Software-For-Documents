package dsw.rudok.app.gui.swing.observerMainPanel;

import dsw.rudok.app.repository.updateEvent.UpdateEvent;

import java.io.Serializable;
import java.util.EventListener;

public interface Subscriber extends EventListener, Serializable {
    void updateDodavanje(Publisher publisher);
    void updateBrisanje(Publisher publisher);
    void updateIme(Publisher publisher);
    void updateDoubleCLick(Publisher publisher);
    void updatePerformed(UpdateEvent e);
}
