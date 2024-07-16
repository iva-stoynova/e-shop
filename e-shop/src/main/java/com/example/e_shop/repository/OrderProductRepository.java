package com.example.e_shop.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.e_shop.model.OrderProduct;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {

	
	@Query("SELECT sum(po.quantity) as total_quantity from order_product po where product_id = :product_id")
	int getAllProductsQuantityByProductId(@Param("product_id") Integer product_id);
	
	@Query("select po.productId, sum(po.quantity) as total_quantity from order_product po group by po.productId")
	List<List<Integer>> getAllProductsQuantity();
	
}
