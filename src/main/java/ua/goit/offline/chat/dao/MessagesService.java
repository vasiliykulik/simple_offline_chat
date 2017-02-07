package ua.goit.offline.chat.dao;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.offline.chat.entity.Message;

import java.util.List;

/**
 * Created by andreymi on 2/7/2017.
 */
public class MessagesService {
    private MessagesDao messagesDao;

    public MessagesService(MessagesDao messagesDao) {
        this.messagesDao = messagesDao;
    }

    @Transactional(readOnly = true)
    public List<Message> getAllMessages() {
        return messagesDao.getAllMessages();
    }

    @Transactional
    public void save(Message message) {
        messagesDao.save(message);
    }
}
