// Model
package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


//    To-do:
//    1. Class extends SQLiteOpenHelper
//    2. Implement the override functions of SQLiteOpenHelper
//    3. Override the constructor

    public static final String DBNAME = "userdb";
    public static final String TBNAME = "users";
    public static final int DBVERSION = 1;

    public String place_username = "username";
    public String place_password = "password";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +TBNAME+ "(username VARCHAR, password VARCHAR" + ");" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TBNAME);
        onCreate(db);
    }

    public long addUser(String uname, String psw){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", uname);
        cv.put("password", psw);
        long res = db.insert(TBNAME,null,cv);
        db.close();
        return res;
    }

    public void deleteUser(String uname){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " +TBNAME+ " WHERE username='" +uname+ "';");
        db.close();
    }

    public void updateUser(String uname,String newpsw){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " +TBNAME+ " SET password='" +newpsw+ "' WHERE username='" +uname+ "';");
        db.close();
    }

//    public String display(){
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cr = db.rawQuery("SELECT * FROM " +TBNAME+ ";", null);
//        String res = "";
//        if (cr.moveToFirst()){
//            while (cr.moveToNext()){
//                res = cr.getString(0) +":" + cr.getString(1);
//            }
//        }
//        return res;
//    }

    public int checkUser(String uname,String psw){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.query(TBNAME,new String[]{place_username,place_password},"username=? AND password=?",new String[]{uname,psw},null,null,null);
        if(cr.moveToFirst()){
            db.close();
            cr.close();
            return 1;
        }else{
            db.close();
            cr.close();
            return -1;
        }
    }

    public String displayUsers(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("SELECT * FROM " +TBNAME+ ";",null);
        StringBuilder data = new StringBuilder();
        if (cr.moveToFirst()){
            do {
                data.append(cr.getString(0)).append(" : ").append(cr.getString(1)).append("\n");
            }while (cr.moveToNext());
        }
        return data.toString();
    }

//    private static final String DBName = "studentdb";
//    private static final String TBName = "student";
//    private static final int DBVERSION = 1;
//
//    String place_name = "name";
//    String place_usn = "usn";
//
//    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
////        Create table in this function
//        String createSQL = "CREATE TABLE "+TBName+"("+place_name+" VARCHAR(20), "+place_usn+" INTEGER PRIMARY KEY);";
//        db.execSQL(createSQL);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS "+TBName);
//        onCreate(db);
//    }
//
//    public void insertStudent(Student student){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put(place_name,student.getName());
//        cv.put(place_usn,student.getUsn());
//        db.insert(TBName,null,cv);
//        db.close();
//    }
//
//    public void deleteStudent(Student student){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TBName,place_usn + "=?",new String[]{String.valueOf(student.getUsn())});
//        db.close();
//    }
//
//    public int updateStudent(Student student){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put(place_name, student.getName());
//        cv.put(place_usn,student.getUsn());
//        return db.update(TBName,cv,place_usn+"=?", new String[]{String.valueOf(student.getUsn())});
//    }

}
