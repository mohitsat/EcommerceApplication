package com.ecomapp.postgresql.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Shipping implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	
	private String shipping_method;
	private String address1;
	private String address2;
	private String city;
	private String state_name;
	private int zipcode;
//	private Address address;
	
	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_shipping_order"))
	private Orders order;
	
}
