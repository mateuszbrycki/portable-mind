package com.portablemind.card.criteria;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.engine.spi.TypedValue;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

/**
 * Created by Mateusz Brycki on 24/08/2015.
 */
public class Description implements Criterion {

    private final String propertyName = "card_description";
    private final String part;

    public Description(final String part) {
        this.part = part;
    }

    @Override
    public String toSqlString(final Criteria criteria, final CriteriaQuery criteriaQuery) throws HibernateException {

        final String queryFragment = this.propertyName + " LIKE(%?%)";

        return queryFragment;
    }

    @Override
    public TypedValue[] getTypedValues(final Criteria criteria, final CriteriaQuery criteriaQuery) throws HibernateException {
        return new TypedValue[] { new TypedValue(StringType.INSTANCE, this.part)  };
    }

}
