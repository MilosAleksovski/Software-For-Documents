package dsw.rudok.app.core;

import dsw.rudok.app.ErrorHandler.ErrorTypes;
import dsw.rudok.app.ErrorHandler.ErrorObserver.ErrorPublisher;
import dsw.rudok.app.repository.Node.RuNode;

public interface ErrHandler extends ErrorPublisher {
    void generateError(ErrorTypes type);
    void generateError(ErrorTypes type, RuNode node);
}
