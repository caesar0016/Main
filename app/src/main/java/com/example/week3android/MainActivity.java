package com.example.week3android;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.week3android.LibraryDB.DaoLibrary;
import com.example.week3android.LibraryDB.RoomDB;
import com.example.week3android.LibraryDB.UserAccount_tbl;

public class MainActivity extends AppCompatActivity {

    private DaoLibrary dao;
    private RoomDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);




        Button btnRegister = findViewById(R.id.btnRegister);
        Button btnBook = findViewById(R.id.btnSaveBook1);
        Button btnViewAcc = findViewById(R.id.btnEmptyView);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterForm.class);
                startActivity(intent);
            }
        });

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterBook.class);
                startActivity(intent);
            }
        });

        btnViewAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListAccount.class);
                startActivity(intent);
            }
        });


    }
}