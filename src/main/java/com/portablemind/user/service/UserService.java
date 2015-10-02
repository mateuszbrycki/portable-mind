package com.portablemind.user.service;

import com.portablemind.user.User;

import java.util.List;

/**
 * Created by Mateusz Brycki on 28/04/2015.
 */
public interface UserService {
    void saveUser(User user);

    void updateUser(User user);

    List<User> findAllUsers();

    User findUser(Integer id);

    User findByMail(String mail);

    Boolean checkIfUserWithMailExists(String mail);

    void deleteUserById(Integer id);
}
