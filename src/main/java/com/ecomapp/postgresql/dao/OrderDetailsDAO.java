package com.ecomapp.postgresql.dao;

import com.ecomapp.postgresql.entities.OrderDetails;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderDetailsDAO extends CrudRepository<OrderDetails, Integer>{
	
	@Query(value = "select a.id, a.order_status, a.customer_customer_id, b.confirmation_number, b.payment_method, b.payment_time, p.order_shipping_charges, p.order_sub_total, p.order_tax, p.order_total, c.address1, c.address2, c.city, c.state_name, c.zipcode, c.shipping_method from order_details a join payments b on a.id=b.order_details_id join pricing p on a.id=p.order_details_id join shipping c on a.id=c.order_details_id", nativeQuery = true)
	List<Object[]> findAllOrders();
	
	@Query(value = "select a.id, a.order_status, a.customer_customer_id, b.confirmation_number, b.payment_method, b.payment_time, p.order_shipping_charges, p.order_sub_total, p.order_tax, p.order_total, c.address1, c.address2, c.city, c.state_name, c.zipcode, c.shipping_method from order_details a join payments b on a.id=b.order_details_id join pricing p on a.id=p.order_details_id join shipping c on a.id=c.order_details_id where a.id = :id", nativeQuery = true)
	Object[] findOrder(@Param("id") int id);
}
