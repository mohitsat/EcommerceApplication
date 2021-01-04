package com.ecomapp.postgresql.entities;

import lombok.Data;

@Data
public class Billing {
	
	private Address address;
	
	//Think about a way of handling multiple billing addresses for split paid orders. Maybe, make the address after the payment method has been decided properly.
}
