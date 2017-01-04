package com.cleancode.kata.promotion;

import java.util.List;

import com.cleancode.kata.Cart;
import com.cleancode.kata.item.Product;

public class CrossProductPromotion implements Promotion {

    private List<String> productCodes;
    private double price;

    public CrossProductPromotion(List<String> productCodes, double price) {
        this.productCodes = productCodes;
        this.price = price;
    }

    @Override
    public double apply(Cart cart) {
        if (isItemPresentInCart(cart)) {
            for (String code : productCodes) {
                Product product = cart.getItemService().getByCode(code);
                cart.getItemsMap().remove(product);
            }
        }
        return price;
    }

    private boolean isItemPresentInCart(Cart cart) {
        for (String code : productCodes) {
            Product product = cart.getItemService().getByCode(code);
            if (cart.getItemsMap().getOrDefault(product, null) == null) {
                return false;
            }
        }
        return true;
    }

}
