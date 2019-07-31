package backup.filter;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class Wgo extends FileFilter
{
    public boolean accept(File file)
    {
        String filename = file.getName().toLowerCase();
        return filename.endsWith(".wgo");
    }

    public String getDescription()
    {
        return ".wgo (Formato Texto)";
    }
}
