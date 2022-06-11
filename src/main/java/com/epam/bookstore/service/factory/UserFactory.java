package com.epam.bookstore.service.factory;

import com.epam.bookstore.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFactory {
    private static UserFactory instance = new UserFactory();

    private UserFactory() {
    }

    public User setData(HttpServletRequest req) {
        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        return user;
    }



    public static UserFactory getInstance() {
        if (instance == null) {
            instance = new UserFactory();
        }
        return instance;
    }
}
