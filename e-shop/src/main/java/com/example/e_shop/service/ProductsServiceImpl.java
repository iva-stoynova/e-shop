package com.example.e_shop.service;

import java.util.ArrayList;
import java.util.List;

//import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.e_shop.exception.ProductAlreadyExistsException;
//import com.example.e_shop.dao.ProductsDao;
import com.example.e_shop.model.Products;
import com.example.e_shop.repository.ProductsRepository;

@Service
public class ProductsServiceImpl {
	
	@Autowired
	ProductsRepository productsRepository;
	
	
	public Products getItem(Long id) {	
		Products item = productsRepository.findById(id).orElse(null); 
		return item;
	}
	
	public Products updateItem(Long no, Products item) {
		productsRepository.save(item);
		return item;
	}	
	
	//public List<Products> updateItem(Long no, Products item) {
	//	productsRepository.save(item);
	//	return item;
	//}	
	
	public List<Products> getAllItems(){
		List<Products> items = new ArrayList<>();
		productsRepository.findAll().forEach(items::add);
		return items;
	}	
	
	public Products addItem(Products item) {
		productsRepository.save(item);
		return item;
	}

	public Products deleteItem(Long no) {
		Products item = productsRepository.findById(no).orElse(null); 
		productsRepository.deleteById(no);
		return item;
	}
}
