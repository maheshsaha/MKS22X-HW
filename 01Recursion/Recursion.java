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
    public static boolean closeEnough(double a, double b){
	if(a==0.0 && b==0.0)return true;
	if(a==0.0)return b < 0.00000000001;
	if(b==0.0)return a < 0.00000000001;
	return Math.abs(a-b)/a < 0.0001;//very generous %error accepted
    }
    public static void main(String[]args){
	double[] input = {1.0,2.0,4.0,7.0,10.0,100.0,1024.0,-1.0,0.0};
	int score = 0;
	for(double in : input){
	    try{
		if(closeEnough(Recursion.sqrt(in),Math.sqrt(in))){
		    score++;
		    //System.out.println("PASS test "+in+" "+Recursion.sqrt(in));
		}
		else{
		    System.out.println("Fail test "+in+" "+Recursion.sqrt(in)+" vs "+Math.sqrt(in));
		}
	    }catch(IllegalArgumentException n){
		if(in == -1){
		    score++;
		}
	    }catch(Exception e){
		System.out.println("Some exception in test case:"+in);
	    }
	}
	System.out.println(score+";out of: "+input.length+";"+Recursion.name());
    }
}


