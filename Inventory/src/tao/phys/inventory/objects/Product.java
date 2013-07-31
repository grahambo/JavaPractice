package tao.phys.inventory.objects;

public class Product {
	private String id;
	private double price;
	private double amount;
	private String name;
	
	public Product(String name, String id, double price, double amount) {
		this.id = id;
		this.price = price;
		this.amount = amount;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void changeId(String id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void changePrice(double price) {
		this.price = price;
	}
	public double getAmount() {
		return amount;
	}
	public void changeAmount(double amount){
		this.amount = amount;
	}
	public void add(double i){
		this.amount += i;
	}
	public void sold(int i){
		this.amount -= i;
	}
	public String getName(){
		return name;
	}
}
