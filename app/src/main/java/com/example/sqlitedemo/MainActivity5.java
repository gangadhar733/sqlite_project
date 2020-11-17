package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity5 extends AppCompatActivity {

    TextView adm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        adm=findViewById(R.id.adm);
    }

    public void userAdd(View view) {
        Intent i = new Intent(MainActivity5.this,MainActivity6.class);
        startActivity(i);
    }

    public void userDelete(View view) {
        Intent i = new Intent(MainActivity5.this,MainActivity7.class);
        startActivity(i);
    }

    public void userUpdate(View view) {
        Intent i = new Intent(MainActivity5.this,MainActivity8.class);
        startActivity(i);
    }

    public void userDisplay(View view) {
        Intent i = new Intent(MainActivity5.this,MainActivity9.class);
        startActivity(i);
    }
}