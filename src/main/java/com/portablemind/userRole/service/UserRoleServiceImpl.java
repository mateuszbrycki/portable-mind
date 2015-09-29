package com.portablemind.userrole.service;

import com.portablemind.userrole.UserRole;
import com.portablemind.userrole.dao.UserRoleDao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Set;

/**
 * Created by Mateusz Brycki on 28/04/2015.
 */
@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

    @Inject
    private UserRoleDao userRoleDao;

    @Override
    public void saveUserRole(UserRole userRole) {
        userRoleDao.saveUserRole(userRole);
    }

    @Override
    public UserRole findById(Integer id) { return userRoleDao.findById(id); }

    @Override
    public UserRole findByName(String role) { return userRoleDao.findByName(role); }

    @Override
    public Set<UserRole> findByUserId(Integer userId) {return userRoleDao.findByUserId(userId);}
}

