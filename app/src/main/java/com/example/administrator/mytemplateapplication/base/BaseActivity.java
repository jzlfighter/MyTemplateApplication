package com.example.administrator.mytemplateapplication.base;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Administrator on 2017/12/21.
 */

public abstract class BaseActivity<T extends BasePresenter> extends DaggerAppCompatActivity implements BaseView<T> {
    @Inject
    protected T mPresenter;

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.takeView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
    }
}
