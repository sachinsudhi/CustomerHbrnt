package trng.hibernat.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="OrderProducts")

@Data
public class OrderProducts {
	@Id
	@GeneratedValue
	@Column(name="op_id")
	private int productOrderID;
	
	@Column(name="order_id_fk")
	private int orderId;
	
	@Column(name="product_id")
	private int productID;
	
	@Column(name="Quantity")
	private int quantity;
	
	@Column(name="Price")
	private double price;

	public OrderProducts() {
		super();
	}
	
	public OrderProducts( int productID, int quantity, double price) {
		super();
		this.productID = productID;
		this.quantity = quantity;
		this.price=price;
	}
	
	public OrderProducts(int productOrderID, int orderID, int productID, int quantity) {
		super();
		this.productOrderID = productOrderID;
		this.orderId = orderID;
		this.productID = productID;
		this.quantity = quantity;
	}

}