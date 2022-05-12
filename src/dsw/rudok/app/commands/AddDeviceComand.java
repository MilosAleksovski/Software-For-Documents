package dsw.rudok.app.commands;

import dsw.rudok.app.commands.CommandObserver.CommandSubscriber;
import dsw.rudok.app.core.IComand;
import dsw.rudok.app.repository.PageModel;
import dsw.rudok.app.repository.workspace.slot.CircleSlot;
import dsw.rudok.app.repository.workspace.slot.RectangleSlot;
import dsw.rudok.app.repository.workspace.slot.Slot;
import dsw.rudok.app.repository.workspace.slot.TriangleSlot;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

public abstract class AddDeviceComand implements IComand, Serializable {
    protected PageModel pageModel;
    protected Slot slot = null;
    protected Point position;
    private CommandsEnum commandtype;
    protected double x;
    protected double y;
    protected double angle;


    public AddDeviceComand(Slot slot, PageModel pageModel, CommandsEnum commandtype, Point position, Dimension dimension, double angle){
        this.position = position;
        this.slot = slot;
        this.pageModel = pageModel;
        this.commandtype=commandtype;
        this.angle = angle;
    }
    public AddDeviceComand(Slot slot, PageModel pageModel, CommandsEnum commandtype, Point position, double x, double y){
        this.position = position;
        this.slot = slot;
        this.pageModel = pageModel;
        this.commandtype=commandtype;
        this.x = x;
        this.y = y;

    }

    @Override
    public void doCommand() {

    }

    @Override
    public void undoCommand() {


    }


    public CommandsEnum getCommandtype() {
        return commandtype;
    }

    public Slot getSlot() {
        return slot;
    }

    public PageModel getPageModel() {
        return pageModel;
    }

    public  Point getPosition() {
        return position;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
}