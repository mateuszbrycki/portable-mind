package com.portablemind.user.dao;

import com.portablemind.filter.FilterManager;
import com.portablemind.user.User;

import java.util.List;

/**
 * Created by Mateusz Brycki on 02/05/2015.
 */
public interface UserDao {
    void saveUser(User user);

    void updateUser(User user);

    List<User> find(FilterManager filterManager);

    void deleteUserById(Integer id);

}

