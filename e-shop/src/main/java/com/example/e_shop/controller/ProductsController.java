package com.example.e_shop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_shop.exception.ProductAlreadyExistsException;
import com.example.e_shop.model.Products;
//import com.example.e_shop.service.ProductsService;
import com.example.e_shop.service.ProductsServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


@RestController
@RequestMapping("/storeApp")
public class ProductsController {

	@Autowired
	//private ProductsService productService;
	private ProductsServiceImpl productService;
	
	@GetMapping("/products")
	public List<Products> getAllItems() {
		return productService.getAllItems();
	}
	
	@PostMapping("/products")
	public Products addItem(@RequestBody Products item) {
		return productService.addItem(item);
	}

	@GetMapping("/products/{id}")
	public Products getItem(@PathVariable Long id) {
		return productService.getItem(id);
	}
	
	@PutMapping("/products/{id}/withdraw/{quantity}")
	public Products withdrawalItem(@PathVariable Long id, @PathVariable Integer quantity) {
		Products item = productService.getItem(id);
		int currQuantity = item.getQuantity() ;
		int newQ = currQuantity - quantity;
		if(newQ < 1)
		{
			System.out.println("the new quantity is negative " +newQ	+" and therefore you can NOT make this item withdrawal");
			return item;
		}
		item.setQuantity(newQ);
		return productService.updateItem(id, item);
	}

	@PutMapping("/products/{id}/load/{quantity}")
	public Products depositItem(@PathVariable Long id, @PathVariable Integer quantity) {
		Products item = productService.getItem(id);
		Integer currQuantity = item.getQuantity();
		int newQuantity = currQuantity + quantity;
		item.setQuantity(newQuantity);
		return productService.updateItem(id, item);
	}
	
	@PutMapping("/products/{id}/loadAll/{quantity}")
	public List<Products> depositAllItem(@RequestParam Map<Integer, Integer> pathVars){   //@PathVariable Map<Integer, Integer> pathVars
		Products temp = null;
		List<Products> result = new ArrayList<Products>();
		for (Map.Entry<Integer, Integer> entry : pathVars.entrySet()) {
			Integer id = entry.getKey();
		    Integer quantity = entry.getValue();
		
		
		    Products item = productService.getItem(Long.valueOf(id));
		    Integer currQuantity = item.getQuantity();
		    int newQuantity = currQuantity + quantity;
		    item.setQuantity(newQuantity);
		    temp =  productService.updateItem(Long.valueOf(id), item);
		    result.add(temp);
		}
		return result;
	}
	
	@DeleteMapping("/products/{id}")
	public Products deleteItem(@PathVariable("id") Long id) {
		return productService.deleteItem(id);
	}
	
	/*ObjectMapper objectMapper = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);
		
	
	@GetMapping("/getAllProducts")
	public Object getAllProducts(){
		List<Products> result= productService.getAllProducts();
		return result;
	}
	
	@GetMapping("/getProductsByName/{key}")
	public Object getProductsByName(@PathVariable("key") String name) throws JsonProcessingException{
		
		List<Products> result= productService.getProductsByName(name);
		String listToJson = objectMapper.writeValueAsString(result);
		return listToJson;
	}
	
	@GetMapping("/getProducts/{id}")
	public ResponseEntity<Products> getProductsById(@PathVariable("id") Long id) throws JsonProcessingException{
		
		Products retrievedProduct= productService.getProductsByProductId(id);
		ResponseEntity<Products> listToJson = new ResponseEntity<>(retrievedProduct, HttpStatus.OK);
		
		return listToJson;
	}

	@PostMapping("/addProduct")
	public boolean addProduct(@RequestBody Products producDetails) throws JsonProcessingException, ProductAlreadyExistsException{
		
		boolean response = productService.addProduct(producDetails);
		return response;
	}
	
	//@PostMapping("/addProduct")
	//public ResponseEntity<String> addProduct(@RequestBody Products product) {		
		
	//	ResponseEntity<String> response = new ResponseEntity<>("Product added successfully", HttpStatus.OK);
	//	return response;
	//}
	
	@PostMapping("updateProduct/{id}")  
    public boolean updateProduct(@RequestBody Products productDetails,@PathVariable("id") String id) {  
        boolean result= productService.updateProduct(productDetails, id);  
        return result;  
    }  
	
	@DeleteMapping("deleteProduct/{id}")  
    public boolean deleteProduct(@PathVariable("id") Long id) {  
        boolean result= productService.deleteProduct(id);  
        return result;  
    } */
	
	
	
	
	
	
	
	 /*@PutMapping("/{id}")
	 public Products updateUser(@PathVariable Long id, @RequestBody Products user) {
		 Products existingUser = productService.findById(id).get();
	    existingUser.setName(user.getName());
	    existingUser.setQuantity(user.getQuantity());
	    return Products.save(existingUser);
	 }*/
	
	/*@PutMapping("/updateProduct/{productId}/d/{quantity}")	
	public boolean depositProductInStock(@PathVariable Integer productId, @PathVariable Integer quantity) {
		Products item = productService.getProductsByProductId(Long.valueOf(productId)); //itemService.getItem(no);
		Integer currQuantity = item.getQuantity();
		int newQuantity = currQuantity + quantity; //Integer.parseInt(quantity);
		item.setQuantity(newQuantity); //String.valueOf(newQuantity));
		//return null; //productService.updateProduct(item, String.valueOf(productId));
		boolean result = productService.updateProduct(item, String.valueOf(productId)); 
		return result;
	}*/
	
	
	
	
	
	
	
	
	
	
	
	/*@Resource 
	ProductsService productService;
	
	
	
	
	@GetMapping(value = "/productList")
	public List<Products> getEmployees() {
		return productService.findAll();	
	}
	
	@PostMapping(value = "/createProduct")
	public void createEmployee(@RequestBody Products product) {
		productService.insertProduct(product);	
	}
	
	//@RequestMapping(value="/products/{id}", method=RequestMethod.PUT)
	//public Products readEmployees(@PathVariable(value = "id") Long id, @RequestBody Products productDetails) {
	//    return productService.updateProduct(id, productDetails);
	//}

	
	@PutMapping(value = "/updateProduct")
	public void updateEmployee(@RequestBody Products product) {
		productService.updateProduct(product);	
	}
	
	@PutMapping(value = "/executeUpdateProduct")
	public void executeUpdateEmployee(@RequestBody Products product) {
		productService.executeUpdateProduct(product);	
	}
	
	@DeleteMapping(value = "/deleteProductById")
	public void deleteProduct(@RequestBody Products product) {
		productService.deleteProduct(product);	
	}*/
	
}
