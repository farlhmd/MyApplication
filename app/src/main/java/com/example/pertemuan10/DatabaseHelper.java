package com.example.pertemuan10;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.pertemuan10.BooksProvider.DATABASE_CREATE;
import static com.example.pertemuan10.BooksProvider.DATABASE_NAME;
import static com.example.pertemuan10.BooksProvider.DATABASE_VERSION;

public class DatabaseHelper extends SQLiteOpenHelper {
    DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("Content provider db", "Upgrading database from version " +
                oldVersion + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS titles");
        onCreate(db);
    }
}
