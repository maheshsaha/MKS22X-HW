public class RunningMedian{

    MyHeap max;
    MyHeap min;
    
    public RunningMedian(){
        min = new MyHeap(true);
	max = new MyHeap(false);
    }

    public void add(int a){
    	if (max.size == 0 && min.size == 0)
	    min.add(a);
        else if (a < getMedian())
    	    min.add(a);
    	else
    	    max.add(a);
	if (max.size > 1 + min.size)
    	    min.add(max.remove());
    	else if (min.size > 1 + max.size)
    	    max.add(min.remove());
    }
    

    public double getMedian(){
	if (max.size == min.size)
	    return (max.peek() + min.peek()) / 2.0;
	else if (max.size > min.size)
	    return 1.0 * max.peek();
	else
	    return 1.0 * min.peek();
    }
    public static void main(String[] args){
    }

}

