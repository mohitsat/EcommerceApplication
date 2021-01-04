package com.ecomapp.postgresql.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class OrderItemQuantity {
	
	@EmbeddedId
	private OrderItemQuantityId id;
	
	private int item_quantity;
	
}
