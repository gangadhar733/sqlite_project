package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {

    EditText userName;
    DBHelper dbHelper;

    public static final String DBNAME = "userdb";
    public static final String TBNAME = "users";
    public static final int DBVERSION = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        userName = (EditText) findViewById(R.id.username);

    }

    public void userDelete(View view) {
        dbHelper = new DBHelper(MainActivity7.this,DBNAME,null,DBVERSION);
        dbHelper.deleteUser(userName.getText().toString());
        Toast.makeText(this, "Deletion Successful", Toast.LENGTH_LONG).show();
        Intent i = new Intent(MainActivity7.this,MainActivity5.class);
        startActivity(i);
    }
}