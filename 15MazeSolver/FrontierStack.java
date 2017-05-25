import java.util.*;

public class FrontierStack implements Frontier{

    private Stack<Location> x;

    public FrontierStack(){
	x = new Stack<Location>();
    }

    public void add(Location o){
	x.add(o);
    }

    public Location next(){
	return x.pop();
    }

    public int size(){
	return x.size();
    }
}
