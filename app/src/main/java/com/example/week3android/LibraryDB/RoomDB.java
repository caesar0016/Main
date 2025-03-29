package com.example.week3android.LibraryDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {AvailBook_tbl.class, Book_tbl.class, Payment_tbl.class, UserAccount_tbl.class}, version = 4)
public abstract class RoomDB extends RoomDatabase {
    private static RoomDB INSTANCE;
    public abstract DaoLibrary daoLibrary();
    public static RoomDB getInstance(Context context) {
        if(INSTANCE == null) {
           INSTANCE = Room.databaseBuilder(context.getApplicationContext(), RoomDB.class, "Sample")
                    .fallbackToDestructiveMigration().build();
        }

        return INSTANCE;
    }
}
