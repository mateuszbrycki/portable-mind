package com.portablemind.card.dao;

import com.portablemind.card.Card;
import com.portablemind.filter.FilterManager;

import java.util.List;

/**
 * Created by Mateusz Brycki on 28/04/2015.
 */
public interface CardDao {
    void saveCard(Card card);

    void updateCard(Card card);

    List<Card> find(FilterManager filterManager);

    List<Card> find(FilterManager filterManager, Integer page);

    Integer getCardOwner(Integer id);

    void deleteCardById(Integer id);
}
