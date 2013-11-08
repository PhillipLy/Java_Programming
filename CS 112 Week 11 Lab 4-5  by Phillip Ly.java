// CS 112 Week 11 Lab 4-5
// by: Phillip Ly

public class TrippleDice extends Dice_Class_Week_11_Labs
{
	public trippleDice()
	{
		super();
	}
	
	@Override
	public int Throw()
	
	{
		int timesCall = 0;
		for(int i = 0; i < 3; i++)
		{
			timesCall += super.Throw();
		}
		
		int average = (timescall/3);
		
		return average;
		
	}
}

// starts of test program

public class TrippleDiceAndDiceTestProgram
{
	public static void main(String[] args)
	{
		TrippleDice Test = new TrippleDice();
		
		system.out.println(Test.Throw());
	}
}






