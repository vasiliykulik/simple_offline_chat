package ua.goit.offline.chat.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.offline.chat.entity.Message;

import java.util.List;

/**
 * Created by andreymi on 2/7/2017.
 */
public class HibernateMessageDao implements MessagesDao {

    private SessionFactory sessionFactory;

    public HibernateMessageDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Message> getAllMessages() {
        return sessionFactory.getCurrentSession().createQuery("from Message", Message.class).list();
    }

    public void save(Message message) {
        Session session = sessionFactory.getCurrentSession();
        session.save(message);
    }
}
