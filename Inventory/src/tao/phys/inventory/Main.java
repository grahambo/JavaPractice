package tao.phys.inventory;

import tao.phys.inventory.lib.InputHelper;
import tao.phys.inventory.lib.Inventory;
import tao.phys.inventory.lib.OutputHelper;


public class Main {
	public static void main(String args[]){
		boolean exit = false;
		InputHelper.getCommand();

		do{
			switch (InputHelper.input) {
			case "options":
				OutputHelper.Options();
				System.out.println();
				InputHelper.getCommand();
				break;
			case "addnew":
				Inventory.addNewProduct();
				InputHelper.getCommand();
				break;
			case "list":
				OutputHelper.productList();
				InputHelper.getCommand();
				break;
			case "edit":
				Inventory.editProduct();
				InputHelper.getCommand();
				break;
			case "save":
				OutputHelper.saveToFile();
				InputHelper.getCommand();
				break;
			case "exit":
				exit = true;
				break;
			default:
				System.out.println("That is not a valid command. Type 'options' for a list of commands.");
				InputHelper.getCommand();
				break;
			}
		}while(!exit);
	}

}
