package hourglass;
//Grace Shang
//Period 4
//Current count: one print line 
public class Hourglass {
	public static void main(String[]args ) {
		String output = "";
		output += "|";
		for(int quote=1; quote<=10; quote++) {
			output += "\"";			
		}output += "|\n"; 
				//\n for a new line here, end of the top row
		for(int line=1; line<=4; line++) {
			for(int space=0; space<line; space++) {
				output += " ";
			}output += "\\";
			for(int colon=1; colon<=-2*line+10; colon++) {
				output += ":";
			}output += "/\n";		
				//\n for another new line here, every "/" is followed by new line 
				//the top half of the hour glass 	
			}	
		output += "     ||\n"; //placeholder code for now 
		for(int line=4; line>=1; line--) { //only changed part is the line space order
			for(int space=0; space<line; space++) {
				output += " ";
			}output += "/";
			for(int colon=1; colon<=-2*line+10; colon++) {
				output += ":";
			}output += "\\\n";		
			}	
		output += "|";
		for(int quote2=1; quote2<=10; quote2++) {
			output += "\"";			
		}output += "|\n"; 
		System.out.println(output);
	}
}

