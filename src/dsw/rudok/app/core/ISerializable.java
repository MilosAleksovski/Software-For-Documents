package dsw.rudok.app.core;


import dsw.rudok.app.repository.workspace.Project;

import java.io.File;


public interface ISerializable  {

    void uradiSerijalizaciju(File file, Project project);

    Project uradiDeSerijalizaciju(File file);

}
