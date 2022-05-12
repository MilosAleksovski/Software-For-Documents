package dsw.rudok.app.ErrorHandler.ErrorObserver;

import dsw.rudok.app.ErrorHandler.GenError;

public interface ErrorPublisher {
    void addErrorSub(ErrorSubscriber errorSubscriber);
    void removeErrorSub(ErrorSubscriber errorSubscriber);
    void notifyErrorSubs(GenError error);
}
