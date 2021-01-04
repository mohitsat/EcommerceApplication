package com.ecomapp.postgresql.dao;

import com.ecomapp.postgresql.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface CustomerDAO extends CrudRepository<Customer, String> {
	
}
