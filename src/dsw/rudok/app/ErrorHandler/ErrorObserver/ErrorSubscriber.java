package dsw.rudok.app.ErrorHandler.ErrorObserver;

import dsw.rudok.app.ErrorHandler.GenError;

public interface ErrorSubscriber {
    void updateErrorSubscribers(GenError error);
}
