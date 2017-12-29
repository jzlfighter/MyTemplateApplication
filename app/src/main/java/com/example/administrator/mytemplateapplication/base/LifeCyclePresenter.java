package com.example.administrator.mytemplateapplication.base;

import com.example.administrator.mytemplateapplication.network.NetworkUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/22.
 * 对presenter的生命周期进行统一处理
 */

public abstract class LifeCyclePresenter<V extends BaseView> implements BasePresenter<V> {
    private List<Disposable> disposables = new ArrayList<>();
    protected V mView;

    @Override
    public void dropView() {
        mView = null;
        for (Disposable disposable : disposables)
            if (disposable != null)
                disposable.dispose();
    }

    @Override
    public void takeView(V view) {
        mView = view;
    }

    public static class ApplySchedulers<T> implements ObservableTransformer<T, T> {
        @Override
        public ObservableSource<T> apply(Observable<T> upstream) {
            return upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    }
}
