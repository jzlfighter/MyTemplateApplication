package com.example.administrator.mytemplateapplication.module.user.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.administrator.mytemplateapplication.module.user.model.entity.User;

/**
 * Created by Administrator on 2017/12/28.
 */

@Database(entities = User.class, version = 1)
public abstract class UsersDatabase extends RoomDatabase {

    public abstract UserDao userDao();

}
