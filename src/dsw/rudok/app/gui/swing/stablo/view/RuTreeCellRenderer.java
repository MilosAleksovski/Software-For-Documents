package dsw.rudok.app.gui.swing.stablo.view;

import dsw.rudok.app.gui.swing.stablo.model.RuTreeItem;
import dsw.rudok.app.repository.workspace.*;
import dsw.rudok.app.repository.workspace.slot.Slot;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class RuTreeCellRenderer extends DefaultTreeCellRenderer {

    public RuTreeCellRenderer() {
    }

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row, hasFocus);

        ImageIcon icon;
        if (((RuTreeItem)value).getNode() instanceof Workspace) {
            URL imageURL = getClass().getResource("slike/workspace.png");



            if (imageURL != null) {
                icon = new ImageIcon(imageURL);
                setIcon(icon);
            }

        } else if (((RuTreeItem)value).getNode() instanceof Project) {
            URL imageURL = getClass().getResource("slike/projekatzelenii.png");
           
            if (imageURL != null) {
                icon = new ImageIcon(imageURL);
                setIcon(icon);
            }
        }
        else if (((RuTreeItem)value).getNode() instanceof Document) {
            URL imageURL = getClass().getResource("slike/documentzuti.png");
            
            if (imageURL != null) {
                icon = new ImageIcon(imageURL);
                setIcon(icon);
            }
        }
        else if (((RuTreeItem)value).getNode() instanceof Page) {
            URL imageURL = getClass().getResource("slike/stranica.png");
         
            if (imageURL != null) {
                icon = new ImageIcon(imageURL);
                setIcon(icon);
            }
        }
        else if (((RuTreeItem)value).getNode() instanceof Slot) {
            URL imageURL = getClass().getResource("slike/slot.png");
            
            if (imageURL != null) {
                icon = new ImageIcon(imageURL);
                setIcon(icon);
            }
        }
        return this;
    }
}
