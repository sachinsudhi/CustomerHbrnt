package trng.hibernat.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Address{
	@Column(name = "bill_street")
	private String billingStreet;
	
	@Column(name = "bill_city")
	private String billingCity;
	
	@Column(name = "bill_state")
	private String billingState;
	
	@Column(name = "bill_zip")
	private String billingZIP;
	
	@Column(name = "bill_country")
	private String billingCountry;
	
	@Column(name = "ship_street")
	private String shippingStreet;
	@Column(name = "ship_city")
	private String shippingCity;
	
	@Column(name = "ship_state")
	private String shippingState;
	
	@Column(name = "ship_zip")
	private String shippingZIP;
	
	@Column(name = "ship_country")
	private String shippingCountry;
	
	public Address() {
		super();
	}
	
	public Address(String billingStreet, String billingCity, String billingState, String billingZIP,
			String billingCountry) {
		super();
		this.billingStreet = billingStreet;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingZIP = billingZIP;
		this.billingCountry = billingCountry;
	}

	public Address(String billingStreet, String billingCity, String billingState, String billingZIP,
			String billingCountry, String shippingStreet, String shippingCity, String shippingState, String shippingZIP,
			String shippingCountry) {
		super();
		this.billingStreet = billingStreet;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingZIP = billingZIP;
		this.billingCountry = billingCountry;
		this.shippingStreet = shippingStreet;
		this.shippingCity = shippingCity;
		this.shippingState = shippingState;
		this.shippingZIP = shippingZIP;
		this.shippingCountry = shippingCountry;
	}

	
}