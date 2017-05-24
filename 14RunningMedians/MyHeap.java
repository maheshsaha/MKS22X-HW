import java.util.*;

public class MyHeap{
    
    ArrayList<Integer> heap;
    int constant;
    int size;
    
    public MyHeap(){
	constant = 1;
	heap = new ArrayList<Integer>();
	heap.add(0);
    }

    public MyHeap(boolean value){
	heap = new ArrayList<Integer>();
	heap.add(0);
        if (value)
	    constant = 1;
	else
	    constant = -1;
    }
    
    private void swap(int a, int b){
        int temp = heap.get(a);
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

    public void add(int s){
	heap.add(s);
	size ++;
	pushUp();
	pushDown();

    }

    public int remove(){
	int s = heap.set(1,heap.remove(size));
	size --;
	pushDown();
	pushUp();
	return s;
    }

    public int peek(){
	if (size < 1)
	    throw new NoSuchElementException("empty heap");
	else
	    return heap.get(1);
    }

    public void pushDown(){
    	int current = 1;
    	int newCurrent;
    	while ((current*2 + 1 <= size) && parentChild(current)) {
    	    if (myCompare(heap.get(current * 2), heap.get(current * 2 + 1)) >= 0)
    		newCurrent = current * 2;
    	    else
    		newCurrent = current * 2 + 1;
    	    swap(current, newCurrent);
    	    current = newCurrent;
    	}
    }
    
    private boolean parentChild(int a){ //checks if parent is smaller than child or not, in respect to min/max heap
	return (myCompare(heap.get(a),heap.get(a*2)) < 0) || (myCompare(heap.get(a), heap.get(a*2 + 1)) < 0);
    }
	
    public void pushUp(){
    	int current = size;
    	while (current > 1 && myCompare(heap.get(current), heap.get(current/2)) > 0){
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
