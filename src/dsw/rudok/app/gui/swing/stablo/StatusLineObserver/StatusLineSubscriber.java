package dsw.rudok.app.gui.swing.stablo.StatusLineObserver;

import javax.swing.tree.TreePath;

public interface StatusLineSubscriber {
    void updateStatusLineSubscribers(TreePath treePath);
}
