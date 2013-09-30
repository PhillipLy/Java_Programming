import java.util.Scanner;
import java.util.Random;

public class GuessANumberGame
{

        public static void main(String[] args)
        {

                Random rand = new Random();
                int generatedNumberToGuess = rand.nextInt(9);
                Scanner input = new Scanner( System.in );
                int userGuess;

                System.out.println("Guess a number between 1 and 10: ");
                userGuess = input.nextInt();

                if (userGuess == generatedNumberToGuess)
                        System.out.println("Your guess was correct");

                if (userGuess < generatedNumberToGuess)
                        System.out.println("Your guess was too low, please try again");
                        userGuess = input.nextInt();

                if (userGuess > generatedNumberToGuess)
                        System.out.println("Your guess was too high, please try again");
                        userGuess = input.nextInt();


        }

}