import java.util.Iterator;
import java.util.Random;

public class RandomizedBag<Item> implements Iterable<Item> {

	int items;
	Item[] bag;
	Item[] copy;
	Random random = new Random();
	
	public RandomizedBag()
	{
		bag=(Item[]) new Object[1];
		items=0;
	}
	
	public boolean isEmpty() 
	{
		boolean check;
		if (items ==0)
		{
			check = true;
		}
		else
		{
			check = false;
		}
		return check;
	}
	
	public int size()  
	{
		return items;
	}
	
	public void put(Item item)    
	{
		if (items == bag.length)
    	{
    		resize(items*2+1);
    	}
		bag[items] = item;
		items++;
	}
	
	public Item get()      
	{
		int itemindex = random.nextInt(items);  //Gets random index from 0 to Items Value
		Item item = bag[itemindex]; //Creates instance of the item to return
		bag[itemindex] = null;
		for (int i=0;i<items;i++)
		{
			if (bag[i] == null && bag[i+1] != null)
			{
				bag[i] = bag[i+1];
				bag[i+1] = null;
				
			}
		}
		items--;
		return item;
	}
	
	public Item sample() 
	{
		int randomindex = random.nextInt(items);
		Item item = bag[randomindex];
		return item;
	}
	
    private void resize(int capacity) {
        assert capacity >= items;
        
        String[] copy = new String[capacity];
        for (int i=0; i<items; i++)
        {
        	copy[i] = (String) bag[i];
        }
        bag = (Item[]) copy;
    }

	private class RandomBagIterator implements Iterator<Item>
	{

		@Override
		public boolean hasNext() 
		{
			boolean check;
			if (items>0)
			{
				check = true;
			}
			else
			{
				check = false;
			}
			return check;
		}

		@Override
		public Item next() {
			int itemindex = random.nextInt(items);  //Gets random index from 0 to Items Value
			Item item = bag[itemindex]; //Creates instance of the item to return
			bag[itemindex] = null;
			for (int i=0;i<items;i++)
			{
				if (bag[i] == null && bag[i+1] != null)
				{
					bag[i] = bag[i+1];
					bag[i+1] = null;
					
				}
			}
			items--;
			return item;	
		}
	}

	@Override
	public Iterator<Item> iterator() {
		 String[] copy = new String[bag.length];
	        for (int i=0; i<items; i++)
	        {
	        	copy[i] = (String) bag[i];
	        }
		RandomBagIterator iterator = new RandomBagIterator();
		return iterator;
	}
}