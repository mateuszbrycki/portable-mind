package com.portablemind.card.criteria;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.engine.spi.TypedValue;
import org.hibernate.type.IntegerType;

/**
 * Created by Mateusz Brycki on 24/08/2015.
 */
public class Category implements Criterion {

    private final String propertyName = "fk_category_id";
    private final int value;

    public Category(final int value) {
        this.value = value;
    }

    @Override
    public String toSqlString(final Criteria criteria, final CriteriaQuery criteriaQuery) throws HibernateException {

        final String queryFragment = this.propertyName + " = ?";

        return queryFragment;
    }

    @Override
    public TypedValue[] getTypedValues(final Criteria criteria, final CriteriaQuery criteriaQuery) throws HibernateException {
        return new TypedValue[] { new TypedValue(IntegerType.INSTANCE, Integer.valueOf(value)) };
    }

}
