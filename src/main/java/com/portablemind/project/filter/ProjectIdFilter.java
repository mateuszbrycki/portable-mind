package com.portablemind.project.filter;

import com.portablemind.filter.Filter;
import com.portablemind.filter.hibernate.HibernateFilter;
import com.portablemind.project.filter.hibernate.HibernateProjectIdFilter;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class ProjectIdFilter implements Filter {
    private Integer value;

    public ProjectIdFilter(Integer userId) {
        this.value = userId;
    }


    public HibernateFilter getFilterForHibernate() {
        return new HibernateProjectIdFilter(this.value);
    }
}
