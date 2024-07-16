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
public class ProductsServiceImpl { //implements ProductsService{
	
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
	

	
	
	/*@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		
		List<Products> result=new ArrayList<>();
		
		try {
			result= productsRepository.getAllProducts();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public List<Products> getProductsByName(String name) {
		// TODO Auto-generated method stub
		List<Products> result=new ArrayList<>();
		
		try {
			result= productsRepository.getProductsByName(name);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public Products getProductsByProductId(Long id) {
		// TODO Auto-generated method stub
		Products result=new Products();
		
		try {
			result= productsRepository.getProductsByProductId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean addProduct(Products productDetails) throws ProductAlreadyExistsException {
		// TODO Auto-generated method stub
		boolean result;
		
		try {
			productsRepository.addProduct(productDetails);
			result=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result=false;
			throw new ProductAlreadyExistsException("Product Already Exists!");
		}
		
		return result;
	}

	@Override
	public boolean updateProduct(Products productDetails, String productId) {
		// TODO Auto-generated method stub
		
		int result;
		
		try {
			result=productsRepository.updateProduct(productDetails,productId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result=0;
		}
		
		if(result==0)
		{
			return false;
		}
		return true;
	}
	
	@Override
	public boolean updateProduct(Products productDetails, Integer productId) {
		// TODO Auto-generated method stub
		
		int result;
		
		try {
			result=productsRepository.updateProduct(productDetails, productId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result=0;
		}
		
		if(result==0)
		{
			return false;
		}
		return true;
	}
	
	@Override
	public boolean deleteProduct(Long id) {
		// TODO Auto-generated method stub
		int result;
		
		try {
			result=productsRepository.deleteProduct(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result=0;
		}
		
		if(result==0)
		{
			return false;
		}
		return true;
	}*/

	/*@Override
	public Products updateProduct(Products productDetails, String productId) {
		// TODO Auto-generated method stub
		
		Products result;
		
		try {
			result=productsRepository.updateProduct(productDetails, productId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(result==null)
		{
			return ;
		}
		return result;
	}*/
	
}
