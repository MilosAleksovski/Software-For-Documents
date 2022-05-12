package dsw.rudok.app.gui.swing.view.painters;

import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.geom.GeneralPath;

public class SelectRectanglePainter extends DevicePainter {

    public SelectRectanglePainter(Slot device) {
        super(device);
        Slot rectangle = (Slot) device;

        double x = rectangle.getPosition().getX();
        double y = rectangle.getPosition().getY();
        shape=new GeneralPath();

        int width = rectangle.getSize().width;
        int h = rectangle.getSize().height;

        ((GeneralPath)shape).moveTo(rectangle.getPosition().x,rectangle.getPosition().y);

        ((GeneralPath)shape).lineTo(rectangle.getPosition().x+rectangle.getSize().width,rectangle.getPosition().y);

        ((GeneralPath)shape).lineTo(x + width,y - 10);
        ((GeneralPath)shape).lineTo(x + width + 10, y- 10);
        ((GeneralPath)shape).lineTo(x + width + 10, y);
        ((GeneralPath)shape).lineTo(x + width, y);

        ((GeneralPath)shape).lineTo(x + width, y + h);

        ((GeneralPath)shape).lineTo(x + width + 10, y + h);
        ((GeneralPath)shape).lineTo(x + width + 10, y + h + 10);
        ((GeneralPath)shape).lineTo(x + width, y + h + 10);
        ((GeneralPath)shape).lineTo(x + width, y + h);

        ((GeneralPath)shape).lineTo(x, y + h);

        ((GeneralPath)shape).lineTo(x, y + h + 10);
        ((GeneralPath)shape).lineTo(x - 10, y + h  + 10);
        ((GeneralPath)shape).lineTo(x - 10, y + h);
        ((GeneralPath)shape).lineTo(x, y + h);

        ((GeneralPath)shape).lineTo(x, y);

        ((GeneralPath)shape).lineTo(x, y - 10);
        ((GeneralPath)shape).lineTo(x - 10, y - 10);
        ((GeneralPath)shape).lineTo(x - 10, y);

        ((GeneralPath)shape).closePath();


        gornjiD = new GeneralPath();
        ((GeneralPath)gornjiD).moveTo(x + width,y);
        ((GeneralPath)gornjiD).lineTo(x + width + 10, y);
        ((GeneralPath)gornjiD).lineTo(x + width + 10, y - 10);
        ((GeneralPath)gornjiD).lineTo(x + width , y - 10);
        ((GeneralPath)gornjiD).closePath();


        donjiD = new GeneralPath();
        ((GeneralPath)donjiD).moveTo(x + width, y + h);
        ((GeneralPath)donjiD).lineTo(x + width + 10, y + h);
        ((GeneralPath)donjiD).lineTo(x + width + 10, y + h + 10);
        ((GeneralPath)donjiD).lineTo(x + width , y + h + 10);
        ((GeneralPath)donjiD).closePath();


        donjiL = new GeneralPath();
        ((GeneralPath)donjiL).moveTo(x, y + h);
        ((GeneralPath)donjiL).lineTo(x - 10, y + h );
        ((GeneralPath)donjiL).lineTo(x - 10, y + h  + 10);
        ((GeneralPath)donjiL).lineTo(x, y + h + 10);
        ((GeneralPath)donjiL).closePath();

        gornjiL = new GeneralPath();
        ((GeneralPath)gornjiL).moveTo(x, y);
        ((GeneralPath)gornjiL).lineTo(x , y - 10);
        ((GeneralPath)gornjiL).lineTo(x - 10, y - 10);
        ((GeneralPath)gornjiL).lineTo(x - 10, y);
        ((GeneralPath)gornjiL).closePath();





        System.out.println("AAA");
    }
}
