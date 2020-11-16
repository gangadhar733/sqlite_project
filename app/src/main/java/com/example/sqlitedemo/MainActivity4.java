package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    EditText userName,passWord;
    DBHelper dbHelper;

    public static final String DBNAME = "userdb";
    public static final String TBNAME = "users";
    public static final int DBVERSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        userName = (EditText) findViewById(R.id.username);
        passWord = (EditText) findViewById(R.id.psw);

    }

    public void goToLogin(View view) {
        dbHelper = new DBHelper(MainActivity4.this,DBNAME,null,DBVERSION);
        long res = dbHelper.addUser(userName.getText().toString(),passWord.getText().toString());
        if (res==-1){
            Toast.makeText(this, "Registration Unsuccessful", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Registration Successful", Toast.LENGTH_LONG).show();
            Intent i = new Intent(MainActivity4.this, MainActivity3.class);
            startActivity(i);
        }
    }
}