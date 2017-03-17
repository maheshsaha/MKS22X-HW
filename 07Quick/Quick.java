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

   
    
    public static void main(String[] args){
	int[] data = {999,999,999,4,1,0,3,2,999,999,999};
	System.out.println(part(data, 0, 11));
	System.out.println(Arrays.toString(data));
    }
}
