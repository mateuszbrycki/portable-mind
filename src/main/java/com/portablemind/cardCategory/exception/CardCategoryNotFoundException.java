package com.portablemind.cardCategory.exception;

/**
 * Created by Mateusz on 30.09.2015.
 */
public class CardCategoryNotFoundException extends RuntimeException{
    public CardCategoryNotFoundException(String message) {
        super(message);
    }
}
