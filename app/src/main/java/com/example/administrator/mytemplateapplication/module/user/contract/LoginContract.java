package com.example.administrator.mytemplateapplication.module.user.contract;

import com.example.administrator.mytemplateapplication.base.BasePresenter;
import com.example.administrator.mytemplateapplication.base.BaseView;
import com.example.administrator.mytemplateapplication.module.user.model.entity.LoginSub;
import com.example.administrator.mytemplateapplication.module.user.model.entity.User;

/**
 * Created by Administrator on 2017/12/28.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void showUserData(User user);
    }

    interface Presenter extends BasePresenter<View> {
        void login(LoginSub loginSub);

        void deleteDatabase();
    }

}
