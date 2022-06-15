package com.epam.bookstore.dao.impl;

import com.epam.bookstore.connection.ConnectionPool;
import com.epam.bookstore.dao.UserDao;
import com.epam.bookstore.entity.User;
import com.epam.bookstore.service.factory.UserFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final String INSERT_USER = "INSERT INTO users (first_name, email, password, mobile, role_id) VALUES(?, ?, ?, ?, ?);";
    private static final String GET_USER_BY_LOGIN_PASSWORD = "SELECT * FROM users WHERE (email=? OR mobile=?) AND password=?;";
    private static final String GET_USER_BY_LOGIN = "SELECT * FROM users WHERE email=?;";
    private static final String GET_USER_BY_MOBILE = "SELECT * FROM users WHERE mobile=?;";

    private ConnectionPool connectionPool;
    private Connection connection;
    private UserFactory userFactory;

    @Override
    public User getUserByLoginPassword(String login, String password) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        User user = null;
        try (PreparedStatement ps = connection.prepareStatement(GET_USER_BY_LOGIN_PASSWORD)){
            ps.setString(1, login);
            ps.setString(2, login);
            ps.setString(3, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                setParameters(user, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean isNumberExist(String mobile) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement ps = connection.prepareStatement(GET_USER_BY_MOBILE)){
            ps.setString(1, mobile);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean isEmailExist(String email) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement ps = connection.prepareStatement(GET_USER_BY_LOGIN)){
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public void setParameters(User user, ResultSet resultSet) throws SQLException {
        user.setId(resultSet.getLong("id"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setAddress(resultSet.getString("address"));
        user.setMobile(resultSet.getString("mobile"));
        user.setRegisteredAt(resultSet.getDate("registered_at"));
        user.setStatus(resultSet.getString("status"));
        user.setRoleId(resultSet.getInt("role_id"));
    }

    @Override
    public List<User> getAll(int langId) {
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