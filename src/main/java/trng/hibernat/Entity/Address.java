package trng.hibernat.Entity;

import lombok.Data;

@Data
public class Address{
	private String billingStreet;
	private String billingCity;
	private String billingState;
	private String billingZIP;
	private String billingCountry;
	private String shippingStreet;
	private String shippingCity;
	private String shippingState;
	private String shippingZIP;
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