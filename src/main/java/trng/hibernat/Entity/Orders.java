package trng.hibernat.Entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="Orders")

@Data
public class Orders {
	@Id
	@GeneratedValue
	@Column(name="order_id")
	private int orderID;
	
	@Column(name="customer_id_fk")
	private int customerId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="invoice_creation_date")
	private Date invoiceCreationDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="delivery_date")
	private Date deliveryDueDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="payment_due_date")
	private Date paymentDueDate;
	
	@Column(name="message")
	private String customMessage;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="order_id_fk")
	private List<OrderProducts> op;

	public Orders() {
		super();
	}
	
	public Orders(int orderID) {
		super();
		this.orderID = orderID;
	}
	
	public Orders(int orderID, Date invoiceCreationDate, Date deliveryDueDate, Date paymentDueDate,
			String customMessage) {
		super();
		this.orderID = orderID;
		this.invoiceCreationDate = invoiceCreationDate;
		this.deliveryDueDate = deliveryDueDate;
		this.paymentDueDate = paymentDueDate;
		this.customMessage = customMessage;
	}

	public Orders(int orderID, int customerID, Date invoiceCreationDate, Date deliveryDueDate, Date paymentDueDate,
			String customMessage, List<OrderProducts> op) {
		super();
		this.orderID = orderID;
		this.customerId = customerID;
		this.invoiceCreationDate = invoiceCreationDate;
		this.deliveryDueDate = deliveryDueDate;
		this.paymentDueDate = paymentDueDate;
		this.customMessage = customMessage;
		this.op = op;
	}

}