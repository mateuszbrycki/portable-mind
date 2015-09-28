package com.portablemind.user.dao;

import com.portablemind.app.AbstractDao;
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

    public void saveUser(User user) {
        persist(user);
    }

    public void updateUser(User user) { update(user); }

    public List<User> findAllUsers() {
        Criteria criteria = getSession().createCriteria(User.class);
        return (List<User>) criteria.list();
    }

    public User findById(Integer id) {
        Query query = getSession().createSQLQuery("SELECT u.* FROM user u WHERE u.id = :id");
        query.setString("id", id.toString());

        return this.mapUserObject(query.list());
    }

    public User findByMail(String mail) {
        Query query = getSession().createSQLQuery("SELECT u.* FROM user u WHERE u.mail = :mail LIMIT 1");
        query.setString("mail", mail);

        return this.mapUserObject(query.list());
    }

    public void deleteUserById(Integer id) {
        Query query = getSession().createSQLQuery("DELETE u.* FROM user u WHERE u.id = :id");
        query.setString("id", id.toString());
        query.executeUpdate();
    }

    private User mapUserObject(List<Object[]> userObj) {

        if(userObj.size() < 1) {
            return null;
        }

        User user = new User();
        user.setId((Integer) (userObj.get(0))[0]);
        user.setRole(userRoleService.findById((Integer) (userObj.get(0))[1]));
        user.setMail((String) (userObj.get(0))[2]);
        user.setPassword((String) (userObj.get(0))[3]);
        user.setIsPublic((Boolean) (userObj.get(0))[6]);
        user.setIsEnabled((Boolean)(userObj.get(0))[7]);

        return user;
    }

}
