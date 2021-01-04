package com.ecomapp.postgresql.resources;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecomapp.postgresql.dao.InventoryDAO;
import com.ecomapp.postgresql.dao.OrdersDAO;
import com.ecomapp.postgresql.dao.PaymentsDAO;
import com.ecomapp.postgresql.dao.PricingDAO;
import com.ecomapp.postgresql.dao.ShippingDAO;
import com.ecomapp.postgresql.entities.Inventory;
import com.ecomapp.postgresql.entities.OrderItems;
import com.ecomapp.postgresql.entities.OrderRequest;
import com.ecomapp.postgresql.entities.Orders;
import com.ecomapp.postgresql.entities.Payments;
import com.ecomapp.postgresql.entities.Pricing;
import com.ecomapp.postgresql.entities.Shipping;

import javassist.NotFoundException;

@RestController
public class OrderResource {
	
	
	@Autowired
	private InventoryDAO inventoryDAO;
	
	@Autowired
	private ShippingDAO shippingDAO;
	
	@Autowired
	private PricingDAO pricingDAO;
	
	@Autowired
	private PaymentsDAO paymentsDAO;
	
	@Autowired
    private ApplicationContext context;
	
	@Autowired
    private OrdersDAO ordersDAO;
 
    public void initiateAppShutdown(int returnCode){
        SpringApplication.exit(context, () -> returnCode);
    }
 
    @RequestMapping("/shutdown")
    public void shutdown() {
        initiateAppShutdown(0);
    }//Can add more security here
	
	@GetMapping("/inventory")
	public Iterable<Inventory> retrieveInventory() {
		return inventoryDAO.findAll();
	}
	
	@GetMapping("/inventory/{id}")
	public Inventory retrieveInventoryById(@PathVariable("id") int id) throws NotFoundException {
	    return inventoryDAO.findById(id)
	            .orElseThrow(() -> new NotFoundException("id" +id));
	}
	
	@GetMapping("/shipping")
	public Iterable<Shipping> retrieveShipping() {
		return shippingDAO.findAll();
	}
	
	@GetMapping("/shipping/{id}")
	public Shipping retrieveShippingById(@PathVariable("id") int id) throws NotFoundException {
	    return shippingDAO.findById(id)
	            .orElseThrow(() -> new NotFoundException("id" +id));
	}
	
	@GetMapping("/payments")
	public Iterable<Payments> retrieveAllPayments() {
		return paymentsDAO.findAll();
	}
	
	@GetMapping("/payments/{id}")
	public Payments retrievePaymentById(@PathVariable("id") int id) throws NotFoundException {
	    return paymentsDAO.findById(id)
	            .orElseThrow(() -> new NotFoundException("id" +id));
	}
	
	@GetMapping("/pricing")
	public Iterable<Pricing> retrieveAllPricing() {
		return pricingDAO.findAll();
	}
	
	@GetMapping("/pricing/{id}")
	public Pricing retrievePricingById(@PathVariable("id") int id) throws NotFoundException {
	    return pricingDAO.findById(id)
	            .orElseThrow(() -> new NotFoundException("id" +id));
	}
	
	@PutMapping("/order/{id}")
	public void cancelOrder(@PathVariable int id) {
		Orders order = ordersDAO.findById(id).get();
		
		order.setOrder_status("cancelled");
		ordersDAO.save(order);
	}
	
	@GetMapping("/order/{id}")
	public Orders retrieveOrderById(@PathVariable("id") int id) throws NotFoundException {
	    return ordersDAO.findById(id)
	            .orElseThrow(() -> new NotFoundException("id" +id));
	}
	
	@GetMapping("/order")
	public Iterable<Orders> retrieveAllOrders() {
		return ordersDAO.findAll();
	}
	
	@PostMapping("/order")
	public Orders createNewOrder(@RequestBody OrderRequest request) {
		Orders order = setOrder(request);
		setPayment(request, order);
		setShipping(request, order);
		setPricing(request, order, order.getOrder_sub_total());
		return order;
	}
	
	public Orders setOrder(OrderRequest request) {
		Orders order = new Orders();
		order.setOrder_status(request.getOrder_status());
		order.setCustomer_id(request.getCustomer().getCustomer_id());
		
		order.setPayment_time(LocalDateTime.now());
		order.setPayment_method(request.getPayment().getPayment_method());
		
		order.setAddress1(request.getAddress().getAddress1());
		order.setAddress2(request.getAddress().getAddress2());
		order.setCity(request.getAddress().getCity());
		order.setState_name(request.getAddress().getState_name());
		order.setZipcode(request.getAddress().getZipcode());
		order.setShipping_method(request.getShipping_method());
		
		Optional<Inventory> invt = null;
		BigDecimal priceVal = new BigDecimal(0.0);
		BigDecimal subTotalPrice = new BigDecimal(0.0);
		for (OrderItems item: request.getItems()) {
			invt = inventoryDAO.findById(item.getId());
			priceVal = invt.get().getPrice();
			priceVal = priceVal.multiply(BigDecimal.valueOf(item.getQuantity()));
			subTotalPrice = subTotalPrice.add(priceVal);
		}
		order.setOrder_sub_total(subTotalPrice);
		BigDecimal order_tax = subTotalPrice.multiply(BigDecimal.valueOf(0.1));
		order.setOrder_tax(order_tax);
		BigDecimal order_shipping_charges = subTotalPrice.multiply(BigDecimal.valueOf(0.05));
		order.setOrder_shipping_charges(order_shipping_charges);
		BigDecimal order_total = subTotalPrice.add(order_tax).add(order_shipping_charges);
		order.setOrder_total(order_total);
		
		ordersDAO.save(order);
		
		return order;
	}
	
	public Payments setPayment(OrderRequest request, Orders order) {
		Payments payment = new Payments();
		payment.setOrder(order);
		payment.setPayment_time(LocalDateTime.now());
		payment.setPayment_method(request.getPayment().getPayment_method());
		payment.setAddress1(request.getPayment().getAddress1());
		payment.setAddress2(request.getPayment().getAddress2());
		payment.setCity(request.getPayment().getCity());
		payment.setState_name(request.getPayment().getState_name());
		payment.setZipcode(request.getPayment().getZipcode());
		paymentsDAO.save(payment);
		return payment;
	}
	
	public Shipping setShipping(OrderRequest request, Orders order) {
		Shipping shipment = new Shipping();
		shipment.setAddress1(request.getAddress().getAddress1());
		shipment.setAddress2(request.getAddress().getAddress2());
		shipment.setCity(request.getAddress().getCity());
		shipment.setState_name(request.getAddress().getState_name());
		shipment.setZipcode(request.getAddress().getZipcode());
		shipment.setShipping_method(request.getShipping_method());
		shipment.setOrder(order);
		shippingDAO.save(shipment);
		return shipment;
	}
	
	public Pricing setPricing(OrderRequest request, Orders order, BigDecimal subTotalPrice) {
		Pricing pricing = new Pricing();
		pricing.setOrder_sub_total(subTotalPrice);
		BigDecimal order_tax = subTotalPrice.multiply(BigDecimal.valueOf(0.1));
		pricing.setOrder_tax(order_tax);
		BigDecimal order_shipping_charges = subTotalPrice.multiply(BigDecimal.valueOf(0.05));
		pricing.setOrder_shipping_charges(order_shipping_charges);
		BigDecimal order_total = subTotalPrice.add(order_tax).add(order_shipping_charges);
		pricing.setOrder_total(order_total);
		pricing.setOrder(order);
		pricingDAO.save(pricing);
		return pricing;
	}
	
}
