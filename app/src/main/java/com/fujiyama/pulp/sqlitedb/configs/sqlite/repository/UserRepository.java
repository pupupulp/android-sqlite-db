package com.fujiyama.pulp.sqlitedb.configs.sqlite.repository;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

import com.fujiyama.pulp.sqlitedb.configs.sqlite.MCASRoomDatabase;
import com.fujiyama.pulp.sqlitedb.configs.sqlite.dao.UserDAO;
import com.fujiyama.pulp.sqlitedb.configs.sqlite.schema.tables.User;

import java.util.List;

public class UserRepository {

    private UserDAO mUserDAO;
    private MutableLiveData<List<User>> mAllUsers;

    UserRepository(Application application) {
        MCASRoomDatabase database = MCASRoomDatabase.getInstance(application);
        mUserDAO = database.userDAO();
        mAllUsers = mUserDAO.getAllUsers();
    }

    MutableLiveData<List<User>> getAllUsers() {
        return mAllUsers;
    }

    public void insert(User user) {
        new insertAsyncTask(mUserDAO).execute(user);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDAO mAsyncTaskDAO;

        insertAsyncTask(UserDAO dao) {
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final User... users) {
            mAsyncTaskDAO.insert(users[0]);
            return null;
        }
    }
}
