package com.example.tp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseController extends SQLiteOpenHelper {
    static String name = "database";
    static int  version = 1;
    String createTableUser = "CREATE TABLE IF NOT EXISTS 'user' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'user' TEXT, 'password' TEXT, 'email' TEXT)";

    public DatabaseController(@Nullable Context context) {
        super(context, name, null, version);
        getWritableDatabase().execSQL(createTableUser);
    }

    public void insertUser(ContentValues contentValues){
        getWritableDatabase().insert("user", "",contentValues);
    }

    public boolean isLoginValid(String user, String password){
        String sql = "SELECT count(*) from user WHERE user = '" + user + "' and password = '" + password + "'";
        SQLiteStatement statement = getReadableDatabase().compileStatement(sql);
        String l = statement.simpleQueryForString();
        statement.close();
        Log.d("Error",l);
        if(l.equals("1")){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
