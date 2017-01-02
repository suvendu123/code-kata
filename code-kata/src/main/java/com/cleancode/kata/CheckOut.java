package com.cleancode.kata;

public class CheckOut {

	private String itemCode;

	public Double total() {
		return itemCode != null && itemCode.equals("A") ? 50.00 : 0.00;
	}

	public void scan(String itemCode) {
		this.itemCode = itemCode;
	}

}
