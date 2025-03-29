package com.example.week3android.LibraryDB;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(
        foreignKeys = {
                @ForeignKey(entity = Book_tbl.class,
                parentColumns = "book_id",
                childColumns = "book_id"
                ),
                @ForeignKey(entity = UserAccount_tbl.class,
                parentColumns = "user_id",
                childColumns = "user_id"
                )
        }
)
public class AvailBook_tbl {
    @PrimaryKey(autoGenerate = true)
    private int avail_id;
    private int book_id;
    private int user_id;
    private String start_date;
    private String end_date;
    private String status = "pending";

    public AvailBook_tbl(int book_id, int user_id, String start_date, String end_date, String status) {
        this.book_id = book_id;
        this.user_id = user_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
    }

    @Ignore
    public AvailBook_tbl(int avail_id, int book_id, int user_id, String start_date, String end_date, String status) {
        this.avail_id = avail_id;
        this.book_id = book_id;
        this.user_id = user_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
    }

    public int getAvail_id() {
        return avail_id;
    }

    public void setAvail_id(int avail_id) {
        this.avail_id = avail_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
