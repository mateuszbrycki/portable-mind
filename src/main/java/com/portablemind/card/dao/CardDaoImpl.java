package com.portablemind.card.dao;

import com.portablemind.app.AbstractDao;
import com.portablemind.card.Card;
import com.portablemind.cardCategory.service.CardCategoryService;
import com.portablemind.project.service.ProjectService;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz Brycki on 28/04/2015.
 */

@Repository("cardDao")
public class CardDaoImpl extends AbstractDao implements CardDao {

    @Autowired
    ProjectService projectService;

    @Autowired
    CardCategoryService cardCategoryService;

    public void saveCard(Card card) {
        persist(card);
    }

    public void updateCard(Card card) { update(card); }

    public List<Card> findAllCards() {
        Criteria criteria = getSession().createCriteria(Card.class);
        criteria.addOrder(Order.asc("id"));
        return (List<Card>) criteria.list();
    }

    public List<Card> findAllUserCards(Integer id) {
        Query query = getSession().createSQLQuery("SELECT c.* FROM card c WHERE c.fk_user_id = :id");
        query.setString("id", id.toString());
        List<Object[]> result = query.list();

        List<Card> cards = new ArrayList<Card>();

        for(Object[] card : result) {
            cards.add(this.mapCardObject(card));
        }

        return cards;
    }

    public List<Card> findAllProjectCards(Integer id) {
        Query query = getSession().createSQLQuery("SELECT c.* FROM card c WHERE c.fk_project_id = :id");
        query.setString("id", id.toString());
        List<Object[]> result = query.list();

        List<Card> cards = new ArrayList<Card>();

        for(Object[] card : result) {
            cards.add(this.mapCardObject(card));
        }

        return cards;
    }

    public Card findById(Integer id) {
        Query query = getSession().createSQLQuery("SELECT c.* FROM card c WHERE c.id = :id LIMIT 1");
        query.setString("id", id.toString());
        List<Object[]> result = query.list();

        return this.mapCardObject(result.get(0));
    }

    public Integer getCardOwner(Integer id) {
        Query query = getSession().createSQLQuery("SELECT c.fk_user_id FROM card c WHERE c.id = :id LIMIT 1");
        query.setString("id", id.toString());

        return (Integer)query.uniqueResult();
    }

    public void deleteCardById(Integer id) {
        Query query = getSession().createSQLQuery("DELETE c.* FROM card c WHERE c.id = :id");
        query.setString("id", id.toString());
        query.executeUpdate();
    }

    private Card mapCardObject(Object[] cardObject) {

        if(cardObject == null) {
            return null;
        }

        Card card = new Card();
        card.setId((Integer) cardObject[0]);
        card.setOwner((Integer) cardObject[1]);
        card.setCategory(cardCategoryService.findById((Integer) cardObject[2]));
        card.setProject(projectService.findById((Integer) cardObject[3]));
        card.setDescription((String) cardObject[6]);

        return card;
    }


}