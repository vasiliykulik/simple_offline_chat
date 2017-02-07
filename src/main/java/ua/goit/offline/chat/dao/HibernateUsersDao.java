package ua.goit.offline.chat.dao;

import org.hibernate.SessionFactory;
import ua.goit.offline.chat.entity.User;

/**
 * Created by andreymi on 2/7/2017.
 */
public class HibernateUsersDao implements UsersDao {
    private SessionFactory sessionFactory;

    public HibernateUsersDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User getUser(String username) {
        return sessionFactory.getCurrentSession().createQuery("from User where name=:username", User.class).setParameter("username", username).uniqueResult();
    }
}
