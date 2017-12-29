package com.example.administrator.mytemplateapplication.base;


import com.example.administrator.mytemplateapplication.network.NetworkUtil;
import com.example.administrator.mytemplateapplication.network.exception.ApiException;
import com.example.administrator.mytemplateapplication.tools.log.Logger;
import com.example.administrator.mytemplateapplication.tools.utils.ToastUtil;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import com.example.administrator.mytemplateapplication.network.ExceptionHandling;

/**
 * Created by jzl on 2017/12/21.
 * 观察者基类，用来对网络请求进行统一的处理
 */

public abstract class BaseObserver<T> implements Observer<T> {

    protected Disposable disposable;
//    private SwipeToLoadLayout swipeLayout;
//    private ObservableInt placeholderState;

    public abstract void onSuccess(T t);

    @Override
    public void onSubscribe(Disposable d) {
        disposable = d;
    }

    @Override
    public void onNext(T t) {
//        if (swipeLayout != null && swipeLayout.isRefreshing()) {
//            swipeLayout.setRefreshing(false);
//        }
//        if (swipeLayout != null && swipeLayout.isLoadingMore()) {
//            swipeLayout.setLoadingMore(false);
//        }
//        if (response.isSuccessful() && response.body() != null) {
//            if (null != placeholderState) {
//                placeholderState.set(PlaceholderLayout.SUCCESS);
//            }
//            onSuccess(call, response);
//        } else {
//            onFailed(call, response);
//        }
        NetworkUtil.dismissCutscenes();
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
//                if (null != placeholderState) {
//            placeholderState.set(PlaceholderLayout.ERROR);
//        }
//        if (swipeLayout != null && swipeLayout.isRefreshing()) {
//            swipeLayout.setRefreshing(false);
//        }
//        if (swipeLayout != null && swipeLayout.isLoadingMore()) {
//            swipeLayout.setLoadingMore(false);
//        }
        if (e instanceof ApiException) {
            ExceptionHandling.operate(((ApiException) e).getResult());
        }

        if (e instanceof IOException) {
            ToastUtil.toast("网络连接超时");
        }
        e.printStackTrace();
    }

    @Override
    public void onComplete() {

    }
}
