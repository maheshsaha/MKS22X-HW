import java.util.*; // i finally get this aftr learning it from jwu

public class MazeSolver{

    private Maze board;
    private boolean animate;
    private boolean aStar;
    private Frontier f;
    
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
	solve(1);
    }

    public void solve(int style){
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
	f.add(board.getStart());
	
	Location x;
	while(f.size()>0){
	    x = f.next();
	    board.set(x.getRow(),x.getCol(),'.');
	    if(distToGoal(x.getRow(),x.getCol())==0){
		while(x.getPrev() != null){
		    x = x.getPrev();
		    board.set(x.getRow(),x.getCol(),'@');
		}
		return;
	    }
	    for(Location l : getNeighbors(x)){
		if(l != null){
		    f.add(l);
		    board.set(l.getRow(),l.getCol(),'?');
		}
	    }
	    System.out.println(board.toString(100));
	}
    }

    public ArrayList<Location> getNeighbors(Location l){
	ArrayList<Location> locations = new ArrayList<Location>();
	int r = l.getRow();
	int c = l.getCol();
	if(r + 1 < board.getMRow() && board.get(r + 1, c) == ' ')
	    locations.add(new Location(r + 1, c, l, distToStart(r + 1, c), distToGoal(r + 1, c), aStar));
	if(r - 1 >= 0 && board.get(r - 1,c) == ' ')
	    locations.add(new Location(r - 1, c, l, distToStart(r - 1, c), distToGoal(r - 1, c), aStar));
	if(c + 1 < board.getMCol() && board.get(r, c + 1) == ' ')
	    locations.add(new Location(r, c + 1, l, distToStart(r, c + 1), distToGoal(r, c + 1), aStar));
	if(c - 1 >= 0 && board.get(r, c - 1) == ' ')
	    locations.add(new Location(r, c - 1, l, distToStart(r, c - 1), distToGoal(r, c - 1), aStar));
	return locations;
    }

    public int distToStart(int x, int y){
	return Math.abs(board.getStart().getRow() - x) + Math.abs(board.getStart().getCol() - y);
    }

    public int distToGoal(int x, int y){
	return Math.abs(board.getEnd().getRow() - x) + Math.abs(board.getEnd().getCol() - y);
    }
    
    public String toString(){
	return board.toString();
    }

    public static void main(String[]args){
	// MazeSolver x = new MazeSolver("data2.txt");
	// x.solve(0);
	// System.out.println(x);

	// x.solve(1);
	// System.out.println(x);
	
	// x.solve(2);
	// System.out.println(x);

	// x.solve(3);
	// System.out.println(x);
    }
}
