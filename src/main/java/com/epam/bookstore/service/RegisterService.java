package com.epam.bookstore.service;

import com.epam.bookstore.dao.UserDao;
import com.epam.bookstore.dao.impl.UserDaoImpl;
import com.epam.bookstore.entity.User;
import com.epam.bookstore.service.factory.UserFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.epam.bookstore.util.PageNameConstants.indexJsp;
import static com.epam.bookstore.util.PageNameConstants.registrationJsp;

public class RegisterService implements Service{
    private final UserDao userDao = new UserDaoImpl();
    private final UserFactory userFactory = UserFactory.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;

        if (userDao.isEmailExist(req.getParameter("email"))) {
            req.setAttribute("emailIsTaken", "This email is already is taken");
            dispatcher = req.getRequestDispatcher(registrationJsp);
            dispatcher.forward(req, res);
        } else if (userDao.isNumberExist(req.getParameter("phoneNo"))) {
            req.setAttribute("numberIsTaken", "This number is already is taken");
            dispatcher = req.getRequestDispatcher(registrationJsp);
            dispatcher.forward(req, res);
        } else {
            User user = userFactory.setData(req);
            userDao.create(user);
            dispatcher = req.getRequestDispatcher(indexJsp);
            dispatcher.forward(req, res);
        }
    }
}
