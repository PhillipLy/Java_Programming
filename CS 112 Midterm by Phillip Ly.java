import java.util.Scanner;

public class Odd_Even_Game {

	public static void main(String[] args) {

		Scanner inp = new Scanner(System.in);

		int userInput = 0;
		int generatedNumberToGuess;
		int round = 0;
		int numberOfGamesPlayed = 0;
		int evenNumber = 0;
		int oddNumber = 0;
		int playerWins = 0;
		int playerLosses = 0;
		int computerWins = 0;
		int computerLosses = 0;
		String promptPlayAgain;

		do {

			generatedNumberToGuess = ((int) (Math.random() * 10));

			if ((generatedNumberToGuess % 2) == 0) {
				generatedNumberToGuess = evenNumber;
				System.out.printf("Generated number to guess is %d\n",
						evenNumber);
			}

			else {
				generatedNumberToGuess = oddNumber;
				System.out.printf("Generated number to guess is %d\n",
						oddNumber);

			}

			System.out
					.println("Guess the generated number ranging from 0 to 10 (Please enter 1 to pick odd or 2 to pick even): ");
			userInput = inp.nextInt();

			numberOfGamesPlayed++;

			if ((generatedNumberToGuess == evenNumber) && (userInput == 2)) {
				playerWins++;
				computerLosses++;
				System.out
						.println("You guessed even while the computer generated an even number. You won!");
			}

			else if ((generatedNumberToGuess == evenNumber) && (userInput == 1)) {
				playerLosses++;
				computerWins++;
				System.out
						.println("You guessed odd while the computer generated an even number. You lost!");
			}

			else if ((generatedNumberToGuess == oddNumber) && (userInput == 1)) {
				playerWins++;
				computerLosses++;
				System.out
						.println("You guessed odd while the computer generated an odd number. You won!");
			}

			else if ((generatedNumberToGuess == oddNumber) && (userInput == 2)) {
				playerLosses++;
				computerWins++;
				System.out
						.println("You guessed even while the computer generated an odd number. You lost!");
			} else {
				System.out
						.println("Invalid input, please enter 1 to pick odd or 2 to pick even");
				continue;
			}

			Scanner input = new Scanner(System.in);

			System.out.println("Do you want to play again? Y/ N ");
			promptPlayAgain = input.nextLine();

			if (promptPlayAgain.equals("Y") || promptPlayAgain.equals("y")) {
				continue;
			}

			else if (promptPlayAgain.equals("N") || promptPlayAgain.equals("n")) {
				System.out.println("You played " + numberOfGamesPlayed
						+ " times!");
				break;
			}

			else {
				System.out.println("Invalid input...game is shutting down...");
				break;
			}

		}

		while (round < 9999);

		int[] gamesPlayed = new int[numberOfGamesPlayed];
		int iPlayerAndComputer;

		for (iPlayerAndComputer = 0; iPlayerAndComputer < gamesPlayed.length; iPlayerAndComputer++) {
			gamesPlayed[iPlayerAndComputer] = iPlayerAndComputer + 1;
			System.out.println("Total number of games played in all: "
					+ gamesPlayed[iPlayerAndComputer]);
		}

		int[] gamesPlayerWon = new int[playerWins];
		int iPlayer;

		for (iPlayer = 0; iPlayer < gamesPlayerWon.length; iPlayer++) {
			gamesPlayerWon[iPlayer] = iPlayer + 1;
			System.out.println("Total games you won in all: "
					+ gamesPlayerWon[iPlayer]);
		}

		int[] gamesComputerWon = new int[computerWins];
		int iComputer;

		for (iComputer = 0; iComputer < gamesComputerWon.length; iComputer++) {
			gamesComputerWon[iComputer] = iComputer + 1;
			System.out.println("Total games the computer won in all: "
					+ gamesComputerWon[iComputer]);
		}

		int[] gamesPlayerLoses = new int[playerLosses];
		int iPlayerDeciding;

		for (iPlayerDeciding = 0; iPlayerDeciding < gamesPlayerLoses.length; iPlayerDeciding++) {
			gamesPlayerLoses[iPlayerDeciding] = iPlayerDeciding + 1;
			System.out.println("Total games you lost in all: "
					+ gamesPlayerLoses[iPlayerDeciding]);
			System.out
					.println("If the total games you lost in all is greater than the total games you won in all, "
							+ "you ultimately lost in the end. The computer is the winner in the end.");

		}

		int[] gamesComputerLosses = new int[computerLosses];
		int iComputerDeciding;

		for (iComputerDeciding = 0; iComputerDeciding < gamesComputerLosses.length; iComputerDeciding++) {
			gamesComputerLosses[iComputerDeciding] = iComputerDeciding + 1;
			System.out.println("Total games the computer lost in all: "
					+ gamesComputerLosses[iComputerDeciding]);
			System.out
					.println("If the total games the computer lost in all is greater than the total games the computer won in all, "
							+ "the computer ultimately lost in the end. The winner is you in the end");

		}

	}

}