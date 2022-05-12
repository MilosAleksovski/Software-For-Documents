package dsw.rudok.app.gui.swing.controllers;


import dsw.rudok.app.gui.swing.stablo.model.RuTreeItem;
import dsw.rudok.app.gui.swing.view.GlavniFrame;
import dsw.rudok.app.repository.Node.RuNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GlavniFrameExit extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        JOptionPane jOptionPane = new JOptionPane();
        int s = JOptionPane.showConfirmDialog((Component) null, "Da li zelite da sacuvate workspace","Sacuvaj workspace", JOptionPane.YES_NO_CANCEL_OPTION);

        if(s == 2){
           GlavniFrame.getInstance().setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
        if(s == 1){
            int f = JOptionPane.showConfirmDialog((Component) null, "Da li zelite da izadjete iz aplikacije","Izadji iz aplikacije", JOptionPane.YES_NO_OPTION);
            if(f == 0){
                GlavniFrame.getInstance().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
            if(f == 1){
                GlavniFrame.getInstance().setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            }
        }

        if(s == 0){

            String path;
            JFileChooser jfc ;
            File projectFile ;
            jfc = new JFileChooser();
            jfc.setFileFilter(new JFileFilterWorkspace());
            jfc.setAcceptAllFileFilterUsed(false);


            RuTreeItem ruTreeItem = (RuTreeItem) GlavniFrame.getInstance().getTree().vratiRoot();

            if(jfc.showSaveDialog(GlavniFrame.getInstance()) == JFileChooser.APPROVE_OPTION){


                path = jfc.getSelectedFile().getAbsolutePath();
                if (!path.endsWith(".txt")) {


                    int k = 0;
                    File file = new File(path); //initialize File object and passing path as argument

                    while(file.exists()){
                        path += "(" + k++ + ")" + ".txt";
                        file = new File(path);
                    }
                    System.out.println(path);


                    try {
                        file.createNewFile();  //creates a new file
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
                else {
                    File file = new File(jfc.getSelectedFile().getAbsolutePath() + ".txt"); //initialize File object and passing path as argument


                    try {
                        file.createNewFile();  //creates a new file
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }

            }else{
                return;
            }

            List<String> lista = new ArrayList<>();

            for(int i = 0; i < ruTreeItem.getChildCount(); i++) {

                projectFile = new File("C:/KT3/Serijalizacija/projectGpf/pr.gpf");
                String putanja ;
                int k = 0;
                while(projectFile.exists()){
                    putanja = "C:/KT3/Serijalizacija/projectGpf/pr"+i + "(" + k++ +")" +".gpf";
                    projectFile = new File(putanja);
                }

                RuTreeItem projekat = (RuTreeItem) ruTreeItem.getChildAt(i);
                RuNode projekatRuNode = projekat.getNode();
                lista.add(projectFile.getAbsolutePath());

                ObjectOutputStream os;
                try {

                    os = new ObjectOutputStream(new FileOutputStream(projectFile));
                    os.writeObject(projekatRuNode);


                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
             stampaj(lista, path);
            GlavniFrame.getInstance().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }


    public void stampaj(List<String> putanja, String workspacePath){


        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(workspacePath+".txt");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for(int i = 0; i < putanja.size(); i++) {
            printWriter.println(putanja.get(i));
        }
        printWriter.close();
    }
}
