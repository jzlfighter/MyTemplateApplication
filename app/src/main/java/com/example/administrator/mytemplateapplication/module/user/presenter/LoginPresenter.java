package com.example.administrator.mytemplateapplication.module.user.presenter;

import android.support.annotation.VisibleForTesting;

import com.example.administrator.mytemplateapplication.base.BaseSubscriber;
import com.example.administrator.mytemplateapplication.base.LifeCyclePresenter;
import com.example.administrator.mytemplateapplication.dagger2.ActivityScoped;
import com.example.administrator.mytemplateapplication.module.user.contract.LoginContract;
import com.example.administrator.mytemplateapplication.module.user.model.entity.LoginSub;
import com.example.administrator.mytemplateapplication.module.user.model.entity.User;
import com.example.administrator.mytemplateapplication.module.user.model.local.UserLocalDataSource;
import com.example.administrator.mytemplateapplication.module.user.model.remote.UserRemoteDataSource;
import com.example.administrator.mytemplateapplication.network.NetworkUtil;
import com.example.administrator.mytemplateapplication.network.entity.HttpResult;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/28.
 */

@ActivityScoped
public class LoginPresenter extends LifeCyclePresenter<LoginContract.View> implements LoginContract.Presenter {

    private UserLocalDataSource local;
    private UserRemoteDataSource remote;


    @Inject
    public LoginPresenter(UserLocalDataSource local, UserRemoteDataSource remote) {
        this.local = local;
        this.remote = remote;
    }

    @Override
    public void login(LoginSub loginSub) {
        NetworkUtil.showCutscenes();
        local.getUser()
                .flatMap(users -> {
                    if (users.size() == 0) {
                        return remote.getUser(loginSub)
                                .map(HttpResult::getData)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread());
                    } else {
                        return Flowable.just(users.get(0));
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new BaseSubscriber<User>() {
            @Override
            public void onSuccess(User user) {
                local.insertOrUpdateUser(user);
                mView.showUserData(user);
            }
        });
    }

    @Override
    public void deleteDatabase() {
        local.deleteAllUser();
    }

    @VisibleForTesting
    public Flowable<List<User>> loadLocalDate(){
        return local.getUser();
    }
}
