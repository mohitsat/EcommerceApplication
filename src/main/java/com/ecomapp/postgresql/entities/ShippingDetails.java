package com.ecomapp.postgresql.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class ShippingDetails implements Serializable {
	
//	private Shipping shipment;
//	private String shipping_method;
//	private String address1;
//	private String address2;
//	private String city;
//	private String state_name;
//	private int zipcode;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "order_details_id")
	private OrderDetails orderDetails;
	
	@OneToOne
	@JoinColumn(name = "shipping_id")
	private Shipping shipment;
}
