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
		original.areEqual();
		original.areNotEqual();
		
		cloned.areEqual();
		cloned.areNotEqual();
		
	}

}