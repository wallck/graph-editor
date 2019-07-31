package data.algorithm;

import data.MainGlobal;

public class GroupE
{
    private MainGlobal mainGlobal;
    public String value;
    
    public GroupE(MainGlobal mainGlobal)
    {
        this.mainGlobal = mainGlobal;
        this.setValue();
    }
    
    private void setValue()
    {
        int i, j;
        String groupE = "E={ ";

        for(i=0; i<this.mainGlobal.adjacencyMatrix.numberVertex(); i++)
        {
            for(j=0; j<this.mainGlobal.adjacencyMatrix.numberVertex(); j++)
            {
                if (this.mainGlobal.adjacencyMatrix.getEdge(i, j)!=0)
                {
                    groupE += "("+this.mainGlobal.screen.getVertice(i).getRotulo()+
                    ","+
                    this.mainGlobal.screen.getVertice(j).getRotulo()+") ";
                }
            }
        }

        this.value = groupE + "}";
    }
}
