package com.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.user.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT c FROM Product c WHERE c.productName LIKE '%' || :keyword || '%'"
			+ " OR c.productModel LIKE '%' || :keyword || '%'" + " OR c.productMadeIn LIKE '%' || :keyword || '%'"
			+ " OR c.productPrice LIKE '%' || :keyword || '%'" + " OR c.description LIKE '%' || :keyword || '%'")
	public List<Product> search(@Param("keyword") String keyword);
}
