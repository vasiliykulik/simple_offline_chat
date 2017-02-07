package ua.goit.offline.chat.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by andreymi on 2/7/2017.
 */
public class UserEntity extends User {
    private ua.goit.offline.chat.entity.User user;

    public UserEntity(String username, String password, Collection<? extends GrantedAuthority> authorities, ua.goit.offline.chat.entity.User user) {
        super(username, password, authorities);
        this.user = user;
    }

    public ua.goit.offline.chat.entity.User getUser() {
        return user;
    }
}
