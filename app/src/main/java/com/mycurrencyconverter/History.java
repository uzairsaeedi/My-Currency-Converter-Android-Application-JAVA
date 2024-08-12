package com.mycurrencyconverter;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class History extends AppCompatActivity {
    private DatabaseHandler databaseHandler;
    private SQLiteDatabase db;
    private Cursor cursor;
    private RecyclerView recyclerView;
    private HistoryAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        recyclerView = findViewById(R.id.rv_history);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseHandler = new DatabaseHandler(this);
        db = databaseHandler.getReadableDatabase();
        cursor = db.query(databaseHandler.TABLE_NAME, null, null, null, null, null, null);
        adapter = new HistoryAdapter(this, cursor, databaseHandler);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}

