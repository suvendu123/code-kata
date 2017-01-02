package com.cleancode.kata;

import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckOut {

	private List<Item> items;
	private ItemService itemService;
	private Map<String, Rule> rules;
	private double totalDiscount;

	public CheckOut() {
		items = new ArrayList<Item>();
		itemService = new ItemService();
		rules = new HashMap<String, Rule>();
	}

	public Double total() {
		Map<Item, Integer> itemCountMap = getCountMap();
		calculateDiscout(itemCountMap);
		return totalDiscount + getTotal(itemCountMap);
	}

	private double getTotal(Map<Item, Integer> itemCountMap) {
		double total = 0;
		for (Map.Entry<Item, Integer> entry : itemCountMap.entrySet()) {
			total += entry.getKey().getPrice() * entry.getValue();
		}
		return total;
	}

	private void calculateDiscout(Map<Item, Integer> itemCountMap) {
		for (String itemCode : rules.keySet()) {
			Item item = itemService.getByCode(itemCode);
			if (itemCountMap.containsKey(item)) {
				applyRule(item, itemCountMap, rules.get(itemCode));
			}
		}

	}

	private void applyRule(Item item, Map<Item, Integer> itemCountMap, Rule rule) {
		if (itemCountMap.get(item) > rule.getQuantity()) {
			itemCountMap.put(item, itemCountMap.get(item) - rule.getQuantity());
			totalDiscount += rule.getDiscountedPrice();
		} else if (itemCountMap.get(item) == rule.getQuantity()) {
			itemCountMap.remove(item);
			totalDiscount += rule.getDiscountedPrice();
		}

	}

	private Map<Item, Integer> getCountMap() {
		return items.stream().collect(toMap(item -> item, value -> 1, Integer::sum));
	}

	public void scan(String itemCode) {
		items.add(itemService.getByCode(itemCode));
	}

	public void addRule(Rule rule) {
		rules.put(rule.getItemCode(), rule);
	}

}
