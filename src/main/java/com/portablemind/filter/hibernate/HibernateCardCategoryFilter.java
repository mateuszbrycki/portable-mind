package com.portablemind.filter.hibernate;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class HibernateCardCategoryFilter implements HibernateFilter {

    private final String PROPERTY_NAME = "category.id";
    private Integer value = 0;

    public HibernateCardCategoryFilter(Integer value) {
        this.value = value;
    }

    public Criterion execute() {

        return Restrictions.eq(PROPERTY_NAME, this.value);
    }

}
