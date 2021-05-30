package com.ust.pms.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.ust.pms.model.Product;


@DataJpaTest
@AutoConfigureTestDatabase
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	TestEntityManager testEntityManager;
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	//@Rollback(false)
	public void testSave() {
		testEntityManager.persist(new Product(1234,"iPhone 10", 111,1099));
        
        Optional<Product> product = productRepository.findById(1234);
         
        assertThat(product.get().getProductId()).isEqualTo(1234);
	}

	@Test
	void testSaveAll() {
		fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	void testExistsById() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAllById() {
		fail("Not yet implemented");
	}

	@Test
	void testCount() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteAllIterableOfQextendsT() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteAll() {
		fail("Not yet implemented");
	}

}
