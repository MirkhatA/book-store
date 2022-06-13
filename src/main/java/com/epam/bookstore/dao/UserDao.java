package com.epam.bookstore.dao;

import com.epam.bookstore.entity.User;

public interface UserDao extends Dao<User>{

    User getUserByLoginPassword(String login, String password);

    boolean isNumberExist(String mobile);

    boolean isEmailExist(String email);
}
