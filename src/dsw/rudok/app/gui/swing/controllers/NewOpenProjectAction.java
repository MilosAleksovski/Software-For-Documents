package dsw.rudok.app.gui.swing.controllers;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.gui.swing.stablo.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.Document;
import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.workspace.Project;
import dsw.rudok.app.repository.workspace.slot.Slot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class NewOpenProjectAction extends AbstractRuDokAction {
    public NewOpenProjectAction() {
        putValue(SMALL_ICON, loadIcon("slike/open.png"));
        putValue(NAME, "Open project");
        putValue(SHORT_DESCRIPTION, "Open project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {



        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new JFileFilterProject());

        if (jfc.showOpenDialog(GlavniFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {



            Project project = AppCore.getInstance().getiSerializable().uradiDeSerijalizaciju(jfc.getSelectedFile());

            GlavniFrame.getInstance().getTree().addProject2(project);

                    Page p = null;
                    for(RuNode document: project.getChildren()){

                        GlavniFrame.getInstance().getTree().addDocument2((Document) document);

                        for(RuNode page: ((Document) document).getChildren()){
                            p = (Page) page;
                            GlavniFrame.getInstance().getTree().addPage2((Page) page);

                        }
                    }


            System.out.println(p.getpModel().getPageElements().size());


        }

    }
}