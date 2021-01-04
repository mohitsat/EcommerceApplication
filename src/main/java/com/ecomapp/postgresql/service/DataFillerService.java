package com.ecomapp.postgresql.service;

import com.ecomapp.postgresql.entities.Customer;
import com.ecomapp.postgresql.entities.Inventory;
import com.ecomapp.postgresql.entities.Orders;
import com.ecomapp.postgresql.entities.Shipping;
import com.ecomapp.postgresql.dao.CustomerDAO;
import com.ecomapp.postgresql.dao.InventoryDAO;
import com.ecomapp.postgresql.dao.OrdersDAO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

@Service
public class DataFillerService {
	private final CustomerDAO customerDAO;
	private final InventoryDAO inventoryDAO;
	public DataFillerService(InventoryDAO inventoryDAO, CustomerDAO customerDAO) {
        this.inventoryDAO = inventoryDAO;
        this.customerDAO = customerDAO;
    }
	@PostConstruct
    @Transactional
    public void fillData(){
     
		Customer pj = new Customer("mm@mm.com", "MM");
        Customer px = new Customer("rr@rr.com", "RR");
        customerDAO.save(pj);
        customerDAO.save(px);
        
        Inventory appleOrder = new Inventory(1,"Apple", new BigDecimal(2.00));
        Inventory bananaOrder = new Inventory(2, "Banana", new BigDecimal(5.00));
        Inventory orangeOrder = new Inventory(3, "Orange", new BigDecimal(7.00));
        
        inventoryDAO.save(appleOrder);
        inventoryDAO.save(bananaOrder);
        inventoryDAO.save(orangeOrder);
	}
}
