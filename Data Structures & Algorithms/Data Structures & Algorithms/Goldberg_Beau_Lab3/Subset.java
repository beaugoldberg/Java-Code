
public class Subset {
	
	static int num;
	
	public static void Subset(int N)
	{
		String[] letter = StdIn.readStrings();
		RandomizedBag bag = new RandomizedBag();
		for (int i=0;i< letter.length;i++)
		{
			bag.put(letter[i]);
		}
		for (int i=0; i<N;i++)
		{
			System.out.println(bag.get());
		}
	}

	public static void main(String[] args) {
		
		Subset(Integer.parseInt(args[0]));
	}

}
