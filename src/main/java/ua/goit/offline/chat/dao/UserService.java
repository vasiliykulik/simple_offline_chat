package ua.goit.offline.chat.dao;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.offline.chat.entity.User;

/**
 * Created by andreymi on 2/7/2017.
 */
public class UserService {
    private UsersDao usersDao;

    public UserService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Transactional(readOnly = true)
    public User getUser(String username) {
        return usersDao.getUser(username);
    }
}
