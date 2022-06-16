package com.epam.bookstore.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    List<T> getAll(int langId) throws SQLException;

    void create(T t);

    void update(Long id, T t, int langId) throws SQLException;

    T getById(long id);
}
