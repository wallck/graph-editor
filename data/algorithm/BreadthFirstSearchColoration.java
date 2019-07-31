package data.algorithm;

import java.util.PriorityQueue;
import java.awt.Color;
import data.MainGlobal;
import data.algorithm.Degree;

public class BreadthFirstSearchColoration
{
    private MainGlobal mainGlobal;
    private Degree degree;
    private int greaterCountColor = 0;
    
    public BreadthFirstSearchColoration(MainGlobal mainGlobal, Degree degree)
    {
        this.mainGlobal = mainGlobal;
        this.degree = degree;
    }
    
    public void breadthFirstSearch()
    {
        int[] colorVertex = new int[this.mainGlobal.adjacencyMatrix.numberVertex()];
        int i, neighbor, vertexOfFifo, greaterVertex = 0, greater = 0;
        PriorityQueue<Integer> fifo = new PriorityQueue<Integer>();

        this.mainGlobal.visited.clear();
        
        for (i=0; i<this.mainGlobal.adjacencyMatrix.numberVertex(); i++)
        {
            colorVertex[i] = -1;

            if (this.degree.getValue(i) > greater)
            {
                greater = this.degree.getValue(i);
                greaterVertex = i;
            }
        }

        this.coloration(greaterVertex, colorVertex);

        fifo.add(greaterVertex);

        while (!fifo.isEmpty())
        {
            vertexOfFifo = fifo.remove();

            for(neighbor=0; neighbor<this.mainGlobal.adjacencyMatrix.numberVertex(); neighbor++)
            {
                if (this.mainGlobal.adjacencyMatrix.getEdge(neighbor, vertexOfFifo)!=0 && !this.mainGlobal.visited.isVisited(neighbor))
                {
                    this.coloration(neighbor, colorVertex);
                    fifo.add(neighbor);
                }		
            }
        }
        
        this.mainGlobal.screen.lblXG.setText(String.valueOf(this.greaterCountColor+1));
    }
    
    private void coloration(int vertex, int[] colorVertex)
    {
        int i, j, countColor = 0;
        Color[] colors = {Color.RED, Color.BLUE, Color.ORANGE, Color.MAGENTA, Color.WHITE};

        if(!this.mainGlobal.visited.isVisited(vertex))
        {
            for(i=0; i<this.mainGlobal.adjacencyMatrix.numberVertex(); i++)
            {
                for(j=0; j<this.mainGlobal.adjacencyMatrix.numberVertex(); j++)
                {
                    if(this.mainGlobal.adjacencyMatrix.getEdge(vertex, j)!=0 && this.mainGlobal.visited.isVisited(j))
                    {
                        if(colorVertex[j] == countColor)
                            countColor++;
                    }
                }
            }
            
            if (countColor > this.greaterCountColor)
                this.greaterCountColor = countColor;
            
            colorVertex[vertex] = countColor;
            this.mainGlobal.visited.setVisited(vertex);
            this.mainGlobal.screen.getVertice(vertex).setCor(colors[countColor]);
        }
    }
}
