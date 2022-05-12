package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.gui.swing.controllers.AbstractRuDokAction;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class AboutPanel extends JDialog {


    public AboutPanel(){

             this.initializeAbout();
    }

    public void initializeAbout(){

          Image icon = Toolkit.getDefaultToolkit().getImage("D:\\GIT.jpg");
          setIconImage(icon);
          setVisible(true);
          setLayout(new FlowLayout());
          setTitle("About Panel");
          setSize(600, 500);
          setLocationRelativeTo(null);


          ImageIcon image = new ImageIcon(getClass().getResource("slike2/igor.jpg"));
          ImageIcon image2 = new ImageIcon(getClass().getResource("slike2/milos.jpg"));


          JLabel jbl = new JLabel(image);
          add(jbl);
          JLabel miki = new JLabel("Igor Pejin - RN84/2020");
          add(miki);
          JLabel jbl2 = new JLabel(image2);
          add(jbl2);
          JLabel miki2 = new JLabel("Milos Aleksovski- RN109/2020");
          add(miki2);

           setResizable(false);


    }


}
