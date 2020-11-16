package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void goToLogin(View view) {
        Intent i = new Intent(MainActivity2.this, MainActivity3.class);
        startActivity(i);
    }

    public void goToRegister(View view) {
        Intent i = new Intent(MainActivity2.this, MainActivity4.class);
        startActivity(i);
    }
}