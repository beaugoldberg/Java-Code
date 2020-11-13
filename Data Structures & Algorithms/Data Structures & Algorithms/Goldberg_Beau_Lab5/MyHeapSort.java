import java.util.Random;
import edu.princeton.cs.algs4.Heap;

public class MyHeapSort {

	Random random = new Random();
	Comparable[] array;
	Stopwatch stopwatch;
	
	public MyHeapSort(int N) 
	{
		stopwatch = new Stopwatch();
		array = new Comparable[N];
		for(int i=0;i<N;i++)
		{
			int num = random.nextInt(100);
			array[i] = num; 
		}
		Heap.sort(array);
		double time = stopwatch.elapsedTime();
		System.out.println(time);
	}

	public static void main(String[] args) 
	{
		MyHeapSort heap = new MyHeapSort(10*10*10*10*10*10);
	}
}
