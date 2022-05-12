package dsw.rudok.app.core;

import java.io.Serializable;

public interface IComand extends Serializable {
    void doCommand();
    void undoCommand();
}
