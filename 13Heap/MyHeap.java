import java.util.*;

public class MyHeap{

    boolean minMax; //true means max heap
    ArrayList<String> heap;
    int min, max;
    int current;
    
    public MyHeap(){
	minMax = true;
	heap = new ArrayList<String>()
    }

    public MyHeap(boolean value){
        minMax = value;
	heap = new ArrayList<String>()
    }

    public void add(String s){
	int child1 = current * 2;
	int child2 = child1 + 1;
	if (minmax)
	    if(max == null){
		max = heap.get(1);
		current = 1;
	    else{
		if (heap.get(child1) == null)
		    heap.add(child1, s);
		else if (heap.get(child2) == null){
		    heap.add(child2, s);
		    current += 1;
		}
		if (s.compareTo(max)>0)
		    pushForth();
		else
		    pushBack();
	else
	    if(min == null)
		min = heap.get(1);
	    else
		if (s.compareTo(min)<0)
		    min = s;
		else
		    pushBack();
    }
    
    public String remove(){
    }

    public String peek(){
    }

    public void pushForth(int index){
	int child1 = index * 2;
	int child2 = child1 + 1;
	if(minMaX)
	    if (heap.get(index).compareTo(heap.get(child1))
    }

    public void pushBack(int index){
    }
    
    public static void main(String[]args){
    }

}


    
