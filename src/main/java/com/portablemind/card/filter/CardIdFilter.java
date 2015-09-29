package com.portablemind.card.filter;

import com.portablemind.card.filter.hibernate.HibernateCardIdFilter;
import com.portablemind.filter.Filter;
import com.portablemind.filter.hibernate.HibernateFilter;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class CardIdFilter implements Filter {

    private Integer value;

    public CardIdFilter(Integer cardId) {
        this.value = cardId;
    }

    public HibernateFilter getFilterForHibernate() {
        return new HibernateCardIdFilter(this.value);
    }

}
