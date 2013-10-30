// CS 112 Week 10 Lab 4
// by: Phillip Ly
// This is a class of the program guess a number game
// with "dice" implemented 

import javax.swing.JOptionPane; // imports that makes Java option Panels implementation possible

//starts of class Dice
public class Dice {
	
	//declarations
	int diceNumber;
	int number;
	int bouces;
	static int numberValue;
	
	public static void OneThrow()
	{
		numbervalue = (int)( 1 + Math.random()*6);
		
		JOptionPane.showMessageDialog(null,"The current number is " + numbervalue);	

	}
	
	// Constructor
	// bounceNumber is the number of bounces from the main program
	
	public Dice (int bounceNumber)
	{
		bounces = bounceNumber;
	}
	
	// performing the dice function of generating random number from 1 to 6
	public int Throw(int bounces) {
		
	JOptionPane.showMessageDialog(null,"The current bounces are " + bounces);	
	
	// if the bounces is 1
	if(bounces == 1){
	
		int random1 = (1 + (int) (Math.random() * 6));

	}
	// if the bounces are 2
	else if (bounces == 2){
		int random1 = (1 + (int) (Math.random() * 6));
		int random2 = (1 + (int) (Math.random() * 6));
		 number = (random1+random2 / 2);

	}
	 
	 return number;
	}
	
	public int Value()
	{
		diceNumber = number;
		return diceNumber;
	}

} // end class Dice

// starts of main program for testing
import javax.swing.JOptionPane;


public class test {
	public static void main(String[] args) {
		
		
		int bounces = (int)(Math.random() *(2) + 1;
		Dice test = new dice(bounces);
		int bounces;		
		
		test.OneThrow();
		 
		test.Throw(bounces);
		
		JOptionPane.showMessageDialog(null,"The test number is " + test.Value());
	
		test.OneThrow();
	
	}

}