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
            session.setAttribute("role", user.getRoleId());
            System.out.println("logged in");
        } else {
            System.out.println("error");
            dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.forward(req, res);
        }
    }
}
