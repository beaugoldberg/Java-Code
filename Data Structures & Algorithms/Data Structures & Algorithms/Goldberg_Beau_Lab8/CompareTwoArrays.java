import java.util.Hashtable;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SeparateChainingHashST;


public class CompareTwoArrays
{
  

    private static boolean compareWithHeap (In inA, In inB, int size) {
        
        boolean match = false;
        Comparable[] A = new Comparable[size];
        Comparable [] B = new Comparable[size];
        int count = 0;
        
        while (!inA.isEmpty()) {
            int itemA = inA.readInt();
            int itemB = inB.readInt();
            A[count] = itemA;
            B[count] = itemB;
            count++;
        }
        Heap.sort(A);
        Heap.sort(B);
        for(int i = 0; i< size; i++)
        {
        	if(!A[i].equals(B[i])) return match;
        }   
        match = true;
        return match;
    }
    
    private static boolean compareWithHash (In inA, In inB, int size) {
        
    	SeparateChainingHashST<Integer,Integer> table = new SeparateChainingHashST<Integer,Integer>(size);
        boolean match = false;
        while (!inA.isEmpty()) {
            int item = inA.readInt();
        	if(table.contains(item))
        	{
        		int temp = (int) table.get(item);
        		temp +=1;
        		table.put(item, temp);
        	}
        	if(!table.contains(item))
        	{
        		table.put(item, 1);
        	}
        }
        while (!inB.isEmpty())
        {
        	int item = inB.readInt();
        	if(!table.contains(item)) return match;
        	if(table.contains(item))
        	{
        		int temp = (int) table.get(item);
        		temp -=1;
        		if(temp < 0) return match;
        		table.put(item, temp);
        	}
        }
        Iterable<Integer> keys = table.keys();
    	for(int key : keys)
    	{
    		if((int)table.get(key) != 0) return match;
    	}
    	match = true;
        
        return match;
    }
    
    public static void main(String[] args) {
        
        if (args.length < 3) {
            StdOut.println("Usage: java-algs4 CompareTwoArrays filenameA filenameB [heap/hash]");
            System.exit(1);
        }
        String filenameA = args[0];
        String filenameB = args[1];
        String method    = args[2];
        
        if ( !method.equals("heap") && !method.equals("hash") ) {
            StdOut.println("Usage: java-algs4 CompareTwoArrays filenameA filenameB [heap/hash]");
            System.exit(1);
        }
        
        In inA = new In(filenameA);
        int nA = inA.readInt();

        In inB = new In(filenameB);
        int nB = inB.readInt();

        if (nA != nB) {
            StdOut.println("Arrays are not the same size, so not equivalent");
            System.exit(0);
        }
        
        boolean match = false;
        
        StopwatchCPU sw = new StopwatchCPU();
        if (method.equals("heap")) {
            match = compareWithHeap(inA, inB, nA);
        } else {
            match = compareWithHash(inA, inB, nA);
        }
        
        
        double elapsed = sw.elapsedTime();
        
        
        StdOut.println("The two input arrays do " + (match?"":"not ") + "match" );
        StdOut.println("elapsed time: " + elapsed + " seconds");
        
    }

   
}

