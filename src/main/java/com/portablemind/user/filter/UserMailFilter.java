package com.portablemind.user.filter;

import com.portablemind.filter.Filter;
import com.portablemind.filter.hibernate.HibernateFilter;
import com.portablemind.user.filter.hibernate.HibernateUserMailFilter;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class UserMailFilter implements Filter {
    private String value;

    public UserMailFilter(String userMail) {
        this.value = userMail;
    }

    public HibernateFilter getFilterForHibernate() {
        return new HibernateUserMailFilter(this.value);
    }
}
