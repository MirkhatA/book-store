package com.epam.bookstore.entity;

import java.util.Objects;

public class BookGenre {

    private Long bookId;
    private Long genreId;

    public BookGenre() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookGenre bookGenre = (BookGenre) o;
        return Objects.equals(bookId, bookGenre.bookId) &&
                Objects.equals(genreId, bookGenre.genreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, genreId);
    }

    @Override
    public String toString() {
        return "BookGenre{" +
                "bookId=" + bookId +
                ", genreId=" + genreId +
                '}';
    }
}
