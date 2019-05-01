package com.minsk.loginapplication;

import com.minsk.loginapplication.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.minsk.loginapplication.HibernateSessionFactoryUtil;
import java.util.List;
import org.hibernate.query.Query;

public class UserDao {

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public List<User> findUser(String login) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String queryString = "from User where login= :value";
        Query queryObject = session.createQuery(queryString);
        queryObject.setParameter("value", login);
        List<User> list = queryObject.list();
        session.close();
        return list;
    }

    public List<User> findAll() {
        List<User> users = (List<User>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }
}
