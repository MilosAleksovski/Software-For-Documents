package dsw.rudok.app.commands.CommandObserver;


import dsw.rudok.app.commands.CommandsEnum;

public interface CommandSubscriber {
    void updateCommandSubscribers(CommandsEnum commandsEnum);
}
