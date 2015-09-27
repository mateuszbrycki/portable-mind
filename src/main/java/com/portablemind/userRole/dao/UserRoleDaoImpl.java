package com.portablemind.userrole.dao;

import com.portablemind.app.AbstractDao;
import com.portablemind.userrole.UserRole;
import com.portablemind.userrole.service.UserRoleService;
import org.hibernate.Query;

import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Mateusz Brycki on 02/05/2015.
 */
@Repository("userRoleDao")
public class UserRoleDaoImpl extends AbstractDao implements UserRoleDao {

    @Inject
    UserRoleService userRoleService;

    public void saveUserRole(UserRole userRole) {
        persist(userRole);
    }

    public UserRole findById(Integer id) {
        Query query = getSession().createSQLQuery("select * from user_role where id = :id");
        query.setString("id", id.toString());

        return this.mapUserRoleObject(query.list());
    }

    public UserRole findByName(String role) {
        Query query = getSession().createSQLQuery("select * from user_role where role = :role");
        query.setString("role", role);

        return this.mapUserRoleObject(query.list());
    }

    public Set<UserRole> findByUserId(Integer id) {
        Query query = getSession().createSQLQuery("select * from user_role where id = :id");
        query.setString("id", id.toString());

        return new HashSet<UserRole>();
    }

    private UserRole mapUserRoleObject(List<Object[]> userRoleObj) {

        UserRole userRole = new UserRole();
        userRole.setId((Integer)(userRoleObj.get(0))[0]);
        userRole.setRole((String)(userRoleObj.get(0))[1]);

        return userRole;
    }

}
