import java.util.*;

public class FrontierPriorityQueue implements Frontier{

    private ArrayList<Location> heap;
    private int size;
    private int constant;

    public FrontierPriorityQueue(){
	heap = new ArrayList<Location>();
	heap.add(null);
    }

    public Location next(){
	return remove();
    }

    public int size(){
	return size;
    }
    
    private void swap(int a, int b){
	Location temp = heap.get(a);
	heap.set(a,heap.get(b));
	heap.set(b,temp);
    }

    public void add(Location s){
	heap.add(s);
	size ++;
	pushUp();
	pushDown();

    }

    public Location remove(){
	if(heap.size() > 2){
	    Location s = heap.set(1,heap.remove(size));
	    size --;
	    pushDown();
	    pushUp();
	    return s;
	}
	else{
	    Location s = heap.remove(size);
	    size --;
	    return s;
	}
	//return s;
    }

    public Location peek(){
	if (size < 1)
	    throw new NoSuchElementException("empty heap");
	else
	    return heap.get(1);
    }

    public void pushDown(){
    	int current = 1;
    	int newCurrent;
    	while (current*2 + 1 <= size) {
	    boolean min = heap.get(2 * current).compareTo(heap.get(2 * current + 1)) * constant > 0;
	    if (min){
		if (heap.get(current).compareTo(heap.get(2 * current)) * constant < 0) {
                    swap(current, 2 * current);
                    current = 2 * current;
                }
		else if (heap.get(current).compareTo(heap.get(2 * current + 1)) * constant < 0) {
                    swap(current, 2 * current + 1);
                    current = 2 * current + 1;
                }
		else {
                    break;
                }
            }
	    else {
                if (heap.get(current).compareTo(heap.get(2 * current + 1)) * constant < 0){
                    swap(current, 2 * current + 1);
                    current = 2 * current + 1;
                }
		else if (heap.get(current).compareTo(heap.get(2 * current)) * constant < 0) {
                    swap(constant, 2 * constant);
                    constant = 2 * constant;
		}
		else {
                    break;
                }
	    }
	}
    }
    
    public void pushUp(){
    	int current = size;
    	while (current > 1 && heap.get(current).compareTo(heap.get(current/2)) * constant > 0){
    	    swap (current, current/2);
    	    current = current / 2;
    	}
    }
}
