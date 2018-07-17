package trng.hibernat.beans;

import java.io.Serializable;

import lombok.Data;


@Data
public class ReportBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int customerID;
	String firstName;
	int quantity;
	double price;
	public ReportBean(int customerID, String firstName, int quantity, double price) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.quantity = quantity;
		this.price = price;
	}
	
	
}
