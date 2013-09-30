import java.util.Scanner;

public class GuessANumberGame
{

        public static void main(String[] args)
        {

                Scanner inp = new Scanner (System.in);
                int userGuess;
                int generatedNumberToGuess;
                int round = 1;
                String promptPlayAgain = "N";


                while ( round < 9999)
                {

                            generatedNumberToGuess = 0 +(int) (Math.random()* 10);
                            System.out.println("Guess a number between 0 and 10: ");
                            userGuess = inp.nextInt();

                            System.out.printf("Random number is %d\n", generatedNumberToGuess);

                        

                        if (userGuess < generatedNumberToGuess)
                            {
                                    System.out.println("Your guess was too low");
                            }

                            else if (userGuess > generatedNumberToGuess)
                            {
                                    System.out.println("Your guess was too high");
                            }

                            else
                            {
                                    System.out.println("Your guess was correct");
                            }

			System.out.println("Do you want to play again? Y/N");
                            promptPlayAgain = inp.nextLine();
                           
                        if (promptPlayAgain.equals("Y") || promptPlayAgain.equals("y") )
                                {
	                              continue;
                                }



                        if (promptPlayAgain.equals("N") || promptPlayAgain.equals("n") )
                                {
                                       break;
                                }      
                         
                        else 
                           {
                                System.out.println("Invalid choice...game shutting down.")
                           }


                 }




                }

 }