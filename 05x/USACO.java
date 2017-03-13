import java.util.*;
import java.io.*;

public class USACO{

    //bronze vars
    private int R, C, E, N;
    private int [][] land;
    //silv vars
    private int Nn, M, T, R1, C1, R2, C2;
    private int [][] past;
    private int [][] current;

    
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
	    
	    for (int x = 0; x < N; x++){
		inf.nextLine();
		
		cowStomp(Integer.parseInt(inf.next()),
			 Integer.parseInt(inf.next()),
			 Integer.parseInt(inf.next()));
		
	
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

	int locationr = r;
	int locationc = c;
	int max = land[r][c];
	for (int i = 0; i < 3; i++){
	    for (int j = 0; j < 3; j++){
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
	depthAnalyze();
	int sum = 0;
	for(int i = 0; i < land.length; i++){
	    for(int j = 0; j < land[i].length; j++){
		sum += land[i][j];
	    }
	}
	return sum * 72 * 72;
    }

    public int silver(String filename){
	try {
	    File x = new File(filename);
	    Scanner inf = new Scanner(x);
	    
	    if (inf.hasNextLine()){
		Nn = inf.nextInt();
		M  = inf.nextInt();
		T  = inf.nextInt();
	    }

	    past    = new int[Nn][M];
	    current = new int[Nn][M];

	    for (int i = 0; i < Nn; i ++){
		
	    	String r = inf.next();
		
	    	for (int j = 0; j < M; j ++){
	    	    if (r.charAt(j) == '*'){
	    		past[i][j] = -1;
	    		current[i][j] = -1;
	    	    }
		    else{
	    		past[i][j] = 0;
	    		current[i][j] = 0;
	    	    }
	    	}
	        
	    }
	    
	    if (inf.hasNextLine()){
		
		R1 = inf.nextInt() - 1;
		C1 = inf.nextInt() - 1;
		R2 = inf.nextInt() - 1;
		C2 = inf.nextInt() - 1;
	    }    
    	}
	catch (FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(0);
	}
	
	return cowCulate(R1, C1, R2, C2);
	
    }

    private int cowCulate(int r1, int c1, int r2, int c2){
	past[r1][c1] = 1;
	current[r2][c2] = 1;
	
        for (int x = T; x > 0; x --){
	    for (int r = 0; r < Nn; r ++){
		for (int c = 0; c < M; c ++){
		    if (past[r][c] != -1){
			current[r][c] = 0;
			if ((r + 1) < Nn && past[r + 1][c] != -1){
			    current[r][c] += past[r + 1][c    ];
			}
			if ((r - 1) >= 0 && past[r - 1][c] != -1){
			    current[r][c] += past[r - 1][c    ];
			}
			if ((c + 1) <  M && past[r][c + 1] != -1){
			    current[r][c] += past[r    ][c + 1];
			}
			if ((c - 1) >= 0 && past[r][c - 1] != -1){
			    current[r][c] += past[r    ][c - 1];
			}
		    }
		}
	    }
	    for (int i = 0; i < Nn; i ++){
		for (int j = 0; j < M; j ++){
		    past[i][j] = current[i][j];
		}
	    }
	}
	
	return past[r2][c2];
    }

    public String printarr(int[][]lol){
	String x = "";
	for(int i = 0; i < lol.length; i++){
	    for(int j = 0; j < lol[i].length; j++){
		if (lol[i][j] < 0)
		    x += " " + lol[i][j] + " ";
		else if (lol[i][j] < 10)
		    x += "  "+ lol[i][j]+" ";
		else if (lol[i][j] < 100)
		    x += " " + lol[i][j] + " ";
		else
		    x += lol[i][j] + " ";
	    }
	    x+= "\n";
	}
	return x;
    }

}
			    
			
	    
	      
	    
	

		
     
    
