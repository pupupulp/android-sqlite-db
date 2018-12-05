package com.fujiyama.pulp.sqlitedb;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fujiyama.pulp.sqlitedb.configs.sqlite.SQLiteDatabaseHelper;
import com.fujiyama.pulp.sqlitedb.configs.sqlite.SQLiteDatabaseManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabaseManager.initialize(new SQLiteDatabaseHelper(getApplicationContext()));
        SQLiteDatabaseManager manager = SQLiteDatabaseManager.getInstance();

        SQLiteDatabase database = manager.openDatabase();
        // database.* for processes needed to execute
        manager.closeDatabase();
    }
}
