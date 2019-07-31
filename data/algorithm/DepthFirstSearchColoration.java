package data.algorithm;

import java.awt.Color;
import data.MainGlobal;
import data.algorithm.Degree;

public class DepthFirstSearchColoration
{
    private MainGlobal mainGlobal;
    private Degree degree;
    private int greaterCountColor = 0;
    
    public DepthFirstSearchColoration(MainGlobal mainGlobal, Degree degree)
    {
        this.mainGlobal = mainGlobal;
        this.degree = degree;
    }
    
    public void depthFirstSearch()
    {
        int[] colorVertex = new int[this.mainGlobal.adjacencyMatrix.numberVertex()];
        int i, greaterVertex = 0, greater = 0;
        
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
        this.depth(greaterVertex, colorVertex);
        
        this.mainGlobal.screen.lblXG.setText(String.valueOf(this.greaterCountColor+1));
    }
    
    private void depth(int indexVertex, int[] colorVertex)
    {
        int neighbor;
		
        this.mainGlobal.visited.setVisited(indexVertex);

        for (neighbor=0; neighbor<this.mainGlobal.adjacencyMatrix.numberVertex(); neighbor++)
        {
            if (this.mainGlobal.adjacencyMatrix.getEdge(indexVertex, neighbor)!=0 && !this.mainGlobal.visited.isVisited(neighbor))
            {
                this.coloration(indexVertex, colorVertex);
                this.coloration(neighbor, colorVertex);
                this.depth(neighbor, colorVertex);
            }
        }
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
