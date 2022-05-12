package dsw.rudok.app.gui.swing.view.QuestionDialogs;

import dsw.rudok.app.repository.workspace.slot.Slot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuestionDialog extends JDialog {

    private JLabel question;
    private JButton textButton;
    private JButton imageButton;
    private JPanel mainPanel;
    private Slot slot;

    public QuestionDialog(Slot slot)
    {
        this.slot = slot;
        initialise();
    }

    public void initialise()
    {
        setTitle("Choose type: ");
        setSize(200, 100);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        question=new JLabel("Izaberite tip za sadrzaj slota: ",SwingConstants.CENTER);
        textButton=new JButton("Text");
        imageButton=new JButton("Image");



        mainPanel=new JPanel();
        mainPanel.add(textButton);
        mainPanel.add(imageButton);

        textButton.addActionListener(new ButtonController());
        imageButton.addActionListener(new ButtonControllerImage());

        setLayout(new BorderLayout());
        this.add(question,BorderLayout.NORTH);
        this.add(mainPanel,BorderLayout.CENTER);
    }
    private class ButtonController implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textDialog();
        }
    }

    private class ButtonControllerImage implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            imageDialog();
        }
    }

    public void textDialog()
    {
        TextDialog textDialog=new TextDialog(slot);
        textDialog.setVisible(true);

        this.dispose();
    }
    public void imageDialog(){

        ImageDialog imageDialog = new ImageDialog(slot);
        imageDialog.setVisible(true);
        this.dispose();
    }

}
