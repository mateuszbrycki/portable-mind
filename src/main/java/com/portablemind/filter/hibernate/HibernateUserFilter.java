package com.portablemind.filter.hibernate;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class HibernateUserFilter implements HibernateFilter{

    private static final String PROPERTY_NAME = "owner.id";
    private Integer value = 0;

    public HibernateUserFilter(Integer userId) {
        this.value = userId;
    }

    public Criterion execute() {
        return Restrictions.eq(PROPERTY_NAME, this.value);
    }
}
