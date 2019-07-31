package data.algorithm;

import java.awt.Color;
import data.MainGlobal;

public class EdgeColoration
{
    private MainGlobal mainGlobal;
    private int greaterCountColor = 0;
    
    public EdgeColoration(MainGlobal mainGlobal)
    {
        this.mainGlobal = mainGlobal;
    }
    
    public void edgeColoration()
    {
        int i, j;
        int[][] edgeColor = new int[this.mainGlobal.adjacencyMatrix.numberVertex()][this.mainGlobal.adjacencyMatrix.numberVertex()];
        boolean[][] edgeVisited = new boolean[this.mainGlobal.adjacencyMatrix.numberVertex()][this.mainGlobal.adjacencyMatrix.numberVertex()];

        for (i=0; i<this.mainGlobal.adjacencyMatrix.numberVertex(); i++)
        {
            for (j=0; j<this.mainGlobal.adjacencyMatrix.numberVertex(); j++)
            {
                edgeVisited[i][j] = false;
                edgeColor[i][j] = -1;
            }
        }
        
        for (i=0; i<this.mainGlobal.adjacencyMatrix.numberVertex(); i++)
        {
            for (j=0; j<this.mainGlobal.adjacencyMatrix.numberVertex(); j++)
            {
                if (this.mainGlobal.adjacencyMatrix.getEdge(i, j)!=0 && !edgeVisited[i][j])
                    this.coloration(i, j, edgeColor, edgeVisited);
            }
        }
        
        this.mainGlobal.screen.lblXGV.setText(String.valueOf(this.greaterCountColor+1));
    }
    
    private void coloration(int indexVertex, int destinyVertex, int[][] edgeColor, boolean[][] edgeVisited)
    {
        int i, j, countColor = 0;
        Color[] colors = {Color.RED, Color.BLUE, Color.ORANGE, Color.MAGENTA, Color.WHITE, Color.PINK, Color.YELLOW};
        
        if(!edgeVisited[indexVertex][destinyVertex])
        {
            for(i=0; i<this.mainGlobal.adjacencyMatrix.numberVertex(); i++)
            {
                for(j=0; j<this.mainGlobal.adjacencyMatrix.numberVertex(); j++)
                {
                    if(this.mainGlobal.adjacencyMatrix.getEdge(indexVertex, j)!=0 && edgeVisited[indexVertex][j])
                    {
                        if(edgeColor[indexVertex][j] == countColor)
                            countColor++;
                    }

                    if(this.mainGlobal.adjacencyMatrix.getEdge(destinyVertex, j)!=0 && edgeVisited[destinyVertex][j])
                    {
                        if(edgeColor[destinyVertex][j] == countColor)
                            countColor++;
                    }
                }
            }
            
            if (countColor > this.greaterCountColor)
                this.greaterCountColor = countColor;
            
            this.mainGlobal.screen.getAresta(indexVertex, destinyVertex).setCor(colors[countColor]);
            edgeColor[indexVertex][destinyVertex] = countColor;
            edgeColor[destinyVertex][indexVertex] = countColor;
            edgeVisited[indexVertex][destinyVertex] = true;
            edgeVisited[destinyVertex][indexVertex] = true;
        }
    }
}
