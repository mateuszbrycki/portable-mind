package com.portablemind.card.service;

import com.portablemind.card.Card;
import com.portablemind.card.dao.CardDao;

import com.portablemind.card.exception.CardNotFoundException;
import com.portablemind.card.filter.CardCardCategoryIdFilter;
import com.portablemind.card.filter.CardIdFilter;
import com.portablemind.card.filter.CardProjectIdFilter;
import com.portablemind.filter.FilterManager;
import com.portablemind.user.filter.OwnerIdFilter;
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

    @Override
    public void saveCard(Card card) {
        dao.saveCard(card);
    }

    @Override
    public void updateCard(Card card) { dao.updateCard(card); }

    @Override
    public List<Card> findAllCards() {

        FilterManager filterManager = new FilterManager();
        return dao.find(filterManager);
    }

    @Override
    public List<Card> findAllUserCards(Integer id) {

        FilterManager filterManager = new FilterManager();
        filterManager.addFilter(new OwnerIdFilter(id));

        return dao.find(filterManager);
    }

    @Override
    public List<Card> findAllProjectCards(Integer id) {

        FilterManager filterManager = new FilterManager();
        filterManager.addFilter(new CardProjectIdFilter(id));

        return dao.find(filterManager);
    }

    @Override
    public List<Card> findAllUserProjectCards(Integer userId, Integer projectId) {

        FilterManager filterManager = new FilterManager();
        filterManager.addFilter(new OwnerIdFilter(userId));
        filterManager.addFilter(new CardProjectIdFilter(projectId));

        return dao.find(filterManager);
    }

    @Override
    public List<Card> findAllUserProjectCards(Integer userId, Integer projectId, Integer categoryId) {

        FilterManager filterManager = new FilterManager();
        filterManager.addFilter(new OwnerIdFilter(userId));
        filterManager.addFilter(new CardProjectIdFilter(projectId));
        filterManager.addFilter(new CardCardCategoryIdFilter(categoryId));

        return dao.find(filterManager);
    }

    @Override
    public Card findCard(Integer id) {

        FilterManager filterManager = new FilterManager();
        filterManager.addFilter(new CardIdFilter(id));
        List<Card> cards = dao.find(filterManager);

        if(cards.isEmpty()) {
            throw new CardNotFoundException("Card " + id + " not found.");
        }

        return dao.find(filterManager).get(0);
    }

    @Override
    public Integer getCardOwner(Integer id) { return dao.getCardOwner(id); }

    @Override
    public void deleteCardById(Integer id) {
        dao.deleteCardById(id);
    }
}
