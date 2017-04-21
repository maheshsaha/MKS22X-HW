import java.util.*;

public class PostFix {

    public static double eval(String s){
        String[] tokens = s.split(" ");
	Stack<String> nums = new Stack<>();
        for(String token : tokens) {
            if(isOp(token)){
		nums.push(apply(token, nums.pop(), nums.pop()));
	    }
	    else
                nums.push(token);
	}
        return Double.parseDouble(nums.pop());
    }

    private static boolean isOp(String s){
        return s.equals("-") || s.equals("+") || s.equals("/") || s.equals("*") || s.equals("%");
    }

    private static String apply(String op, String a, String b){
	double A = Double.parseDouble(a);
	double B = Double.parseDouble(b);
	// System.out.println(A);
	// System.out.println(B);
	if(op.equals("-"))
            return (B - A) + "" ;
	if(op.equals("+"))
            return (B + A) + "";
	if(op.equals("/"))
            return (B / A) + "";
	if(op.equals("*"))
            return (B * A) + "";
	else
            return (B % A) + "";
    }

    public static void main(String[] args){
        System.out.println(eval("1.0 1.0 + 5.3 * 12 - 3 %"));
    }
}
