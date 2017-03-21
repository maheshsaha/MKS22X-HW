import java.util.*;

public class Quick {

    public static void swap (int [] data, int i, int j){
	int temp = data[i];
	data[i] = data[j];
	data[j] = temp;
    }
    
    public static int part (int [] data, int start, int end){
	if (start == end)
	    return start;
	
	int randomInd = (int)(Math.random() * (end - start + 1)) + start;
	int val = data[randomInd];

	//	System.out.println(data[randomInd]);

	swap(data,randomInd,end);
	
	//	System.out.println(Arrays.toString(data));	

	int pivPos = start;
	
	for (int i = start; i < end; i ++){
	    if (data[i] < data[end]){
		swap(data,pivPos,i);
		pivPos += 1;
	    }
	}
	swap(data,pivPos,end);
	return pivPos;		    
    }
    
    public static int quickselect(int []data, int k){

	int start = 0;
	int end = data.length-1;
	int kPos = 0;
	
	while(true){
	    kPos = part(data,start,end);
	    if (k != kPos){
		if(k < kPos)
		    end = kPos;
		else
		    start = kPos;
	    }
	    else
		break;
	}
	return data[kPos];
    }
	    
	//return the value that is the kth smallest value of the array. 
	//use your partition method to help you accomplish this.
    
    
    
    
    public static void main(String[] args){
	int[] data = {1,1,1,1,1,2,3,4,5,7,8,8};
	System.out.println(part(data, 0, 11));
	System.out.println(Arrays.toString(data));
	int[]ary = { 2, 10, 15, 23, 0,  5};
	System.out.println(quickselect( ary , 0 ));// would return 0
	System.out.println(quickselect( ary , 1 ));//  would return 2
	System.out.println(quickselect( ary , 2 ));//  would return 5
	System.out.println(quickselect( ary , 3 ));//  would return 10
	System.out.println(quickselect( ary , 4 ));//  would return 15
	System.out.println(quickselect( ary , 5 ));//  would return 23
    }
}
