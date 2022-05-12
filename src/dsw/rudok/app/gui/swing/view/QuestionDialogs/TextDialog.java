package dsw.rudok.app.gui.swing.view.QuestionDialogs;

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

public class TextDialog extends JDialog {
    private JLabel question;
    private JTextField jTextField;
    private JButton obutton;
    private Slot slot;


    public TextDialog(Slot slot) {
        this.slot = slot;
        initialise();
    }

    public void initialise()
    {
        setTitle("Write text: ");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        question=new JLabel("Napistite tekst za slot: ",SwingConstants.CENTER);
        obutton=new JButton("Postavi tekst");
        jTextField=new JTextField();
        jTextField.setSize(200,50);

        obutton.addActionListener(new TextDialog.ButtonController());

        setLayout(new BorderLayout());
        this.add(question,BorderLayout.NORTH);
        this.add(jTextField,BorderLayout.CENTER);
        this.add(obutton,BorderLayout.SOUTH);

    }
    private class ButtonController implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            editorInitialise();
        }
    }
public void editorInitialise()
{




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

    System.out.println(path);



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

    printWriter.println(jTextField.getText());

    printWriter.close();

    slot.setFile(file);
    slot.setType("Text");

    TextEditor textEditor=new TextEditor(jTextField.getText(), slot);
    textEditor.setVisible(true);
    this.dispose();
}
}
