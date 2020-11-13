import java.util.Arrays;

public class AutoComplete {

	Term[] term, searched;
	int firstindex, lastindex;
	
	//Initializes the data structure from the given array of terms
	public AutoComplete(Term[] terms) 
	{
		term=terms;
		Arrays.sort(term);
	}

	// Returns all terms that start with the given prefix, in descending order of weight.
	public Term[] allMatches(String prefix)
	{
		if(prefix.equals(null)) throw new NullPointerException("String can't be equal to null");
		Term main = new Term(prefix,0);
		lastindex = BinarySearchDeluxe.lastIndexof(term, main, Term.byPrefixOrder(prefix.length()));
		firstindex = BinarySearchDeluxe.firstIndexof(term, main, Term.byPrefixOrder(prefix.length()));

		searched = new Term[lastindex+1-firstindex];
		int pointer = 0;
		for(int i=firstindex; i <= lastindex; i++)
		{
				searched[pointer] = term[i];
				pointer++;
		}
		Arrays.sort(searched, Term.byReverseWeightOrder());
		return searched;
	}
	
	// Returns the number of terms that start with the given prefix.
	public int NumberofMatches(String Prefix)
	{
		int NumMatches = lastindex - firstindex;
		return NumMatches;
	}
	
	public static void main(String[] args)
	{
	    // read in the terms from a file
	    String filename = args[0];
	    In in = new In(filename);
	    int N = in.readInt();
	    Term[] terms = new Term[N];
	    for (int i = 0; i < N; i++) 
	    {
	        long weight = in.readLong();           // read the next weight
	        in.readChar();                         // scan past the tab
	        String query = in.readLine();          // read the next query
	        terms[i] = new Term(query, weight);    // construct the term
	    }
	    int k = Integer.parseInt(args[1]);
	    AutoComplete autocomplete = new AutoComplete(terms);
	    while (StdIn.hasNextLine()) {
	    	try
	    	{
	        String prefix = StdIn.readLine();
	        Term[] results = autocomplete.allMatches(prefix);
	        for (int i = 0; i < Math.min(k, results.length); i++)
	            StdOut.println(results[i]);
	    	}
	    	catch(ArrayIndexOutOfBoundsException e)
	    	{
	    		System.out.println("No matches, please enter another term");
	    	}
	    }
	}
}
