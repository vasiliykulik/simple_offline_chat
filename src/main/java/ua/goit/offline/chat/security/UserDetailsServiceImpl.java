package ua.goit.offline.chat.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.goit.offline.chat.dao.UserService;
import ua.goit.offline.chat.entity.User;

import java.util.Collections;

import static org.springframework.security.core.userdetails.User.withUsername;

/**
 * Created by andreymi on 2/7/2017.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userService.getUser(username);
            if (user == null) {
                throw new UsernameNotFoundException(username);
            }
            return new UserEntity(user.getName(), user.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority("test")), user);
        } catch (Exception e) {
            throw new UsernameNotFoundException(username);
        }
    }
}
