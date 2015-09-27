package com.portablemind.user.service;

import com.portablemind.user.User;
import com.portablemind.user.dao.UserDao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Mateusz Brycki on 28/04/2015.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    public void saveUser(User user) { userDao.saveUser(user);}

    public void updateUser(User user) { userDao.updateUser(user);}

    public List<User> findAllUsers() { return userDao.findAllUsers(); }

    public User findById(Integer id) { return userDao.findById(id); }

    public User findByMail(String mail) { return userDao.findByMail(mail); }

    public void deleteUserById(Integer id) { userDao.deleteUserById(id); }
}

