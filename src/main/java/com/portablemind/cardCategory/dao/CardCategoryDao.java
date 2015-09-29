package com.portablemind.cardCategory.dao;

import com.portablemind.cardCategory.CardCategory;
import com.portablemind.filter.FilterManager;

import java.util.List;

/**
 * Created by Mateusz Brycki on 03/05/2015.
 */
public interface CardCategoryDao {
    void saveCardCategory(CardCategory cardCategory);

    void updateCardCategory(CardCategory cardCategory);

    List<CardCategory> find(FilterManager filterManager);

    void deleteCardCategoryById(Integer id);
}

