package dsw.rudok.app.commands;

import dsw.rudok.app.repository.PageModel;
import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.*;

public class DeleteCommand extends AddDeviceComand {
    public DeleteCommand(Slot slot, PageModel pageModel, CommandsEnum commandtype, Point position, Dimension dimension, double angle) {
        super(slot, pageModel, commandtype, position, dimension, angle);
    }
    public void doCommand(){
        pageModel.dodajElementUListu(slot);
    }
    public void undoCommand(){
        pageModel.obrisiElementIzListe(slot);
    }
}
