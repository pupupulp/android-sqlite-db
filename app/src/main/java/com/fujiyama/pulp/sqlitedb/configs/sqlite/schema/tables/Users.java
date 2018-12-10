package com.fujiyama.pulp.sqlitedb.configs.sqlite.schema.tables;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.math.BigInteger;

@Entity(tableName = "USERS")
public class Users {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    @NonNull
    private BigInteger mId;

    @ColumnInfo(name = "FULL_NAME")
    private String mFullName;

    public Users(BigInteger mId, String mFullName) {
        this.mId = mId;
        this.mFullName = mFullName;
    }

    public BigInteger getmId() {
        return mId;
    }

    public String getmFullName() {
        return mFullName;
    }
}
