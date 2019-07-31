package data.algorithm;

import data.MainGlobal;
import data.algorithm.Degree;

public class Euler
{
    public boolean value;
    
    public Euler(MainGlobal mainGlobal, Degree degree)
    {
        this.setValue(mainGlobal, degree);
    }
    
    private void setValue(MainGlobal mainGlobal, Degree degree)
    {
        int i, count=0;

        for(i=0; i<mainGlobal.adjacencyMatrix.numberVertex(); i++)
        {
            if (degree.getValue(i)%2!=0)
                count++;
        }

        this.value = count<=2;
    }
}