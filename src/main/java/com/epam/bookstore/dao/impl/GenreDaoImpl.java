package com.epam.bookstore.dao.impl;

import com.epam.bookstore.connection.ConnectionPool;
import com.epam.bookstore.dao.Dao;
import com.epam.bookstore.dao.GenreDao;
import com.epam.bookstore.entity.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenreDaoImpl implements GenreDao {
    private static final String GET_ALL_GENRES = "SELECT * FROM genres WHERE language_id=?;";

    private ConnectionPool connectionPool;
    private Connection connection;

    @Override
    public List<Genre> getAll(int langId) throws SQLException {
        List<Genre> genres = new ArrayList<>();

        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement ps = connection.prepareStatement(GET_ALL_GENRES)) {
            ps.setInt(1, langId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pushToGenreList(genres, rs);
            }
        } finally {
            connectionPool.returnConnection(connection);
        }

        return genres;
    }

    @Override
    public void create(Genre genre) {

    }

    @Override
    public void update(Genre genre, int langId) {

    }

    @Override
    public Genre getById(long id) {
        return null;
    }

    private void pushToGenreList(List<Genre> genres, ResultSet rs) throws SQLException {
        Genre genre = new Genre();

        genre.setId(rs.getLong("id"));
        genre.setName(rs.getString("name"));
        genre.setLanguageId(rs.getString("language_id"));

        genres.add(genre);
    }

}
