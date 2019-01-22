package com.example.sirius.codeforcesmobile;

import android.app.Application;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Create db

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (rank TEXT,handle TEXT,firstname TEXT, lastname TEXT,rating TEXT,maxrating TEXT,maxrank TEXT,contribution TEXT,friendOfCount TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS blogs (title TEXT,author TEXT,date TEXT,content TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS contests (id TEXT,name TEXT,author TEXT,startTimeSeconds TEXT,duration TEXT,url TEXT)");

        //db.execSQL("INSERT INTO users VALUES ('Tom Smith', 23);");
        db.close();

    }
}
