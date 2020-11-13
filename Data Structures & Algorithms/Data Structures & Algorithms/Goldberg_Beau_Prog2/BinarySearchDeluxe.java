import java.util.Arrays;
import java.util.Comparator;

public class BinarySearchDeluxe {

	// Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
	public static <Key> int firstIndexof(Key[] a, Key key, Comparator<Key> comparator) 
	{
		if(key.equals(null)) throw new NullPointerException("Key can't be null");
		int lo = 0;
		int hi = a.length-1;
		int index=0;
		while (lo <= hi)
		{
			int mid = lo + (hi-lo)/2;
			if (comparator.compare(key,a[mid]) <= -1) hi = mid-1; 
			else if (comparator.compare(key,a[mid]) >= 1) lo = mid+1;
			else if (mid-1 >= 0 && (comparator.compare(key, a[mid]) == 0))
			{
				int i=1;
				while(i !=0)
				{
					if(mid-i >=0 && comparator.compare(key, a[mid-i]) == 0) i++;
					else 
					{
						int left = i-1;
						i=0;
						index = (mid-left); 
						return index;
					}
				}
			}
			else return index;
		}return -1;
	}
	
    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
	public static <Key> int lastIndexof(Key[] a, Key key, Comparator<Key> comparator) 
	{
		if(key.equals(null)) throw new NullPointerException("Key can't be null");
		int lo = 0;
		int hi = a.length-1;
		int index =0;
		while (lo <= hi)
		{
			int mid = lo + (hi-lo)/2;
			if (comparator.compare(key,a[mid]) <= -1)hi = mid-1;
			else if (comparator.compare(key,a[mid]) >= 1)lo = mid+1;
			else if (mid+1 < a.length && (comparator.compare(key, a[mid]) == 0))
			{
				int i=1;
				while(i !=0)
				{
					if(mid+i < a.length && comparator.compare(key, a[mid+i]) == 0) i++;
					else 
					{
						int right = i-1;
						i=0;
						index = (mid+right); 
						return index;
					}
				}
			}
			else return index;
		}return -1;
	}
	
	// unit testing (you should have some Unit Testing here to confirm that your methods work)
	public static void main(String[] args)
	{
		Term[] term = new Term[9];
		term[0] = new Term("Trevor", 45);
		term[1] = new Term("Aberton", 43);
		term[2] = new Term("John", 39);
		term[3] = new Term("Brad", 48);
		term[4] = new Term("Brampton", 41);
		term[5] = new Term("Aber", 41);
		term[6] = new Term("Steve", 41);
		term[7] = new Term("Johnathan", 41);
		term[8] = new Term("Trahley", 41);
		
		Arrays.sort(term);
		for(int i=0;i<term.length;i++)
		{
			System.out.println(term[i]);
		}
		String thing = "A";
		Term tip = new Term(thing,0);
		int lastindex = BinarySearchDeluxe.lastIndexof(term, tip, Term.byPrefixOrder(thing.length()));
		int firstindex = BinarySearchDeluxe.firstIndexof(term, tip, Term.byPrefixOrder(thing.length()));
		System.out.println(lastindex);
		System.out.println(firstindex);
		Term[] searched;
		if (lastindex == -1 || firstindex == -1)
		{
			System.out.println("No Matches");
		}
		else
		{
		if(lastindex == firstindex)
		{
			searched = new Term[1];
			searched[0]= term[firstindex];
		}
		else
		{
			searched = new Term[lastindex+1-firstindex];
			for(int i=0; firstindex != lastindex+1;i++)
			{
				searched[i] = term[firstindex];
				firstindex++;
			}
		}
		
		Arrays.sort(searched, Term.byReverseWeightOrder());
		for(int i=0;i<searched.length;i++)
		{
			System.out.println(searched[i]);
		}
		}
	}
}
