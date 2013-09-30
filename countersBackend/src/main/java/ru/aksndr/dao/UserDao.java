package ru.aksndr.dao;

import ru.aksndr.entity.User;

/**
 * User: a.arzamastsev Date: 29.08.13 Time: 10:19
 */
public interface UserDao {
    public void addUser(User user);
    public void updateUser(User user);
    public User getUserById (long userId);
}
