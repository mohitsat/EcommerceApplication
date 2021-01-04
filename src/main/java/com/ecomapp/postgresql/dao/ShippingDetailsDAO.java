package com.ecomapp.postgresql.dao;

import com.ecomapp.postgresql.entities.ShippingDetails;
import org.springframework.data.repository.CrudRepository;

public interface ShippingDetailsDAO extends CrudRepository<ShippingDetails, Integer>{

}
