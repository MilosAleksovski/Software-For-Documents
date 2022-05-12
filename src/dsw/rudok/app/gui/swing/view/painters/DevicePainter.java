package dsw.rudok.app.gui.swing.view.painters;


import dsw.rudok.app.gui.swing.view.repositoryMainFrame.PageView;
import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.io.Serializable;

public class DevicePainter extends ElementPainter implements Serializable {
    protected Shape shape;
    protected Shape gornjiD;
    protected Shape donjiD;
    protected Shape donjiL;
    protected Shape gornjiL;





    public DevicePainter(Slot device){
        super(device);
    }

    public void paint(Graphics2D g, Slot element){


           g.setPaint(element.getPaint());

           AffineTransform affineTransform = new AffineTransform();

           g.rotate(element.getAngle() / 4, element.getPosition().getX(), element.getPosition().getY());



           g.draw(shape);

           g.setTransform(affineTransform);



    }



    public boolean elementAt(Slot element, Point pos){
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(element.getAngle() / 4, element.getPosition().getX(), element.getPosition().getY());
        if(affineTransform.createTransformedShape(shape).contains(pos)){
            return true;
        }

        return false;

    }





    public String elementAt2(Slot element, Point pos){
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(element.getAngle() / 4, element.getPosition().getX(), element.getPosition().getY());


        if(affineTransform.createTransformedShape(donjiL).contains(pos.getX(), pos.getY())){
            System.out.println("Pogodio donjiLevi");
            return "donjiLevi";
        }
        if(affineTransform.createTransformedShape(donjiD).contains(pos.getX(), pos.getY())){
            System.out.println("Pogodio donjiDesni");
            return "donjiDesni";
        }
        if(gornjiL != null) {
            if (affineTransform.createTransformedShape(gornjiL).contains(pos.getX(), pos.getY())) {
                System.out.println("Pogodio gornjiLevi");
                return "gornjiLevi";
            }
        }

        if(affineTransform.createTransformedShape(gornjiD).contains(pos.getX(), pos.getY())){
            System.out.println("Pogodio gornjiDesni");
            return "gornjiDesni";
        }

        return null;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
