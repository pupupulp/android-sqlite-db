package com.fujiyama.pulp.sqlitedb.configs.sqlite.schema.tables;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "USERS")
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    @NonNull
    private int mId;

    @ColumnInfo(name = "FULL_NAME")
    private String mFullName;

    public User(int mId, String mFullName) {
        this.mId = mId;
        this.mFullName = mFullName;
    }

    public int getmId() {
        return mId;
    }

    public String getmFullName() {
        return mFullName;
    }
}
