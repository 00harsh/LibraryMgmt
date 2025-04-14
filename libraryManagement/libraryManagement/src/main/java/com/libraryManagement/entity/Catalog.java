package com.libraryManagement.entity;

import jakarta.persistence.*;

@Entity
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catalogId;
    private int bookId;
    private String category;
    private String keywords;

    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "bookId", insertable=false, updatable=false)
    private Book book;

    // Getters and Setters


    public Catalog(int catalogId, int bookId, String category, String keywords, Book book) {
        this.catalogId = catalogId;
        this.bookId = bookId;
        this.category = category;
        this.keywords = keywords;
        this.book = book;
    }

    public Catalog() {
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "catalogId=" + catalogId +
                ", bookId=" + bookId +
                ", category='" + category + '\'' +
                ", keywords='" + keywords + '\'' +
                '}';
    }
}
