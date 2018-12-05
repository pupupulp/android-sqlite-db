package com.fujiyama.pulp.sqlitedb.configs.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class SQLiteDatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseSchema schema;

    public SQLiteDatabaseHelper(@Nullable Context context) {
        super(context, schema.getDatabaseName(), null, schema.getDatabaseVersion());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


