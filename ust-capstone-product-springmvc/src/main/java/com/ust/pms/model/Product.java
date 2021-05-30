package com.ust.pms.model;

//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {

	@Id
	//@Min(value = 1 ,message="product id is required")
	private int productId;
	//@NotBlank(message="product name is required")
	private String productName;
	//@NotNull(message="Quantity On Hand is required")
	private int quantityOnHand;
	//@NotNull(message="price is required")
	private int price;

}
