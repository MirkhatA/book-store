package com.epam.bookstore.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.epam.bookstore.constants.PageNameConstants.indexJsp;

public class ChangeToEnglishService implements Service {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = req.getSession();

        session.setAttribute("language", "en");
        req.getRequestDispatcher(indexJsp).forward(req, res);
    }
}
