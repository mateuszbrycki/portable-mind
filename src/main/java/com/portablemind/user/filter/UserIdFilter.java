package com.portablemind.user.filter;

import com.portablemind.filter.Filter;
import com.portablemind.filter.hibernate.HibernateFilter;
import com.portablemind.user.filter.hibernate.HibernateUserIdFilter;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class UserIdFilter implements Filter {
    private Integer value;

    public UserIdFilter(Integer userId) {
        this.value = userId;
    }

    public HibernateFilter getFilterForHibernate() {
        return new HibernateUserIdFilter(this.value);
    }
}
