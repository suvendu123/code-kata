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

}
