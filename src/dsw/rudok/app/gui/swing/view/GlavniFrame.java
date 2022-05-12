package dsw.rudok.app.gui.swing.view;

import dsw.rudok.app.ErrorHandler.GenError;
import dsw.rudok.app.commands.CommandsEnum;
import dsw.rudok.app.core.Repository;
import dsw.rudok.app.gui.swing.controllers.GlavniFrameExit;
import dsw.rudok.app.gui.swing.controllers.JFileFilterWorkspace;
import dsw.rudok.app.gui.swing.stablo.StatusLineObserver.StatusLineSubscriber;
import dsw.rudok.app.gui.swing.controllers.ActionManager;
import dsw.rudok.app.gui.swing.controllers.ClickListener;
import dsw.rudok.app.gui.swing.stablo.model.RuTreeItem;
import dsw.rudok.app.gui.swing.stablo.observerT.SubscriberT;
import dsw.rudok.app.gui.swing.stablo.RuStablo;
import dsw.rudok.app.gui.swing.stablo.view.RuTreeImplementation;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.Document;
import dsw.rudok.app.repository.workspace.Project;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GlavniFrame extends JFrame implements SubscriberT, StatusLineSubscriber{

    private ActionManager actionManager;
    private static  GlavniFrame instanca;
    private Repository docRep;
    private JMenuBar jMenuB ;
    private JToolBar jToolBar;
    private RuStablo tree;
    private JTree workspace;
    private JLabel lbl;
    private JPanel desnaStrana;
    private JLabel naslov;
    private JTabbedPane jTabbedPane;
    private StateToolbar jStateToolbar;
    private Document document;
    private Project project;
    private JOptionPane jOptionPane;

    private GlavniFrame(){

    }
    private void initialise() {
        actionManager = new ActionManager();
        lbl=new JLabel();
    }



    public void ucitavanje()
    {
        tree = new RuTreeImplementation();
        this.tree.addSubscriberT(this);
        this.tree.addStatusLineSubscriber(this);
        workspace = tree.generateTree(docRep.getWorkspace());
        pokrenigui();
    }

    public void pokrenigui() {
        setVisible(true);
        setTitle("RuDok");
        setSize(1200, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Dodato za prekid rada
        setResizable(false);


        /*Dodat nas logo*/
        URL iconURL = getClass().getResource("slike2/logo.png");
        ImageIcon icon = new ImageIcon(iconURL);
        GlavniFrame.getInstance().setIconImage(icon.getImage());

        jMenuB = new MyMenuBar();
        setJMenuBar(jMenuB);

        jToolBar = new Toolbar();
        add(jToolBar, BorderLayout.NORTH);

        jStateToolbar=new StateToolbar();

        napraviDesnuStranuZaSplit();
        workspace.addMouseListener(ClickListener.getClickListener());

        addWindowListener(new GlavniFrameExit());

        JScrollPane scroll=new JScrollPane(workspace);
        scroll.setMinimumSize(new Dimension(200,150));
        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll, desnaStrana);
        getContentPane().add(split,BorderLayout.CENTER);
        getContentPane().add(lbl,BorderLayout.SOUTH);
        getContentPane().add(jStateToolbar,BorderLayout.EAST);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);
    }



    /*Singleton za GlavniFrame*/
    public static GlavniFrame getInstance(){
        if(instanca == null){
            instanca = new GlavniFrame();
            instanca.initialise();

        }
        return instanca;
    }
    public void napraviDesnuStranuZaSplit(){
        desnaStrana = new JPanel();
        desnaStrana.setLayout(new BorderLayout());
        jTabbedPane = new JTabbedPane();
        naslov = new JLabel("", SwingConstants.CENTER);
        desnaStrana.add(naslov, BorderLayout.NORTH);
        desnaStrana.add(jTabbedPane, BorderLayout.CENTER);
    }
    /*Geteri i seteri*/

    public JPanel getjPanel() {
        return desnaStrana;
    }

    public void setDocRep(Repository docRep) {

        this.docRep = docRep;
    }
    public JTree getWorkspace() {
        return workspace;
    }
    public RuStablo getTree() {
        return tree;
    }
    public ActionManager getActionManager() {
        return actionManager;
    }
    @Override
    public void updateT(Object notification) {
        tree.updateTree(workspace);
    }

    @Override
    public void updateStatusLineSubscribers(TreePath treePath) {
        this.lbl.setText(treePath.toString());
    }

    public JTabbedPane getjTabbedPane() {
        return jTabbedPane;
    }

    public JLabel getNaslov() {
        return naslov;
    }

    public void showError(GenError error) {
        JOptionPane.showMessageDialog(GlavniFrame.getInstance(),error.getMessage());
    }



    public void kopirajDokument(){
        this.document = (Document) tree.selectedItem();
        this.project = (Project) tree.selectedItem().getParent();
    }
    public void paste(){
        tree.dodajRuTreee(document, project);
        tree.selectedItem().notifySubscribersCopyPaste(document);
    }



    public void undoRedoEnable(CommandsEnum commandsEnum) {

        switch (commandsEnum)
        {

            case DELETE:
                actionManager.getUndoAction().setEnabled(true);
                actionManager.getNewRedoAction().setEnabled(false);
                break;
            case CURRENTSMALLER:
                actionManager.getUndoAction().setEnabled(true);
                break;
            case MULTISELEKT:
                actionManager.getNewRedoAction().setEnabled(false);
                actionManager.getUndoAction().setEnabled(true);
                break;
            case DELETEDO:
                actionManager.getNewRedoAction().setEnabled(false);
                actionManager.getUndoAction().setEnabled(true);
                break;
            case CURRENTCOMMANDEQUAL:
                actionManager.getNewRedoAction().setEnabled(false);
                break;
            case MULTISELEKTUNDO:

                actionManager.getNewRedoAction().setEnabled(true);
                actionManager.getUndoAction().setEnabled(false);
                break;
            case UNDODELETE:
                actionManager.getNewRedoAction().setEnabled(true);
                actionManager.getUndoAction().setEnabled(false);
                break;
            case UNDOELEMENTS:
                actionManager.getNewRedoAction().setEnabled(true);
                break;
            case COMMANDNULL:
                actionManager.getUndoAction().setEnabled(false);
                break;
            case UNDOMOVE:
                actionManager.getNewRedoAction().setEnabled(true);

        }
    }
}
