// By: Phillip Ly
// Week 14 Lab 3

import java.util.Arrays;
import java.util.Random;


public class SimpleDiceArray {

        private final int[] array;
        private int diceIndex = 0;

        // construct a diceArray of a given size

        public SimpleDiceArray(int size)
        {
                array = new int[size];
        } // end constructor


        public void add(int value)
        {
                int position = diceIndex; // store the dice index
                array[position] = value;

                System.out.printf(" The value of the dice is %2d ", value);

                ++diceIndex;

                System.out.printf(" Next dice index: %d\n", diceIndex);

        }
}


import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class MainDiceTest {

        public static void main(String[] args) {

                // construct the shared object
                SimpleDiceArray sharedSimpleDiceArray = new SimpleDiceArray(25);

                System.out.println("Starting Thread Pool");
                // create executorService to manage threads
                ExecutorService threadExecutor = Executors.newCachedThreadPool();

                for (int i = 0; i < 3; i++) {

                        Dice dice1 = new Dice(1, sharedSimpleDiceArray);
                        Dice dice2 = new Dice(2, sharedSimpleDiceArray);
                        Dice dice3 = new Dice(3, sharedSimpleDiceArray);

                        // start threads and place in runnable state
                        threadExecutor.execute(dice1);
                        threadExecutor.execute(dice2);
                        threadExecutor.execute(dice3);

                }

                // shut down
                threadExecutor.shutdown();

                System.out.println("Tasks started, main ends.\n");

        } // end main

}// end class




import java.util.Random;
import java.lang.Runnable;

public class Dice implements Runnable {

     // declarations
     private int dice;
     public static final Random rand = new Random();
     private int threadNumber = 0;
     private final  SimpleDiceArray sharedSimpleDiceArray;
         private final int startValue = 0;

     public Dice(int d, SimpleDiceArray array) {

             dice = d;
             sharedSimpleDiceArray = array;
     }


     // generate a random number and return it
     @Override
     public void run() {

         threadNumber++;

         int number = rand.nextInt(6 * dice) + 1;

         System.out.printf("Thread number %d threw %d \n",
threadNumber, number);

         for ( int i = startValue; i < startValue + 3; i++)
         {
                 sharedSimpleDiceArray.add(number);
         }



     }

}
//Good
