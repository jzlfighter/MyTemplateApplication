package com.example.administrator.mytemplateapplication;

import android.content.Intent;
import android.os.Bundle;

import com.example.administrator.mytemplateapplication.base.BaseActivity;
import com.example.administrator.mytemplateapplication.module.test.contract.TestContract;
import com.example.administrator.mytemplateapplication.module.user.views.LoginActivity;

public class MainActivity extends BaseActivity<TestContract.Presenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.Button).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), LoginActivity.class)));
    }
}
