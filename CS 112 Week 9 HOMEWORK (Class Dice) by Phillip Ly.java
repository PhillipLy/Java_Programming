// CS 112 Week 09 Homework
// by: Phillip Ly
// This is a class of the program guess a number game
// with "dice" implemented 

import javax.swing.JOptionPane; // imports that makes Java option Panels implementation possible
//starts of class Dice

public class Dice {

	// display initial values of game board
	public void setGameBoardInitial() {

		JOptionPane.showMessageDialog(null,
				"Initially, you had 0 correct guesses and 0 "
						+ "wrong guesses. Your win percentage is 0.0 %.");
	}

	// display prompt for players to enter guesses
	public String promptUser() {

		return (JOptionPane
				.showInputDialog("Guess the number the dice will roll. Type in one for 1, "
						+ "two for 2, three for 3, four for 4, five for 5, six for 6."));
	}

	// display prompt asking players if they want to play again
	public int playAgainPrompt() {

		return (Integer
				.parseInt(JOptionPane
						.showInputDialog("Do you want to keep playing? 1 for yes, 0 for no")));
	}

	// performing the dice function of generating random number from 1 to 6
	public int diceNumberGenerator() {

		return (1 + (int) (Math.random() * 6));
	}

	// display the message letting the players know that their guesses were
	// right
	public void rightGuess() {

		JOptionPane.showMessageDialog(null,
				"You got it! Your guess was correct!");
	}

	// display the message letting the players know that their guesses were
	// wrong
	public void wrongGuess() {

		JOptionPane.showMessageDialog(null,
				"Wrong guess! The CPU won this round!");
	}

	// display the message in case the players entered irrelevant characters,
	// symbols, etc
	public void errorMessage() {

		JOptionPane.showMessageDialog(null,
				"An error has occured! Restarting the game...");
	}

} // end class Dice
