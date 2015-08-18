package com.portablemind.cardCategory.dao;

import com.portablemind.cardCategory.CardCategory;

import java.util.List;

/**
 * Created by Mateusz Brycki on 03/05/2015.
 */
public interface CardCategoryDao {
    void saveCardCategory(CardCategory cardCategory);

    void updateCardCategory(CardCategory cardCategory);

    List<CardCategory> findAllCardCategories();

    CardCategory findById(Integer id);

    void deleteCardCategoryById(Integer id);

    List<CardCategory> findAllUserCardCategories(Integer id);
}

