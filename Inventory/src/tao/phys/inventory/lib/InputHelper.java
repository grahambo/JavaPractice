package tao.phys.inventory.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHelper {
	public static String input;
	
//	Top level input request
	public static String getCommand() {
		input = InputHelper.getInput("What would you like to do? (Type 'options' for options)");
		return input;
	}
	
//	basic input reader
	public static String getInput(String prompt){
		BufferedReader stdin = new BufferedReader(
				new InputStreamReader(System.in));
		
		System.out.print(prompt);
		System.out.flush();
		
		try {
			return stdin.readLine();
		} catch (IOException e) {
			return "Error: "+ e.getMessage();
		}
	}
}
