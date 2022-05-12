package dsw.rudok.app.repository.state;

import dsw.rudok.app.repository.SlotHandler.SlotHandler;
import dsw.rudok.app.repository.state.stateRepo.*;
import dsw.rudok.app.repository.workspace.Page;

import java.io.Serializable;

public class StateManager implements Serializable {
    private State currentState;


    CircleState circleState;
    RectangleState rectangleState;
    SelectState selectState;
    TriangleState triangleState;
    MoveState moveState;
    ResizeState resizeState;
    DeleteState deleteState;
    RotateState rotateState;
    Rotate2State rotate2State;

    public StateManager(Page page)
    {
        circleState = new CircleState(page);
        rectangleState=new RectangleState(page);
        selectState=new SelectState(page);
        triangleState=new TriangleState(page);
        moveState = new MoveState(page);
        resizeState = new ResizeState(page);
        deleteState = new DeleteState(page);
        currentState = selectState;
        rotateState=new RotateState(page);
        rotate2State = new Rotate2State(page);
    }
    public void setCircleState() {
        currentState=circleState;
    }
    public void setRectangleState() {
        currentState=rectangleState;
    }
    public void setSelectState() {
        currentState=selectState;
    }
    public void setTriangleState() { currentState=triangleState; }
    public void setMoveState(){currentState = moveState;}
    public void setResizeState(){currentState = resizeState;}
    public void setDeleteState() { currentState=deleteState; }
    public void setRotateState() {
        currentState = rotateState;
    }
    public void setRotate2State(){currentState = rotate2State;}

    public State getCurrentState() {

        return currentState;
    }
}
