package com.cleancode.kata;

public class CheckOut {

	private double price;
	
	public Double total() {
		return this.price;
	}

	public void scan(String itemCode) {
		if(itemCode.equals("B")){
			price +=30;
		}
		if(itemCode.equals("A")){
			price +=50;
		}
	}

}
