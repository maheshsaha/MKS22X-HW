import java.util.*;
import java.io.*;
import java.*;

public class Maze{

    private char[][]maze;
    private boolean animate;
    private boolean start, end;
    private int startR, startC, endR, endC;

    public Maze(String filename){
	animate = false;
	try{
	    File name = new File(filename);
	    Scanner inf = new Scanner(name);

	    int rows = 0;
	    int cols = 0;
	    
	    while(inf.hasNextLine()){
		rows++;
		cols = inf.nextLine().length();
	    }
	    maze = new char[rows][cols];

	    int line = 0;
	    while(inf.hasNext()){
		String lines = inf.nextLine();

		int i = 0;
		while (i < lines.length()){
		    maze[line][i] = lines.charAt(i);
		    if(lines.charAt(i) == 'S') {
			start = true;
			startR = line;
			startC = i;
		    }
		    if(lines.charAt(i) == 'E'){
			end = true;
			endR = line;
			endC = i;
		    }
		    i++;
		}
		line++;
	    }
	    System.out.println(startR + "," + startC);
	}
	catch (FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(0);
	}
	if (start == false || end == false){
	    System.out.println("Missing start or end");
	    System.exit(0);
	}
    }    

    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    
    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
	maze[startR][startC] = ' ';//erase the S, and start solving!
	return solve(startR,startC);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
	if (maze[row][col] == 'E')
	    return true;
	if (maze[row][col] == ' '){
	    maze[row][col] = '@';
	    if (solve(row, col + 1) ||
		solve(row, col - 1) ||
		solve(row + 1, col) ||
		solve(row - 1, col)) {
		return true;
	    }else{
		maze[row][col] = '.';
	    }
	}
	//COMPLETE SOLVE
        return false; //so it compiles
    }
    public String toString(){
	String s = "";
	for(int i = 0; i < maze.length; i++){
	    for(int j = 0; j < maze[i].length; j++){
		s += maze[i][j];
	    }
	    s += "\n";
	}
	return s;
    }
}

