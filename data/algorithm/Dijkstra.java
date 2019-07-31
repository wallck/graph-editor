package data.algorithm;

import data.MainGlobal;
import javax.swing.JOptionPane;
import java.awt.Color;

public class Dijkstra
{
    private MainGlobal mainGlobal;
    private int indexVertex, destinyVertex;
    private int[] A_Antecessor;
    private int[] E_Estimativa;
    private boolean[] F_Fechados;
    
    public Dijkstra(MainGlobal mainGlobal)
    {
        this.mainGlobal = mainGlobal;
    }
    
    public void dijkstra(int indexVertex, int destinyVertex)
    {
        int[] A_Antecessor = new int[this.mainGlobal.adjacencyMatrix.numberVertex()];
        int[] E_Estimativa = new int[this.mainGlobal.adjacencyMatrix.numberVertex()];
        boolean[] F_Fechados = new boolean[this.mainGlobal.adjacencyMatrix.numberVertex()];
        boolean naoEncontrado = true;
        boolean caminhoExiste = true;
        boolean caminhoPosicao = false;
        int i, extimativaMinima, indiceVertice = 0;
        
        this.indexVertex = indexVertex;
        this.destinyVertex = destinyVertex;
        
        for(i=0; i<this.mainGlobal.adjacencyMatrix.numberVertex(); i++)
        {
            F_Fechados[i] = false;
            E_Estimativa[i] = Integer.MAX_VALUE;
            A_Antecessor[i] = 0;
        }

        F_Fechados[indexVertex] = true;
        E_Estimativa[indexVertex] = 0;
        A_Antecessor[indexVertex] = indexVertex;

        for(i=0; i<this.mainGlobal.adjacencyMatrix.numberVertex(); i++)
        {
            if(indexVertex!=i && this.mainGlobal.adjacencyMatrix.getEdge(indexVertex, i)>0)
            {
                E_Estimativa[i] = this.mainGlobal.adjacencyMatrix.getEdge(indexVertex, i);
                A_Antecessor[i] = indexVertex;
            }
        }

        for(i=0; i<this.mainGlobal.adjacencyMatrix.numberVertex(); i++)
        {
            if(this.mainGlobal.adjacencyMatrix.getEdge(indexVertex, i) > 0)
            {
                caminhoPosicao = true;
                break;
            }
        }

        while(naoEncontrado && caminhoExiste && caminhoPosicao)
        {
            extimativaMinima = Integer.MAX_VALUE;
            indiceVertice = 0;

            for(i=0; i<this.mainGlobal.adjacencyMatrix.numberVertex(); i++)
            {
                if(!F_Fechados[i] && E_Estimativa[i]<extimativaMinima)
                {
                    extimativaMinima = E_Estimativa[i];
                    indiceVertice = i;
                }
            }

            F_Fechados[indiceVertice] = true;

            for(i=0; i<this.mainGlobal.adjacencyMatrix.numberVertex(); i++)
            {
                if(!F_Fechados[i] && this.mainGlobal.adjacencyMatrix.getEdge(indiceVertice, i)>0)
                {
                    if((E_Estimativa[indiceVertice] + this.mainGlobal.adjacencyMatrix.getEdge(indiceVertice, i)) < E_Estimativa[i])
                    {
                        E_Estimativa[i] = E_Estimativa[indiceVertice] + this.mainGlobal.adjacencyMatrix.getEdge(indiceVertice, i);
                        A_Antecessor[i] = indiceVertice;
                    }
                }
            }

            if(F_Fechados[destinyVertex])
                naoEncontrado = false;
            else
            {
                naoEncontrado = true;
                caminhoExiste = false;

                for(i=0; i<this.mainGlobal.adjacencyMatrix.numberVertex(); i++)
                {
                    if(!F_Fechados[i] && E_Estimativa[i]<Integer.MAX_VALUE)
                    {
                        caminhoExiste = true;
                        break;
                    }
                }
            }
        }
        
        this.F_Fechados = F_Fechados;
        this.E_Estimativa = E_Estimativa;
        this.A_Antecessor = A_Antecessor;
        
        /**
        String saida = "";

        for (i=0; i<A_Antecessor.length; i++)
                saida += "["+A_Antecessor[i]+"]";

        saida += "\n";

        for (i=0; i<E_Estimativa.length; i++)
                saida += "["+E_Estimativa[i]+"]";

        saida += "\n";

        for (i=0; i<F_Fechados.length; i++)
                saida += "["+F_Fechados[i]+"]";

        JOptionPane.showMessageDialog(null, saida);
        /**/
        
        this.minimumWay(caminhoExiste, caminhoPosicao);
    }
    
    private void minimumWay(boolean caminhoExiste, boolean caminhoPosicao)
    {
        int auxDestinoOrigem, totalWeight = 0;
        
        if(caminhoExiste && caminhoPosicao)
        {
            auxDestinoOrigem = this.destinyVertex;

            this.mainGlobal.screen.getVertice(this.destinyVertex).setCor(Color.ORANGE);

            auxDestinoOrigem = this.A_Antecessor[this.destinyVertex];
            this.mainGlobal.screen.getVertice(auxDestinoOrigem).setCor(Color.ORANGE);
            this.mainGlobal.screen.getAresta(this.destinyVertex, auxDestinoOrigem).setCor(Color.ORANGE);
            totalWeight += this.mainGlobal.screen.getAresta(this.destinyVertex, auxDestinoOrigem).getPeso();

            while(auxDestinoOrigem != this.indexVertex)
            {
                this.mainGlobal.screen.getAresta(auxDestinoOrigem, A_Antecessor[auxDestinoOrigem]).setCor(Color.ORANGE);
                totalWeight += this.mainGlobal.screen.getAresta(auxDestinoOrigem, A_Antecessor[auxDestinoOrigem]).getPeso();
                auxDestinoOrigem = this.A_Antecessor[auxDestinoOrigem];
                this.mainGlobal.screen.getVertice(auxDestinoOrigem).setCor(Color.ORANGE);
            }
            
            this.mainGlobal.screen.lblCusto.setText(String.valueOf(totalWeight));
        }
        else
            JOptionPane.showMessageDialog(null, "Caminho Mínimo é Impossivel");
    }
}
