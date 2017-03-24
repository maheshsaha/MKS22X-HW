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
	
	swap(data,randomInd,start);

	int gt = end;
	int lt = start;
	int i = start + 1;
	int val = data[lt];

	while(i <= gt){
	    if(data[i] == val){
		i++;
	    }
	    else if(data[i] < val){
		swap(data,i,lt);
		i++;
		lt++;
	    }
	    else{
		swap(data,gt,i);
		gt--;
	    }
	}
	return lt;		    
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
    
    public static void quicksort(int[]data){
    	quicksortH(data, 0, data.length - 1);
    }

    public static void quicksortH(int[]data, int start, int end){
    	if (start == end)
    	    return;
	
    	int randomInd = (int)(Math.random() * (end - start + 1)) + start;
    	
    	swap(data,randomInd,start);
	
    	int gt = end;
    	int lt = start;
    	int i = start + 1;
    	int val = data[lt];

    	while(i <= gt){
    	    if(data[i] == val){
    		i++;
    	    }
    	    else if(data[i] < val){
    		swap(data,i,lt);
    		i++;
    		lt++;
    	    }
    	    else{
    		swap(data,gt,i);
    		gt--;
    	    }
    	}
	if (start < end){
	    quicksortH(data, gt, end);
	    quicksortH(data, start, lt - 1);
	}
    }
    
    
    
    public static void main(String[] args){
    }
}
