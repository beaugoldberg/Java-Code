import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term>{

	long weight;
	String query;
	
	 // Initializes a term with the given query string and weight.
	public Term(String query, long weight)
	{
		if(query.equals(null)) throw new NullPointerException("The query is empty");
		if(weight < 0) throw new IllegalArgumentException("The weight can't be negative");
		this.query = query;
		this.weight = weight;
	}
	
    // Compares the two terms in descending order by weight.
	public static Comparator<Term> byReverseWeightOrder() {
		return new Comparator<Term>() {
			public int compare(Term v, Term w) 
			{
				if(v.weight < w.weight) return 1;
				else if(v.weight > w.weight) return -1;
				else return 0;
			}
		};
	}
	
	// Compares the two terms in lexicographic order but using only the first r characters of each query.
	public static Comparator<Term> byPrefixOrder(int r) {
		return new Comparator<Term>() {
			public int compare(Term v, Term w)
			{
				if(r < 0) throw new IllegalArgumentException("The input length must be larger than zero");
				final int rr = r;
				int termlength = w.query.length();
				
				if(termlength >= rr)
				{
				if(v.query.compareTo(w.query.substring(0, rr)) <= -1) return -1;
				else if(v.query.compareTo(w.query.substring(0, rr)) >= 1) return 1;
				else return 0;
				}
				
				else
				{
					if(v.query.compareTo(w.query) <= -1) return -1;
					else if(v.query.compareTo(w.query) >= 1) return 1;
					else return 0;
				}
			}
		};
	}
	
	// Compares the two terms in lexicographic order by query.
	public int compareTo(Term that)
	{	
		Term term = new Term(query, weight);
		if (term.query.compareTo(that.query) <= -1) return -1;
		else if (term.query.compareTo(that.query) == 0) return 1;
		else if (term.query.compareTo(that.query) >= 1) return 1;
		else return -1;
	}
	
    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
	public String toString()
	{		
		return this.weight + "\t" + this.query;
	}
	
	// unit testing (you should have some Unit Testing here to confirm that your methods work)
	public static void main(String[] args)
	{
		Term[] term = new Term[5];
		term[0] = new Term("Trevor", 45);
		term[1] = new Term("Charles", 43);
		term[2] = new Term("John", 39);
		term[3] = new Term("Brad", 48);
		term[4] = new Term("Chad", 41);

		Arrays.sort(term, Term.byReverseWeightOrder());
		for (Term t:term)
		{
			System.out.println(t);
		}
		
		StdOut.println("");
		Arrays.sort(term, Term.byPrefixOrder(1));
		for (Term t:term)
		{
			System.out.println(t);
		}
	}
}
