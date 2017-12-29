package com.example.administrator.mytemplateapplication.module.test.contract;

import com.example.administrator.mytemplateapplication.base.BasePresenter;
import com.example.administrator.mytemplateapplication.base.BaseView;

/**
 * Created by Administrator on 2017/12/22.
 */

public interface TestContract {
    interface View extends BaseView<Presenter>{
        void showText(String text);
    }

    interface Presenter extends BasePresenter<View>{
        void loadData();
    }
}
