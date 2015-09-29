package com.portablemind.filter.hibernate;

import com.portablemind.filter.FilterManager;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by Mateusz on 28.09.2015.
 */
public class HibernatePrepareFilters {

    public static Criteria prepareCriteria(Criteria criteria, FilterManager filterManager) {

        List<HibernateFilter> hibernateFilters = filterManager.getFiltersForHibernate();

        for(HibernateFilter filter : hibernateFilters) {
            criteria.add(filter.execute());
        }

        return criteria;
    }

}