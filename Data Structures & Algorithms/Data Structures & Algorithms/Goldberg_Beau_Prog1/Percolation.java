import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.QuickFindUF;

public class Percolation {
	
	int[][] grid;
	int N;
	static WeightedQuickUnionUF UF;

	//create N-N grid with all sites
	public Percolation(int N) throws IllegalArgumentException
	{
		grid = new int[N][N];
		UF = new WeightedQuickUnionUF((N*N)+2);
		this.N = N;
	}
	
	//open the site, if it is a new site
	public void open(int row, int col) throws IndexOutOfBoundsException
	{
		int left = row-1;
		int right = row+1;
		int up = col-1;
		int down = col+1;
		int index = (col*N) + (row+1);
		
		if (grid[row][col] == 0)
		{
			grid[row][col] = 1;
		}
		//Series of if statements checking if nearby sites are open and connecting them if they are
		if (row == 0)
		{
			UF.union(index, 0);
		}
		if (row == N-1)
		{
			UF.union(index, N*N+1);
		}
		if (left >=0 && left < N)
		{
			if (grid[left][col] == 1)
			{
				UF.union(index, index-1);		
			}
		}
		if (right < N && right >=0)
		{
			if (grid[right][col] == 1)
			{
				UF.union(index, index + 1);		
			}
		}
		if (up >=0 && up < N)
		{
			if (grid[row][up] == 1)
			{
				UF.union(index, index - N);		
			}
		}
		if (down < N && down >=0)
		{
			if (grid[row][down] == 1)
			{
				UF.union(index, index + N);		
			}
		}
	}
	
	//is the site open?
	public boolean isOpen(int row, int col)
	{
		boolean check;
		if (grid[row][col] == 1)
		{
			check = true;
		}
		else
		{
			check = false;
		}
		return check;
	}
	
	//is the site full?
	//Need to figure out how to connect the top row to a point and bottom to a point for 
	//ease of checking if full. Need to set up exception for index out of bounds for when
	//checking if full.
	public boolean isFull(int row, int col)
	{
		int index = (col*N) + (row+1);
		return UF.connected(index, 0);
	}
	
	//number of open sites
	public int numberofOpenSites()
	{
		int i = 0;
		int j = 0;
		int opensites = 0;
		while (i < N)
		{
			if (isOpen(i,j))
			{
				opensites++;
			}
			if (j == N-1 && i == N-1)
			{
				i=N;
			}
			if(i == N-1)
			{
				i=0;
				j++;
			}
			i++;
		}
		return opensites;
	}
	
	//does the system percolate?
	//check if bottom point is full to check if the system percolates
	public boolean percolates()
	{
		return UF.connected((N*N)+1,0);
	}
	
	//unit testing
	public static void main(String[] args)
	{
		Percolation perc = new Percolation(3);
		System.out.println(perc.percolates());
	}
	
}
