package com.portablemind.user.dao;

import com.portablemind.app.AbstractDao;
import com.portablemind.filter.FilterManager;
import com.portablemind.filter.hibernate.HibernatePrepareFilters;
import com.portablemind.user.User;
import com.portablemind.userrole.service.UserRoleService;
import org.hibernate.Criteria;
import org.hibernate.Query;

import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Mateusz Brycki on 02/05/2015.
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {

    @Inject
    UserRoleService userRoleService;

    @Override
    public void saveUser(User user) {
        persist(user);
    }

    @Override
    public void updateUser(User user) { update(user); }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> find(FilterManager filterManager) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria = HibernatePrepareFilters.prepareCriteria(criteria, filterManager);

        List<User> users = criteria.list();

        return users;
    }

    @Override
    public void deleteUserById(Integer id) {
        Query query = getSession().createSQLQuery("DELETE u.* FROM user u WHERE u.id = :id");
        query.setString("id", id.toString());
        query.executeUpdate();
    }
}
