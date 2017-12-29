package com.example.administrator.mytemplateapplication.network;


import com.example.administrator.mytemplateapplication.network.converter.RDConverterFactory;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.administrator.mytemplateapplication.Constant.URL_TEST;

public class RetrofitClientForTest {
    // 网络请求超时时间值(s)
    private static final int DEFAULT_TIMEOUT = 30;
    // retrofit实例
    private Retrofit retrofit;

    /**
     * 私有化构造方法
     */
    public RetrofitClientForTest(HttpUrl url) {
        // 创建一个OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // 设置网络请求超时时间
        builder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        // 添加签名参数
//        builder.addInterceptor(new BasicParamsInject().getInterceptor());
        // 打印参数
        builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        // 失败后尝试重新请求
        builder.retryOnConnectionFailure(true);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * @return 指定service实例
     */
    public <T> T create(Class<T> clazz) {
        return retrofit.create(clazz);
    }
}
