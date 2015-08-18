package com.portablemind.cardCategory.service;


import com.portablemind.cardCategory.CardCategory;
import com.portablemind.cardCategory.dao.CardCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mateusz Brycki on 03/05/2015.
 */
@Service("cardCategoryService")
@Transactional
public class CardCategoryServiceImpl implements CardCategoryService {

    @Autowired
    private CardCategoryDao dao;

    public void saveCardCategory(CardCategory cardCategory) {
        dao.saveCardCategory(cardCategory);
    }

    public void updateCardCategory(CardCategory cardCategory) { dao.updateCardCategory(cardCategory); }

    public List<CardCategory> findAllCardCategories() {
        return dao.findAllCardCategories();
    }

    public CardCategory findById(Integer id) { return dao.findById(id); }

    public void deleteCardCategoryById(Integer id) {
        dao.deleteCardCategoryById(id);
    }

    public List<CardCategory> findAllUserCardCategories(Integer id) {
        return dao.findAllUserCardCategories(id);
    }
}
