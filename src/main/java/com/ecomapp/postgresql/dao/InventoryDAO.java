package com.ecomapp.postgresql.dao;

import org.springframework.data.repository.CrudRepository;

import com.ecomapp.postgresql.entities.Inventory;

public interface InventoryDAO extends CrudRepository<Inventory, Integer>{

}
