import java.io.FileNotFoundException;
//** = API is correct
public class Outcast {
	
   WordNet wordnet;
   //**
   public Outcast(WordNet wordnet)  
   {
	  this.wordnet = wordnet;
   }
   //**
   public String outcast(String[] nouns) 
   {
	  //---------------------------------------------------------------------------------------------------------------
	  //Check if nouns[] has at least two items and and all items are wordnet nouns
	  //---------------------------------------------------------------------------------------------------------------
	  for(String word : nouns)
	  {
		  if(!wordnet.isNoun(word)) throw new IllegalArgumentException("All arguments must be wordnet nouns");
	  }
	  if(nouns.length < 2) throw new IllegalArgumentException("There needs to be at least two arguments in the array");
	  //---------------------------------------------------------------------------------------------------------------
	  //Iterate through the argument array keeping track of the distance, the longest distance will be the outcast
	  //---------------------------------------------------------------------------------------------------------------
	  int longestlength = 0;
	  String outcast = null;
	  for(String noun : nouns) {
		  int length =0;
		  for(String noun1 : nouns) {
			  if (noun != noun1) {
				  length += wordnet.distance(noun, noun1);
			  }
		  }  
		  if(length > longestlength) {
			  longestlength = length;
			  outcast = noun;
		  }
	  }
	  return outcast;
	  //---------------------------------------------------------------------------------------------------------------
   }

   public static void main(String[] args) throws FileNotFoundException {
		        
		     WordNet wordnet = new WordNet("synsets.txt","hypernyms.txt");
		     Outcast outcast = new Outcast(wordnet);
		     String[] nouns = new String[]{"apple", "pear", "peach", "banana", "lime", "lemon", "blueberry", "strawberry", "mango", "watermelon", "potato"};

		    System.out.println("Outcast: " + outcast.outcast(nouns));
		}
   }