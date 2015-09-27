package com.portablemind.card.service;

import com.portablemind.card.Card;
import com.portablemind.card.dao.CardDao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Mateusz Brycki on 28/04/2015.
 */
@Service("cardService")
@Transactional
public class CardServiceImpl implements CardService {
    @Inject
    private CardDao dao;

    public void saveCard(Card card) {
        dao.saveCard(card);
    }

    public void updateCard(Card card) { dao.updateCard(card); }

    public List<Card> findAllCards() {
        return dao.findAllCards();
    }

    public List<Card> findAllUserCards(Integer id) {return dao.findAllUserCards(id); }

    public List<Card> findAllProjectCards(Integer id) {return dao.findAllProjectCards(id); }

    public List<Card> findAllUserProjectCards(Integer id, Integer projectId) {return dao.findAllUserProjectCards(id, projectId); }

    public Card findById(Integer id) {
        return dao.findById(id);
    }

    public Integer getCardOwner(Integer id) { return dao.getCardOwner(id); }

    public void deleteCardById(Integer id) {
        dao.deleteCardById(id);
    }
}
