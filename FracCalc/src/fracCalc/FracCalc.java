package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) {
    	System.out.println(produceAnswer("5_3/4 + 6_5/8"));
        // TODO: Read the input from the user and call produceAnswer with an equation
//    	Scanner scan = new Scanner(System.in);
//    	String userInput = scan.next();
//    		do {
//        	System.out.println("please enter equation:");
//        	userInput = scan.next();
//    		System.out.println("answer: " + produceAnswer(userInput));
//    		} while(!(userInput.equals("quit")));

}
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4" 
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    
    public static String produceAnswer(String input) { 
        // TODO: Implement this function to produce the solution to the input
    	String[] part1 = input.split(" "); //[1_1/2 + 6_1/4] --> [1_1/2, +, 6_1/4]
    	int wholeNum;
    	int numer;
    	int denom;
    	if(part1[2].contains("/")) {
    		if(part1[2].contains("_")) {
    		wholeNum = Integer.parseInt(part1[2].substring(0, part1[2].indexOf("_"))); 
    	    numer = Integer.parseInt(part1[2].substring(part1[2].indexOf("_")+1, part1[2].indexOf("/")));
    		} else {
    			wholeNum = 0;
    			numer = Integer.parseInt(part1[2].substring(0, part1[2].indexOf("/")));
    		}
	    	
	    	denom = Integer.parseInt(part1[2].substring(part1[2].indexOf("/")+1));
    	} else {
//    		if whole number, numer = 0 and denom = 2 
    		wholeNum = Integer.parseInt(part1[2]);
    		numer = 0;
    		denom = 1;
    	}
    	return "whole:" + wholeNum + " numerator:" + numer + " denominator:" + denom;
    	
    }
}

//    public static String solveMethods(String op1, String operator, String op2) {
//    	String[] firstFrac = op1.split("_");
//    }

