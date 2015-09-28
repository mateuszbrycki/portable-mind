package com.portablemind.filter.hibernate;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class HibernateProjectFilter implements HibernateFilter {
    private static final String PROPERTY_NAME = "project.id";
    private Integer value = 0;

    public HibernateProjectFilter(Integer projectId) {
        this.value = projectId;
    }

    public Criterion execute() {
        return Restrictions.eq(PROPERTY_NAME, this.value);
    }
}
