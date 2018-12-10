package com.fujiyama.pulp.sqlitedb.view.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;

import com.fujiyama.pulp.sqlitedb.configs.sqlite.repository.UserRepository;
import com.fujiyama.pulp.sqlitedb.configs.sqlite.schema.tables.User;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository mRepository;
    private MutableLiveData<List<User>> mAllUsers;

    public UserViewModel(Application application) {
        super(application);

        mRepository = new UserRepository(application);
        mAllUsers = mRepository.getAllUsers();
    }

    public MutableLiveData<List<User>> getAllUsers() {
        return mAllUsers;
    }

    public void insert(User user) {
        mRepository.insert(user);
    }
}
