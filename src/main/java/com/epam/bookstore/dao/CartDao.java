package com.epam.bookstore.dao;

import com.epam.bookstore.entity.Cart;

import java.util.List;

public interface CartDao extends Dao<Cart> {
    List<Cart> addBookToCart(Long bookId);

    List<Cart> getCartByUserId(Long userId, int langId);
}
