public class MazeSolver{
    private Maze board;

    public MazeSolver(String filename){
	this(filename, false);
    }

    public MazeSolver(String filename, boolean animate){
	if (animate)
	    animate();
    }

    public void solve(){
	sovle(1);
    }

    public void solve(int style){
	//0 DFS
	//1 BFS
	//2 BF
	//3 A*
    }

    public toString(){
    }
}
