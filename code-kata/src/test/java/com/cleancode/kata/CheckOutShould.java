package com.cleancode.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CheckOutShould {
    
	private CheckOut checkOut;
	
	@Before
	private void setUp(){
		checkOut =  new CheckOut();
	}
    @Test
    public void should_return_price_for_no_item(){
        assertEquals(new Double(0), checkOut.total());
        
    }
    
    @Test
    public void should_return_price_for_one_item(){
        checkOut.scan("A");
        assertEquals(new Double(50), checkOut.total());
        
    }
   

}
