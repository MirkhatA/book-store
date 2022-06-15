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
import java.util.Objects;

import static com.epam.bookstore.constants.PageNameConstants.*;

public class UpdateUserDataService implements Service {
    private final UserDao userDao = new UserDaoImpl();
    private final UserFactory userFactory = UserFactory.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        HttpSession session = req.getSession();

        String email = (String) session.getAttribute("email");
        String mobile = (String) session.getAttribute("mobile");
        Integer langId = (Integer) session.getAttribute("languageId");

        if (userDao.isEmailExist(req.getParameter("email")) && !Objects.equals(req.getParameter("email"), email)) {
            req.setAttribute("emailIsTaken", "This email is already is taken");
            dispatcher = req.getRequestDispatcher(profileJsp);
            dispatcher.forward(req, res);
        } else if (userDao.isNumberExist(req.getParameter("phoneNo")) && !Objects.equals(req.getParameter("phoneNo"), mobile)) {
            req.setAttribute("numberIsTaken", "This number is already is taken");
            dispatcher = req.getRequestDispatcher(profileJsp);
            dispatcher.forward(req, res);
        } else {
            User user = userFactory.setData(req);
            userDao.update(user, langId);

            session.setAttribute("email", user.getEmail());
            session.setAttribute("firstName", user.getFirstName());
            session.setAttribute("lastName", user.getLastName());
            session.setAttribute("address", user.getAddress());
            session.setAttribute("mobile", user.getMobile());

            req.setAttribute("profileSuccessfullyUpdated", "Profile updated successfully!");
            dispatcher = req.getRequestDispatcher(profileJsp);
            dispatcher.forward(req, res);
        }
    }
}
