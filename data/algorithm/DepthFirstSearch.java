package data.algorithm;

import data.MainGlobal;
import java.awt.Color;

public class DepthFirstSearch
{
    private MainGlobal mainGlobal; 
    
    public DepthFirstSearch(MainGlobal mainGlobal)
    {
        this.mainGlobal = mainGlobal;
    }
    
    public void depthFirstSearch(int indexVertex)
    {
        this.mainGlobal.visited.clear();
        this.depth(indexVertex);
    }
    
    private void depth(int indexVertex)
    {
        int neighbor;
		
        this.mainGlobal.visited.setVisited(indexVertex);
        this.mainGlobal.screen.getVertice(indexVertex).setCor(Color.BLUE);

        for (neighbor=0; neighbor<this.mainGlobal.adjacencyMatrix.numberVertex(); neighbor++)
        {
            if (this.mainGlobal.adjacencyMatrix.getEdge(indexVertex, neighbor)!=0 && !this.mainGlobal.visited.isVisited(neighbor))
            {
                this.mainGlobal.screen.getAresta(indexVertex, neighbor).setCor(Color.BLUE);
                this.depth(neighbor);
            }
        }
    }
}
