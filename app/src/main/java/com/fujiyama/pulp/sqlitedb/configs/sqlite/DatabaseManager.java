package com.fujiyama.pulp.sqlitedb.configs.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager {
    private static final String TAG = DatabaseManager.class.getSimpleName();

    private int mConnectionCounter;

    private static DatabaseManager instance;
    private static SQLiteOpenHelper mSQLiteDatabaseHelper;
    private static SQLiteDatabase mSQLiteDatabase;

    public static synchronized void initialize(SQLiteOpenHelper helper) {
        if(instance == null) {
            instance = new DatabaseManager();
            mSQLiteDatabaseHelper = helper;
        }
    }

    public static synchronized DatabaseManager getInstance() {
        if(instance == null) {
            throw new IllegalStateException(TAG + " is not initialized.");
        }

        return instance;
    }

    public synchronized SQLiteDatabase openDatabase() {
        addOpenedConnections();

        if(mConnectionCounter == 1) {
            mSQLiteDatabase = mSQLiteDatabaseHelper.getWritableDatabase();
        }

        return mSQLiteDatabase;
    }

    public synchronized void closeDatabase() {
        reduceOpenedConnections();

        if(mConnectionCounter == 0) {
            mSQLiteDatabase.close();
        }
    }

    public synchronized boolean isDatabaseOpen() {
        return (mSQLiteDatabase != null && mSQLiteDatabase.isOpen());
    }

    private synchronized void addOpenedConnections() {
        mConnectionCounter++;
    }

    private synchronized void reduceOpenedConnections() {
        mConnectionCounter--;
    }
}
