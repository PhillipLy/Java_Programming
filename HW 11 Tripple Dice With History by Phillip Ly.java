// Triple Dice with history class for HW # 11
// by Phillip Ly

public class trippleDiceWithHistory_week_11_HW extends Dice_Class_Week_11_Labs
		implements Cloneable {

	// private declarations
	private int numberOfThrows = 0;
	private int valuePerThrow = 0;
	private int[] historyOfThrows = new int[100];

	public trippleDiceWithHistory_week_11_HW() {

	}

	// starts of Throw function
	@Override
	public int Throw() {
		valuePerThrow = super.Throw();
		numberOfThrows++;
		historyOfThrows[numberOfThrows] = valuePerThrow;
		return valuePerThrow;
	}

	// starts of toString function
	@Override
	public String toString() {
		String printHistoryOfThrows = null;

		for (int i = 1; i <= numberOfThrows; i++)

			printHistoryOfThrows = String.format("The %d throw's value was %d",
					i, historyOfThrows[i]);

		return (printHistoryOfThrows);

	}

	// For clone method
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	// Equal Methods
	@Override
	public boolean areEqual() {

		if (numberOfThrows == valuePerThrow)
			return true;

		return true;
	}

	@Override
	public boolean areNotEqual() {

		if (numberOfThrows != valuePerThrow)
			return false;

		return true;
	}

}
