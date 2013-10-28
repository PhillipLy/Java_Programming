// Phillip Ly
// 10 22 2013
// This program prints 'Odd' or 'Even' strings

public class OddOrEven {

	public void displayOdd() {
		System.out.println("Odd");

	}

	public void displayEven() {
		System.out.println("Even");

	}

}

public class OddOrEvenTest {

	public static void main(String[] args) {

		OddOrEven myOddOrEven = new OddOrEven();

		myOddOrEven.displayOdd();
		myOddOrEven.displayEven();
	}

}