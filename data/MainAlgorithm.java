package data;

import java.util.ArrayList;
import data.MainGlobal;
import data.algorithm.GroupE;
import data.algorithm.Degree;
import data.algorithm.Euler;
import data.algorithm.Eulerian;
import data.algorithm.Tree;
import data.algorithm.DepthFirstSearch;
import data.algorithm.BreadthFirstSearch;
import data.algorithm.Dijkstra;
import data.algorithm.Prim;
import data.algorithm.BreadthFirstSearchColoration;
import data.algorithm.DepthFirstSearchColoration;
import data.algorithm.EdgeColoration;

public class MainAlgorithm
{
    private GroupE groupE;
    private Degree degree;
    private Euler euler;
    private Eulerian eulerian;
    private Tree tree;
    private BreadthFirstSearch breadthFirstSearch;
    private DepthFirstSearch depthFirstSearch;
    private Dijkstra dijkstra;
    private Prim prim;
    private BreadthFirstSearchColoration breadthFirstSearchColoration;
    private DepthFirstSearchColoration depthFirstSearchColoration;
    private EdgeColoration edgeColoration;
    
    public MainAlgorithm(MainGlobal mainGlobal)
    {
        this.groupE = new GroupE(mainGlobal);
        this.degree = new Degree(mainGlobal);
        this.euler = new Euler(mainGlobal, this.degree);
        this.eulerian = new Eulerian(mainGlobal, this.degree);
        this.tree = new Tree(mainGlobal);
        this.breadthFirstSearch = new BreadthFirstSearch(mainGlobal);
        this.depthFirstSearch = new DepthFirstSearch(mainGlobal);
        this.dijkstra = new Dijkstra(mainGlobal);
        this.prim = new Prim(mainGlobal);
        this.breadthFirstSearchColoration = new BreadthFirstSearchColoration(mainGlobal, this.degree);
        this.depthFirstSearchColoration = new DepthFirstSearchColoration(mainGlobal, this.degree);
        this.edgeColoration = new EdgeColoration(mainGlobal);
    }
    
    public String groupE()
    {
        return this.groupE.value;
    }
    
    public int degree(int vertex)
    {
        return this.degree.getValue(vertex);
    }
    
    public boolean isEuler()
    {
        return this.euler.value;
    }
    
    public boolean isEulerian()
    {
        return this.eulerian.value;
    }
    
    public boolean isTree()
    {
        return this.tree.value;
    }
    
    public void breadthFirstSearch(int vertex)
    {
        this.breadthFirstSearch.breadthFirstSearch(vertex);
    }
    
    public void depthFirstSearch(int vertex)
    {
        this.depthFirstSearch.depthFirstSearch(vertex);
    }
    
    public void minimumWay(int indexVertex, int destinyVertex)
    {
        this.dijkstra.dijkstra(indexVertex, destinyVertex);
    }
    
    public void minimumTree()
    {
        this.prim.primAlgorithm();
    }
    
    public void breadthFirstSearchColoration()
    {
        this.breadthFirstSearchColoration.breadthFirstSearch();
    }
    
    public void depthFirstSearchColoration()
    {
        this.depthFirstSearchColoration.depthFirstSearch();
    }
    
    public void edgeColoration()
    {
        this.edgeColoration.edgeColoration();
    }
}
