package com.example.administrator.mytemplateapplication.module.user.presenter;

import com.example.administrator.mytemplateapplication.dagger2.ActivityScoped;
import com.example.administrator.mytemplateapplication.module.user.contract.LoginContract;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Administrator on 2017/12/28.
 */
@Module
public abstract class LoginModule {
    @ActivityScoped
    @Binds
    abstract LoginContract.Presenter presenter(LoginPresenter presenter);
}
