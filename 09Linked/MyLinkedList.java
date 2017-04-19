import java.util.*;

public class MyLinkedList implements Iterable<Integer> {
    
    LNode start;
    LNode end;
    int size;

    public class LinkedListIterator implements Iterator<Integer>{
	
	private MyLinkedList current;
	private int index;
	
	public LinkedListIterator(MyLinkedList list){
	    current = list;
	    index = 0;
	}
	
	public boolean hasNext(){
	    return index < current.size();
	}
	
	public Integer next(){
	    if(hasNext()){
		index ++;
		return current.get(index-1);
	    }
	    else{
		throw new NoSuchElementException();
	    }
	}
	
	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
    
    public LinkedListIterator iterator(){
	return new LinkedListIterator(this);
    }
    
    public MyLinkedList(){
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
	    location.next = toBeAdded;
	}
    }
    
    
    private void remove(LNode target){
    	if(start == target){
    	    start = start.next;
    	    if (size != 1)
    		start.prev = null;
	}
    	else if(end == target){
    	    end = end.prev;
    	    end.next = null;
    	}	
    	else{
    	    target.prev.next = target.next;
    	    target.next.prev = target.prev;
    	}
    }
    
    public boolean add(int value){ 
	add(size,value);
	return true;
    }
    
    public void add(int index, int value){
	if(index < 0 || index > size()){
    	    throw new IndexOutOfBoundsException();
    	}
	if (index == 0){
	    if(size == 0){
		start = new LNode(value);;
		end = start;
	    }
	    else{
		start.prev = new LNode(value);
		LNode temp = start;
		start = start.prev;
		start.next = temp;
		//System.out.println(this.toToString());
	    }
	}
	else if(index == size()){
	    addAfter(end, new LNode(value));
	}
    	else{
	    addAfter(getNthNode(index-1), new LNode(value));
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
