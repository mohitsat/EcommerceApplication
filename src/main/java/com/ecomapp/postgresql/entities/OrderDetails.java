package com.ecomapp.postgresql.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	
	@ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_order_customer"))
	private Customer customer;
	
	private String order_status;
	
//	@GetMapping("/orderdetails")
//	public List<Object[]> retrieveOrders() {
//		//return orderDetailsDAO.findAll();
//		return orderDetailsDAO.findAllOrders();
//	}
	
//	@GetMapping("/orderdetails/{id}")
//	public Object[] retrieveOrderDetails(@PathVariable("id") int id) throws NotFoundException {
//		Object[] order = orderDetailsDAO.findOrder(id);
//		
//		if (order.length == 0)
//			throw new NotFoundException("id-" + id);
//		
//        return order;
//	}
	
//	@PostMapping("/orderdetails")
//	public ResponseEntity<Object> createOrder(@RequestBody OrderRequest request) {
//		
//		OrderDetails order = new OrderDetails();
//		order.setCustomer(request.getCustomer());
//		order.setOrder_status(request.getOrder_status());
//	
//		OrderDetails savedOrder = orderDetailsDAO.save(order);
//
//		// Save order id and quantity
//		OrderItemQuantityId orderItemQuantityId = new OrderItemQuantityId();
//		orderItemQuantityId.setOrderDetails(savedOrder);
//		
//		OrderItemQuantity orderItemQuantity = null;
//		Optional<Inventory> invt = null;
//		BigDecimal priceVal = new BigDecimal(0.0);
//		BigDecimal subTotalPrice = new BigDecimal(0.0);
//		for (OrderItems item: request.getItems()) {
//			invt = inventoryDAO.findById(item.getId());
//			priceVal = invt.get().getPrice();
//			orderItemQuantityId.setInventory(invt.get());
//			orderItemQuantity = new OrderItemQuantity();
//			orderItemQuantity.setId(orderItemQuantityId);
//			orderItemQuantity.setItem_quantity(item.getQuantity());
//			priceVal = priceVal.multiply(BigDecimal.valueOf(item.getQuantity()));
//			subTotalPrice = subTotalPrice.add(priceVal);
//			
//			orderItemQuantityDAO.save(orderItemQuantity);
//		}
		
//		Pricing pricing = new Pricing();
//		pricing.setOrder_sub_total(subTotalPrice);
//		BigDecimal order_tax = subTotalPrice.multiply(BigDecimal.valueOf(0.1));
//		pricing.setOrder_tax(order_tax);
//		BigDecimal order_shipping_charges = subTotalPrice.multiply(BigDecimal.valueOf(0.05));
//		pricing.setOrder_shipping_charges(order_shipping_charges);
//		BigDecimal order_total = subTotalPrice.add(order_tax).add(order_shipping_charges);
//		pricing.setOrder_total(order_total);
//		pricing.setOrderDetails(order);
//		pricingDAO.save(pricing);

		
//		Shipping shipment = new Shipping();
//		shipment.setAddress1(request.getAddress().getAddress1());
//		shipment.setAddress2(request.getAddress().getAddress2());
//		shipment.setCity(request.getAddress().getCity());
//		shipment.setState_name(request.getAddress().getState_name());
//		shipment.setZipcode(request.getAddress().getZipcode());
//		shipment.setShipping_method(request.getShipping_method());
//		shipment.setOrderDetails(order);
//		shippingDAO.save(shipment);
		
		
//		ShippingDetails shipmentdetails = new ShippingDetails();
//		shipmentdetails.setOrderDetails(order);
//		shipmentdetails.setShipment(shipment);
//		shippingDetailsDAO.save(shipmentdetails);
		
//		Payments payment = new Payments();
//		payment.setOrder(order);
//		payment.setPayment_time(LocalDateTime.now());
//		payment.setPayment_method(request.getPayment().getPayment_method());
//		payment.setAddress1(request.getPayment().getAddress1());
//		payment.setAddress2(request.getPayment().getAddress2());
//		payment.setCity(request.getPayment().getCity());
//		payment.setState_name(request.getPayment().getState_name());
//		payment.setZipcode(request.getPayment().getZipcode());
//		paymentsDAO.save(payment);
		
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(savedOrder.getId()).toUri();
//		
//		return ResponseEntity.created(location).build();
//	}
	
//	@DeleteMapping("/orderdetails/{id}")
//	public void deleteOrder(@PathVariable int id) {
//		orderDetailsDAO.deleteById(id);
//	}
}
