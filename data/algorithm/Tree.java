package data.algorithm;

import data.MainGlobal;

public class Tree
{
    public boolean value;
    private MainGlobal mainGlobal;
    
    public Tree(MainGlobal mainGlobal)
    {
        this.mainGlobal = mainGlobal;
        this.setValue();
    }
    
    private void setValue()
    {
        this.value = isTree(0, 0);
    }
    
    private boolean isTree(int indexVertex, int previousIndexVertex)
    {
        this.mainGlobal.visited.clear();
        return !isCicle(indexVertex, previousIndexVertex);
    }
    
    private boolean isCicle(int indexVertex, int previousIndexVertex)
    {
        int i;
        boolean retorno = false;

        this.mainGlobal.visited.setVisited(indexVertex);

        for (i=0; i<this.mainGlobal.adjacencyMatrix.numberVertex(); i++)
        {
            if (this.mainGlobal.adjacencyMatrix.getEdge(indexVertex, i) != 0)
            {
                if (!this.mainGlobal.visited.isVisited(i))
                    retorno = isCicle(i, indexVertex);
                else if (i != previousIndexVertex)
                    return true;
            }
        }
        
        return retorno;
    }
}
