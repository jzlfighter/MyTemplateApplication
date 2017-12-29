package com.example.administrator.mytemplateapplication.module.user.model.remote;

import com.example.administrator.mytemplateapplication.module.user.model.entity.LoginSub;
import com.example.administrator.mytemplateapplication.module.user.model.entity.User;
import com.example.administrator.mytemplateapplication.network.RetrofitClient;
import com.example.administrator.mytemplateapplication.network.api.TestService;
import com.example.administrator.mytemplateapplication.network.entity.HttpResult;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/28.
 */
@Singleton
public class UserRemoteDataSource {

    @Inject
    public UserRemoteDataSource() {
    }

    public Flowable<HttpResult<User>> getUser(LoginSub loginSub) {
        return RetrofitClient.create(TestService.class).doLogin(loginSub)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
