package dsw.rudok.app.gui.swing.view.painters;

import dsw.rudok.app.repository.workspace.slot.CircleSlot;
import dsw.rudok.app.repository.workspace.slot.RectangleSlot;
import dsw.rudok.app.repository.workspace.slot.Slot;
import dsw.rudok.app.repository.workspace.slot.TriangleSlot;

import java.awt.geom.GeneralPath;

public class SelectRotatePainter extends DevicePainter {
    public SelectRotatePainter(Slot device,Slot kopijaSlota) {
        super(device);
        Slot element = (Slot) device;

        System.out.println("Postavi resize za rotateP" + element.getRotations());
        double h = element.getSize().height;
        double w = element.getSize().width;

        double x = element.getPosition().getX();
        double y = element.getPosition().getY();


        if (element instanceof RectangleSlot) {
            element.setI(1);
            if (kopijaSlota.getRotations() == 0) {
                shape = new GeneralPath();
                System.out.println("Usao u 0");

                ((GeneralPath) shape).moveTo(element.getPosition().x, element.getPosition().y); //pocetna

                ((GeneralPath) shape).lineTo(element.getPosition().x - element.getSize().height, element.getPosition().y); // levo

                ((GeneralPath)shape).lineTo(x-h-10,y);
                ((GeneralPath)shape).lineTo(x-h-10,y-10);
                ((GeneralPath)shape).lineTo(x-h,y-10);
                ((GeneralPath)shape).lineTo(x-h,y);

                ((GeneralPath) shape).lineTo(element.getPosition().x - element.getSize().height, element.getPosition().y + element.getSize().width); //dole

                ((GeneralPath)shape).lineTo(x-h,y+w+10);
                ((GeneralPath)shape).lineTo(x-h-10,y+w+10);
                ((GeneralPath)shape).lineTo(x-h-10,y+w);
                ((GeneralPath)shape).lineTo(x-h,y+w);

                ((GeneralPath) shape).lineTo(element.getPosition().x, element.getPosition().y + element.getSize().width); //desno

                ((GeneralPath)shape).lineTo(x+10,y+w);
                ((GeneralPath)shape).lineTo(x+10,y+w+10);
                ((GeneralPath)shape).lineTo(x,y+w+10);
                ((GeneralPath)shape).lineTo(x,y+w);

                ((GeneralPath)shape).lineTo(x,y); //pocetna

                ((GeneralPath)shape).lineTo(x,y-10);
                ((GeneralPath)shape).lineTo(x+10,y-10);
                ((GeneralPath)shape).lineTo(x+10,y);
                ((GeneralPath)shape).lineTo(x,y);

                ((GeneralPath) shape).closePath(); //kraj

                gornjiD = new GeneralPath();
                ((GeneralPath)gornjiD).moveTo(x, y);
                ((GeneralPath)gornjiD).lineTo(x+10,y);
                ((GeneralPath)gornjiD).lineTo(x+ 10, y - 10);
                ((GeneralPath)gornjiD).lineTo(x, y - 10);
                ((GeneralPath)gornjiD).closePath();

                gornjiL=new GeneralPath();
                ((GeneralPath)gornjiL).moveTo(x-h,y);
                ((GeneralPath)gornjiL).lineTo(x-h-10,y);
                ((GeneralPath)gornjiL).lineTo(x-h-10,y-10);
                ((GeneralPath)gornjiL).lineTo(x-h,y-10);
                ((GeneralPath)gornjiL).closePath();

                donjiD=new GeneralPath();
                ((GeneralPath)donjiD).moveTo(x,y+w);
                ((GeneralPath)donjiD).lineTo(x+10,y+w);
                ((GeneralPath)donjiD).lineTo(x+10,y+w+10);
                ((GeneralPath)donjiD).lineTo(x,y+w+10);
                ((GeneralPath)donjiD).closePath();

                donjiL=new GeneralPath();
                ((GeneralPath)donjiL).moveTo(x-h,y+w);
                ((GeneralPath)donjiL).lineTo(x-h-10,y+w);
                ((GeneralPath)donjiL).lineTo(x-h-10,y+w+10);
                ((GeneralPath)donjiL).lineTo(x-h,y+w+10);
                ((GeneralPath)donjiL).closePath();

            } else if (kopijaSlota.getRotations() == 1) {
                shape = new GeneralPath();

                ((GeneralPath) shape).moveTo(element.getPosition().x, element.getPosition().y);

                ((GeneralPath) shape).lineTo(element.getPosition().x - w, element.getPosition().y);

                ((GeneralPath)shape).lineTo(x-w-10,y);
                ((GeneralPath)shape).lineTo(x-w-10,y+10);
                ((GeneralPath)shape).lineTo(x-w,y+10);
                ((GeneralPath)shape).lineTo(x-w,y);

                ((GeneralPath) shape).lineTo(element.getPosition().x - w, element.getPosition().y-element.getSize().height);

                ((GeneralPath)shape).lineTo(x-w,y-h-10);
                ((GeneralPath)shape).lineTo(x-w-10,y-h-10);
                ((GeneralPath)shape).lineTo(x-w-10,y-h);
                ((GeneralPath)shape).lineTo(x-w,y-h);

                ((GeneralPath) shape).lineTo(element.getPosition().x , element.getPosition().y - h);

                ((GeneralPath)shape).lineTo(x+10,y-h);
                ((GeneralPath)shape).lineTo(x+10,y-h-10);
                ((GeneralPath)shape).lineTo(x,y-h-10);
                ((GeneralPath)shape).lineTo(x,y-h);

                ((GeneralPath)shape).lineTo(x,y);

                ((GeneralPath)shape).lineTo(x,y+10);
                ((GeneralPath)shape).lineTo(x+10,y+10);
                ((GeneralPath)shape).lineTo(x+10,y);
                ((GeneralPath)shape).lineTo(x,y);

                ((GeneralPath) shape).closePath();

                donjiL=new GeneralPath();
                ((GeneralPath)donjiL).moveTo(x-w,y);
                ((GeneralPath)donjiL).lineTo(x-w-10,y);
                ((GeneralPath)donjiL).lineTo(x-w-10,y+10);
                ((GeneralPath)donjiL).lineTo(x-w,y+10);
                ((GeneralPath)donjiL).closePath();

                gornjiL=new GeneralPath();
                ((GeneralPath)gornjiL).moveTo(x-w,y-h);
                ((GeneralPath)gornjiL).lineTo(x-w,y-h-10);
                ((GeneralPath)gornjiL).lineTo(x-w-10,y-h-10);
                ((GeneralPath)gornjiL).lineTo(x-w-10,y-h);
                ((GeneralPath)gornjiL).closePath();

                gornjiD=new GeneralPath();
                ((GeneralPath)gornjiD).moveTo(x,y-h);
                ((GeneralPath)gornjiD).lineTo(x+10,y-h);
                ((GeneralPath)gornjiD).lineTo(x+10,y-h-10);
                ((GeneralPath)gornjiD).lineTo(x,y-h-10);
                ((GeneralPath)gornjiD).closePath();

                donjiD=new GeneralPath();
                ((GeneralPath)donjiD).moveTo(x,y);
                ((GeneralPath)donjiD).lineTo(x,y+10);
                ((GeneralPath)donjiD).lineTo(x+10,y+10);
                ((GeneralPath)donjiD).lineTo(x+10,y);
                ((GeneralPath)donjiD).closePath();

            } else if (kopijaSlota.getRotations() == 2) {
                System.out.println("Usao u 2");
                shape = new GeneralPath();
                ((GeneralPath) shape).moveTo(element.getPosition().x, element.getPosition().y);

                ((GeneralPath) shape).lineTo(element.getPosition().x + h, element.getPosition().y);

                ((GeneralPath)shape).lineTo(x+h+10,y);
                ((GeneralPath)shape).lineTo(x+h+10,y+10);
                ((GeneralPath)shape).lineTo(x+h,y+10);
                ((GeneralPath)shape).lineTo(x+h,y);

                ((GeneralPath) shape).lineTo(element.getPosition().x + h, element.getPosition().y-element.getSize().width);

                ((GeneralPath)shape).lineTo(x+h,y-w-10);
                ((GeneralPath)shape).lineTo(x+h+10,y-w-10);
                ((GeneralPath)shape).lineTo(x+h+10,y-w);
                ((GeneralPath)shape).lineTo(x+h-10,y-w);

                ((GeneralPath) shape).lineTo(element.getPosition().x , element.getPosition().y - w);

                ((GeneralPath)shape).lineTo(x-10,y-w);
                ((GeneralPath)shape).lineTo(x-10,y-w-10);
                ((GeneralPath)shape).lineTo(x,y-w-10);
                ((GeneralPath)shape).lineTo(x,y-w+10);

                ((GeneralPath)shape).lineTo(x,y);

                ((GeneralPath)shape).lineTo(x,y+10);
                ((GeneralPath)shape).lineTo(x-10,y+10);
                ((GeneralPath)shape).lineTo(x-10,y);
                ((GeneralPath)shape).lineTo(x,y);

                ((GeneralPath) shape).closePath();

                donjiD=new GeneralPath();
                ((GeneralPath)donjiD).moveTo(x+h,y);
                ((GeneralPath)donjiD).lineTo(x+h+10,y);
                ((GeneralPath)donjiD).lineTo(x+h+10,y+10);
                ((GeneralPath)donjiD).lineTo(x+h,y+10);
                ((GeneralPath)donjiD).closePath();

                gornjiD=new GeneralPath();
                ((GeneralPath)gornjiD).moveTo(x+h,y-w);
                ((GeneralPath)gornjiD).lineTo(x+h,y-w-10);
                ((GeneralPath)gornjiD).lineTo(x+h+10,y-w-10);
                ((GeneralPath)gornjiD).lineTo(x+h+10,y-w);
                ((GeneralPath)gornjiD).closePath();

                gornjiL=new GeneralPath();
                ((GeneralPath)gornjiL).moveTo(x,y-w);
                ((GeneralPath)gornjiL).lineTo(x-10,y-w);
                ((GeneralPath)gornjiL).lineTo(x-10,y-w-10);
                ((GeneralPath)gornjiL).lineTo(x,y-w-10);
                ((GeneralPath)gornjiL).closePath();

                donjiL=new GeneralPath();
                ((GeneralPath)donjiL).moveTo(x,y);
                ((GeneralPath)donjiL).lineTo(x,y+10);
                ((GeneralPath)donjiL).lineTo(x-10,y+10);
                ((GeneralPath)donjiL).lineTo(x-10,y);
                ((GeneralPath)donjiL).closePath();

            } else if (kopijaSlota.getRotations() == 3) {
                shape=new GeneralPath();
                System.out.println("Usao u 3");
                ((GeneralPath)shape).moveTo(element.getPosition().x,element.getPosition().y);

                ((GeneralPath)shape).lineTo(element.getPosition().x+element.getSize().width,element.getPosition().y);

                ((GeneralPath)shape).lineTo(x + w,y - 10);
                ((GeneralPath)shape).lineTo(x + w + 10, y- 10);
                ((GeneralPath)shape).lineTo(x + w + 10, y);
                ((GeneralPath)shape).lineTo(x + w, y);

                ((GeneralPath)shape).lineTo(x + w, y + h);

                ((GeneralPath)shape).lineTo(x + w + 10, y + h);
                ((GeneralPath)shape).lineTo(x + w + 10, y + h + 10);
                ((GeneralPath)shape).lineTo(x + w, y + h + 10);
                ((GeneralPath)shape).lineTo(x + w, y + h);

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
                ((GeneralPath)gornjiD).moveTo(x + w,y);
                ((GeneralPath)gornjiD).lineTo(x + w + 10, y);
                ((GeneralPath)gornjiD).lineTo(x + w + 10, y - 10);
                ((GeneralPath)gornjiD).lineTo(x + w , y - 10);
                ((GeneralPath)gornjiD).closePath();


                donjiD = new GeneralPath();
                ((GeneralPath)donjiD).moveTo(x + w, y + h);
                ((GeneralPath)donjiD).lineTo(x + w + 10, y + h);
                ((GeneralPath)donjiD).lineTo(x + w + 10, y + h + 10);
                ((GeneralPath)donjiD).lineTo(x + w , y + h + 10);
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
            }

        }
        else if(element instanceof TriangleSlot)
        {

            if (kopijaSlota.getRotations() == 0) {
                shape = new GeneralPath();
                ((GeneralPath)shape).moveTo(x, y);

                ((GeneralPath)shape).lineTo(x - w ,y - (h + 20) / 2);

                ((GeneralPath)shape).lineTo(x - w-10,y - (h + 20) / 2);
                ((GeneralPath)shape).lineTo(x - w - 10, (y - (h + 20) / 2)-10);
                ((GeneralPath)shape).lineTo(x - w , (y - (h + 20) / 2)-10);
                ((GeneralPath)shape).lineTo(x - w, (y - (h + 20) / 2));

                ((GeneralPath)shape).lineTo(x - w , y + (h + 20) / 2);

                ((GeneralPath)shape).lineTo(x - w,(y + (h + 20) / 2)+10);
                ((GeneralPath)shape).lineTo(x - w - 10, (y + (h + 20) / 2)+10);
                ((GeneralPath)shape).lineTo(x - w -10 , (y + (h + 20) / 2));
                ((GeneralPath)shape).lineTo(x - w, (y + (h + 20) / 2));

                ((GeneralPath)shape).lineTo(x ,y);

                ((GeneralPath)shape).lineTo(x ,y-5);
                ((GeneralPath)shape).lineTo(x+10, y-5);
                ((GeneralPath)shape).lineTo(x +10 ,y+5);
                ((GeneralPath)shape).lineTo(x, y+5);
                ((GeneralPath)shape).lineTo(x, y);

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


                kopijaSlota.incrementRotations();

            } else if (kopijaSlota.getRotations() == 1)
            {
                shape = new GeneralPath();
                ((GeneralPath)shape).moveTo(x, y);

                ((GeneralPath)shape).lineTo(x - (h + 20) / 2,y - w);

                ((GeneralPath)shape).lineTo((x - (h + 20) / 2)-10,y - w);
                ((GeneralPath)shape).lineTo((x - (h + 20) / 2)-10,y - w-10);
                ((GeneralPath)shape).lineTo((x - (h + 20) / 2),y - w-10);
                ((GeneralPath)shape).lineTo((x - (h + 20) / 2),y - w);

                ((GeneralPath)shape).lineTo(x + (h+ 20) /2, y - w);

                ((GeneralPath)shape).lineTo((x + (h+ 20) /2)+10, y - w);
                ((GeneralPath)shape).lineTo((x + (h+ 20) /2)+10, y - w-10);
                ((GeneralPath)shape).lineTo(x + (h+ 20) /2, y - w-10);
                ((GeneralPath)shape).lineTo(x + (h+ 20) /2, y - w);

                ((GeneralPath)shape).lineTo(x ,y);

                ((GeneralPath)shape).lineTo(x-5 ,y);
                ((GeneralPath)shape).lineTo(x-5, y+10);
                ((GeneralPath)shape).lineTo(x +5 ,y+10);
                ((GeneralPath)shape).lineTo(x+5, y);
                ((GeneralPath)shape).lineTo(x, y);

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

                kopijaSlota.incrementRotations();
            }
            else if (kopijaSlota.getRotations() == 2)
            {
                shape = new GeneralPath();
                ((GeneralPath)shape).moveTo(x, y);

                ((GeneralPath)shape).lineTo(x + w ,y - (h + 20) / 2);

                ((GeneralPath)shape).lineTo(x + w +10 ,y - (h + 20) / 2);
                ((GeneralPath)shape).lineTo(x + w +10 ,(y - (h + 20) / 2)-10);
                ((GeneralPath)shape).lineTo(x + w ,(y - (h + 20) / 2)-10);
                ((GeneralPath)shape).lineTo(x + w ,y - (h + 20) / 2);

                ((GeneralPath)shape).lineTo(x + w , y + (h + 20) / 2);

                ((GeneralPath)shape).lineTo(x + w , (y + (h + 20) / 2)+10);
                ((GeneralPath)shape).lineTo(x + w + 10 , (y + (h + 20) / 2)+10);
                ((GeneralPath)shape).lineTo(x + w + 10 , (y + (h + 20) / 2));
                ((GeneralPath)shape).lineTo(x + w  , (y + (h + 20) / 2));

                ((GeneralPath)shape).lineTo(x , y);

                ((GeneralPath)shape).lineTo(x , y-5);
                ((GeneralPath)shape).lineTo(x-10 , y-5);
                ((GeneralPath)shape).lineTo(x-10 , y+5);
                ((GeneralPath)shape).lineTo(x , y+5);
                ((GeneralPath)shape).lineTo(x , y);

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


                kopijaSlota.incrementRotations();
            }
            else if(kopijaSlota.getRotations()==3)
            {
                shape = new GeneralPath();
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
                kopijaSlota.clearRotations();
            }
        }
        else if(element instanceof CircleSlot)
        {
            System.out.println("Ne moze se rotirati krug");
        }
    }
    }

