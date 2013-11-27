// By: Phillip Ly
// Week 14 lab 2

import java.util.Random;

public class Dice implements Runnable {

     // declarations
     private int dice;
     public static final Random rand = new Random();
     private int threadNumber = 0;
     public Dice(int d) {

             dice = d;

     }

     public Dice() {

             this(1);

     }

     // generate a random number and return it
     @Override
     public void run() {

         threadNumber++;

             int number = rand.nextInt(6 * dice) + 1;

             System.out.printf("Thread number %d threw %d \n",
threadNumber, number);


     }

}

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class MainDiceTest {

        public static void main(String[] args) {

                int stringNumber = 0;

                System.out.println("Starting Thread Pool");
                // create executorService to manage threads
                                ExecutorService threadExecutor = Executors.newCachedThreadPool();

                for (int i = 0; i < 25; i++) {



                        // create and name each runnable
                        Dice thread = new Dice();

                        // start threads and place in runnable state
                        threadExecutor.execute(thread); // start task1

                }

                // shut down
                threadExecutor.shutdown();

                System.out.println("Tasks started, main ends.\n");

        } // end main

}// end class