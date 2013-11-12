// Dice Game with trippleDiceWithHistory Implementation For HW # 11
// by Phillip Ly

import javax.swing.JOptionPane;

public class DiceGameProgramWeek_11_HW {

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
		int playersWinsForCalculation = 0;
		
		// instantiations of objects using the relevant classes
		Dice_Class_Week_11_Labs myDice = new Dice_Class_Week_11_Labs(bounces); 
		trippleDiceWithHistory_week_11_HW original = new trippleDiceWithHistory_week_11_HW();

		// starts of while loop with the condition of choice == 1 or if the
		// player wants to play
		while (choice == 1) {

			computerNum = myDice.Throw(); // call myDice's diceNumberGenerator
			// method to generate dice numbers
			int dices = myDice.promptNumberOfDiceToThrow();
			Dice_Class_Week_11_Labs.Throw(dices, bounces);
			Dice_Class_Week_11_Labs.OneThrow();
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
				playersWinsForCalculation++;
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

					myDice.setGameBoardInitial();
					
					// keeping tracks of wins and loses, games history, and results
					myDice.keepTrackHistory(userWins, compWins, tries, userChoice, compChoice);

					myDice.promptUserGuessAndComputerNumber();

					myDice.playerWinPercentage(playersWinsForCalculation, tries);
					
					// Implementation of trippleDiceWithHistory
					original.Throw();
					
					JOptionPane.showMessageDialog(null, "Checking to see if the number of throws equal to the value per throw"
							+ "(true = yes, false = no). ");
					original.areEqual();
					original.areNotEqual();
					
					}
					scorecard = 1;

				}
			}
			tries++;
			
		} // the While loop's bracket
}