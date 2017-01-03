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

    public void scan(String itemCode) {
        items.add(itemService.getByCode(itemCode));
    }

    public void addRule(Rule rule) {
        rules.put(rule.getItemCode(), rule);
    }

    private double getTotal(Map<Item, Integer> itemCountMap) {
        double total = 0;
        for (Map.Entry<Item, Integer> entry : itemCountMap.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    private void calculateDiscout(Map<Item, Integer> itemCountMap) {
        for (Map.Entry<String, Rule> entry : rules.entrySet()) {
            applyRule(itemCountMap, entry);
        }

    }

    private void applyRule(Map<Item, Integer> itemCountMap, Map.Entry<String, Rule> entry) {
        Item item = itemService.getByCode(entry.getKey());
        if (itemCountMap.containsKey(item)) {
            totalDiscount += entry.getValue().apply(item, itemCountMap.get(item));
            itemCountMap.remove(item);
        }
    }

    private Map<Item, Integer> getCountMap() {
        return items.stream().collect(toMap(item -> item, value -> 1, Integer::sum));
    }

}
