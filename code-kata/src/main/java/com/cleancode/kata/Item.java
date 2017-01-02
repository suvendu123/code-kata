package com.cleancode.kata;

public class Item {

	private String itemCode;
	private double price;

	public Item(String itemCode, double price) {
		this.itemCode = itemCode;
		this.price = price;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
