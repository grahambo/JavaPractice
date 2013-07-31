package tao.phys.inventory.lib;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Set;

public class OutputHelper extends Inventory {
//	saves the inventory to a file
	public static void saveToFile(){
		String filename = InputHelper.getInput("Input savefile name: ");
		Writer writer = null;
		
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(filename)));
			writer.write("Name\t"+"ID\t"+"Amount\t"+"Price\t");
			
			Set<String> key = inventory.keySet();
			Iterator<String> keyIterator = key.iterator();
			while(keyIterator.hasNext()){
				String product = keyIterator.next();
				writer.write((inventory.get(product).getName()+"\t"
						+inventory.get(product).getId()+"\t"
						+inventory.get(product).getAmount()+"\t"
						+"$"+inventory.get(product).getPrice()));
			}
			
			writer.close();
			
			System.out.println("This inventory has been saved.");
		} catch (FileNotFoundException e) {
			System.out.println("Error: "+e.getMessage());
		} catch (IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
		return;

		
		
	}

//	Lists the current inventory for the user
	public static void productList(){
		System.out.println("Name\t"+"ID\t"+"Amount\t"+"Price\t");
		System.out.println();
		
		Set<String> key = Inventory.inventory.keySet();
		Iterator<String> keyIterator = key.iterator();
		while(keyIterator.hasNext()){
			String product = keyIterator.next();
			System.out.println(Inventory.inventory.get(product).getName()+"\t"
					+Inventory.inventory.get(product).getId()+"\t"
					+Inventory.inventory.get(product).getAmount()+"\t"
					+"$"+Inventory.inventory.get(product).getPrice());
		}
		return;
	}

	//	Lists available options for manipulating inventory.
	
//	Lists options for manipulating the inventory
public static void Options(){
		System.out.println("addnew: Add a new product");
		System.out.println("list: Lists all products");
		System.out.println("edit 'product': Edit a product");
		System.out.println("save: Save this inventory to a file");
		
		System.out.println("exit: Exits program");
	}
}
