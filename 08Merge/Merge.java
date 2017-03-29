import java.util.*;
public class Merge{

    public int[] numbers;
    
    public static void merge(int[] a, int[] b, int[] destination){
	int iA = 0;
	int iB = 0;
	int iDest = 0;

	while (iA < a.length && iB < b.length){
	    if (a[iA] < b[iB]) {
		destination[iDest] = a[iA];
		iA ++;
	    }
	    else {
		destination[iDest] = b[iB];
		iB ++;
	    }
	    iDest ++;
	}
	for (int i = iA; i < a.length; i ++){
	    destination[iDest] = a[i];
	    iDest++;
	}
	for (int j = iB; j < b.length; j ++){
	    destination[iDest] = b[j];
	    iDest++;
	}
    }
i9
    public static void mergesort(int[] ary) {
	if (ary.length <= 1){
	    return;
	}

	int[]a = new int[ary.length/2];
	int[]b = new int[ary.length - a.length];

	for(int i = 0; i < ary.length/2; i ++) {
	    a[i] = ary[i];
	}
	int x = 0;
	for(int j = ary.length/2; j < ary.length; j ++) {
	    b[x] = ary[j];
	    x ++;
	}

	mergesort(a);
	mergesort(b);

	merge(a,b,ary);
	return;
    }
	
    public static void main(String[] args) {
    }
}
