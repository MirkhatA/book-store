package com.epam.bookstore.dao;

import com.epam.bookstore.entity.Cart;

import java.util.ArrayList;
import java.util.List;

public interface CartDao extends Dao<Cart> {
    void addBookToCart(Long bookId);

    void removeBookFromCart(Long bookId);

    void removeFromCart(Long bookId);

    List<Cart> getCartByUserId(Long userId, int langId);
}
