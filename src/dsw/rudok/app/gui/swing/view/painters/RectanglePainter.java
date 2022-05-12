package dsw.rudok.app.gui.swing.view.painters;


import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.io.Serializable;

public class RectanglePainter extends DevicePainter implements Serializable {
    public RectanglePainter(Slot device) {
        super(device);
        Slot rectangle = (Slot) device;

        shape=new GeneralPath();
        ((GeneralPath)shape).moveTo(rectangle.getPosition().x,rectangle.getPosition().y);

        ((GeneralPath)shape).lineTo(rectangle.getPosition().x+rectangle.getSize().width,rectangle.getPosition().y);

        ((GeneralPath)shape).lineTo(rectangle.getPosition().x+rectangle.getSize().width,rectangle.getPosition().y+rectangle.getSize().height);

        ((GeneralPath)shape).lineTo(rectangle.getPosition().x,rectangle.getPosition().y+rectangle.getSize().height);

        ((GeneralPath)shape).closePath();


    }
}
