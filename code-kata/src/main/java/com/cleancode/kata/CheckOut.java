package com.cleancode.kata;

import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckOut {

	private List<Item> items;
	private ItemService itemService;
	private Map<String, String> rules;
	private double discountedPrice;

	public CheckOut() {
		items = new ArrayList<Item>();
		itemService = new ItemService();
		rules = new HashMap<String, String>();
	}

	public Double total() {
		Map<Item, Integer> itemCountMap = getCountMap();
		calculateDiscout(itemCountMap);
		double total = 0;
		for (Map.Entry<Item, Integer> entry : itemCountMap.entrySet()) {
			total += entry.getKey().getPrice() * entry.getValue();
		}
		return discountedPrice + total;
	}

	private void calculateDiscout(Map<Item, Integer> itemCountMap) {
		for (String itemCode : rules.keySet()) {
			Item item = itemService.getByCode(itemCode);
			if (itemCountMap.containsKey(item)) {
				applyRule(item, itemCountMap, rules.get(itemCode));
			}
		}

	}

	private void applyRule(Item item, Map<Item, Integer> itemCountMap, String rule) {
		if (rule.equalsIgnoreCase("3 for 130")) {
			if (itemCountMap.get(item) > 3) {
				itemCountMap.put(item, itemCountMap.get(item) - 3);
				discountedPrice += 130;
			} else if (itemCountMap.get(item) == 3) {
				itemCountMap.remove(item);
				discountedPrice += 130;
			}
		}

	}

	private Map<Item, Integer> getCountMap() {
		return items.stream().collect(toMap(item -> item, value -> 1, Integer::sum));
	}

	public void scan(String itemCode) {
		items.add(itemService.getByCode(itemCode));
	}

	public void addRule(String itemCode, String rule) {
		rules.put(itemCode, rule);
	}

}
