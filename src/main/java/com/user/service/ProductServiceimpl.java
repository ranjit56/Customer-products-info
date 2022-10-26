package com.user.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.Product;
import com.user.repository.ProductRepository;

@Service
public class ProductServiceimpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Transactional
	public Product createProduct(Product product) {

		if (product == null) {
			throw new IllegalArgumentException("Product Can't be Null.");
		}
		if (product.getId() == null) {
			throw new IllegalArgumentException("Product Id Can't be Null.");
		}
		if (product.getProductName() == null) {
			throw new IllegalArgumentException("Product productName Can't be Null.");
		}
		if (product.getProductModel() == null) {
			throw new IllegalArgumentException("Product productModel Can't be Null.");
		}
		if (product.getProductMadeIn() == null) {
			throw new IllegalArgumentException("Product productMadeIn Can't be Null.");
		}
		if (product.getProductPrice() == null) {
			throw new IllegalArgumentException("Product productPrice Can't be Null.");
		}

		if (product.getDescription() == null) {
			throw new IllegalArgumentException("Product description Can't be Null.");
		}

		return productRepository.saveAndFlush(product);
	}

	@Transactional
	public Boolean deleteProductById(long id) {
		Boolean flag = false;
		if (id == 0) {
			throw new IllegalArgumentException("Id can't be null");
		} else {
			Product product = getProductById(id);
			productRepository.deleteById(id);
			return flag;
		}
	}

	@Transactional
	public List<Product> getAllProducts() {
		List<Product> product = productRepository.findAll();
		System.out.println("Getting the data from the db: " + product);
		return product;
	}

	@Transactional
	public Product getProductById(long id) {
		return productRepository.findById(id).orElse(null);

	}

	@Transactional
	public List<Product> search(String keyword) {
		return productRepository.search(keyword);
	}

}
