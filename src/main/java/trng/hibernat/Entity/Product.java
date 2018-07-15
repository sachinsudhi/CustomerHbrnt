package trng.hibernat.Entity;

import lombok.Data;

@Data
public class Product {
	private int productID;
	private String name;
	private String description;
	private double price;

	public Product() {
		super();
	}
	
	public Product(int productId, String name, double price) {
		super();
		this.productID=productId;
		this.name = name;
		this.price = price;
	}
	public Product(int productID, String name, String description, double price) {
		super();
		this.productID = productID;
		this.name = name;
		this.description = description;
		this.price = price;
	}

}