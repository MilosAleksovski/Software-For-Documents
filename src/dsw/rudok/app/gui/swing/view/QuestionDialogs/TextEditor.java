package dsw.rudok.app.gui.swing.view.QuestionDialogs;



import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.repository.workspace.slot.Slot;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class TextEditor extends JDialog {

    private JToolBar jToolBar;
    private JButton bold;
    private JButton underline;
    private JButton italic;
    private JButton edit;
    private JButton save;
    private static JTextPane jTextPane;
    private Slot slot;
    private Font font1 = new Font("Arial", Font.PLAIN, 30);



    public TextEditor(String textToEdit, Slot slot) {
        setjToolBar();
        jTextPane = new JTextPane();
        jTextPane.setText(textToEdit);
        this.slot = slot;
        initialise();
    }

    public void initialise()
    {

        setSize(1000,600);
        setLocationRelativeTo(null);
        setTitle("Text editor");
        setResizable(false);
        add(jToolBar, BorderLayout.NORTH);
        jTextPane.setFont(font1);
        this.add(jTextPane, BorderLayout.CENTER);
        bold.addActionListener(new ButtonControllerBold());
        italic.addActionListener(new ButtonControllerItalic());
        underline.addActionListener(new ButtonControllerUnderline());
        edit.addActionListener(new ButtonControllerEdit());
        save.addActionListener(new ButtonControllerSave());

    }



    private class ButtonControllerBold extends StyledEditorKit.BoldAction {

    }
    private class ButtonControllerItalic extends StyledEditorKit.ItalicAction {

    }
    private class ButtonControllerUnderline extends StyledEditorKit.UnderlineAction {

    }
    private class ButtonControllerEdit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            slot.setType("");
            setVisible();
            QuestionDialog questionDialog = new QuestionDialog(slot);
            questionDialog.setVisible(true);

        }
    }
    private class ButtonControllerSave implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        solution();
        }
    }

    public void solution(){



        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(slot.getFile().getAbsolutePath()+".txt");
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println(jTextPane.getText());

        printWriter.close();


    }



    public void setjToolBar(){
        jToolBar = new JToolBar();
        bold = new JButton("B");
        italic = new JButton("I");
        underline = new JButton("U");
        edit = new JButton("Edit");
        save = new JButton("Save");
        jToolBar.setFloatable(false);
        jToolBar.add(bold);
        jToolBar.add(italic);
        jToolBar.add(underline);
        jToolBar.add(edit);
        jToolBar.add(save);


    }

    public void setVisible(){
        this.dispose();
    }
}
