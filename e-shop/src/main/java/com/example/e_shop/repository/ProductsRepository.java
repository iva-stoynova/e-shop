package com.example.e_shop.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.e_shop.model.Products;

@Repository
//public class ProductsRepository {

public interface ProductsRepository extends CrudRepository<Products, Long> {

	Optional<Products> findById(Long id);

	
	
	
	
	
	/*@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<Products> getAllProducts() {
		
		List<Products> productList = new ArrayList<>();
		
		 productList=jdbcTemplate.query("SELECT * from Products", new RowMapper<Products>(){  
			   
			@Override
			public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
									
				Products product=new Products();
				product.setId(rs.getLong("id"));
				product.setName(rs.getString("name"));
				product.setQuantity(rs.getInt("quantity"));
				product.setPrice(rs.getBigDecimal("price"));
				return product;
			}  
		    }); 
		 
		return productList;
	}
	
	public List<Products> getProductsByName(String name) {
		
		List<Products> productList = new ArrayList<>();
		
		 productList=jdbcTemplate.query("SELECT * from Products where lower(name)='"+name.toLowerCase()+"'", new RowMapper<Products>(){  
			   
			@Override
			public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
									
				Products product=new Products();
				product.setId(rs.getLong("id"));
				product.setName(rs.getString("name"));
				product.setQuantity(rs.getInt("quantity"));
				product.setPrice(rs.getBigDecimal("price"));				
				return product;
			}  
		    }); 
		return productList;
	}
	
	public Products getProductsByProductId(Long id) {
		
		//Optional<Products> productList = null;
		Products productList = new Products();
		
		 productList=jdbcTemplate.queryForObject("SELECT * from Products where id ='"+id+"'", new RowMapper<Products>(){  
			   
			@Override
			public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
									
				Products product=new Products();
				product.setId(rs.getLong("id"));
				product.setName(rs.getString("name"));
				product.setQuantity(rs.getInt("quantity"));
				product.setPrice(rs.getBigDecimal("price"));
				return product;
			}  
		    }); 
		return productList;
	}
	
	public void addProduct(Products productDetails) {
		
		 String INSERT_STATEMENT = "INSERT INTO Products(id,name,quantity,price) VALUES (?,?,?,?)" ;

			jdbcTemplate.batchUpdate(INSERT_STATEMENT, new BatchPreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					// TODO Auto-generated method stub
					ps.setLong(1,productDetails.getId()); 
					ps.setString(2, productDetails.getName());
					ps.setInt(3, productDetails.getQuantity());
					ps.setBigDecimal(4, productDetails.getPrice());
				}
				
				@Override
				public int getBatchSize() {
					// TODO Auto-generated method stub
					return 1;
				}
			});
	}
	
	public int updateProduct(Products productDetails, String id) {
		
		String query="UPDATE Products set name='"+productDetails.getName()+"',quantity='"+productDetails.getQuantity()+"',price='"+productDetails.getPrice()+"' where id='"+id+"'  ";    
			    return jdbcTemplate.update(query);  
	}
	
	public int updateProduct(Products productDetails, Integer id) {
		
		String query="UPDATE Products set quantity='"+productDetails.getQuantity()+"' where id='"+id+"'  ";    
			    return jdbcTemplate.update(query);  
	} 
	
	
	
	public int deleteProduct(Long id){  
	    String query="delete from products where id='"+id+"' ";  
	    return jdbcTemplate.update(query);  
	}  */
	
}
