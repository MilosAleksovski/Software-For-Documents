package dsw.rudok.app.commands;

import dsw.rudok.app.repository.PageModel;
import dsw.rudok.app.repository.workspace.slot.CircleSlot;
import dsw.rudok.app.repository.workspace.slot.RectangleSlot;
import dsw.rudok.app.repository.workspace.slot.Slot;
import dsw.rudok.app.repository.workspace.slot.TriangleSlot;

import java.awt.*;

public class MultiSelectCommand extends AddDeviceComand  {
    public MultiSelectCommand(Slot slot, PageModel pageModel, CommandsEnum commandtype, Point position, Dimension dimension, double angle) {
        super(slot, pageModel, commandtype, position, dimension, angle);
    }

    public void doCommand(){
        slot.setPaint(Color.blue);
        if(slot instanceof RectangleSlot)
            slot.napraviNoviRPainter();
        if(slot instanceof TriangleSlot)
            slot.napraviNoviTPainter();
        if(slot instanceof CircleSlot)
            slot.napraviNoviCPainter();
        pageModel.obrisiElementIzListe(slot);
        pageModel.dodajElementUListu(slot);
    }
    public void undoCommand(){
        slot.setPaint(Color.red);
        if(slot instanceof RectangleSlot)
            slot.napraviNoviRPainter();
        if(slot instanceof TriangleSlot)
            slot.napraviNoviTPainter();
        if(slot instanceof CircleSlot)
            slot.napraviNoviCPainter();
        pageModel.obrisiElementIzListe(slot);
        pageModel.dodajElementUListu(slot);
    }
}
