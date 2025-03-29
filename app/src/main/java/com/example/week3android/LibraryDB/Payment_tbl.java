package com.example.week3android.LibraryDB;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(
        foreignKeys = {
                @ForeignKey(entity = UserAccount_tbl.class,
                parentColumns = "user_id",
                childColumns = "user_id"),

                @ForeignKey(entity = Book_tbl.class,
                parentColumns = "book_id",
                childColumns = "book_id"),
        }
)
public class Payment_tbl {
    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Payment_tbl(int user_id, int book_id, String status) {
        this.user_id = user_id;
        this.book_id = book_id;
        this.status = status;
    }

    @Ignore
    public Payment_tbl(int payment_id, int user_id, int book_id, String status) {
        this.payment_id = payment_id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.status = status;
    }

    @PrimaryKey(autoGenerate = true)
    private int payment_id;
    private int user_id;
    private int book_id;
    private String status = "pending"; //-- pending, paid, etc
}

