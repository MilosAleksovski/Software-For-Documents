package dsw.rudok.app.gui.swing;

import dsw.rudok.app.ErrorHandler.GenError;
import dsw.rudok.app.commands.CommandsEnum;
import dsw.rudok.app.core.Gui;
import dsw.rudok.app.core.Repository;
import dsw.rudok.app.gui.swing.view.GlavniFrame;

public class SwingGui implements Gui {

    private GlavniFrame gf;
    private Repository docRep;

    public SwingGui(Repository docRep) {
        this.docRep = docRep;
    }

    @Override
    public void start() {

        
        gf = GlavniFrame.getInstance();// Pravi se jedini objekat JMainFrame-a
        gf.setDocRep(docRep);
        gf.ucitavanje();                 // Pokrece se metoda koja inicijalizuje nas glavni prozor;
        gf.setVisible(true);
    }

    @Override
    public void updateErrorSubscribers(GenError error) {
        GlavniFrame.getInstance().showError(error);
    }

    @Override
    public void updateCommandSubscribers(CommandsEnum commandsEnum) {
        GlavniFrame.getInstance().undoRedoEnable(commandsEnum);
    }
}

