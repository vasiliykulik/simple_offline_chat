package ua.goit.offline.chat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.goit.offline.chat.security.UserDetailsServiceImplTest;

import java.util.Collections;

/**
 * Created by Молния on 13.02.2017.
 */
// Maven что бы заранить Test - имя класса должно заканчмваться на Test
    // Проверим как load-дится пользователь
public class UserServiceTest {
    private UserDetailsService service;
    // Но это же интерфейс, а есть такие Интерфейсы где 45 методов (и каждый раз имплементировать не круто)

    @Before
    public void initService(){
        service = Mockito.mock(UserDetailsService.class);
    }




    @Test
    public void testCorrect(){
        Mockito.when(service.loadUserByUsername("test"))
                .thenReturn(User.withUsername("test")
                        // Хотим что то сложное сделать - @Override
                .password("test")
                .authorities(Collections.emptyList())
                        .build());
        Assert.assertEquals("test",getPassword("test"));
        Mockito.verify(service, Mockito.times(1)).loadUserByUsername("test");
    }

@Test(expected = UsernameNotFoundException.class)


    private String getPassword(String username){
        UserDetails details = service.loadUserByUsername(username);
        if(details==null){
            // по конвенции Spring Security бросаем exception
            throw new UsernameNotFoundException(username);
        }
        return details.getPassword();
    }
}
