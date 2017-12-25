package com.example.administrator.mytemplateapplication.base;

import com.example.administrator.mytemplateapplication.network.NetworkUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/22.
 */

public class HttpUrlPresenter implements BasePresenter {
    private List<Disposable> disposables = new ArrayList<>();

    protected <T> void loadData(Observable<T> observable, BaseObserver<T> observer) {
        NetworkUtil.showCutscenes();
        disposables.add(observer.disposable);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void onDestory() {
        for (Disposable disposable : disposables)
            if (disposable != null)
                disposable.dispose();
    }
}
