package com.ecomapp.postgresql.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class OrderItemQuantityId implements Serializable {
	
	@ManyToOne
    @JoinColumn(name = "inventory_id")
	private Inventory inventory;
    
	@ManyToOne
    @JoinColumn(name = "order_details_id")
    private OrderDetails orderDetails;

}
