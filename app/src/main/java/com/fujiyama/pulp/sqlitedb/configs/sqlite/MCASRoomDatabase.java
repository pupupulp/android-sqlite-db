package com.fujiyama.pulp.sqlitedb.configs.sqlite;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.fujiyama.pulp.sqlitedb.configs.sqlite.dao.UserDAO;
import com.fujiyama.pulp.sqlitedb.configs.sqlite.schema.DatabaseInfo;
import com.fujiyama.pulp.sqlitedb.configs.sqlite.schema.tables.User;

import java.math.BigInteger;

@Database(entities = {
        User.class
}, version = DatabaseInfo.DATABASE_VERSION)
public abstract class MCASRoomDatabase extends RoomDatabase {

    public abstract UserDAO userDAO();

    private static volatile MCASRoomDatabase instance;

    public static MCASRoomDatabase getInstance(final Context context) {
        if(instance == null) {
            synchronized (MCASRoomDatabase.class) {
                if(instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            MCASRoomDatabase.class,
                            DatabaseInfo.DATABASE_NAME)
                            .addCallback(populateDatabase)
                            .build();
                }
            }
        }

        return instance;
    }

    private static RoomDatabase.Callback populateDatabase = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(instance).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final UserDAO mDao;

        PopulateDbAsync(MCASRoomDatabase database) {
            mDao = database.userDAO();
        }

        @Override
        protected Void doInBackground(final Void... voids) {
            mDao.deleteAll();

            User user = new User(5, "John Doe");
            mDao.insert(user);

            return null;
        }
    }
}
