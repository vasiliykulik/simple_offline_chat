package ua.goit.offline.chat;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Молния on 13.02.2017.
 */
// Классный интерфейс - но он ничего не тестирует
public class TwoTestsSQRT {


    @Test
    public void testCorrect(){
        // double веселый тип - может накинуть пару цифп в конце
        // поэтому зададим точность 1%
        Assert.assertEquals(3,sqrt(9),0.01);
    }

    @Test
    public void testIncorrect(){
        Assert.assertFalse("We encounter some unexpected",1<0);
    }


    private double sqrt(double a){
        if(a<0){
            throw new NumberFormatException ("Wrong number"+a);
        }
        return Math.sqrt(a);
    }
}


