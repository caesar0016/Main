package com.example.week3android;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.week3android.LibraryDB.Book_tbl;
import com.example.week3android.LibraryDB.DaoLibrary;
import com.example.week3android.LibraryDB.RoomDB;

public class RegisterBook extends AppCompatActivity {
    private DaoLibrary dao;
    private RoomDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_book);
        dao = RoomDB.getInstance(this).daoLibrary();

        EditText edAuthor = findViewById(R.id.txtAuthor);
        EditText edTitle = findViewById(R.id.txtTitle);
        EditText edCategory = findViewById(R.id.txtCategory);
        EditText edPrice = findViewById(R.id.txtPrice);
        EditText edQty = findViewById(R.id.txtQty);

        Button btnRegister = findViewById(R.id.btnSaveBook);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String author = edAuthor.getText().toString().trim();
                String title = edTitle.getText().toString().trim();
                String category = edCategory.getText().toString().trim();
                double price = Double.parseDouble(String.valueOf(edPrice.getText()));
                int qty = Integer.parseInt(String.valueOf(edPrice.getText()));

                AsyncTask.execute(() ->{
                    dao.insertBook(new Book_tbl(author, title, category, price, qty, true, false));
                });

            }
        });



    }
}