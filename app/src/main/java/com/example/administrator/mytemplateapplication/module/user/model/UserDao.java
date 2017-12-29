package com.example.administrator.mytemplateapplication.module.user.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.administrator.mytemplateapplication.module.user.model.entity.User;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/12/28.
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM users LIMIT 1")
    Flowable<List<User>> getUser();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUesr(User user);

    @Query("DELETE FROM users")
    void deleteAllUsers();
}
