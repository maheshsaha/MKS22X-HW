import java.*;

public class LakeMaking{
    
    private int R, C, E, N;
    private int [][] land;

    public LakeMaking(String filename){
       	try{
	    File name = new File(filename);
	    Scanner inf = new Scanner(name);
	      
	    if(inf.hasNextLine()){
		R = inf.next();
		C = inf.next();
		E = inf.next();
		N = inf.next();
	    }
	    land = new int[R][C];

	    for (int i = 0; i < R; i++){
		inf.nextLine();
		for (int j = 0; j < C; j++){
		    land[i][j] = inf.next();
		}
	    }
	    
	    for (int x = 0; x < N; x++){
		inf.nextLine();
		cowStomp(inf.next(),inf.next(),inf.next());
	    }
	}
	catch (FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(0);
	}
    }
    
    private void cowStomp(int r, int c, int e){
	int locationr= r;
	int locationc = c;
	int max = land[r][c];
	for(int i=0; i<3; i++){
	    if(land[r+i][c] > max){
		max= land[r+i][c];
		locationr= r+i;
		locationc= c;
	    }
	    if(land[r][c+i] > max){
		max = land[r][c+i];
		locationr=r;
		locationc=c+i;
	    }
	}
	for(int y = 1; y < 3; y++){
	    if(land[r+y][c+y] > max){
		max= land[r+y][c+y];
		locationr= r+y;
		locationc= c+y;
	    }
	}
	if(land[r+1][c+2] > max){
	    max = land[r+1][c+2];
	    locationr=r+1;
	    locationc=c+2;
	}
	if(land[r+2][c+1] > max){
	    max = land[r+2][c+1];
	    locationr=r+2;
	    locationc=c+1;
	}
    }

	
     
    
