package com.example.administrator.mytemplateapplication.network.api;

import com.example.administrator.mytemplateapplication.module.test.model.HomeRec;
import com.example.administrator.mytemplateapplication.module.test.model.SplashRec;
import com.example.administrator.mytemplateapplication.module.user.model.entity.LoginSub;
import com.example.administrator.mytemplateapplication.module.user.model.entity.User;
import com.example.administrator.mytemplateapplication.network.entity.HttpResult;

import java.util.ArrayList;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

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
    /**
     *
     */
    @GET
    Call<HttpResult<ArrayList<SplashRec>>> getPositionContent(@Url String url, @Query("appflag") String appflag, @Query("positionid") String positionid);
}
