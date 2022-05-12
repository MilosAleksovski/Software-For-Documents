package dsw.rudok.app.gui.swing.view.painters;


import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.*;
import java.io.Serializable;

public abstract class ElementPainter implements Serializable {
    public ElementPainter(Slot element) {	}

    public abstract void paint(Graphics2D g, Slot element);

    public abstract boolean elementAt(Slot element, Point pos);

    public abstract String elementAt2(Slot element, Point pos);



}
