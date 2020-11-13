import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
//** = API is correct
public class WordNet {

	Digraph graph;
	RedBlackBST<String, Bag<Integer>> tree;
	ShortestCommonAncestor sca;
	String[] keys;
	int size;
	
   // ** constructor takes the name of the two input files
   public WordNet(String synsets, String hypernyms) throws FileNotFoundException
   {
		if ((synsets == null) || (hypernyms == null)) throw new NullPointerException("Files are empty");
		//--------------------------------------------------------------------
		//Read in synsets into the RedBlack BST and hypernyms into the digraph
		//--------------------------------------------------------------------
		tree = new RedBlackBST<String,Bag<Integer>>();
		File synset = new File(synsets);
		File hypernym = new File(hypernyms);
		Scanner scanS = new Scanner(synset);
		Scanner scanH = new Scanner(hypernym);
		
		int vertices = 0;
		while(scanS.hasNextLine())
		{
			vertices++;
			Scanner linescan2 = new Scanner(scanS.nextLine());
			linescan2.useDelimiter(",");
			int value = linescan2.nextInt();
			String key = linescan2.next();
			Scanner spacescan = new Scanner(key);
			while(spacescan.hasNext())
			{
				String key1 = spacescan.next();
				if(!tree.contains(key1))
				{
					tree.put(key1, new Bag<>());
					tree.get(key1).add(value);
				}
				else
				{
					tree.get(key1).add(value);
				}
			}
			spacescan.close();
			linescan2.close();
		}
		graph = new Digraph(vertices);
		while(scanH.hasNextLine())
		{
			Scanner linescan = new Scanner(scanH.nextLine());
			linescan.useDelimiter(",");
			int v = linescan.nextInt();
			while(linescan.hasNext())
			{
				graph.addEdge(v, linescan.nextInt());
			}
			linescan.close();
		}
		scanS.close();
		scanH.close();
		//----------------------------------------------------------------------------------
		//Check if graph is a rooted DAG
		//----------------------------------------------------------------------------------
		DirectedCycle cycle = new DirectedCycle(graph);
		if (cycle.hasCycle()) throw new IllegalArgumentException("Graph contains a cycle");
		
		int root = 0;
		for (int i = 0;i < graph.V();i++)
		{
			if(!graph.adj(i).iterator().hasNext()) root++;
		}
		if (root != 1) throw new IllegalArgumentException("Graph is not rooted");
		//-------------------------------------------------------------------------------------
		//If graph is a rooted DAG then we can create a ShortestCommonAncestor instance
		//-------------------------------------------------------------------------------------
		sca = new ShortestCommonAncestor(graph);
		//--------------------------------------------------------------------------------------
		//Read in synsets again into an array in order to traverse key to value and value to key
		//--------------------------------------------------------------------------------------
		keys = new String[vertices];
		Scanner keyscan = new Scanner(synset);
		while(keyscan.hasNextLine())
		{
			Scanner linescan = new Scanner(keyscan.nextLine());
			linescan.useDelimiter(",");
			int index = linescan.nextInt();
			String key = linescan.next();
			keys[index] = key;		
			linescan.close();
		}
		keyscan.close();
		//---------------------------------------------------------------------------------------
   }

   // ** all WordNet nouns
   public Iterable<String> nouns()
   {
	   return tree.keys();
   }

   // ** is the word a WordNet noun?
   public boolean isNoun(String word)
   {
	   if (word == null) throw new NullPointerException("entry is null");
	   return tree.contains(word);  
   }

   // ** return a synset (second field of synsets.txt) that is a shortest common ancestor
   // ** of noun1 and noun2 (defined below)
   public String sca(String noun1, String noun2) 
   {		  
	   if (noun1 == null || noun2 == null) throw new NullPointerException("at least one of the entries is null");
	   if (!isNoun(noun1) || !isNoun(noun2)) throw new IllegalArgumentException("the entries are not wordnet nouns");
	   Bag<Integer> it = tree.get(noun1);
	   Bag<Integer> it2 = tree.get(noun2);
	   int index = sca.ancestor(it, it2);
	   return keys[index];

   }

   // ** distance between noun1 and noun2 (defined below)
   public int distance(String noun1, String noun2) 
   {	 
	   if (noun1 == null || noun2 == null) throw new NullPointerException("at least one of the entries is null");
	   if (!isNoun(noun1) || !isNoun(noun2)) throw new IllegalArgumentException("the entries are not wordnet nouns");
	   Bag<Integer> it = tree.get(noun1);
	   Bag<Integer> it2 = tree.get(noun2);
	   return sca.length(it, it2);
   }

   // do unit testing of this class
   public static void main(String[] args) throws FileNotFoundException
   {
	   WordNet wordnet = new WordNet("synsets.txt","hypernyms.txt");
	   System.out.println("Ancestor: " + wordnet.sca("miracle", "demotion"));
	   System.out.println("Distance: " + wordnet.distance("miracle", "demotion"));
	  
   }
}