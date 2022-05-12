package dsw.rudok.app.gui.swing.observerMainPanel;

import dsw.rudok.app.repository.Node.RuNode;

public interface Publisher {
    void addSubscriber(Subscriber sub);
    void removeSubscriber(Subscriber sub);
    void notifySubscribersDodavanje(RuNode ruNode);
    void notifySubscribersBrisanje(RuNode ruNode);
    void notifySubscribersDoubleKlik(RuNode ruNode);
    void notifySubscribersRename(RuNode ruNode);
    void notifySubscribersCopyPaste(RuNode ruNode);
}
