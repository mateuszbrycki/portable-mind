package com.portablemind.card.exception;

/**
 * Created by Mateusz on 30.09.2015.
 */
public class CardNotFoundException extends RuntimeException {

    public CardNotFoundException(String message) {
        super(message);
    }

}
