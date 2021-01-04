package com.ecomapp.postgresql.dao;

import org.springframework.data.repository.CrudRepository;

import com.ecomapp.postgresql.entities.Orders;

public interface OrdersDAO extends CrudRepository<Orders, Integer>{

}
