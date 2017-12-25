package com.example.administrator.mytemplateapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.mytemplateapplication.base.BaseActivity;
import com.example.administrator.mytemplateapplication.base.BaseObserver;
import com.example.administrator.mytemplateapplication.module.OauthTokenMo;
import com.example.administrator.mytemplateapplication.module.test.views.TestActivity;
import com.example.administrator.mytemplateapplication.network.RetrofitClient;
import com.example.administrator.mytemplateapplication.network.api.TestService;
import com.example.administrator.mytemplateapplication.network.entity.HttpResult;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TestActivity.class));
            }
        });
    }
}
