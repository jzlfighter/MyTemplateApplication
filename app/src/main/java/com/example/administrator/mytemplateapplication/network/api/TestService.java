package com.example.administrator.mytemplateapplication.network.api;

import com.example.administrator.mytemplateapplication.module.OauthTokenMo;
import com.example.administrator.mytemplateapplication.module.test.model.HomeRec;
import com.example.administrator.mytemplateapplication.network.entity.HttpResult;

import io.reactivex.Observable;
import retrofit2.Call;
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
}
