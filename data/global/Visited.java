package data.global;

public class Visited
{
    private boolean[] value;
    
    public Visited(int numberOfVertex)
    {
        this.value = new boolean[numberOfVertex];
    }
    
    public void setVisited(int index)
    {
        this.value[index] = true;
    }
    
    public void setUnvisited(int index)
    {
        this.value[index] = false;
    }
    
    public boolean isVisited(int index)
    {
        return this.value[index];
    }
    
    public void clear()
    {
        int i;
        
        for (i=0; i<this.value.length; i++)
            this.value[i] = false;
    }
}
