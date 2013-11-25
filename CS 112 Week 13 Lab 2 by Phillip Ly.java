// Week 13 Lab 2
// This is the interface of lab 2
// by: Phillip Ly

package week13_labs;

public interface week13_labs {

        int getGeneratedRandomNumber() throws Exception; // generate a random number

        String getHistory(); // return tracked history

} // end interface


package week13_labs;

import java.util.ArrayList;
import java.util.Random;


public class Dice implements week13_labs  {

        // declarations
        private int dice;
        private ArrayList<Integer> hist;
        public static final Random rand = new Random();


        public Dice(int d) {

                dice = d;

                hist = new ArrayList<Integer>();

                 }

        public Dice() {

                   this(1);

          }


        // generate a random number and return it
        @Override
         public int getGeneratedRandomNumber() throws Exception {

                if ( hist.size() > 3)
                {
                        throw new Exception();
                }

                 int number = rand.nextInt(6 * dice) + 1;

                 this.hist.add(number);

                  return number;

                  }
        // keep track of history and return
        @Override
        public String getHistory()
        {

                String history = "";

                   for (int roll : hist) {

                  history += roll + ", ";

                     }
                return history;
        }

}



package week13_labs;

public class test_program {

        public static void main(String[] args) throws Exception {


                Dice myDice = new Dice();



                try // throw an exception and immediately catch it
                {
                        System.out.println("Method throwException called");
                        myDice.getGeneratedRandomNumber();
                        myDice.getGeneratedRandomNumber();
                        myDice.getGeneratedRandomNumber();
                } // end try
                catch ( Exception exception ) // catch exception thrown in try
                {
                        System.err.println("Exception catched");
                } // end catch


                try // throw an exception and immediately catch it
                {
                        System.out.println("Method throwException called");
                        myDice.getGeneratedRandomNumber();
                        myDice.getGeneratedRandomNumber();
                        myDice.getGeneratedRandomNumber();
                        myDice.getGeneratedRandomNumber();

                } // end try
                catch ( Exception exception ) // catch exception thrown in try
                {
                        System.err.println("Exception catched");
                } // end catch

                finally // executes regardless of what occurs in try...catch
                {
                        System.err.println("Finally executed in throwException");
                } // end finally

                }



}