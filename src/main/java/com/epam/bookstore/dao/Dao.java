package com.epam.bookstore.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    List<T> getAll() throws SQLException;

    void create(T t);

    void update(T t, String[] params);

    T getById(long id);
}
