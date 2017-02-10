public class QueenBoard{

    private int[][]board;
    private int solutionCount;

    public QueenBoard(int size){
	board = new int[size][size];
	for (int i = 0; i < board.length; i ++){
	    for(int j = 0; j < board[i].length; j ++){
		board[i][j] = 0;
	    }
	}
    }
    
    private boolean addQueen(int r, int c){
	board[r][c] == -1;
	for (int i = r; i < board.length; i ++){
	    for(int j = c; j < board[i].length; j ++){
		board[i][j] = 0;
	    }
	}	
    }

    private boolean removeQueen(int r, int c){
	board[r][c] == 0;
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public boolean solve(){
	if (board.length == 2 || board.length == 3){
	    return false;
	}
	else{
	    return solveH(0);
	}
    }
    
    private boolean solveH(int col){
	if (col == board.length){
	    int x = 0;
	    for (int i = 0; i < board.length; i ++){
		if (board[i][col-1] == -1)
		    x++;
	    }
	    return x > 0;
	}
	else {
	    placeQueen[col][col];
    }
    
    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
    	return -1;
    }
    /**toString
     *and all numbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
    	return "";
    }
}

