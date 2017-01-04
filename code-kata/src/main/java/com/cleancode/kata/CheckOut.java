package com.cleancode.kata;

import java.util.HashMap;
import java.util.Map;

import com.cleancode.kata.item.ItemInventory;
import com.cleancode.kata.promotion.Promotion;

public class CheckOut {

    private ItemInventory itemService;
    private Map<String, Promotion> rules;
    private Cart cart;

    public CheckOut() {
        cart = new Cart();
        itemService = new ItemInventory();
        rules = new HashMap<String, Promotion>();
    }

    public Double total() {
        cart.applyRule(rules);
        return cart.getTotal();

    }

    public void scan(String itemCode) {
        cart.addItem(itemService.getByCode(itemCode));
    }

    public void addRule(Promotion rule) {
        rules.put(rule.getItemCode(), rule);
    }

}
