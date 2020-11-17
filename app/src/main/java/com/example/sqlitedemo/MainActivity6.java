package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {

    EditText userName,passWord;
    DBHelper dbHelper;
    TextView adu;

    public static final String DBNAME = "userdb";
    public static final String TBNAME = "users";
    public static final int DBVERSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        userName = (EditText) findViewById(R.id.username);
        passWord = (EditText) findViewById(R.id.psw);
        adu=findViewById(R.id.adu);

    }

    public void userAdd(View view) {
        dbHelper = new DBHelper(MainActivity6.this,DBNAME,null,DBVERSION);
        long res = dbHelper.addUser(userName.getText().toString(),passWord.getText().toString());
        if (res == -1){
            Toast.makeText(this, "Insert Unsuccessful", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Insert Successful", Toast.LENGTH_LONG).show();
        }
        Intent i = new Intent(MainActivity6.this,MainActivity5.class);
        startActivity(i);
    }
}