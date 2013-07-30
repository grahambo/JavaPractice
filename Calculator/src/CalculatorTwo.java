import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class CalculatorTwo {

	public static void main(String[] args) {
		String input = " ";
		String[] nums = null;
		
		double answer = 0d;
		
		for (boolean exit=false; exit==false;input = getInput(" ")) {
			switch (input) {
			case "exit":
				exit = true;
				break;
			default:
	
				try {
					if (input.contains("+")) {
						nums = input.split("\\+");
						answer = Double.valueOf(nums[0]) + Double.valueOf(nums[1]);
						System.out.println(answer);
					} else if (input.contains("-")) {
						nums = input.split("-");
						answer = Double.valueOf(nums[0]) - Double.valueOf(nums[1]);
						System.out.println(answer);
					} else if (input.contains("*")) {
						nums = input.split("\\*");
						answer = Double.valueOf(nums[0]) * Double.valueOf(nums[1]);
						System.out.println(answer);
					} else if (input.contains("/")) {
						nums = input.split("/");
						answer = Double.valueOf(nums[0]) / Double.valueOf(nums[1]);
						System.out.println(answer);
					}
				} catch (NumberFormatException e) {
					System.out.println("That is not a valid number. Try again.");
				} catch (ArrayIndexOutOfBoundsException ee){
					System.out.println("Expression incomplete. Try again.");
				}
				break;
			}
		}
	
		
	}

private static String getInput(String prompt){
	BufferedReader stdin = new BufferedReader(
			new InputStreamReader(System.in));
	
	System.out.print(prompt);
	System.out.flush();
	try {
		return stdin.readLine();
	} catch (IOException e) {
		return "Error: " + e.getMessage();
	}
}
}


