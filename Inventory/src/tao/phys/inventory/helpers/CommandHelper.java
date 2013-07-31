package tao.phys.inventory.helpers;

import tao.phys.inventory.objects.Inventory;

public class CommandHelper extends Inventory {

//	This handles all of the cases for commands from the top level command line
	public static void doCommand() {
		boolean exit = false;
//		POSSIBLE CASES
//		options 	-- shows options
//		addnew 		-- adds a new product
//		list 		-- lists all products in inventry
//		edit 		-- allows user to edit product values
//		save		-- saves to file
//						(Formats with a one line header and then
//						 name 	id	amount	price)
//		open 		-- opens a file and puts data into internal inventory HashMap
//						(Must be formated like the save file)
//		remove 		-- allows user to remove a product completely
//		total value	-- calculates dollar value of entire inventory
//		exit 		-- exits the program
		do{
			InputHelper.getCommand();
			switch (InputHelper.input) {
			case "options":
				OutputHelper.Options();
				System.out.println();
				break;
			case "addnew":
			{
				String name = null;
				String id = null;
				double price = 0;
				double amount = 0;
				
				try {
					name = InputHelper.getInput("Product name: ");
					id = InputHelper.getInput("Product id: ");
					amount = Integer.parseInt(InputHelper.getInput("Product amount: "));
					price = Double.parseDouble(InputHelper.getInput("Product price: "));
				} catch (NumberFormatException e) {
					System.out.println("That value is not allowed.");
				}
				Inventory.addNewProduct(name, id, price, amount);
				break;
			}
			case "list":
				OutputHelper.productList();
				break;
			case "edit": 
			{
				String product = InputHelper.getInput("Which product would you like to edit?");
				System.out.println("--"+product+"--");
				System.out.println("Current ID:\t"+inventory.get(product).getId()+"\t"
						+"amount:\t"+inventory.get(product).getAmount()+"\t"
						+"price:\t"+inventory.get(product).getPrice());
				boolean checkDone = false;
					do {
						String edit = InputHelper
								.getInput("Input field to change and new value ('done' to go back)");
						if (edit.equals("done")){
							break;
						} else {
							String newValue = edit.split(" ")[1];
							edit = edit.split(" ")[0];
							Inventory.editProduct(product, edit, newValue,
									checkDone);
						}
					} while (!checkDone);
				break;
			}
			case "save":
				String savefile = InputHelper.getInput("Input savefile name: ");
				OutputHelper.saveToFile(savefile);
				break;
			case "open":
				String openfile = InputHelper.getInput("Input filename: ");
				InputHelper.openFile(openfile);
				break;
			case "remove":
				Inventory.removeProduct(InputHelper.getInput("Input product to remove: "));
				break;
			case "total value":
				System.out.println("Total inventory value:\t$"+Inventory.totalValue());
				break;
			case "exit":
				exit = true;
				break;
			default:
				System.out.println("That is not a valid command. Type 'options' for a list of commands.");
				break;
			}
		}while(!exit);
	}

}
