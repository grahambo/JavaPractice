package tao.phys.inventory.lib;

import java.util.HashMap;


public class Inventory {
//	This HashMap is effectively the inventory while the code is running.
	protected static HashMap<String, Product> inventory = new HashMap<String, Product>();
	
//	Allows user to add a new product by creating a new instance
//	of the Product class, initialized with relevant info.
	public static void addNewProduct(){

		String name = null;
		String id = null;
		int amount = 0;
		double price = 0;

		try {
			name = InputHelper.getInput("Product name: ");
			id = InputHelper.getInput("Product id: ");
			amount = Integer.parseInt(InputHelper.getInput("Product amount: "));
			price = Double.parseDouble(InputHelper.getInput("Product price: "));
		} catch (NumberFormatException e) {
			System.out.println("That value is not allowed.");
		}
		
		Product thing = new Product(name, id, price, amount);
		
		inventory.put(name, thing);
		
		return;
	}
//	Allows user to edit a product one at a time.
	public static void editProduct(){
		String edit, newValue, product = null;
		boolean check = false;
		
		product = InputHelper.getInput("Which product would you like to edit?");
		
		System.out.println("--"+product+"--");
		System.out.println("Current ID:\t"+inventory.get(product).getId()+"\t"
				+"Current amount:\t"+inventory.get(product).getAmount()+"\t"
				+"Current price:\t"+inventory.get(product).getPrice());
		do{
			edit = InputHelper.getInput("What would you like to change? (ID, amount, price) Type 'done' to return.");
			
			switch (edit) {
			case "ID":
				newValue = InputHelper.getInput("New value: ");
				inventory.get(product).changeId(newValue);
				break;
			case "amount":
				newValue = InputHelper.getInput("New value: ");
				inventory.get(product).changeAmount(Double.parseDouble(newValue));
				break;
			case "price":
				newValue = InputHelper.getInput("New value: ");
				inventory.get(product).changePrice(Double.parseDouble(newValue));
				break;
			case "done":
				check = true;
			default:
				System.out.println("That was not a valid option. Options: 'ID', 'amount', 'price', 'done'");
				break;
			}
		}while(!check);
		
		return;
		
	}
}

