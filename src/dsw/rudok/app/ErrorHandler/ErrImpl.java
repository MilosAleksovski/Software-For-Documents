package dsw.rudok.app.ErrorHandler;

import dsw.rudok.app.ErrorHandler.ErrorObserver.ErrorPublisher;
import dsw.rudok.app.ErrorHandler.ErrorObserver.ErrorSubscriber;
import dsw.rudok.app.core.ErrHandler;
import dsw.rudok.app.repository.Node.RuNode;

import java.util.ArrayList;
import java.util.List;

public class ErrImpl implements ErrHandler, ErrorPublisher {

    List<ErrorSubscriber> errorSubscribers;

    public void generateError(ErrorTypes type)
    {
        if(type.equals(ErrorTypes.SELECTIONERROR))
            notifyErrorSubs(new GenError(1,"Selektujte dokument."));
        else if(type.equals(ErrorTypes.ACTIONERROR))
            notifyErrorSubs(new GenError(2,"Akcija nije podrzana."));
        else if(type.equals(ErrorTypes.WORKSPACEERROR))
            notifyErrorSubs(new GenError(3,"Workspace se ne moze brisati."));
        else if(type.equals(ErrorTypes.WORKSPACENOTSELECTED))
            notifyErrorSubs(new GenError(4,"Selektujte workspace."));
        else if(type.equals(ErrorTypes.SLOTERROR))
            notifyErrorSubs(new GenError(5,"Slot error"));
        else if(type.equals(ErrorTypes.PAGEERROR))
            notifyErrorSubs(new GenError(6,"Selektujte stranicu"));
        else if(type.equals(ErrorTypes.ROTATECIRCLEERROR))
            notifyErrorSubs(new GenError(7,"Krug se ne moze rotirati"));
    }
    public void generateError(ErrorTypes type, RuNode node)
        {
            if(type.equals(ErrorTypes.DOCUMENTERROR))
            {
                notifyErrorSubs(new GenError(8,"Niste selektovali dokument vec "+node.getName()));
            }
            else if(type.equals(ErrorTypes.NOTPAGESELECTED))
            {
                notifyErrorSubs(new GenError(9,"Niste selektovali stranicu vec "+node.getName()));
            }
        }


    @Override
    public void addErrorSub(ErrorSubscriber errorSubscriber) {
        if(errorSubscriber == null)
            return;
        if(this.errorSubscribers ==null)
            this.errorSubscribers = new ArrayList<>();
        if(this.errorSubscribers.contains(errorSubscriber))
            return;
        this.errorSubscribers.add(errorSubscriber);
    }

    @Override
    public void removeErrorSub(ErrorSubscriber errorSubscriber) {
        if(errorSubscriber == null || this.errorSubscribers == null || !this.errorSubscribers.contains(errorSubscriber))
            return;
        this.errorSubscribers.remove(errorSubscriber);
    }

    @Override
    public void notifyErrorSubs(GenError error) {
        if(error == null || this.errorSubscribers == null || this.errorSubscribers.isEmpty())
            return;
        for(ErrorSubscriber listener : errorSubscribers){
            listener.updateErrorSubscribers(error);
        }
    }
}
