package tao.phys.inventory.objects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class Inventory {
//	This HashMap is effectively the inventory while the code is running.
	protected static HashMap<String, Product> inventory = new HashMap<String, Product>();
	
//	Allows user to add a new product by creating a new instance
//	of the Product class, initialized with relevant info.
	public static void addNewProduct(String name, String id, double price, double amount){
		Product thing = new Product(name, id, price, amount);	
		inventory.put(name, thing);
		return;
	}
//	Allows user to edit a product one at a time.
	public static void editProduct(String product, String edit, String newValue, boolean doneCheck){
		
		switch (edit) {
		case "ID":
			inventory.get(product).changeId(newValue);
			break;
		case "amount":
			inventory.get(product).changeAmount(Double.parseDouble(newValue));
			break;
		case "price":
			inventory.get(product).changePrice(Double.parseDouble(newValue));
			break;
		default:
			System.out.println("That was not a valid option. Options: 'ID', 'amount', 'price', 'done'");
			break;
		}
		return;
	}
//	removes a product
	public static void removeProduct(String product){
		inventory.remove(product);
	}
	
	public static double totalValue(){
		Set<String> key = inventory.keySet();
		Iterator<String> keyIterator = key.iterator();
		double total = 0;
		
		while(keyIterator.hasNext()){
			String product = keyIterator.next();
			total += inventory.get(product).getAmount() * inventory.get(product).getPrice();
		}
		return total;
	}
}

