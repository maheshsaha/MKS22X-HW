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

	swap(data,randomInd,start);
	
	//	System.out.println(Arrays.toString(data));	

	int pivPos = start;
	
	for (int i = start + 1; i <= end; i ++){
	    if (data[i] <= val){
		if (i - pivPos == 1){
		    swap(data,i,pivPos);
		    pivPos += 1;
		}
		else{
		    swap(data,pivPos + 1, pivPos);
		    swap(data,pivPos,i);
		    pivPos += 1;
		}
	    }
	}
	return pivPos;		    
    }
    
    public static int quickselect(int []data, int k){
	int kPos = part(data,0,data.length-1);
	if (kPos!=0){
	    for (int i = 0; i < kPos; i ++){
		kPos = part(data,i,kPos-i);
		if (k == kPos)
		    return data[kPos];
	    }
	    for (int j = kPos + 1; j < data.length; j++){
		kPos = part(data,j,data.length-j);
		if (k == kPos)
		    return data[kPos];
	    }
	}
	return data[kPos];
    }
	    
	//return the value that is the kth smallest value of the array. 
	//use your partition method to help you accomplish this.
    
    
    
    
    public static void main(String[] args){
	int[] data = {9,8,7,4,4,10,1,2,55,12,0,2};
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
