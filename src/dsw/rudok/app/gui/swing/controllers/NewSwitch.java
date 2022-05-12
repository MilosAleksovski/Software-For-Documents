package dsw.rudok.app.gui.swing.controllers;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.gui.swing.stablo.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.gui.swing.view.QuestionDialogs.TextEditor;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.Document;
import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.workspace.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Scanner;

public class NewSwitch extends AbstractRuDokAction {
    private JFileChooser jfc;
    private File projectFile;


    public NewSwitch() {
        putValue(SMALL_ICON, loadIcon("slike/switch.png"));
        putValue(NAME, "Switch Workspace");
        putValue(SHORT_DESCRIPTION, "Switch Workspace");
    }


    @Override
    public void actionPerformed(ActionEvent e) {



        jfc = new JFileChooser();
        jfc.setFileFilter(new JFileFilterWorkspace());
        jfc.setAcceptAllFileFilterUsed(false);


        if (jfc.showOpenDialog(GlavniFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            RuTreeItem ruTreeItem = (RuTreeItem) GlavniFrame.getInstance().getTree().vratiRoot();
            ruTreeItem.removeAllChildren();

            projectFile = jfc.getSelectedFile();


            try {

                Scanner scanner = new Scanner(projectFile);

                while (scanner.hasNextLine()) {
                    String aPath = scanner.nextLine();
                    File f = new File(aPath);
                    Project project = AppCore.getInstance().getiSerializable().uradiDeSerijalizaciju(f);

                    GlavniFrame.getInstance().getTree().addProject2(project);

                    Page p = null;
                    for (RuNode document : project.getChildren()) {

                        GlavniFrame.getInstance().getTree().addDocument2((Document) document);

                        for (RuNode page : ((Document) document).getChildren()) {
                            p = (Page) page;
                            GlavniFrame.getInstance().getTree().addPage2((Page) page);

                        }
                    }
                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }


        }
    }
}