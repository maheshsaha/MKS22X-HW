import java.util.*;

public class MyDeque{
    String[] ary;
    int size, front, back;

    public MyDeque(){
	ary = new String[10];
    }
    
    public void addFirst(String i){
	if (i.equals(null)){
	    throw new NullPointerException();
	}
	if(size == ary.length){
	    resize();
	}
	else{
	    front --;
	    if (front < 0)
		front = ary.length - 1;
	    ary[front] = i;
	}
	size ++;
    }
    
    public void addLast(String i){
	if (i.equals(null)){
	    throw new NullPointerException();
	}
	if(size == ary.length){
	    resize();
	}
	else{
	    back ++;
	    if(back == ary.length)
		back = 0;
	    ary[back] = i;
	}
	size ++;
    }
    
    public String removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	String i = ary[front];
	front ++;
	if (front == ary.length){
	    front = 0;
	}
	size --;
	return i;	       
    }

    public String removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	String i = ary[back];
	back --;
	if (back < 0){
	    back = ary.length - 1;
	}
	size --;
	return i;
    }

    public String getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return ary[front];
    }

    public String getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return ary[back];
    }

    private void resize(){
	String[] temp = new String[ary.length*2];
	int i = 0;
	int f = front;
	while (i < ary.length){
	    if(f == ary.length){
		f = 0;
	    }
	    temp[i] = ary[f];
	    f ++;
	    i ++;
	}
	front = 0;
	back = ary.length-1;
	ary = temp;
    }

    public String toString(){
	String blah = "";
	int f = front;
	for(int i = 0; i < size; i++){
	    if(f == ary.length){
		f = 0; 
	    }
	    blah += ary[f] + ", ";
	    f++;
	}
	
	return blah; 	
    }

    public static void main(String[] args){
    }
}
