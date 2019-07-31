package data.algorithm;

import data.MainGlobal;

public class Eulerian
{
    public boolean value;
    
    public Eulerian(MainGlobal mainGlobal, Degree degree)
    {
        this.value = this.setValue(mainGlobal, degree);
    }
    
    private boolean setValue(MainGlobal mainGlobal, Degree degree)
    {
        int i;

        for (i=0; i<mainGlobal.adjacencyMatrix.numberVertex(); i++)
        {
            if (degree.getValue(i)%2!=0)
                return false;
        }
        
        return true;
    }
}