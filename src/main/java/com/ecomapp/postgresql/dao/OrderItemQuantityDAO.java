package com.ecomapp.postgresql.dao;

import org.springframework.data.repository.CrudRepository;

import com.ecomapp.postgresql.entities.OrderItemQuantity;
import com.ecomapp.postgresql.entities.OrderItemQuantityId;

public interface OrderItemQuantityDAO extends CrudRepository<OrderItemQuantity, OrderItemQuantityId> {

}
