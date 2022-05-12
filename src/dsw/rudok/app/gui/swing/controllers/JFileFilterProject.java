package dsw.rudok.app.gui.swing.controllers;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class JFileFilterProject extends FileFilter {
    @Override
    public boolean accept(File f) {
        return (f.isDirectory() ||
                f.getName().toLowerCase().endsWith(".gpf"));
    }

    @Override
    public String getDescription() {
            return "GrafEditor Project Files (*.gpf)";
    }

}
