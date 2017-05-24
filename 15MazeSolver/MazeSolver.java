import java.util.*;

public class MazeSolver{

    private Maze board;
    private boolean animate;
    
    public MazeSolver(String filename){
	this(filename, false);
    }

    public MazeSolver(String filename, boolean animate){
	//0 DFS
	//1 BFS
	//2 BF
	//3 A
	this.animate = animate;
        board = new Maze(filename);
    }

    public void solve(){
	sovle(1);
    }

    public void solve(int style){
	boolean aStar = false;
	Frontier f;
	
	if (style == 0)
	    f = new FrontierStack();
	if (style == 1)
	    f = new FrontierQueue();
	if (style == 2)
	    f = new FrontierPriorityQueue();
	if (style == 3){
	    f = new FrontierPriorityQueue(); //astar
	    aStar = true;
	}
	else{
	    System.out.println("Invalid input");
	    System.exit();
	}
	f.add(board.getStart());
	
	location x;
	while(f.size() > 0){
	    x = 
    }

    public toString(){
    }
}
