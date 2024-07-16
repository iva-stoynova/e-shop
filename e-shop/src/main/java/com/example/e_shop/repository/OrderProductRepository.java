package com.example.e_shop.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.e_shop.model.OrderProduct;

@Repository
//public class OrderProductRepository {
public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {

	
	@Query("SELECT sum(po.quantity) as total_quantity from order_product po where product_id = :product_id")
	int getAllProductsQuantityByProductId(@Param("product_id") Integer product_id);
	
	@Query("select po.productId, sum(po.quantity) as total_quantity from order_product po group by po.productId")
	List<List<Integer>> getAllProductsQuantity();
	
	
	
	
	
	
	/*@Autowired
	private JdbcTemplate jdbcTemplate;
		
		
    @SuppressWarnings("deprecation")
	public List<Products> getProductByOrderId(Integer order_id) {
    	
    	List<Products> productList = new ArrayList<>();
                
        List<Integer> productIds =  jdbcTemplate.queryForList("SELECT product_id FROM order_product where order_id='"+order_id+"'", Integer.class);        
        String inSql = String.join(",", Collections.nCopies(productIds.size(), "?"));
		
		productList=jdbcTemplate.query(String.format("SELECT * from Products where id IN (%s)", inSql), 
			productIds.toArray(),	  (rs, rowNum) -> new Products(rs.getLong("id"), rs.getString("name"),
			        rs.getInt("quantity"), rs.getBigDecimal("price")));			 
		
		return productList;      
    }
    
    public int getAllProductsQuantityByProductId(Integer product_id) {
		
		int totalQuantity = 0;
		
		totalQuantity=jdbcTemplate.queryForObject("SELECT sum(quantity) from order_product where product_id='"+product_id+"'", Integer.class);  
		
		return totalQuantity;
	}*/
	
}
