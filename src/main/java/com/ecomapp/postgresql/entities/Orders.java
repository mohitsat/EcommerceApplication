package com.ecomapp.postgresql.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	
	private String order_status;
	private String customer_id;
	
	@Column(columnDefinition="serial")
	@Generated(GenerationTime.INSERT)
	private int confirmation_number;
	private String payment_method;
	private LocalDateTime payment_time;
	
	private BigDecimal order_sub_total;
	private BigDecimal order_tax;
	private BigDecimal order_shipping_charges;
	private BigDecimal order_total;
	
	private String shipping_method;
	private String address1;
	private String address2;
	private String city;
	private String state_name;
	private int zipcode;
}
