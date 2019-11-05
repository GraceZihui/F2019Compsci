package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner scan = new Scanner(System.in);
    	System.out.println("please enter equation:");
    	String userInput = scan.nextLine();
    	if(userInput.equals("quit")) {
    	System.out.println("see you around then ;-)");
    	} else {
    		System.out.println("answer: " + produceAnswer(userInput));
    }
}
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4" 
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) { 
        // TODO: Implement this function to produce the solution to the input
    	String[]part1 = input.split(" "); //[1_1/2 + 6_1/4] --> [1_1/2, 6_1/4]
    	String[]part2 = part1[2].split("_"); //--> [6, 1/2]
    	String[]part3 = part1[2].split("/"); //--> [6, 1, 2]
    	String numerator = part3[1];
	

//    	int[] array = [whole, numerator, denominator];
//    	String oper1 = part[0];
//    	String oper = part[1];
//    	String oper2 = part[2];
//    	return oper2;

    }// TODO: Fill in the space below with any helper methods that you think you will need
    
}
