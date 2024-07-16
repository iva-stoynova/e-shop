package com.example.e_shop.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Products {
	        
	
	@Id
	@Column(name = "id",unique=true, nullable = false)
	private Long id;	
	private String name;	
	private int quantity;	
	private BigDecimal price;
	
	
	public Products() {
		
	}
		
	public Products(Long id, String name, int quantity, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public Products(Products product) {
		super();
		this.id = product.id;
		this.name = product.name;
		this.quantity = product.quantity;
		this.price = product.price;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}		
}
