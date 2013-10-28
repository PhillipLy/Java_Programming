//Phillip Ly

public class OddOrEven {

	private String m_val; // private variable of the class Odd or Even
	private int m_valInt;

	public OddOrEven(int value) {
		m_valInt = value;
	}

	// method allow user to set value of m_val
	public void setValue(int value) {
		m_valInt = value; // store the m_val
	} // end method setValue

	// method to retrieve the value
	public int oddEven() {
		return m_valInt;
	} // end method oddEven

	public void displayOdd() {
		System.out.println("Odd");

	}

	public void displayEven() {
		System.out.println("Even");

	}

}


import java.util.Scanner;

public class OddOrEvenTest {

	// main method begins program execution
	public static void main(String[] args) {

		// create Scanner to obtain input from command window
		Scanner input = new Scanner(System.in);

		int value = 0;
		// create myOddOrEven object and assign it to OddOrEven
		OddOrEven myOddOrEven = new OddOrEven(value);

		// display initial value of OddOrEven
		System.out.printf("Initial value is: %s \n\n", myOddOrEven.oddEven());

		// prompt for and read value
		System.out.println("Please enter a value");
		int theValue = input.nextInt(); // read inputed integer

		myOddOrEven.setValue(theValue); // set the value

		System.out.println();

		if (theValue % 2 != 0) {
			myOddOrEven.displayOdd();
		}

		else if (theValue % 2 == 0)
			myOddOrEven.displayEven();
	}

}