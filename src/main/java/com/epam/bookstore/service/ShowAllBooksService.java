package com.epam.bookstore.service;

import com.epam.bookstore.dao.BookDao;
import com.epam.bookstore.dao.impl.BookDaoImpl;
import com.epam.bookstore.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import static com.epam.bookstore.constants.PageNameConstants.booksJsp;

public class ShowAllBooksService implements Service {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = req.getSession();
        Integer langId = (Integer) session.getAttribute("languageId");

        List<Book> books = bookDao.getAll(langId);

        session.setAttribute("books", books);
        req.getRequestDispatcher(booksJsp).forward(req, res);
    }
}
