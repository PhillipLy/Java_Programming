import java.util.Scanner;

public class Rock_Paper_Scissor {

	public static void main(String[] args)
	{
		String userInput;
		int userChoice = -1, cpuChoice, timesChoseRock = 0, timesChosePaper =
				0, timesChoseScissor = 0, timesWon = 0, timesLost = 0, timesTied = 0;
		int numberOfTries = 0;
		boolean debug = false;
		// debug = true;

		Scanner kb = new Scanner(System.in);
		while( userChoice >= -1)		{

			System.out.print("Please enter your choice of rock, paper, or scissor: ");
			userInput = kb.next();
			numberOfTries++;

			// Start Choice Assignments
			if( userInput.equalsIgnoreCase("rock") || userInput.equalsIgnoreCase("r") )
				userChoice = 0;
			else if( userInput.equalsIgnoreCase("paper") ||
					userInput.equalsIgnoreCase("p") )
				userChoice = 1;
			else if( userInput.equalsIgnoreCase("scissor") ||
					userInput.equalsIgnoreCase("s") )
				userChoice = 2;
			else if( userInput.equalsIgnoreCase("debug") && debug == true)
				userChoice = 3;
			else
			{
				System.out.println("Invalid choice");
				break;
			}

			cpuChoice = (int)(Math.random() * 3);


			// Initiate Winner Determination
			if( userChoice == 3)
				System.out.println("You won! You are (wins/loses/ties): "+ ++timesWon
						+":"+ timesLost +":"+ timesTied);

			else if( userChoice == 0 && cpuChoice == 0) // Rock v Rock
				System.out.println("You tied! You chose rock, while the computer also
						chose rock (times chose rock (player + CPU)/ times chose paper (player
								+ CPU)/ times chose scissor (player + CPU)): \n"+ ((++timesChoseRock)
								* 2) +":"+ timesChosePaper +":"+ timesChoseScissor );

								else if( userChoice == 0 && cpuChoice == 1) // Rock v Paper
									System.out.println("You lost! You chose rock, while the computer
											chose paper (times chose rock (player + cpu)/times chose paper (player
													+ CPU)/ times chose scissor (player + CPU)): \n"+ ++timesChoseRock
													+":"+ ++timesChosePaper +":"+ timesChoseScissor );

								else if( userChoice == 0 && cpuChoice == 2) // Rock v Scissor
									System.out.println("You won! You chose rock, while the computer chose
											scissor (times chose rock (player + cpu)/times chose paper (player +
													CPU)/ times chose scissor (player + CPU)): \n"+ ++timesChoseRock +":"+
														timesChosePaper +":"+ ++timesChoseScissor );

								else if( userChoice == 1 && cpuChoice == 0) // Paper v Rock
									System.out.println("You won! You chose paper, while the computer
											chose rock (times chose rock (player + cpu)/times chose paper (player
													+ CPU)/ times chose scissor (player + CPU)): \n"+ ++timesChoseRock
													+":"+ ++timesChosePaper +":"+ timesChoseScissor );

								else if( userChoice == 1 && cpuChoice == 1) // Paper v Paper
									System.out.println("You tied! You chose paper, while the computer
											also chose paper (times chose rock (player + cpu)/times chose paper
													(player + CPU)/ times chose scissor (player + CPU)): \n"+
													timesChoseRock +":"+ ((++timesChosePaper) * 2) +":"+ timesChoseScissor
											);

								else if( userChoice == 1 && cpuChoice == 2) // Paper v Scissor
									System.out.println("You lost! You chose paper, while the computer
											chose scissor (times chose rock (player + cpu)/times chose paper
													(player + CPU)/ times chose scissor (player + CPU)): \n"+
													timesChoseRock +":"+ ++timesChosePaper +":"+ ++timesChoseScissor );

								else if( userChoice == 2 && cpuChoice == 0) // Scissor v Rock
									System.out.println("You lost! You chose scissor, while the computer
											chose rock (times chose rock (player + cpu)/times chose paper (player
													+ CPU)/ times chose scissor (player + CPU)): \n"+ ++timesChoseRock
													+":"+ timesChosePaper +":"+ ++timesChoseScissor );

								else if( userChoice == 2 && cpuChoice == 1) // Scissor v Paper
									System.out.println("You won! You chose scissor, while the computer
											chose paper (times chose rock (player + cpu)/times chose paper (player
													+ CPU)/ times chose scissor (player + CPU)): \n"+ timesChoseRock +":"+
														++timesChosePaper +":"+ ++timesChoseScissor );

								else if( userChoice == 2 && cpuChoice == 2) // Scissor v Scissor
									System.out.println("You tied! You chose scissor, while the computer
											chose scissor (times chose rock (player + cpu)/times chose paper
													(player + CPU)/ times chose scissor (player + CPU)): \n"+
													timesChoseRock +":"+ timesChosePaper +":"+ ( (++timesChoseScissor) *
															2) );

								else // Internal Error
								{
									System.err.println("Internal Error");
									break;
								}

								if(debug == true)
								{
									System.out.println("RAW INFO::userChoice=="+ userChoice
											+"::cpuChoice==="+ cpuChoice);
								}

								System.out.print("Play again(y/n)? ");
								userInput = kb.next();

								if( userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes") )
								{
									continue;
								}
								if ( userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("no") )
								{
									break;
								}
								else
								{
									System.out.println("Invalid choice...game over");
									break;
								}
		}
		kb.close();

		int[] playerAndComputerMoves = new int[numberOfTries];
		int iPlayerComputer;

		for (iPlayerComputer = 0; iPlayerComputer < playerAndComputerMoves.length; iPlayerComputer++) {
			playerAndComputerMoves[iPlayerComputer] = iPlayerComputer + 1;
			System.out.println("Number of moves from player and computer in this game: "
					+ playerAndComputerMoves[iPlayerComputer] );
		}
	}