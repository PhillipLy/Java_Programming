// CS 112 Week 10 Lab 1
// by: Phillip Ly
// This is a class of the program guess a number game
// with "dice" implemented 

import javax.swing.JOptionPane; // imports that makes Java option Panels implementation possible
//starts of class Dice

public class Dice {

	// performing the dice function of generating random number from 1 to 6
	public int Throw() {

		return (1 + (int) (Math.random() * 6));
	}

	public int Value() {

		int currentDiceValue = (1 + (int) (Math.random() * 6));
		return currentDiceValue;
	}

} // end class Dice

public class wk10_lab1_Dice {
	
	 int diceNumber;
	
	public int Throw()
	{
			
		int num =  (int)( 1 + (int) (Math.random() * 6);
		return num;
	}

	public int Value()
	{
		 diceNumber = Throw();
		return diceNumber;
		
	}
}