package com.portablemind.card;

import com.portablemind.rest.api.UrlSpace;

/**
 * Created by Mateusz on 27.09.2015.
 */
public class CardUrls implements UrlSpace {

    public class Api {
        public static final String CARDS = "/api/cards";
        public static final String CARD = "/api/card";
        public static final String CARD_ID = "/{cardId}";
    }
}
