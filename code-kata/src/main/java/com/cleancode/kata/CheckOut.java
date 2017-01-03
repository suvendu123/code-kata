package com.cleancode.kata;

import java.util.HashMap;
import java.util.Map;

public class CheckOut {

    private ItemService itemService;
    private Map<String, Rule> rules;
    private Cart cart;

    public CheckOut() {
        cart = new Cart();
        itemService = new ItemService();
        rules = new HashMap<String, Rule>();
    }

    public Double total() {
        cart.applyRule(rules);
        return cart.getTotal();

    }

    public void scan(String itemCode) {
        cart.addItem(itemService.getByCode(itemCode));
    }

    public void addRule(Rule rule) {
        rules.put(rule.getItemCode(), rule);
    }

}
