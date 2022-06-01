package com.epam.bookstore.entity;

import java.util.Date;
import java.util.Objects;

public class Order {

    private Long id;
    private Long cartId;
    private String address;
    private String mobile;
    private String paymentMethod;
    private Date orderDate;
    private Date deliverDate;
    private String comment;
    private Double total;
    private String status;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(cartId, order.cartId) &&
                Objects.equals(address, order.address) &&
                Objects.equals(mobile, order.mobile) &&
                Objects.equals(paymentMethod, order.paymentMethod) &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(deliverDate, order.deliverDate) &&
                Objects.equals(comment, order.comment) &&
                Objects.equals(total, order.total) &&
                Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cartId, address, mobile, paymentMethod, orderDate, deliverDate, comment, total, status);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", cartId=" + cartId +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", orderDate=" + orderDate +
                ", deliverDate=" + deliverDate +
                ", comment='" + comment + '\'' +
                ", total=" + total +
                ", status='" + status + '\'' +
                '}';
    }
}
