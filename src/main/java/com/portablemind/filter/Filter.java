package com.portablemind.filter;

import com.portablemind.filter.hibernate.HibernateFilter;

/**
 * Created by Mateusz on 28.09.2015.
 */
public interface Filter {

    HibernateFilter getFilterForHibernate();
}
