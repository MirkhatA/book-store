package com.epam.bookstore.dao;

import com.epam.bookstore.entity.User;

public interface UserDao extends Dao<User>{

    User getById(Long id);

    User getUserByLoginPassword(String login, String password);


}
