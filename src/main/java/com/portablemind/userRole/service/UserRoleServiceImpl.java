package com.portablemind.userrole.service;

import com.portablemind.userrole.UserRole;
import com.portablemind.userrole.dao.UserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by Mateusz Brycki on 28/04/2015.
 */
@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    public void saveUserRole(UserRole userRole) {
        userRoleDao.saveUserRole(userRole);
    }

    public UserRole findById(Integer id) { return userRoleDao.findById(id); }

    public UserRole findByName(String role) { return userRoleDao.findByName(role); }

    public Set<UserRole> findByUserId(Integer userId) {return userRoleDao.findByUserId(userId);}
}

