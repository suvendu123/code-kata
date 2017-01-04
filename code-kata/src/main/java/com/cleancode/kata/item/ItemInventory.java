package com.cleancode.kata.item;

import java.util.HashMap;
import java.util.Map;

public class ItemInventory {

	private Map<String, Item> items;

	public ItemInventory() {
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
