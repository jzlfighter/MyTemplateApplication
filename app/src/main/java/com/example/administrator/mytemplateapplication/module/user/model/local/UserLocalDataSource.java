package com.example.administrator.mytemplateapplication.module.user.model.local;

import android.support.annotation.NonNull;

import com.example.administrator.mytemplateapplication.module.user.model.UserDao;
import com.example.administrator.mytemplateapplication.module.user.model.entity.User;
import com.example.administrator.mytemplateapplication.tools.log.Logger;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/28.
 */

@Singleton
public class UserLocalDataSource {

    private final UserDao mUserDao;

    @Inject
    public UserLocalDataSource(@NonNull UserDao userDao) {
        mUserDao = userDao;
    }

    public Flowable<List<User>> getUser() {
        return mUserDao.getUser();
    }

    public void insertOrUpdateUser(User user) {
        Observable.just(user)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .subscribe(mUserDao::insertUesr);
    }

    public void deleteAllUser() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                mUserDao.deleteAllUsers();
            }
        }.start();
    }
}
