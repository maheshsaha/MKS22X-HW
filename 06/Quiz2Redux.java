import java.util.*;
public class Quiz2Redux{  
    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help(words,s,0,"");
	Collections.sort(words);
	return words;
    }
    
    private static void help(ArrayList<String> words, String s, int index, String subS){
	if (index >= s.length()){
	    words.add(subS);
	    return;
	}
	help(words,s,index+1,subS);
	help(words,s,index+1,subS + s.charAt(index));
    }
    
    public static void main(String[] args){
	System.out.println(combinations("abcd"));
    }
}
