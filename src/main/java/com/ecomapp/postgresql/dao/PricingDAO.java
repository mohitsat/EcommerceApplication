package com.ecomapp.postgresql.dao;

import com.ecomapp.postgresql.entities.Pricing;
import org.springframework.data.repository.CrudRepository;

public interface PricingDAO extends CrudRepository<Pricing, Integer>{

}
