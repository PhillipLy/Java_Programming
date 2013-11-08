// CS 112 Week 11 Dice Class 
// Lab: 2
// by: Phillip Ly
// This is a class of the program guess a number game
// with "dice" implemented 

import javax.swing.JOptionPane; // imports that makes Java option Panels implementation possible

public class Dice_Class_Week_11_Labs {
	
	//declarations
		int diceNumber;
		static int number;
		int bounces;
	    static int numberValue;
		static int totalValue = 0;
		static int keepTrackOfThrows = 0;
		static int numberOfThrow = 0;

		
		// Constructor
		// bounceNumber is the number of bounces from the main program
		
		public Dice_Class_Week_11_Labs (int bounceNumber)
		{
			bounces = bounceNumber;
		}
		
		// keep track of history 
		public void keepTrackHistory(int[] winsTotal, int[] losesTotal, int triesTotal, int[] playersChoice, int[] cpuChoice){
			
			int wins = 0;
			int loses = 0;

			for (int i : winsTotal) {
				wins += i;
			}

			for (int i : losesTotal) {
				loses += i;
			}
			
			JOptionPane
			.showMessageDialog(null, "You had " + wins
					+ " correct guesses. And  " + loses
					+ " wrong guesses!");
			
			for (int i = 0; i <= triesTotal; i++) {

				JOptionPane.showMessageDialog(null, "Your guess no"
						+ " " + String.valueOf(i + 1) + " was: "
						+ playersChoice[i] + " The actual number was: "
						+ cpuChoice[i]);
			}
		}
		
		
		// performing the dice function of generating random number from 1 to 6
		public static int Throw(int dices, int bounces) {
			
		JOptionPane.showMessageDialog(null,"The current bounces are " + bounces);	
			
		for (int i = 0; i < dices; i++)
		{
		// if the bounces is 1
		if(bounces == 1){
			 keepTrackOfThrows++; // keep track of number of throws
			 numberOfThrow = keepTrackOfThrows;
			 
	 
			int number1 = (1 + (int) (Math.random() * 6));

			totalValue = number1;
		}
		else {
			keepTrackOfThrows++; // keep track of number of throws
			numberOfThrow = keepTrackOfThrows;
			int number1 = 0;
			for (int j = 0; j < bounces; j++)

			{
				number1 = number1 + (1+(int)(Math.random()*6)); 
			}
			
		totalValue = (number1 )/bounces;
		}
		
		number = number + totalValue;
		
		}
		
		JOptionPane.showMessageDialog(null,"The current number of throw is " + numberOfThrow );	
		
		 return number;
		 
		}
		
		public static void OneThrow()
		{
			keepTrackOfThrows++; // keep track of number of throws
			numberOfThrow = keepTrackOfThrows;
			
			JOptionPane.showMessageDialog(null,"The current number of throw is " + numberOfThrow);
	         
		}
		
		// player's win percentage
		public void playerWinPercentage(int totalWins, int totalAttempts)
		{
			if(totalAttempts == 0)
			{
			totalAttempts = 1;
			double userWinPercentage = (totalWins / totalAttempts)*100;
			// calculation of the player's win percentage
			String winPercentageOfUser = String.format(
					"Your win percentage based on your "
							+ " total wins/total tries is: %.2f",
					userWinPercentage);
			JOptionPane.showMessageDialog(null, winPercentageOfUser);
			}
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
		public int promptUser() {

			return (Integer
					.parseInt(JOptionPane
							.showInputDialog("Guess the number the dice(s) will roll." )));
		}

		public void promptUserGuessAndComputerNumber(){

			JOptionPane
			.showMessageDialog(null,
					"The following are your guesses and the computers number");
		}

		public int promptHistoryAndResults(){

			return (Integer.parseInt(JOptionPane.showInputDialog("Do you want to see the "
					+ "game result? 1 for yes, 0 for no "
					+ "(WARNING: this option is only available every even attempts)")));
		}

		public int promptNumberOfDiceToThrow(){

			return(Integer.parseInt(JOptionPane
					.showInputDialog("What is the number of dices to throw?")));
		}

		// display prompt asking players if they want to play again
		public int playAgainPrompt() {

			return (Integer
					.parseInt(JOptionPane
							.showInputDialog("Do you want to keep playing? 1 for yes, 0 for no")));
		}

		// performing the dice function of generating random number from 1 to 6
		public int Throw() {

			keepTrackOfThrows++;
			numberOfThrow = keepTrackOfThrows;
			JOptionPane.showMessageDialog(null,"The current number of throw is " + numberOfThrow );	


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

}


//CS 112 Week 11 Main program for testing
//Lab: 2
//by: Phillip Ly
//This is the program guess a number game
//with "dice" implemented and a class for 
//methods calling

import javax.swing.JOptionPane;


public class Main_Program_Week_11_Labs {

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
		Dice_Class_Week_11_Labs myDice = new Dice_Class_Week_11_Labs(bounces); // creates the
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

					}
					scorecard = 1;

				}
			}
			tries++;

		} // the While loop's bracket

}


