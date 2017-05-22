package ua.goit.offline.chat.validation;

import org.junit.*;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Молния on 20.02.2017.
 */

public class AnotherURLValidatorTest {
    private static URLLinksValidator validator;
    static {
        try {
            AnotherURLValidatorTest.class.getMethod("initClass").invoke(null);
            validator = new URLLinksValidator();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    // 1 times BeforeClass
    @BeforeClass
    public static void initClass()
    {

    }
    // every time before each test
    @Before
    public void init(){
        System.out.println("Call before every time.");

    }
    @Test
    public void testCorrectLinks(){
        // так как наш метод возвращает true или false
        Assert.assertTrue(validator.isValid("hello"));

    }
    @Test
    public void testIncorrectLinks(){
        // так как наш метод возвращает true или false
        Assert.assertTrue(validator.isValid("hello"));

    }
/*    @Test
    public void testIncorrectMessages(){
        Assert.assertEquals(validator.isValid(false, validator.isValid("http://google.com"));
        Assert.assertFalse(validator.isValid("http://google.com"));
    }*/
Object a = new Object();
    @Test
    public void testWithMocks(){
        Object a = new Object();
        validator = Mockito.mock(URLLinksValidator.class);
        Mockito.when(validator.isValid("hello")).thenReturn(true);
        Mockito.when(validator.isValid("http://ok.com")).thenReturn(true);
        Assert.assertTrue(validator.isValid("hello"));
        Assert.assertTrue(validator.isValid("http://ok.com"));
/*        Mockito.verify(validator,Mockito.times(2)).isValid("hello");
        Mockito.verify(validator,Mockito.times(2)).isValid(Mockito.anyString());*/
    }
    /*@After
    @AfterClass*/
}
