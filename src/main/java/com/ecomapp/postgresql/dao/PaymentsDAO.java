package com.ecomapp.postgresql.dao;

import com.ecomapp.postgresql.entities.Payments;
import org.springframework.data.repository.CrudRepository;

public interface PaymentsDAO extends CrudRepository<Payments, Integer>{

}
