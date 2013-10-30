// CS 112 Week 10 Lab 2
// by: Phillip Ly
// This is a class of the program guess a number game
// with "dice" implemented 

import javax.swing.JOptionPane; // imports that makes Java option Panels implementation possible
//starts of class Dice

public class Dice {

	// performing the dice function of generating random number from 1 to 6
	public int Throw(int bounces) {
		
		int random1 = (1 + (int) (Math.random() * 6));
		
	 for (int i = 0; i <= 2; i++){
		int random2 = (1 + (int) (Math.random() * 6))
	}
	 
	 return (random2 / 2);
	}

	public int Value() {

		int currentDiceValue = (1 + (int) (Math.random() * 6));
		return currentDiceValue;
	}

} // end class Dice