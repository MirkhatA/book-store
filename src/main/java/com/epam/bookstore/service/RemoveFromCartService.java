package com.epam.bookstore.service;

import com.epam.bookstore.dao.CartDao;
import com.epam.bookstore.dao.impl.CartDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class RemoveFromCartService implements Service {
    CartDao cartDao = new CartDaoImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = req.getSession();
        RequestDispatcher dispatcher;

        Long bookId = Long.parseLong(req.getParameter("id"));
        cartDao.removeBookFromCart(bookId);

        dispatcher = req.getRequestDispatcher("/showCartService");
        dispatcher.forward(req, res);
    }
}
