package com.epam.bookstore.service;

import com.epam.bookstore.dao.UserDao;
import com.epam.bookstore.dao.impl.UserDaoImpl;
import com.epam.bookstore.entity.User;
import com.epam.bookstore.service.factory.UserFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.epam.bookstore.constants.PageNameConstants.indexJsp;
import static com.epam.bookstore.constants.PageNameConstants.loginJsp;

public class LoginService implements Service{
    private final UserDao userDao = new UserDaoImpl();
    private final UserFactory userFactory = UserFactory.getInstance();
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        HttpSession session = req.getSession();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = userDao.getUserByLoginPassword(login, password);

        if (user != null) {
            session.setAttribute("userId", user.getId());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("firstName", user.getFirstName());
            session.setAttribute("lastName", user.getLastName());
            session.setAttribute("address", user.getAddress());
            session.setAttribute("mobile", user.getMobile());
            session.setAttribute("role", user.getRoleId());

            dispatcher = req.getRequestDispatcher(indexJsp);
            dispatcher.forward(req, res);
        } else {
            req.setAttribute("loginError", "Login error");
            dispatcher = req.getRequestDispatcher(loginJsp);
            dispatcher.forward(req, res);
        }
    }
}
