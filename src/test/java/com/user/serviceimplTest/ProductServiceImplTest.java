
package com.user.serviceimplTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.user.entity.Product;
import com.user.repository.ProductRepository;
import com.user.service.ProductServiceimpl;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceImplTest {

	@InjectMocks
	ProductServiceimpl productServiceimpl;

	@Mock
	ProductRepository productRepository;

	
	List<Product> products;

	@Mock
	Product product;

	@Test
	public void createProductTest() {

		Product product = new Product();
		product.setId((long) 1);
		product.setProductName("dell");
		product.setProductPrice("56678");
		product.setDescription("good");
		product.setProductModel("ghj");
		product.setProductMadeIn("india");
		when(productRepository.saveAndFlush(product)).thenReturn(product);
		productServiceimpl.createProduct(product);
	}

	@Test
	public void createProductTest_Exception() {
		
		Product product = new Product();
		product.setId(null);
		product.setProductName(null);
		product.setProductPrice(null);
		product.setDescription(null);
		product.setProductModel(null);
		product.setProductMadeIn(null);

		when(productRepository.saveAndFlush(product)).thenReturn(product);
		productServiceimpl.createProduct(null);

	}

	@Test
	public void createProductTest_Exception1() {
		
		Product product = new Product();
		product.setId(null);
		product.setProductName(null);
		product.setProductPrice(null);
		product.setDescription(null);
		product.setProductModel(null);
		product.setProductMadeIn(null);

		when(productRepository.saveAndFlush(product)).thenReturn(product);
		productServiceimpl.createProduct(product);

	}
	@Test
	public void createProductTest_Exception2() {
		
		Product product = new Product();
		product.setId((long) 1);
		product.setProductName("dell");
		product.setProductPrice(null);
		product.setDescription("good");
		product.setProductModel("ghj");
		product.setProductMadeIn("india");

		when(productRepository.saveAndFlush(product)).thenReturn(product);
		productServiceimpl.createProduct(product);

	}
	@Test
	public void createProductTest_Exception6() {
		
		Product product = new Product();
		product.setId((long) 1);
		product.setProductName(null);
		product.setProductPrice("sdf");
		product.setDescription("good");
		product.setProductModel("ghj");
		product.setProductMadeIn("india");

		when(productRepository.saveAndFlush(product)).thenReturn(product);
		productServiceimpl.createProduct(product);

	}
	@Test
	public void createProductTest_Exception3() {
		
		Product product = new Product();
		product.setId((long) 1);
		product.setProductName("dell");
		product.setProductPrice("56678");
		product.setDescription(null);
		product.setProductModel("ghj");
		product.setProductMadeIn("india");

		when(productRepository.saveAndFlush(product)).thenReturn(product);
		productServiceimpl.createProduct(product);

	}
	@Test
	public void createProductTest_Exception4() {
		
		Product product = new Product();
		product.setId((long) 1);
		product.setProductName("dell");
		product.setProductPrice("56678");
		product.setDescription("good");
		product.setProductModel(null);
		product.setProductMadeIn("india");

		when(productRepository.saveAndFlush(product)).thenReturn(product);
		productServiceimpl.createProduct(product);

	}
	@Test
	public void createProductTest_Exception5() {
		
		Product product = new Product();
		product.setId((long) 1);
		product.setProductName("dell");
		product.setProductPrice("56678");
		product.setDescription("good");
		product.setProductModel("ghj");
		product.setProductMadeIn(null);

		when(productRepository.saveAndFlush(product)).thenReturn(product);
		productServiceimpl.createProduct(product);

	}
	
	@Test
	public void getAllProductsTest() {
		when(productRepository.findAll())
				.thenReturn(Stream
						.of(new Product((long) 2, "ran", "ind", "java", "dfghj", "dfgh"),
								new Product((long) 3, "syam", "ind", "java", "dfghj", "dfghj"))
						.collect(Collectors.toList()));
		assertEquals(2, productServiceimpl.getAllProducts().size());
	}

	@Test
	public void getProductById() {

		product.setId((long) 1);
		product.setProductName("dell");
		product.setProductPrice("56678");
		product.setDescription("good");
		product.setProductModel("ghj");
		product.setProductMadeIn("india");
		productServiceimpl.getProductById(1);
		verify(productRepository, times(1)).findById((long) 1);
		
	}

	@Test
	public void deleteProductByIdTest() {

		product.setId((long) 1);
		product.setProductName("dell");
		product.setProductPrice("56678");
		product.setDescription("good");
		product.setProductModel("ghj");
		product.setProductMadeIn("india");
		long id = 1;
		productServiceimpl.deleteProductById(id);
		verify(productRepository, times(1)).findById(id);
	}

	@Test
	public void deleteProductByIdTest_Exception() {

		product.setId((long) 1);
		product.setProductName("dell");
		product.setProductPrice("56678");
		product.setDescription("good");
		product.setProductModel("ghj");
		product.setProductMadeIn("india");
		long id = 0;
		productServiceimpl.deleteProductById(id);

		verify(productRepository, times(1)).findById(id);
	}
	
	@Test
	public void searchTest() {
		
		products = new ArrayList<>();
		products.add(new Product((long) 1, "Dell", "Latitude234", "india", "23444", "good"));
		products.add(new Product((long) 1, "Apple", "Latitude234", "US", "23444", "good"));
		String keyword = "Dell";
		when(productRepository.search(keyword)).thenReturn(products);
		productServiceimpl.search(keyword);
		
	}

}
