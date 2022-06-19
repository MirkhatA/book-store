package com.epam.bookstore.entity;

import java.util.Objects;

public class Cart {

    private Long id;
    private String userName;
    private String bookName;
    private int quantity;

    public Cart() {
    }

    public Cart(Long id, String userName, String bookName, int quantity) {
        this.id = id;
        this.userName = userName;
        this.bookName = bookName;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return quantity == cart.quantity &&
                Objects.equals(id, cart.id) &&
                Objects.equals(userName, cart.userName) &&
                Objects.equals(bookName, cart.bookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, bookName, quantity);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
