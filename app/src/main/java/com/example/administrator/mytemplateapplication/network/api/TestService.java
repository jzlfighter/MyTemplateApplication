package com.example.administrator.mytemplateapplication.network.api;

import com.example.administrator.mytemplateapplication.module.test.model.HomeRec;
import com.example.administrator.mytemplateapplication.module.user.model.entity.LoginSub;
import com.example.administrator.mytemplateapplication.module.user.model.entity.User;
import com.example.administrator.mytemplateapplication.network.entity.HttpResult;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/12/21.
 */

public interface TestService {
    /**
     * 获取首页详情
     */
    @POST("borrow/findIndex.htm")
    Observable<HttpResult<HomeRec>> getHomeIndex();
    /** 登录 */
    @POST("user/login.htm")
    Flowable<HttpResult<User>> doLogin(@Body LoginSub sub);
}
