public class MyLinkedList {
    LNode start;
    int size;

    public LinkedList(){
	LinkedList x = new LinkedList();
    }
   
    public String toString(){
	String i = "[";
	for (int x = 0; x < size-1; x++){
	    i += get(x) + ", ";
	}
	i += get(size-1) + "]";
    }

}

public class LNode {
    /* Phase I:
       boolean add(int value) 
       - adds the value to end (try adding to the front first, for testing purposes)
       int size() 
       - return the number of elements in the list
       toString() 
       - returns a string representation of the list of n elements formatted like: 
       [ v0, v1, v2, v3, ... vn-1, ] 
       An empty list is just []
       int get(int index) 
       - return the value of the element at the specified index (0 based)
       int set(int index,int newValue)
       - change the value of the element at the specified index to the newValue, return the old value  
       
       Phase II:
       int indexOf(int value) 
       - returns the index of the 1st occurrence of the value in the linked list, -1 if not found.
       boolean add(int index, int value)    
       - insert a new element at the specified index, 0 at the front, size() at the end. 
       int remove(int index) 
       - remove the element at the specified index, returns the value removed
       
       ALSO: 
       -Any exceptions that the actual LinkedList contains:  get,set,add,remove
    */
