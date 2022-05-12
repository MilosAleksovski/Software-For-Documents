package dsw.rudok.app.commands;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.ErrorHandler.ErrorObserver.ErrorSubscriber;
import dsw.rudok.app.commands.CommandObserver.CommandPublisher;
import dsw.rudok.app.commands.CommandObserver.CommandSubscriber;
import dsw.rudok.app.core.IComand;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.repository.workspace.slot.Slot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CommandMenager implements IComand, Serializable {

    private  ArrayList<IComand> commands = new ArrayList<>();
    private int currentCommand = 0;
    private int flag = 1;



    public void addCommand(IComand command){
        while(currentCommand < commands.size()) {
            commands.remove(currentCommand);
        }

        if(commands.size() >= 1) {
            int a = currentCommand ;

            if (((AddDeviceComand) (commands.get(a - 1))).getCommandtype() != (((AddDeviceComand)command).getCommandtype())) {
                commands.clear();
                currentCommand = 0;
            }
        }
        if(flag == 0){
            commands.clear();
            currentCommand = 0;
            flag = 1;
        }
        commands.add(command);

        currentCommand++;

        AppCore.getInstance().getUndoRedoHandler().undoRedoEnable(CommandsEnum.DELETE);

    }



    public void doCommand(){
        flag = 0;
        CommandsEnum br=((AddDeviceComand) (commands.get(currentCommand ))).getCommandtype();
        int brojElemenata = ((AddDeviceComand) (commands.get(0))).getPageModel().getSlotovi().size();

        if(br.equals(CommandsEnum.RECTANGLE) || br.equals(CommandsEnum.TRIANGLE) || br.equals(CommandsEnum.CIRCLE)) {
            AppCore.getInstance().getUndoRedoHandler().undoRedoEnable(CommandsEnum.UNDOELEMENTS);
            commands.get(currentCommand++).doCommand();
        }
        if(br.equals(CommandsEnum.MULTISELEKT)){


            for(IComand iComand: commands){
                iComand.doCommand();
                currentCommand++;
            }
            AppCore.getInstance().getUndoRedoHandler().undoRedoEnable(CommandsEnum.MULTISELEKT);
        }
        if (br.equals(CommandsEnum.MOVE) || br.equals(CommandsEnum.ROTATE) || br.equals(CommandsEnum.RESIZE) ) {
            System.out.println(brojElemenata);

            for(int i = 0; i < brojElemenata; i++){
                commands.get(i).undoCommand();
            }
            for(int i = commands.size() - 1; i > commands.size() - brojElemenata - 1; i--){
                commands.get(i).doCommand();
            }
            currentCommand = commands.size();
            AppCore.getInstance().getUndoRedoHandler().undoRedoEnable(CommandsEnum.UNDOMOVE);
        }

        if (br.equals(CommandsEnum.DELETE)) {
            for(IComand iComand: commands){
                iComand.undoCommand();
                currentCommand++;
            }
            AppCore.getInstance().getUndoRedoHandler().undoRedoEnable(CommandsEnum.MULTISELEKT);
        }



        if(currentCommand == commands.size()){
            AppCore.getInstance().getUndoRedoHandler().undoRedoEnable(CommandsEnum.MULTISELEKT);
        }

    }


    public void undoCommand(){
        flag = 0;
        CommandsEnum br=((AddDeviceComand) (commands.get(currentCommand - 1))).getCommandtype();
        int brojElemenata = ((AddDeviceComand) (commands.get(0))).getPageModel().getSlotovi().size();

        if(currentCommand > 0) {

            if(br.equals(CommandsEnum.MULTISELEKT)){

                for(IComand iComand: commands){
                    iComand.undoCommand();
                    currentCommand--;
                }
                AppCore.getInstance().getUndoRedoHandler().undoRedoEnable(CommandsEnum.MULTISELEKTUNDO);
            }

            if (br.equals(CommandsEnum.MOVE) || br.equals(CommandsEnum.ROTATE) || br.equals(CommandsEnum.RESIZE) ) {


                for(int i = commands.size() - 1; i > commands.size() - brojElemenata - 1; i--){
                    commands.get(i).undoCommand();
                }
                for(int j = 0; j < brojElemenata; j++){
                    ((AddDeviceComand)commands.get(j)).setAngle(0);
                    commands.get(j).doCommand();
                }


                currentCommand = 0;


                AppCore.getInstance().getUndoRedoHandler().undoRedoEnable(CommandsEnum.UNDOMOVE);
            }

            if (br.equals(CommandsEnum.DELETE)) {
                for(IComand iComand: commands){
                    iComand.doCommand();
                    currentCommand--;
                }
                AppCore.getInstance().getUndoRedoHandler().undoRedoEnable(CommandsEnum.UNDODELETE);
            }
            else if(br.equals(CommandsEnum.RECTANGLE) || br.equals(CommandsEnum.TRIANGLE) || br.equals(CommandsEnum.CIRCLE)) {

                AppCore.getInstance().getUndoRedoHandler().undoRedoEnable(CommandsEnum.UNDOELEMENTS);
                commands.get(--currentCommand).undoCommand();
            }
        }
        if(currentCommand == 0){
            AppCore.getInstance().getUndoRedoHandler().undoRedoEnable(CommandsEnum.COMMANDNULL);
        }
    }




    public int getCurrentCommand() {
        return currentCommand;
    }

}