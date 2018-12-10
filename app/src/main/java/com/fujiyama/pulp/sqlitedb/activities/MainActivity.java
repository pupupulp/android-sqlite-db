package com.fujiyama.pulp.sqlitedb.activities;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fujiyama.pulp.sqlitedb.R;
import com.fujiyama.pulp.sqlitedb.configs.sqlite.DatabaseHelper;
import com.fujiyama.pulp.sqlitedb.configs.sqlite.DatabaseManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseManager.initialize(new DatabaseHelper(getApplicationContext()));
        DatabaseManager manager = DatabaseManager.getInstance();

        SQLiteDatabase database = manager.openDatabase();
        // database.* for processes needed to execute
        manager.closeDatabase();
    }
}
