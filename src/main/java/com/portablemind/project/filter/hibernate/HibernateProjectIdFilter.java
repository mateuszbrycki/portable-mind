package com.portablemind.project.filter.hibernate;

import com.portablemind.filter.hibernate.HibernateFilter;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class HibernateProjectIdFilter implements HibernateFilter {
    private static final String PROPERTY_NAME = "id";
    private Integer value = 0;

    public HibernateProjectIdFilter(Integer projectId) {
        this.value = projectId;
    }

    public Criterion execute() {
        return Restrictions.eq(PROPERTY_NAME, this.value);
    }
}
