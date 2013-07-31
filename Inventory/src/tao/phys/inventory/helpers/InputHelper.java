package tao.phys.inventory.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.io.FileUtils;

import tao.phys.inventory.objects.Inventory;
import tao.phys.inventory.objects.Product;

public class InputHelper extends Inventory {
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
//	opens the saved file and inputs the values into internal inventory HashMap
	public static void openFile(String filename){
		File file = new File(filename);
		
		String name=null, id=null;
		double amount=0, price=0;
		
			try {
				List<String> fileList = FileUtils.readLines(file);
				fileList.remove(0);
				
				ListIterator<String> listIter = fileList.listIterator();
				while(listIter.hasNext()){
					String currentLine = listIter.next();
					name = currentLine.split("\t")[0];
					id = currentLine.split("\t")[1];
					amount = Double.parseDouble(currentLine.split("\t")[2]);
					price = Double.parseDouble(currentLine.split("\t")[3]);
					
					inventory.put(name, new Product(name, id, price, amount));
				}
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} 
				
	}
}
