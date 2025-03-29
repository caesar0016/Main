package com.example.week3android;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.week3android.LibraryDB.DaoLibrary;
import com.example.week3android.LibraryDB.RoomDB;

public class UpdateUser extends AppCompatActivity {

    private DaoLibrary dao;
    private RoomDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_user);

        int user_id = getIntent().getIntExtra("user_id", 1);
        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");
        String userType = getIntent().getStringExtra("user_type");


        EditText edUsername = findViewById(R.id.updateUsername);
        EditText edPassword = findViewById(R.id.updatePass);
        EditText edUserType = findViewById(R.id.updateUserType);

        Button btnUpdate = findViewById(R.id.btnUpdateAccount);

        dao = RoomDB.getInstance(this).daoLibrary();


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUsername.getText().toString().trim();
                String password = edPassword.getText().toString().trim();
                String userType = edUserType.getText().toString().trim();

                AsyncTask.execute(() ->{
                    dao.updateAccount(username, password, userType, user_id);
                    Toast.makeText(UpdateUser.this, "Success Update", Toast.LENGTH_SHORT).show();
                });

            }
        });



    }
}