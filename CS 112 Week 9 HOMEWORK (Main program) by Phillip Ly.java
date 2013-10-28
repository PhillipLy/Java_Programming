// CS 112 Week 09 Homework
// by: Phillip Ly
// This program is a guess a number game
// with "dice" implemented 

import java.util.Scanner;
import javax.swing.JOptionPane; // program uses Java option Panels

// starts of program
public class HomeworkWeek09 {
	private static Scanner input;

	public static void main(String[] args) {
		// relevant declarations
		input = new Scanner(System.in);
		int tries = 0;
		int attempts = 0;
		int computerNum;
		int[] userWins = new int[100];
		int[] compWins = new int[100];
		String[] userChoice = new String[100];
		int[] compChoice = new int[100];
		int choice = 1;
		int scorecard;
		Dice myDice = new Dice(); // creates the dice object and assigns it to
									// myDice

		// starts of while loop with the condition of choice == 1 or if the
		// player wants to play
		while (choice == 1) {

			computerNum = myDice.diceNumberGenerator(); // call myDice's
														// diceNumberGenerator
														// method to generate
														// dice numbers
			String guess = myDice.promptUser();// call myDice's promptUser
												// method so players can enter
												// guesses
			attempts++; // after player entered guess increment the attempts
						// counter by 1
			userChoice[tries] = guess;
			compChoice[tries] = computerNum;
			JOptionPane.showMessageDialog(null, "The number is " + computerNum);

			// different possible outcomes after player entered guess and the
			// computer generated Dice number
			if (guess.equals("one") && computerNum != 1) {

				myDice.wrongGuess(); // calls myDice's wrongGuess method to
										// display the message of outcome
				userWins[tries] = 0;
				compWins[tries] = 1;

			}

			else if (guess.equals("one") && computerNum == 1) {

				myDice.rightGuess(); // calls myDice's rightGuess method to
										// display the message of outcome
				userWins[tries] = 1;
				compWins[tries] = 0;
			}

			else if (guess.equals("two") && computerNum != 2) {

				myDice.wrongGuess(); // calls myDice's wrongGuess method to
										// display the message of outcome
				userWins[tries] = 0;
				compWins[tries] = 1;
			}

			else if (guess.equals("two") && computerNum == 2) {

				myDice.rightGuess(); // calls myDice's rightGuess method to
										// display the message of outcome
				userWins[tries] = 1;
				compWins[tries] = 0;
			}

			else if (guess.equals("three") && computerNum != 3) {

				myDice.wrongGuess(); // calls myDice's wrongGuess method to
										// display the message of outcome
				userWins[tries] = 0;
				compWins[tries] = 1;
			}

			else if (guess.equals("three") && computerNum == 3) {

				myDice.rightGuess(); // calls myDice's rightGuess method to
										// display the message of outcome
				userWins[tries] = 1;
				compWins[tries] = 0;
			}

			else if (guess.equals("four") && computerNum != 4) {

				myDice.wrongGuess(); // calls myDice's wrongGuess method to
										// display the message of outcome
				userWins[tries] = 0;
				compWins[tries] = 1;
			}

			else if (guess.equals("four") && computerNum == 4) {

				myDice.rightGuess(); // calls myDice's rightGuess method to
										// display the message of outcome
				userWins[tries] = 1;
				compWins[tries] = 0;
			}

			else if (guess.equals("five") && computerNum != 5) {

				myDice.wrongGuess(); // calls myDice's wrongGuess method to
										// display the message of outcome
				userWins[tries] = 0;
				compWins[tries] = 1;
			}

			else if (guess.equals("five") && computerNum == 5) {

				myDice.rightGuess(); // calls myDice's rightGuess method to
										// display the message of outcome
				userWins[tries] = 1;
				compWins[tries] = 0;
			}

			else if (guess.equals("six") && computerNum != 6) {

				myDice.wrongGuess(); // calls myDice's wrongGuess method to
										// display the message of outcome
				userWins[tries] = 0;
				compWins[tries] = 1;
			}

			else if (guess.equals("six") && computerNum == 6) {

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
				scorecard = Integer
						.parseInt(JOptionPane
								.showInputDialog("Do you want to see the game result? 1 for yes, 0 for no "
										+ "(WARNING: this option is only available every even attempts)"));
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
					JOptionPane.showMessageDialog(null, "You had " + wins
							+ " correct guesses. And  " + loses
							+ " wrong guesses!");

					JOptionPane
							.showMessageDialog(null,
									"The following are your guesses and the computers number");

					for (int i = 0; i <= tries; i++) {
						// keeping tracks of player's guesses and generated numbers
						JOptionPane.showMessageDialog(null, "Your guess no"
								+ " " + String.valueOf(i + 1) + " was: "
								+ userChoice[i] + " The actual number was: "
								+ compChoice[i]);

						double userWinPercentage = (wins / attempts) * 100;
						// calculation of the player's win percentage
						String winPercentageOfUser = String
								.format("Your win percentage based on your "
										+ " total wins/total attempts is: %.2f",
										userWinPercentage);
						JOptionPane
								.showMessageDialog(null, winPercentageOfUser);
					}

					scorecard = 1;

				}
			}
			tries++;

		} // the While loop's bracket

	}

} // ends of program

