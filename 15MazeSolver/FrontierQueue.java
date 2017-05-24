import java.util.*;

public class FrontierQueue implements Frontier{
    private LinkedList<Location> f;

    public FrontierQueue(){
	f = new LinkedList<Location>();
    }

    public void add(Location x){
	f.add(x);
    }

    public Location next(){
	return f.remove();
    }

    public int size(){
	return f.size();
    }
}
