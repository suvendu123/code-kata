package com.cleancode.kata.promotion;

import java.util.List;
import java.util.Map;
import java.util.Optional;
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
    public double getPrice() {
        return price;
    }

    @Override
    public double apply(Cart cart) {
        List<Product> products = getProducts(cart);
        return isItemPresentInCart(products, cart.getItemsMap()) ? applyDiscount(products, cart.getItemsMap()) : 0;

    }

    private double applyDiscount(List<Product> products, Map<Product, Integer> itemsMap) {
        products.forEach((product) -> itemsMap.put(product, itemsMap.get(product) - 1));
        return isItemPresentInCart(products, itemsMap) ? price += applyDiscount(products, itemsMap) : price;
    }

    private List<Product> getProducts(Cart cart) {
        return productCodes.stream().map(code -> cart.getProductInventory().getByCode(code))
                .collect((Collectors.toList()));
    }

    private boolean isItemPresentInCart(List<Product> products, Map<Product, Integer> itemsMap) {
        products.forEach((product) -> removeZeroQuantity(product, itemsMap));
        Optional<Product> productNotPresent = products.stream()
                .filter(product -> itemsMap.getOrDefault(product, null) == null).findFirst();
        return productNotPresent.isPresent() ? false : true;
    }

    private void removeZeroQuantity(Product product, Map<Product, Integer> itemsMap) {
        if (itemsMap.containsKey(product) && itemsMap.get(product) == 0) {
            itemsMap.remove(product);
        }

    }

}
