package com.epam.bookstore.entity;

import java.util.Date;
import java.util.Objects;

public class Book {

    private Long id;
    private String title;
    private String description;
    private Date publicationDate;
    private String image;
    private Integer quantity;
    private Double price;
    private Long authorId;
    private Long publisherId;
    private Long languageId;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(title, book.title) &&
                Objects.equals(description, book.description) &&
                Objects.equals(publicationDate, book.publicationDate) &&
                Objects.equals(image, book.image) &&
                Objects.equals(quantity, book.quantity) &&
                Objects.equals(price, book.price) &&
                Objects.equals(authorId, book.authorId) &&
                Objects.equals(publisherId, book.publisherId) &&
                Objects.equals(languageId, book.languageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, publicationDate, image, quantity, price, authorId, publisherId, languageId);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publicationDate=" + publicationDate +
                ", image='" + image + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", authorId=" + authorId +
                ", publisherId=" + publisherId +
                ", languageId=" + languageId +
                '}';
    }
}
