package com.cleancode.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CheckOutShould {

	private CheckOut checkOut;

	@Before
	public void setUp() {
		checkOut = new CheckOut();
	}

	@Test
	public void should_return_price_for_no_item() {
		assertEquals(new Double(0), checkOut.total());

	}

	@Test
	public void should_return_price_for_one_item() {
		checkOut.scan("A");
		assertEquals(new Double(50), checkOut.total());

	}

	@Test
	public void should_scan_two_item_and_return_total_price() {
		checkOut.scan("A");
		checkOut.scan("B");
		assertEquals(new Double(80), checkOut.total());

	}

	@Test
	public void should_apply_rule_and_calculate_total() {
		checkOut.addRule("A", "3 for 130");
		checkOut.scan("A");
		checkOut.scan("A");
		checkOut.scan("A");
		checkOut.scan("B");
		assertEquals(new Double(160), checkOut.total());

	}

}
