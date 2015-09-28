package com.portablemind.filter;

import com.portablemind.filter.hibernate.HibernateFilter;
import com.portablemind.filter.hibernate.HibernateUserFilter;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class UserFilter implements Filter {
    private Integer value;

    public UserFilter(Integer userId) {
        this.value = userId;
    }


    public HibernateFilter getFilterForHibernate() {
        return new HibernateUserFilter(this.value);
    }
}
