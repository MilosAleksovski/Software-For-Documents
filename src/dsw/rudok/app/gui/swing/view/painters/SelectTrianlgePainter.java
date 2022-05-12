package dsw.rudok.app.gui.swing.view.painters;

import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.geom.GeneralPath;

public class SelectTrianlgePainter extends DevicePainter {


    public SelectTrianlgePainter(Slot device) {
        super(device);
        Slot tE = (Slot) device;

        double x = tE.getPosition().getX();
        double y = tE.getPosition().getY();

        double w = tE.getSize().getWidth();
        double h = tE.getSize().getHeight();



        shape=new GeneralPath();


        ((GeneralPath)shape).moveTo(x, y);
        ((GeneralPath)shape).lineTo(x + 5, y);
        ((GeneralPath)shape).lineTo(x + 5, y - 10);
        ((GeneralPath)shape).lineTo(x - 5, y - 10);
        ((GeneralPath)shape).lineTo(x - 5, y);
        ((GeneralPath)shape).lineTo(x, y);

        ((GeneralPath)shape).lineTo(x - (h + 20) / 2 ,y + w);
        ((GeneralPath)shape).lineTo(x - (h + 20) / 2 - 10 ,y + w );
        ((GeneralPath)shape).lineTo(x - (h + 20) / 2 - 10,y + w + 10);
        ((GeneralPath)shape).lineTo(x - (h + 20) / 2,y + w + 10);
        ((GeneralPath)shape).lineTo(x - (h + 20) / 2,y + w);

        ((GeneralPath)shape).lineTo(x + (h+ 20) / 2, y + w);
        ((GeneralPath)shape).lineTo(x + (h+ 20) / 2 + 10, y + w);
        ((GeneralPath)shape).lineTo(x + (h+ 20) / 2 + 10, y + w + 10);
        ((GeneralPath)shape).lineTo(x + (h+ 20) / 2, y + w + 10);
        ((GeneralPath)shape).lineTo(x + (h+ 20) / 2, y + w);

        ((GeneralPath)shape).closePath();

        donjiD = new GeneralPath();
        ((GeneralPath)donjiD).moveTo(x + (h+ 20) / 2, y + w);
        ((GeneralPath)donjiD).lineTo(x + (h+ 20) / 2 + 10, y + w);
        ((GeneralPath)donjiD).lineTo(x + (h+ 20) / 2 + 10, y + w + 10);
        ((GeneralPath)donjiD).lineTo(x + (h+ 20) / 2, y + w + 10);
        ((GeneralPath)donjiD).closePath();

        donjiL = new GeneralPath();
        ((GeneralPath)donjiL).moveTo(x - (h + 20) / 2 ,y + w);
        ((GeneralPath)donjiL).lineTo(x - (h + 20) / 2 - 10 ,y + w );
        ((GeneralPath)donjiL).lineTo(x - (h + 20) / 2 - 10,y + w + 10);
        ((GeneralPath)donjiL).lineTo(x - (h + 20) / 2,y + w + 10);
        ((GeneralPath)donjiL).closePath();

        gornjiD = new GeneralPath();
        ((GeneralPath)gornjiD).moveTo(x, y);
        ((GeneralPath)gornjiD).lineTo(x + 5, y);
        ((GeneralPath)gornjiD).lineTo(x + 5, y - 10);
        ((GeneralPath)gornjiD).lineTo(x - 5, y - 10);
        ((GeneralPath)gornjiD).lineTo(x - 5, y);
        ((GeneralPath)gornjiD).closePath();


    }
}
