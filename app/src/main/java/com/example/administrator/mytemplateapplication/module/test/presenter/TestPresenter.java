package com.example.administrator.mytemplateapplication.module.test.presenter;

import com.example.administrator.mytemplateapplication.base.BaseObserver;
import com.example.administrator.mytemplateapplication.base.HttpUrlPresenter;
import com.example.administrator.mytemplateapplication.module.test.contract.TestContract;
import com.example.administrator.mytemplateapplication.module.test.model.HomeRec;
import com.example.administrator.mytemplateapplication.network.RetrofitClient;
import com.example.administrator.mytemplateapplication.network.api.TestService;
import com.example.administrator.mytemplateapplication.network.entity.HttpResult;

/**
 * Created by Administrator on 2017/12/22.
 */

public class TestPresenter extends HttpUrlPresenter implements TestContract.Presenter {
    private TestContract.View testView;

    public TestPresenter(TestContract.View view) {
        testView = view;
        testView.setPresenter(this);
    }
public void test(){
        System.out.print("dafsdfasdfasdf");
}
    @Override
    public void loadData() {
        loadData(RetrofitClient.getService(TestService.class).getHomeIndex(), new BaseObserver<HttpResult<HomeRec>>() {
            @Override
            public void onSuccess(HttpResult<HomeRec> oauthTokenMoHttpResult) {
                testView.showText(oauthTokenMoHttpResult.getData().getTitle());
            }
        });
    }
}
