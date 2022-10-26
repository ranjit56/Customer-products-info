package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.Product;

@Service
public interface ProductService {

	public Product createProduct(Product product);

	public Product getProductById(long id);

	public Boolean deleteProductById(long id);

	public List<Product> getAllProducts();

	public List<Product> search(String keyword);

}
