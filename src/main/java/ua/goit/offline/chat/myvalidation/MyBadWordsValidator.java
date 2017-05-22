/*
package ua.goit.offline.chat.myvalidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ua.goit.offline.chat.dao.BadWordsDao;

*/
/**
 * Created by Молния on 20.02.2017.*//*



@Component
public class MyBadWordsValidator implements MyValidator{

    private final MyBadWordsValidator badWordsDao;

    @Autowired
    public MyBadWordsValidator(MyBadWordsValidator badWordsDao) {
        this.badWordsDao = badWordsDao;
    }

    @Transactional(readOnly = true)
    @Override
    public boolean isValid(String validate) {
        return !StringUtils.isEmpty(validate) && badWordsDao.get(validate)==null;
    }
}
*/
