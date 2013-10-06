import java.util.Scanner;

public class Lab_5_Week_6 {


                public static void main(String[] args)
                {

                        Scanner inp = new Scanner (System.in);
                        int userGuess;
                        String userInput;
                        int generatedNumberToGuess = 0;
                        char checkPlayAgain = ' ';
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

                                Scanner userInput= new Scanner(System.in);
                                System.out.print("Play again? Enter 1 if yes, enter 2 if no");

                                int again = userInput.nextInt();


                                switch (again)
                                {
                                case '1':
                                   play = true;
                                        break;


                                case '2':
                                    play = false
                                        break;

                                }
                        }

                        System.out.println("Bye Bye");
                }


}