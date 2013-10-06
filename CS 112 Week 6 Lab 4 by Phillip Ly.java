import java.util.Scanner;

public class Lab_4_Week_6 {


                public static void main(String[] args)
                {

                        Scanner inp = new Scanner (System.in);
                        int userGuess;
                        String userInput;
                        int generatedNumberToGuess = 0;
                        boolean playUntilDone = false, play = true;

                        while (play)
                        {
                                System.out.println("Guess a number between 0
and 10: ");
                                userGuess = inp.nextInt();

                                generatedNumberToGuess = 0 +(int) (Math.random()* 10);


                          System.out.printf("Random number is %d\n",
generatedNumberToGuess);

                            if (userGuess == generatedNumberToGuess)
                            {
                                System.out.println("Your guess was correct");
                            }

                            else if (userGuess > generatedNumberToGuess)
                            {
                                System.out.println("Your guess was too high");
                            }

                            else
                            {
                            System.out.println("Your guess was too low");
                            }

                                Scanner kb = new Scanner(System.in);
                                System.out.print("Play again(y/n)? ");
                                userInput = kb.next();

                                playUntilDone = (userInput.equalsIgnoreCase("y") ||
userInput.equalsIgnoreCase("Y"));
                                if( playUntilDone )
                                {
                                continue;
                                }
                                else if ( userInput.equalsIgnoreCase("n") ||
userInput.equalsIgnoreCase("no") )
                                {
                                break;
                                }
                                else
                                {
                                System.out.println("Invalid choice...game over");
                                break;
                                }

                        }

                        System.out.println("Bye Bye");
                }


}