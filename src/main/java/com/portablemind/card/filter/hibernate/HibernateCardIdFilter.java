package com.portablemind.card.filter.hibernate;

import com.portablemind.filter.hibernate.HibernateFilter;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class HibernateCardIdFilter implements HibernateFilter {

    private final String PROPERTY_NAME = "id";
    private Integer value = 0;

    public HibernateCardIdFilter(Integer value) {
        this.value = value;
    }

    public Criterion execute() {
        return Restrictions.eq(PROPERTY_NAME, this.value);
    }
}
