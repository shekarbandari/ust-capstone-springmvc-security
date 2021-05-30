package com.ust.pms.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ust.pms.model.Product;
import com.ust.pms.repository.ProductRepository;

class ProductServiceTest {

	ProductService productService;
	ProductRepository productRepository;
	
	
	@BeforeEach
	void setUp() throws Exception {
		productService=new ProductService();
	}

	@AfterEach
	void tearDown() throws Exception {
		productService=null;
	}

	@Test
	public void testDeleteProduct() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveProduct() {
	// productRepository.save(p);
	/*
	 * Product p=new Product(1234,"Lenova",111,222);
	 * doReturn(p).when(productRepository).save(any());
	 * 
	 * 
	 * Product product=productService.saveProduct(p);
	 * Assertions.assertNotNull(product,"the save object successfully");
	 * Assertions.assertEquals(1234,product.getProductId()
	 * ,"the product id is testing");
	 */
		
		Product  product=productRepository.save(new Product(1234,"google",12,23));
		assertThat(product.getProductId()).isEqualTo(1234);
		
	 
	 
	 
	}

	@Test
	void testGetProductDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProduct() {
		fail("Not yet implemented");
	}

	@Test
	void testIsProductExist() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteProductById() {
		fail("Not yet implemented");
	}

}
