// CS 112 Week 10 Homework
// by: Phillip Ly
// This is a class of the program guess a number game
// with "dice" implemented 

import javax.swing.JOptionPane; // imports that makes Java option Panels implementation possible

public class Week_10_Homework {
	//declarations
	int diceNumber;
	int number;
	int bounces;
    static int numberValue;
	int totalValue = 0;
	int keepTrackOfThrows = 0;
	int numberOfThrow = 0;

	
	// Constructor
	// bounceNumber is the number of bounces from the main program
	
	public Week_10_Homework (int bounceNumber)
	{
		bounces = bounceNumber;
	}
	
	// keep track of history 
	public void keepTrackHistory(int[] winsTotal, int[] losesTotal, int triesTotal, 
			int[] playersChoice, int[] cpuChoice)
	{
		
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
	public int Throw(int dices, int bounces) {
		
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
	
	public static void OneThrow()
	{
		numberValue = (int)( 1 + Math.random()*6);
		
		JOptionPane.showMessageDialog(null,"The current number is " + numberValue);
         
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

