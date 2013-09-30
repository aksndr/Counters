package ru.aksndr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aksndr.dao.UserDao;
import ru.aksndr.entity.User;

import java.io.Serializable;

/**
 * User: a.arzamastsev Date: 29.08.13 Time: 10:25
 */
public class UserServiceImpl implements UserService, Serializable {

    @Autowired
    public UserDao userDao;

    public UserDao getUserDao(){
        return userDao;
    }

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Transactional(readOnly = false)
    @Override
    public void addUser(User user) {
        getUserDao().addUser(user);
    }

    @Transactional(readOnly = false)
    @Override
    public void updateUser(User user){
        getUserDao().updateUser(user);
    }

    @Transactional(readOnly = false)
    @Override
    public User getUserById (long userId){
        return getUserDao().getUserById(userId);
    }
}
