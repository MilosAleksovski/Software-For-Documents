package dsw.rudok.app.commands;

import dsw.rudok.app.commands.CommandObserver.CommandPublisher;
import dsw.rudok.app.commands.CommandObserver.CommandSubscriber;
import dsw.rudok.app.core.IComand;
import dsw.rudok.app.core.UndoRedoHandler;

import java.util.ArrayList;
import java.util.List;

public class CommandImpl implements CommandPublisher, UndoRedoHandler {

    List<CommandSubscriber> commandSubscribers=new ArrayList<>();

    public void undoRedoEnable(CommandsEnum commandsEnum)
    {
        if(commandsEnum.equals(CommandsEnum.DELETE))
        {
            notifyCommandSubs(CommandsEnum.DELETE);
        }else if(commandsEnum.equals(CommandsEnum.MULTISELEKT))
        {
            notifyCommandSubs(CommandsEnum.MULTISELEKT);
        }
        else if(commandsEnum.equals(CommandsEnum.UNDOMOVE)){
            notifyCommandSubs(CommandsEnum.UNDOMOVE);
        }
        else if(commandsEnum.equals(CommandsEnum.CURRENTSMALLER))
        {
            notifyCommandSubs(CommandsEnum.CURRENTSMALLER);
        }

        else if (commandsEnum.equals(CommandsEnum.DELETEDO))
        {
            notifyCommandSubs(CommandsEnum.DELETEDO);
        }
        else if(commandsEnum.equals(CommandsEnum.CURRENTCOMMANDEQUAL))
        {
            notifyCommandSubs(CommandsEnum.CURRENTCOMMANDEQUAL);
        }
        else if(commandsEnum.equals(CommandsEnum.MULTISELEKTUNDO))
        {
            notifyCommandSubs(CommandsEnum.MULTISELEKTUNDO);
        }
        else if(commandsEnum.equals(CommandsEnum.UNDODELETE))
        {
            notifyCommandSubs(CommandsEnum.UNDODELETE);
        }
        else if(commandsEnum.equals(CommandsEnum.UNDOELEMENTS))
        {
            notifyCommandSubs(CommandsEnum.UNDOELEMENTS);
        }
        else if(commandsEnum.equals(CommandsEnum.COMMANDNULL))
        {
            notifyCommandSubs(CommandsEnum.COMMANDNULL);
        }
    }

    @Override
    public void addCommandSubscriber(CommandSubscriber commandSubscriber) {
        if(commandSubscribers == null)
            return;
        if(this.commandSubscribers ==null)
            this.commandSubscribers = new ArrayList<>();
        if(this.commandSubscribers.contains(commandSubscriber))
            return;
        this.commandSubscribers.add(commandSubscriber);
    }

    @Override
    public void removeCommandSubscriber(CommandSubscriber errorSubscriber) {
        if(commandSubscribers == null || this.commandSubscribers == null || !this.commandSubscribers.contains(errorSubscriber))
            return;
        this.commandSubscribers.remove(errorSubscriber);
    }

    @Override
    public void notifyCommandSubs(CommandsEnum commandsEnum) {
        if(commandsEnum == null || this.commandSubscribers == null || this.commandSubscribers.isEmpty()) {
            return;
        }
        for(CommandSubscriber listener : commandSubscribers){
            listener.updateCommandSubscribers(commandsEnum);
        }
    }


}
