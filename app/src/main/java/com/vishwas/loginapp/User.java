package com.vishwas.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        String massage;
        //using getIntent method to get data from MainActivity to User class.
        Intent intent = getIntent();
        // in here getting data user name from MainActivity
        String str = intent.getStringExtra("UserName");
        massage = "Congratulation you've login successfully " + str;
        Toast.makeText(getApplicationContext(), massage, Toast.LENGTH_SHORT).show();

    }
}
