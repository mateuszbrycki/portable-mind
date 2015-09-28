package com.portablemind.filter;

import com.portablemind.filter.hibernate.HibernateCardCategoryFilter;
import com.portablemind.filter.hibernate.HibernateFilter;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class CardCategoryFilter implements Filter {

    private Integer value;

    public CardCategoryFilter(Integer cardCategoryId) {
        this.value = cardCategoryId;
    }

    public HibernateFilter getFilterForHibernate() {
        return new HibernateCardCategoryFilter(this.value);
    }

}
