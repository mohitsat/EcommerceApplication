package com.ecomapp.postgresql.entities;

import lombok.Data;

@Data
public class PaymentDetails {
	
	private String payment_method;
	private String address1;
	private String address2;
	private String city;
	private String state_name;
	private int zipcode;
}
