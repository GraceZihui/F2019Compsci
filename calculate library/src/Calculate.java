 //Grace Shang 
//8/29/19
//Fourth period
//Group of methods that will perform math calculations 
//UPLOAD AND FINISH IT !!!!!!!!! >:-(

//square - returns the square of the value passed.
public class Calculate {
	public static int square(int number) {
		int answer = 0;
		answer = number* number;
		return answer;	
	}

//cube - returns the cube of the value passed.
	public static int cube(int number) {
		int answer = 0;
		answer = number * number * number;
		return answer;
	}	

//average for 2 numbers - returns average of two numbers. Accepts two doubles and returns one double.
	public static double average(double number1, double number2) {
		double answer = 0.0;
		answer = (number1+number2)/2;
		return answer;
	}
	
//average for 3 numbers - gives the average for three numbers. Accepts three doubles and returns one double.
	public static double average( double number1, double number2, double number3) {
		double answer = 0.0;
		answer = (number1+number2+number3)/3;
		return answer;
	}
	
//toDegrees - converts angle measure given in radians to degrees.
	public static double toDegrees(double number) {
		double answer = 0.0;
		answer = (3.14159/180)*number;
		return answer;
	}
	
//toRadians - converts angle measure given in degrees to radians.
	public static double toRadians(double number) {
		double answer = 0.0;
		answer = (180/3.14159)*number;
		return answer;
	}
		
//discriminant - provides coefficients of a quadratic equation in standard form.
	public static double discriminant(double num1, double num2, double num3) {
		double answer = 0.0;
		answer = ((num2*num2-4*num1*num3)/(2*num1));
		return answer;	
	}
//toImproperFrac - converts a mixed number to an improper fraction.
	public static String toImproperFrac(int whole, int num, int denom) {
		int numerator = 0;
		int denominator = 0;
		numerator = (whole*denom)+num;
		denominator = denom;
		return numerator + "/" + denominator;
	}
	
//toMixedNum (a is the numerator, and b is the denominator) - converts from improper fraction to mixed number.
	public static String toMixedNum(int numerator, int denominator) {
		int wholeNumber = numerator/denominator;
		numerator = numerator%denominator;
		return wholeNumber + "_" + numerator + "/" + denominator; 
	}
	
//foil - converts binomial multiplication form into quadratic equation form. 
	public static String foil(int a, int b, int c, int d, String var) {
		return (a*c) + var + "^2 +" + ((a*d) + (b*c)) + var + "+" + (b*d);
	}
	
//PART TWO	
//isDivisbleBy - determines if an integer is divisible by another.
	public static boolean isDivisibleBy(int dividend, int divider) {
		if(divider==0) throw new IllegalArgumentException("no answer");
		if(dividend%divider == 0) {
			return true;
		}else {
			return false;
		}
	}
	
//absValue - returns the absolute value of a number. 
	public static double absValue(double num) {
		if(num<=0) {
			return (num*-1);
		}else{
			return num;
		}
	}
	
//max - returns larger of two values. accepts two doubles and returns one double.
	public static double max(double num1, double num2) {
		if(num1>num2) {
			return num1;
		}else {
			return num2;
		}
	}		
//max3 - returns the larger of three variables - accepts three doubles and returns one double.
	public static double max(double num1, double num2, double num3) {
		if(num1>num2 && num1>num3) {
			return num1;
		}else if(num2>num2 && num2>num3) {
			return num2;
		}else{
			return num3;
		}
		}

//min - returns minimum of two integers. Accepts two integers and returns an int.
	public static int min(int num1, int num2) {
		if(num1<num2) {
			return num1;
		}else
			return num2;
		}
//min method, accepts two doubles
	public static double min(double num1, double num2) {
		if(num1<num2) {
			return num1;
		}else
			return num2;
		}
	
//round2 - rounds a double to two decimal places. Returns a double.
	public static double round2(double a) {
		a = (a*100)+0.5;
		//multiply by 100 then convert to int to get rid of decimals
		a = (int)a;
		a = (double)a/100;
		//convert back to double and divide by 100 to move two decimal spaces back
		return (a);
	}

//PART THREE
//exponent - raises to a positive exponential power. accepts double and int and returns double.
	public static double exponent(double base, int power) {
		if(power<0) throw new IllegalArgumentException("cannot calculate negative exponents");
		double answer = 1;
		for(int i=1; i<=power; i++) {
			answer = answer*base;
		}
		return answer;
	}
//factorial - returns factorial of a value passed. Accepts integer and returns integer.
	public static int factorial(int a) {
		if(a>0) throw new IllegalArgumentException("cannot calculate");
		int answer = 1;
		for(int i=1; i<=a; i++) {
			answer = answer*i;
		}
		return answer;
	}

//isPrime
	public static boolean isPrime(int a) { 
		for(int i=2; i<a; i++) { 
			if(isDivisibleBy(a,i)) {
				//if ifDivisibleBy returns as true then it can't be prime.
				return false;
			}	
		}
		return true;
	}
//gcf - finds greatest common factor between two intervals. Accepts two integers and returns one integer.
	public static int gcf(int num1, int num2) {
		if(num1==0 || num2==0) throw new IllegalArgumentException("a==0 && b==0");
		int gcf = 1;
		for(int i=1; i<=max(num1,num2); i++) {
			if(isDivisibleBy(num1,i) && isDivisibleBy(num2,i)) {
				gcf = i;
			}
		}
		return gcf;
	}

//square root - returns the approximation of the square root passed rounded to two decimals. Accepts a double and returns a double.
	public static double sqrt(double a) {
		if(a<0)throw new IllegalArgumentException("cannot find square root of a negative number");
		double answer = a/2;
		while((answer*answer)-a>=.005){
		answer = (.5*(a/answer+a));		 
		}
		return round2(answer);
	}
	
//quadForm - approximates the real roots in a quadratic formula if any. Accepts three integers and returns a string. 
	public static String quadForm(int a, int b, int c) {
		double discriminant = discriminant(a, b, c); //b^2-4ac - determines what type of roots(negative, positive, zero)
		double root1; 
		double root2 ;
		//if negative, returns "no real roots"
		if(discriminant<0) {
			return "no real roots";
		}else {
			root1 = (sqrt(discriminant)-b/(2*a));	//quadratic formula written out linearly
			root2 = (-sqrt(discriminant)-b/(2*a));
		}
		if(root1 == root2) {
			return round2(root1) + ":^)"; 
		}
		return round2(min(root1, root2)) + " and " + round2(max(root1, root2)); //ordering the roots smallest to largest & rounding 
	}
}	