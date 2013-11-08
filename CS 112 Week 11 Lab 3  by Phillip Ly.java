// CS 112 Week 11 Lab 3 class
// by: Phillip Ly

public class ThreeDice
{
	Private DiceObject D1;
	Private DiceObject D2;
	Private DiceObject D3;
	
	public int Throw()
	{
		int dSum = 0;
		
		dSum += D1.Throw();
		dSum += D2.Throw();
		dSum += D3.Throw();
		
		int average = (dSum/3);
		
		return average;		
	}

}

// CS 112 Week 11 Lab 3 test program
// by: Phillip Ly

public class ThreeDiceClassTest 
{
	public static void main(String[] args) 
	{
		ThreeDice testThreeDice = new ThreeDice();
		
		System.out.println(threeDice.Throw());
	
	}

}
