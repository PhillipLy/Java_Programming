// CS 112 Week 10 Lab 2
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

} // end class Dice