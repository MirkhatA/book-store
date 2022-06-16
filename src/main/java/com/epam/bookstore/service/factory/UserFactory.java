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
        user.setLastName(req.getParameter("lastName"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setAddress(req.getParameter("address"));
        user.setMobile(req.getParameter("phoneNo"));

        return user;
    }

    public static UserFactory getInstance() {
        if (instance == null) {
            instance = new UserFactory();
        }
        return instance;
    }
}
