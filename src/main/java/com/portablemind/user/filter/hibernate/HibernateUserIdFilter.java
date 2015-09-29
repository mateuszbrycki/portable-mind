package com.portablemind.user.filter.hibernate;

import com.portablemind.filter.hibernate.HibernateFilter;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class HibernateUserIdFilter implements HibernateFilter {

    private static final String PROPERTY_NAME = "id";
    private Integer value = 0;

    public HibernateUserIdFilter(Integer userId) {
        this.value = userId;
    }

    public Criterion execute() {
        return Restrictions.eq(PROPERTY_NAME, this.value);
    }
}
