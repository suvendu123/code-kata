package com.cleancode.kata.promotion;

import com.cleancode.kata.Cart;

public interface Promotion {
    
    double apply(Cart cart);
    
    double getPrice();

}
