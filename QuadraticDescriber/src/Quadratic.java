//responsible for all calculations
public class Quadratic {
	public static String quadrDescriber(double a, double b, double c) {
					//takes a b c values and plugs them into quadratic graph equation
					//gives axis of symmetry, x intercept(s), y intercept
					//also tells you which way graph opens apparently T_T
					//needs scanner?	
		String output = "";
			output += ":-)";
			output += "Description of the graph of:\n";
			output += "y=" + a + " x^2 + " + b + " x + " + c + "\n"; //y = a * (x^2) + b * x + c
			if (a>0) {
				output += "Opens up \n";
			}
			if (a<0) {
				output += "Opens down \n";
			}
			//vertex equation? (-b/2a, c) 
			double x = (-b)/(2*a);
			double y = a*(x*x) +b*x + c; 
			output += "Vertex: (" + x +", " + y+ ") \n";
			output += "X-Intercept: " + quadform(a, b, c); 
			output += "Y-Intercept: ( " + c + ", 0)"; 
			return output;
	}
	//discriminant - provides coefficients of a quadratic equation in standard form.
		public static double discriminant(double a, double b, double c) {
			double answer = 0.0;
			answer = ((b*b)-4*a*c)/(2*a);
			return answer;	
		}
	//max - returns larger of two values. accepts two doubles and returns one double.
		public static double max(double a, double b) {
			if(a>b) {
				return a;
			}else {
				return b;
			}
		}
	//min - returns minimum of two integers. Accepts two integers and returns an int.
		public static double min(double a, double b) {
			if(a<b) {
				return a;
			}else
				return b;
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
	//round2 - rounds a double to two decimal places. Returns a double.
		public static double round2(double a) {
			a = (a*100)+0.5;
			//multiply by 100 then convert to int to get rid of decimals
			a = (int)a;
			a = (double)a/100;
			//convert back to double and divide by 100 to move two decimal spaces back
			return (a);
		}
		public static String quadform(double a, double b, double c) {; //x^2 + b*x = -c/a 
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
				return round2(min(root1, root2)) + " and " + round2(max(root1, root2));
	} //ordering the roots smallest to largest & rounding 

}


