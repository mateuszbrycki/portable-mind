package com.portablemind.card.filter;

import com.portablemind.card.filter.hibernate.HibernateCardProjectIdFilter;
import com.portablemind.filter.Filter;
import com.portablemind.filter.hibernate.HibernateFilter;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class CardProjectIdFilter implements Filter {
    private Integer value;

    public CardProjectIdFilter(Integer userId) {
        this.value = userId;
    }


    public HibernateFilter getFilterForHibernate() {
        return new HibernateCardProjectIdFilter(this.value);
    }
}
