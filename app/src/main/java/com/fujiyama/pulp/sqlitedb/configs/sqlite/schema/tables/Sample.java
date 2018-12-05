package com.fujiyama.pulp.sqlitedb.configs.sqlite.schema.tables;

public class Sample {
    private static final String TABLE_NAME = Sample.class.getSimpleName().toUpperCase();
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_EMAIL = "EMAIL";
    private static final String COLUMN_DATE_CREATED = "DATE_CREATED";

    private static final String CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_EMAIL + " TEXT," +
                COLUMN_DATE_CREATED + " BIGINT" +
            ")";

    public static String getCreateQuery() {
        return CREATE_QUERY;
    }
}
