package com.example.e_shop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.e_shop.model.OrderProduct;
import com.example.e_shop.model.Products;
import com.example.e_shop.repository.OrderProductRepository;

@Service
public class OrderProductServiceImpl { // implements OrderProductService{

	@Autowired
	OrderProductRepository orderProductsRepository;
	
		
	public int getAllProductsQuantityByProductId(Integer productId) {		
		return orderProductsRepository.getAllProductsQuantityByProductId(productId);		
	}
		
	public List<List<Integer>> getAllProductsQuantity() {
		return orderProductsRepository.getAllProductsQuantity();		
	}	
	
    public List<OrderProduct> getOrderProducts(){
        List<OrderProduct> out = new ArrayList<OrderProduct>();
        orderProductsRepository.findAll().forEach(orderproduct -> out.add(orderproduct));
        return out;
    }
    
    
    
    
	
	/*@Override
	public List<Products> getProductByOrderId(Integer orderId) {
		// TODO Auto-generated method stub
		
		List<Products> result=new ArrayList<>();
		
		try {
			result = orderProductsRepository.getProductByOrderId(orderId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getAllProductsQuantityByProductId(Integer productId) {
		int sum = 0;
		sum = orderProductsRepository.getAllProductsQuantityByProductId(productId);
		return sum;
	}*/
	
	
	
	
	//public Products updateItem(Products item, String no) {
	//	orderProductsRepository.save(item);
	//	return item;
	//}

}
