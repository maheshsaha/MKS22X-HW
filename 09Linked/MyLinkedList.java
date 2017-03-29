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
    
    public boolean add (int value){ //adds to start
       	LNode i = new LNode(value, start);
        start = i;
	size ++;
	return true;
    }

       
    public int size(){
	return size;
    }
    
    public int get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	
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
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	    
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

    public int indexOf(int value){
	LNode current = start;
	for (int i = 0; i < size; i ++){
	    if (current.value == value){
		return i;
	    }
	    else
		current = current.next;
	}
	return -1;
    }
    
    public static void main(String[] args){
	MyLinkedList x = new MyLinkedList();
	x.add(1);
	x.add(2);
	x.add(3);
	x.add(4);
	x.add(5);

	System.out.println(x);
	System.out.println(x.set(0,3));
	System.out.println(x);
	System.out.println("size = " + x.size());
	System.out.println(x.indexOf(7));

    }
}
