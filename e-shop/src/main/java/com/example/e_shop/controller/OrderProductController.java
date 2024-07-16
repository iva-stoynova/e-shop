package com.example.e_shop.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_shop.model.OrderProduct;
import com.example.e_shop.model.Products;
//import com.example.e_shop.service.OrderProductService;
import com.example.e_shop.service.OrderProductServiceImpl;
//import com.example.e_shop.service.ProductsService;
import com.example.e_shop.service.ProductsServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;



@RestController
@RequestMapping("/storeApp")
public class OrderProductController {


	@Autowired
	private OrderProductServiceImpl orderProductService;
	
	@Autowired
	private ProductsServiceImpl productService;
	
	
	
	@GetMapping("/orderproducts")
	public List<OrderProduct> getAllOrderProduct() {
	    return  orderProductService.getOrderProducts();
	}
		
	@GetMapping("/getNeededByProductId/{id}")
	public String checkInventory(@PathVariable("id") Integer productId) {
	
		Map<Integer, Integer> inventory = new HashMap<Integer, Integer>();
		 
    	Integer requestedQuantity = orderProductService.getAllProductsQuantityByProductId(productId);
    	Products retrievedProduct = productService.getItem(Long.valueOf(productId));
    	int stockQuantity = retrievedProduct.getQuantity();
    	if (stockQuantity < requestedQuantity) {
            inventory.put(productId, requestedQuantity - stockQuantity);
            
        };
        return Arrays.toString(inventory.entrySet().toArray());        
    }
	
	@GetMapping("/getAllNeeded")
	public Map<Integer, Integer> checkInventoryForAll() {
	
		Map<Integer, Integer> inventory = new HashMap<Integer, Integer>();		
		
		List<List<Integer>> requestedQuantity = orderProductService.getAllProductsQuantity();
    	
    	for(int i = 0; i < requestedQuantity.size();i++) {
    		List<Integer> temp = requestedQuantity.get(i);
    		Products retrievedProduct = productService.getItem(Long.valueOf(temp.get(0)));
    		int stockQuantity = retrievedProduct.getQuantity();
    		if (stockQuantity < temp.get(1)) {
                inventory.put(temp.get(0), temp.get(1) - stockQuantity);              
            };
    	}
    
        return inventory;
    }

}
