package data;

import data.global.AdjacencyMatrix;
import data.global.Visited;
import userInterface.MainForm;

public class MainGlobal
{
    public AdjacencyMatrix adjacencyMatrix;
    public Visited visited;
    public MainForm screen;
    
    public MainGlobal(int numberOfVertex)
    {
        this.adjacencyMatrix = new AdjacencyMatrix(numberOfVertex);
        this.visited = new Visited(numberOfVertex);
    }
    
    public void reBuild(int numberOfVertex)
    {
        this.adjacencyMatrix = null;
        this.visited = null;
        
        this.adjacencyMatrix = new AdjacencyMatrix(numberOfVertex);
        this.visited = new Visited(numberOfVertex);
    }
    
    public void addUserInterface(MainForm screen)
    {
        this.screen = screen;
    }
}
