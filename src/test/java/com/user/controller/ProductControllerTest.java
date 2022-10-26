package com.user.controller;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

import com.user.entity.Product;
import com.user.service.ProductService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductControllerTest {
	 
	@InjectMocks
	ProductController productController;

	@Mock
	ProductService productService;
	
	@Mock
	Model model;
	@Mock
	Product product;
	
	List<Product> products;
	
	@Test
	public void homeTest() {
		
		products = new ArrayList<>();
		products.add(new Product((long) 1, "Dell", "Latitude234", "india", "23444", "good"));
		products.add(new Product((long) 1, "Apple", "Latitude234", "US", "23444", "good"));
		when(productService.getAllProducts()).thenReturn(products);
		productController.home(model);
	}
	
	@Test
	public void showNewProductFormTest() {
		
		product.setId((long) 1);
		product.setProductName("Dell");
		product.setProductModel("Latitude234");
		product.setProductMadeIn("india");
		product.setProductPrice("563");
		product.setDescription("good");
		when(productService.createProduct(product)).thenReturn(product);
		productController.showNewProductForm(model);
	}
	
	@Test
	public void saveproductsTest() {
		
		product.setId((long) 1);
		product.setProductName("Dell");
		product.setProductModel("Latitude234");
		product.setProductMadeIn("india");
		product.setProductPrice("563");
		product.setDescription("good");
		when(productService.createProduct(product)).thenReturn(product);
		productController.saveproducts(product);
	}
	
	@Test
	public void editProductFormTest() {
		
		product.setId((long) 1);
		product.setProductName("Dell");
		product.setProductModel("Latitude234");
		product.setProductMadeIn("india");
		product.setProductPrice("563");
		product.setDescription("good");
		when(productService.getProductById(1)).thenReturn(product);
		productController.editProductForm(1, model);
		
	}
	
	@Test
	public void deleteProductFormTest() {
		product.setId((long) 1);
		product.setProductName("Dell");
		product.setProductModel("Latitude234");
		product.setProductMadeIn("india");
		product.setProductPrice("563");
		product.setDescription("good");
		productController.deleteProductForm(1);
		verify(productService,times(1)).deleteProductById(1);
	}
	
	@Test
	public void searchTest() {
		
		products = new ArrayList<>();
		products.add(new Product((long) 1, "Dell", "Latitude234", "india", "23444", "good"));
		products.add(new Product((long) 1, "Apple", "Latitude234", "US", "23444", "good"));
		String keyword = "Dell";
	   when(productService.search(keyword)).thenReturn(products);
	   productController.search(keyword, model);
	}
}
