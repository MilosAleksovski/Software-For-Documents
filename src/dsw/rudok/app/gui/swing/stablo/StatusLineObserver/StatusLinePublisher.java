package dsw.rudok.app.gui.swing.stablo.StatusLineObserver;

import javax.swing.tree.TreePath;

public interface StatusLinePublisher {
    void addStatusLineSubscriber(StatusLineSubscriber statsub);
    void removeStatusLineSubscriber(StatusLineSubscriber statsub);
    void notifyStatusLineSubscribers(TreePath treePath);
}
