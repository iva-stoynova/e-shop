package com.example.e_shop.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.e_shop.model.Products;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Long> {

	Optional<Products> findById(Long id);

	
}
