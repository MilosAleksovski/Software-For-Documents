package dsw.rudok.app.repository.workspace.slot;

import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.gui.swing.view.painters.*;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.workspace.slot.CircleSlot;
import dsw.rudok.app.repository.workspace.slot.RectangleSlot;
import dsw.rudok.app.repository.workspace.slot.TriangleSlot;

import java.awt.*;
import java.io.File;
import java.io.Serializable;
import java.util.Random;

public abstract class Slot extends RuNode implements Serializable {

    private static int slotCounter=1;
    protected Dimension size;
    protected Point position;
    protected String name;
    protected ElementPainter elementPainter;
    protected Paint paint;
    private  int rotations=0;
    private int r = 0, i = 0;
    private double angle = 0;
    private String type=null;
    private File file;

    public Slot( Point position, String name, RuNode parent) {
        super(name, parent);
        this.position = position;
        this.name = "Slot" + slotCounter++;
        paint = Color.red;
        if(this instanceof RectangleSlot || this instanceof TriangleSlot || this instanceof CircleSlot) {
            GlavniFrame.getInstance().getTree().addSlot(this);
        }

    }


    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public double getAngle() {
        return angle;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public Paint getPaint() {
        return paint;
    }
    public void selektovaniRPainter(){
        elementPainter = new SelectRectanglePainter(this);
    }
    public void selektovaniTPainter(){
        elementPainter = new SelectTrianlgePainter(this);
    }


    public void angleIncrement(){

        this.angle += 0.1;
    }


    public void selektovaniRotatePainter(Slot selektovaniSlot){
        if(rotations == 0){
            rotations = 3;
        }
        else {
            rotations--;
        }
        elementPainter=new SelectRotatePainter(this,selektovaniSlot);}

    public void napraviNoviRPainter(){
        elementPainter = new RectanglePainter(this) ;

    }
    public void napraviNoviCPainter(){
        elementPainter = new CirclePainter(this) ;

    }
    public void napraviNoviTPainter(){
        elementPainter = new TrianglePainter(this) ;

    }


    public void napraviNoviRotatePainter1(Slot kopijaslota)
    {

        elementPainter=new RotatePainter(this,kopijaslota);

    }

    public void napraviNoviRotatePainter2(Slot kopijaslota)
    {
        System.out.println(rotations + "NAPRAVI ROTATEPAINTER2");
        elementPainter=new RotatePainter(this,kopijaslota);

        if(rotations == 0){
            rotations = 3;
        }
        else {
            rotations--;
        }


    }
    public void napraviNoviRotatePainter3(Slot kopijaslota)
    {

        elementPainter=new SelectRotatePainter(this,kopijaslota);
    }


    public  int getRotations() {
        return rotations;
    }
    public  void incrementRotations()
    {
        this.rotations++;
    }
    public void clearRotations()
    {
        rotations=0;
    }

    public void setRotations(int rotations) {
        this.rotations = rotations;
    }

    public static int getSlotCounter() {
        return slotCounter++;
    }

    public Dimension getSize() {
        return size;
    }

    public ElementPainter getElementPainter() {
        return elementPainter;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public RuNode getParent() {
        return super.getParent();
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setI(int i) {
        this.i = i;
    }


    public int getI() {
        return i;
    }


    public void setAngle(double angle) {
        this.angle = angle;
    }


    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
