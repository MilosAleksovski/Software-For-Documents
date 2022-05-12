package dsw.rudok.app.gui.swing.view.painters;


import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class CirclePainter extends DevicePainter{

    public CirclePainter(Slot device) {
        super(device);
        Slot cE = (Slot)device;

        shape=new GeneralPath();
        shape =new Ellipse2D.Double(Math.abs(cE.getPosition().getX()), Math.abs(cE.getPosition().getY()), Math.abs(cE.getSize().getWidth()), Math.abs(cE.getSize().getWidth()));

//        ((GeneralPath)shape).moveTo(x, y);
//
//        ((GeneralPath)shape).quadTo();
//
//        ((GeneralPath)shape).lineTo();
//
//        ((GeneralPath)shape).lineTo();
    }
}
