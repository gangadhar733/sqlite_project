package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity9 extends AppCompatActivity {

    TextView contents;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        contents = (TextView) findViewById(R.id.content);
        dbHelper = new DBHelper(MainActivity9.this,DBHelper.DBNAME,null,DBHelper.DBVERSION);
        String data = dbHelper.displayUsers();
        contents.setText(data);

    }
}