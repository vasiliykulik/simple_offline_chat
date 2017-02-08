package ua.goit.offline.chat.security;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import ua.goit.offline.chat.dao.UserService;
import ua.goit.offline.chat.entity.User;

import static org.junit.Assert.assertNotNull;

/**
 * Created by andreymi on 2/8/2017.
 */
public class UserDetailsServiceImplTest {
    private FileSystemXmlApplicationContext applicationContext;
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        applicationContext = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/database-context.xml");
        userService = applicationContext.getBean(UserService.class);
    }

    @After
    public void tearDown() throws Exception {
        applicationContext.close();
    }

    @Test
    public void loadUserByUsername() throws Exception {
        User user = userService.getUser("test");
        assertNotNull(user);
    }

}