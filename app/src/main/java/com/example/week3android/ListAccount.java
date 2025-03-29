package com.example.week3android;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week3android.LibraryDB.Adapters.AccountAdapter;
import com.example.week3android.LibraryDB.DaoLibrary;
import com.example.week3android.LibraryDB.RoomDB;
import com.example.week3android.LibraryDB.UserAccount_tbl;

import java.util.ArrayList;
import java.util.List;

public class ListAccount extends AppCompatActivity {

    private DaoLibrary dao;
    private RoomDB db;
    private List<UserAccount_tbl> list;
    private AccountAdapter accountAdapter;

    private RecyclerView rvAccounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_book);  // make sure this layout contains RecyclerView with id rvAccount

        rvAccounts = findViewById(R.id.rvAccount);

        // Initialize the list and adapter
        list = new ArrayList<>();

        // Set a default or placeholder user (this is just for testing, remove later)
        list.add(new UserAccount_tbl("username", "123", "guest", "req1", false));

        // Initialize the adapter
        accountAdapter = new AccountAdapter(list, this);

        // Set the adapter to RecyclerView
        rvAccounts.setAdapter(accountAdapter);

        // Set a LayoutManager for RecyclerView (this is required)
        rvAccounts.setLayoutManager(new LinearLayoutManager(this));

        // Initialize Room Database and DaoLibrary
        dao = RoomDB.getInstance(this).daoLibrary();

        // Fetch the data from the Room Database
        fetchUserAccounts();
    }

    private void fetchUserAccounts() {
        // Fetch data from Room Database in a background thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Replace this with the actual method to fetch the accounts from your Room database
                List<UserAccount_tbl> userAccounts = dao.viewUserAccount();

                // Run on the UI thread to update the RecyclerView with new data
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Update the list with the new data
                        list.clear();
                        list.addAll(userAccounts);

                        // Notify the adapter that the data has changed
                        accountAdapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();
    }


}
