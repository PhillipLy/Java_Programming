//Phillip Ly

public class OddOrEven {

	private String m_val; // private variable of the class Odd or Even

	//method allow user to set value of m_val
	public void setValue(String value)
	{
		m_val = value; // store the m_val
	} // end method setValue

	//method to retrieve the value
	public String oddEven()
	{
		return m_val;
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

		// create myOddOrEven object and assign it to OddOrEven
		OddOrEven myOddOrEven = new OddOrEven();

		//display initial value of OddOrEven
		System.out.printf("Initial value is: %s \n\n", myOddOrEven.oddEven());

		//prompt for and read value
		System.out.println("Please enter a value");
		String theValue = input.nextLine(); // read inputed text

		myOddOrEven.setValue(theValue); //set the value

		System.out.println();

		if(theValue.equals("odd") || theValue.equals("ODD") )
		{
			myOddOrEven.displayOdd();
		}

		else
			myOddOrEven.displayEven();
	}

}