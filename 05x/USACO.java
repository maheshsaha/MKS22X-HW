import java.util.*;
import java.io.*;

public class USACO{
    
    private int R, C, E, N;
    private int [][] land;
    
    public USACO() {
    }

    public int bronze(String filename){
       	try{
	    File name = new File(filename);
	    Scanner inf = new Scanner(name);
	      
	    if(inf.hasNextLine()){
		R = Integer.parseInt(inf.next());
		C = Integer.parseInt(inf.next());
		E = Integer.parseInt(inf.next());
		N = Integer.parseInt(inf.next());
	    }
	    land = new int[R][C];

	    for (int i = 0; i < R; i++){
		inf.nextLine();
		for (int j = 0; j < C; j++){
		    land[i][j] = Integer.parseInt(inf.next());
		}
	    }
	    //   System.out.println(blah());
	    for (int x = 0; x < N; x++){
		inf.nextLine();
		// System.out.println(Integer.parseInt(inf.next()));
		// System.out.println(Integer.parseInt(inf.next()));
		cowStomp(Integer.parseInt(inf.next()),Integer.parseInt(inf.next()),Integer.parseInt(inf.next()));
		//	System.out.println(blah());
	
	    }
	}
	catch (FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(0);
	}
	return volumeCalc();
    }
    
    public String blah(){
	String x = "";
	for(int i = 0; i < land.length; i++){
	    for(int j = 0; j < land[i].length; j++){
		x += land[i][j]+" ";
	    }
	    x+= "\n";
	}
	return x;
    }


    public void cowStomp(int r, int c, int e){
	r = r-1;
	c = c-1;
	//	System.out.println(c);
	int locationr = r;
	int locationc = c;
	int max = land[r][c];
	for (int i = 0; i < 3; i++){
	    for (int j = 0; j < 3; j++){
		//	System.out.println(r+i);
		//	System.out.println(c+j);
		if (land[r+i][c+j] > max){

		    max = land[r+i][c+j];
		    locationr = r + i;
		    locationc = c + j;
		}
	    }
	}
	int newMax = max - e;
	for (int i = 0; i < 3; i++){
	    for (int j = 0; j < 3; j++){
		if (land[r+i][c+j] > newMax){
		    land[r+i][c+j] = newMax;
		}
	    }
	}
    }
    
    public void depthAnalyze(){
	//	System.out.println(E);
	for(int i = 0; i < land.length; i++){
	    for(int j = 0; j < land[i].length; j++){

		if (land[i][j] < E){
		    land[i][j] = E - land[i][j];
		}
		else{
		    land[i][j] = 0;
		}
	    }
	}
    }

    public int volumeCalc(){
	int sum = 0;
	for(int i = 0; i < land.length; i++){
	    for(int j = 0; j < land[i].length; j++){
		sum += land[i][j];
	    }
	}
	return sum * 72 * 72;
    }
}

	

		
     
    
