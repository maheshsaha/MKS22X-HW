import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;
    private boolean start, end;
    private int startR, startC, endR, endC;

    public Maze(String filename){ //ty Alan for help
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
	    inf = new Scanner(name);
	    while(inf.hasNext()){
		String lines = inf.nextLine();

		for(int i = 0; i < lines.length(); i ++){
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
		}
		line++;
	    }
	    if (start == false || end == false){
		System.out.println("Missing start or end");
		System.exit(0);
	    }
	}
	catch (FileNotFoundException e){
	    System.out.println("File not found");
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


    public boolean solve(){
	maze[startR][startC] = ' ';//erase the S, and start solving!
	return solve(startR,startC);
    }

    
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

