public class KnightBoard{

    private int[][] board;

    public KnightBoard(int r, int c){
	board = new int[r][c];
	
    }
    
    public String toString(){
	String b = "";
	for (int i = 0; i < board.length; i ++){
	    if (i != 0)  b += "\n";
	    for (int j = 0; j < board[0].length; j ++){
		if (board[i][j] < 10)
		    b += " " + board[i][j] + " ";
		else
		    b += "" + board[i][j] + " ";
	    }
	}
	return b+"\n";
    }

    public void solve(){
	
	for (int i = 0; i < board.length; i ++){
	    for (int j = 0; j < board[i].length; j ++){
		board[i][j] = 0;
		if (solveH(i, j, 1))
		    return;
	    }
	}
    }

    private boolean valid(int row, int col, int level){
	return (row < board.length && row > -1 && col < board[0].length && col > -1 && board[row][col] == 0);
    }
    
    private boolean solveH(int row, int col, int level){
	if (level > board.length * board[0].length)
	    return true;
	else if (valid(row, col, level)){
	    board[row][col] = level;
	    if (solveH(row + 2, col + 1, level + 1)||
		solveH(row + 2, col - 1, level + 1)||
		solveH(row - 2, col + 1, level + 1)||		
		solveH(row - 2, col - 1, level + 1)||
		solveH(row + 1, col + 2, level + 1)||
		solveH(row + 1, col - 2, level + 1)||
		solveH(row - 1, col + 2, level + 1)||
		solveH(row - 1, col - 2, level + 1))
		return true;
	    else
		board[row][col] = 0;
	}
	return false;
    }
    
    public static void main(String[] args){
	for (int i = 1; i < 8; i ++){
	    System.out.println("Solving a " + i + " x " + i + " board: \n");
	    KnightBoard test = new KnightBoard(i,i);
	    test.solve();
	    System.out.println(test);
	}
	for (int i = 1; i < 8; i ++){
	    System.out.println("Solving a " + i + " x " + (i+1) + " board: \n");
	    KnightBoard test = new KnightBoard(i,i+1);
	    test.solve();
	    System.out.println(test);
	}
    }
}
