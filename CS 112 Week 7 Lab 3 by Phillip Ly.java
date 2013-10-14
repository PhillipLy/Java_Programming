import java.util.Arrays;

public class arraysAddingGivenNumbers {

	public static void main(String[] args) {
		int[] arrayNums;
		arrayNums = new int[6];

		arrayNums[0] = 123;
		arrayNums[1] = 456;
		arrayNums[2] = 479;
		arrayNums[3] = 135;
		arrayNums[4] = 246;
		arrayNums[5] = 135;

		Arrays.sort(arrayNums);

		int i;
		int sum = 0;
		int average = 0;

		for (i = 0; i < arrayNums.length; i++) {
			System.out.println("Number: " + arrayNums[i]);
		}

		sum = 123 + 135 + 135 + 246 + 456 + 479;
		average = (sum / 6);
		System.out.printf("Average:%d\n", average);

	}

}