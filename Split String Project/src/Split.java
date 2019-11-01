//Grace Shang
//10/21/19
//4 Period
//uses method split string 
public class Split {		 
	public static void main(String[] args) {
		//String[] outputArray = "I like apples!".split(" ");
		//System.out.println(Arrays.toString(outputArray));
		//String[] outputArray2 = "I really like really red apples!".split("really");
		//System.out.println(Arrays.toString(outputArray2));
		//String[] outputArray3 = "I really like really red apples!".split(" really ");
		//System.out.println(Arrays.toString(outputArray3));
		//String[] outputArray4 = "really I really like really red apples!".split("really");
		//System.out.println(Arrays.toString(outputArray4));
		
	//Part 1
		System.out.println(part1("bread")); //not sandwich
		System.out.println(part1("breadham")); //not sandwich
		System.out.println(part1("mayobread"));
		System.out.println(part1("breadmayobread"));
		System.out.println(part1("breadbread"));
		System.out.println(part1("breadmayobreadham")); //need to take out ham at the end
		System.out.println(part1("applespineapplesbreadlettucetomatobaconmayohambreadcheese")); //kills my eyes
		System.out.println(part2("apples pineapples bread lettuce tomato bacon mayo ham bread cheese"));
	}
	
	public static String part1 (String sandwich) {
		String[] sandwichParts = sandwich.split("bread"); //takes out bread
		int breadIndex = sandwich.indexOf("bread");
		//name of the string (sandwich) and then what to look for within it (looking for bread)
			if(breadIndex != -1) {
				String parts = sandwich.substring(breadIndex + 5); //finds bread and cuts it out with everything before it 
				breadIndex = parts.indexOf("bread"); //finds the second bread 
				if(breadIndex > 0) {		
					return sandwichParts[1]; //go to array sandwichParts and then returns index one which is the filling
				}else if(breadIndex == 0) {
					return "not a sandwich! this is just bread.";
				}else {
					return "not a sandwich! you are missing some bread.";
				}
			}else {
				return "not a sandwich! you are missing some bread.";
			}
	}
	
	//part 2	
	
	public static String part2 (String ingredients) { 
		String[] spaces = ingredients.split(" "); //splits at the spaces which so far does nothing
//		System.out.println(Arrays.toString(spaces));
		String noSpace = ""; 
		for(int i = 0; i < spaces.length; i++) { //spaces.length is the length of the whole array 
			noSpace += spaces[i]; //passes through every element in the array and adds to string noSpace
		} // like list[0] + list[1] + list[3] etc etc
		String insides = part1(noSpace); //passes it through the part one, returns 
		return insides; //lol like intestines
		
	}
}

