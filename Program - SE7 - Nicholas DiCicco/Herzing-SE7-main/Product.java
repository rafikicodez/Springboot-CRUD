package application;

import java.util.Objects;

public class Product {
	
	// object attributes
	private String name, sku;
	private int ID, quantity;
	private double price;
	
	
	
	// constructor default
	public Product() {
		this.setID(0);
		this.setName("Empty");
		this.setSku("None");
		this.setQuantity(0);
		this.setPrice(0.0);
	}//end default constructor

	
	// constructor
	public Product(String name, String sku, int quantity, double price) {
		this.setID(0);
		this.setName(name);
		this.setSku(sku);
		this.setQuantity(quantity);
		this.setPrice(price);
	}//end constructor
	
	
	// constructor
	public Product(int ID, String name, String sku, int quantity, double price) {
		this.setID(ID);
		this.setName(name);
		this.setSku(sku);
		this.setQuantity(quantity);
		this.setPrice(price);
	}//end constructor
	

	
	// object equals
	public boolean equalsID(int id) {
		boolean result = false;
		if (getID() == id) {result = true;}
		return result;
	}//end method equals
	
	
	
	// return id
	public int getID() {
		return this.ID;
	}//end method getID

	
	
	// return name
	public String getName() {
		return this.name;
	}//end method getName

	
	
	// return sku
	public String getSku() {
		return this.sku;
	}//end method getSku

	
	
	// return quantity
	public int getQuantity() {
		return this.quantity;
	}//end method getQuantity


	
	// return price
	public double getPrice() {
		return this.price;
	}//end method getPrice

	

	// update id
	public void setID(int id) {
		this.ID = id;
	}//end method setID

	

	// update name
	public void setName(String name) {
		this.name = name;
	}//end method setName

	

	// update sku
	public void setSku(String sku) {
		this.sku = sku;
	}//end method setSku

	

	// update quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}//end method setQuantity

	

	// update price
	public void setPrice(Double price) {
		this.price = price;
	}//end method setPrice


	
	@Override
	public boolean equals(final Object o) {
		if (this == o) {return true;}//end IF condition
		if (o == null) {return false;}//end IF condition
		if (getClass() != o.getClass()) {return false;}//end IF condition
		Product product = (Product) o;
		return Objects.equals(ID, product.ID) 
				&& Objects.equals(name, product.name)
				&& Objects.equals(sku, product.sku)
				&& Objects.equals(quantity, product.quantity)
				&& Objects.equals(price, product.price);
	}//end method equals

	


}//end class Product
