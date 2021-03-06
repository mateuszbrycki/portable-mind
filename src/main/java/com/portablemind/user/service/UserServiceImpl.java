package com.portablemind.user.service;

import com.portablemind.filter.Filter;
import com.portablemind.filter.FilterManager;
import com.portablemind.user.User;
import com.portablemind.user.dao.UserDao;

import com.portablemind.user.exception.UserNotFoundException;
import com.portablemind.user.filter.UserIdFilter;
import com.portablemind.user.filter.UserMailFilter;
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

    @Override
    public void saveUser(User user) { userDao.saveUser(user);}

    @Override
    public void updateUser(User user) { userDao.updateUser(user);}

    @Override
    public List<User> findAllUsers() {
        return userDao.find(new FilterManager());
    }

    @Override
    public User findUser(Integer id) {
        FilterManager filterManager = new FilterManager();
        filterManager.addFilter(new UserIdFilter(id));
        List<User> users = userDao.find(filterManager);

        if(users.size() != 1) {
            throw new UserNotFoundException("User " + id + " not found.");
        }

        return users.get(0);
    }

    @Override
    public User findByMail(String mail) {
        FilterManager filterManager = new FilterManager();
        filterManager.addFilter(new UserMailFilter(mail));
        List<User> users = userDao.find(filterManager);

        if(users.size() != 1) {
            throw new UserNotFoundException("User with " + mail + " not found.");
        }

        return users.get(0);
    }

    @Override
    public Boolean checkIfUserWithMailExists(String mail) {
        FilterManager filterManager = new FilterManager();
        filterManager.addFilter(new UserMailFilter(mail));
        List<User> users = userDao.find(filterManager);

        if(users.size() == 0) {
            return false;
        }

        return true;
    }

    @Override
    public void deleteUserById(Integer id) { userDao.deleteUserById(id); }
}

