package dsw.rudok.app.gui.swing.view.QuestionDialogs;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.ErrorHandler.ErrorTypes;
import dsw.rudok.app.repository.workspace.slot.Slot;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ImageDialog extends JDialog {
    private Slot slot;
    private JLabel txt;
    private JFileChooser jFileChooser;
    private static List<String> ucitani = new ArrayList<>();

    public ImageDialog(Slot slot){
        this.slot = slot;
        initialize();
    }



    public void initialize(){
        setTitle("Choose image-" +slot.getName());
        setSize(650,650);
        setLocationRelativeTo(null);
        setResizable(false);

        txt = new JLabel("Izaberi sliku koju zelite da ubacite", SwingConstants.CENTER);

        setLayout(new BorderLayout());

        jFileChooser = new JFileChooser();
        jFileChooser.addActionListener(new Button());

        add(txt, BorderLayout.NORTH);
        add(jFileChooser,BorderLayout.CENTER);


    }

    private class Button implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getActionCommand().equals("ApproveSelection")){

                if(jFileChooser.getSelectedFile().getAbsolutePath().endsWith(".png")){
                       ImagePreview imagePreview = new ImagePreview(slot, jFileChooser.getSelectedFile().getAbsolutePath());
                       imagePreview.setVisible(true);
                       slot.setType("Image");


                    int k = 0;
                    String path = "C:/KT3/Serijalizacija/sadrzajSlotaTxt/sadrzaj";
                    File file = new File(path); //initialize File object and passing path as argument

                    while(file.exists()){
                        path += "(" + k++ + ")" ;
                        file = new File(path);
                    }

                    if(!path.contains(".txt")){
                        path += ".txt";
                    }


                    try {
                        file.createNewFile();  //creates a new file
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }


                    FileWriter fileWriter = null;
                    try {
                        fileWriter = new FileWriter(path);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                    PrintWriter printWriter = new PrintWriter(fileWriter);

                    printWriter.println(jFileChooser.getSelectedFile().getAbsolutePath());

                    printWriter.close();

                    slot.setFile(file);

                    close();
                }
                else{
                    AppCore.getInstance().getErrHandler().generateError(ErrorTypes.ACTIONERROR);
                }

            }
            else if(e.getActionCommand().equals("CancelSelection")){
                close();
                QuestionDialog questionDialog = new QuestionDialog(slot);
                questionDialog.setVisible(true);
            }

        }
    }
    public void close(){
        this.dispose();
    }

}
