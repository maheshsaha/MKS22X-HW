public class KnightBoard{

    private int[][] board;

    public KnightBoard(int r, int c){
	board = new int[r][c];
	for (int i = 0; i < board.length; i ++){
	    for(int j = 0; j < board[i].length; j ++){
		board[i][j] = 0;
	    }
	}
    }
    
    public String toString(){
	return "";
    }

    public void solve(){
	solveH(0,0,1);
    }

    private boolean isGood(int r, int c){
	return true;
    }

    private boolean solveH(int r, int c, int l){ // l is the number of the knight
	if(l > board.length*board[0].length)
	    return true;
	else {
	    for (int w = 0; w < board.length; w++){
		if (board[w][c] == 0) {
		    addKnight(w,c);
		    if (!solveH(w,c+1){
			removeKnight(w,c);
		    }
		    else
			return true;
		}
	    }
	    return false;
	}
    }
    
