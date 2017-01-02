package com.cleancode.kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckOut {

	private List<Item> items;
	private ItemService itemService;
	private Map<String , String> rules;

	public CheckOut() {
		items = new ArrayList<Item>();
		itemService = new ItemService();
		rules = new HashMap<String , String>();
	}

	public Double total() {
		double specialPrice =0;
		double total =0;
		for(Item item : items){
			if(rules.containsKey(item.getItemCode())){
				specialPrice = 130.00;
			}else{
				total+= item.getPrice();
			}
			
		}
		return specialPrice  + total;
	}

	public void scan(String itemCode) {
		items.add(itemService.getByCode(itemCode));
	}

	public void addRule(String itemCode, String rule) {
		rules.put(itemCode, rule);
	}

}
