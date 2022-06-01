package com.epam.bookstore.entity;

import java.util.Date;
import java.util.Objects;

public class Cart {

    private Long id;
    private Long userId;
    private Long bookId;
    private Integer quantity;
    private Date createdAt;
    private Double price;
    private Double totalPrice;

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) &&
                Objects.equals(userId, cart.userId) &&
                Objects.equals(bookId, cart.bookId) &&
                Objects.equals(quantity, cart.quantity) &&
                Objects.equals(createdAt, cart.createdAt) &&
                Objects.equals(price, cart.price) &&
                Objects.equals(totalPrice, cart.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, bookId, quantity, createdAt, price, totalPrice);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", quantity=" + quantity +
                ", createdAt=" + createdAt +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
