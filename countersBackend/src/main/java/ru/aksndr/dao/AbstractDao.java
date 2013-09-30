package ru.aksndr.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * User: a.arzamastsev Date: 29.08.13 Time: 12:29
 */
public abstract class AbstractDao implements Serializable {
    private static final long serialVersionUID = 2L;
    @Autowired
    public SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
