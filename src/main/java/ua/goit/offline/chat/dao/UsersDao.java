package ua.goit.offline.chat.dao;

import ua.goit.offline.chat.entity.User;

/**
 * Created by andreymi on 2/7/2017.
 */
public interface UsersDao {
    User getUser(String username);
}
