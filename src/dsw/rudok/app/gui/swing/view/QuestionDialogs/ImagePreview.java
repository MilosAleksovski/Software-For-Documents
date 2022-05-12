package dsw.rudok.app.gui.swing.view.QuestionDialogs;

import dsw.rudok.app.AppCore;
import dsw.rudok.app.ErrorHandler.ErrorTypes;
import dsw.rudok.app.repository.workspace.slot.Slot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

public class ImagePreview extends JDialog {
    private Slot slot;
    private String apsolutePath;
    private JLabel image;
    private JPanel jPanel;
    private JToolBar jToolBar;

    public ImagePreview(Slot slot, String apsolutePath){
        this.slot = slot;
        this.apsolutePath = apsolutePath;
        initialize();
    }

    public void initialize(){

        this.setTitle("Preview Image-" + slot.getName());
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        jToolBar = new JToolBar();
        JButton edit = new JButton("Edit");
        jToolBar.add(edit);
        edit.addActionListener(new EditAction());
        jToolBar.setFloatable(false);

        this.setLayout(new BorderLayout());

        this.add(jToolBar, BorderLayout.NORTH);

        jPanel = new JPanel();

        image = new JLabel(new ImageIcon(apsolutePath));



        jPanel.add(image);
        this.add(jPanel, BorderLayout.CENTER);

    }

    private class EditAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            slot.setType("");
            setVisible();
            QuestionDialog questionDialog = new QuestionDialog(slot);
            questionDialog.setVisible(true);
        }
    }
    public void setVisible(){
        this.dispose();
    }
}
