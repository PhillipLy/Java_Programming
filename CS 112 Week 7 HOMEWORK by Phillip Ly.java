import java.util.Scanner;

public class GuessANumberGame {

	public static void main(String[] args) {

		Scanner inp = new Scanner(System.in);
		int userGuess;
		int generatedNumberToGuess;
		int round = 0;
		int numberOfTries = 0;
		String promptPlayAgain;

		do {

			generatedNumberToGuess = (int) (Math.random() * 10);
			System.out.println("Guess a number between 0 and 10: ");
			userGuess = inp.nextInt();
			numberOfTries++;

			System.out.printf("Random number is %d\n", generatedNumberToGuess);

			if (userGuess < generatedNumberToGuess) {
				System.out.println("Your guess was too low");
			}

			else if (userGuess > generatedNumberToGuess) {
				System.out.println("Your guess was too high");
			}

			else {
				System.out.println("Your guess was correct");
				System.out.println("It took you " + numberOfTries + " tries");
			}

			System.out.printf("Random number is %d\n", generatedNumberToGuess);

			Scanner input = new Scanner(System.in);

			System.out.println("Do you want to play again? Y/ N ");
			promptPlayAgain = input.nextLine();

			if (promptPlayAgain.equals("Y") || promptPlayAgain.equals("y")) {
				continue;
			}

			else if (promptPlayAgain.equals("N") || promptPlayAgain.equals("n")) {
				break;
			}

			else {
				System.out.println("Invalid input...game is shutting down...");
				break;
			}

		}

		while (round < 9999 || promptPlayAgain.equals("Y")
				|| promptPlayAgain.equals("y"));

		int[] playerAndComputerMoves = new int[numberOfTries];
		int iPlayerComputer;

		for (iPlayerComputer = 0; iPlayerComputer < playerAndComputerMoves.length; iPlayerComputer++) {
			playerAndComputerMoves[iPlayerComputer] = iPlayerComputer + 1;
			System.out
					.println("Number of moves from player and computer in this game: "
							+ playerAndComputerMoves[iPlayerComputer]);
		}

	}
}
//Good
