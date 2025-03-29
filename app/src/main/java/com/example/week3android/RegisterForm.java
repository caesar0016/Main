package com.example.week3android;

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
import com.example.week3android.LibraryDB.UserAccount_tbl;
import com.example.week3android.databinding.ActivityRegisterFormBinding;

public class RegisterForm extends AppCompatActivity {

    private ActivityRegisterFormBinding binding;
    private DaoLibrary dao;
    private RoomDB db;
    EditText txtUsername, txtPassword, txtconPassword, txtRequirements;
    Button btnRegisterBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_form);

        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        txtconPassword = findViewById(R.id.txtconPassword);
        txtRequirements = findViewById(R.id.txtRequirements);

        btnRegisterBook = findViewById(R.id.btnRegisterForm1);


        dao = RoomDB.getInstance(this).daoLibrary();






        btnRegisterBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask.execute(() ->{

                    String Username = txtUsername.getText().toString().trim();
                    String Password = txtPassword.getText().toString().trim();
                    String conPassword = txtconPassword.getText().toString().trim();
                    String requirements = txtRequirements.getText().toString().trim();


                    dao.insertAccount(new UserAccount_tbl(Username, Password, "guest", requirements, false));
//                    Toast.makeText(RegisterForm.this, "Success", Toast.LENGTH_SHORT).show();






                });

            }
        });









    }
}