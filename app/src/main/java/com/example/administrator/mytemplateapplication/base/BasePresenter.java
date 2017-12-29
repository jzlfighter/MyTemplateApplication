package com.example.administrator.mytemplateapplication.base;

/**
 * Created by Administrator on 2017/12/22.
 */

public interface BasePresenter<V extends BaseView> {
    void takeView(V view);

    void dropView();
}
