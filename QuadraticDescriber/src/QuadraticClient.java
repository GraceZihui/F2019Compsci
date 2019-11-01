import java.util.*;
public class QuadraticClient {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		double aInput = 0.0;
		double bInput = 0.0;
		double cInput = 0.0;
		String keepGoing = " ";
		System.out.println("Welcome to the Quadratic Describer!");
		System.out.println(":-)");
		System.out.println("Please enter your a, b, and c values.");
		while (!keepGoing.equals("quit")) {
			System.out.print("a: ");
			aInput = console.nextDouble();
			System.out.print("b: ");
			bInput = console.nextDouble();
			System.out.print("c: ");
			cInput = console.nextDouble();
			System.out.println(Quadratic.quadrDescriber(aInput, bInput, cInput));
			System.out.println("Do you wish to continue? (Type \"end\" to end)");
			keepGoing = console.next();
			keepGoing = keepGoing.toLowerCase();
		}
		console.close();
	}
}