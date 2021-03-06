package com.cleancode.kata.item;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Product {

	private String itemCode;
	private double price;

	public Product(String itemCode, double price) {
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

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(itemCode).toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof Product) {
			final Product other = (Product) obj;
			return new EqualsBuilder().append(itemCode, other.getItemCode()).isEquals();
		} else {
			return false;
		}
	}
}
