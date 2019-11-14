package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) {
//    	System.out.println(produceAnswer("5_3/4 + 6_5/8"));
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner scan = new Scanner(System.in);
    	String userInput = scan.next();
    		do {
        	System.out.println("please enter equation:");
        	userInput = scan.next();
    		System.out.println("answer: " + produceAnswer(userInput));
    		} while(!(userInput.equals("quit")));
    }
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4" 
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    
    public static String produceAnswer(String input) { 
    	String[] part1 = input.split(" "); //[1_1/2 + 6_1/4] --> [1_1/2, +, 6_1/4]
    	String answer;
    	int[] op1 = splitFrac(part1[0]); //op1[whole1, numer1, denom1]
    	int[] op2 = splitFrac(part1[2]); //op2[whole2, numer2, denom2]
    	toImproperFrac(op1); //turns into improper fraction for mathing
    	toImproperFrac(op2);    	
    	if(part1[1].equals("/")) {
    		answer = divide(op1[1], op2[1], op1[2], op2[2] );
    	} else if(part1[1].equals("*")) {
    		answer = multiply(op1[1], op2[1], op1[2], op2[2]);
    	} else if(part1[1].equals("+")) {
    		answer = add(op1[1], op2[1], op1[2], op2[2]);
    	} else { //else everything is subtract
    		answer = subtract(op1[1], op2[1], op1[2], op2[2]);
    	} 
    	return answer;
    }
    
    
    //splits everything into [a, b, c]	
    public static int[] splitFrac (String input) {	
    	int[]frac = {0, 0, 0};
    	if(input.contains("_")) {
    		String[]var1 = input.split("_");
    		String[]var2 = var1[1].split("/");
    		frac[0] = Integer.parseInt(var1[0]);
    		frac[1] = Integer.parseInt(var2[0]);
    		frac[2] = Integer.parseInt(var2[1]);
    	} else {
    		if(input.contains("/")) {
    			String[]var2 = input.split("/");
    			frac[1] = Integer.parseInt(var2[0]);
    			frac[2] = Integer.parseInt(var2[1]);
    		} else {
    			frac[0] = Integer.parseInt(input);
    		}
    	}
    	return frac;
    }
    //converts to improper fractions
	public static void toImproperFrac(int[]mixedFrac) {
		int newNumer = (mixedFrac[0]*mixedFrac[2])+mixedFrac[1];
		mixedFrac[1] = newNumer;
		mixedFrac[0] = 0;
	}
	//method for multiplications
	public static String multiply(int numer1, int numer2, int denom1, int denom2) {
		int finalNumer = numer1*numer2;
		int finalDenom = denom1*denom2;
		return(finalNumer + "/" + finalDenom);
	}
	//method for divisions
	public static String divide(int numer1, int numer2, int denom1, int denom2) {
		int newNum2 = denom2;
		int newDenom2 = numer2;
		int finalNum = numer1*newNum2;
		int finalDenom = denom1*newDenom2;
		return(finalNum + "/" + finalDenom);
	}
	//method for subtractions
	public static String subtract (int numer1, int numer2, int denom1, int denom2) {
		int newDenom = denom1*denom2;
		int newNum1 = numer1*denom2;
		int newNum2 = numer2*denom1;
		int finalNum = newNum1 - newNum2;
		return(finalNum + "/" + newDenom);
	}
	//method for addition
	public static String add(int numer1, int numer2, int denom1, int denom2) {
		int newDenom = denom1*denom2;
		int newNum1 = numer1*denom2;
		int newNum2 = numer2*denom1;
		int finalNum = newNum1 + newNum2;
		return(finalNum + "/" + newDenom);
	}
	//convert answer into mixed number
	public static String toMixedNum(int numer, int denom) {
		int wholeNumber = numer/denom;
		numer = numer%denom;
		return(wholeNumber + "_" + numer + "/" + denom); 

}

