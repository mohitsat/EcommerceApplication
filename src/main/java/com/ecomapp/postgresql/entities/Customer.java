package com.ecomapp.postgresql.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	private String customer_id;
	
	private String customer_name;
	
	// first_name, last_name, contact_details
}
