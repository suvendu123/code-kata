package com.cleancode.kata;

import java.util.ArrayList;
import java.util.List;

import com.cleancode.kata.item.ProductInventory;
import com.cleancode.kata.promotion.Promotion;

public class CheckOut {

    private ProductInventory productInventory;
    private List<Promotion> promotions;
    private Cart cart;

    public CheckOut() {
        cart = new Cart();
        productInventory = new ProductInventory();
        promotions = new ArrayList<Promotion>();
    }

    public Double total() {
        cart.applyPromotion(promotions);
        return cart.getTotal();

    }

    public void scan(String itemCode) {
        cart.addItem(productInventory.getByCode(itemCode));
    }

    public void addPromotion(Promotion promotion) {
        promotions.add(promotion);
    }

}
