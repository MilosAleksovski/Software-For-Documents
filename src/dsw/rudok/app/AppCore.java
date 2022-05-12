package dsw.rudok.app;

import dsw.rudok.app.ErrorHandler.ErrImpl;
import dsw.rudok.app.ErrorHandler.ErrorTypes;
import dsw.rudok.app.Serializable.Serializable;
import dsw.rudok.app.commands.CommandImpl;
import dsw.rudok.app.commands.CommandMenager;
import dsw.rudok.app.core.*;
import dsw.rudok.app.gui.swing.SwingGui;
import dsw.rudok.app.repository.RepositoryImpl;


public class AppCore extends ApplicationFramework {

    /*Singleton pattern*/
    private static AppCore instanca ;

    private AppCore()
    {

    }
    public static AppCore getInstance()
    {
        if(instanca==null)
            instanca=new AppCore();
        return instanca;
    }


    @Override
    public void run() {
        this.gui.start();
    }

    /*Main metoda*/
    public static void main(String[] args) {

        Repository docRep = new RepositoryImpl();
        Gui gui = new SwingGui(docRep);
        ErrHandler errHandler= new ErrImpl();
        UndoRedoHandler undoRedoHandler=new CommandImpl();
        ApplicationFramework appcore= AppCore.getInstance();
        ISerializable iSerializable = new Serializable();
        appcore.inicijalizacija(gui,docRep,errHandler,undoRedoHandler, iSerializable);
        appcore.run();
    }


}

