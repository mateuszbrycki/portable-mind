package com.portablemind.cardCategory.service;


import com.portablemind.card.filter.CardCardCategoryIdFilter;
import com.portablemind.cardCategory.CardCategory;
import com.portablemind.cardCategory.dao.CardCategoryDao;

import com.portablemind.cardCategory.filter.CardCategoryIdFilter;
import com.portablemind.filter.FilterManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Mateusz Brycki on 03/05/2015.
 */
@Service("cardCategoryService")
@Transactional
public class CardCategoryServiceImpl implements CardCategoryService {

    @Inject
    private CardCategoryDao dao;

    @Override
    public void saveCardCategory(CardCategory cardCategory) {
        dao.saveCardCategory(cardCategory);
    }

    @Override
    public void updateCardCategory(CardCategory cardCategory) { dao.updateCardCategory(cardCategory); }

    @Override
    public List<CardCategory> findAllCardCategories() {
        return dao.find(new FilterManager());
    }

    @Override
    public CardCategory findById(Integer id) {
        FilterManager filterManager = new FilterManager();
        filterManager.addFilter(new CardCategoryIdFilter(id));

        //TODO mbrycki wyjątek
        return dao.find(filterManager).get(0);
    }

    @Override
    public void deleteCardCategoryById(Integer id) {
        dao.deleteCardCategoryById(id);
    }
}
