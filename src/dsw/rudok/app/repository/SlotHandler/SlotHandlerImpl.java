package dsw.rudok.app.repository.SlotHandler;

import dsw.rudok.app.commands.*;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.gui.swing.view.painters.*;

import dsw.rudok.app.repository.SlotFactory.*;
import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.workspace.slot.CircleSlot;
import dsw.rudok.app.repository.workspace.slot.RectangleSlot;
import dsw.rudok.app.repository.workspace.slot.Slot;
import dsw.rudok.app.repository.workspace.slot.TriangleSlot;

import java.awt.*;
import java.awt.event.MouseEvent;


public class SlotHandlerImpl implements SlotHandler {
     private static double x, y;
     private static String typeOfResize = null;
     private static int pogodjeni;
     private static Slot lassoRect;

    @Override
    public void moveSlot(Page mediator,MouseEvent e) {
        x = e.getX();
        y = e.getY();
        pogodjeni = mediator.getpModel().getElementAtPosition(e.getPoint());
        int i = 0;
        System.out.println(pogodjeni);
        for(Slot slot:mediator.getpModel().getPageElements()){
            if(i++ == pogodjeni){
                if(!slot.getPaint().equals(Color.blue)){
                    pogodjeni = - 1;
                    break;
                }
            }
        }
    }


    @Override
    public void moveSlot2(Page mediator, MouseEvent e) {

        System.out.println(pogodjeni);
        if(pogodjeni != -1) {
            double xSize = e.getX() - x;
            double ySize = e.getY() - y;

            x = e.getX();
            y = e.getY();
            if(mediator.getpModel().getSlotovi().size()  != 0) {
                for (Slot kopijaSlota : mediator.getpModel().getSlotovi()) {

                    if (kopijaSlota == null)
                        return;

                    Point point = new Point((int) (kopijaSlota.getPosition().getX() + xSize), (int) (kopijaSlota.getPosition().getY() + ySize));
                    mediator.getpModel().obrisiElementIzListe(kopijaSlota);

                    kopijaSlota.setPosition(point);

                    if (kopijaSlota.getElementPainter() instanceof TrianglePainter) {
                        kopijaSlota.napraviNoviTPainter();
                    }
                    if (kopijaSlota.getElementPainter() instanceof CirclePainter) {
                        kopijaSlota.napraviNoviCPainter();
                    }
                    if (kopijaSlota.getElementPainter() instanceof RectanglePainter) {
                        kopijaSlota.napraviNoviRPainter();
                    }
                    if (kopijaSlota.getElementPainter() instanceof RotatePainter) {

                        kopijaSlota.napraviNoviRotatePainter2(kopijaSlota);
                    }


                    Point point2 = new Point();
                    point2.setLocation(kopijaSlota.getPosition());



                    mediator.getpModel().dodajElementUListu(kopijaSlota);
                    mediator.getCommandManager().addCommand(new MoveCommand(kopijaSlota, mediator.getpModel(),CommandsEnum.MOVE,kopijaSlota.getPosition(),kopijaSlota.getSize(), kopijaSlota.getAngle()));


                }
            }
            else if(mediator.getSelektovaniSlot() != null) {

                Slot kopijaSlota = mediator.getSelektovaniSlot();

                Point point = new Point((int) (kopijaSlota.getPosition().getX() + xSize), (int) (kopijaSlota.getPosition().getY() + ySize));
                mediator.getpModel().obrisiElementIzListe(kopijaSlota);

                kopijaSlota.setPosition(point);

                if (kopijaSlota.getElementPainter() instanceof TrianglePainter) {
                    kopijaSlota.napraviNoviTPainter();
                }
                if (kopijaSlota.getElementPainter() instanceof CirclePainter) {
                    kopijaSlota.napraviNoviCPainter();
                }
                if (kopijaSlota.getElementPainter() instanceof RectanglePainter) {
                    System.out.println("AFAS");
                    kopijaSlota.napraviNoviRPainter();
                }
                if (kopijaSlota.getElementPainter() instanceof RotatePainter) {

                    kopijaSlota.napraviNoviRotatePainter2(kopijaSlota);
                }
                mediator.getpModel().dodajElementUListu(kopijaSlota);
                AddDeviceComand addDeviceComand = new MoveCommand( kopijaSlota, mediator.getpModel(),CommandsEnum.MOVE, kopijaSlota.getPosition(), kopijaSlota.getSize(),kopijaSlota.getAngle());
                mediator.getCommandManager().addCommand(addDeviceComand);

            }
        }
    }

    @Override
    public void resizeSlot(Page mediator,MouseEvent e) {
        typeOfResize = mediator.getpModel().getElementAtPosition2(e.getPoint());

        if(typeOfResize == null){
            if(mediator.getpModel().getElementAtPosition(e.getPoint()) != -1){
                typeOfResize = "krug";
            }
            else    return;
        }
        if(typeOfResize != null){


            this.x = e.getX();
            this.y = e.getY();
        }
    }

    @Override
    public void resizeSlot2(Page mediator, MouseEvent e) {
        double xSize = e.getX() - x;
        double ySize = e.getY() - y;


        x = e.getX();
        y = e.getY();

        for (Slot kopijaSlota : mediator.getpModel().getSlotovi()) {

            if (typeOfResize != null) {


                mediator.getpModel().obrisiElementIzListe(kopijaSlota);
                if (kopijaSlota instanceof CircleSlot) {

                    kopijaSlota.getSize().setSize(kopijaSlota.getSize().width + xSize, kopijaSlota.getSize().height + ySize);
                    kopijaSlota.napraviNoviCPainter();
                    mediator.getpModel().dodajElementUListu(kopijaSlota);

                    Dimension dimension = kopijaSlota.getSize();
                    Point point = kopijaSlota.getPosition();

                    AddDeviceComand addDeviceComand = new ResizeCommand( kopijaSlota, mediator.getpModel(), CommandsEnum.RESIZE, point, dimension.getHeight(), dimension.getWidth());
                    mediator.getCommandManager().addCommand(addDeviceComand);
                    continue;
                }


                if (typeOfResize == "donjiDesni") {
                    if (kopijaSlota.getElementPainter() instanceof SelectRotatePainter && kopijaSlota.getI() == 1 && kopijaSlota.getRotations() == 2) {
                        Point point = new Point((int) (kopijaSlota.getPosition().getX()), (int) (kopijaSlota.getPosition().getY() + ySize));
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width + ySize, kopijaSlota.getSize().height + xSize);
                        kopijaSlota.setPosition(point);
                    } else if (kopijaSlota.getElementPainter() instanceof SelectRotatePainter && kopijaSlota.getI() == 1 && kopijaSlota.getRotations() == 1) {
                        Point point = new Point((int) (kopijaSlota.getPosition().getX() + xSize), (int) (kopijaSlota.getPosition().getY() + ySize));
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width + xSize, kopijaSlota.getSize().height + ySize);
                        kopijaSlota.setPosition(point);
                    } else if (kopijaSlota.getElementPainter() instanceof SelectRotatePainter && kopijaSlota.getI() == 1 && kopijaSlota.getRotations() == 0) {
                        Point point = new Point((int) (kopijaSlota.getPosition().getX() + xSize), (int) (kopijaSlota.getPosition().getY()));
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width + ySize, kopijaSlota.getSize().height + xSize);
                        kopijaSlota.setPosition(point);
                    } else if (kopijaSlota instanceof RectangleSlot) {
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width + xSize, kopijaSlota.getSize().height + ySize);
                    } else if (kopijaSlota instanceof TriangleSlot) {
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width + ySize, kopijaSlota.getSize().height + xSize * 2);

                    }

                } else if (typeOfResize == "gornjiLevi") {
                    if (kopijaSlota.getElementPainter() instanceof SelectRotatePainter && kopijaSlota.getI() == 1 && kopijaSlota.getRotations() == 2) {
                        Point point = new Point((int) (kopijaSlota.getPosition().getX() + xSize), (int) (kopijaSlota.getPosition().getY()));
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width - ySize, kopijaSlota.getSize().height - xSize);
                        kopijaSlota.setPosition(point);
                    } else if (kopijaSlota.getElementPainter() instanceof SelectRotatePainter && kopijaSlota.getI() == 1 && kopijaSlota.getRotations() == 1) {
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width - xSize, kopijaSlota.getSize().height - ySize);
                    } else if (kopijaSlota.getElementPainter() instanceof SelectRotatePainter && kopijaSlota.getI() == 1 && kopijaSlota.getRotations() == 0) {
                        Point point = new Point((int) (kopijaSlota.getPosition().getX()), (int) (kopijaSlota.getPosition().getY() + ySize));
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width - ySize, kopijaSlota.getSize().height - xSize);
                        kopijaSlota.setPosition(point);
                    } else if(kopijaSlota instanceof RectangleSlot) {
                        Point point = new Point((int) (kopijaSlota.getPosition().getX() + xSize), (int) (kopijaSlota.getPosition().getY() + ySize));
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width - xSize, kopijaSlota.getSize().height - ySize);
                        kopijaSlota.setPosition(point);
                    }
                    else if(kopijaSlota instanceof TriangleSlot) {
                        Point point = new Point((int) (kopijaSlota.getPosition().getX()), (int) (kopijaSlota.getPosition().getY() + ySize));
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width - ySize, kopijaSlota.getSize().height);
                        kopijaSlota.setPosition(point);
                    }
                } else if (typeOfResize == "donjiLevi") {
                    if (kopijaSlota.getElementPainter() instanceof SelectRotatePainter && kopijaSlota.getI() == 1 && kopijaSlota.getRotations() == 2) {
                        Point point = new Point((int) (kopijaSlota.getPosition().getX() + xSize), (int) (kopijaSlota.getPosition().getY() + ySize));
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width + ySize, kopijaSlota.getSize().height - xSize);
                        kopijaSlota.setPosition(point);
                    } else if (kopijaSlota.getElementPainter() instanceof SelectRotatePainter && kopijaSlota.getI() == 1 && kopijaSlota.getRotations() == 1) {
                        Point point = new Point((int) (kopijaSlota.getPosition().getX()), (int) (kopijaSlota.getPosition().getY() + ySize));
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width - xSize, kopijaSlota.getSize().height + ySize);
                        kopijaSlota.setPosition(point);
                    } else if (kopijaSlota.getElementPainter() instanceof SelectRotatePainter && kopijaSlota.getI() == 1 && kopijaSlota.getRotations() == 0) {
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width + ySize, kopijaSlota.getSize().height - xSize);

                    } else if (kopijaSlota instanceof RectangleSlot) {
                        Point point = new Point((int) (kopijaSlota.getPosition().getX() + xSize), (int) (kopijaSlota.getPosition().getY()));
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width - xSize, kopijaSlota.getSize().height + ySize);
                        kopijaSlota.setPosition(point);
                    } else if (kopijaSlota instanceof TriangleSlot) {
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width + ySize, kopijaSlota.getSize().height - xSize * 2);
                    }
                } else if (typeOfResize == "gornjiDesni") {
                    if (kopijaSlota.getElementPainter() instanceof SelectRotatePainter && kopijaSlota.getI() == 1 && kopijaSlota.getRotations() == 2) {
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width - ySize, kopijaSlota.getSize().height + xSize);
                    } else if (kopijaSlota.getElementPainter() instanceof SelectRotatePainter && kopijaSlota.getI() == 1 && kopijaSlota.getRotations() == 1) {
                        Point point = new Point((int) (kopijaSlota.getPosition().getX() + xSize), (int) (kopijaSlota.getPosition().getY()));
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width + xSize, kopijaSlota.getSize().height - ySize);
                        kopijaSlota.setPosition(point);
                    } else if (kopijaSlota.getElementPainter() instanceof SelectRotatePainter && kopijaSlota.getI() == 1 && kopijaSlota.getRotations() == 0) {
                        Point point = new Point((int) (kopijaSlota.getPosition().getX() + xSize), (int) (kopijaSlota.getPosition().getY() + ySize));
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width - ySize, kopijaSlota.getSize().height + xSize);
                        kopijaSlota.setPosition(point);
                    } else if (kopijaSlota instanceof RectangleSlot) {
                        Point point = new Point((int) (kopijaSlota.getPosition().getX()), (int) (kopijaSlota.getPosition().getY() + ySize));
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width + xSize, kopijaSlota.getSize().height - ySize);
                        kopijaSlota.setPosition(point);
                    } else if (kopijaSlota instanceof TriangleSlot) {
                        Point point = new Point((int) (kopijaSlota.getPosition().getX()), (int) (kopijaSlota.getPosition().getY() + ySize));
                        kopijaSlota.getSize().setSize(kopijaSlota.getSize().width - ySize, kopijaSlota.getSize().height);
                        kopijaSlota.setPosition(point);
                    }

                }


                if (kopijaSlota.getElementPainter() instanceof SelectTrianlgePainter) {
                    kopijaSlota.selektovaniTPainter();
                }
                if (kopijaSlota.getElementPainter() instanceof SelectRectanglePainter) {
                    kopijaSlota.selektovaniRPainter();
                }

                if (kopijaSlota.getElementPainter() instanceof SelectRotatePainter) {
                    kopijaSlota.napraviNoviRotatePainter3(kopijaSlota);
                }

                Dimension dimension = kopijaSlota.getSize();
                Point point = kopijaSlota.getPosition();



                mediator.getpModel().dodajElementUListu(kopijaSlota);
                AddDeviceComand addDeviceComand = new ResizeCommand( kopijaSlota, mediator.getpModel(), CommandsEnum.RESIZE, point, dimension.getHeight(), dimension.getWidth());
                mediator.getCommandManager().addCommand(addDeviceComand);

            }
        }
    }
    @Override
    public void rotateSlot(Page mediator) {
        mediator.getpModel().obrisiElementIzListe(mediator.getSelektovaniSlot());
        if(mediator.getSelektovaniSlot().getElementPainter() instanceof SelectRotatePainter){
            if(mediator.getSelektovaniSlot().getRotations() == 3){
                mediator.getSelektovaniSlot().setRotations(0);
            }
            else{
                mediator.getSelektovaniSlot().incrementRotations();
            }
        }
        mediator.getSelektovaniSlot().napraviNoviRotatePainter1(mediator.getSelektovaniSlot());
        mediator.getpModel().dodajElementUListu(mediator.getSelektovaniSlot());
    }

    @Override
    public void deleteSlot(Page mediator, MouseEvent e) {

        int pogodjeni=0;


        for(Slot s:mediator.getpModel().getPageElements()) {
            if (s.getPaint().equals(Color.blue)) {
                if(((DevicePainter)s.getElementPainter()).getShape().contains(e.getPoint()))
                {

                    pogodjeni=1;
                    break;
                }

            }
        }

        if(pogodjeni==1)
        {
            for(Slot s:mediator.getpModel().getSlotovi())
            {

                mediator.getpModel().obrisiElementIzListe(s);
                mediator.getCommandManager().addCommand(new DeleteCommand(s, mediator.getpModel(),CommandsEnum.DELETE, s.getPosition(), s.getSize(),s.getAngle()));
                GlavniFrame.getInstance().getTree().Delete2(s);
            }
            mediator.getpModel().getSlotovi().clear();
        }

    }



    @Override
    public void napraviSlot(Point point, String type, Page mediator) {


        if (type == "triangle"){
            SlotFactory slotFactory = new TriangleFactory();
            Slot slot = slotFactory.napraviSlot(point, mediator.getName(), mediator);
            mediator.getpModel().dodajElementUListu(slot);
            mediator.getCommandManager().addCommand(new SlotCommand(slot, mediator.getpModel(), CommandsEnum.TRIANGLE, point,slot.getSize(),slot.getAngle()));

            for(Slot slot2: mediator.getpModel().getPageElements()){
                System.out.println(slot2.getPosition().getX() + " " + slot2.getPosition().getY());
            }
            System.out.println("___________________________________");
        }
        if (type == "rectangle"){

            SlotFactory slotFactory = new RectangleFactory();
            Slot slot = slotFactory.napraviSlot(point, mediator.getName(), mediator);
            mediator.getpModel().dodajElementUListu(slot);
            mediator.getCommandManager().addCommand(new SlotCommand(slot, mediator.getpModel(),CommandsEnum.RECTANGLE, point,slot.getSize(),slot.getAngle()));
        }
        if (type == "circle"){
            SlotFactory slotFactory = new CircleFactory();
            Slot slot = slotFactory.napraviSlot(point, mediator.getName(), mediator);
            mediator.getpModel().dodajElementUListu(slot);
            mediator.getCommandManager().addCommand(new SlotCommand(slot, mediator.getpModel(), CommandsEnum.CIRCLE,  point,slot.getSize(),slot.getAngle()));
        }
        if(type=="lasso")
        {
            SlotFactory slotFactory = new LassoFactory();
            lassoRect=slotFactory.napraviSlot(point,"lasso",mediator);
        }

    }

    @Override
    public void rotateSlot2Press(MouseEvent e, Page mediator) {
        pogodjeni = mediator.getpModel().getElementAtPosition(e.getPoint());

        if(pogodjeni != -1){
            int i = 0;
            for(Slot slot:mediator.getpModel().getPageElements()){
                if(i++ == pogodjeni){
                    if(slot.getPaint().equals(Color.blue)){
                        pogodjeni = 1;

                        x = e.getX();
                        y = e.getY();
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void rotateSlot2Drag(MouseEvent e, Page mediator) {

        if(pogodjeni == 1){
            for(Slot s : mediator.getpModel().getSlotovi()) {
                mediator.getpModel().obrisiElementIzListe(s);
                s.angleIncrement();
                mediator.getpModel().dodajElementUListu(s);
                mediator.getCommandManager().addCommand(new RotateCommand(s, mediator.getpModel(),CommandsEnum.ROTATE,s.getPosition(),s.getSize(), s.getAngle()));
            }
        }
    }

    @Override
    public void setStartcord(MouseEvent e,Page mediator) {


        System.out.println(mediator.getpModel().getSlotovi().size() + " VELICINA SELEKTOVANIH");


        if(mediator.getpModel().getSlotovi().size() != 0)
        {
            for(Slot s:mediator.getpModel().getSlotovi())
            {
                s.setPaint(Color.red);
                if(s.getElementPainter() instanceof  SelectRectanglePainter){
                    s.napraviNoviRPainter();
                }
                else if(s.getElementPainter() instanceof  SelectTrianlgePainter){
                    s.napraviNoviTPainter();
                }
            }
            mediator.getpModel().getSlotovi().clear();
        }

        if(mediator.getpModel().getSlotovi().size() == 0)  {

            int pozicijaElementa = mediator.getpModel().getElementAtPosition(e.getPoint());



            int i = 0;

            System.out.println(mediator.getpModel().getPageElements().size());
            if(pozicijaElementa != -1) {
                for (Slot slot : mediator.getpModel().getPageElements()) {
                    if (i++ == pozicijaElementa) {

                        slot.setPaint(Color.blue);
                        mediator.getpModel().fireUpdatePerformed();
                        mediator.getCommandManager().addCommand(new MultiSelectCommand(slot, mediator.getpModel(), CommandsEnum.MULTISELEKT, slot.getPosition(), slot.getSize(), slot.getAngle()));
                        mediator.getpModel().getSlotovi().add(slot);
                        break;
                    }
                }
            }
        }



        this.x=e.getX();
        this.y=e.getY();

        napraviSlot(e.getPoint(),"lasso",mediator);
        lassoRect.getSize().setSize(0,0);

        lassoRect.napraviNoviRPainter();
        mediator.getpModel().dodajElementUListu(lassoRect);


    }

    @Override
    public void setEndCord(Page mediator,MouseEvent e) {
        double xSize = e.getX() - x;
        double ySize = e.getY() - y;

        x = e.getX();
        y = e.getY();

        mediator.getpModel().obrisiElementIzListe(lassoRect);

        lassoRect.getSize().setSize(lassoRect.getSize().width+xSize,lassoRect.getSize().height+ySize);
        lassoRect.napraviNoviRPainter();

        mediator.getpModel().dodajElementUListu(lassoRect);

    }

    @Override
    public void setEndCord2(Page mediator,MouseEvent e) {

        mediator.getpModel().obrisiElementIzListe(lassoRect);

        for(Slot s:mediator.getpModel().getPageElements())
        {

            if (((DevicePainter) lassoRect.getElementPainter()).getShape().getBounds().intersects(s.getPosition().getX(), s.getPosition().getY(), s.getSize().getWidth(), s.getSize().getHeight()) && s.getPaint() != Color.blue) {
                s.setPaint(Color.blue);
                mediator.getpModel().getSlotovi().add(s);
                mediator.getCommandManager().addCommand(new MultiSelectCommand(s, mediator.getpModel(),CommandsEnum.MULTISELEKT,s.getPosition(),s.getSize(), s.getAngle()));

            }


        }

        mediator.getpModel().fireUpdatePerformed();
    }


}