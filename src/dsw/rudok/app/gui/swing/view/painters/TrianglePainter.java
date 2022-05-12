package dsw.rudok.app.gui.swing.view.painters;

import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.geom.GeneralPath;

public class TrianglePainter extends DevicePainter {
    public TrianglePainter(Slot device) {
        super(device);

        Slot tE = (Slot) device;

        shape=new GeneralPath();

        double h = tE.getSize().height;
        double w = tE.getSize().width;

        double x = tE.getPosition().getX();
        double y = tE.getPosition().getY();

        ((GeneralPath)shape).moveTo(x, y);
        ((GeneralPath)shape).lineTo(x - (h + 20) / 2,y + w);
        ((GeneralPath)shape).lineTo(x + (h+ 20) /2, y + w);

        ((GeneralPath)shape).closePath();
        System.out.println("AAA");
    }
}
