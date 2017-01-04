package com.cleancode.kata.item;

import java.util.HashMap;
import java.util.Map;

public class ProductInventory {

	private Map<String, Product> products;

	public ProductInventory() {
		initItems();
	}

	private void initItems() {
		products = new HashMap<String, Product>();
		products.put("A", new Product("A", 50.00));
		products.put("B", new Product("B", 30.00));
		products.put("C", new Product("C", 20.00));

	}

	public Product getByCode(String itemCode) {
		return products.get(itemCode);
	}

	public void addProduct(Product product) {
		products.put(product.getItemCode(), product);
	}

}
