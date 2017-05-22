package ua.goit.offline.chat.dao;

import ua.goit.offline.chat.entity.BadWord;

/**
 * Created by Молния on 20.02.2017.
 */
public interface MyBadWordsDao {
    BadWord get(String word);
}
