package com.portablemind.card.dao;

import com.portablemind.app.AbstractDao;
import com.portablemind.card.Card;
import com.portablemind.cardCategory.service.CardCategoryService;
import com.portablemind.filter.FilterManager;
import com.portablemind.filter.hibernate.HibernatePrepareFilters;
import com.portablemind.project.service.ProjectService;
import com.portablemind.user.service.UserService;

import org.hibernate.Criteria;
import org.hibernate.Query;

import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Mateusz Brycki on 28/04/2015.
 */

@Repository("cardDao")
public class CardDaoImpl extends AbstractDao implements CardDao {

    @Inject
    ProjectService projectService;

    @Inject
    CardCategoryService cardCategoryService;

    @Inject
    UserService userService;

    @Override
    public void saveCard(Card card) {
        persist(card);
    }

    @Override
    public void updateCard(Card card) { update(card); }

    @SuppressWarnings("unchecked")
    @Override
    public List<Card> find(FilterManager filterManager) {

        Criteria criteria = getSession().createCriteria(Card.class);
        criteria = HibernatePrepareFilters.prepareCriteria(criteria, filterManager);
        List<Card> cards = criteria.list();

        return cards;
    }

    @Override
    public Integer getCardOwner(Integer id) {
        Query query = getSession().createSQLQuery("SELECT c.fk_user_id FROM card c WHERE c.id = :id LIMIT 1");
        query.setString("id", id.toString());

        return (Integer)query.uniqueResult();
    }

    @Override
    public void deleteCardById(Integer id) {
        Query query = getSession().createSQLQuery("DELETE c.* FROM card c WHERE c.id = :id");
        query.setString("id", id.toString());
        query.executeUpdate();
    }
}