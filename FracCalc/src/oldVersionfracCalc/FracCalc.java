package oldVersionfracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
//    	System.out.println(produceAnswer("5_3/4 + 6_5/8"));
		// TODO: Read the input from the user and call produceAnswer with an equation
		Scanner scan = new Scanner(System.in);
		String userInput = "";
		do {
			System.out.println("please enter equation:");
			userInput = scan.nextLine();
			System.out.println("answer: " + produceAnswer(userInput));
		} while (!(userInput.equals("quit")));
	}

	public static String produceAnswer(String input) {
		String[] part1 = input.split(" "); // [1_1/2 + 6_1/4] --> [1_1/2, +, 6_1/4]
		String answer;
		System.out.println(Arrays.toString(part1));
		int[] op1 = splitFrac(part1[0]); // op1[whole1, numer1, denom1]
		int[] op2 = splitFrac(part1[2]); // op2[whole2, numer2, denom2]
		toImproperFrac(op1); // turns into improper fraction for mathing
		toImproperFrac(op2);
		if (part1[1].equals("/")) {
			answer = divide(op1[1], op2[1], op1[2], op2[2]);
		} else if (part1[1].equals("*")) {
			answer = multiply(op1[1], op2[1], op1[2], op2[2]);
		} else if (part1[1].equals("+")) {
			answer = add(op1[1], op2[1], op1[2], op2[2]);
		} else { // else everything is subtract
			answer = subtract(op1[1], op2[1], op1[2], op2[2]);
		}
		return answer;
	}

	// splits everything into [a, b, c]
	public static int[] splitFrac(String input) {
		int[] frac = { 0, 0, 0 };
		if (input.contains("_")) {
			String[] var1 = input.split("_");
			String[] var2 = var1[1].split("/");
			frac[0] = Integer.parseInt(var1[0]);
			frac[1] = Integer.parseInt(var2[0]);
			frac[2] = Integer.parseInt(var2[1]);
		} else {
			if (input.contains("/")) {
				String[] var2 = input.split("/");
				frac[1] = Integer.parseInt(var2[0]);
				frac[2] = Integer.parseInt(var2[1]);
			} else {
				frac[0] = Integer.parseInt(input);
			}
		}
		return frac;
	}

	// converts to improper fractions
	public static void toImproperFrac(int[] mixedFrac) {
		int newNumer = Math.abs((mixedFrac[0] * mixedFrac[2])) + mixedFrac[1];
		if (mixedFrac[1] == 0) {
			newNumer = Math.abs(mixedFrac[0]);
			mixedFrac[2] = 1;
		}
		mixedFrac[1] = newNumer;
		if (mixedFrac[0] < 0) {
			mixedFrac[1] = mixedFrac[1] * (-1);
		}
		mixedFrac[0] = 0;
	}

	// method for multiplications
	public static String multiply(int numer1, int numer2, int denom1, int denom2) {
		int finalNumer = numer1 * numer2;
		int finalDenom = denom1 * denom2;
		String answer = toMixedNum(finalNumer, finalDenom);
		return answer;
	}

	// method for divisions
	public static String divide(int numer1, int numer2, int denom1, int denom2) {
		int newNum2 = denom2;
		int newDenom2 = numer2;
		int finalNum = numer1 * newNum2;
		int finalDenom = denom1 * newDenom2;
		System.out.println(numer1 + " " + denom1 + " " + numer2 + " " + denom2 + " " + newNum2 + " " + newDenom2 + " "
				+ finalNum + " " + finalDenom);
		String answer = toMixedNum(finalNum, finalDenom);
		return answer;
	}

	// method for subtractions
	public static String subtract(int numer1, int numer2, int denom1, int denom2) {
		int newDenom = denom1 * denom2;
		int newNum1 = numer1 * denom2;
		int newNum2 = numer2 * denom1;
		int finalNum = newNum1 - newNum2;
		String answer = toMixedNum(finalNum, newDenom);
		return answer;
	}

	// method for addition
	public static String add(int numer1, int numer2, int denom1, int denom2) {
		int newDenom;
		if (denom1 == 0 || denom2 == 0) {
			newDenom = denom1 + denom2;
		} else {
			newDenom = denom1 * denom2;
		}
		int newNum1 = numer1 * denom2;
		int newNum2 = numer2 * denom1;
		int finalNum = newNum1 + newNum2;
		String answer = toMixedNum(finalNum, newDenom);
		return answer;
	}

	// convert answer into mixed number
	public static String toMixedNum(int numer, int denom) {
		int[] frac = { numer, denom };
		System.out.println(Arrays.toString(frac));
		simplify(frac);
		System.out.println(Arrays.toString(frac));
		int wholeNumber;
		numer = frac[0];
		denom = frac[1];
		if (numer == 0 || denom == 0) {
			wholeNumber = 0;
		} else {
			wholeNumber = numer / denom;
		}
		numer = numer % denom;
		if (denom < 0) {
			numer = numer * (-1);
		}
		if (numer == 0) {
			return (wholeNumber + "");
		} else if (wholeNumber == 0) {
			return (numer + "/" + Math.abs(denom));
		} else {
			return (wholeNumber + "_" + Math.abs(numer) + "/" + Math.abs(denom));
		}
	}

//greatest common factor
	public static int gcf(int num1, int num2) {
		int gcf = 1;
		for (int i = 1; i <= max(num1, num2); i++) {
			if (isDivisibleBy(num1, i) && isDivisibleBy(num2, i)) {
				gcf = i;
			}
		}
		return gcf;
	}

//max - returns larger of two values. accepts two doubles and returns one double.
	public static double max(double num1, double num2) {
		if (num1 > num2) {
			return num1;
		} else {
			return num2;
		}
	}

//isDivisbleBy - determines if an integer is divisible by another.
	public static boolean isDivisibleBy(int dividend, int divider) {
		if (dividend % divider == 0) {
			return true;
		} else {
			return false;
		}
	}

//simplifying....(T^T)
	public static void simplify(int[] frac) {
		int gcf = gcf(Math.abs(frac[0]), Math.abs(frac[1]));
		System.out.println(gcf + "");
		frac[0] = frac[0] / gcf;
		frac[1] = frac[1] / gcf;
	}
}
