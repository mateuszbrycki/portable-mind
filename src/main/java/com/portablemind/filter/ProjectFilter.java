package com.portablemind.filter;

import com.portablemind.filter.hibernate.HibernateFilter;
import com.portablemind.filter.hibernate.HibernateProjectFilter;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class ProjectFilter  implements Filter{
    private Integer value;

    public ProjectFilter(Integer userId) {
        this.value = userId;
    }


    public HibernateFilter getFilterForHibernate() {
        return new HibernateProjectFilter(this.value);
    }
}
