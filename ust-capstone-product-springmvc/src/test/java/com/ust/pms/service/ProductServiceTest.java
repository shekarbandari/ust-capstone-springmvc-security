package com.ust.pms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ust.pms.model.Product;
import com.ust.pms.repository.ProductRepository;

@SpringBootTest
class ProductServiceTest {

	
	@Autowired
	private ProductRepository productRepository;
	private Product product;
	
	@BeforeEach
	public void setUp() throws Exception {
		product = new Product(1234,"lenova",100,100);
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeleteProduct() {
		
		Product product = new Product(101,"wire",90,10);
	    productRepository.save(product);
	    productRepository.deleteById(product.getProductId());
	    //productRepository.deleteById(100);
	    Optional optional = productRepository.findById(product.getProductId());
	    assertEquals(Optional.empty(), optional);
		 
	}

	@Test
	public void testUpdateProduct() {
		product.setPrice(1000);
		productRepository.save(product);
	    Product Product1 = productRepository.findById(product.getProductId()).get();
	    assertEquals(1000, Product1.getPrice());
	}

	@Test
	public void testSaveProduct() {
		 productRepository.save(product);
	     Product Product1 = productRepository.findById(product.getProductId()).get();
	     assertEquals(1234, Product1.getProductId());
	
	}

	@Test
	public void testGetProductDetails() {
		List<Product> productList = (List<Product>) productRepository.findAll();
		assertTrue(productList.size()>0);
	}

	@Test
	public void testGetProduct() {
		Product Product1 = productRepository.findById(product.getProductId()).get();
	    assertEquals(1234, Product1.getProductId());
	}

	

}