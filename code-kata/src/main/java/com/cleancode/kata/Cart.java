package com.cleancode.kata;

import java.util.HashMap;
import java.util.Map;

import com.cleancode.kata.item.Item;
import com.cleancode.kata.item.ItemInventory;
import com.cleancode.kata.promotion.Promotion;

public class Cart {

    private Map<Item, Integer> itemsMap;
    private ItemInventory itemService;
    private double totalPrice;

    public Cart() {
        itemsMap = new HashMap<Item, Integer>();
        itemService = new ItemInventory();
    }

    public void addItem(Item item) {
        if (itemsMap.getOrDefault(item, null) != null) {
            itemsMap.put(item, itemsMap.get(item) + 1);
        } else {
            itemsMap.put(item, 1);
        }

    }

    public void applyRule(Map<String, Promotion> rules) {
        for (Map.Entry<String, Promotion> entry : rules.entrySet()) {
            applyRuleForItem(entry);
        }
    }

    private void applyRuleForItem(Map.Entry<String, Promotion> entry) {
        Item item = itemService.getByCode(entry.getKey());
        if (itemsMap.containsKey(item)) {
            totalPrice += entry.getValue().apply(item, itemsMap.get(item));
            itemsMap.remove(item);
        }
    }

    public Double getTotal() {
        for (Map.Entry<Item, Integer> entry : itemsMap.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        return totalPrice;
    }
}
