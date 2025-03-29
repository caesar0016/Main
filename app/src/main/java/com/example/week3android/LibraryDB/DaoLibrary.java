package com.example.week3android.LibraryDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoLibrary {
    //-------------------------- Insert section here ------------------------------------//

    @Insert
    void insertAccount(UserAccount_tbl user);

    @Insert
    void insertBook(Book_tbl book);

    @Insert
    void insertAvailBooking(AvailBook_tbl avail);

    @Insert
    void insertPayment(Payment_tbl payment);


    //-------------------------- Insert Update here ------------------------------------//

    @Query("Update UserAccount_tbl set username = :username, password = :pass, user_type = :userType where user_id = :id")
    void updateAccount(String username, String pass, String userType, int id);

    @Query("Update Book_tbl set author = :author, title = :title, category = :category, price = :price, qty = :qty, is_available = :isAvail, is_archived = :is_archived where book_id = :id")
    void updateBook(String author, String title, String category, double price, int qty, boolean isAvail, boolean is_archived, int id);

    @Query("Update Payment_tbl set user_id = :user_id, book_id = :book_id, status = :status where payment_id = :id")
    void updatePayment(int user_id, int book_id, String status, int id);

    @Query("Update AvailBook_tbl set avail_id = :avail_id, book_id = :book_id, user_id = :user_id, status = :status where avail_id = :id")
    void updateAvailBook(int avail_id, int book_id, int user_id, String status, int id);

    //-------------------------- Delete id here ------------------------------------//

    @Query("Delete from useraccount_tbl where user_id = :id")
    void deleteUserAccount1(int id);
    @Query("Update book_tbl set is_archived = true where book_id = :id")
    void archivedBook(int id);
    @Delete
    void deleteBook(Book_tbl book);

    //-------------------------- Show id here ------------------------------------//

    @Query("Select * from UserAccount_tbl")
    List<UserAccount_tbl> viewUserAccount(); //
    @Query("Select * from UserAccount_tbl where user_id = :id")
    List<UserAccount_tbl> viewAccountById(int id);


    @Query("Select * from Book_tbl where is_archived = false")
    List<Book_tbl> viewCatalog();
    @Query("Select * from Book_tbl where is_archived = :isArchive")
    List<Book_tbl> viewCatalog(boolean isArchive);
    @Query("Select * from Book_tbl")
    List<Book_tbl> viewCatalogAll();
    @Query("Select * from Book_tbl where is_archived = false and book_id = :id")
    List<Book_tbl> viewCatalogById(int id);
    @Query("Select * from Payment_tbl")
    List<Payment_tbl> viewPayment();

    @Query("Select * from AvailBook_tbl where status = :status")
    List<AvailBook_tbl> viewAvailBook(String status);





}
