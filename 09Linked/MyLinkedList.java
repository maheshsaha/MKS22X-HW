import java.util.*;

public class MyLinkedList implements Iterable<Integer> {
  
    LNode start;
    LNode end;
    int size;

    public class LinkedListIterator implements Iterator<Integer>{
	private LNode current;
	private int index;

	public LinkedListIterator(MyLinkedList list){
	    current = list.start;
	}

	public boolean hasNext(){
	    return current.next != null;
	}

	public Integer next(){
	    if(hasNext()){
		index ++;
		current = current.next;
		return current.value;
	    }
	    else{
		throw new NoSuchElementException();
	    }
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
    
    public MyLinkedList(){
    }

    public LinkedListIterator iterator(){
	return new LinkedListIterator(this);
    }
        
    public int size(){
	return size;
    }

    private LNode getNthNode(int n){
	if(n < 0 || n > size()-1){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = start;
	int i = 0;
	while (current != null){
	    if (i == n)
		break;
	    else{
		current = current.next;
		i++;
	    }
	}
	return current;
    }
    
    private void addAfter(LNode location, LNode toBeAdded){
	if(location == end){
	    end.next = toBeAdded;
	    toBeAdded.prev = end;
	    end = toBeAdded;
	}
	else{
	    toBeAdded.next = location.next;
	    toBeAdded.prev = location;
	    toBeAdded.next.prev = toBeAdded;
	    location.next = toBeAdded;
	}
    }
    

    private void remove(LNode target){
	if(end == target){
	    end = end.prev;
	    end.next = null;
	}
	else if(start == target){
	    start.next = start;
	    start.prev = null;
	}
	else{
	    target.prev.next = target.next;
	    target.next.prev = target.prev;
	}
	size --;
    }    

    public boolean add(int value){ 
	add(size,value);
	return true;
    }
    
    public void add(int index, int value){
	if(index < 0 || index > size()){
    	    throw new IndexOutOfBoundsException();
    	}
	if (index == 0 && size == 0){
	    start = new LNode(value);;
	    end = start;
	}
    	else if (index == 0){
	    start.prev = new LNode(value);
    	    start.next = start;
    	    start = start.prev;
    	}
	else if(index == size()){
	    LNode val = new LNode(value);
	    addAfter(end, val);
	}
    	else{
	    LNode val = new LNode(value);
	    addAfter(getNthNode(index-1), val);
    	}
    	size ++;
    }
    
    public int remove(int index){
	if(index < 0 || index >= size()){
    	    throw new IndexOutOfBoundsException();
    	}
	int val = get(index);
	remove(getNthNode(index));
	size --;
	return val;
    }

    
    public int get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	return getNthNode(index).value;
    }
    
    public int set(int index, int newValue){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	int oVal = get(index);
	getNthNode(index).value = newValue;
	return oVal;
    }
    
    public String toString(){
	if (size == 0){
	    return "[]";
	}
	if (size == 1){
	    return "[" + start.value + "]";
	}
	String i = "[";
	LNode current = start;
	while(current.next != null){
	    i += current.value + ", ";
	    current = current.next;
	}
	i += (current.value + "]");
	return i;
    }

    public String toToString(){
	if (size == 0){
	    return "[]";
	}
	if (size == 1){
	    return "[(null)" + start.value + "(null)]";
	}
	String i = "[(null)";
	LNode current = start;
	i += current.value + "(" + current.next.value + "), ";
	current = current.next;
	while(current.next != null){
	    i += "(" + current.prev.value + ")" + current.value + "(" + current.next.value + "), ";
	    current = current.next;
	}
	i += "(" + current.prev.value + ")" + current.value + "(null)]";
	return i;
    }

    public int indexOf(int value){
	LNode current = start;
	int i= 0;
	while(current != null){
	    if (current.value == value){
		return i;
	    }
	    else{
		current = current.next;
		i++;
	    }
	}
	return -1;
    }
	
    private class LNode {
        int value;
	LNode next,prev;
	
	public LNode(int val){
	    value = val;
	}
	
	public String toString(){
	    return value + "";
	}
    }
    
    public static void main(String[] args){
    }
}
