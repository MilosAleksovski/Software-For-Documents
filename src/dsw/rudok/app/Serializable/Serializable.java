package dsw.rudok.app.Serializable;




import dsw.rudok.app.core.ISerializable;
import dsw.rudok.app.repository.workspace.Project;
import java.io.*;


public class Serializable implements  ISerializable {




    @Override
    public void uradiSerijalizaciju(File file, Project project) {
        ObjectOutputStream os;
        try {


            os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(project);


        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public Project uradiDeSerijalizaciju(File file) {
        Project project = null;
        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream(file));

            try {
                project = (Project) os.readObject();
            } catch (ClassNotFoundException exception) {
                exception.printStackTrace();
            }


        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return project;
    }

}
