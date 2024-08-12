package com.mycurrencyconverter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "CURRENCYCONVERTER";
    private static final int DB_VERSION = 2;
    public static final String TABLE_NAME = "conversion_history";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FROM_CURRENCY = "from_currency";
    public static final String COLUMN_TO_CURRENCY = "to_currency";
    public static final String COLUMN_AMOUNT = "amount";
    public static final String COLUMN_RESULT = "result";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    public DatabaseHandler(Context context){
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable = "CREATE TABLE USERS(id INTEGER PRIMARY KEY, Name TEXT, Email TEXT, Phone TEXT, Password TEXT)";
        db.execSQL(createUserTable);

        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FROM_CURRENCY + " TEXT, " +
                COLUMN_TO_CURRENCY + " TEXT, " +
                COLUMN_AMOUNT + " REAL, " +
                COLUMN_RESULT + " REAL, " +
                COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP)";
        db.execSQL(createTableQuery);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS USERS");
        onCreate(db);
    }


    public boolean registerUser(String name, String email, String phone, String pass) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Email", email);
        contentValues.put("Phone", phone);
        contentValues.put("Password", pass);
        Long l = sqLiteDatabase.insert("USERS", null, contentValues);
        sqLiteDatabase.close();
        if (l > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean loginUser(String email, String pass) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM USERS WHERE Email='" + email + "' AND Password='" + pass + "'";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            // User is LoggedIn
            return true;

        } else {
            // User is  Not LoggedIn
            return false;
        }
    }
    public void deleteHistoryItem(int historyItemId) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete(DatabaseHandler.TABLE_NAME, DatabaseHandler.COLUMN_ID + " = ?",
                    new String[]{String.valueOf(historyItemId)});
        } finally {
            db.close();
        }
    }


}


