package com.epam.bookstore.dao.impl;

import com.epam.bookstore.connection.ConnectionPool;
import com.epam.bookstore.dao.BookDao;
import com.epam.bookstore.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private static final String GET_ALL_BOOKS = "SELECT * FROM books";

    private ConnectionPool connectionPool;
    private Connection connection;

    @Override
    public List<Book> getAll() throws SQLException {
        List<Book> books = new ArrayList<>();

        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement ps = connection.prepareStatement(GET_ALL_BOOKS)){
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pushToBooksList(books, rs);
            }
        } finally {
            connectionPool.returnConnection(connection);
        }

        return books;
    }

    private void pushToBooksList(List<Book> books, ResultSet rs) throws SQLException {
        Book book = new Book();

        book.setId(rs.getLong("id"));
        book.setTitle(rs.getString("title"));
        book.setDescription(rs.getString("description"));
        book.setImage(rs.getString("image"));
        book.setQuantity(rs.getInt("quantity"));
        book.setPrice(rs.getDouble("price"));
        book.setAuthorId(rs.getLong("author_id"));
        book.setPublisherId(rs.getLong("publisher_id"));
        book.setLanguageId(rs.getLong("language_id"));

        books.add(book);
    }

    @Override
    public void create(Book book) {

    }

    @Override
    public void update(Book book, String[] params) {

    }

    @Override
    public Book getById(long id) {
        return null;
    }
}
