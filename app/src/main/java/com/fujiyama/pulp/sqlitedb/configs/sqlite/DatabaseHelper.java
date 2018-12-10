package com.fujiyama.pulp.sqlitedb.configs.sqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import com.fujiyama.pulp.sqlitedb.configs.sqlite.schema.DatabaseInfo;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = DatabaseHelper.class.getSimpleName();

    public DatabaseHelper(@Nullable Context context) {
        super(context, DatabaseInfo.getDatabaseName(), null, DatabaseInfo.getDatabaseVersion());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            // do queries
        } catch(SQLException e) {
            Log.d(TAG, " Error creating database " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            // drop tables
            onCreate(db);
        }
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if(!db.isReadOnly()) {
            db.execSQL("PRAGMA foreign_keys=ON");
        }
    }
}


