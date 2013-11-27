// Week 14 Lab 1
// By: Phillip Ly


import java.util.Random;

public class Dice implements Runnable {

        // declarations
        private int dice;
        public static final Random rand = new Random();

        public Dice(int d) {

                dice = d;

        }

        public Dice() {

                this(1);

        }

        // generate a random number and return it
        @Override
        public void run() {

                int number = rand.nextInt(6 * dice) + 1;

                System.out.println(number);

        }

}




public class MainDiceTest {

        public static void main(String[] args) {

                System.out.println("Start of thread 1");
                for (int i = 0; i < 25; i++) {

                        Runnable T1 = new Dice();
                        Thread worker = new Thread(T1);
                        // set the name of the thread
                        worker.setName(String.valueOf(T1));
                        // starts the thread indirectly
                        worker.start();

                }
                System.out.println("Complete of thread 1");

                System.out.println("Start of thread 2");

                for (int i = 0; i < 25; i++) {

                        Runnable T2 = new Dice();
                        Thread worker2 = new Thread(T2);
                        // set the name of the thread
                        worker2.setName(String.valueOf(T2));
                        // start the thread
                        worker2.start();
                }

                System.out.println("Complete of thread 2");

        }

}