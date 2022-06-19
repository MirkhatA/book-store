package com.epam.bookstore.dao.impl;

import com.epam.bookstore.connection.ConnectionPool;
import com.epam.bookstore.dao.CartDao;
import com.epam.bookstore.entity.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    private static final String GET_CART_BY_USER_ID = "SELECT c.id, CONCAT(first_name, ' ', last_name) AS `name`, b.title AS `book_title`, c.book_id, c.quantity FROM cart c " +
            " JOIN books b ON b.id = c.book_id  JOIN users u ON u.id = c.user_id " +
            " WHERE user_id = ? AND language_id = ?;";
    private static final String ADD_TO_CART_BY_BOOK_ID = "UPDATE cart SET quantity = quantity + 1 WHERE book_id = ?;";
    private static final String REMOVE_FROM_CART_BY_BOOK_ID = "UPDATE cart SET quantity = quantity - 1 WHERE book_id = ?;";

    private ConnectionPool connectionPool;
    private Connection connection;

    @Override
    public List<Cart> getAll(int langId) throws SQLException {
        return null;
    }

    @Override
    public void create(Cart cart) {

    }

    @Override
    public void update(Long id, Cart cart, int langId) throws SQLException {

    }

    @Override
    public Cart getById(long id) {
        return null;
    }

    @Override
    public void addBookToCart(Long bookId) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement ps = connection.prepareStatement(ADD_TO_CART_BY_BOOK_ID)){
            ps.setLong(1, bookId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void removeBookFromCart(Long bookId) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement ps = connection.prepareStatement(REMOVE_FROM_CART_BY_BOOK_ID)){
            ps.setLong(1, bookId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void removeFromCart(Long bookId) {

    }



    @Override
    public List<Cart> getCartByUserId(Long userId, int langId) {
        List<Cart> cartList = new ArrayList<>();

        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement ps = connection.prepareStatement(GET_CART_BY_USER_ID)){
            ps.setLong(1, userId);
            ps.setInt(2, langId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pushToCartList(cartList, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartList;
    }

    private void pushToCartList(List<Cart> cartList, ResultSet rs) throws SQLException {
        Cart cart = new Cart();

        cart.setId(rs.getLong("id"));
        cart.setUserName(rs.getString("name"));
        cart.setBookName(rs.getString("book_title"));
        cart.setBookId(rs.getInt("book_id"));
        cart.setQuantity(rs.getInt("quantity"));

        cartList.add(cart);
    }



}
