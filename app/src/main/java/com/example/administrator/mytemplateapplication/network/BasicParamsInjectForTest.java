package com.example.administrator.mytemplateapplication.network;


import com.example.administrator.mytemplateapplication.Constant;
import com.example.administrator.mytemplateapplication.network.interceptor.BasicParamsInterceptor;
import com.example.administrator.mytemplateapplication.network.interceptor.IBasicDynamic;
import com.example.administrator.mytemplateapplication.tools.statistics.DeviceInfoUtils;
import com.example.administrator.mytemplateapplication.tools.utils.ContextHolder;

import java.util.Map;
import java.util.TreeMap;

import okhttp3.Interceptor;

public class BasicParamsInjectForTest {
    private BasicParamsInterceptor interceptor;

    public BasicParamsInjectForTest() {
        // 设置静态参数
        interceptor = new BasicParamsInterceptor.Builder()
                //.addBodyParam(Constant.APP_KEY, BaseParams.APP_KEY)
                .addBodyParam(Constant.MOBILE_TYPE, "2")
                .addBodyParam(Constant.VERSION_NUMBER, "")
                .build();
        // 设置动态参数
        interceptor.setIBasicDynamic(new IBasicDynamic() {
            @Override
            public String signParams(String postBodyString) {
                //post提交动态添加参数
                return UrlUtils.getInstance().dynamicParams(postBodyString);
            }

            @Override
            public Map signParams(Map map) {
                //get提交动态添加参数
                TreeMap temp = new TreeMap(map);
                return UrlUtils.getInstance().dynamicParams(temp);
            }

            @Override
            public Map signHeadParams(Map headMap) {
                return UrlUtils.getInstance().signParams(headMap);
            }
        });
    }

    public Interceptor getInterceptor() {
        return interceptor;
    }
}
