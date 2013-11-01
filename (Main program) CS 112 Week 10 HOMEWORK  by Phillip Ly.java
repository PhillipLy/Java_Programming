// CS 112 Week 10 Homework
// by: Phillip Ly
// This is the program guess a number game
// with "dice" implemented and a class for 
// methods calling

import javax.swing.JOptionPane;

public class Week_10_Homework_Program {

	public static void main(String[] args) {

		// relevant declarations
		int tries = 0;
		int computerNum;
		int[] userWins = new int[100];
		int[] compWins = new int[100];
		int[] userChoice = new int[100];
		int[] compChoice = new int[100];
		int choice = 1;
		int scorecard;
		int bounces = (int) (Math.random() * (100) + 1);
		Week_10_Homework myDice = new Week_10_Homework(bounces); // creates the
		// dice
		// object
		// and
		// assigns
		// it to
		// myDice

		// starts of while loop with the condition of choice == 1 or if the
		// player wants to play
		while (choice == 1) {

			computerNum = myDice.Throw(); // call myDice's diceNumberGenerator
			// method to generate dice numbers
			int dices = myDice.promptNumberOfDiceToThrow();
			myDice.Throw(dices, bounces);
			int guess = myDice.promptUser();// call myDice's promptUser method
			// so players can enter guesses
			userChoice[tries] = guess;
			compChoice[tries] = computerNum;
			JOptionPane.showMessageDialog(null, "The number is " + computerNum);
			JOptionPane.showMessageDialog(null,
					"The final number is " + myDice.Value());

			// different possible outcomes after player entered guess and the
			// computer generated Dice number
			if (guess != computerNum) {

				myDice.wrongGuess(); // calls myDice's wrongGuess method to
				// display the message of outcome
				userWins[tries] = 0;
				compWins[tries] = 1;

			}

			else if (guess == computerNum) {

				myDice.rightGuess(); // calls myDice's rightGuess method to
				// display the message of outcome
				userWins[tries] = 1;
				compWins[tries] = 0;
			}

			else {
				myDice.errorMessage(); // calls myDice's errorMessage method to
				// display the relevant message
				continue;
			}

			choice = myDice.playAgainPrompt(); // calls myDice's playAgainPrompt
			// method to ask player to play
			// again

			// every 2 tries ask the players if they wants to see the results
			// rather than inconveniently asking every time
			if (tries % 2 == 0) {
				scorecard = myDice.promptHistoryAndResults();
				// relevant codes keeping tracks of player wins and win
				// percentages
				if (scorecard == 1) {
					int wins = 0;
					int loses = 0;

					for (int i : userWins) {
						wins += i;
					}

					for (int i : compWins) {
						loses += i;
					}

					myDice.setGameBoardInitial();
					// keeping tracks of wins and loses

					myDice.keepTrackHistory(wins, loses);

					myDice.promptUserGuessAndComputerNumber();

					for (int i = 0; i <= tries; i++) {

						JOptionPane.showMessageDialog(null, "Your guess no"
								+ " " + String.valueOf(i + 1) + " was: "
								+ userChoice[i] + " The actual number was: "
								+ compChoice[i]);

						myDice.playerWinPercentage(wins, tries);

					}

					scorecard = 1;

				}
			}
			tries++;

		} // the While loop's bracket

	}

}