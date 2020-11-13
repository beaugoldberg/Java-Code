import java.util.ArrayList;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;
//** = API is correct
public class ShortestCommonAncestor {

	Digraph graph;
	ArrayList<Integer> indexes;
	static int length, lengthV, lengthW;
	
   // ** constructor takes a rooted DAG as argument
   public ShortestCommonAncestor(Digraph G)
   {
	   if (G == null) throw new NullPointerException("Graph is empty");
	   this.graph = G;
   }

   // ** length of shortest ancestral path between v and w
   public int length(int v, int w)
   {
	   if (!((v >= 0 && v < this.graph.V()) && (w >= 0 && w < this.graph.V()))) 
	   {
		   throw new IndexOutOfBoundsException("entries are not in the graph's range of vertexes");
	   }
	   lengthV = getLength(w,v);
	   lengthW = getLength(v,w);
	   length = lengthW + lengthV;
	   return length;
   }

   // ** a shortest common ancestor of vertices v and w
   public int ancestor(int v, int w)
   {
	   if (!((v >= 0 && v <= this.graph.V()-1) && (w >= 0 && w <= this.graph.V()-1)))
	   {
		   throw new IndexOutOfBoundsException("entries are not in the graph's range of vertexes");
	   }
	   //Perform a modified breadth first search using an arraylist to store all vertices that are visited during the search
	   //-------------------------------------------------------------------------------------------------------------------
	   indexes = new ArrayList<Integer>();
	   Queue<Integer> queue = new Queue<Integer>();
	   queue.enqueue(v);
	   while (!queue.isEmpty()) {
	       int currentnode = queue.dequeue();
	       indexes.add(currentnode);
	       for (int adjnodes : graph.adj(currentnode)) {
	      	 	if(!indexes.contains(adjnodes))
	      	 	{
	       	 	   queue.enqueue(adjnodes);
	       	 	}
            } 
	     }
	     //------------------------------------------------------------------------------------------------------
	     //Check if the second entry is in the arraylist because if it is then it is the shortest common ancestor
	     //------------------------------------------------------------------------------------------------------
	     if(indexes.contains(w)) return w;
	     //------------------------------------------------------------------------------------------------------
	     //If second entry is not in arraylist, begin modified breadth first search again this time checking if
	     //each visited index is in the arraylist. The first one that is in the arraylist will be the ancestor
	     //------------------------------------------------------------------------------------------------------
	   	 queue.enqueue(w);
	   	 while(!queue.isEmpty()) {
	   		 int currentnode = queue.dequeue();
	   		 for (int adjnodes : graph.adj(currentnode)) {
	   			 queue.enqueue(adjnodes);
	   			 if (indexes.contains(adjnodes)) {
	   				 return adjnodes;
	   			 }
	   		 }
	   	 }
	   	 return -1;
	   	 //-----------------------------------------------------------------------------------------------------------------
   }
   
   private int getLength(int v, int w) 
   {
	     if (!((v >= 0 && v < this.graph.V()) && (w >= 0 && w < this.graph.V()))) 
	     {
		     throw new IndexOutOfBoundsException("entries are not in the graph's range of vertexes");
	     }
	     //-----------------------------------------------------------------------------------------------------------------
	     //Perform modified BFS again but this time return the length off second node to the ancestor.
	     //In the length method it will sway v & w to get the length of the first node to ancestor and
	     //then return the sum of the two to give the total distance.
	     //-----------------------------------------------------------------------------------------------------------------
		 int lengthW = 0;
		 indexes = new ArrayList<Integer>();
		 Queue<Integer> queue = new Queue<Integer>();
	     queue.enqueue(v);
	     while (!queue.isEmpty()) {
	         int currentnode = queue.dequeue();
	         indexes.add(currentnode);
	         for (int adjnodes : graph.adj(currentnode)) {
	        	 	if(!indexes.contains(adjnodes)) {
	        	 	   queue.enqueue(adjnodes);
	        	 	}
	           } 
	     }   
	     queue.enqueue(w);
	 	 while(!queue.isEmpty()) {
	   		 int currentnode = queue.dequeue();
	   		 for (int adjnodes : graph.adj(currentnode)) {
	   			 queue.enqueue(adjnodes);
	   			 lengthW++;
	   			 if (indexes.contains(adjnodes)) {
	   				 if(v==adjnodes) {
	   					 return lengthW-1;
	   				 }
	   				 return lengthW;
	   			 }
	   		 }
	   	 }
	   	 return 1;
	   	 //-----------------------------------------------------------------------------------------------------------------
   }

   // ** length of shortest ancestral path of vertex subsets A and B
   public int length(Iterable<Integer> subsetA, Iterable<Integer> subsetB) 
    {
	   //-----------------------------------------------------------
	   //Check if all vertices in the two subsets are valid integers
	   //-----------------------------------------------------------
	   for(Integer num : subsetA)
	   {
		   if(!((num >= 0 && num < this.graph.V()))) throw new IndexOutOfBoundsException("A vertex in subsetA is not in the graph");
	   }
	   for(Integer num : subsetB)
	   {
		   if(!((num >= 0 && num < this.graph.V()))) throw new IndexOutOfBoundsException("A vertex in subsetB is not in the graph");
	   }
	   //--------------------------------------------------------------------------------------------------------
	   //Loop through the subset of integers keeping tabs on the shortest length between two points in the subset
	   //--------------------------------------------------------------------------------------------------------
	   int length =0;
	   for(Integer A : subsetA)
	   {
		   for(Integer B : subsetB)
		   {
			   if(length==0) length = length(A,B);
			   if(length(A,B) < length) length = length(A,B);
		   }
	   }
	   return length;
	   //--------------------------------------------------------------------------------------------------------
	}

   // ** a shortest common ancestor of vertex subsets A and B
   public int ancestor(Iterable<Integer> subsetA, Iterable<Integer> subsetB)
   {
	   //-----------------------------------------------------------
	   //Check if all vertices in the two subsets are valid integers
	   //-----------------------------------------------------------
	   for(Integer num : subsetA)
	   {
		   if(!((num >= 0 && num < this.graph.V()))) throw new IndexOutOfBoundsException("A vertex in subsetA is not in the graph");
	   }
	   for(Integer num : subsetB)
	   {
		   if(!((num >= 0 && num < this.graph.V()))) throw new IndexOutOfBoundsException("A vertex in subsetB is not in the graph");
	   }
	   //-------------------------------------------------------------------------------------------
	   //Loop through the subsets keeping tabs on the shortest length and the corresponding ancestor
	   //-------------------------------------------------------------------------------------------
	   int length = 0;
	   int ancestor = 0;
	   for(Integer A : subsetA)
	   {
		   for(Integer B : subsetB)
		   {
			   if(length == 0) 
			   {
				   length = length(A,B);
				   ancestor = ancestor(A,B);
			   }
			   if(length(A,B) < length) 
			   {
				   length = length(A,B);
				   ancestor = ancestor(A,B);
			   }
		   }
	   }
	   return ancestor;
	   //-------------------------------------------------------------------------------------------  
    }

   // do unit testing of this class
   public static void main(String[] args)
   {
	   Digraph test = new Digraph(12);
	   test.addEdge(6, 3);
	   test.addEdge(7, 3);
	   test.addEdge(3, 1);
	   test.addEdge(4, 1);
	   test.addEdge(5, 1);
	   test.addEdge(8, 5);
	   test.addEdge(9, 5);
	   test.addEdge(10, 9);
	   test.addEdge(11, 9);
	   test.addEdge(1, 0);
	   test.addEdge(2, 0);
	   ShortestCommonAncestor sca = new ShortestCommonAncestor(test);
	   System.out.println("Ancestor: " + sca.ancestor(3, 10));
	   System.out.println("Length: " + sca.length(3, 10));
   }
}
