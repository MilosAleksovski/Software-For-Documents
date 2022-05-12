package dsw.rudok.app.commands;

import dsw.rudok.app.repository.PageModel;
import dsw.rudok.app.repository.workspace.slot.CircleSlot;
import dsw.rudok.app.repository.workspace.slot.RectangleSlot;
import dsw.rudok.app.repository.workspace.slot.Slot;
import dsw.rudok.app.repository.workspace.slot.TriangleSlot;

import java.awt.*;

public class ResizeCommand extends AddDeviceComand {


    public ResizeCommand(Slot slot, PageModel pageModel, CommandsEnum commandtype, Point position, double x, double y) {
        super(slot, pageModel, commandtype, position, x, y);
    }

    public void doCommand(){
        slot.setPosition(position);
        slot.getSize().setSize(y, x);
        if(slot instanceof RectangleSlot)
            slot.selektovaniRPainter();
        if(slot instanceof TriangleSlot)
            slot.selektovaniTPainter();
        if(slot instanceof CircleSlot)
            slot.napraviNoviCPainter();
        pageModel.dodajElementUListu(slot);
    }
    public void undoCommand(){
        pageModel.obrisiElementIzListe(slot);
    }

}
