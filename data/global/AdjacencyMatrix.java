package data.global;

public class AdjacencyMatrix
{
    private int[][] value;
    
    public AdjacencyMatrix(int numberOfVertex)
    {
        this.value = new int[numberOfVertex][numberOfVertex];
    }
    
    public void addEdge(int vertexRoot, int vertex, int weight)
    {
        this.value[vertexRoot][vertex] = weight;
        this.value[vertex][vertexRoot] = weight;
    }
    
    public void delEdge(int vertexRoot, int vertex)
    {
        this.value[vertexRoot][vertex] = 0;
        this.value[vertex][vertexRoot] = 0;
    }
    
    public int getEdge(int vertexRoot, int vertex)
    {
        return this.value[vertexRoot][vertex];
    }
    
    public int numberVertex()
    {
        return this.value.length;
    }
    
    public String[][] getCopy()
    {
        String[][] adjacencyMatrix = new String[this.value.length][this.value.length];
        int i, j;
        
        for (i=0; i<this.value.length; i++)
        {
            for (j=0; j<this.value.length; j++)
            {
                adjacencyMatrix[i][j] = String.valueOf(this.value[i][j]);
            }
        }
        
        return adjacencyMatrix;
    }
}
