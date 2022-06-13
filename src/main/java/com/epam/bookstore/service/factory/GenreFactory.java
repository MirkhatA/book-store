package com.epam.bookstore.service.factory;

import com.epam.bookstore.dao.GenreDao;
import com.epam.bookstore.dao.impl.GenreDaoImpl;
import com.epam.bookstore.entity.Genre;

import java.sql.SQLException;
import java.util.List;

public class GenreFactory {
    private static GenreFactory instance = new GenreFactory();
    private GenreDao genreDao = (GenreDao) new GenreDaoImpl();

    private GenreFactory() {

    }

    public List<Genre> getGenres() throws SQLException {
        return genreDao.getAll();
    }

    public static GenreFactory getInstance() {
        if (instance == null) {
            instance = new GenreFactory();
        }
        return instance;
    }

}
