package tao.phys.inventory.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import tao.phys.inventory.objects.Inventory;

public class OutputHelper extends Inventory {
	
//	saves the inventory to a file
	public static void saveToFile(String filename){
		
		File file = new File(filename);
		
		try {
			FileUtils.writeStringToFile(file, "Name\t"+"ID\t"+"Amount\t"+"Price\t", false);
			
			Set<String> key = inventory.keySet();
			Iterator<String> keyIterator = key.iterator();
			while(keyIterator.hasNext()){
				String product = keyIterator.next();
				FileUtils.writeStringToFile(file, ("\n"+inventory.get(product).getName()+"\t"
						+inventory.get(product).getId()+"\t"
						+inventory.get(product).getAmount()+"\t"
						+inventory.get(product).getPrice()), true);
			}
						
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
	
//	Lists options for manipulating the inventory
public static void Options(){
		System.out.println("addnew: Add a new product");
		System.out.println("list: Lists all products");
		System.out.println("edit 'product': Edit a product");
		System.out.println("save: Save this inventory to a file");
		System.out.println("open: Opens an inventory file");
		System.out.println("remove: Remove a product from inventory");
		System.out.println("total value: Calculates total value of inventory");
		
		System.out.println("exit: Exits program");
	}
}
