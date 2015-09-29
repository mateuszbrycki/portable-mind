package com.portablemind.user.filter;

import com.portablemind.filter.Filter;
import com.portablemind.filter.hibernate.HibernateFilter;
import com.portablemind.user.filter.hibernate.HibernateOwnerIdFilter;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class OwnerIdFilter implements Filter {
    private Integer value;

    public OwnerIdFilter(Integer userId) {
        this.value = userId;
    }


    public HibernateFilter getFilterForHibernate() {
        return new HibernateOwnerIdFilter(this.value);
    }
}
