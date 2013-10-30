// CS 112 Week 10 Lab 5
// by: Phillip Ly
// This is a class of the program guess a number game
// with "dice" implemented 

import javax.swing.JOptionPane; // imports that makes Java option Panels implementation possible

//starts of class Dice
public class Dice {
	
	//declarations
	int diceNumber;
	int number;
	int bounces;
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
	public int Throw(int dices, int bounces) {
		
	JOptionPane.showMessageDialog(null,"The current bounces are " + bounces);	
	
	int totalValue - 0;
	
	for (int i = 0; i < dices; i++)
	{
	// if the bounces is 1
	if(bounces == 1){
	
		int random1 = (1 + (int) (Math.random() * 6));

	}
	// if the bounces are 2
	else {
		int number1 = 0;
		for (int j = 0; j < bounces; j++)

		{
			number1 = number1 + (1+(int)(Math.random()*6)); 
		}
		
		totalValue = (number1)/bounces;
	}
	
	number = number + totalvalue;
	
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
		
		
		int bounces = (int)(Math.random() *(100) + 1;
		int dices = Integer.parseInt(JOptionPane.showInputDialog("What is the number of dices to throw?"));
		Dice test = new dice(bounces);
		int bounces;		
		
		test.Throw(dices, bounces);

		// test.OneThrow();
		 
		
		JOptionPane.showMessageDialog(null,"The final value is " + test.Value());
	
	
	}

}