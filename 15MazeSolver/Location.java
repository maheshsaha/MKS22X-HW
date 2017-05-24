public class Location implements Comparable<Location>{
    
    private int row;
    private int col;
    private Location previous;
    private boolean aStar;
    private int distanceToStart;
    private int distanceToGoal;

    public Location(int r, int c, Location prev, int distToStart, int distToGoal, boolean astar){
	row = r;
	col = c;
	previous = prev;
	distanceToStart = distToStart;
	distanceToGoal = distToGoal;
	aStar = astar;
    }

    public int getRow(){
	return row;
    }

    public int getCol(){
	return col;
    }

    public int getStartDist(){
	return distanceToStart;
    }

    public int getGoalDist(){
	return distanceToGoal;
    }
    
    public Location getPrev(){
	return previous;
    }

    public boolean getStar(){
	return aStar;
    }

    public int getPrevRow() {
        return previous.getRow();
    }

    public int getPrevCol() {
        return previous.getCol();
    }

    public boolean hasPrev() {
        return previous != null;
    }
    
    public int compareTo(Location other){
	int x = getGoalDist();
	int y = other.getGoalDist();
	if (aStar){
	    x += getStartDist();
	    y += other.getStartDist();
	}
	return x -  y;
    }

}

