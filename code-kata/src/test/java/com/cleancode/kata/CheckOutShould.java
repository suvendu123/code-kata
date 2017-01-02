package com.cleancode.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CheckOutShould {
    
    @Test
    public void should_return_price_for_no_item(){
        CheckOut checkOut = new CheckOut();
        assertEquals(new Double(0), checkOut.total());
        
    }
   

}
