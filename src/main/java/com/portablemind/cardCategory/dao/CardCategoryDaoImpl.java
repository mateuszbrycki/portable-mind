package com.portablemind.cardCategory.dao;

import com.portablemind.app.AbstractDao;
import com.portablemind.cardCategory.CardCategory;
import com.portablemind.filter.FilterManager;
import com.portablemind.filter.hibernate.HibernatePrepareFilters;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mateusz Brycki on 03/05/2015.
 */
@Repository("cardCategoryDao")
public class CardCategoryDaoImpl extends AbstractDao implements CardCategoryDao {

    @Override
    public void saveCardCategory(CardCategory cardCategory) {
        persist(cardCategory);
    }

    @Override
    public void updateCardCategory(CardCategory cardCategory) { update(cardCategory); }

    @SuppressWarnings("unchecked")
    @Override
    public List<CardCategory> find(FilterManager filterManager) {
        Criteria criteria = getSession().createCriteria(CardCategory.class);
        criteria = HibernatePrepareFilters.prepareCriteria(criteria, filterManager);

        List<CardCategory>  cardCategories= criteria.list();

        return cardCategories;
    }

    @Override
    public void deleteCardCategoryById(Integer id) {
        Query query = getSession().createSQLQuery("DELETE cc.* FROM card_category cc WHERE cc.id = :id");
        query.setString("id", id.toString());
        query.executeUpdate();
    }
}
