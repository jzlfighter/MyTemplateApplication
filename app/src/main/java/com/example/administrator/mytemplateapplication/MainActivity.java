package com.example.administrator.mytemplateapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.mytemplateapplication.base.BaseActivity;
import com.example.administrator.mytemplateapplication.module.test.contract.TestContract;
import com.example.administrator.mytemplateapplication.module.user.views.LoginActivity;

public class MainActivity extends BaseActivity<TestContract.Presenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.Button).setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), LoginActivity.class)));
        int newVis= View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        getWindow().getDecorView().setSystemUiVisibility(newVis);
    }
}
