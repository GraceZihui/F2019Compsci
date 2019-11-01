import java.util.Scanner;

public class ProcessingNumbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // how to close scanner?
		System.out.print("Please enter the amount of numbers you'd like.");
		int totalNumbers = scan.nextInt();
		System.out.print("Please enter your numbers! #1: ");
		int sum = 0;
		int max = 0;
		int value = scan.nextInt();
		int min = value; // The minimum value works now
		int evenMax = 0; // Even number max works now thank u Jesus

		for (int i = 2; i <= totalNumbers; i++) {
			System.out.print("#" + i + ": ");
			int scannedNum = scan.nextInt();
			if (scannedNum > max) {
				max = scannedNum; // overall maximum number
				if (max % 2 == 0) { // loop to find max even number - if even then run again if not ignore it?
					evenMax = max;
				}
			} if (scannedNum < min) {
				min = scannedNum; //loop for minimum that doesn't work
			} //it works now!
			if (scannedNum % 2 == 0) {
				sum += scannedNum; //sum of even numbers
			}
		}
		System.out.println("Maximum Number: " + max);
		System.out.println("Maximum Even Number: " + evenMax);
		System.out.println("Minimum Number: " + min);
		System.out.println("The Sum of the Even Numbers: " + sum);
		
		scan.close();
	}
}