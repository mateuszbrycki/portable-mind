package com.portablemind.cardCategory.filter;

import com.portablemind.filter.Filter;
import com.portablemind.cardCategory.filter.hibernate.HibernateCardCategoryIdFilter;
import com.portablemind.filter.hibernate.HibernateFilter;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class CardCategoryIdFilter implements Filter {

    private Integer value;

    public CardCategoryIdFilter(Integer cardCategoryId) {
        this.value = cardCategoryId;
    }

    public HibernateFilter getFilterForHibernate() {
        return new HibernateCardCategoryIdFilter(this.value);
    }

}
