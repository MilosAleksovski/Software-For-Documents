package dsw.rudok.app.gui.swing.controllers;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class JFileFilterWorkspace extends FileFilter {
    @Override
    public boolean accept(File f) {
        return (f.isDirectory() ||
                f.getName().toLowerCase().endsWith(".txt"));
    }

    @Override
    public String getDescription() {
        return "Text Workspace Files (*.txt)";
    }

}
