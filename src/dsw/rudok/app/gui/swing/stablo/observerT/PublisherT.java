package dsw.rudok.app.gui.swing.stablo.observerT;

public interface PublisherT {
    void addSubscriberT(SubscriberT sub);
    void removeSubscriberT(SubscriberT sub);
    void notifySubscribersT(Object notification);
}
