package com.portablemind.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.inject.Inject;


/**
 * Created by Mateusz Brycki on 28/04/2015.
 */
public class AbstractDao {
    @Inject
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void persist(Object entity) {
        getSession().persist(entity);
    }

    public void update(Object entity) { getSession().update(entity);}

    public void delete(Object entity) {
        getSession().delete(entity);
    }
}
