package com.portablemind.card.filter.hibernate;

import com.portablemind.filter.hibernate.HibernateFilter;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class HibernateCardProjectIdFilter implements HibernateFilter {
    private static final String PROPERTY_NAME = "project.id";
    private Integer value = 0;

    public HibernateCardProjectIdFilter(Integer projectId) {
        this.value = projectId;
    }

    public Criterion execute() {
        return Restrictions.eq(PROPERTY_NAME, this.value);
    }
}
