package dsw.rudok.app.gui.swing.controllers;



import dsw.rudok.app.AppCore;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.repository.workspace.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class NewSaveProjectAction extends AbstractRuDokAction {


    private JFileChooser jfc ;
    private File projectFile ;
    public NewSaveProjectAction() {
        putValue(SMALL_ICON, loadIcon("slike/save.png"));
        putValue(NAME, "Save project");
        putValue(SHORT_DESCRIPTION, "Save project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jfc = new JFileChooser();
        jfc.setFileFilter(new JFileFilterProject());
        jfc.setAcceptAllFileFilterUsed(false);


        if (jfc.showSaveDialog(GlavniFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {

            projectFile = jfc.getSelectedFile();
            String s = projectFile.getPath();
            System.out.println(projectFile);

            if (!s.endsWith(".gpf")) {
                s += ".gpf";
                projectFile.delete();
                projectFile = new File(s);
            }

        } else {
            return;
        }



        if (GlavniFrame.getInstance().getTree().selectedItem() instanceof Project) {
            Project project = (Project) GlavniFrame.getInstance().getTree().selectedItem();
            AppCore.getInstance().getiSerializable().uradiSerijalizaciju(projectFile, project);
            project.setProjectFile(projectFile);
            project.setChanged(false);

        }




    }


}

