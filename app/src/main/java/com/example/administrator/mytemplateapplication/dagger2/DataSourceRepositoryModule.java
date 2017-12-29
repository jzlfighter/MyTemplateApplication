package com.example.administrator.mytemplateapplication.dagger2;


import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.administrator.mytemplateapplication.module.user.model.UserDao;
import com.example.administrator.mytemplateapplication.module.user.model.UsersDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * This is used by Dagger to inject the required arguments for all DataSourceRepositoryModule.
 */
@Module
abstract class DataSourceRepositoryModule {

    @Singleton
    @Provides
    static UsersDatabase provideUsersDatabase(Application context) {
        return Room.databaseBuilder(context.getApplicationContext(), UsersDatabase.class, "User.db").build();
    }

    @Singleton
    @Provides
    static UserDao provideUserDao(UsersDatabase db) {
        return db.userDao();
    }

}
