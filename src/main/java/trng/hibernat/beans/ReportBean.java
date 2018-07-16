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
	String lastName;
	
	public ReportBean(int customerID, String firstName, String lastName) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
	}	
	
	
}
