package com.example.e_shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "order_product")
public class OrderProduct {
	
	
	@Id
	@Column(name = "order_id")
	private int orderId;
	@Column(name = "product_id")
	private int productId;
	@Column(name = "quantity")
	private int quantity;
	
		
	public OrderProduct() {
		
	}
	
	public OrderProduct(int orderId, int productId, int quantity) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public OrderProduct(OrderProduct op) {
		super();
		this.orderId =op.orderId;
		this.productId = op.productId;
		this.quantity = op.quantity;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderProduct [orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}
	
}
