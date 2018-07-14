package trng.hibernat.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

import lombok.Data;

@Entity
@Table(name="Customers", uniqueConstraints= { 
		@UniqueConstraint(columnNames="first_name") ,@UniqueConstraint(columnNames="last_name")		
})

@Data
public final class Customer{
	@Id
	@GeneratedValue
	@Column(name="customer_id")
	private int customerID;
	
	@Column(name="title")
	private String title;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="suffix")
	private String suffix;
	
	@Email(message="Please Enter a valid email")
	private String email;
	
	@Column(name="company")
	private String company;
	
	@Column(name="display_name")
	private String displayName;
	
	@Column(name="print_on_check")
	private String printOnCheckAs;
	
	@Column(name="other_details")
	private String otherDetails;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	@JoinColumn(name="customer_id_fk")
	private List<Order> orders;

	public Customer() {
		super();
	}
	
	public Customer(int customerID, String title, String firstName, String middleName, String lastName, String suffix,
			String email, String company, String displayName, String printOnCheckAs,  String otherDetails) {
		super();
		this.customerID = customerID;
		this.title = title;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.suffix = suffix;
		this.email = email;
		this.company = company;
		this.displayName = displayName;
		this.printOnCheckAs = printOnCheckAs;
		this.otherDetails = otherDetails;
	}


	public Customer(int customerID, String title, String firstName, String middleName, String lastName, String suffix,
			String email, String company, String displayName, String printOnCheckAs,  String otherDetails,
			List<Order> order) {
		super();
		this.customerID = customerID;
		this.title = title;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.suffix = suffix;
		this.email = email;
		this.company = company;
		this.displayName = displayName;
		this.printOnCheckAs = printOnCheckAs;
		this.otherDetails = otherDetails;
		this.orders = order;
	}

}