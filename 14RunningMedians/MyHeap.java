import java.util.*;

public class MyHeap{
    
    ArrayList<Integer> heap;
    int constant;
    int size;
    
    public MyHeap(){
	constant = 1;
	heap = new ArrayList<Integer>();
	heap.add(null);
	size = heap.size();
    }

    public MyHeap(boolean value){
	heap = new ArrayList<Integer>();
	heap.add(null);
        if (value)
	    constant = 1;
	else
	    constant = -1;
	size = heap.size();
    }
    
    private void swap(int a, int b){
	Integer temp = heap.get(a);
	heap.set(a,heap.get(b));
	heap.set(b,temp);
    }

    private int myCompare(Integer a, Integer b){
	return a.compareTo(b)*constant;
    }

    public void add(Integer s){
	heap.add(s);
	pushUp();
	size ++;	
    }

    public Integer remove(){
	Integer s = heap.get(1);
	// System.out.println(size);
	// System.out.println(heap.get(size-1));
	heap.set(1,heap.get(size-1));
	pushDown();
	size --;
	return s;
    }

    public Integer peek(){
	if (size <= 0)
	    throw new NoSuchElementException();
	else
	    return heap.get(size);
    }

    public void pushDown(){
	int current = 1;
	int newCurrent;
	// System.out.print("pushDown call: ");
	// System.out.println(heap);
	while ((current*2 + 1 <= size-1) && parentChild(current)) {
	    // System.out.println(heap.get(current*2));
	    // System.out.println(heap.get(current*2+1));
	    // System.out.println(current);
	    if (myCompare(heap.get(current * 2), heap.get(current * 2 + 1)) >= 0)
		newCurrent = current * 2;
	    else
		newCurrent = current * 2 + 1;
	    // System.out.println(newCurrent);
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
    public String toString(){
        String s = "[";
        for (int i = 0; i < size; i++) {
            s += heap.get(i) + ", ";
        }
	return s.substring(0, s.length() - 2) + "]";
    }
    
    public static void main(String[] args){
    }
    
}
