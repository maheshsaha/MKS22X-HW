import java.util.*;

public class MyHeap{
    
    ArrayList<Location> heap;
    int constant;
    int size;
    
    public MyHeap(){
	constant = 1;
	heap = new ArrayList<Location>();
	heap.add(null);
    }

    public MyHeap(boolean value){
	heap = new ArrayList<Location>();
	heap.add(null);
        if (value)
	    constant = 1;
	else
	    constant = -1;
    }
    
    private void swap(int a, int b){
	Location temp = heap.get(a);
	heap.set(a,heap.get(b));
	heap.set(b,temp);
    }

    private int myCompare(int a, int b){
	if (a > b){
	    return 1 * constant;
	}
	else if (a < b){
	    return -1 * constant;
	}
	else return 0;
    }

    public void add(Location s){
	heap.add(s);
	size ++;
	pushUp();
	pushDown();

    }

    public Location remove(){
        Location s = heap.set(1,heap.remove(size));
	size --;
	pushDown();
	pushUp();
	return s;
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

    // public String toString(){
    //     String s = "[";
    //     for (int i = 0; i < size; i++) {
    //         s += heap.get(i) + ", ";
    //     }
    // 	return s.substring(0, s.length() - 2) + "]";
    // }
    
    public static void main(String[] args){

    }
    
}
