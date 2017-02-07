package ua.goit.offline.chat.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import ua.goit.offline.chat.dao.UserService;
import ua.goit.offline.chat.security.UserDetailsServiceImpl;

/**
 * Created by andreymi on 2/7/2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration
        extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsServiceImpl getUserService(UserService userService) {
        return new UserDetailsServiceImpl(userService);
    }

    //AuthenticationManager

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                //.csrf().ignoringAntMatchers("/test")
                //.and()
                .formLogin();
    }
}
