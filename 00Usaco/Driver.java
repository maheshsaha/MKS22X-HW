public class Driver{
    public static void main(String[]args){
	LakeMaking g = new LakeMaking("data1.dat");
	g.depthAnalyze();
	//	System.out.println(g.blah());
	System.out.println(g.volumeCalc());
    }
}
