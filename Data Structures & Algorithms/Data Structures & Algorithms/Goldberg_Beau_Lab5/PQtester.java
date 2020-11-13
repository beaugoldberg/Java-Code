import java.util.Random;
import edu.princeton.cs.algs4.MaxPQ;

public class PQtester {

	MaxPQ pq;
	Random random;
	Stopwatch stopwatch;
	double timeelapsed;

	public PQtester(int N) {
		pq = new MaxPQ();
		random = new Random();
		stopwatch = new Stopwatch();
		for(int i=0; i<N; i++)
		{
			int num = random.nextInt(100);
			pq.insert(num);
		}
		int size = pq.size();
		while (pq.size() > size/2)
		{
			pq.delMax();
		}
		for (int i=0; i<N/2;i++)
		{
			int num = random.nextInt(100);
			pq.insert(num);
		}
		while(pq.size()>0)
		{
			pq.delMax();
		}
		timeelapsed = stopwatch.elapsedTime();
//		System.out.println(timeelapsed);
	}
	
	public static void main(String[] args) 
	{
		int n=1000;
		for(int j=0;j<5;j++)
		{
		double time = 0;
		System.out.println("Test " + (j+1) + ": N=" + n);
		for(int i=0;i<4;i++)
		{
			PQtester test = new PQtester(n);
			time = time + test.timeelapsed;
		}
		double timeavg = time/4;
		System.out.println("Average Time: " + timeavg + "\n");
		n=n*10;
		}
	}
	
	}


