package com.example.administrator.mytemplateapplication.module.test.presenter;

import com.example.administrator.mytemplateapplication.module.test.contract.TestContract;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by Administrator on 2017/12/22.
 */
public class TestPresenterTest {

    @Mock
    private TestContract.View mView;
    private TestPresenter testPresenter;

    @Before
    public void setupTasksPresenter() {
    }

    @Test
    public void loadData() throws Exception {
    }

}