// Week 13 Lab 1 
// This is the interface of lab 1
// by: Phillip Ly

package week13_labs;

public interface week13_labs {

	int getGeneratedRandomNumber(); // generate a random number
	
	String getHistory(); // return tracked history

} // end interface



public class Dice implements week13_labs {

	// declarations
	private int dices;
	private ArrayList<Integer> hist;
	public static final Random rand = new Random();
	
	
	public Dice(int d) {

		 dices = d;

		hist = new ArrayList<Integer>();
		
		 }
	
	public Dice() {

		   this(1);

	  }
	// generate a random number and return it
	@Override
	 public int getGeneratedRandomNumber() {

		 int number = rand.nextInt(6 * dices) + 1;

		 this.hist.add(number);

		  return number;

		  }
	// keep track of history and return
	@Override
	public String getHistory()
	{
		
		String history = "";

		   for (int roll : hist) {

	          history += roll + ", ";

		     }
		return history;
	}
	
}
	
	

package week13_labs;

import java.util.ArrayList;

import java.util.Random;

public class Card implements week13_labs {

	private int card;
	private ArrayList<Integer> hist;
	public static final Random rand = new Random();
	
	
	public Card(int d) {

		 card = d;

		hist = new ArrayList<Integer>();
		
		 }
	
	public Card() {

		   this(1);

	  }
	
	@Override
	 public int getGeneratedRandomNumber() {

		 int number = rand.nextInt(52 * card) + 1;

		 this.hist.add(number);

		  return number;

		  }
	
	@Override
	public String getHistory()
	{
		
		String history = "";

		   for (int roll : hist) {

	          history += roll + ", ";

		     }
		return history;
	}
	
}


package week13_labs;

public class test_program {

	public static void main(String[] args) {
		
		// create two element array for interface
		week13_labs[] interfaceObjects = new week13_labs[2];
		
		// populate array with objects that implement interface
		interfaceObjects[1] = new Dice(1);
		
		interfaceObjects[2] = new Card(2);

		for ( week13_labs currentValue: interfaceObjects )
		{
			System.out.printf( "The value of the dice is: %d", currentValue.getGeneratedRandomNumber());
			
			System.out.println("The history of the dice is");
			
			currentValue.getHistory();
			
			
			System.out.printf( "The value of the card is: %d", currentValue.getGeneratedRandomNumber());
			
			System.out.println("The history of the card is");
			
			currentValue.getHistory();		
			
			
		}
		
		
	}

}