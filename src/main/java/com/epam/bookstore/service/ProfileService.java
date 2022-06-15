package com.epam.bookstore.service;

import com.epam.bookstore.dao.UserDao;
import com.epam.bookstore.dao.impl.UserDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.epam.bookstore.util.PageNameConstants.errorJsp;
import static com.epam.bookstore.util.PageNameConstants.profileJsp;

public class ProfileService implements Service {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        HttpSession session = req.getSession();

        if (session.getAttribute("email") != null) {
            String login = (String) session.getAttribute("email");

            dispatcher = req.getRequestDispatcher(profileJsp);
            dispatcher.forward(req, res);
        } else {
            dispatcher = req.getRequestDispatcher(errorJsp);
            dispatcher.forward(req, res);
        }
    }
}
