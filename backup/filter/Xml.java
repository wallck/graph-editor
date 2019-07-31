package backup.filter;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class Xml extends FileFilter
{
    public boolean accept(File file)
    {
        String filename = file.getName().toLowerCase();
        return filename.endsWith(".xml");
    }

    public String getDescription()
    {
        return ".xml (Formato XML)";
    }
}
