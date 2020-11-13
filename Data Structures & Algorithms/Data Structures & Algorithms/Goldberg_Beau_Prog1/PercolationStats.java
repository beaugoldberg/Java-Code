import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class PercolationStats {

	StdRandom random;
	static StdStats stats;
	static double[] percentstats;
	static double mean;
	double stddev;
	int loops;
	
	// Perform T independent experiments
	// Constructor would throw IllegalArgumentExcpetion if N<or=0 or T<or=0
	public PercolationStats(int N, int T) throws IllegalArgumentException
	{
		int i=0;
		int k=0;
		percentstats = new double[T];
		double efficiency = 0;
		this.loops = T;
		
		for(i=0;i<T;i++)
		{
		Percolation perc = new Percolation(N);				
		while (!perc.percolates())
		{
		perc.open(random.uniform(N), random.uniform(N));
		}
		efficiency = perc.numberofOpenSites()/(double)(N*N);
		percentstats[k] = efficiency;
		k++;
		}
		
	}
	
	//sample mean of the percolation threshold
	public double mean()
	{
		mean = stats.mean(percentstats);
		return mean;		
	}
	
	//sample standard deviation of percolation threshold
	public double stddev()
	{
		stddev = stats.stddev(percentstats);
		return stddev; 
	}
	
	// low endpoint of 95% confidence 
	public double confidenceLow()
	{
		return (mean - (1.96*stddev)/Math.sqrt(loops));
		
	}
	
	//high endpoint of 95% confidence 
	public double confidenceHigh()
	{
		return (mean + (1.96*stddev)/Math.sqrt(loops));
		
	}
	
	public static void main(String[] args)
	{
		Stopwatch clock = new Stopwatch();
		PercolationStats program = new PercolationStats(50,3200);
		System.out.println("Time: " + clock.elapsedTime());
		System.out.println("Mean: " + program.mean());
		System.out.println("Stddev: " + program.stddev());
		System.out.println("Confidence Low: " + program.confidenceLow());
		System.out.println("Confidence High: " + program.confidenceHigh());
		
	}
	
	
}
