package com.epam.bookstore.dao.impl;

import com.epam.bookstore.connection.ConnectionPool;
import com.epam.bookstore.dao.AuthorDao;
import com.epam.bookstore.entity.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {
    private static final String GET_ALL_AUTHORS = "SELECT * FROM authors WHERE language_id=?";

    private ConnectionPool connectionPool;
    private Connection connection;

    @Override
    public List<Author> getAll(int langId) throws SQLException {
        List<Author> authors = new ArrayList<>();

        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement ps = connection.prepareStatement(GET_ALL_AUTHORS)){
            ps.setInt(1, langId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Author author = new Author();
                author.setId(rs.getLong("id"));
                author.setFullName(rs.getString("full_name"));
                author.setLanguageId(rs.getString("language_id"));
                authors.add(author);
            }
        } finally {
            connectionPool.returnConnection(connection);
        }

        return authors;
    }

    @Override
    public void create(Author author) {

    }

    @Override
    public void update(Author author, String[] params) {

    }

    @Override
    public Author getById(long id) {
        return null;
    }
}
