package com.example.administrator.mytemplateapplication.module.test.views;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mytemplateapplication.R;
import com.example.administrator.mytemplateapplication.base.BaseActivity;
import com.example.administrator.mytemplateapplication.module.test.contract.TestContract;

public class TestActivity extends BaseActivity<TestContract.Presenter> implements TestContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Button button=  findViewById(R.id.btButton);
        button.setOnClickListener(view -> mPresenter.loadData());
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((Animatable)(((ImageView)findViewById(R.id.imageView)).getDrawable())).start();
    }

    @Override
    public void showText(String text) {
        ((TextView) (findViewById(R.id.textView))).setText(text);
    }

}
