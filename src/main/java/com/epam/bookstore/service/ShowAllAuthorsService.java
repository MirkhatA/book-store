package com.epam.bookstore.service;

import com.epam.bookstore.dao.AuthorDao;
import com.epam.bookstore.dao.impl.AuthorDaoImpl;
import com.epam.bookstore.entity.Author;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import static com.epam.bookstore.util.PageNameConstants.authorsJsp;

public class ShowAllAuthorsService implements Service {
    private AuthorDao authorDao = new AuthorDaoImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = req.getSession();

        List<Author> authors = authorDao.getAll();

        session.setAttribute("authors", authors);
        res.sendRedirect(authorsJsp);
    }
}
