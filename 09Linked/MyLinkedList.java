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
    private LNode end;
    private int size;

    public MyLinkedList(){
	start = null;
	end = null;
	size = 0;
    }
    
    public boolean add (int value){ //adds to end now!
	if (start == null){
	    start = new LNode(value);
	    end = new LNode(value);
	}
	else{
	    // end = new LNode(value, end);
	    LNode current = start;
	    for (int i = 0; i < size(); i ++){
	    	if (current.next == null){
	    	    current.next = new LNode(value);
	    	    end = new LNode(value);
	    	}
	    	current = current.next;
	    }
	}
	size ++;
	return true;
    }

    
    public void add(int index, int value){
	LNode current = start;
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
        if (index == size()){
	    for (int i = 0; i < size(); i ++){
		if (current.next == null){
		    current.next = new LNode(value);
		    end = new LNode(value);
		}
		current = current.next;
	    }
	}
	if (index == 0){
	    start = new LNode(value, start);
	}

	else{
	    int temp = set(index, value);
	    for(int j = 0; j < size(); j ++){
		if (j >= index + 1){
		    temp = set(j, temp);
		}
		current = current.next;
	    }
	    current = new LNode(temp);
	    end = new LNode(temp,null);
	    // System.out.println(temp);
	}
	size ++;
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
	while(current.next != null){
	    i += current.value + ", ";
	    current = current.next;
	}
	i += (current.value + "]");
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
    
    public static void main(String[] args){
	MyLinkedList x = new MyLinkedList();
	x.add(1);
	x.add(2);
	x.add(3);
	x.add(4);
	x.add(6);
	x.add(4,5);
	System.out.println(x.get(4));
	System.out.println(x.set(0,3));
	System.out.println(x);
	System.out.println("size = " + x.size());
	System.out.println(x.indexOf(5));
    
    }
}
