package com.epam.bookstore.service.factory;

import com.epam.bookstore.dao.GenreDao;
import com.epam.bookstore.dao.impl.GenreDaoImpl;

public class GenreFactory {
    private static GenreFactory instance = new GenreFactory();
    private GenreDao genreDao = (GenreDao) new GenreDaoImpl();

    private GenreFactory() {
    }

    public static GenreFactory getInstance() {
        if (instance == null) {
            instance = new GenreFactory();
        }
        return instance;
    }

}
