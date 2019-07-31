package data.algorithm;

import data.MainGlobal;
import java.awt.Color;

public class Prim
{
    private MainGlobal mainGlobal;
    
    public Prim(MainGlobal mainGlobal)
    {
        this.mainGlobal = mainGlobal;
    }
    
    public void primAlgorithm()
    {
        this.mainGlobal.visited.clear();
        this.prim();
    }
    
    private void prim()
    {
        int i, j, k;
        int beginIndex, endIndex, weight, totalWeight = 0;

        this.mainGlobal.visited.setVisited(0);
        this.mainGlobal.screen.getVertice(0).setCor(Color.MAGENTA);

        beginIndex = Integer.MAX_VALUE;

        for(i=0; i<this.mainGlobal.adjacencyMatrix.numberVertex(); i++)
        {
            weight = Integer.MAX_VALUE;
            endIndex = Integer.MAX_VALUE;

            for(j=0; j<this.mainGlobal.adjacencyMatrix.numberVertex(); j++)
            {
                if(this.mainGlobal.visited.isVisited(j))
                {
                    for(k=0; k<this.mainGlobal.adjacencyMatrix.numberVertex(); k++)
                    {
                        if(this.mainGlobal.adjacencyMatrix.getEdge(j, k)!=0
                            && (this.mainGlobal.adjacencyMatrix.getEdge(j, k)<weight && !this.mainGlobal.visited.isVisited(k)))
                        {
                            weight = this.mainGlobal.adjacencyMatrix.getEdge(j, k);
                            beginIndex = j;
                            endIndex = k;
                        }
                    }
                }
            }

            if(endIndex != Integer.MAX_VALUE)
            {
                this.mainGlobal.visited.setVisited(endIndex);
                this.mainGlobal.screen.getAresta(beginIndex, endIndex).setCor(Color.MAGENTA);
                totalWeight += this.mainGlobal.screen.getAresta(beginIndex, endIndex).getPeso();
                this.mainGlobal.screen.getVertice(endIndex).setCor(Color.MAGENTA);
            }
        }
        
        this.mainGlobal.screen.lblCusto.setText(String.valueOf(totalWeight));
    }
}
