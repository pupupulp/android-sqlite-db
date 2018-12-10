package com.fujiyama.pulp.sqlitedb.configs.sqlite.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.fujiyama.pulp.sqlitedb.configs.sqlite.schema.tables.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Query("DELETE FROM USERS")
    void deleteAll();

    @Query("SELECT * FROM USERS")
    List<User> getAllUsers();
}
