package com.cleancode.kata;

import static org.junit.Assert.assertEquals;

import static java.util.Arrays.asList;

import org.junit.Before;
import org.junit.Test;

import com.cleancode.kata.promotion.CrossProductPromotion;
import com.cleancode.kata.promotion.ProductPromotion;

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
        checkOut.addPromotion(new ProductPromotion("A", 3, 130.00));
        checkOut.scan("A");
        scanItemTwoTimes("A");
        checkOut.scan("B");
        assertEquals(new Double(160), checkOut.total());

    }

    @Test
    public void should_apply_a_diffrent_rule_and_calculate_total() {
        checkOut.addPromotion(new ProductPromotion("A", 3, 130.00));
        checkOut.addPromotion(new ProductPromotion("B", 2, 45.00));
        checkOut.scan("A");
        scanItemTwoTimes("B");
        assertEquals(new Double(95), checkOut.total());

    }

    @Test
    public void should_apply_rule_for_multiple_divided_by_quantity() {
        checkOut.addPromotion(new ProductPromotion("B", 2, 45.00));
        scanItemTwoTimes("B");
        scanItemTwoTimes("B");
        checkOut.scan("B");
        assertEquals(new Double(120), checkOut.total());

    }
    
    @Test
    public void should_apply_cross_product_promotion() {
        //given
        checkOut.scan("A");
        checkOut.scan("B");
        
        //when
        checkOut.addPromotion(new CrossProductPromotion(asList("B", "A") , 70.00));
       
        //then
        assertEquals(new Double(70), checkOut.total());

    }
    
    @Test
    public void should_apply_cross_product_promotion_for_multiple_in_number() {
        //given
        scanItemTwoTimes("A");
        scanItemTwoTimes("B");
        
        //when
        checkOut.addPromotion(new CrossProductPromotion(asList("B", "A") , 70.00));
       
        //then
        assertEquals(new Double(140), checkOut.total());

    }
    
    @Test
    public void should_apply_all_type_promotion_at_the_same_time() {
        //given
        scanItemTwoTimes("A");
        scanItemTwoTimes("B");
        scanItemTwoTimes("B");
        checkOut.scan("A");
        
               
        //when
        checkOut.addPromotion(new CrossProductPromotion(asList("B", "A") , 70.00));
        checkOut.addPromotion(new ProductPromotion("B", 2, 45.00));
        checkOut.addPromotion(new ProductPromotion("A", 3, 130.00));
        //then
        assertEquals(new Double(240), checkOut.total());

    }

    private void scanItemTwoTimes(String item) {
        checkOut.scan(item);
        checkOut.scan(item);
    }

}
