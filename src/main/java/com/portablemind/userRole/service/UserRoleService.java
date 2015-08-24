package com.portablemind.userrole.service;

import com.portablemind.userrole.UserRole;

import java.util.Set;

/**
 * Created by Mateusz Brycki on 28/04/2015.
 */
public interface UserRoleService {

    void saveUserRole(UserRole userRole);

    UserRole findById(Integer id);

    UserRole findByName(String role);

    Set<UserRole> findByUserId(Integer userId);
}
