package com.example.administrator.mytemplateapplication.module.test.views;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.mytemplateapplication.R;
import com.example.administrator.mytemplateapplication.base.BaseActivity;
import com.example.administrator.mytemplateapplication.module.test.contract.TestContract;
import com.example.administrator.mytemplateapplication.module.test.presenter.TestPresenter;

public class TestActivity extends BaseActivity<TestContract.Presenter> implements TestContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        new TestPresenter(this);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.loadData();
            }
        });
    }

    @Override
    public void showText(String text) {
        ((TextView) (findViewById(R.id.textView))).setText(text);
    }

    @Override
    public void setPresenter(TestContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
