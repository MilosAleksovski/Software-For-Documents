package dsw.rudok.app.gui.swing.stablo;

import dsw.rudok.app.gui.swing.stablo.StatusLineObserver.StatusLinePublisher;
import dsw.rudok.app.gui.swing.stablo.observerT.PublisherT;
import dsw.rudok.app.gui.swing.view.RuView;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.Document;
import dsw.rudok.app.repository.workspace.Page;
import dsw.rudok.app.repository.workspace.Project;
import dsw.rudok.app.repository.workspace.Workspace;
import dsw.rudok.app.repository.workspace.slot.Slot;

import javax.swing.*;
import javax.swing.tree.TreePath;

public interface RuStablo extends PublisherT, StatusLinePublisher, RuView {

    JTree generateTree(Workspace workspace);
    void updateTree(JTree jtree);
    void addProject();
    void addProject2(Project project);
    void addDocument();
    void addDocument2(Document document);
    void addPage();
    void addPage2(Page page);
    void addSlot(Slot slot);
    void Delete();
    void Delete2(Slot slot);
    RuNode selectedItem();
    TreePath selectedPath();
    boolean isWorkspaceSelected();
    boolean isSelected(TreePath path);
    void dodajRuTreee(Document document, Project project);
    Object vratiRoot();


}
