package com.cleancode.kata;

import java.util.ArrayList;
import java.util.List;

import com.cleancode.kata.item.ProductInventory;
import com.cleancode.kata.promotion.Promotion;

public class CheckOut {

    private ProductInventory itemService;
    private List<Promotion> promotions;
    private Cart cart;

    public CheckOut() {
        cart = new Cart();
        itemService = new ProductInventory();
        promotions = new ArrayList<Promotion>();
    }

    public Double total() {
        cart.applyPromotion(promotions);
        return cart.getTotal();

    }

    public void scan(String itemCode) {
        cart.addItem(itemService.getByCode(itemCode));
    }

    public void addPromotion(Promotion promotion) {
        promotions.add(promotion);
    }

}
