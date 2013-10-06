import java.util.Scanner;

public class Lab_1_Week_6 {


                public static void main(String[] args)
                {

                        Scanner inp = new Scanner (System.in);
                        int userGuess;
                        int generatedNumberToGuess = 0 +(int) (Math.random()* 10);
                        boolean win = false, greater;

                        while (win == false)
                        {

                                System.out.println("Guess a number between 0
and 10: ");
                                userGuess = inp.nextInt();
                                win   = (userGuess == generatedNumberToGuess);
                                greater = (userGuess > generatedNumberToGuess);
                                System.out.printf("Random number is %d\n",
generatedNumberToGuess);

                            if (win)
                            {
                                System.out.println("Your guess was correct");
                            }

                            else if (greater)
                            {
                                System.out.println("Your guess was too high");
                            }

                            else
                            {
                            System.out.println("Your guess was too low");
                            }
                        }

                    System.out.println("The number to guess was " +
generatedNumberToGuess);
                        System.out.println("Bye Bye");
                }


}