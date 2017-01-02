package com.cleancode.kata;

import java.util.HashMap;
import java.util.Map;

public class ItemService {

	private Map<String, Item> items;

	public ItemService() {
		initItems();
	}

	private void initItems() {
		items = new HashMap<String, Item>();
		items.put("A", new Item("A", 50.00));
		items.put("B", new Item("B", 30.00));

	}

	public Item getByCode(String itemCode) {
		return items.get(itemCode);
	}

}
