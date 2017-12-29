package com.example.administrator.mytemplateapplication.module.test.presenter;

import com.example.administrator.mytemplateapplication.dagger2.ActivityScoped;
import com.example.administrator.mytemplateapplication.module.test.contract.TestContract;

import dagger.Binds;
import dagger.Module;

/**
 * This is a Dagger module. We use this to pass in the View dependency to the
 * {@link com.example.administrator.mytemplateapplication.module.test.presenter.TestPresenter}.
 */
@Module
public abstract class TestModule {

    @ActivityScoped
    @Binds
    abstract TestContract.Presenter presenter(TestPresenter presenter);

}
