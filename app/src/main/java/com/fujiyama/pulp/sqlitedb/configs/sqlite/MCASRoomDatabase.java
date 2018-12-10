package com.fujiyama.pulp.sqlitedb.configs.sqlite;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.fujiyama.pulp.sqlitedb.configs.sqlite.dao.UserDAO;
import com.fujiyama.pulp.sqlitedb.configs.sqlite.schema.DatabaseInfo;
import com.fujiyama.pulp.sqlitedb.configs.sqlite.schema.tables.User;

@Database(entities = {
        User.class
}, version = DatabaseInfo.DATABASE_VERSION)
public abstract class MCASRoomDatabase extends RoomDatabase {

    public abstract UserDAO userDAO();
}
