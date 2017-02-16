package ua.goit.offline.chat;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Молния on 13.02.2017.
 */
public class DivisionTest {
    // Junit выпустила 5 версию (в основн исп 4 вер - конфигится Аннотациями)
    // мктод должен быть public void

    @Test
    public void testCorrect(){
        // double веселый тип - может накинуть пару цифп в конце
        // поэтому зададим точность 1%
        Assert.assertEquals(2,div(4,2),0.01);
    }
// И сразу сожем увидеть что не работает
    @Test
    public void testIncorrect(){
        Assert.assertFalse("We encounter some unexpected",div(5,2)==3);
    }

/*
    @Test(expected = )
    public void testLimits2(){
        div(1,0);
    }
*/


@Test
public void testLimits(){
        div(1,0);
        }

/*    @Test
    public void testLimits1(){
    // Интересная штука (доходит до 127 и начинает с -127), integer не поставит, и позволит только прменив L(к лонгу)
        for(byte i=0; i<128;i++){
                    }
        div(1,0.0);
    }*/


    private int div(int a, int b){
        return a/b;
    }


    // тестируем деление двух чисел
    private double div(double a, double b){
        return a/b;
    }
}
