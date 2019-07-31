package backup.filter;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class Pri extends FileFilter
{
    public boolean accept(File file)
    {
        String filename = file.getName().toLowerCase();
        return filename.endsWith(".pri");
    }

    public String getDescription()
    {
        return ".pri (Formato Serializado)";
    }
}
