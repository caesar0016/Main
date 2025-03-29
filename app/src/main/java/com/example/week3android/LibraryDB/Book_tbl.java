package com.example.week3android.LibraryDB;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Book_tbl  {
    @PrimaryKey(autoGenerate = true)
    private int book_id;
    private String author;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }

    public boolean isIs_archived() {
        return is_archived;
    }

    public void setIs_archived(boolean is_archived) {
        this.is_archived = is_archived;
    }

    public Book_tbl(String author, String title, String category, double price, int qty, boolean is_available, boolean is_archived) {
        this.author = author;
        this.title = title;
        this.category = category;
        this.price = price;
        this.qty = qty;
        this.is_available = is_available;
        this.is_archived = is_archived;
    }

    @Ignore
    public Book_tbl(int book_id, String author, String title, String category, double price, int qty, boolean is_available, boolean is_archived) {
        this.book_id = book_id;
        this.author = author;
        this.title = title;
        this.category = category;
        this.price = price;
        this.qty = qty;
        this.is_available = is_available;
        this.is_archived = is_archived;
    }

    private String title;
    private String category;
    private double price;
    private int qty;

    private boolean is_available = true;
    private boolean is_archived = false;


}