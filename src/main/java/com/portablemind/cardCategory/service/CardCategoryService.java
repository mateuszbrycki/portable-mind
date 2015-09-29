package com.portablemind.cardCategory.service;

import com.portablemind.cardCategory.CardCategory;
import com.portablemind.filter.FilterManager;

import java.util.List;

/**
 * Created by Mateusz Brycki on 03/05/2015.
 */
public interface CardCategoryService {
    void saveCardCategory(CardCategory cardCategory);

    void updateCardCategory(CardCategory cardCategory);

    List<CardCategory> findAllCardCategories();

    CardCategory findById(Integer id);

    void deleteCardCategoryById(Integer id);

}
