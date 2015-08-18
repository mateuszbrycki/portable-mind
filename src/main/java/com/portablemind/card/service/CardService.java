package com.portablemind.card.service;

import com.portablemind.card.Card;

import java.util.List;

/**
 * Created by Mateusz Brycki on 28/04/2015.
 */
public interface CardService {
    void saveCard(Card card);

    void updateCard(Card card);

    List<Card> findAllCards();

    List<Card> findAllUserCards(Integer id);

    List<Card> findAllProjectCards(Integer id);

    Card findById(Integer id);

    Integer getCardOwner(Integer id);

    void deleteCardById(Integer id);

}
