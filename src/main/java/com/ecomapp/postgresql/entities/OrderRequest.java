/**
 * 
 */
package com.ecomapp.postgresql.entities;

import lombok.Data;

/**
 * @author mohit
 *
 */
@Data
public class OrderRequest {
	
	private OrderItems[] items;
    
	private Customer customer;
	
	private Address address;
	
	private String shipping_method;
	
	private PaymentDetails payment;
	
	private String order_status;

}
