package data.algorithm;

import java.util.PriorityQueue;
import java.awt.Color;
import data.MainGlobal;

public class BreadthFirstSearch
{
    private MainGlobal mainGlobal; 
    
    public BreadthFirstSearch(MainGlobal mainGlobal)
    {
        this.mainGlobal = mainGlobal;
    }
    
    public void breadthFirstSearch(int indexVertex)
    {
        int neighbor, vertexOfFifo;
        PriorityQueue<Integer> fifo = new PriorityQueue<Integer>();

        this.mainGlobal.visited.clear();

        fifo.add(indexVertex);
        this.mainGlobal.visited.setVisited(indexVertex);

        while (!fifo.isEmpty())
        {
            vertexOfFifo = fifo.remove();

            for (neighbor=0; neighbor<this.mainGlobal.adjacencyMatrix.numberVertex(); neighbor++)
            {
                if (this.mainGlobal.adjacencyMatrix.getEdge(neighbor, vertexOfFifo)!=0 && !this.mainGlobal.visited.isVisited(neighbor))
                {
                    fifo.add(neighbor);
                    this.mainGlobal.visited.setVisited(neighbor);
                    
                    this.mainGlobal.screen.getVertice(vertexOfFifo).setCor(Color.RED);
                    this.mainGlobal.screen.getVertice(neighbor).setCor(Color.RED);
                    this.mainGlobal.screen.getAresta(vertexOfFifo, neighbor).setCor(Color.RED);
                }
            }
        }
    }
}
