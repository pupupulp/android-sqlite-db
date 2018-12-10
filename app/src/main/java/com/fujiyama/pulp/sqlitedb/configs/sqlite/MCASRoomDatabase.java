package com.fujiyama.pulp.sqlitedb.configs.sqlite;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.fujiyama.pulp.sqlitedb.configs.sqlite.dao.UserDAO;
import com.fujiyama.pulp.sqlitedb.configs.sqlite.schema.DatabaseInfo;
import com.fujiyama.pulp.sqlitedb.configs.sqlite.schema.tables.User;

@Database(entities = {
        User.class
}, version = DatabaseInfo.DATABASE_VERSION)
public abstract class MCASRoomDatabase extends RoomDatabase {

    public abstract UserDAO userDAO();

    private static volatile MCASRoomDatabase instance;

    static MCASRoomDatabase getInstance(final Context context) {
        if(instance == null) {
            synchronized (MCASRoomDatabase.class) {
                if(instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            MCASRoomDatabase.class,
                            DatabaseInfo.DATABASE_NAME).build();
                }
            }
        }

        return instance;
    }
}
