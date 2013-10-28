import javax.swing.JOptionPane;

//class
public class OddorEven {

	private int m_val;

	public OddorEven(int val) {
		m_val = val;
	}

	public OddorEven() {
		m_val =  0 + (int)(Math.random()*10);
	}

	public void setval(int val) {
		m_val = val;
	}

	public String oddeven() {
		if (m_val % 2 == 0) {
			return "even";
		}

		else
			return "odd";
	}

	public static void odd() {
		JOptionPane.showMessageDialog(null, "Odd");
	}

	public static void even() {
		JOptionPane.showMessageDialog(null, "Even");
	}
}

//main

import java.util.Scanner;
import javax.swing.JOptionPane;

public class OddOrEvenTest {
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		int tries = 0;
		int computerNum;
		int[] userWins = new int[100];
		int[] compWins = new int[100];
		String[] userChoice = new String[100];
		int[] compChoice = new int[100];
		int choice = 1;
		int scorecard;
		int value = 0;
		OddOrEven myOddOrEven = new OddOrEven(value);

		while (choice == 1) {
			computerNum = 0 + (int) (Math.random() * 10);
			String guess = JOptionPane
					.showInputDialog("Guess if its even or odd. E for even and O for odd");
							userChoice[tries] = guess;
							compChoice[tries] = computerNum;
							JOptionPane.showMessageDialog(null, "The number is " + computerNum);
							if (guess.equals("O")) {
								if (computerNum % 2 == 0) {
									myOddOrEven.displayEven();
									userWins[tries] = 0;
									compWins[tries] = 1;
								}

								else if (computerNum % 2 != 0) {
									myOddOrEven.displayOdd();
									userWins[tries] = 1;
									compWins[tries] = 0;
								}

							}
							if (guess.equals("E")) {
								if (computerNum % 2 == 0) {
									JOptionPane.showMessageDialog(null,
											"Good guess! The number was even!");
									userWins[tries] = 1;
									compWins[tries] = 0;
								}

								else if (computerNum % 2 != 0) {
									JOptionPane.showMessageDialog(null,
											"Wrong guess! The number was odd!");
									userWins[tries] = 0;
									compWins[tries] = 1;
								}

							}

							choice = Integer
									.parseInt(JOptionPane
											.showInputDialog("Do you want to keep playing? 1 for yes, 0 for no"));
							scorecard = Integer
									.parseInt(JOptionPane
											.showInputDialog("Do you want to see the scorecard? 1 for yes,
													0 for no"));
													if (scorecard == 1) {
														int wins = 0;
														int loses = 0;

														for (int i : userWins) {
															wins += i;
														}

														for (int i : compWins) {
															loses += i;
														}

														JOptionPane
														.showMessageDialog(null, "You had " + wins
																+ " correct guesses. And  " + loses
																+ " wrong guesses!");

														JOptionPane
														.showMessageDialog(null,
																"The following are your guesses and the computers number");

														for (int i = 0; i <= tries; i++) {

															JOptionPane.showMessageDialog(null, "Your guess no "
																	+ String.valueOf(i + 1) + " was: " + userChoice[i]
																			+ " The actual number was: " + compChoice[i]);
														}

														scorecard = 1;
													}
													tries++;
		} // While

	}
}