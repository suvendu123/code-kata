package com.cleancode.kata.promotion;

import java.util.Map;

import com.cleancode.kata.Cart;
import com.cleancode.kata.item.Product;

public class ProductPromotion implements Promotion {
    private String itemCode;
    private int quantity;
    private double discountedPrice;

    public ProductPromotion(String itemCode, int quantity, double discountedPrice) {
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.discountedPrice = discountedPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    @Override
    public double apply(Cart cart) {
        Product product = cart.getItemService().getByCode(itemCode);
        return cart.getItemsMap().containsKey(product) ? applyPromotion(cart, product) : 0;
    }

    private double applyPromotion(Cart cart, Product product) {
        double price = 0;
        int divident = cart.getItemsMap().get(product) / this.getQuantity();
        if (divident != 0) {
            price += divident * this.getDiscountedPrice();
        }
        handleRemainingProduct(cart.getItemsMap(), product);
        return price;
    }

    private void handleRemainingProduct(Map<Product, Integer> productMap, Product product) {
        if (productMap.get(product) % this.getQuantity() != 0) {
            productMap.put(product, productMap.get(product) % this.getQuantity());
        } else {
            productMap.remove(product);
        }

    }

}
