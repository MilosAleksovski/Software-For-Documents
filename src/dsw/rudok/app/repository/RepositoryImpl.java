package dsw.rudok.app.repository;

import dsw.rudok.app.core.Repository;
import dsw.rudok.app.repository.Node.RuNode;
import dsw.rudok.app.repository.workspace.Workspace;

public class RepositoryImpl implements Repository {

   private Workspace root;
   private RuNode ruNode;

   public RepositoryImpl()
   {

       root=new Workspace("Workspace");
   }

    @Override
    public Workspace getWorkspace() {

       return root;
    }
}
