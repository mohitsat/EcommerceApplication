package com.ecomapp.postgresql.dao;

import com.ecomapp.postgresql.entities.Shipping;
import org.springframework.data.repository.CrudRepository;

public interface ShippingDAO extends CrudRepository<Shipping, Integer>{

}
