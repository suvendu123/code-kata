package com.cleancode.kata;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.cleancode.kata.item.Product;
import com.cleancode.kata.item.ProductInventory;

public class ProductInventoryShould {
	
	@Test
	public void should_add_new_product_C(){
		ProductInventory inventory = new ProductInventory();
		inventory.addProduct(new Product("C", 20.00));
		
		assertNotNull(inventory.getByCode("C"));
	}

}
