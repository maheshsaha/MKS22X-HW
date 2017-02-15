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
	solutionCount = -1;
    }
    
    private void addQueen(int r, int c){
	board[r][c] = -1;

	for(int col = c+1; col < board.length; col++){
	    board[r][col] += 1;
	}
	for(int j = 1; r+j < board.length && c+j < board.length; j++){
	    board[r+j][c+j] += 1;
	}
	for(int l = 1; r-l > -1 && c+l < board.length; l++){
	    if(board[r-l][c+l] != -1)
		board[r-l][c+l] += 1;
	}
    }	


    private void removeQueen(int r, int c){
	board[r][c] = 0;
	
	for(int col = c+1; col < board.length; col++){
	    board[r][col] -= 1;
	}
	for(int j = 1; r+j < board.length && c+j < board.length; j++){
	    board[r+j][c+j] -= 1;
	}
	for(int l = 1; r-l > -1 && c+l < board.length; l++){
	    if(board[r-l][c+l] != -1)
		board[r-l][c+l] -= 1;
	}
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
	return solveH(0);
    }
    
    private boolean solveH(int col){
	if (col >= board.length){
	    return true;
	}
	else {
	    for (int r = 0; r < board.length; r++){
		if (board[r][col] == 0) {
		    addQueen(r,col);
		    if (!solveH(col + 1)){
			removeQueen(r, col);
		    }
		    else
			return true;
		}
	    }
	    return false;
	}
    }
    
    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
	if (board.length == 0)
	    return 0;
	else
	    return solutionCount;
    }

    public void countSolutions(){
	if(solutionCount == -1){
	    solutionCount = 0;
	}
	countHelper(0);
    }

    public void countHelper(int c) {
	if (c >= board.length){
	    solutionCount += 1;
	}
	else {
	    for(int r = 0; r < board.length; r ++){
		if (board[r][c] == 0){
		    addQueen(r, c);
		    countHelper(c+1);
		    removeQueen(r, c);
		}
	    }
	}
    }
	
    /**toString
     *and all numbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	String i = "";
	for(int r = 0; r < board.length; r++){
	    i += "\n";
	    for(int c = 0; c < board[0].length; c++){
		if(board[r][c] == -1){
		    i += " Q ";}
		else{
		    i += " _ ";}
	    }
	}
	return i;
    }

    public static void main(String[] args) {
       	QueenBoard test = new QueenBoard(3);
	test.solve();
	System.out.println(test);
	QueenBoard test2 = new QueenBoard(8);
	test2.countSolutions();
	System.out.println(test2.getSolutionCount());
    }
}

