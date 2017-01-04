package com.cleancode.kata.promotion;

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
        double price = 0;
        Product product = cart.getItemService().getByCode(itemCode);
        int divident = cart.getItemsMap().get(product) / this.getQuantity();
        int reminder = cart.getItemsMap().get(product) % this.getQuantity();
        if (divident != 0) {
            price += divident * this.getDiscountedPrice();
        }
        if (reminder != 0) {
            cart.getItemsMap().put(product, reminder);
        }else{
            cart.getItemsMap().remove(product);
        }
        return price;
    }

}
