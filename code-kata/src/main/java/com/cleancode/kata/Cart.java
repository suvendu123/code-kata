package com.cleancode.kata;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cleancode.kata.item.Product;
import com.cleancode.kata.item.ProductInventory;
import com.cleancode.kata.promotion.Promotion;

public class Cart {

    private Map<Product, Integer> itemsMap;
    private ProductInventory productInventory;
    private double totalPrice;

    public Cart() {
        itemsMap = new HashMap<Product, Integer>();
        productInventory = new ProductInventory();
    }

    public void addItem(Product item) {
        if (itemsMap.getOrDefault(item, null) != null) {
            itemsMap.put(item, itemsMap.get(item) + 1);
        } else {
            itemsMap.put(item, 1);
        }

    }

    public void applyPromotion(List<Promotion> promotions) {
    	promotions.sort(Comparator.comparing(Promotion:: getPrice));
        promotions.forEach(promotion -> totalPrice += promotion.apply(this));

    }

    public Double getTotal() {
        itemsMap.forEach((item, quantity) -> totalPrice += item.getPrice() * quantity);
        return totalPrice;
    }

    public Map<Product, Integer> getItemsMap() {
        return itemsMap;
    }

    public ProductInventory getProductInventory() {
        return productInventory;
    }

}
