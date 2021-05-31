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
public class Cart {
	
	@Id
	private  int productId;
	private String productName;
	private int quantityOnHand;
	private int price;
	
	
	
}
