public class Recursion {
    public static String name(){
	return "Saha,Mahesh";
    }
    
    public static double sqrt (double n){
	if (n < 0)
	    throw new IllegalArgumentException();
	else if (n == 0)
	    return 0;
	else{
	    return rHelper(n, 1);
	}
    }
    public static double rHelper(double n, double guess){
	double bGuess = (n/guess + guess)/2;
	if ((bGuess * bGuess)-n < 0.0000000001)
	    return bGuess;
	return rHelper(n, bGuess);
    }

    // public static void main(String[]args){
    // 	System.out.println(sqrt(1000));
    // 	System.out.println(name());
    }
}
