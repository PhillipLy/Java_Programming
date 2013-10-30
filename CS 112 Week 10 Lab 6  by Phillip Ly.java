// CS 112 Week 10 Lab 6
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
		public int Throw() {

			return (1 + (int) (Math.random() * 6));
		}

		public int Value() {

			int currentDiceValue = (1 + (int) (Math.random() * 6));
			return currentDiceValue;
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

// starts of main program for testing
import javax.swing.JOptionPane;


public class test {
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
				Dice myDice = new Dice(bounces); // creates the dice object and assigns it to myDice
				int bounces = (int)(Math.random() *(100) + 1;
				int bounces;	
				
				// starts of while loop with the condition of choice == 1 or if the player wants to play
				while (choice == 1) {

					computerNum = myDice.Throw(); // call myDice's diceNumberGenerator method to generate dice numbers
					int dices = Integer.parseInt(JOptionPane.showInputDialog("What is the number of dices to throw?"));
					myDice.Throw(dices, bounces);
					String guess = myDice.promptUser();// call myDice's promptUser method so players can enter guesses
					attempts++; // after player entered guess increment the attempts counter by 1
					userChoice[tries] = guess;
					compChoice[tries] = computerNum;
					JOptionPane.showMessageDialog(null, "The number is " + computerNum);
					JOptionPane.showMessageDialog(null,"The final number is " + myDice.Value());

					
					// different possible outcomes after player entered guess and the computer generated Dice number
					if (guess.equals("one") && computerNum != 1) {

						myDice.wrongGuess(); // calls myDice's wrongGuess method to display the message of outcome
						userWins[tries] = 0;
						compWins[tries] = 1;

					}

					else if (guess.equals("one") && computerNum == 1) {

						myDice.rightGuess(); // calls myDice's rightGuess method to display the message of outcome
						userWins[tries] = 1;
						compWins[tries] = 0;
					}

					else if (guess.equals("two") && computerNum != 2) {

						myDice.wrongGuess(); // calls myDice's wrongGuess method to display the message of outcome
						userWins[tries] = 0;
						compWins[tries] = 1;
					}

					else if (guess.equals("two") && computerNum == 2) {

						myDice.rightGuess(); // calls myDice's rightGuess method to display the message of outcome
						userWins[tries] = 1;
						compWins[tries] = 0;
					}

					else if (guess.equals("three") && computerNum != 3) {

						myDice.wrongGuess(); // calls myDice's wrongGuess method to display the message of outcome
						userWins[tries] = 0;
						compWins[tries] = 1;
					}

					else if (guess.equals("three") && computerNum == 3) {

						myDice.rightGuess(); // calls myDice's rightGuess method to display the message of outcome
						userWins[tries] = 1;
						compWins[tries] = 0;
					}

					else if (guess.equals("four") && computerNum != 4) {

						myDice.wrongGuess(); // calls myDice's wrongGuess method to display the message of outcome
						userWins[tries] = 0;
						compWins[tries] = 1;
					}

					else if (guess.equals("four") && computerNum == 4) {

						myDice.rightGuess(); // calls myDice's rightGuess method to display the message of outcome
						userWins[tries] = 1;
						compWins[tries] = 0;
					}

					else if (guess.equals("five") && computerNum != 5) {

						myDice.wrongGuess(); // calls myDice's wrongGuess method to display the message of outcome
						userWins[tries] = 0;
						compWins[tries] = 1;
					}

					else if (guess.equals("five") && computerNum == 5) {

						myDice.rightGuess(); // calls myDice's rightGuess method to display the message of outcome
						userWins[tries] = 1;
						compWins[tries] = 0;
					}

					else if (guess.equals("six") && computerNum != 6) {

						myDice.wrongGuess(); // calls myDice's wrongGuess method to display the message of outcome
						userWins[tries] = 0;
						compWins[tries] = 1;
					}

					else if (guess.equals("six") && computerNum == 6) {

						myDice.rightGuess(); // calls myDice's rightGuess method to display the message of outcome
						userWins[tries] = 1;
						compWins[tries] = 0;
					}

					else {
						myDice.errorMessage(); // calls myDice's errorMessage method to display the relevant message
						continue;
					}

					choice = myDice.playAgainPrompt(); // calls myDice's playAgainPrompt method to ask player to play again

					// every 2 tries ask the players if they wants to see the results rather than inconveniently asking every time 
					if(tries % 2 == 0){
					scorecard = Integer
							.parseInt(JOptionPane
									.showInputDialog("Do you want to see the game result? 1 for yes, 0 for no "
											+ "(WARNING: this option is only available every even attempts)"));
					// relevant codes keeping tracks of player wins and win percentages
					if (scorecard == 1 ) {
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
						JOptionPane
								.showMessageDialog(null, "You had " + wins
										+ " correct guesses. And  " + loses
										+ " wrong guesses!");

						JOptionPane
								.showMessageDialog(null,
										"The following are your guesses and the computers number");

						for (int i = 0; i <= tries; i++) {

							JOptionPane.showMessageDialog(null, "Your guess no" + " "
									+ String.valueOf(i + 1) + " was: " + userChoice[i]
									+ " The actual number was: " + compChoice[i]);
							
							double userWinPercentage = (wins / attempts)*100;
							// calculation of the player's win percentage
							String winPercentageOfUser = String.format(
									"Your win percentage based on your "
											+ " total wins/total attempts is: %.2f",
									userWinPercentage);
							JOptionPane.showMessageDialog(null, winPercentageOfUser);
						}
						
						scorecard = 1;
						
						}
					}
					tries++;

				} // the  While loop's bracket 
		
		
	
	
	}

}