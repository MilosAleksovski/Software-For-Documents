package dsw.rudok.app.core;

import dsw.rudok.app.ErrorHandler.ErrorObserver.ErrorSubscriber;
import dsw.rudok.app.commands.CommandObserver.CommandSubscriber;

public interface Gui extends ErrorSubscriber, CommandSubscriber {
    void start();
}
