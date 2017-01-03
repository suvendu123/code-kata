package com.cleancode.kata;

public class Rule {
    private String itemCode;
    private int quantity;
    private double discountedPrice;

    public Rule(String itemCode, int quantity, double discountedPrice) {
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.discountedPrice = discountedPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public double apply(Item item, Integer itemCount) {
        double price = 0;
        int divident = itemCount / this.getQuantity();
        int reminder = itemCount % this.getQuantity();
        if (divident != 0) {
            price += divident * this.getDiscountedPrice();
        }
        if (reminder != 0) {
            price += reminder * item.getPrice();
        }
        return price;
    }

}
