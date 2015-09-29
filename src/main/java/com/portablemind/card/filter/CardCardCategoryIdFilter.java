package com.portablemind.card.filter;

import com.portablemind.card.filter.hibernate.HibernateCardCardCategoryIdFilter;
import com.portablemind.filter.Filter;
import com.portablemind.filter.hibernate.HibernateFilter;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class CardCardCategoryIdFilter implements Filter {

    private Integer value;

    public CardCardCategoryIdFilter(Integer cardCategoryId) {
        this.value = cardCategoryId;
    }

    public HibernateFilter getFilterForHibernate() {
        return new HibernateCardCardCategoryIdFilter(this.value);
    }

}
