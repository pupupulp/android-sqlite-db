package com.fujiyama.pulp.sqlitedb.configs.sqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import com.fujiyama.pulp.sqlitedb.configs.sqlite.schema.DatabaseInfo;
import com.fujiyama.pulp.sqlitedb.configs.sqlite.schema.tables.Sample;

public class SQLiteDatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = SQLiteDatabaseHelper.class.getSimpleName();

    public SQLiteDatabaseHelper(@Nullable Context context) {
        super(context, DatabaseInfo.getDatabaseName(), null, DatabaseInfo.getDatabaseVersion());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(Sample.getCreateQuery());
        } catch(SQLException e) {
            Log.d(TAG, " Error creating database " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


