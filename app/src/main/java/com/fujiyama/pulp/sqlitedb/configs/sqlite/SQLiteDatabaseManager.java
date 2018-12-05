package com.fujiyama.pulp.sqlitedb.configs.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDatabaseManager {
    private static String TAG = SQLiteDatabaseManager.class.getSimpleName();

    private int mConnectionCounter;

    private static SQLiteDatabaseManager instance;
    private static SQLiteOpenHelper mSQLiteDatabaseHelper;
    private static SQLiteDatabase mSQLiteDatabase;

    public static synchronized void initialize(SQLiteOpenHelper helper) {
        if(instance == null) {
            instance = new SQLiteDatabaseManager();
            mSQLiteDatabaseHelper = helper;
        }
    }

    public static synchronized SQLiteDatabaseManager getInstance() {
        if(instance == null) {
            throw new IllegalStateException(TAG + " is not initialized.");
        }

        return instance;
    }

    public synchronized SQLiteDatabase openDatabase() {
        mConnectionCounter++;

        if(mConnectionCounter == 1) {
            mSQLiteDatabase = mSQLiteDatabaseHelper.getWritableDatabase();
        }

        return mSQLiteDatabase;
    }

    public synchronized void closeDatabase() {
        mConnectionCounter--;

        if(mConnectionCounter == 0) {
            mSQLiteDatabase.close();
        }
    }
}
