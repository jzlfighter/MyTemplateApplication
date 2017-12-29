package com.example.administrator.mytemplateapplication.module.test.presenter;

import android.support.annotation.VisibleForTesting;

import com.example.administrator.mytemplateapplication.base.BaseObserver;
import com.example.administrator.mytemplateapplication.base.LifeCyclePresenter;
import com.example.administrator.mytemplateapplication.dagger2.ActivityScoped;
import com.example.administrator.mytemplateapplication.module.test.contract.TestContract;
import com.example.administrator.mytemplateapplication.module.test.model.HomeRec;
import com.example.administrator.mytemplateapplication.network.RetrofitClient;
import com.example.administrator.mytemplateapplication.network.api.TestService;
import com.example.administrator.mytemplateapplication.network.entity.HttpResult;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/12/22.
 */
@ActivityScoped
public class TestPresenter extends LifeCyclePresenter<TestContract.View> implements TestContract.Presenter {


    @Inject
    TestPresenter() {
    }

    @Override
    public void loadData() {
        RetrofitClient.create(TestService.class)
                .getHomeIndex()
                .compose(new ApplySchedulers<>())
                .subscribe(new BaseObserver<HttpResult<HomeRec>>() {
                    @Override
                    public void onSuccess(HttpResult<HomeRec> homeRecHttpResult) {
                        mView.showText(homeRecHttpResult.getData().getTitle());
                    }
                });
    }

}
