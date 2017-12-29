package com.example.administrator.mytemplateapplication.base;

import com.example.administrator.mytemplateapplication.network.ExceptionHandling;
import com.example.administrator.mytemplateapplication.network.NetworkUtil;
import com.example.administrator.mytemplateapplication.network.exception.ApiException;
import com.example.administrator.mytemplateapplication.tools.utils.ToastUtil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.IOException;

import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/12/28.
 */

public abstract class BaseSubscriber<T> implements Subscriber<T> {
    protected Subscription subscription;
//    private SwipeToLoadLayout swipeLayout;
//    private ObservableInt placeholderState;

    public abstract void onSuccess(T t);

    @Override
    public void onSubscribe(Subscription d) {
        subscription = d;
        d.request(1);
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
        subscription.cancel();
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
        subscription.cancel();
    }
}
