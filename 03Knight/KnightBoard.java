public class KnightBoard{

    private int[][] board;

    public KnightBoard(int r, int c){
	board = new int[r][c];
	for (int i = 0; i < board.length; i ++){
	    for (int j = 0; j < board[i].length; j ++){
		board[i][j] = 0;
	    }
	}
    }
    
    public String toString(){
	String b = "";
	for (int i = 0; i < board.length; i ++){
	    b += "\n";
	    for (int j = 0; j < board[0].length; j ++){
		if (board[i][j] < 10)
		    b += " " + board[i][j] + " ";
		else
		    b += "" + board[i][j] + " ";
	    }
	}
	return b;
    }

    public void solve(){
	for (int i = 0; i < board.length; i ++){
	    for (int j = 0; j < board[i].length; j ++){
		if(solveH(i,j,1))
		    return;
	    }
	}
    }
    
    private boolean solveH(int row, int col, int level){
	return false;   
    }

    public static void main(String[] args){
        System.out.println("hello world!");
    }
}
