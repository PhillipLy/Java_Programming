// Main program for testing of HW # 11
// by Phillip Ly

public class mainProgramTest_Week_11_HW {

	public static void main(String[] args) throws CloneNotSupportedException
	{
		// Instantiation of object
		trippleDiceWithHistory_week_11_HW original = new trippleDiceWithHistory_week_11_HW();
		
		
		// lets create a clone of the trippleDice object
		trippleDiceWithHistory_week_11_HW cloned = (trippleDiceWithHistory_week_11_HW) original.clone();
		
		//verifications of clone
		System.out.println(cloned.Throw());
		
		System.out.println(original != cloned);
		
		// test equal method using clones
		System.out.println(original.getClass() == cloned.getClass());
		
		System.out.println(original.equals(cloned));
		
		// test equal method using numberOfThrows and valuePerThrow for both original and clones
		
		System.out.println("CPU is checking the original class to see if number of throws equal to the value of throw (returning true if yes, false if no)");
		original.areEqual();
		original.areNotEqual();
		
		System.out.println("CPU is checking the cloned class to see if number of throws equal to the value of throw (returning true if yes, false if no)");
		cloned.areEqual();
		cloned.areNotEqual();
		
	}

}
