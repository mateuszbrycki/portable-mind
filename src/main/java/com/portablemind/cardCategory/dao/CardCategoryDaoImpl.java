package com.portablemind.cardCategory.dao;

import com.portablemind.app.AbstractDao;
import com.portablemind.cardCategory.CardCategory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz Brycki on 03/05/2015.
 */
@Repository("cardCategoryDao")
public class CardCategoryDaoImpl extends AbstractDao implements CardCategoryDao {

    public void saveCardCategory(CardCategory cardCategory) {
        persist(cardCategory);
    }

    public void updateCardCategory(CardCategory cardCategory) { update(cardCategory); }

    public List<CardCategory> findAllCardCategories() {
        Criteria criteria = getSession().createCriteria(CardCategory.class);
        return (List<CardCategory>) criteria.list();
    }

    public List<CardCategory> findAllUserCardCategories(Integer id) {
        Query query = getSession().createSQLQuery("SELECT * FROM card_category cc WHERE cc.fk_user_id = :id");
        query.setString("id", id.toString());
        List<Object[]> result = (List<Object[]>) query.list();

        List<CardCategory> cardCategories = new ArrayList<CardCategory>();
        for(Object[] cardCategory : result) {
            cardCategories.add(this.mapCardCategoryObject(cardCategory));
        }

        return cardCategories;
    }

    public void deleteCardCategoryById(Integer id) {
        Query query = getSession().createSQLQuery("DELETE cc.* FROM card_category cc WHERE cc.id = :id");
        query.setString("id", id.toString());
        query.executeUpdate();
    }

    public CardCategory findById(Integer id) {
        Query query = getSession().createSQLQuery("SELECT * FROM card_category cc WHERE cc.id = :id");
        query.setString("id", id.toString());
        List<Object[]> result = query.list();

        return this.mapCardCategoryObject(result.get(0));

    }

    private CardCategory mapCardCategoryObject(Object[] cardCategoryObject) {

        if(cardCategoryObject == null) {
            return null;
        }

        CardCategory cardCategory = new CardCategory();
        cardCategory.setId((Integer)cardCategoryObject[0]);
        cardCategory.setName((String) cardCategoryObject[1]);

        return cardCategory;
    }
}
