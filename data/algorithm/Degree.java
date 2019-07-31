package data.algorithm;

import data.MainGlobal;

public class Degree
{
    private MainGlobal mainGlobal;
    
    public Degree(MainGlobal mainGlobal)
    {
        this.mainGlobal = mainGlobal;
    }
    
    public int getValue(int vertex)
    {
        int i, value = 0;
		
        for(i=0; i<this.mainGlobal.adjacencyMatrix.numberVertex(); i++)
        {
            if (this.mainGlobal.adjacencyMatrix.getEdge(vertex, i)!=0)
                value++;
        }
        
        return value;
    }
}
