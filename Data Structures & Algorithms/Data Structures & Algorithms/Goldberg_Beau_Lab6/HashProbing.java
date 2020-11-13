import java.util.Arrays;
import java.util.Random;

public class HashProbing {
	
	static int[] array, probecost;
	static int size;
	static Random random;
	static int numprobes;
	
	public HashProbing(int N) 
	{
		array = new int[N];
		this.size = N;
	}
	
	public static void main(String[] args) 
    { 
		random = new Random();
		HashProbing hash = new HashProbing(1000000);
		probecost = new int[size/4];
		int i=0;
		while(i<size/2)
		{
		int index = random.nextInt(size);
		System.out.println(index);
		if(array[index] == 0)
		{
			array[index] = index;
		}
		else
		{
			int number = index;
			int probecostnum = 0;
			int j=0;
			while(array[index] != 0)
			{
				if(index+1 >= size)
				{
					index=0;
				}
				else
				{
				probecostnum++;
				index++;
				}
			}
			array[index] = number;
			probecost[j] = probecostnum;
			j++;
			numprobes = j;
		}
		i++;
		}
		int totalprobes =0;
		for(int m=0;m<numprobes;m++)
		{
			totalprobes = totalprobes + probecost[m];
		}
		System.out.println("Average Probes: " + totalprobes/numprobes);
    }
}
