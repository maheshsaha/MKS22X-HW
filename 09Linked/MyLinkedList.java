public class MyLinkedList {

    public class LNode {
	private int value;
	private LNode next;
	
	public LNode(int val){
	    value = val;
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
	    LNode node = start;
	    int i = 0;
	    while (node != null){
		if (i == index-1){
		    LNode temp = node.next;
		    node.next = new LNode(value);
		    node.next.next = temp;
		}
		else node = node.next;
		i ++;
	    }
	}
	size ++;
    }
    
    public int remove(int index){
	int val = get(index);
    	LNode current = start;
    	if(index < 0 || index >= size()){
    	    throw new IndexOutOfBoundsException();
    	}

	else if(size() == 1){
	    start = null;
	    end = null;
	}

        else if (index == size()-1){
    	    for (int i = 0; i < size(); i ++){
    		if (i == index - 1){
    		    current.next = null;
    		    end = current;
		    break;
    		}
    		current = current.next;
    	    }
    	}

    	else if (index == 0){
    	    start = start.next;
    	}

    	else{
    	    LNode node = start;
	    int i = 0;
	    while (node.next != null){
		if (i == index-1){
		    node.next = node.next.next;
		    break;
		}
		else node = node.next;
		i ++;
	    }
	}
	size --;
	return val;
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
	System.out.println(x);
	System.out.println("size = " + x.size());
	System.out.println(x.remove(0));
	System.out.println(x);
	System.out.println(x.remove(1));
	System.out.println(x);
	System.out.println(x.remove(3));
	System.out.println(x);
	System.out.println(x.remove(0));
	System.out.println(x);
	System.out.println(x.remove(0));
	System.out.println(x);
	System.out.println(x.remove(0));
	System.out.println(x);
    }
}
