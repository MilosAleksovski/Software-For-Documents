package dsw.rudok.app.gui.swing.view.painters;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.ErrorHandler.ErrorTypes;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.repository.workspace.slot.CircleSlot;
import dsw.rudok.app.repository.workspace.slot.RectangleSlot;
import dsw.rudok.app.repository.workspace.slot.Slot;
import dsw.rudok.app.repository.workspace.slot.TriangleSlot;

import java.awt.geom.GeneralPath;

public class RotatePainter extends DevicePainter {
    public RotatePainter(Slot device, Slot kopijaSlota) {
        super(device);
        Slot element = (Slot) device;

        double h = element.getSize().height;
        double w = element.getSize().width;

        double x = element.getPosition().getX();
        double y = element.getPosition().getY();
        System.out.println("RotateP" + element.getRotations());


        if (element instanceof RectangleSlot) {
            if (kopijaSlota.getRotations() == 0) {
                shape = new GeneralPath();
                System.out.println("Usao u 0");
                ((GeneralPath) shape).moveTo(element.getPosition().x, element.getPosition().y);
                ((GeneralPath) shape).lineTo(element.getPosition().x - element.getSize().height, element.getPosition().y);
                ((GeneralPath) shape).lineTo(element.getPosition().x - element.getSize().height, element.getPosition().y + element.getSize().width);
                ((GeneralPath) shape).lineTo(element.getPosition().x, element.getPosition().y + element.getSize().width);
                ((GeneralPath) shape).closePath();
                kopijaSlota.incrementRotations();


            } else if (kopijaSlota.getRotations() == 1) {
                shape = new GeneralPath();
                System.out.println("Usao u 1");
                ((GeneralPath) shape).moveTo(element.getPosition().x, element.getPosition().y);
                ((GeneralPath) shape).lineTo(element.getPosition().x - w, element.getPosition().y);
                ((GeneralPath) shape).lineTo(element.getPosition().x - w, element.getPosition().y-element.getSize().height);
                ((GeneralPath) shape).lineTo(element.getPosition().x , element.getPosition().y - h);
                ((GeneralPath) shape).closePath();
                kopijaSlota.incrementRotations();
            } else if (kopijaSlota.getRotations() == 2) {
                System.out.println("Usao u 2");
                shape = new GeneralPath();
                ((GeneralPath) shape).moveTo(element.getPosition().x, element.getPosition().y);
                ((GeneralPath) shape).lineTo(element.getPosition().x + h, element.getPosition().y);
                ((GeneralPath) shape).lineTo(element.getPosition().x + h, element.getPosition().y-element.getSize().width);
                ((GeneralPath) shape).lineTo(element.getPosition().x , element.getPosition().y - w);
                ((GeneralPath) shape).closePath();
                kopijaSlota.incrementRotations();
            } else if (kopijaSlota.getRotations() == 3) {
                shape=new GeneralPath();
                System.out.println("Usao u 3");
                ((GeneralPath)shape).moveTo(element.getPosition().x,element.getPosition().y);
                ((GeneralPath)shape).lineTo(element.getPosition().x+element.getSize().width,element.getPosition().y);
                ((GeneralPath)shape).lineTo(element.getPosition().x+element.getSize().width,element.getPosition().y+element.getSize().height);
                ((GeneralPath)shape).lineTo(element.getPosition().x,element.getPosition().y+element.getSize().height);
                ((GeneralPath)shape).closePath();
                kopijaSlota.clearRotations();
            }
        }
        else if(element instanceof TriangleSlot)
        {
            if (kopijaSlota.getRotations() == 0) {
                shape = new GeneralPath();
                ((GeneralPath)shape).moveTo(x, y);
                ((GeneralPath)shape).lineTo(x - w ,y - (h + 20) / 2);
                ((GeneralPath)shape).lineTo(x - w , y + (h + 20) / 2);
                ((GeneralPath)shape).closePath();
                kopijaSlota.incrementRotations();

            } else if (kopijaSlota.getRotations() == 1)
            {
                shape = new GeneralPath();
                ((GeneralPath)shape).moveTo(x, y);
                ((GeneralPath)shape).lineTo(x - (h + 20) / 2,y - w);
                ((GeneralPath)shape).lineTo(x + (h+ 20) /2, y - w);

                ((GeneralPath)shape).closePath();
                kopijaSlota.incrementRotations();
            }
            else if (kopijaSlota.getRotations() == 2)
            {
                shape = new GeneralPath();
                ((GeneralPath)shape).moveTo(x, y);
                ((GeneralPath)shape).lineTo(x + w ,y - (h + 20) / 2);
                ((GeneralPath)shape).lineTo(x + w , y + (h + 20) / 2);

                ((GeneralPath)shape).closePath();
                kopijaSlota.incrementRotations();
            }
            else if(kopijaSlota.getRotations()==3)
            {
                shape=new GeneralPath();
                ((GeneralPath)shape).moveTo(x, y);
                ((GeneralPath)shape).lineTo(x - (h + 20) / 2,y + w);
                ((GeneralPath)shape).lineTo(x + (h+ 20) /2, y + w);
                ((GeneralPath)shape).closePath();
                kopijaSlota.clearRotations();
            }
        }
        else if(element instanceof CircleSlot)
        {
            System.out.println("Ne moze se rotirati krug");
        }
    }
}


