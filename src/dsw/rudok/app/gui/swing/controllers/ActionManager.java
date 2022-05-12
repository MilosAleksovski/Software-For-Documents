package dsw.rudok.app.gui.swing.controllers;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.text.DefaultEditorKit;

public class ActionManager {
    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private AboutAction aboutAction;
    private NewDocumentAction docnew;
    private NewPageAction pagenew;
    private NewSlotAction sltnew;
    private DeleteAction deleteAction;
    private NewPasteAction newPasteAction;
    private NewCopyAction newCopyAction;
    private NewTriangleAction newTriangleAction;
    private NewCircleAction newCircleAction;
    private NewRectangleAction newRectangleAction;
    private NewSelectionAction newSelectionAction;
    private NewDeleteAction2 newDeleteAction2;
    private NewMoveAction newMove;
    private NewResizeAction newResizeAction;
    private NewRotateAction newRotateAction;
    private NewRotateAction2 newRotateAction2;
    private NewRedoAction newRedoAction;
    private NewUndoAction undoAction;
    private NewOpenAction newOpenAction;
    private NewBoldAction newBoldAction;
    private NewItalicAction newItalicAction;
    private NewUnderlineAction newUnderlineAction;
    private NewEditAction newEditAction;
    private NewOpenProjectAction newOpenProjectAction;
    private NewSaveProjectAction newSaveProjectAction;
    private NewSwitch newSwitch;

    public ActionManager() {
        initialiseActions();
    }


    private void initialiseActions() {
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        aboutAction = new AboutAction();
        docnew=new NewDocumentAction();
        pagenew=new NewPageAction();
        sltnew=new NewSlotAction();
        deleteAction = new DeleteAction();
        newPasteAction = new NewPasteAction();
        newCopyAction = new NewCopyAction();
        newTriangleAction=new NewTriangleAction();
        newCircleAction=new NewCircleAction();
        newRectangleAction=new NewRectangleAction();
        newSelectionAction=new NewSelectionAction();
        newDeleteAction2 = new NewDeleteAction2();
        newMove = new NewMoveAction();
        newResizeAction = new NewResizeAction();
        newRotateAction=new NewRotateAction();
        newRotateAction2 = new NewRotateAction2();
        undoAction = new NewUndoAction();
        newRedoAction = new NewRedoAction();
        newOpenAction=new NewOpenAction();
        newBoldAction = new NewBoldAction();
        newItalicAction = new NewItalicAction();
        newUnderlineAction = new NewUnderlineAction();
        newEditAction = new NewEditAction();
        newOpenProjectAction = new NewOpenProjectAction();
        newSaveProjectAction = new NewSaveProjectAction();
        newSwitch = new NewSwitch();

    }

    public NewSwitch getNewSwitch() {
        return newSwitch;
    }

    public NewOpenProjectAction getNewOpenProjectAction() {
        return newOpenProjectAction;
    }

    public NewSaveProjectAction getNewSaveProjectAction() {
        return newSaveProjectAction;
    }

    public NewUnderlineAction getNewUnderlineAction() {
        return newUnderlineAction;
    }

    public NewItalicAction getNewItalicAction() {
        return newItalicAction;
    }

    public NewEditAction getNewEditAction() {
        return newEditAction;
    }

    public NewBoldAction getNewBoldAction() {
        return newBoldAction;
    }

    public NewOpenAction getNewOpenAction() {
        return newOpenAction;
    }

    public NewRedoAction getNewRedoAction() {
        return newRedoAction;
    }

    public NewUndoAction getUndoAction() {
        return undoAction;
    }

    public ExitAction getExitAction(){

        return this.exitAction;
    }
    public void setExitAction(ExitAction exitAction){
        this.exitAction = exitAction;
    }

    public NewProjectAction getNewProjectAction(){
        return this.newProjectAction;
    }
    public void setNewProjectAction(NewProjectAction newProjectAction){
        this.newProjectAction = newProjectAction;
    }

    public NewDocumentAction getDocnew() {
        return docnew;
    }public void setDocnew(NewDocumentAction docnew) {
        this.docnew = docnew;
    }
    public NewSlotAction getSltnew() {
        return sltnew;
    }public void setSltnew(NewSlotAction sltnew) {
        this.sltnew = sltnew;
    }

    public NewRotateAction getNewRotateAction() {
        return newRotateAction;
    }

    public NewPageAction getPagenew() {
        return pagenew;
    }public void setPagenew(NewPageAction pagenew) {
        this.pagenew = pagenew;
    }

    public AboutAction getAboutAction(){
        return this.aboutAction;
    }
    public void setAboutAction(AboutAction aboutAction){
        this.aboutAction = aboutAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public void setDeleteAction(DeleteAction deleteAction) {
        this.deleteAction = deleteAction;
    }

    public NewCopyAction getNewCopyAction() {
        return newCopyAction;
    }

    public NewPasteAction getNewPasteAction() {
        return newPasteAction;
    }

    public NewRectangleAction getNewRectangleAction() {
        return newRectangleAction;
    }

    public NewSelectionAction getNewSelectionAction() {
        return newSelectionAction;
    }

    public NewCircleAction getNewCircleAction() {
        return newCircleAction;
    }

    public NewTriangleAction getNewTriangleAction() {
        return newTriangleAction;
    }

    public NewDeleteAction2 getNewDeleteAction2() {
        return newDeleteAction2;
    }

    public void setNewDeleteAction2(NewDeleteAction2 newDeleteAction2) {
        this.newDeleteAction2 = newDeleteAction2;
    }

    public NewMoveAction getNewMove() {
        return newMove;
    }

    public void setNewMove(NewMoveAction newMove) {
        this.newMove = newMove;
    }

    public NewResizeAction getNewResizeAction() {
        return newResizeAction;
    }

    public NewRotateAction2 getNewRotateAction2() {
        return newRotateAction2;
    }
}
