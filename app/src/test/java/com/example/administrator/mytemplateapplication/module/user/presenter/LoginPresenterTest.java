package com.example.administrator.mytemplateapplication.module.user.presenter;

import com.example.administrator.mytemplateapplication.base.LifeCyclePresenter;
import com.example.administrator.mytemplateapplication.module.user.contract.LoginContract;
import com.example.administrator.mytemplateapplication.module.user.model.entity.User;
import com.example.administrator.mytemplateapplication.module.user.model.local.UserLocalDataSource;
import com.example.administrator.mytemplateapplication.module.user.model.remote.UserRemoteDataSource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Administrator on 2017/12/29.
 */
public class LoginPresenterTest {
    @Mock
    private UserLocalDataSource local;
    @Mock
    private UserRemoteDataSource remote;
    @Mock
    private LoginContract.View view;
    @Captor
    private ArgumentCaptor<User> captor;

    @Inject
    private LoginPresenter presenter;

    @Before
    public void setupLoginPresenter() {
        MockitoAnnotations.initMocks(this);
        presenter = new LoginPresenter(local, remote);
        presenter.takeView(view);

    }

    @Test
    public void loadLocalDatabase() {
        ArgumentCaptor<User> showTasksArgumentCaptor = ArgumentCaptor.forClass(User.class);
//        verify(local,times(3)).getUser();
        presenter.loadLocalDate().subscribe(new Consumer<List<User>>() {
            @Override
            public void accept(List<User> users) throws Exception {
                assertEquals(users.get(0).getUsername(),"");
            }
        });
    }
}