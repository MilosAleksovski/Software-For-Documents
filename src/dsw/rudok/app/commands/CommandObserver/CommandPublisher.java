package dsw.rudok.app.commands.CommandObserver;

import dsw.rudok.app.commands.CommandsEnum;

public interface CommandPublisher {
    void addCommandSubscriber(CommandSubscriber commandSubscriber);
    void removeCommandSubscriber(CommandSubscriber errorSubscriber);
    void notifyCommandSubs(CommandsEnum commandsEnum);
}