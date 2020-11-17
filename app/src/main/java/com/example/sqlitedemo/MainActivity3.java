package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    EditText userName,passWord;
    DBHelper dbHelper;
    TextView log;

    public static final String DBNAME = "userdb";
    public static final String TBNAME = "users";
    public static final int DBVERSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        userName = (EditText) findViewById(R.id.username);
        passWord = (EditText) findViewById(R.id.psw);

        log=findViewById(R.id.log);

    }

    public void goToFeatures(View view) {
        dbHelper = new DBHelper(MainActivity3.this,DBNAME,null,DBVERSION);
        int res = dbHelper.checkUser(userName.getText().toString(),passWord.getText().toString());
        if (res==1){
            Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
            Intent i = new Intent(MainActivity3.this,MainActivity5.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Login Unsuccessful", Toast.LENGTH_LONG).show();
            Intent i = new Intent(MainActivity3.this,MainActivity2.class);
            startActivity(i);
        }
    }
}