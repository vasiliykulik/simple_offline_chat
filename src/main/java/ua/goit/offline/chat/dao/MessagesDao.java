package ua.goit.offline.chat.dao;

import ua.goit.offline.chat.entity.Message;

import java.util.List;

/**
 * Created by andreymi on 2/7/2017.
 */
public interface MessagesDao {
    List<Message> getAllMessages();

    void save(Message message);
}
