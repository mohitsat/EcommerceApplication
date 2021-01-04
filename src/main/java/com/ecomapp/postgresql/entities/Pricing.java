package com.ecomapp.postgresql.entities;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class Pricing implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	
	private BigDecimal order_sub_total;
	private BigDecimal order_tax;
	private BigDecimal order_shipping_charges;
	private BigDecimal order_total;
	
	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_pricing_order"))
	private Orders order;
}
