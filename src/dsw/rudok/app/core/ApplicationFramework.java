package dsw.rudok.app.core;

import dsw.rudok.app.Serializable.Serializable;

public abstract class ApplicationFramework {

    protected Gui gui;
    protected Repository docrep;
    protected ErrHandler errHandler;
    protected UndoRedoHandler undoRedoHandler;
    protected ISerializable iSerializable;

    public abstract void run();

    public void inicijalizacija(Gui gui, Repository docrep,ErrHandler errHandler,UndoRedoHandler undoRedoHandler, ISerializable iSerializable)
    {
        this.docrep=docrep;
        this.gui=gui;
        this.errHandler=errHandler;
        this.errHandler.addErrorSub(gui);
        this.undoRedoHandler=undoRedoHandler;
        this.undoRedoHandler.addCommandSubscriber(gui);
        this.iSerializable = iSerializable;

    }

    /* Geteri i seteri*/

    public void setGui(Gui gui) {
        this.gui = gui;
    }

    public Gui getGui() {

        return gui;
    }
    public ErrHandler getErrHandler() {
        return errHandler;
    }

    public UndoRedoHandler getUndoRedoHandler() {
        return undoRedoHandler;
    }

    public ISerializable getiSerializable() {
        return iSerializable;
    }
}
