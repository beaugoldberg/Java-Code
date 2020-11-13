import java.util.Iterator;
import java.util.NoSuchElementException;

public class Dequeue<Item> implements Iterable<Item> {
	    private int n;         // number of elements on queue
	    private Node first;    // beginning of queue
	    private Node last;     // end of queue

	    // helper linked list class
	    private class Node {
	        private Item item;
	        private Node next;
	        private Node previous;
	    }

	    public Dequeue() {
	       first = null;
	       last = null;
	       n=0;
	    }

	    public boolean isEmpty() {
	       return n==0;
	    }

	    public int size() {
	       return n;
	    }
	    
	    public void addFirst(Item item) {
	    	if (item == null) throw new NullPointerException("Cant add a null object");
	    	Node newfirst = new Node();
	    	newfirst.item = item;
	    	if(isEmpty())
	    	{
	    		first = newfirst;
	    		last = first;
	    		first.next = last;
	    		last.previous=first;
	    		n++;
	    	}
	    	else 
	    	{
	    		newfirst.next = first;
	    		first.previous = newfirst;
	    		first = newfirst;
	    		n++;
	    	}
	    }

	    public void addLast(Item item) {
	    	if (item == null) throw new NullPointerException("Cant add a null object");
	    	Node temp = new Node();
	    	temp.item = item;
	    	if (last == null)
	    	{
	    		last = temp; 
	    		first = temp;
	    		first.next = last;
	    		last.previous=first;
	    		n++;
	    	}
	    	else
	    	{
	    		temp.previous=last;
	    		last.next = temp;
	    		last = temp;
	    		n++;
	    	}
	    }

	    public Item removeFirst() {
	        if (isEmpty()) throw new NoSuchElementException("Queue is Empty");
	        Item item = first.item;
	        first = first.next;
	        first.previous = null;
	        n--;
	        return item;
	    }
	    
	    public Item removeLast() {
	    	if (isEmpty()) throw new NoSuchElementException("Queue is Empty");
	    	Item item = last.item;
	    	last = last.previous;
	    	n--;
	    	return item;
	    }

		@Override
		public Iterator<Item> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
		  public static void main(String[] args) {
		        
		        Dequeue<String> d = new Dequeue<String>();
		        
		        d.addLast("I");
		        d.addLast("once");
		        d.addLast("danced");
		        StdOut.print( d.removeFirst() + " ");
		        d.addFirst("upon");
		        d.addFirst("a");
		        d.addFirst("dream");
		        d.addFirst("with");
		        StdOut.print( d.removeLast() + " ");
		        d.addLast("you");
		        StdOut.print( d.removeFirst() + " ");
		        while (!d.isEmpty()) {
		           StdOut.print( d.removeLast() + " ");
		        }
		    }
}

