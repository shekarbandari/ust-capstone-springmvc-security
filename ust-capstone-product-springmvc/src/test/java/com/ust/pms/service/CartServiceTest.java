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

import com.ust.pms.model.Cart;
import com.ust.pms.repository.CartRepository;

@SpringBootTest
class CartServiceTest {
	
	@Autowired
	CartRepository cartRepository;
	Cart cart;

	@BeforeEach
	void setUp() throws Exception {
	cart=new Cart(1234,"lenova",100,100);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDeleteCart() {
		Cart product = new Cart(101,"wire",90,10);
		cartRepository.save(product);
		cartRepository.deleteById(product.getProductId());
	    //productRepository.deleteById(100);
	    Optional optional = cartRepository.findById(product.getProductId());
	    assertEquals(Optional.empty(), optional);
	}

	@Test
	void testUpdateCart() {
		cart.setPrice(1000);
		cartRepository.save(cart);
	    Cart cart1 = cartRepository.findById(cart.getProductId()).get();
	    assertEquals(1000, cart1.getPrice());
	}

	@Test
	void testSaveCart() {
		cartRepository.save(cart);
	     Cart cart1 = cartRepository.findById(cart.getProductId()).get();
	     assertEquals(1234, cart1.getProductId());
	
	}

	@Test
	void testGetCartDetails() {
		List<Cart> cartList = (List<Cart>) cartRepository.findAll();
		assertTrue(cartList.size()>0);	}

	@Test
	void testGetCart() {
		Cart cart1 = cartRepository.findById(cart.getProductId()).get();
	    assertEquals(1234, cart1.getProductId());
	}

	/*
	 * @Test void testIsCartExist() { fail("Not yet implemented"); }
	 * 
	 * @Test void testDeleteCartById() { fail("Not yet implemented"); }
	 */
}
