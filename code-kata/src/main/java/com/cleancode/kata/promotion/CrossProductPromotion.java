package com.cleancode.kata.promotion;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        List<Product> products = getProducts(cart);
        if (isItemPresentInCart(products, cart.getItemsMap())) {
            return applyDiscount(products, cart.getItemsMap());
        }
        return 0;
    }

    private double applyDiscount(List<Product> products, Map<Product, Integer> itemsMap) {
        for (Product product : products) {
            if (itemsMap.get(product) != 0) {
                itemsMap.put(product, itemsMap.get(product) - 1);
            } else {
                itemsMap.remove(product);
            }
        }
        return isItemPresentInCart(products, itemsMap) ? price += applyDiscount(products, itemsMap) : price;
    }

    private List<Product> getProducts(Cart cart) {
        return productCodes.stream().map(code -> cart.getItemService().getByCode(code)).collect((Collectors.toList()));
    }

    private boolean isItemPresentInCart(List<Product> products, Map<Product, Integer> itemsMap) {
        for (Product product : products) {
            if (itemsMap.get(product) == 0) {
                itemsMap.remove(product);
            }
            if (itemsMap.getOrDefault(product, null) == null) {
                return false;
            }
        }
        return true;
    }

}
