package com.cleancode.kata;

import java.util.ArrayList;
import java.util.List;

public class CheckOut {

	private List<Item> items;
	private ItemService itemService;

	public CheckOut() {
		items = new ArrayList<Item>();
		itemService = new ItemService();
	}

	public Double total() {
		return items.stream().mapToDouble(item -> item.getPrice()).sum();
	}

	public void scan(String itemCode) {
		items.add(itemService.getByCode(itemCode));
	}

}
