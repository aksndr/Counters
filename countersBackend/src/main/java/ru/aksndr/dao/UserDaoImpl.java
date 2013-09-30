package ru.aksndr.dao;

import ru.aksndr.entity.User;

import java.io.Serializable;

/**
 * User: a.arzamastsev Date: 29.08.13 Time: 10:20
 */
public class UserDaoImpl extends AbstractDao implements UserDao {

    @Override
    public User getUserById (long userId){
        return (User)getSessionFactory().getCurrentSession().get(User.class, userId);
    }

    @Override
    public void addUser(User user) {
        getSessionFactory().getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user){
        getSessionFactory().getCurrentSession().update(user);
    }
}
