package com.epam.bookstore.dao.impl;

import com.epam.bookstore.connection.ConnectionPool;
import com.epam.bookstore.dao.UserDao;
import com.epam.bookstore.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static final String INSERT_USER = "INSERT INTO users (first_name, email, password, mobile, role_id) VALUES(?, ?, ?, ?, ?);";

    private ConnectionPool connectionPool;
    private Connection connection;

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public User getUserByEmailPassword(String email, String password) {
        return null;
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void create(User user) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement ps = connection.prepareStatement(INSERT_USER)){
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getMobile());
            ps.setInt(5, 1);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user, String[] params) {

    }

    @Override
    public User getById(long id) {
        return null;
    }
}