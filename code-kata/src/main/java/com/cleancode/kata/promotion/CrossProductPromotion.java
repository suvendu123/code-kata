package com.cleancode.kata.promotion;

import java.util.List;

import com.cleancode.kata.Cart;

public class CrossProductPromotion implements Promotion {

    private List<String> productCodes;
    private double price;

    public CrossProductPromotion(List<String> productCodes, double price) {
        this.productCodes = productCodes;
        this.price = price;
    }

    @Override
    public double apply(Cart cart) {
         return price;
    }
   

}
