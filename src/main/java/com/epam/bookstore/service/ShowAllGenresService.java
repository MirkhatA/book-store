package com.epam.bookstore.service;

import com.epam.bookstore.dao.GenreDao;
import com.epam.bookstore.dao.impl.GenreDaoImpl;
import com.epam.bookstore.entity.Genre;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import static com.epam.bookstore.constants.PageNameConstants.genresJsp;

public class ShowAllGenresService implements Service {
    private GenreDao genreDao = new GenreDaoImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = req.getSession();
        Integer langId = (Integer) session.getAttribute("languageId");

        List<Genre> genres = genreDao.getAll(langId);

        session.setAttribute("genres", genres);
        req.getRequestDispatcher(genresJsp).forward(req, res);
    }
}
