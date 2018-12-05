package com.fujiyama.pulp.sqlitedb.configs.sqlite;

public class DatabaseSchema {
    private static final String DATABASE_NAME = "sample.db";
    private static final int DATABASE_VERSION = 1;

    public static String getDatabaseName() {
        return DATABASE_NAME;
    }

    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }
}
