public class MyLinkedList {

    public class LNode {
	private int value;
	private LNode next;
	
	public LNode(int val){
	    value = val;
	    next = null;
	}
	
	public LNode(int val, LNode node){
	    value = val;
	    next = node;
	}
    }
    
    private LNode start;
    private int size;

    public MyLinkedList(){
	start = null;
	size = 0;
    }
    
    public boolean add (int value) {
	LNode i = new LNode(value, start);
        start = i;
	size ++;
	return true;
    }
    
    public int size(){
	return size;
    }
    
    public int get(int index){
	LNode current = start;
	for (int i = 0; i < size; i ++){
	    if (i == index){
		return current.value;
	    }
	    else
		current = current.next;
	}
	return -1;
    }
    
    public int set(int index, int newValue){
	LNode current = start;
	int oVal = get(index);
	for (int i = 0; i < index + 1; i ++){
	    if (i == index){
		current.value = newValue;
	    }
	    else{
		current = current.next;
	    }
	}
	return oVal;
    }
    
    public String toString(){
	if (size == 0){
	    return "[]";
	}
	String i = "[";
	LNode current = start;
	for (int x = 0; x < size-1; x++){
	    i += current.value + ", ";
	    current = current.next;
	}
	i += (current.value + "]");
	return i;
    }
    
    
    public static void main(String[] args){
    }
}
