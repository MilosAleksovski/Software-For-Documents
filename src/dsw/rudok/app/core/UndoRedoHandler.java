package dsw.rudok.app.core;

import dsw.rudok.app.commands.CommandObserver.CommandPublisher;
import dsw.rudok.app.commands.CommandsEnum;

public interface UndoRedoHandler extends CommandPublisher {
    void undoRedoEnable(CommandsEnum commandsEnum);
}