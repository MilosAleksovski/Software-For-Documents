package dsw.rudok.app.gui.swing.controllers;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.ErrorHandler.ErrorTypes;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.gui.swing.view.QuestionDialogs.ImagePreview;
import dsw.rudok.app.gui.swing.view.QuestionDialogs.QuestionDialog;
import dsw.rudok.app.gui.swing.view.QuestionDialogs.TextDialog;
import dsw.rudok.app.gui.swing.view.QuestionDialogs.TextEditor;
import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.workspace.slot.Slot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Scanner;

public class NewOpenAction extends AbstractRuDokAction {
    public NewOpenAction() {

        putValue(NAME, "Open element");
        putValue(SHORT_DESCRIPTION, "Open element");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (GlavniFrame.getInstance().getTree().selectedItem() instanceof Page) {
            Page selectedPage = (Page) GlavniFrame.getInstance().getTree().selectedItem();
            for (Slot s : selectedPage.getpModel().getPageElements()) {
                if (s.getPaint().equals(Color.blue) && s.getType() == null) {

                    QuestionDialog questionDialog = new QuestionDialog(s);
                    questionDialog.setVisible(true);
                    break;

                } else if (s.getPaint().equals(Color.blue) && s.getType() != null) {

                    System.out.println(s.getType());
                    System.out.println(s.getFile().getAbsolutePath());

                    if(s.getType().equals("Text")){

                        File file = new File(s.getFile().getAbsolutePath()+".txt");


                        try {

                            Scanner scanner = new Scanner(file);

                            TextEditor textEditor = new TextEditor(scanner.nextLine(), s);
                            textEditor.setVisible(true);

                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        break;
                    }
                    else if(s.getType().equals("Image")){

                        File file = new File(s.getFile().getAbsolutePath()+".txt");

                        try {

                            Scanner scanner = new Scanner(file);
                            ImagePreview imagePreview = new ImagePreview(s, scanner.nextLine());
                            imagePreview.setVisible(true);

                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }

                        break;
                    }
                }

            }
            if (selectedPage.getpModel().getPageElements().isEmpty())
                AppCore.getInstance().getErrHandler().generateError(ErrorTypes.SLOTNOTSELECTED);
        }
        else
        {
            AppCore.getInstance().getErrHandler().generateError(ErrorTypes.ACTIONERROR);
        }
    }
}

