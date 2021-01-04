package com.ecomapp.postgresql.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import lombok.Data;

@Data
@Entity
public class Payments {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	
	private String payment_method;
	private LocalDateTime payment_time;
	private String address1;
	private String address2;
	private String city;
	private String state_name;
	private int zipcode;
	
	@Column(columnDefinition="serial")
	@Generated(GenerationTime.INSERT)
	private int confirmation_number;
	
	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_payments_order"))
	private Orders order;
}
