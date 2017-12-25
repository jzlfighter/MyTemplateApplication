package com.example.administrator.mytemplateapplication.base;

import android.support.v7.app.AppCompatActivity;

import com.example.administrator.mytemplateapplication.tools.log.Logger;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/21.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView<T> {
    protected T mPresenter;

    @Override
    public void setPresenter(T presenter) {
        mPresenter = presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestory();
    }
}
