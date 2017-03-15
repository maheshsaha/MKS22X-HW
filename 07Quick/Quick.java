public class Quick {

    public static int part ( int [] data){
	int randomInd = (int)(Math.random() * data.length);
	int val = data[randomInd];
	System.out.println(data[randomInd]);
	System.out.println(toArray(data));

	int lessThan = 0;

	for (int i = 0; i < randomInd; i ++){
	    if (data[i] < data[randomInd])
		lessThan += 1;
	}
	for (int j = randomInd+1; j < data.length; j++){
	    if (data[j] < data[randomInd])
		lessThan += 1;
	}

	int tempi = data[lessThan];
	data[lessThan] = data[randomInd];
	data[randomInd] = tempi;
	
	
	for(int i = 0; i < lessThan; i++){
	    if(data[i] > data[lessThan]){
		int temp = data[i];
		data[i] = data[lessThan + i + 1];
		data[lessThan + i + 1] = temp; 
	    }
	}
	return lessThan;
    }

    public static String toArray(int[]data){
	String s = "";
	    for (int i = 0; i < data.length; i ++){
		s += data[i] + ", ";
	    }

	return s; 
    }

    public static void main(String[]args){
	int[]blah = {999,999,999,4,1,0,3,2,999,999,999};
	System.out.println(part(blah));
    }

    
    
    
	//-Choose a random element to be a pivot, and partition the array around it. 
	//-Only partition the elements from start to end inclusive.
	//-When done returns the index of the final position of the pivot element.      
	//    (Should be from start to end inclusive)
    }
