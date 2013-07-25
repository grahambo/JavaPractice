import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Calculator {

	public static void main(String[] args) {
		String op;
		String[] validop = {"+", "-", "*", "/"};
		double num1 = 0d, num2=0d, answer=0d;
		boolean error = true;
		
		do{
			try {
				num1 = Double.valueOf(getInput("First number? "));
				error = false;
			} catch (NumberFormatException e) {
				System.out.println("That is not a valid number.");
				error = true;
			}
		} while (error == true);
		
		do{
			op = getInput("What operation? (- + * /)");
		
			if(Arrays.asList(validop).contains(op)){
				error = false;
			}
			else{
				System.out.println("That is not a valid operator.");
				error = true;
			}
		} while (error == true);
		
		do{
			try {
				num2 = Double.valueOf(getInput("Second number? "));
				error = false;
			} catch (NumberFormatException e) {
				System.out.println("That is not a valid number.");
				error = true;
			}
		} while (error == true);
		
		switch (op) {
		case "+":
			answer = num1 + num2;
			break;
		case "-":
			answer = num1 - num2;
			break;
		case "*":
			answer = num1 * num2;
			break;
		case "/":
			answer = num1 / num2;
			break;
		default:
			System.out.println("An error has occured.");
			break;
		}
		
		System.out.println("The answer is: " + String.valueOf(answer));
		
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
