public class FrontierPriorityQueue implements Frontier{

    private MyHeap heap;

    public FrontierPriorityQueue(){
	heap = new MyHeap();
    }

    public void add (Location x){
	heap.add(x);
	
    }

    public int size(){
	return heap.size();
    }
    
    public Location next(){
	return heap.remove();
    }
    
}
