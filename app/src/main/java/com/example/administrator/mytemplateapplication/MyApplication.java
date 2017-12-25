package com.example.administrator.mytemplateapplication;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;


import com.example.administrator.mytemplateapplication.tools.SharedInfo;
import com.example.administrator.mytemplateapplication.tools.utils.ActivityManage;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import okhttp3.OkHttpClient;

/**
 * Author: TinhoXu
 * E-mail: xth@erongdu.com
 * Date: 2016/8/16 10:51
 * <p>
 * Description:
 */
public class MyApplication extends Application {
    /**
     * 当前活动的Activity数量
     */
    private int count = 0;
    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ActivityManage.push(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {
                ActivityManage.setTopActivity(activity);
            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
                count--;
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                ActivityManage.remove(activity);
            }
        });
        SharedInfo.init(Constant.SP_NAME);
    }

}
